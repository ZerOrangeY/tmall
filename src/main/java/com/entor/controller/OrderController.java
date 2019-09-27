package com.entor.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.entity.Order;
import com.entor.entity.User;
import com.entor.service.OrderService;
import com.entor.service.UserService;
import com.entor.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Controller
public class OrderController {
	@Resource
	private OrderService oService;
	
	@RequestMapping("/admin_order_list")
	public String listOrder(HttpSession session,Page page) {
		
		PageHelper.offsetPage(page.getStart(),10);
		
		List<Order> os = oService.queryAll();
		int total = (int) new PageInfo<>(os).getTotal();
	    page.setTotal(total);

	    System.out.println(page);
	    
	    for (Order o : os) {
			System.out.println(o);
		}
		session.setAttribute("os", os);
		session.setAttribute("page", page);
		return "admin/listOrder";
	}
}
