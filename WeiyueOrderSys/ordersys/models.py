#!-*- coding:utf-8 -*-
from django.db import models

import datetime, random

# Create your models here.
class Category(models.Model):
    id = models.AutoField(primary_key=True, verbose_name="目录编号")  # 唯一编号
    name = models.CharField(max_length=128, verbose_name="目录名称")  # 调料名字
    image_url = models.CharField(max_length=1024, verbose_name="图片路径")
    description = models.TextField(blank=True, verbose_name="目录描述")

    class Meta:
        verbose_name = "目录"
        verbose_name_plural = "目录"

    def __str__(self):
        return u"目录 %s: %s" % (str(self.id), self.name)

    def __unicode__(self):
        return u"目录 %s: %s" % (str(self.id), self.name)


class Sauce(models.Model):
    id = models.AutoField(primary_key=True, verbose_name="调料编号")  # 唯一编号
    name = models.CharField(max_length=128, verbose_name="调料名字")  # 调料名字
    price = models.FloatField(default=0, verbose_name="单品价格")  # 单品价格
    image_url = models.CharField(max_length=1024, verbose_name="图片路径")
    description = models.TextField(blank=True, verbose_name="调料描述")

    class Meta:
        verbose_name = "调料"
        verbose_name_plural = "调料"

    def __str__(self):
        return u"调料 %s : %s" % ( str(self.id), self.name)

    def __unicode__(self):
        return u"调料 %s : %s" % ( str(self.id), self.name)


class Food(models.Model):
    id = models.AutoField(primary_key=True, verbose_name="食物编号")  # 食物唯一编号
    name = models.CharField(max_length=128, verbose_name="食物名称")

    category = models.ForeignKey(Category, verbose_name="类别")  # 食物类别
    image_url = models.CharField(max_length=1024, verbose_name="图片路径")
    price = models.FloatField(default=0, verbose_name="食物价格")
    description = models.TextField(blank=True, verbose_name="食物描述")
    special = models.BooleanField(default=False, verbose_name="是否特价")

    sauces = models.ManyToManyField(Sauce, blank=True, verbose_name="调料")  #

    def get_price(self):
        return self.price

    def get_id(self):
        return self.id

    class Meta:
        verbose_name = "食物"
        verbose_name_plural = "食物"

    def __str__(self):
        return u"食物 %s: %s" % (str(self.id), self.name)

    def __unicode__(self):
        return u"食物 %s: %s" % (str(self.id), self.name)



class OrderNum(models.Model):
    num = models.IntegerField(verbose_name="餐厅排队号码")
    is_used = models.BooleanField(default=False)


    @staticmethod
    def create():
        for i in range(1,10000):
            n = OrderNum(num=i, is_used=False)
            n.save()

    def __str__(self):
        return u"餐厅内点餐号码: %s" % str(self.num)
    def __unicode__(self):
        return u"餐厅内点餐号码: %s" % str(self.num)

class LineItem(models.Model):
    id = models.AutoField(primary_key=True)
    food = models.ForeignKey(Food, default="", verbose_name=u"食品")
    unite_price = models.FloatField(default=0, verbose_name=u"食物价格")
    quantity = models.IntegerField(default=0, verbose_name=u"食品数量")
    sauces = models.ForeignKey(Sauce, null=True, blank=True, verbose_name=u"调料")
    printed = models.BooleanField(default=False, verbose_name="是否出单")
    # order = models.ForeignKey(Order,null=True, blank=True, verbose_name=u'订单')
    class Meta:
        verbose_name = u"单品"
        verbose_name_plural = u"单品"

    def __str__(self):
        return u'单品%s: %s' % (self.id, self.food.name)
    def __unicode__(self):
        return u'单品%s: %s' % (self.id, self.food.name)


class Order(models.Model):
    WAIT_TO_PAY = "WP"
    SUCCESS_TO_PAY = "SP"
    FAIL_TO_PAY = "FP"
    ORDER_STATE = (
        (WAIT_TO_PAY, u"等待支付"),
        (SUCCESS_TO_PAY, u"支付成功"),
        (FAIL_TO_PAY, u'支付失败')
    )

    id = models.AutoField(primary_key=True)
    time = models.DateTimeField(verbose_name="下单时间")  # 订单时间
    out_trade_num = models.CharField(max_length=128, verbose_name="订单号")  # 订单号唯一
    order_num = models.IntegerField(verbose_name="餐厅排队号码")  # 餐厅内点餐号码， 可重复利用
    custom_id = models.CharField(max_length=256, default="0", verbose_name="顾客会员号")  # 会员顾客
    state = models.CharField(max_length=50, choices=ORDER_STATE, verbose_name="订单状态", default=WAIT_TO_PAY)
    money = models.FloatField(default=0, verbose_name="订单金额")  # 订单原始金额
    bonus = models.BigIntegerField(default=0, verbose_name="会员积分")  # 积分
    discount = models.FloatField(default=0, verbose_name="折扣")  # 折扣
    description = models.TextField(blank=True, verbose_name="订单附加描述")  # 对订单的附加描述
    # foods = models.ManyToManyField(Food, verbose_name="食物")
    line_item = models.ManyToManyField(LineItem, blank=True, verbose_name=u"单品")

    class Meta:
        verbose_name = "订单"
        verbose_name_plural = "订单"

    @staticmethod
    def create(items, total_price, order_num=None):
        cls = Order()
        cls.time = datetime.datetime.now()
        if isinstance(order_num, type(None)):
            cls.order_num = cls.gen_order_num()
        else:
            cls.order_num = order_num
        cls.out_trade_num = cls.gen_out_trade_num()
        cls.state = cls.WAIT_TO_PAY
        cls.money = total_price
        cls.save()
        for li in items:
            cls.line_item.add(li)

        cls.save()
        return cls



    def gen_out_trade_num(self):
        otn = str( datetime.datetime.now() )
        otn = otn.replace('-','')
        otn = otn.replace(' ','')
        otn = otn.replace(':','')
        otn = otn.replace('.','')
        otn = otn + str( random.randint(1,100000000))
        return otn

    def gen_order_num(self):
        order_num = OrderNum.objects.all().filter(is_used=False)[0]
        order_num.is_used = True
        order_num.save()
        return order_num.num

    def destroy(self):
        order_num = OrderNum.objects.get(id= self.order_num)
        order_num.is_used = False

    def __str__(self):
        return u"订单 %s" % (self.out_trade_num)

    def __unicode__(self):
        return u"订单 %s" % (self.out_trade_num)




class Cart(object):
    def __init__(self, *args, **kwargs):
        self.items = []
        self.total_price = 0

    def add_product(self, line_item, num=1):
        self.total_price += line_item.unite_price*num

        # 如果购物车中有重复的商品，则+1
        for item in self.items:
            if line_item.food.id == item.food.id:
                item.quantity += 1
                return
        # 全新的一种商品
        self.items.append(line_item)




class Coupon(models.Model):
    id = models.AutoField(primary_key=True)
    time = models.DateTimeField(verbose_name="优惠时间")
    info = models.TextField(verbose_name="优惠信息")




