# -*- coding: utf-8 -*-
from django.shortcuts import render_to_response, HttpResponse, redirect, RequestContext
from django.template.loader import get_template
from django.contrib.sessions import serializers
from django.core import serializers
from models import Cart, Food, Category, LineItem, Order
from django.views.decorators.csrf import csrf_exempt
import json

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
        # generate food name with

        # amount_dict = dict([(key.food, {key.quantity: 'beChoiced'}) for key in item_list])
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


def order(request):
    if request.method == "POST":
        cart_session = request.session.get('cart', None)

        if not cart_session:
            # custom did not order any thing
            # TODO hint it
            return HttpResponse("")
        else:
            cart = pickle_load(cart_session)
            # Order.create(cart.items, total_price)


def add_to_cart(request):
    if request.method == "POST":
        food_id = request.POST['foodId']
        print "add food : %s" % (str(food_id) )
        food = Food.objects.get(id=food_id)
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

