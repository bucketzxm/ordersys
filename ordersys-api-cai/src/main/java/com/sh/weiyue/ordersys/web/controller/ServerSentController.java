package com.sh.weiyue.ordersys.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sh.weiyue.ordersys.web.persistence.domain.Order;
import com.sh.weiyue.ordersys.web.persistence.repository.OrderRepository;
import com.sh.weiyue.ordersys.web.persistence.repository.OrderitemRepository;
import com.sh.weiyue.ordersys.web.service.ShoppingCart;

@Controller
public class ServerSentController {

	@Autowired
	OrderRepository orderRepos;
	@Autowired
	ShoppingCart shoppingCart = null;
	
	private List<Order> orders =null;
	
	
	public int deleteOrderByOutTradeNum(String out_trade_no){
		
		List<Order> orders = orderRepos.findAll();
		for(Order order: orders)
		{
			if( order.getOutTradeNo().equals(null)){
				continue;
			}
			
			if (order.getOutTradeNo().equals(out_trade_no))
			{
				System.out.println("order_out_trade_no =>"+out_trade_no+"will be deleted!!!");
				orderRepos.delete(order.getOrderId());

				shoppingCart.clear();
				
				return 1;
			}
		}
		return 0;
}
	
	
	@RequestMapping("receiveCheckOut/serverSent")
	public void sendMessage(HttpServletResponse response) throws IOException
	{
		response.setContentType("text/event-stream");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();;
		String checkOutOrder = "";
		
			
		try{
			List<Order> orders = orderRepos.findByOrderState("TRADE_WAIT_TO_FINISH");
			for(Order o: orders)	
			{
				checkOutOrder = "<ul>" +
						o.getOutTradeNo()+ "<button>abc</button>"+
						"</ul>";
				orderRepos.setOrderState("TRADE_NOTIFY_WAITER",o.getOutTradeNo());
				out.write("data: "+checkOutOrder+"\n\n");
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();	
				}	
			}
		}catch(Exception e){
			e.printStackTrace();
			out.close();
		}
		out.close();
	}
	
	
	@RequestMapping("receiveCheckOut")
	public String waiterCheckOut(HttpServletResponse response, Model model){
		
		return "receiveCheckOut";
	}
	
	@RequestMapping("setOrderFinished")
	public void setOrderFinished(HttpServletRequest request){
		String out_trade_no = request.getParameter("out_trade_no");
		
		orderRepos.setOrderState("TRADE_WAIT_TO_FINISH", out_trade_no);
		System.out.println("xxxxxxTRADE_WAIT_TO_FINISH"+out_trade_no);
		
	}
	
	@RequestMapping("deleteCheckOut")
	public void deleteCheckOut(HttpServletRequest request){
		String out_trade_no = request.getParameter("out_trade_no");
		orderRepos.setOrderState("TRADE_FINISHED", out_trade_no);
	}
	
	
	
	@RequestMapping(value="checkOrderFinished", method = RequestMethod.POST)
	public @ResponseBody String checkOrderFinished(@RequestParam String out_trade_no)
	{
		int orderId = orderRepos.findByOutTradeNum(out_trade_no);
		
		Order ord = orderRepos.findByOrderId(orderId);
		
//		System.out.println(ord.getOutTradeNo()+"++++++++");
		try{
//			Order ord = orderRepos.findByOutTradeNum(out_trade_no);
			System.out.println(ord.getOrderState()+"++++++");
			if(ord.getOrderState().equals("TRADE_FINISHED"))
			{
				//deleteOrderByOutTradeNum(out_trade_no);
				return "true";
			}else{
				return "false";
			}
			
		}catch (Exception e){
			return "false";
		}
		
	}
}
