package com.sh.weiyue.ordersys.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sh.weiyue.ordersys.web.persistence.domain.Order;
import com.sh.weiyue.ordersys.web.service.ShoppingCart;

public class IsHasDishInterceptor extends HandlerInterceptorAdapter{
	@Autowired
    ShoppingCart shoppingCart;
	
		@Override
	    public boolean preHandle(HttpServletRequest request,
	            HttpServletResponse response, Object handler) throws Exception { 	
			
		String checkUrl[] = { "/myDish", "/choicePay", "/login", "/evaluate"};
		int i;
		for(  i = 0 ; i < checkUrl.length; i++ )
			if( request.getServletPath().equals( checkUrl[i] ))
	 	    	break;
		
		if( i == checkUrl.length )
			return true;
		
	    Order order = shoppingCart.getOrder();
		if( order == null )
		{
			response.sendRedirect( "#" );//#表示回到根目录？
			return false;
		}
		else
		{
			if( order.getOrderitems().size() == 0 )
			{
				response.sendRedirect( "#" );
				return false;			
			}
			//if( request.getServletPath().equals( "/evaluate" ) && order.getOrderState() == false )
				//return false;//未测试evaluate页面方便，先注释
			return true;
		}
	}
}
