package com.sh.weiyue.ordersys.web.service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sh.weiyue.ordersys.web.persistence.domain.Agent;
import com.sh.weiyue.ordersys.web.persistence.domain.Food;
import com.sh.weiyue.ordersys.web.persistence.domain.Mac;
import com.sh.weiyue.ordersys.web.persistence.domain.Order;
import com.sh.weiyue.ordersys.web.persistence.domain.Orderitem;
import com.sh.weiyue.ordersys.web.persistence.repository.AgentRepository;
import com.sh.weiyue.ordersys.web.persistence.repository.CartRepository;
import com.sh.weiyue.ordersys.web.persistence.repository.FoodRepository;
import com.sh.weiyue.ordersys.web.persistence.repository.MacRepository;
import com.sh.weiyue.ordersys.web.persistence.repository.OrderRepository;
import com.sh.weiyue.ordersys.web.persistence.repository.OrderitemRepository;
import com.sh.weiyue.ordersys.web.persistence.repository.SpecialRepository;

@Component
@Scope("session")//很多东西都可以写存储过程或者触发器优化
public class ShoppingCart
{
	@Autowired
    FoodRepository foodRepos;
	@Autowired
    OrderRepository orderRepos;
	@Autowired
    OrderitemRepository orderitemRepos;
	@Autowired
    SpecialRepository specialRepos;
	@Autowired
    AgentRepository agentRepos;
	@Autowired
    CartRepository cartRepos;
	@Autowired
    MacRepository macRepos;
	
   // just a plain java class - member variables and methods as usual
   private static int orderId = -1;//-1表示该用户当前还没有订单
   private String macAddress;

