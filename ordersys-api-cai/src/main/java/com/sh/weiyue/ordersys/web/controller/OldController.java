package com.sh.weiyue.ordersys.web.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sh.weiyue.ordersys.web.persistence.domain.Category;
import com.sh.weiyue.ordersys.web.persistence.domain.Food;
import com.sh.weiyue.ordersys.web.persistence.domain.Menuitem;
import com.sh.weiyue.ordersys.web.persistence.domain.Order;
import com.sh.weiyue.ordersys.web.persistence.domain.Orderitem;
import com.sh.weiyue.ordersys.web.persistence.domain.Special;
import com.sh.weiyue.ordersys.web.persistence.repository.CartRepository;
import com.sh.weiyue.ordersys.web.persistence.repository.CategoryRepository;
import com.sh.weiyue.ordersys.web.persistence.repository.FoodRepository;
import com.sh.weiyue.ordersys.web.persistence.repository.MenuitemRepository;
import com.sh.weiyue.ordersys.web.persistence.repository.OrderitemRepository;
import com.sh.weiyue.ordersys.web.persistence.repository.SpecialRepository;
import com.sh.weiyue.ordersys.web.service.ShoppingCart;


//@Controller
public class OldController { 
	@Autowired
	CategoryRepository cgRepo;
	@Autowired
	private  ShoppingCart shoppingCart;
	@Autowired
	FoodRepository foodRepo;
	@Autowired
	SpecialRepository specialRepo;
	@Autowired
	MenuitemRepository menuitemRepo;
	@Autowired
    OrderitemRepository orderitemRepos;
	@Autowired
    CartRepository cartRepos;
	
	@RequestMapping("")
    public String home(Model model,HttpServletRequest request)
	{
		//检查该mac地址用户是否以前就有过订单，并相应地设置session
		 shoppingCart.checkMac(request);
		 //优惠推荐生成
		 makeFavor(model);
//		 //表头和滑动条的显示和消失(即显示当前的人数和桌号)
//		 makeFomerAndSlider(model);
//		 return "homeTest3";
		return "newHome";
	}
	
	@RequestMapping("newMenu")
    public String Menu( Model model )
	{
	   //找到主菜单中的菜
	   List<Category> cgs = cgRepo.findAll();
	   String cgName="";
	   int cgNo;
	   String cgPart="";	   
	   for(int i = 0; i < cgs.size(); i++ ){
		   cgName = cgs.get(i).getCategoryName();
	       cgNo = cgs.get(i).getCategoryId();
		   cgPart += "<div cgNo='"+cgNo+"'>"+cgName + "</div>";  
	   }
	   String dishPart = getDishPart( cgRepo.findOne(cgs.get(0).getCategoryId() ) );
	   model.addAttribute("cgPart",cgPart);
	   model.addAttribute("dishPart",dishPart);
	   return "newMenu";
	}
	
