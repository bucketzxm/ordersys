# from django.contrib import admin
# from models import *
#
# # Register your models here.
# class SauceAdmin(admin.ModelAdmin):
#     list_display = ('name', 'price')
#
#
# admin.site.register(Sauce, SauceAdmin)

#!-*- coding: utf-8 -*-
from django.contrib import admin

from models import Food, Category, Order, Sauce


class SauceAdmin(admin.ModelAdmin):
    list_display = ('name', 'price')


class FoodAdmin(admin.ModelAdmin):
    list_display = ('name', 'category', 'price')


class CategoryAdmin(admin.ModelAdmin):
    list_display = ('name', 'description')


class OrderAdmin(admin.ModelAdmin):
    list_display = ('time', 'order_num', 'state', 'money')


admin.site.register(Sauce, SauceAdmin)
admin.site.register(Food, FoodAdmin)
admin.site.register(Category, CategoryAdmin)
admin.site.register(Order, OrderAdmin)