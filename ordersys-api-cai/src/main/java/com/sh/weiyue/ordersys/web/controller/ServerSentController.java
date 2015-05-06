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
	
	
	@RequestMapping("serverSent")
	public @ResponseBody  String sendMessage(HttpServletResponse response, Model model) throws IOException
	{
		Random r = new Random();
		response.setContentType("text/event-stream");
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		String checkOutOrder = "";
		while(true)
		{
			try{
				out =  response.getWriter();
				
				List<Order> orders = orderRepos.findByOrderState("TRADE_WAIT_TO_FINISH");
				
				for(Order o: orders)
				{
					checkOutOrder += o.getOutTradeNo()+";";
				}

				System.out.println("start to find trade_wait_to_finish orders"+" ==> " + checkOutOrder);
				out.write(checkOutOrder);
				
				try{
					response.flushBuffer();
				}catch(Exception e){  
					break;
				}
			}catch(IOException e)
			{
				out.close();
				e.printStackTrace();
				break;
			}catch(Exception e){
				break;
			}		
		}
		return "serverSent";
	}
	
	
	@RequestMapping("receiveCheckOut")
	public String waiterCheckOut(HttpServletResponse response, Model model){
		PrintWriter out = null;
		String checkOutOrder = "";
		while(true){
			try{
				out = response.getWriter();
				List<Order> orders = orderRepos.findByOrderState("TRADE_WAIT_TO_FINISH");
				for(Order o: orders)
				{
					checkOutOrder = "<ul>" +
									o.getOutTradeNo()+ "<button>abc</button>"+
									"</ul>";
					orderRepos.setOrderState("TRADE_NOTIFY_WAITER",o.getOutTradeNo());
					out.write(checkOutOrder);
				}	
				try{
					response.flushBuffer();
				}catch(Exception e){
					e.printStackTrace();
					break;
				}
			}catch(IOException e){
				e.printStackTrace();
				out.close();
			}catch(Exception e){
				e.printStackTrace();
				out.close();
				break;
			}
		}
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
