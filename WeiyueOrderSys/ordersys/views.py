# -*- coding: utf-8 -*-
from django.shortcuts import render_to_response, HttpResponse, redirect, RequestContext
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


def view_cart(request):
    title = "购物车"
    cart = request.session.get('cart', None)
    if not cart:
        # 购物车空
        cart = Cart()
        request.session['cart'] = cart


    return render_to_response("view_cart.html")

def add_to_cart(request):
    if request.method == "POST":
        food_id = request.POST['foodId']
        food = Food.objects.get(id=food_id)
        cart = request.session.get('cart', None)

        if not cart:
            cart = Cart()
            request.session['cart'] = cart
        cart.add_product(food)
        return view_cart(request)
