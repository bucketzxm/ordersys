# -*- coding: utf8 -*-
from django.db import models

# Create your models here.


class Order(models.Model):
    service = models.TextField()
    v = models.TextField()
    sec_id = models.TextField()
    sign = models.TextField()
    notify_data = models.TextField()
    out_trade_no = models.TextField()
    trade_status = models.TextField()


    def __str__(self):
        return self.out_trade_no
