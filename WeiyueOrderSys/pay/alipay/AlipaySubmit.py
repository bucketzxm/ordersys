# -*- coding: utf-8 -*-
__author__ = 'simon'

import urllib


from AlipayConfig import AlipayConfig
from AlipayCore import AlipayCore
import xml.etree.ElementTree as ET
from md5 import MD5


class AlipaySubmit(object):
    @staticmethod
    def build_request_my_sign(str_para):
        '''
        生成签名结果
        :param str_para:要签名的数组
        :return:签名结果字符串
        '''
        pre_str = AlipayCore.create_link_string(str_para)

        my_sign = ""

        if AlipayConfig.sign_type == 'MD5':
            my_sign = MD5.sign(pre_str, AlipayConfig.key, AlipayConfig.input_charset)
        if AlipayConfig.sign_type == "0001":
            my_sign = ""

            # print(my_sign.decode('utf-8'))
            # my_sign = my_sign.encode('utf-8').decode('utf-8')
        return str(my_sign)


    '''
        <form id="alipaysubmit" name="alipaysubmit" action="https://mapi.alipay.com/gateway.do?_input_charset=utf-8" method="get">
        <input type="hidden" name="seller_email" value="emma-xu319@163.com"/>
        <input type="hidden" name="orderId" value="192"/>
        <input type="hidden" name="_input_charset" value="utf-8"/>
        <input type="hidden" name="subject" value="威悦餐饮"/>
        <input type="hidden" name="sign" value="9253dda915e5f55f719e38bd05931900"/>
        <input type="hidden" name="royalty_type" value="10"/>
        <input type="hidden" name="notify_url" value="http://192.168.146.141:8088/notify_url.jsp"/>
        <input type="hidden" name="body" value="威悦账单"/>
        <input type="hidden" name="royalty_parameters" value="469380879@qq.com^0.00^ "/>
        <input type="hidden" name="payment_type" value="1"/>
        <input type="hidden" name="out_trade_no" value="390"/>
        <input type="hidden" name="partner" value="2088011763438960"/>
        <input type="hidden" name="service" value="create_direct_pay_by_user"/>
        <input type="hidden" name="total_fee" value="0.01"/>
        <input type="hidden" name="return_url" value="http://192.168.146.141:8088/return_url"/>
        <input type="hidden" name="sign_type" value="MD5"/>
        <input type="submit" value="确认" style="display:none;">
        </form><script>document.forms['alipaysubmit'].submit();</script>
    '''

    @staticmethod
    def build_request_para(str_para_temp):
        '''
        生成要请求给支付宝的参数数组
        :param spara_temp: 请求前的参数数组
        :return: 要请求的参数数组
        '''
        # 除去数组中的空值和签名参数
        para_dict_without_sign = AlipayCore.para_filter(str_para_temp)
        # 生成签名结果
        my_sign = AlipaySubmit.build_request_my_sign(para_dict_without_sign)
        # 签名结果与签名方式加入请求提交参数组中
        para_dict = para_dict_without_sign
        para_dict['sign'] =  my_sign

        if not para_dict.get('service') == 'alipay.wap.trade.create.direct' and \
                not para_dict.get('service') == 'alipay.wap.auth.authAndExecute':
            para_dict['sign_type'] = AlipayConfig.sign_type

        return para_dict


    @staticmethod
    def build_request(alipay_gateway_new, str_para_temp):
        '''
        建立请求，以表单HTML形式构造（默认）
        :param alipay_gateway_new:支付宝网关地址
        :param str_para_temp:请求参数数组

        :return:提交表单HTML文本
        '''

        str_para_temp = AlipaySubmit.build_request_para(str_para_temp)
        # 请求
        params = urllib.urlencode(str_para_temp)
        res = urllib.urlopen(alipay_gateway_new,params).read()

        res_html = urllib.unquote(res).decode('utf-8')
        #res_html = res.decode('utf-8')

        request_token = AlipaySubmit.get_request_token(res_html)

        return request_token


    @staticmethod
    def checkout(alipay_gateway_new, str_para_temp):

        sbHtml = ""
        sbHtml = sbHtml + "<form id=\"alipaysubmit\" name=\"alipaysubmit\" action=\"" + alipay_gateway_new + "_input_charset" + AlipayConfig.input_charset \
                 + "\" method=\"" + "get" \
                 + "\">"

        lens = len(str_para_temp)
        for num, key in enumerate(str_para_temp):
            sbHtml = sbHtml + "<input type=\"hidden\" name=\"" + str(key) + "\" value=\"" + str(
                str_para_temp[key]) + "\"/>"

        sbHtml = sbHtml + "<input type=\"submit\" value=\"" + "confirm" + "\" style=\"display:none;\"></form>"
        sbHtml = sbHtml + "<script>document.forms['alipaysubmit'].submit();</script>"

        return sbHtml


    @staticmethod
    def get_request_token(text):
        '''
        解析远程模拟提交后返回的信息，获得token
        :param text: 要解析的字符串
        :return:解析结果
        '''
        request_token = ""

        str_split_text = text.split("&")

        para_text = {}

        for item in str_split_text:
            e_pos = item.find('=')
            key = item[0:e_pos]
            value = item[e_pos + 1:]

            para_text[key] = value


        res_data = para_text.get('res_data')
        print("res_data==>" , res_data)
        if res_data:
            # token从res_data中解析出来（也就是说res_data中已经包含token的内容）
            res_data = res_data.replace('+',' ')
            root = ET.fromstring(res_data)
            for child in root:
                if child.tag == "request_token":
                    request_token = child.text
                    break
        return request_token