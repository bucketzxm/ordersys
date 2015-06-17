# -*- coding: utf-8 -*-

# Create your views here.


import hashlib
from django.shortcuts import render_to_response, HttpResponse, redirect, RequestContext

from alipay.AlipayConfig import AlipayConfig
from alipay.AlipaySubmit import AlipaySubmit
from alipay.md5 import MD5
from django.views.decorators.csrf import csrf_exempt, csrf_protect

from ordersys.models import Order, OrderNum


class Alipay(AlipaySubmit, AlipayConfig):
    # 唯一订单号
    out_trade_num = ""
    # 付款金额
    total_fee = ""
    # 支付宝网关
    ALIPAY_GATEWAY_NEW = "http://wappaygw.alipay.com/service/rest.htm?"
    # 返回格式 , 必填 不需要修改
    format = "xml"
    # 返回格式
    v = "2.0"
    # 请求号, 必填，必须保证每次都是唯一
    req_id = ""
    req_dataToken = ""


    def __init__(self, out_trade_num, total_fee):
        self.out_trade_num = out_trade_num
        self.total_fee = total_fee

        # 请求号， 每次唯一， 这里暂时用 out_trade_num
        self.req_id = out_trade_num
        self.req_dataToken = self.gen_req_data_token()


    def gen_req_data_token(self):
        res = "<direct_trade_create_req><notify_url>" + str(self.notify_url) + "</notify_url><call_back_url>" + str(self.call_back_url) + "</call_back_url><seller_account_name>" + str(self.seller_email) + "</seller_account_name><out_trade_no>" + str(self.out_trade_num) + "</out_trade_no><subject>" + str(self.subject) + "</subject><total_fee>" + str(self.total_fee) + "</total_fee><merchant_url>" + str(self.merchant_url) + "</merchant_url></direct_trade_create_req>"

        return res


    def gen_para_temp_token(self):
        sPara = {}

        sPara['service'] = self.service
        sPara['partner'] = AlipayConfig.partner
        sPara['_input_charset'] = AlipayConfig.input_charset
        sPara['sec_id'] = AlipayConfig.sign_type
        sPara['format'] = self.format
        sPara['v'] = self.v
        sPara['req_id'] = self.req_id
        sPara['req_data'] = self.req_dataToken

        return sPara


@csrf_exempt
def alipay(request):
    out_trade_num = request.GET['out_trade_num']

    order = Order.objects.get(out_trade_num=out_trade_num)

    ali = Alipay(order.out_trade_num, order.money)

    sParaTempToken = ali.gen_para_temp_token()

    print("sParaTempToken ==> ", sParaTempToken)
    request_token = ali.build_request(ali.ALIPAY_GATEWAY_NEW, sParaTempToken)


    req_data = "<auth_and_execute_req><request_token>" + request_token + "</request_token></auth_and_execute_req>";

    sParaTemp = {}
    sParaTemp['service'] =  "alipay.wap.auth.authAndExecute"
    sParaTemp['format'] = 'xml'
    sParaTemp['v'] = '2.0'
    sParaTemp['partner'] = AlipayConfig.partner
    sParaTemp['sec_id'] = AlipayConfig.sign_type
    sParaTemp['req_data'] = req_data

    params = AlipaySubmit.build_request_para(sParaTemp)

    html = AlipaySubmit.checkout(ali.ALIPAY_GATEWAY_NEW, params)


    return HttpResponse(html)


@csrf_exempt
def choose_pay_method(request):
    if request.method == 'GET':
        return render_to_response("choosePayMethod.html")


def call_back(request):
    '''
    同步回调函数
    :param request:
    :return:
    '''
    if request.method == "GET":
        sign = request.GET['sign']
        result = request.GET['result']
        out_trade_num = request.GET['out_trade_num']

        # 支付宝中的流水号
        trade_num = request.GET['trade_num']

        request_token = request.GET['request_token']

        order = Order.objects.get(out_trade_num = out_trade_num)
        order.state = Order.SUCCESS_TO_PAY

        order_num = OrderNum.objects.get(order.order_num)
        order_num.is_used = False
        order_num.save()
        order.save()
        request.session['cart'] = None
        return render_to_response("call_back.html")



def notify_back(request):
    '''
    异步回调函数
    :param request:
    :return:
    '''

    pass