	@RequestMapping(value="getCategory", method = RequestMethod.POST)  
    public @ResponseBody void getCategory( @RequestParam int cgId, HttpServletResponse response) throws IOException//将总费用和人均费用打包在一个Map中返回
	{
		Category cg = cgRepo.findOne( cgId );
		String dishPart = getDishPart( cg );
		response.setContentType("text/text;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print( dishPart );		
	}
	
	String getDishPart( Category cg )
	{
		List<Menuitem> menuItems;
		String dishPart = "";
		menuItems = cg.getMenuitems();
	   int j = 0;
	   while( j < menuItems.size() )
       {
		   if( menuItems.size() - j >= 2)
		   {
			   Food food1 = menuItems.get(j).getFood();
			   Food food2 = menuItems.get(j+1).getFood();
			   
			   if( food1.getFoodName().length() > food2.getFoodName().length() )
			   {
				   Food foodTmp = food1;
				   food1 = food2;
				   food2 = foodTmp;
			   }
			   dishPart += "<div>"+
		    			"<div class='dish' foodId='"+food1.getFoodId()+"'>"+
		    			"<img src='images/"+food1.getFoodName()+".jpg'>"+
			 		    "<div>" + food1.getFoodName() + "</div>"+
			 		    "<div>￥" + food1.getRealPrice() + "</div>"+
			 			"</div>";
			   
			   dishPart += "<div class='dish' foodId='"+food2.getFoodId()+"'>"+
		    			"<img src='images/"+food2.getFoodName()+".jpg'>"+
			 		    "<div>" + food2.getFoodName() + "</div>"+
			 		    "<div>￥" + food2.getRealPrice() + "</div>"+
			 			"</div></div>";			   
		   }
		   else
		   {
			   Food food = menuItems.get(j).getFood();
			   dishPart += "<div>"+
		    			"<div class='dish' foodId='"+food.getFoodId()+"'>"+
		    			"<img src='images/"+food.getFoodName()+".jpg'>"+
			 		    "<div>" + food.getFoodName() + "</div>"+
			 		    "<div>￥" + food.getRealPrice() + "</div>"+
			 			"</div></div>";
			   
		   }
    	   j += 2;
       }
	   
		dishPart += "<div>" +
		  "<div style='width:100%;float:left;height:40px'>" +
		  "</div></div>";
	   return dishPart;
	}
	
	@RequestMapping("newMyDish")
    public String MyDish()
	{
		return "newMyDish";
	}
	
	@RequestMapping("choicePay")
    public String choicePay()
	{
		return "choicePay";
	}
	
	
	void makeFavor(Model model)
	{
		Food food;
		//找到手机优惠的菜品
	   List<Special> sps = specialRepo.findAll();
	   String aFavor = "";
	   for(int i = 0;i < sps.size();i++)
	   {
			food = sps.get(i).getFood();
	    	aFavor += "<div class='item' foodid='"+food.getFoodId()+"'>"
    			+ "<img src='images/"+food.getFoodName()+".jpg' alt='Owl Image'>"
			    + "<div class='description'>"
	    		+ food.getFoodName() + "<br />"
   	            + "原价￥"+food.getRealPrice()+" 松鼠优惠价￥"+sps.get(i).getSpecialPrice()
   	            +"</div></div>";

	   }
	   model.addAttribute("aFavor",aFavor);
	    
	  List<Menuitem> menuItems = menuitemRepo.findByMenuitemBigsaleGreaterThan(new BigDecimal(0));
	   String bFavor = "";
	   for(int i = 0;i < menuItems.size();i++){
			food = menuItems.get(i).getFood();
	    	bFavor += "<div class='item' foodid='"+food.getFoodId()+"'>"
    			+ "<img src='images/"+food.getFoodName()+".jpg' alt='Owl Image'>"
		    + "<div>"
    		+ "<div>"+food.getFoodName()+"</div>"
   	            + "<s>原价：￥"+food.getRealPrice()+"</s><br />"
    		+"现价：<strong>￥"+menuItems.get(i).getMenuitemBigsale()+"</strong>"  
   	    		+ "</div></div>";
	   }
	   model.addAttribute("bFavor",bFavor);
	}
	
	void makeFomerAndSlider(Model model)
	{
		String fomerDisplay = "";
		String fomerPerson = "";
		String fomerDesk = "";
		Order order = shoppingCart.getOrder();
		if( order != null)
		{
			fomerDesk = "   桌号："+ order.getOrderDeskId() +"  ";
			fomerPerson = "   人数："+ order.getOrderPersonNum() +"  ";
		}
		else
		{
			fomerDisplay = "display:none;";
		}	
		
		model.addAttribute("fomerDesk",fomerDesk);
		model.addAttribute("fomerPerson", fomerPerson);
		model.addAttribute("fomerDisplay", fomerDisplay);
	}
	
	@RequestMapping("test")
    public String test(){
		Orderitem ordi = orderitemRepos.findAll().get(0);
		System.out.println(ordi.getOrderitemId()+"-----------");
		orderitemRepos.delete(ordi);
		System.out.println("test completed!");
		return "prePay";
	}

	@RequestMapping("prePay")
    public String prePay(@RequestParam int mode,Model model,HttpServletRequest request){
		shoppingCart.checkMac(request);
		System.out.println(shoppingCart.getOrderId() + "-----------------");
		Order order = shoppingCart.getOrder();
		if(order == null || order.getOrderDeskId() == null)
			return "prePay";
		
		String myOrderList="";
		int totalC=shoppingCart.getTotalC();
		Food food;
		List<Orderitem> orderitems = shoppingCart.getOrderitems();
		for(int i=0;i<totalC;i++)
		{
			food=orderitems.get(i).getFood();
			myOrderList+="<li class='ui-li ui-li-static ui-btn-up-c ui-li-last' foodid ='"+food.getFoodId()+"'>"+
						"<h1 class='ui-li-heading'>"+food.getFormatName()+
						"<span style='position:absolute;right:10px;'>"+
								"<font style='color:red;'>￥"+food.getRealPrice()+"</font>"+
								"<font style='color:green'>×"+orderitems.get(i).getOrderitemAmount()+"</font>"+
						"</span>"+
						"</h1></li>";					
		}
		Map<String,String> map = getTwoCost();
		model.addAttribute("myOrderList",myOrderList);
		model.addAttribute("personNum",map.get("personNum"));
		model.addAttribute("deskId",map.get("deskId"));
		model.addAttribute("totalCost",map.get("totalCost"));
		model.addAttribute("averageCost",map.get("averageCost"));
		if(mode==1)
		  return "prePay";
		else
		  return "prePay2";
	}
	
	@RequestMapping(value="getTwoCost", method = RequestMethod.POST)  
    public @ResponseBody Map<String,String> getTwoCost()//将总费用和人均费用打包在一个Map中返回
	{
		Map<String,String> map=new HashMap<String,String>();
		BigDecimal averageCost;
		BigDecimal totalCost = shoppingCart.getTotalCost();
		int orderId = shoppingCart.getOrderId();
		Integer personNum = cartRepos.getpersonNumByOrder(orderId);
		if(shoppingCart.getTotalC()==0)
			averageCost=new BigDecimal(0);
		else
			averageCost = totalCost.divide(new BigDecimal(personNum),2, BigDecimal.ROUND_HALF_EVEN);
		map.put("averageCost", averageCost+"");
		map.put("totalCost",totalCost+"");
		map.put("deskId",cartRepos.getDeskIdByOrder(orderId)+"");
		map.put("personNum",personNum+"");
		
		//由张翔调用，但是要注意，一旦支付失败后再加回去，也就是说这个map对象取一次后要保留着，最后不是支付成功，就是又加回去了
		/*Map<String,BigDecimal> payAssign = shoppingCart.getPayAssign();
		System.out.println("手机优惠金额:" + payAssign.get("1"));
		System.out.println("商家所得金额:" + payAssign.get("2"));*/
		return map;
	}
	
	@RequestMapping(value="addToCart", method = RequestMethod.POST)  
	public @ResponseBody String addToCart(@RequestParam int foodId){ 
		return shoppingCart.addToCart(foodId)+"";
	}
	
	@RequestMapping(value="rmFromCart", method = RequestMethod.POST)  
	public @ResponseBody String  rmFromCart(@RequestParam int foodId){ 
		return shoppingCart.rmFromCart(foodId) + "";
	}
	
	@RequestMapping(value="orderItemCut", method = RequestMethod.POST)  
	public @ResponseBody String  orderItemCut(@RequestParam int foodId){ 
		return shoppingCart.orderItemCut(foodId) + "";
	}

	//由于之前JqueryMobile全部都是ajax跳转，所以这个响应也处理成了ajax
	@RequestMapping(value="getMyOrder", method = RequestMethod.POST)  
    public @ResponseBody Map<String,String> getMyOrder() { 
		String myOrderList="";
		int totalC=shoppingCart.getTotalC();
		Food food;
		List<Orderitem> orderitems = shoppingCart.getOrderitems();
		for(int i=0;i<totalC;i++)
		{
			food=orderitems.get(i).getFood();
			myOrderList+="<li class='ui-li ui-li-static ui-btn-up-c ui-li-last' foodid ='"+food.getFoodId()+"'>"+
						"<h1 class='ui-li-heading'>"+food.getFormatName()+" ￥"+food.getRealPrice()+"</h1>"+
						"<div class='quantityChanger'>"+
						    "<font style='font-size:30px;color:red;cursor: pointer;' onclick = 'bubbleCount2(this,1)'>+</font>"+
							"<font style='font-size:25px;margin:15px;' class = 'amount'>"+orderitems.get(i).getOrderitemAmount()+"</font>"+
							"<font style='font-size:30px;color:green;cursor:pointer;' onclick = 'bubbleCount2(this,-1)'>-</font>"+
						"</div></li>";					
		}
		System.out.println("point1 ------------- ");
		Map<String,String> map = getTwoCost();
		System.out.println("point2 ------------- ");
		map.put("myOrderList",myOrderList);
		return map;
 }

  @RequestMapping(value="checkOrder", method = RequestMethod.POST)  
   public @ResponseBody String checkOrder() {
	  if(shoppingCart.getTotalC()>0){
		  return "1";
	  }
	  else 
		  return "0";
  }
  
  @RequestMapping(value="getRecommendDish", method = RequestMethod.POST)  
   public @ResponseBody Map<String,String> getRecommendDish() {
	  List<Special> specials = specialRepo.findAll();
	  List<Orderitem> orderitems = shoppingCart.getOrderitems();
	  Map<String,String> map=new HashMap<String,String>();
	  Food food;
	  for(int i=0; i < specials.size(); i++)
	  {
		  if(!isInOrder(specials.get(i), orderitems))
		  {
			  food = specials.get(i).getFood();
			  map.put("foodName",food.getFoodName());
			  map.put("foodId",food.getFoodId()+"");
			  return map;
		  }
	  }
	  map.put("foodName","0");
	  return map;
  }
  
  //判断某个特价菜是否已点
  boolean isInOrder(Special special, List<Orderitem> orderitems)
  {
	  for(int i = 0; i < orderitems.size(); i++)
	  {
		  if(orderitems.get(i).getFood().getFoodId() == special.getFood().getFoodId())
			  return true;
	  }
	  return false;
  }
  
  //若session中orderid已有，初始化之前已点的菜
  @RequestMapping(value="initAmount", method = RequestMethod.POST)  
   public @ResponseBody List<FoodAmount> initAmount()
	   {
		  List<FoodAmount> foodAmountList = new ArrayList<FoodAmount>();
		  if(shoppingCart.getOrderId() < 0)
			  return foodAmountList;
		  
		  Orderitem orderitem;
		  List<Orderitem> orderitems = shoppingCart.getOrderitems();
		  for(int i = 0; i < orderitems.size(); i++)
		  {
			  orderitem = orderitems.get(i);
			  FoodAmount foodAmount = new FoodAmount(orderitem.getFood().getFoodId(),orderitem.getOrderitemAmount());
			  foodAmountList.add(foodAmount);
		  }
		  return foodAmountList;
	   }
}

class FoodAmount
{
	private int foodId;
	private int amount;
	
	FoodAmount(int foodId, int amount)
	{
		this.setFoodId(foodId);
		this.setAmount(amount);
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}


