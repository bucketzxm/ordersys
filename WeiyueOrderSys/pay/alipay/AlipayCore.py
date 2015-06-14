# -*- coding: utf-8 -*-
__author__ = 'simon'



class AlipayCore(object):
    @staticmethod
    def para_filter(str_dict):
        '''
        除去数组中的空值和签名参数
        :param str_dict:签名参数组
        :return:去掉空值与签名参数后的新签名参数组
        '''

        result_dict = {}
        if not str_dict:
            return result_dict

        for key, value in str_dict.items():
            if not key or key == "sign" or key == "sign_type":
                continue
            result_dict[key] = value

        return result_dict


    @staticmethod
    def create_link_string(str_para):
        '''
        把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
        :param str_para:需要排序并参与字符拼接的参数组
        :return:拼接后字符串
        '''
        ret = ""
        para_dict = sorted( str_para.items(), key = lambda d: d[0] )
        lens = len(str_para)
        num = 0
        for key, value in para_dict:
            if num == lens - 1:
                ret = ret + str(key) + str('=') + str(value)
            else:
                ret = ret + str(key) + str('=') + str(value) + str('&')
            num += 1
        return ret