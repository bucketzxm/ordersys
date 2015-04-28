package com.sh.weiyue.ordersys.web.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sh.weiyue.ordersys.web.persistence.domain.Order;
import com.sh.weiyue.ordersys.web.service.ShoppingCart;

public class IsSentOrderInterceptor extends HandlerInterceptorAdapter{
	@Autowired
    ShoppingCart shoppingCart;
	
	@Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception { 	
		
	String checkUrl[] = { 
		"/category", "/dish", "/addToCart", "/",
		"/selectDeskAndPerson", "/isSelectDesk", "/myDish", "/rmFromCart",
		"/orderItemCut", "/sendOrder"
	};
	int i;
	for(  i = 0 ; i < checkUrl.length; i++ )
		if( request.getServletPath().equals( checkUrl[i] ))
 	    	break;
	
	if( i == checkUrl.length )
		return true;
	
    Order order = shoppingCart.getOrder();
	if( order == null )//表示还没选桌,订单还未产生，要放行
	{
		return true;
	}
	else
	{
		if( order.getOrderIsSent() == true )//如果以下单
		{
			System.out.println( "收到请求：" + request.getServletPath() + "，已下单！需要跳转首页");
			String type = request.getHeader("X-Requested-With");
 	 	   	if ("XMLHttpRequest".equalsIgnoreCase(type))  
 	 	   	{  
 	 	   		PrintWriter out = response.getWriter();
 	 	   		out.print( "alreadySentOrder" );	
 	 	   	}
	 	 	else
	 	 		response.sendRedirect( "prePay" );
			return false;			
		}
		
		return true;
	}
}
}
