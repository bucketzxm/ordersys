package com.sh.weiyue.ordersys.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sh.weiyue.ordersys.web.persistence.domain.Evaluate;
import com.sh.weiyue.ordersys.web.persistence.domain.Food;
import com.sh.weiyue.ordersys.web.persistence.domain.Orderitem;
import com.sh.weiyue.ordersys.web.persistence.repository.EvaluateRepository;
import com.sh.weiyue.ordersys.web.persistence.repository.OrderRepository;
import com.sh.weiyue.ordersys.web.service.ShoppingCart;

import org.json.JSONArray;
import org.json.JSONObject;
@Controller
public class EvaluateController {
	@Autowired
    private ShoppingCart shoppingCart;
	@Autowired
    OrderRepository orderRepos;
	@Autowired
	EvaluateRepository evaluateRepos;
	
	@RequestMapping("evaluate")
    public String evaluate( Model model )
	{
		
		// 把订单设为完成状态	
		orderRepos.setOrderState("TRADE_FINISHED", shoppingCart.getOrder().getOutTradeNo());
		//先表格
		String myOrderList="";
		//orderRepos.setOrderState(true, shoppingCart.getOrderId());
    	
		int totalC = shoppingCart.getTotalC();
		Food food;
		List<Orderitem> orderitems = shoppingCart.getOrderitems();
		for(int i = 0; i < totalC; i++ )
		{
			food=orderitems.get(i).getFood();
			myOrderList +=
				"<tr foodid ='"+food.getFoodId()+"'>"
			+		"<td>"
			+			"<div></div>"
			+			food.getFormatName()
			+		"</td>"
			+		"<td>"
			+			"<img src = 'icon/heart-white.png'>" 
			+			"<img src = 'icon/heart-white.png'>" 
			+			"<img src = 'icon/heart-white.png'>" 
			+			"<img src = 'icon/heart-white.png'>" 
			+			"<img src = 'icon/heart-white.png'>" 
			+		"</td>"
			+	"</tr>";
		}
		model.addAttribute( "myOrderList", myOrderList );
		shoppingCart.clear();//清空session中的，但数据库中的已付款标志要在支付成功时才置
		return "evaluate";
	}
	
	@RequestMapping("doEvaluate")
	public @ResponseBody void doEvaluate( @RequestParam String jsonString )
	{
		JSONArray jsonarray = new JSONArray( jsonString );
		for( int i = 0; i < jsonarray.length(); i++ )
		{
			JSONObject jsonObj = jsonarray.getJSONObject(i);
			//System.out.println( jsonObj.getInt("dishId") + ":" + jsonObj.getInt("score") );
			Evaluate evaluate = new Evaluate( jsonObj.getInt("dishId"), jsonObj.getInt("score") );
			evaluateRepos.save( evaluate );
		} 
		
	}
}
