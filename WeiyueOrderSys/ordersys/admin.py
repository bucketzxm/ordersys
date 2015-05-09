#!-*- coding: utf-8 -*-
from django.contrib import admin

# Register your models here.

from models import Food, Category, Order

admin.site.register(Food)
admin.site.register(Category)
admin.site.register(Order)