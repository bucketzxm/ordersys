#-*- coding:utf-8 -*-


'''
 一直查询另一台回调请求的服务器，确认alipay支付是否成功
'''
import django
import urllib,urllib2
import os,sys
from threading import Thread, Lock
import time
import MySQLdb
import requests

BASE_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
sys.path.append(BASE_DIR)

os.environ["DJANGO_SETTINGS_MODULE"] = "ordersys_server.settings"
import ordersys_server.settings
from server.models import Order
import time

django.setup()
# 等待查询的订单队列
query_order = "" 
lock = Lock()


def query_ticket():
    '''

    result 只有一个结果是 success

    '''
	#tickets = Order.objects.all().filter(order_state = 'wait')
    tickets = Order.objects.all()
    trade_no_list = []
    for ticket in tickets:
        trade_no_list.append( ticket.out_trade_no)

    #返回所有交易成功的商家order_num, 用分号隔开
    return ";".join(trade_no_list)


class Producer(Thread):
    def run(self):
        while True:
            if lock.acquire():
                global query_order
                query_order = query_ticket()
                lock.release()


query_url = "http://139.159.34.121:9347/confirm_status"
delete_url = "http://192.168.146.141:8088/deleteOrderByOutTradeNum"
class Consumer(Thread):
    def run(self):
        while True:
            if lock.acquire():
                # python 发送  post 请求
                params = {
                    "out_trade_no": query_order,
                    }

                print "query_order ==>" + query_order
				
                r = requests.post(query_url, params)

                #resp 中包含了另一台服务器确认成功的订单num,用;分割
                if r.status_code == requests.codes.ok:
                    ord = r.text
                    ord_li = ord.split(';')		
                    print ord_li
				
                    for to_send in ord_li:
                        print "to_send ==> " + to_send
                        try:
                            r = requests.get(delete_url+"?"+"out_trade_no="+to_send)
                        except:
                            print "net work error"
                            pass
                        print "url ==> " + delete_url+'?'+"out_trade_no="+to_send

                time.sleep(2)
                lock.release()


if __name__ == "__main__":
    producer = Producer()
    consumer = Consumer()
    producer.start()
    consumer.start()

