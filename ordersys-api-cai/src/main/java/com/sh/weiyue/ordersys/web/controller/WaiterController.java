package com.sh.weiyue.ordersys.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sh.weiyue.ordersys.web.persistence.domain.Order;
import com.sh.weiyue.ordersys.web.persistence.domain.Orderitem;
import com.sh.weiyue.ordersys.web.persistence.repository.CartRepository;
import com.sh.weiyue.ordersys.web.persistence.repository.OrderRepository;
import com.sh.weiyue.ordersys.web.persistence.repository.OrderitemRepository;
import com.sh.weiyue.ordersys.web.persistence.repository.WaiterRepository;
@Controller
public class WaiterController {
   @Autowired
   WaiterRepository waiterRepos;
   
   @RequestMapping("waiterTest")
   public String waiterTest()
   {
	   return "waiterTest";
   }
	
	
   @RequestMapping(value="deskAlreadySentOrder", method = RequestMethod.POST)
   public @ResponseBody String deskAlreaySentOrder()
   {
	   List<Integer> deskIds = waiterRepos.getDeskAlreadySentOrder();
	   String jsonString = "[";
	   for( int i = 0; i < deskIds.size(); i++ )
	   {
		   jsonString += deskIds.get(i) + ",";
	   }
	   jsonString += "]";
	   return jsonString;//已下单的所有桌号
   }
   
   @RequestMapping(value="deskSendHumanPay", method = RequestMethod.POST)
   public @ResponseBody String deskSendHumanPay()
   {
	   List<Integer> deskIds = waiterRepos.getDeskHumanPay();
	   String jsonString = "[";
	   for( int i = 0; i < deskIds.size(); i++ )
	   {
		   jsonString += deskIds.get(i) + ",";
	   }
	   jsonString += "]";
	   return jsonString;//呼叫人工支付的桌号
   }
   
   @Autowired
   OrderRepository orderRepos;
   @RequestMapping(value="orderOfDesk", method = RequestMethod.POST)
   public @ResponseBody void orderOfDesk( @RequestParam int deskId, HttpServletResponse response ) throws IOException
   {
	   //由桌号得到订单号
	   Integer orderId = waiterRepos.getOrderIdOfDesk( deskId );
	   if( orderId == 0 )
	   {
		   System.out.println( deskId + "号桌不存在订单！");
		   return;
	   }
	   //由订单号得到所有菜
	   Order order= orderRepos.findOne( orderId );
	   List<Orderitem> orderitems = order.getOrderitems();
	   String jsonString = "[";
	   for(int i = 0; i < orderitems.size(); i++ )
	   {
		   Orderitem orderitem= orderitems.get(i);
		   jsonString += "{" + orderitem.getOrderitemId() + ","
				   + "\"" + orderitem.getFood().getFoodName() + "\","
				   + orderitem.getOrderitemAmount() + "},";
	   }
	   jsonString += "]";
	   //某桌的订单,包含订单项编号,食物名，数量.例：[{1,"玉米",1},{2,"鸡翅",3},]
   
	   response.setContentType("text/text;charset=UTF-8");
	   PrintWriter out = response.getWriter();
	   out.print( jsonString );
   }
   
   @RequestMapping(value="needConfirm", method = RequestMethod.POST)
   public @ResponseBody String needConfirm()
   {
	   List<Integer> orderIds = orderRepos.getUnconfirmOrder();
	   String jsonString = "[";
	   for( int i = 0; i < orderIds.size(); i++ )
	   {
		   jsonString += orderIds.get(i) + ",";
	   }
	   jsonString += "]";
	   return jsonString;
   }
   
   @RequestMapping(value="showOrder", method = RequestMethod.POST)
   public @ResponseBody String showOrder()
   {
	   List<Integer> orderIds = orderRepos.getAllOrder();
	   String jsonString = "[";
	   for( int i = 0; i < orderIds.size(); i++ )
	   {
		   jsonString += orderIds.get(i) + ",";
	   }
	   jsonString += "]";
	   return jsonString;
   }
  
   @Autowired
   OrderitemRepository orderitemRepos;
   @RequestMapping(value="cutOrderitem", method = RequestMethod.POST)
   public @ResponseBody void cutOrderitem( @RequestParam int orderitemId )
   {
	   Orderitem orderitem = orderitemRepos.findOne( orderitemId );
	   if( orderitem == null )
	   {
		   System.out.println( "该订单项不存在" );
		   return;
	   }
	   orderitem.setOrderitemAmount( orderitem.getOrderitemAmount() - 1 );
	   orderitem.setOrderitemPrice(orderitem.getOrderitemPrice().subtract(orderitem.getFood().getRealPrice()));
	   orderitemRepos.save(orderitem);
	   //数量减1
   }
   
