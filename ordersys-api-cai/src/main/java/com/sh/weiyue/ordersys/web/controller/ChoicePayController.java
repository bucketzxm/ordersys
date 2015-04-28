package com.sh.weiyue.ordersys.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChoicePayController {
	@RequestMapping("choicePay")
    public String choicePay( Model model )
	{
		return "choicePay";//选择支付方式的页面
	}
}
