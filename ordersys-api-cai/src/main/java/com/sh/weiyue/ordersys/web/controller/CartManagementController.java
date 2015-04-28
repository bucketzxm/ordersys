package com.sh.weiyue.ordersys.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sh.weiyue.ordersys.web.persistence.domain.Mac;
import com.sh.weiyue.ordersys.web.persistence.domain.Order;
import com.sh.weiyue.ordersys.web.persistence.repository.DeskRepository;
import com.sh.weiyue.ordersys.web.persistence.repository.FoodRepository;
import com.sh.weiyue.ordersys.web.persistence.repository.MacRepository;
import com.sh.weiyue.ordersys.web.persistence.repository.MenuitemRepository;
import com.sh.weiyue.ordersys.web.persistence.repository.OrderRepository;
import com.sh.weiyue.ordersys.web.service.ShoppingCart;

@Controller
@Scope("request")
public class CartManagementController //负责选桌相关的ajax请求
{
   @Autowired
   private ShoppingCart shoppingCart;
   @Autowired
   FoodRepository repository;
   @Autowired
   MenuitemRepository repository2;
   @Autowired
   DeskRepository deskRepos;
   @Autowired
   OrderRepository orderRepos;
   @Autowired
   MacRepository macRepos;

   String judgeDesk( int deskId, int personNum )
   {
	   Order order = shoppingCart.getOrder();
	   Integer deskNum = deskRepos.findAll().get(0).getDeskNum();
	   //System.out.println( "读到了桌子数量为：" + deskNum );
	   if( deskId < 1 || deskId > deskNum )
		   return "-1";//没有这张桌号
	   if(order != null)//如果订单已存在,且选号没变
	   {

		   if( order.getOrderDeskId() == deskId)
		   {
			   return "1";
		   }
	   }

	   if(orderRepos.findByorderDeskIdAndOrderState( deskId, false ).size()>0)
	   {
		   return "0";//该位子当前已被占，不能被选
	   }

	   if( order != null )//如果订单已存在
	   {
		   order.setOrderDeskId( deskId );;
		   orderRepos.save(order);
	   }
	   else{
		   order = new Order( deskId, personNum );
	       order = orderRepos.save(order);
	       
	       shoppingCart.setOrderId(order.getOrderId());

	       Mac mac = new Mac(shoppingCart.getMacAddress(),order);
	       macRepos.save(mac);
	   }
       return "1";
   }



   @RequestMapping(value="selectDeskAndPerson", method = RequestMethod.POST)
   public @ResponseBody String selectDeskAndPerson(@RequestParam int deskId, @RequestParam int personNum)
   {
	   String ans = judgeDesk( deskId, personNum );
	   if( ans.equals( "1" ) )
	   {
	       //Helper.sit(deskId+"");
		   return "1";
	   }
	   else
		   return ans;
   }

   @RequestMapping(value="isSelectDesk", method = RequestMethod.POST)
   public @ResponseBody String isSelectDesk()
   {
	  if( shoppingCart.getOrderId() > 0)
		  return "true";
	  else
		  return "false";
   }

   @RequestMapping(value="addToCart", method = RequestMethod.POST)
	public @ResponseBody String addToCart(@RequestParam int foodId){
		return shoppingCart.addToCart(foodId);
	}

	@RequestMapping(value="rmFromCart", method = RequestMethod.POST)
	public @ResponseBody String  rmFromCart(@RequestParam int foodId){
		return shoppingCart.rmFromCart(foodId) + "";
	}

	@RequestMapping(value="orderItemCut", method = RequestMethod.POST)
	public @ResponseBody String  orderItemCut(@RequestParam int foodId){
		return shoppingCart.orderItemCut(foodId) + "";
	}

}













