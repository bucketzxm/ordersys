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
from threading import Condition

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
condition = Condition()


def query_ticket():
    '''
	result 只有一个结果是 success
	'''

    #tickets = Order.objects.all().filter(order_state = 'wait')
    tickets = Order.objects.all()
    trade_no_list = []
    for ticket in tickets:
        trade_no_list.append( ticket.out_trade_no)

    ret = ""
	#返回所有交易成功的商家order_num, 用分号隔开

    trade_no_list = [x for x in trade_no_list if x!=None]

    print trade_no_list
    if trade_no_list:
        ret = ";".join(trade_no_list)
    else:
        ret = ""

    print "query_ticket ret==>" + ret
    return ret


class Producer(Thread):
    def run(self):
        while True:
            condition.acquire()
            global query_order
            query_order = query_ticket()

            if len(query_order) > 0:
                condition.notify()
                condition.wait()
            time.sleep(1)

query_url = "http://139.159.34.121:9347/confirm_status"
#query_url = "http://localhost:8000/confirm_status"
#delete_url = "http://192.168.146.141:8088/deleteOrderByOutTradeNum"
delete_url = "http://localhost:8088/deleteOrderByOutTradeNum"
class Consumer(Thread):
    def run(self):
        while True:
            condition.acquire()
            # python 发送  post 请求
            params = {
                "out_trade_no": query_order,
            }
            print "query_order ==>" + query_order
            try:
                r = requests.post(query_url, params)

			#resp 中包含了另一台服务器确认成功的订单num,用;分割

                if r.status_code == requests.codes.ok:
                    ord = r.text
                    ord_li = ord.split(';')
                    print "returned order list ==> " + str(ord_li)
                    for to_send in ord_li:
                        print "to_send ==> " + to_send
                        try:
                            r = requests.get(delete_url+"?"+"out_trade_no="+to_send)
                        except:
                            print "net work error"
                            pass
                        print "url ==> " + delete_url+'?'+"out_trade_no="+to_send
                else:
                    print "request failed ==> "+ str( r.status_code ) + " request.res => "+r.text
            except:
                print "net work error"
                pass
            time.sleep(1)
            condition.notify()
            condition.wait()


if __name__ == "__main__":
	producer = Producer()
	consumer = Consumer()
	producer.start()
	consumer.start()

