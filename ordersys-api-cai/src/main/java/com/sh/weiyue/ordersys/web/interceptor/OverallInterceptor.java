package com.sh.weiyue.ordersys.web.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sh.weiyue.ordersys.web.service.ShoppingCart;

public class OverallInterceptor extends HandlerInterceptorAdapter {
	@Autowired
    ShoppingCart shoppingCart;

	@Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {

		shoppingCart.checkMac(request);
		String allowUrl[] = {
		"/", "/isSelectDesk", "/selectDeskAndPerson","/reLogin","SystemPrompt", "/doEvaluate"
				
		};
		for( int i = 0 ; i < allowUrl.length; i++ )
			if( request.getServletPath().equals( allowUrl[i] ))
	 	    	return true;

 	    if( shoppingCart.getOrderId() != -1 )
 	    	return true;
 	    else
 	    {
 	    	System.out.println( "收到请求：" + request.getServletPath() + "，需要跳转首页");
 	       //判断是否是ajax请求
 	       String type = request.getHeader("X-Requested-With");
 	 	   if ("XMLHttpRequest".equalsIgnoreCase(type))
 	       {
 	           System.out.println( "这是一个ajax请求:" + request.getServletPath() );
 	           PrintWriter out = response.getWriter();
	 	 	   out.print( "notYetSelectDesk" );
 	       }
 	 	   else
 	 		   response.sendRedirect( "/" );
 	       return false;
 	    }
    }
}
