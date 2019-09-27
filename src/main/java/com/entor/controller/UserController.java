package com.entor.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.entity.Category;
import com.entor.entity.User;
import com.entor.service.CategoryService;
import com.entor.service.UserService;
import com.entor.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Controller
public class UserController {
	@Resource
	private UserService uService;
	
	@RequestMapping("/admin_user_list")
	public String listCategory(HttpSession session,Page page) {
		
		PageHelper.offsetPage(page.getStart(),10);
		
		List<User> us = uService.queryAll();
		int total = (int) new PageInfo<>(us).getTotal();
	    page.setTotal(total);

	    System.out.println(page);
	    
	    for (User u : us) {
			System.out.println(u);
		}
		session.setAttribute("us", us);
		session.setAttribute("page", page);
		return "admin/listUser";
	}
}
