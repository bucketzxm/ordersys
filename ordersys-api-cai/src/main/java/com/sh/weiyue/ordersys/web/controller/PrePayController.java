package com.sh.weiyue.ordersys.web.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sh.weiyue.ordersys.web.persistence.domain.Food;
import com.sh.weiyue.ordersys.web.persistence.domain.Orderitem;
import com.sh.weiyue.ordersys.web.service.ShoppingCart;

@Controller
public class PrePayController 
{
	@Autowired
	private ShoppingCart shoppingCart;
	
	@RequestMapping("humanPayConfirm")
    public String humanPayConfirm()
	{	
		return "humanPayConfirm";
	}
	
	@RequestMapping("prePay")
    public String prePay( Model model )
	{	
		String myOrderList="";
		int totalC = shoppingCart.getTotalC();
		Food food;
		List<Orderitem> orderitems = shoppingCart.getOrderitems();
		for(int i = 0; i < totalC; i++ )
		{
			food=orderitems.get(i).getFood();

			myOrderList +=
				"<tr>"
			+		"<td>" + food.getFormatName() + "</td>"
			+		"<td>" + orderitems.get(i).getOrderitemAmount() + "</td>"
			+		"<td>￥"+food.getRealPrice()+"</td>"
			+	"</tr>";				
		}
		model.addAttribute( "myOrderList", myOrderList );
		
		//TODO: 判断order是否已经删除
		if(shoppingCart.getOrder() == null){
			return "home";
		}
		int personNum = shoppingCart.getOrder().getOrderPersonNum();
		BigDecimal averageCost = shoppingCart.getAvgCost();
		BigDecimal totalCost = shoppingCart.getTotalCost();

		model.addAttribute( "deskId",shoppingCart.getOrder().getOrderDeskId() + "" );
		model.addAttribute( "personNum", personNum+"" );
		model.addAttribute( "sum", totalCost.toString() );
		model.addAttribute( "avg", averageCost.toString() );
		return "prePay";
	}
}
