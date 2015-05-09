#!-*- coding:utf-8 -*-
from django.db import models

# Create your models here.

class Order(models.Model):
    id = models.AutoField(primary_key=True)
    out_trade_num = models.CharField(max_length=128, verbose_name="订单号")
    order_state = models.CharField(max_length=50,verbose_name="订单状态")
    
