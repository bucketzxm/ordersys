from django.contrib import admin

# Register your models here.

from .models import Order, Category, Food, Menuitem, Special
admin.site.register(Order)
admin.site.register(Category)
admin.site.register(Food)
admin.site.register(Menuitem)
admin.site.register(Special)
