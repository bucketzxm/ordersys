from django.contrib import admin

# Register your models here.

from .models import Order, Category, Food, Menuitem
admin.site.register(Order)
admin.site.register(Category)
admin.site.register(Food)
admin.site.register(Menuitem)
