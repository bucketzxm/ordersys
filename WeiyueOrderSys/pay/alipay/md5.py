# -*- coding: utf-8 -*-
__author__ = 'simon'

import hashlib

class MD5(object):

    @staticmethod
    def sign(text, key, input_charset):
        '''
        签名字符串
        :param text:需要签名的字符串
        :param key:密钥
        :param input_charset:编码格式
        :return:签名结果
        '''
        text = str(text) + str(key)
        return hashlib.md5( text ).hexdigest()


    @staticmethod
    def verify(text, sign, key, input_charset):
        '''
        验证签名字符串
        :param text:需要签名的字符串
        :param sign:签名结果
        :param key:密钥
        :param input_charset:编码格式
        :return: 是否正确
        '''
        text = text+key
        my_sign = hashlib.md5.new(text.encode('utf-8')).digest()

        if my_sign == sign:
            return True
        else:
            return False
