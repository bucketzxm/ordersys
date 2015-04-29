from django.conf.urls import url
from . import views


urlpatterns = [
    url(r'^$',views.index,name="index"),
    url(r'^confirm',views.confirm_status,name="confirm_status"),
    url(r'^cloudPayConfirm',views.cloud_pos_pay_confirm),
]