   @RequestMapping(value="showOrderitem1", method = RequestMethod.POST)
   public @ResponseBody String showOrderitem1()
   {
	   List<Integer> orderItemIds = orderitemRepos.getOrderitem();
	   String jsonString = "[";
	   for( int i = 0; i < orderItemIds.size(); i++ )
	   {
		   jsonString += orderItemIds.get(i) + ",";
	   }
	   jsonString += "]";
	   return jsonString;
   }
   
   @RequestMapping(value="showOrderitem2", method = RequestMethod.POST)
   public @ResponseBody String showOrderitem2()
   {
	   List<Integer> orderItemIds = orderitemRepos.getOrderitem();
	   String jsonString = "[";
	   for( int i = 0; i < orderItemIds.size(); i++ )
	   {
		   jsonString += orderItemIds.get(i) + ",";
	   }
	   jsonString += "]";
	   return jsonString;
   }
   
   @RequestMapping(value="showOrderitem3", method = RequestMethod.POST)
   public @ResponseBody String showOrderitem3()
   {
	   List<Integer> orderItemIds = orderitemRepos.getOrderitem();
	   String jsonString = "[";
	   for( int i = 0; i < orderItemIds.size(); i++ )
	   {
		   jsonString += orderItemIds.get(i) + ",";
	   }
	   jsonString += "]";
	   return jsonString;
   }
   
   @RequestMapping(value="addOrderitem", method = RequestMethod.POST)
   public @ResponseBody void addOrderitem( @RequestParam int orderitemId )
   {
	   Orderitem orderitem = orderitemRepos.findOne( orderitemId );
	   if( orderitem == null )
	   {
		   System.out.println( "该订单项不存在" );
		   return;
	   }
	   orderitem.setOrderitemAmount( orderitem.getOrderitemAmount() + 1 );
	   orderitem.setOrderitemPrice( orderitem.getOrderitemPrice().add(orderitem.getFood().getRealPrice() ) );
	   orderitemRepos.save(orderitem);  
	   //数量加1
   }
   
   @RequestMapping(value="deleteOrderitem", method = RequestMethod.POST)
   public @ResponseBody void deleteOrderitem( @RequestParam int orderitemId )
   {
	   orderitemRepos.deleteOrderitem( orderitemId );
	   //清除订单项
   }
   
   @Autowired
   CartRepository cartRepos;
   @RequestMapping(value="sumOfDesk", method = RequestMethod.POST)
   public @ResponseBody BigDecimal sumOfDesk( @RequestParam int deskId )
   {
	   Integer orderId = waiterRepos.getOrderIdOfDesk( deskId );
	   if( orderId == null )
	   {
		   System.out.println( deskId + "号桌不存在订单" );
		   return null;
	   }
	   return cartRepos.getTotalCost( orderId );
   }
   
   //服务员点击确定，置标志位
   @RequestMapping(value="doWaiterConfirm", method = RequestMethod.POST)
   public @ResponseBody void doWaiterConfirm( @RequestParam int deskId )
   {
	   //由桌号得到订单号
	   Integer orderId = waiterRepos.getOrderIdOfDesk( deskId );
	   if( orderId == null )
	   {
		   System.out.println( deskId + "号桌不存在订单！");
		   return;
	   }
	   waiterRepos.setWaiterConfirm( orderId );
   }
   
   //服务员已确认的桌号
   @RequestMapping(value="deskAlreadyConfirm", method = RequestMethod.POST)
   public @ResponseBody String deskAlreadyConfirm()
   {
	   List<Integer> deskIds = waiterRepos.getDeskAlreadyConfirm();
	   String jsonString = "[";
	   for( int i = 0; i < deskIds.size(); i++ )
	   {
		   jsonString += deskIds.get(i) + ",";
	   }
	   jsonString += "]";
	   return jsonString;//呼叫人工支付的桌号
   }
   
   @RequestMapping(value="deleteOrder", method = RequestMethod.POST)
   public @ResponseBody void deleteOrder( @RequestParam int deskId )
   {
	   waiterRepos.deleteOrder( deskId );
   }
}
