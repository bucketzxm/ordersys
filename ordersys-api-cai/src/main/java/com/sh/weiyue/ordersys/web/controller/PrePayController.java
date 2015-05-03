package com.sh.weiyue.ordersys.web.controller;

import com.sh.weiyue.ordersys.web.persistence.repository.OrderRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

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
	@Autowired
	private OrderRepository orderRepo;
	@RequestMapping("humanPayConfirm")
    public String humanPayConfirm(Model model) throws IOException
	{	
		
		String out_trade_no = shoppingCart.getOrder().getOutTradeNo();	

		String get_url = "http://localhost:8088/receiveCheckOut/?out_trade_no="+out_trade_no;

		URL realUrl = new URL(get_url);
		
		System.out.print(get_url);
		
		URLConnection conn = realUrl.openConnection();
		conn.setRequestProperty("accept", "*/*");  
        conn.setRequestProperty("connection", "Keep-Alive");  
        conn.setRequestProperty("user-agent",  
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");  
		conn.connect();
		Map<String,List<String>> map = null;
		map = conn.getHeaderFields();
		
		for (String key : map.keySet())
		{
			System.out.println(key + "-->" + map.get(key));
		}
		model.addAttribute("out_trade_no",out_trade_no);
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
