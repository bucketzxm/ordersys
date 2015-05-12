# -*- coding: utf-8 -*-
from django.shortcuts import render_to_response, HttpResponse, redirect, RequestContext
from django.template.loader import get_template
from django.contrib.sessions import serializers
from django.core import serializers
from models import Cart, Food, Category


try:
    import cPickle as pickle
except:
    import pickle


def index(request):
    title = "首页"

    special = Food.objects.filter(special=True)
    if not special:
        pass
    return render_to_response('index.html', locals())


def category(request):
    title = "目录"
    cg_list = Category.objects.all()
    return render_to_response("category.html", locals())


def dishes(request):
    if request.method == "GET":
        c = {}
        # c.update(csrf(request))

        cgId = request.GET['cgId']
        category = Category.objects.filter(id=cgId)[0]

        food_list = []
        if category:
            food_list = Food.objects.all().filter(category=category)
            title = category.name

        c['cgId'] = cgId
        c['food_list'] = food_list
        c['title'] = title
        return render_to_response("dishes.html", c)
    redirect('/')




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


def pickle_dump(object_list, new_object):
    object_list.append(new_object)
    return pickle.dumps(object_list)

def pickle_load(data):
    object_list = pickle.load(data)
    return object_list

def view_cart(request):
    title = "购物车"
    cart = request.session.get('cart', None)
    if not cart:
        # 购物车空
        cart = Cart()
        data = pickle_dump([], cart)
        request.session['cart'] = data
    t = get_template("view_cart.html")
    c = RequestContext(request,locals())
    return HttpResponse(t.render(c))


def add_to_cart(request):
    if request.method == "POST":
        food_id = request.POST['foodId']
        food = Food.objects.get(id=food_id)
        cart = request.session.get('cart', None)

        data = ""
        if not cart:
            # data = serialize([], Cart(), 'json')
            data = pickle_dump([], Cart())
        else:
            # origin_list = deserialize_to_object_list(cart, 'json')
            # data = serialize(origin_list, cart)
            origin_list = pickle_load(cart)
            data = pickle_dump(origin_list, cart)
        cart.add_product(data)
        return view_cart(request)
