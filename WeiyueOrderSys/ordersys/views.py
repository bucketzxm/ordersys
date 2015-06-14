# -*- coding: utf-8 -*-
from django.shortcuts import render_to_response, HttpResponse, redirect, RequestContext
from django.template.loader import get_template
from django.contrib.sessions import serializers
from django.core import serializers
from models import Cart, Food, Category, LineItem, Order
from django.views.decorators.csrf import csrf_exempt, csrf_protect
import json

import uuid

ERROR_CODE = {
    '1000': {"status": "1000", "desc": "执行成功"},
    '1001': {"status": "1001", "desc": "缺少参数"},
    '1002': {"status": "1002", "desc": "执行异常"}
    # '1003':{"status": "1002", "desc": "执行错误"},
}



@csrf_exempt
def get_wait_to_pay_orders(request):
    tmp = []
    for order in Order.objects.filter(state=Order.WAIT_TO_PAY):
        tmp.append(order.to_dict())
        print 'food:'
        for line_item in order.foods.all():
            print line_item
    return HttpResponse(json.dumps(tmp))


@csrf_exempt
def delete_wait_to_pay(request):
    if not request.POST.has_key('out_trade_num') or not request.POST.has_key('order_num'):
        return HttpResponse(json.dumps(ERROR_CODE['1001']))
    else:
        try:
            out_trade_num = request.POST.get('out_trade_num')
            order_num = request.POST.get('order_num')
            tmp = []
            for order in Order.objects.filter(out_trade_num=out_trade_num, order_num=order_num):
                tmp.append(order.to_dict())
            return HttpResponse(json.dumps(tmp))
        except Exception, e:
            tmp = ERROR_CODE['1002']
            tmp['desc'] += (":" + str(e))
            return HttpResponse(json.dumps(tmp))


@csrf_exempt
def confirm_wait_to_pay_to_success(request):
    print request.POST
    if not request.POST.has_key('out_trade_num') or not request.POST.has_key('order_num'):
        return HttpResponse(json.dumps(ERROR_CODE['1001']))
    else:
        try:
            out_trade_num = request.POST.get('out_trade_num')
            order_num = request.POST.get('order_num')
            for order in Order.objects.filter(out_trade_num=out_trade_num, order_num=order_num):
                order.state = order.SUCCESS_TO_PAY
                order.save()
            return HttpResponse(json.dumps(ERROR_CODE['1000']))
        except Exception, e:
            tmp = ERROR_CODE['1002']
            tmp['desc'] += (":" + str(e))
            return HttpResponse(json.dumps(tmp))






try:
    import cPickle as pickle
except:
    import pickle


# deserialize django models object
def deserialize_to_object_list(data, format):
    ret = []
    for obj in serializers.deserialize(format, data):
        ret.append(obj)
    return ret


# serialize django models object
def serialize(object_list, new_object, format):
    object_list.append(new_object)
    data = serializers.serialize(format, object_list)
    return data


def pickle_dump(new_object):
    return pickle.dumps(new_object)


def pickle_load(data):
    if isinstance(data, unicode):
        data_str = data.encode('utf-8')
    elif isinstance(data, str):
        data_str = data
    ret = pickle.loads(data_str)
    return ret


def index(request):
    title = "首页"
    special_list = Food.objects.filter(special=True)

    cart = request.session.get('cart', None)
    if cart:
        item_list = pickle_load(cart).items
    else:
        item_list = []
    amount_dict = dict( [(key, {0: "notChoiced"}) for key in special_list])

    for item in item_list:
        amount_dict[item.food] = {item.quantity: "beChoiced"}
    return render_to_response('index.html', locals())


def category(request):
    title = "目录"
    cg_list = Category.objects.all()
    return render_to_response("category.html", locals())


def dishes(request):
    if request.method == "GET":
        c = {}
        cgId = request.GET['cgId']
        category = Category.objects.filter(id=cgId)[0]

        food_list = []
        if category:
            food_list = Food.objects.all().filter(category=category)
            title = category.name

        c['cgId'] = cgId
        c['food_list'] = food_list
        c['title'] = title

        cart = request.session.get('cart', None)

        if cart:
            item_list = pickle_load(cart).items
        else:
            item_list = []


        amount_dict = dict([(key, {0: "notChoiced"}) for key in food_list])

        for item in item_list:
            amount_dict[item.food] = {item.quantity: "beChoiced"}

        print amount_dict
        c["amount"] = amount_dict
        return render_to_response("dishes.html", c)
    redirect('/')


def view_cart(request):
    title = "购物车"
    cart = request.session.get('cart', None)
    # if cart is null, pickle_load will raise error
    if cart:
        cart = pickle_load(cart)
    line_items = []
    if not cart:
        # 购物车空
        line_items = []
    else:
        line_items = cart.items

    t = get_template("view_cart.html")
    c = RequestContext(request, locals())
    return HttpResponse(t.render(c))



