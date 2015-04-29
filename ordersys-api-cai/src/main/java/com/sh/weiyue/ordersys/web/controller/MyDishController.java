package com.sh.weiyue.ordersys.web.controller;

import java.math.BigDecimal;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sh.weiyue.ordersys.web.persistence.domain.Food;
import com.sh.weiyue.ordersys.web.persistence.domain.Order;
import com.sh.weiyue.ordersys.web.persistence.domain.Orderitem;
import com.sh.weiyue.ordersys.web.persistence.repository.DeskRepository;
import com.sh.weiyue.ordersys.web.persistence.repository.OrderRepository;
import com.sh.weiyue.ordersys.web.service.ShoppingCart;
import com.sh.weiyue.ordersys.web.controller.AliPayController;
@Controller
public class MyDishController
{
	@Autowired
	private ShoppingCart shoppingCart;

	@RequestMapping("myDish")
    public String MyDish( Model model )
	{
		String myOrderList="";
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
			+			"<img src = 'icon/plus-black.png'>"
			+			"<amount>"+orderitems.get(i).getOrderitemAmount()+"</amount>"
			+			"<img src = 'icon/minus-black.png'>"
			+		"</td>"
			+		"<td>￥"+food.getRealPrice()+"</td>"
			+	"</tr>";
		}
		model.addAttribute( "myOrderList", myOrderList );

		int personNum = shoppingCart.getOrder().getOrderPersonNum();
		BigDecimal averageCost = shoppingCart.getAvgCost();
		BigDecimal totalCost = shoppingCart.getTotalCost();

		model.addAttribute( "deskId",shoppingCart.getOrder().getOrderDeskId() + "" );
		model.addAttribute( "personNum", personNum+"" );
		model.addAttribute( "sum", totalCost.toString() );
		model.addAttribute( "avg", averageCost.toString() );
		setDeskButtons( model );
		return "myDish";
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

	
	private String prepareOrder()
	{
		
		JSONObject obj = new JSONObject();

		obj.put("custId",'0');

		obj.put("restId","19");

//		JSONObject items = new JSONObject();
//		items.put(", value)
//		obj.put();
//		
		
		//just for test
		String ret_str = "{\"custId\": \"0\", \"itemList\": [{\"itemId\": \"15927\", \"modifierIds\": \"\", \"itemPrice\": \"25.8\", \"instractions\": \"\", \"modifierPrice\": \"0\", \"itemNum\": \"1\", \"taxPrice\": \"0\"}], \"restId\": \"19\"}";
		
		
		return  ret_str; 
	}
	
	@Autowired
    OrderRepository orderRepos;
	@RequestMapping(value="sendOrder", method = RequestMethod.POST)
	public @ResponseBody String sentOrder()
	{
		orderRepos.setOrderIsSent( true, shoppingCart.getOrderId() );
		orderRepos.setOrderMermoney( shoppingCart.getPlatformMoney(), shoppingCart.getOrderId() );//平台的钱
        orderRepos.setOrderCommoney( shoppingCart.getShopperMoney(), shoppingCart.getOrderId() );//商家的钱
        
        
        String url = "http://218.244.136.120:8080/alfred-mobile-api/order/addOrder";
        String ret_str = prepareOrder();
        
        JSONObject ret = new JSONObject(AliPayController.strPost(url,ret_str));
        
        System.out.print(ret.get("appOrderId"));
        String out_trade_num = ret.get("appOrderId").toString();
        System.out.print(out_trade_num);
        orderRepos.setOutTradeNum(out_trade_num, shoppingCart.getOrderId());
//        System.out.print (AliPayController.strPost(url,ret_str));
//        System.out.println(shoppingCart.getOrderId());
        //Order order = shoppingCart.getOrder();
        
        // sendOrder 后获取 order 的 out_trade_no 
       // order.setOutTradeNo(ret.getString("appOrderId"));
        
        //List<Orderitem> orderItems = order.getOrderitems();
        
//        System.out.println( orderItems.get(0).toString() );
		return "2";
	}
}
