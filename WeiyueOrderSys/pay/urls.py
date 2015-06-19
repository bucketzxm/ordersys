__author__ = 'simon'


from django.conf.urls import url
import views

urlpatterns = [
    url(r'^choosePayMethod', views.choose_pay_method),
    url(r'^alipaywap', views.alipay),
    url(r'^callback', views.call_back),
]
