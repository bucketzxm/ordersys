#-*- coding: utf-8 -*-
__author__ = 'simon'



class AlipayConfig(object):

    service = 'alipay.wap.trade.create.direct'
    format = 'xml'
    v = '2.0'

    # 合作者id, 以2088开头16位纯数字
    partner = "2088011763438960"
    # 商户的私钥
    key = "eoc7f61tlmj8a0wiz4v7yeyv6l38bgvd"

    # 商户私钥
    # 如果签名方式设置0001 ， 请设置该参数
    private_key = ""

    # 支付宝公钥
    # 如果签名方式设置0001 ， 请设置该参数
    ali_public_key = ""

    log_path = ""

    input_charset = "utf-8" # gbk

    #sign method = sec_id
    sign_type = "MD5"

    #------* req_data -----*
    subject = "威悦餐厅"
     # 服务器异步通知页面
    notify_url = ""
    # 页面跳转同步通知页面
    call_back_url = "http://121.40.164.39:8000/"
     # 操作中断返回地址
    merchant_url = ""

    # 卖家支付宝账户
    seller_email = "emma-xu319@163.com"