def make_order(request):
    if request.method == "GET":
        cart_session = request.session.get('cart', None)

        if not cart_session:
            # custom did not order any thing
            # TODO hint it
            return redirect("/myDish")
        else:
            cart = pickle_load(cart_session)
            order = Order.create(cart.items, cart.total_price)
            if order:
                request.session['cart'] = None
                return redirect("/pay/choosePayMethod/?out_trade_num="+ str(order.out_trade_num) )
            else:
                return HttpResponse("/")


@csrf_exempt
def add_to_cart(request):
    if request.method == "POST":
        food_id = request.POST['foodId']

        food = Food.objects.get(id=food_id)
        # food.name = food.name.encode('utf-8')
        # food.save()
        print "add food : %s" % (food.name )
        cart_session = request.session.get('cart', None)
        # Lineitem save in cart
        # session is empty
        if not cart_session:
            cart = Cart()
            li = LineItem()
            li.food = food
            li.unite_price = food.price
            li.quantity = 1
            li.save()
            cart.add_product(li)
        else:
            cart = pickle_load(cart_session)

            has_food = False
            for li in cart.items:
                if li.food.id == food.id:
                    li.quantity += 1
                    has_food = True
            if not has_food:
                li = LineItem()
                li.food = food
                li.unite_price = food.price
                li.quantity = 1
                li.save()
                cart.add_product(li)

        cart.total_price += food.price
        data = pickle_dump(cart)
        request.session['cart'] = data
    return HttpResponse("")

@csrf_exempt
def cut_from_cart(request):
    if request.method == "POST":
        food_id = request.POST['foodId']
        print "cut food : %s" % (str(food_id) )
        food = Food.objects.get(id=food_id)
        cart_session = request.session.get('cart', None)
        # Lineitem save in cart
        # session is empty

        cart = pickle_load(cart_session)
        for li in cart.items:
            if li.food.id == food.id:
                li.quantity -= 1
                cart.total_price -= food.price
                if li.quantity == 0:
                    cart.items.remove(li)

        data = pickle_dump(cart)
        request.session['cart'] = data

    return HttpResponse("")


def clear_cart(request):
    request.session['cart'] = None
    return redirect("/myDish")



@csrf_exempt
def get_category(request):
    categories = Category.objects.all()
    data = serializers.serialize("json", categories)
    json_list = []
    for tmp_json_obj in json.loads(data):
        tmp_json_dict = tmp_json_obj['fields']
        tmp_json_dict['id'] = tmp_json_obj['pk']
        json_list.append(tmp_json_dict)
    return HttpResponse(json.dumps(json_list))


@csrf_exempt
def get_unpay_order(request):
    orders = Order.objects.all()
    order_json_array = []
    for o in orders:
        tmp_order_json = {'id': str(o.id), 'time': o.time.strftime('%y-%b-%d %H:%M:%S'),
                          'out_trade_num': str(o.out_trade_num),
                          'order_num': str(o.order_num),
                          'custom_id': str(o.custom_id), 'state': o.state, 'money': str(o.money), 'bonus': str(o.bonus),
                          'discount': str(o.discount), 'description': o.description, 'line_item': []}
        for i in o.line_item.all():
            tmp_line_item_json = {'id': str(i.id), 'unite_price': str(i.unite_price), 'quantity': str(i.quantity),
                                  'sauces': None}

            # 处理食物
            tmp_food = i.food
            tmp_food_json = {'id': str(tmp_food.id), 'name': tmp_food.name, 'image_url': tmp_food.image_url,
                             'price': str(tmp_food.price), 'description': tmp_food.description,
                             'special': str(tmp_food.special),
                             'sauces': None}
            tmp_category = tmp_food.category
            tmp_category_json = {'id': str(tmp_category.id), 'name': tmp_category.name,
                                 'image_url': tmp_category.image_url,
                                 'description': tmp_category.description}
            tmp_food_json['category'] = tmp_category_json
            tmp_line_item_json['food'] = tmp_food_json

            # 处理配料
            tmp_sauces = i.sauces
            if tmp_sauces:
                tmp_sauces_json = {'id': str(tmp_sauces.id), 'name': tmp_sauces.name, 'price': str(tmp_sauces.price),
                                   'image_url': tmp_sauces.image_url, 'description': tmp_sauces.description}
                tmp_line_item_json['sauces'] = tmp_sauces_json
            tmp_order_json['line_item'].append(tmp_line_item_json)
        order_json_array.append(tmp_order_json)
    # print order_json_array
    return HttpResponse(json.dumps(order_json_array))
