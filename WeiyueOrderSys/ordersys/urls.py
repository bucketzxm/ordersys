__author__ = 'simon'

from django.conf.urls.static import static
from django.conf.urls import url
import views

urlpatterns = [
    url(r'^$', views.index),
    url(r'^category/', views.category),
    url(r'^myDish', views.view_cart),
    url(r'^addToCart', views.add_to_cart),
    url(r'^cutFromCart', views.cut_from_cart),
    url(r'^dish', views.dishes),
    url(r'^clearCart', views.clear_cart),
    url(r'^makeOrder', views.make_order),
    url(r'^getCategory', views.get_category),
    url(r'^getUnPayedOrder', views.get_unpay_order)
]
