#!-*- coding:utf-8 -*-
from django.db import models

# Create your models here.

class Order(models.Model):
    id = models.AutoField(primary_key=True)
    time = models.DateTimeField(verbose_name="下单时间")  # 订单时间
    out_trade_num = models.CharField(max_length=128, verbose_name="订单号")  # 订单号唯一
    order_num = models.IntegerField(verbose_name="餐厅排队号码")  # 餐厅内点餐号码， 可重复利用
    custom_id = models.CharField(max_length=256, default="0", verbose_name="顾客会员号")  # 会员顾客
    state = models.CharField(max_length=50, verbose_name="订单状态")
    money = models.FloatField(default=0, verbose_name="订单金额")  # 订单原始金额

    bonus = models.BigIntegerField(default=0, verbose_name="会员积分")  # 积分
    discount = models.FloatField(default=0, verbose_name="折扣")  # 折扣

    description = models.TextField(verbose_name="订单附加描述")  # 对订单的附加描述

    foods = models.ManyToManyField(Food, verbose_name="食物")

    def __str__(self):
        return "订单: " + self.out_trade_num;

    def __unicode__(self):
        return "订单: " + self.out_trade_num;


class Food(models.Model):
    id = models.AutoField(primary_key=True, verbose_name="食物编号")  # 食物唯一编号
    name = models.CharField(max_length=128, verbose_name="食物名称")

    category = models.ForeignKey(Category, verbose_name="类别")  # 食物类别
    image_url = models.URLField(default="", verbose_name="图片路径")
    price = models.FloatField(default=0)
    description = models.TextField(verbose_name="食物描述")
    special = models.BooleanField(default=False, verbose_name="是否特价")

    sauces = models.ManyToManyField(Sauce, verbose_name="调料")  #

    def __str__(self):
        return "食物 " + self.id + " : " + self.name;

    def __unicode__(self):
        return "食物 " + self.id + " : " + self.name;


class Sauce(models.Model):
    id = models.AutoField(primary_key=True, verbose_name="调料编号")  # 唯一编号
    name = models.CharField(max_length=128, verbose_name="调料名字")  # 调料名字
    price = models.FloatField(default=0, verbose_name="单品价格")  # 单品价格
    image_url = models.URLField(default="", verbose_name="图片路径")  # 图片路径
    description = models.TextField(verbose_name="调料描述")

    def __str__(self):
        return "调料 " + self.id + " : " + self.name;

    def __unicode__(self):
        return "调料 " + self.id + " : " + self.name;


class Category(models.Model):
    id = models.AutoField(primary_key=True, verbose_name="目录编号")  # 唯一编号
    name = models.CharField(max_length=128, verbose_name="目录名称")  # 调料名字
    image_url = models.URLField(default="", verbose_name="图片路径")  # 图片路径
    description = models.TextField(verbose_name="调料描述")

    def __str__(self):
        return "目录 " + self.id + " : " + self.name;

    def __unicode__(self):
        return "目录 " + self.id + " : " + self.name;
