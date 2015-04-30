#-*- coding: utf-8 -*-
from django.shortcuts import render
from django.http import HttpResponse
from django.views.decorators.csrf import csrf_exempt,csrf_protect,requires_csrf_token
# Create your views here.

from models import Order

import xml.dom.minidom


def verify_sign( sign ):
    pass



def getTagText(root, tag):
    node = root.getElementsByTagName(tag)[0]
    rc = ""
    for node in node.childNodes:
        if node.nodeType in ( node.TEXT_NODE, node.CDATA_SECTION_NODE):
            rc = rc + node.data
    return rc


def deal_xml(xml_text):
    '''
    解析xml返回一个dict
    :return:
    >>> <notify><trade_status>TRADE_FINISHED</trade_status></notify>
    {"trade_status":"TRADE_FINISHED"}
    '''
    ret_dict = {}
    doc = xml.dom.minidom.parseString(xml_text)

    root = doc.documentElement

    for child in root.childNodes:
        ret_dict[child.nodeName] = getTagText(root,child.nodeName)

    return ret_dict


def parse_raw_data(raw_data):
    raw_data =  raw_data[1:len(raw_data)-1]
    print raw_data
    #remove { and }
    data = raw_data.split(",")

    ret_dict = {}
    for item in data:
        name = item[: item.find("=")+1]
        #remove =
        if name[-1] == "=":
            name = name[:len(name)-1]

        #remove space
        if name[0] == ' ':
            name = name[1:]

        value = item[item.find("=")+1:]
        ret_dict[name] = value

    return ret_dict


@csrf_exempt
def index(request):
    '''

    解析支付宝的回调函数, 需要输出 success

    '''
    if request.method == 'POST':
        raw_data =  request.body
        order_dict = parse_raw_data(raw_data)
        print order_dict['notify_data']
        notify_dict = deal_xml(order_dict['notify_data'])
        # 从 notify_data 中提取两项方便查询
        order_dict['trade_status'] = notify_dict['trade_status']
        order_dict['out_trade_no'] = notify_dict['out_trade_no']
        print order_dict

        order = Order(**order_dict)
        order.save()
        return HttpResponse("success") #必须输出success, 不然支付宝会一直通知
    else:
        return HttpResponse("Not a post method")

@csrf_exempt
def cloud_pos_pay_confirm(request):
    if request.method == 'POST':
        params = dict(request.POST)
        print request.POST
        params['service'] = 'alipay.wap.trade.create.direct'
        params['sign'] = '123456'
        params['sec_id'] = '000001'
        params['v'] = '1'
        del params['total_fee']
        params['notify_data'] = '123'
        #print "before" + params['out_trade_no'][0]
        a = params['out_trade_no'] = params['out_trade_no'][0]
        b = params['trade_status'] = params['trade_status'][0]
        a = a.replace("[u'","")
        a = a.replace("']","")
        b = b.replace("[u'","")
        b = b.replace("']","")
        params['out_trade_no'] = a
        params['trade_status'] = b
        order = Order(**params)
        order.save()
        return HttpResponse("success")
    else: 
        return HttpResponse("Not a post method")


def query_confirm( num_str ):
    '''
    传入 num_str 是待查询的订单号码
    返回  ret_str 是查询后确认的订单号码， 用;分割
    '''
    out_trade_no_list = num_str.split(';')
    ret = []
    for num in out_trade_no_list:
        obj = Order.objects.get(out_trade_no = num)
        if obj.trade_status == "TRADE_SUCCESS":
            ret.append(num)
    return ";".join(ret)



@csrf_exempt
def confirm_status(request):
    if request.method == "POST":
        out_trade_no = request.POST['out_trade_no']
        confirmed = query_confirm(out_trade_no)
        return HttpResponse(confirmed)
    elif request.method == "GET":
        return HttpResponse("Get method")


