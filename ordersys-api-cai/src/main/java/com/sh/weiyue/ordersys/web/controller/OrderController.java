package com.sh.weiyue.ordersys.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController
{
	
	@RequestMapping("query_order_status")
	public String queryOrderStatus(HttpServletRequest request){
		
		String order_success = null;
		Map<String, String[]> params =  request.getParameterMap();
		String queryString = null;
		//获取 out_trade_no
		
		String out_trade_no = params.get("todo_order")[0];
		
		String[] todo = out_trade_no.split(";");
		
		for (String ord : todo)
		{
			
		}
		
		return order_success;
	}
	
}