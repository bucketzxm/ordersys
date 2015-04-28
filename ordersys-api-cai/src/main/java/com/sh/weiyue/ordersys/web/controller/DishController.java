package com.sh.weiyue.ordersys.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sh.weiyue.ordersys.web.persistence.domain.Category;
import com.sh.weiyue.ordersys.web.persistence.domain.Food;
import com.sh.weiyue.ordersys.web.persistence.domain.Menuitem;
import com.sh.weiyue.ordersys.web.persistence.domain.Order;
import com.sh.weiyue.ordersys.web.persistence.repository.CartRepository;
import com.sh.weiyue.ordersys.web.persistence.repository.CategoryRepository;
import com.sh.weiyue.ordersys.web.service.ShoppingCart;

@Controller
public class DishController
{
	@Autowired
	CategoryRepository cgRepo;
	@Autowired
    ShoppingCart shoppingCart;
	@Autowired
	CartRepository cartRepo;
	
	@RequestMapping("dish")
    public String Dish( Model model, @RequestParam int cgId )
	{
		Category cg = cgRepo.findOne( cgId );
		List<Menuitem> menuItems;
		String dishPart = "";
		menuItems = cg.getMenuitems();
		Order order = shoppingCart.getOrder();
		
	    for( int i = 0; i < menuItems.size(); i++ )
        {
			Food food = menuItems.get(i).getFood();
			String isBeChoiced = "";
			String isSoldOut = "";
			String amount = "1";
			
			if(  menuItems.get(i).getMenuitemStatus() == 0 )
			{
				isSoldOut = "soldOut";
			}
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
			
			dishPart +=
			"<li foodId='"+food.getFoodId()+"' class='"+ isBeChoiced + " " + isSoldOut +"'>"
				+ "<img src='" + food.getFoodPicture() + "'>"
				+ "<h3>"+food.getFormatName()+"</h3>"
				+ "<p>￥"+food.getFoodPrice()+ likeMark + "</p>"
				+ "<button>"+amount+"</button>"
				+ "<div class='liMask'></div>"
				+ "<div class='soldOutMark'>"
					+ "<h3><span>Sold Out</span>  售罄</h3>"
				+ "</div>"
			+"</li>";
        }
	    model.addAttribute("dishPart",dishPart);
	    model.addAttribute("cgName",cg.getCategoryName());
	    return "dish";
	}
}