	public int getOrderId() {
		return this.orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public Order getOrder(){
		return orderRepos.findOne(orderId);
	}
	public List<Orderitem> getOrderitems(){
		Order  order = getOrder();
		if(order == null)
			return new ArrayList<Orderitem>();
		List<Orderitem> orderitems = order.getOrderitems();
		if(orderitems == null)
			return new ArrayList<Orderitem>();
		return orderitems;
	}

	public Orderitem findOrderitem(int foodId)
	{
		return cartRepos.findOrderitem(orderId,foodId);
	}
   
   public String addToCart(int foodId){
	   Integer status = cartRepos.getFoodStatus(foodId) ;
	   if(status == null || status == 0)
	  {
		  return "soldOut";//已售完
	  }
	   
	   Orderitem orderitem = findOrderitem(foodId);
	   if(orderitem == null)
	   {
		   
		   Food food = foodRepos.findOne(foodId);
		   Order order = orderRepos.findOne(orderId);
		   System.out.print("=====!!!!!! orderitem is null !!!!=====" + orderId);
		   System.out.print("foodid => " + foodId + "<===");
		   orderitem = new Orderitem(order,food);
		   System.out.println( "该菜之前没有被点过" );
		   System.out.println("xxxxxxfuckxxxxxx");
		   
		   orderitemRepos.save(orderitem);
		   System.out.println( "该菜之前没有被点过2222" );
	   }
	   else
	   {
		   System.out.print("=====!!!!!! orderitem is not null !!!!=====");
		  //System.out.println( "该菜之前被点过" );
		  orderitem.setOrderitemAmount(orderitem.getOrderitemAmount()+1);
		  orderitem.setOrderitemPrice(orderitem.getOrderitemPrice().add(orderitem.getFood().getRealPrice()));
		  orderitemRepos.save(orderitem);  
	   }
	   return  getAvgCost() + " " + getTotalCost();
   }
   
   public String rmFromCart(int foodId){
	   Orderitem ordi=this.findOrderitem(foodId);
	   //System.out.println(ordi.getOrderitemId() + "------------------------");
	   ordi = orderitemRepos.save(ordi);//为什么？不知道。。这是删除一个订单项
	   orderitemRepos.deleteOrderitem(ordi.getOrderitemId());
	   return getAvgCost() + " " + getTotalCost();
   }
   
   //减少食物数量
   public String orderItemCut(int foodId)
   {
	   Orderitem orderitem=this.findOrderitem(foodId);
	   orderitem.setOrderitemAmount(orderitem.getOrderitemAmount()-1);
	   orderitem.setOrderitemPrice(orderitem.getOrderitemPrice().subtract(orderitem.getFood().getRealPrice()));
	   orderitemRepos.save(orderitem);
	   return getAvgCost() + " " + getTotalCost();
   }
    
  public int getTotalC(){
	  return cartRepos.getTotalC(orderId);
   }
   
   public int getTotalF(){//可以增加一个属性，然后写触发器优化
	   return cartRepos.getTotalF(orderId);
   }
   
   public BigDecimal getTotalCost(){//可以对于memoney和commoney写触发器
	   BigDecimal totalCost = cartRepos.getTotalCost(orderId);
	   if(totalCost == null)
		   return new BigDecimal(0);
	   return totalCost;
   }
   
   public BigDecimal getAvgCost(){//可以对于memoney和commoney写触发器
	    BigDecimal averageCost;
	    BigDecimal totalCost = getTotalCost();
		int personNum = getOrder().getOrderPersonNum();
		if( getTotalC() == 0 )
			averageCost = new BigDecimal(0);
		else
			averageCost = totalCost.divide(new BigDecimal(personNum),2, BigDecimal.ROUND_HALF_EVEN);
		return averageCost;
   }
   
   public BigDecimal getPlatformMoney()//手机优惠金额
   {
	  return cartRepos.getPlatformMoney(orderId);
   }
   
   public BigDecimal getShopperMoney()//商家推荐金额
   {
	   return cartRepos.getShopperMoney(orderId);
   }
   
   public void clear()
   {
	   System.out.println("执行了clear()!------------------");
	   this.orderId=-1;
   }
   
   public Map<String,Object> getPayAssign()
   {
	   Map<String,Object> payAssign = new HashMap<String,Object>();
	   List<Agent> agents = agentRepos.findByAgentMoneyGreaterThan(new BigDecimal(0));
	   List<Integer> ids = new ArrayList<Integer>();
	   BigDecimal shopperMoney = this.getShopperMoney();//商家推荐金额
	   BigDecimal total = this.getTotalCost();
	   BigDecimal agentMoney;//表示商家欠平台的钱
	   for(int i = 0;i < agents.size();i++)
	   {
		   if(shopperMoney.equals(new BigDecimal(0)))
			   break;
		   agentMoney = agents.get(i).getAgentMoney();
		   
		   //在重新分配之前，先把agentMoney进行备份。已便失败后还原
		   agents.get(i).setAgentMoneyCopy(agentMoney);
		   if(agentMoney.compareTo(shopperMoney) <= 0)
		   {
			   shopperMoney = shopperMoney.subtract(agentMoney);
			   agents.get(i).setAgentMoney(new BigDecimal(0));                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
		   }
		   else
		   {
			   agents.get(i).setAgentMoney(agentMoney.subtract(shopperMoney));
			   shopperMoney = new BigDecimal(0);
		   }
		   ids.add(i);
		   agentRepos.save(agents.get(i));
	   }
	   //两者都有可能是零。在使用时要先进行判断
	   if( total == null )
		   total = new BigDecimal(0);
	   if( shopperMoney == null )
		   shopperMoney = new BigDecimal(0);
	   payAssign.put("plateForm_ BigDecimal",total.subtract(shopperMoney));
	   payAssign.put("shopper_ BigDecimal",shopperMoney);
	   payAssign.put("ids_List",ids);
	   return payAssign;
   }

	public String getMacAddress() {
		return macAddress;
	}
	
	public void setMacAddress(String macAdddress) {
		this.macAddress = macAdddress;
	} 
	
	public void checkMac(HttpServletRequest request)
	{
		System.out.println("fucccccccck############");
		 if(this.getOrderId() > 0)
		 {
			 //若sesion已有值，则不需要检查
			 return;
		 }
		 String ip = request.getHeader("x-forwarded-for");

           if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

               ip = request.getHeader("Proxy-Client-IP");

           }

           if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

               ip = request.getHeader("WL-Proxy-Client-IP");

           }

           if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

               ip = request.getRemoteAddr();

           }
           
           //System.out.println("当前客户端的ip地址是："+ip);
           try{
        	   String macAddress = Mac.GetMacAddress(ip);
        	   if(macAddress == null)
        	   {
        		   //System.out.println("获取的mac地址为空！");
        	   }
        	   else
        	   {
        		   //System.out.println("得到的mac地址是：" + macAddress);
        		   this.setMacAddress(macAddress);
        		   //先获取mac地址，然后由mac地址获取相应的订单
        	       //若不存在或最近订单已完成，则生成新订单，并在mac中加一条新记录
        		   if((macRepos.findMacAddressCount(macAddress) == 0) || macRepos.findLatestOrderState(macAddress))
        		   { 
        			   System.out.println("没找到啊草！！！");
        			   return;
        		   }
        		   //若存在则将找到的记录Id，赋给session
        		   else
        		   {
        			   int orderId = macRepos.findLatestOrderId(macAddress);

        			   System.out.println("找到了日！！！"+orderId);
        			   this.setOrderId(orderId);
        		   }
        	       
        	   }
           }
           catch(Exception e){
        	   System.out.println("获取客户端mac地址时出现异常");
        	   e.printStackTrace();
           }
	}
	
}
