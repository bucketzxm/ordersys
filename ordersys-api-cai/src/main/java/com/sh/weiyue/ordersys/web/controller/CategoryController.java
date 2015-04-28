package com.sh.weiyue.ordersys.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sh.weiyue.ordersys.web.persistence.domain.Category;
import com.sh.weiyue.ordersys.web.persistence.repository.CategoryRepository;

@Controller
public class CategoryController {
	@Autowired
	CategoryRepository cgRepo;
	@RequestMapping( "category" )
    public String home(Model model,HttpServletRequest request)
	{	
		List<Category> cgs = cgRepo.findAll();
		String cgPart="";	   
		for(int i = 0; i < cgs.size(); i++ ){
		   String cgName = cgs.get(i).getCategoryName();
	       int cgId = cgs.get(i).getCategoryId();
	       String cgPicture = cgs.get(i).getCategoryPicture();
	       
	       cgPart += "<li cgId='"+cgId+"'>"
			   + "<img src='"+cgPicture+"'>"
			   + "<div>"+cgName + "</div>"  
			+ "</li>";
		}
		model.addAttribute("cgPart",cgPart);
		return "category";
	}
}
