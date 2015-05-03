package com.sh.weiyue.ordersys.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ServerSentController {

	@RequestMapping("serverSent")
	public @ResponseBody  String sendMessage(HttpServletResponse response) throws IOException
	{
		Random r = new Random();
		response.setContentType("text/event-stream");
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		while(true)
		{
			try{
				double randomNumber = Math.random()*1000;
				out =  response.getWriter();
				out.print("data: +" + "time: " + Calendar.getInstance().getTime()+"\n\n");
				
				try{
					response.flushBuffer();
					Thread.sleep((long)randomNumber);
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
	
	
}
