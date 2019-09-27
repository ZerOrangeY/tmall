package com.entor.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.entity.Category;
import com.entor.entity.Property;
import com.entor.service.CategoryService;
import com.entor.service.PropertyService;
import com.entor.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Controller
public class PropertyController {
	
	@Resource
	private PropertyService pService;
	@Resource
	private CategoryService cService;
	@RequestMapping("/admin_property_list")
	public String listCategory(HttpSession session,Page page,int cid) {
		System.out.println("到达listCategory");
		Category c = cService.queryById(cid);
		PageHelper.offsetPage(page.getStart(),page.getCount());
		List<Property> ps = pService.queryById(cid);
		
		int total = (int) new PageInfo<>(ps).getTotal();
	    page.setTotal(total);
	    page.setParam("&cid="+c.getId());
	    
	    System.out.println(page);
	    
	    session.setAttribute("c", c);
		session.setAttribute("ps", ps);
		session.setAttribute("page", page);
		return "admin/listProperty";
	}
}
