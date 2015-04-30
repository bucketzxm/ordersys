package com.sh.weiyue.ordersys.web.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sh.weiyue.ordersys.web.persistence.domain.Food;
import com.sh.weiyue.ordersys.web.persistence.domain.Menuitem;
import com.sh.weiyue.ordersys.web.persistence.domain.Order;
import com.sh.weiyue.ordersys.web.persistence.domain.Orderitem;
import com.sh.weiyue.ordersys.web.persistence.domain.Special;
import com.sh.weiyue.ordersys.web.persistence.repository.CartRepository;
import com.sh.weiyue.ordersys.web.persistence.repository.DeskRepository;
import com.sh.weiyue.ordersys.web.persistence.repository.MenuitemRepository;
import com.sh.weiyue.ordersys.web.persistence.repository.SpecialRepository;
import com.sh.weiyue.ordersys.web.service.ShoppingCart;

@Controller
public class HomeController 
{	
	@Autowired
    ShoppingCart shoppingCart;
	
	@RequestMapping("")
    public String home(Model model,HttpServletRequest request)
	{	
		 //shoppingCart.checkMac(request);//检查该mac地址用户是否以前就有过订单，若有则设置session.这句改到拦截器里做了	 
		 setDeskButtons( model );
		 setMobileDiscount( model );
		 setBusRecommend( model );
		 System.out.println("####fuck in home####"+shoppingCart.getOrderId());
		 return "home";
	}
	
	@Autowired
	DeskRepository deskRepos;
	private void setDeskButtons( Model model ) 
	{
		Integer deskNum = deskRepos.findAll().get(0).getDeskNum();
		String deskButtons = "";
		for( int i = 1; i <= deskNum; i++ )
			deskButtons += "<button>" + i + "</button>";
		model.addAttribute( "deskButtons", deskButtons );
	}

	@Autowired
	SpecialRepository specialRepo;
	public void setMobileDiscount( Model model )
	{
	   Food food;
	   List<Special> sps = specialRepo.findAll();
	   Order order = shoppingCart.getOrder();
	   String aFavor = "";
	   for(int i = 0;i < sps.size();i++)
	   {
			food = sps.get(i).getFood();	
			String isBeChoiced = "";
			String amount = "1";
	    	if( order != null )
	    	{
	    		Integer foodNum = cartRepo.getFoodAmount( order.getOrderId(), food.getFoodId() );
	    		if( foodNum != null && foodNum !=0 )
		    	{
		    		isBeChoiced = "beChoiced";
		    		amount = foodNum.toString();
		    	}
	    	}
	    	
	    	String likeMark = "";
	        if( food.getFoodScore() != null )
	        {
	        	likeMark = "<span class='likeMark'><img src='icon/like-white.png'>"
	        			+ food.getFoodScore() + "</span>";
	        }
	    	
	    	aFavor += "<div class='item "+ isBeChoiced + "' foodid='" + food.getFoodId() + "'>"
			+ "<img src='" + sps.get(i).getSpecial_picture() + "'>"
			+ "<div class='description'>"
				+ "<div>" + food.getFoodName() + likeMark + "</div>"
				+ "<div>抢购价  <spcialPrice>￥" + sps.get(i).getSpecialPrice() + "</spcialPrice></div>"
			+ "</div>"
			+ "<div class='addDish'>"
				+ "<button>"+amount+"</button>"
			   +"<button class='addButton'>抢 购</button>"
			+ "</div>"
		    + "</div>";
	   }
	   model.addAttribute("aFavor",aFavor);
	}
	
	@Autowired
	MenuitemRepository menuitemRepo;
	@Autowired
	CartRepository cartRepo;
	public void setBusRecommend( Model model )
	{
	   Food food;
	   List<Menuitem> menuItems = menuitemRepo.findByMenuitemBigsaleGreaterThan( new BigDecimal(0) );
	   Order order = shoppingCart.getOrder();
	   
	   String bFavor = "";
	   for(int i = 0;i < menuItems.size();i++){
			food = menuItems.get(i).getFood();		
			String isBeChoiced = "";
			String amount = "1";
	    	if( order != null )
	    	{
	    		Integer foodNum = cartRepo.getFoodAmount( order.getOrderId(), food.getFoodId() );
	    		if( foodNum != null && foodNum !=0 )
		    	{
		    		isBeChoiced = "beChoiced";
		    		amount = foodNum.toString();
		    	}
	    	}
	    	
	    	String likeMark = "";
	    	if( food.getFoodScore() != null )
	        {
	        	likeMark = "<span class='likeMark'><img src='icon/like.png'>"
	        			+ food.getFoodScore() + "</span>";
	        }
	    	
	    	bFavor += "<div class='item "+ isBeChoiced + "' foodid='" + food.getFoodId() + "'>"
	    	+ "<img src='" + food.getFoodPicture() + "'>"
			+ "<div>"
			 	+ "<div>"+food.getFoodName()+"</div>"
				+ "<del>原价：￥"+food.getFoodPrice()+"</del><br />"
				+ "现价：<strong>￥"+menuItems.get(i).getMenuitemBigsale()+"</strong>"
				+ likeMark
			+ "</div>"
			+ "<button>"+amount+"</button>"
		    + "</div>";
	   }
       model.addAttribute("bFavor",bFavor);
	}
	
	public boolean isSelectedDish( int foodId )
	{
		Order order = shoppingCart.getOrder();
		if( order == null )
			return false;
		else
		{
			List<Orderitem> orderItems = order.getOrderitems();
			for( int i = 0; i < orderItems.size(); i++ )
			{
				if( orderItems.get(i).getFood().getFoodId() == foodId )
					return true;
			}
		}
		return false;
	}
}
