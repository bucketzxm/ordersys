#-*- coding: utf-8 -*-
from django.shortcuts import render_to_response,HttpResponse, redirect
from django.template.loader import get_template
from django.contrib.sessions import serializers

from models import Cart, Food, Category

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
        cgId = request.GET['cgId']
        category = Category.objects.filter(id = cgId)[0]

        food_list = []
        if category:
            food_list = Food.objects.all().filter(category= category )
            title = category.name

        return render_to_response("dishes.html",locals())
    redirect('/')

def view_cart(request):
    title = "购物车"
    cart = request.session.get('cart',None)
    if not cart:
        # 购物车空
        cart = Cart()

    request.session['cart_total_price'] = cart.total_price
    request.session['cart_total_items'] = cart.items
    return render_to_response("view_cart.html",locals())



def add_to_cart(request):
    if request.method == "POST":
        # deal with food request
        pass
    else:
        pass
