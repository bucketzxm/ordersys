package com.sh.weiyue.ordersys.web.controller;

import javax.servlet.http.HttpServletRequest;

import com.alipay.config.*;
import com.alipay.util.*;
import com.sh.weiyue.ordersys.web.persistence.domain.Order;
import com.sh.weiyue.ordersys.web.persistence.repository.OrderRepository;
import com.sh.weiyue.ordersys.web.service.ShoppingCart;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

import com.alipay.config.*;
import com.alipay.util.*;

import java.util.HashMap;
import com.sh.weiyue.ordersys.web.persistence.repository.OrderRepository;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.data.repository.CrudRepository;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Controller
public class AliPayController {
	@Autowired
	private ShoppingCart shoppingCart;
	
	
	
//	post 一个 string 对象
	public static String strPost(String url, String jsonString) {
		HttpClient httpClient = new HttpClient();
		PostMethod method = null;
		String resultMsg = null;
		
		try {
			method = new PostMethod(url);
			method.getParams().setParameter(
					HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
			method.setRequestEntity(new StringRequestEntity(jsonString,
					"application/json", "UTF-8"));
			int statusCode = httpClient.executeMethod(method);
			if (statusCode == 200) {
				resultMsg = method.getResponseBodyAsString().trim();
			} else {
				System.out.println(method.getResponseBodyAsString().trim());
			}
		} catch (UnsupportedEncodingException e) {
		} catch (HttpException e) {
		} catch (IOException e) {
		} finally {
			method.releaseConnection();
		}
		return resultMsg;
	}
	
	@RequestMapping("confirmPayment")
	public String confirmPayment( Model model, HttpServletRequest request)
	{
		String url = "http://218.244.136.120:8080/alfred-api/thirdpartyPay/confirmPayment";
		
		String id ="207";
		HttpClient httpClient = new HttpClient();
		String result = null;
		PostMethod method = null;
		try{
			method = new PostMethod(url);
			
			method.addParameter("sysOrderId",id);

			method.addParameter("payType","A");
			
			method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
			
			int statusCode = httpClient.executeMethod(method);
			if (statusCode == 200) {
				// 获得返回串
				result = method.getResponseBodyAsString().trim();
				System.out.println(result);
			} else {
				System.out.println(method.getResponseBodyAsStream());
			}
		}catch (UnsupportedEncodingException e) {
		} catch (HttpException e) {
		} catch (IOException e) {
		} finally {
			method.releaseConnection();
		}
		return result;
	}
	
	public int deleteOrderByOutTradeNum(String out_trade_no){
		
		List<Order> orders = orderRepos.findAll();
		for(Order order: orders)
		{
			if (order.getOutTradeNo().equals(out_trade_no))
			{
				orderRepos.delete(order.getOrderId());
				shoppingCart.setOrderId(-1);
				return 1;
			}
		}
		// find order failed or anything else
		return -1;
	}
	@RequestMapping("deleteOrderByOutTradeNum")
	public String deleteOrderByOutTradeNum(HttpServletRequest request)
	{
		
		
		if (request.getMethod() == "GET"){
			Map<String,String[]> params = request.getParameterMap();
			String queryString = null;
			
			String out_trade_no = params.get("out_trade_no")[0];
			
			int  ret = deleteOrderByOutTradeNum(out_trade_no);
			return "home";
		}
		
		return "home";
	}
	
	@Autowired
	OrderRepository orderRepos;
	@RequestMapping("return_url")
	public String aliPayApiReturn(Model model, HttpServletRequest request){
		
		if (request.getMethod() == "GET")
		{
			Map<String, String[]> params =  request.getParameterMap();
			String queryString = null;
			//获取 out_trade_no
			
			String out_trade_no = params.get("out_trade_no")[0];
			//System.out.print(out_trade_no+"aaa");
			//删除对应的Order
			deleteOrderByOutTradeNum(out_trade_no);
			
			
//			Order order = orderRepos.findOne(out_trade_no);
//			for (String key : params.keySet()) {  
//	            String[] values = params.get(key);  
//	            for (int i = 0; i < values.length; i++) {  
//	                String value = values[i];  
//	                queryString += key + "=" + value + "&";  
//	            }  
//	        }  
//			model.addAttribute("queryString",out_trade_no);
		}
		return "return_url";
	}
	
	
	@RequestMapping( "alipayapi" )
    public String aliPayApi( Model model, HttpServletRequest request )
	{
		String ALIPAY_GATEWAY_NEW = "https://mapi.alipay.com/gateway.do?";
		
		//支付类型
		String payment_type = "1";
		//必填，不能修改
		//服务器异步通知页面路径
		String notify_url = "http://192.168.100.135:8088/notify_url.jsp";
		//需http://格式的完整路径，不能加?id=123这类自定义参数

		//页面跳转同步通知页面路径
		String return_url = "http://192.168.100.135:8088/return_url";
		//需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/
		//192.168.1.100

		//卖家支付宝帐户
		//String seller_email = new String(request.getParameter("WIDseller_email").getBytes("ISO-8859-1"),"UTF-8");
		String seller_email = "emma-xu319@163.com";
		
		//必填

		//商户订单号
		Order ord = shoppingCart.getOrder();
		String out_trade_no = ord.getOutTradeNo();
		//商户网站订单系统中唯一订单号，必填

		//订单名称
		String subject = "威悦餐饮";
		//必填

		//付款金额
		//String total_fee = new String(request.getParameter("WIDtotal_fee").getBytes("ISO-8859-1"),"UTF-8");
		String total_fee = shoppingCart.getTotalCost().toString();
		//必填
		
		//订单描述

		String body = "威悦账单";
		//商品展示地址
		String show_url = "";
		//需以http://开头的完整路径，例如：http://www.xxx.com/myorder.html

		//防钓鱼时间戳
		String anti_phishing_key = "";
		//若要使用请调用类文件submit中的query_timestamp函数

		//客户端的IP地址
		String exter_invoke_ip = "";
		//非局域网的外网IP地址，如：221.0.0.1	
		
		BigDecimal cost = shoppingCart.getTotalCost();
		BigDecimal rate = new BigDecimal(0.5);
		BigDecimal  profit = cost.multiply(rate).setScale(2,BigDecimal.ROUND_HALF_DOWN);
		String strProfit = profit.toString();
		
		String royalty_type = "10";
		String royalty_parameters = "469380879@qq.com^"+strProfit+"^ ";
		System.out.println(royalty_parameters);
		
		//////////////////////////////////////////////////////////////////////////////////
		
		//把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", "create_direct_pay_by_user");
        sParaTemp.put("partner", AlipayConfig.partner);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("payment_type", payment_type);
		sParaTemp.put("notify_url", notify_url);
		sParaTemp.put("return_url", return_url);
		sParaTemp.put("seller_email", seller_email);
		sParaTemp.put("out_trade_no", out_trade_no);
		sParaTemp.put("subject", subject);
		sParaTemp.put("total_fee", total_fee);
		sParaTemp.put("body", body);
		sParaTemp.put("show_url", show_url);
		sParaTemp.put("anti_phishing_key", anti_phishing_key);
		sParaTemp.put("exter_invoke_ip", exter_invoke_ip);
		sParaTemp.put("orderId", shoppingCart.getOrderId() + "" );
		sParaTemp.put("royalty_type", royalty_type);//提成类型，该值为固定值：10，不需要修改
        sParaTemp.put("royalty_parameters", royalty_parameters);//提成信息集
		
		//建立请求
		String apiHtmlText = AlipaySubmit.buildRequest(ALIPAY_GATEWAY_NEW,sParaTemp,"get","确认");
		model.addAttribute( "apiHtmlText", apiHtmlText );
		return "alipayapi";
	}
	
	@RequestMapping( "alipaywap" )
    public String aliPayWap( Model model, HttpServletRequest request )
	{
		//服务器异步通知页面路径
		String notify_url = "http://www.xxx.com/create_direct_pay_by_user-JAVA-UTF-8/notify_url.jsp";
		//需http://格式的完整路径，不能加?id=123这类自定义参数

		//卖家支付宝帐户
		//String seller_email = new String(request.getParameter("WIDseller_email").getBytes("ISO-8859-1"),"UTF-8");
		String seller_email = "emma-xu319@163.com";
		//必填

		//商户订单号
		String out_trade_no = new Date().toString();
		//商户网站订单系统中唯一订单号，必填

		//订单名称
		String subject = "威悦餐饮";
		//必填

		//付款金额
		//String total_fee = new String(request.getParameter("WIDtotal_fee").getBytes("ISO-8859-1"),"UTF-8");
		String total_fee = shoppingCart.getTotalCost().toString();
		//必填

		//订单描述
		//////////////////////////////////////////////////////////////////////////////////
		
		//支付宝网关地址
		String ALIPAY_GATEWAY_NEW = "http://wappaygw.alipay.com/service/rest.htm?";

		////////////////////////////////////调用授权接口alipay.wap.trade.create.direct获取授权码token//////////////////////////////////////
				
		//返回格式
		String format = "xml";
		//必填，不需要修改
				
		//返回格式
		String v = "2.0";
		//必填，不需要修改
				
		//请求号
		String req_id = UtilDate.getOrderNum();
		//必填，须保证每次请求都是唯一

		//页面跳转同步通知页面路径
		String call_back_url = "http://127.0.0.1:8080/WS_WAP_PAYWAP-JAVA-UTF-8/call_back_url.jsp";
		//需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/

		//操作中断返回地址
		String merchant_url = "http://127.0.0.1:8080/WS_WAP_PAYWAP-JAVA-UTF-8/xxxxxx.jsp";
		//用户付款中途退出返回商户的地址。需http://格式的完整路径，不允许加?id=123这类自定义参数s
				
		//请求业务参数详细
		String req_dataToken = "<direct_trade_create_req><notify_url>" + notify_url + "</notify_url><call_back_url>" + call_back_url + "</call_back_url><seller_account_name>" + seller_email + "</seller_account_name><out_trade_no>" + out_trade_no + "</out_trade_no><subject>" + subject + "</subject><total_fee>" + total_fee + "</total_fee><merchant_url>" + merchant_url + "</merchant_url></direct_trade_create_req>";
		//必填
				
		//////////////////////////////////////////////////////////////////////////////////
				
		//把请求参数打包成数组
		Map<String, String> sParaTempToken = new HashMap<String, String>();
		sParaTempToken.put("service", "alipay.wap.trade.create.direct");
		sParaTempToken.put("partner", AlipayConfig.partner);
		sParaTempToken.put("_input_charset", AlipayConfig.input_charset);
		sParaTempToken.put("sec_id", AlipayConfig.sign_type);
		sParaTempToken.put("format", format);
		sParaTempToken.put("v", v);
		sParaTempToken.put("req_id", req_id);
		sParaTempToken.put("req_data", req_dataToken);
				
		//建立请求
		String sHtmlTextToken = null;
		try {
			 sHtmlTextToken = AlipaySubmit.buildRequest(ALIPAY_GATEWAY_NEW,"", "",sParaTempToken);
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//URLDECODE返回的信息
		try {
			  sHtmlTextToken = URLDecoder.decode(sHtmlTextToken,AlipayConfig.input_charset);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取token
		String request_token = null;
		try {
			 request_token = AlipaySubmit.getRequestToken(sHtmlTextToken);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//out.println(request_token);
				
		////////////////////////////////////根据授权码token调用交易接口alipay.wap.auth.authAndExecute//////////////////////////////////////
				
		//业务详细
		String req_data = "<auth_and_execute_req><request_token>" + request_token + "</request_token></auth_and_execute_req>";
		//必填
				
		//把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", "alipay.wap.auth.authAndExecute");
		sParaTemp.put("partner", AlipayConfig.partner);
		sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("sec_id", AlipayConfig.sign_type);
		sParaTemp.put("format", format);
		sParaTemp.put("v", v);
		sParaTemp.put("req_data", req_data);
				
				//建立请求
		String wapHtmlText = AlipaySubmit.buildRequest(ALIPAY_GATEWAY_NEW, sParaTemp, "get", "确认");
		model.addAttribute( "wapHtmlText", wapHtmlText );
		return "alipaywap";
	}
	
	@RequestMapping( "alipaycode" )
    public String aliPayCode( Model model, HttpServletRequest request )
	{
		//接口调用时间
		String timestamp = UtilDate.getDateFormatter();
		//格式为：yyyy-MM-dd HH:mm:ss

		//动作
		String method = "add";
		//创建商品二维码
		//业务类型
		String biz_type = "1";
		//目前只支持1
		//业务数据
		String biz_data = new String("www.baidu.com");
		//格式：JSON 大字符串，详见技术文档4.2.1章节
		
		
		//////////////////////////////////////////////////////////////////////////////////
		
		//把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", "alipay.mobile.qrcode.manage");
        sParaTemp.put("partner", AlipayConfig.partner);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("timestamp", timestamp);
		sParaTemp.put("method", method);
		sParaTemp.put("biz_type", biz_type);
		sParaTemp.put("biz_data", biz_data);
		
		//建立请求
		String codeHtmlText = null;
		try {
			codeHtmlText = AlipaySubmitCode.buildRequest("", "", sParaTemp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute( "codeHtmlText", codeHtmlText );
		return "alipaycode";
	}
}
