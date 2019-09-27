package com.entor.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.entity.Category;
import com.entor.service.CategoryService;
import com.entor.service.ProductService;
import com.entor.service.PropertyService;
import com.entor.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;



@Controller
public class CategoryController {
	@Resource
	private CategoryService categoryService;
	@Resource
	private PropertyService propertyService;
	@Resource
	private ProductService productService;
	@RequestMapping("/admin_category_list")
	public String listCategory(HttpSession session,Page page) {
		
		PageHelper.offsetPage(page.getStart(),10);
		
		List<Category> cs = categoryService.queryAll();
		int total = (int) new PageInfo<>(cs).getTotal();
	    page.setTotal(total);

	    System.out.println(page);
	    
	    for (Category category : cs) {
			System.out.println(category);
		}
		session.setAttribute("cs", cs);
		session.setAttribute("page", page);
		return "admin/listCategory";
	}
	
	@RequestMapping("/admin_category_edit")
	public String editCategory(HttpSession session,int id) {
		
		Category c = categoryService.queryById(id);
		
	    System.out.println(c);
	    session.setAttribute("c", c);
		return "admin/editCategory";
	}
	
	@RequestMapping("/admin_category_delete")
	public String deleteCategory(HttpSession session,int id,Page page) {
		
		categoryService.deleteById(id);
		propertyService.deleteByCid(id);
		productService.deleteByCid(id);
	   
	    session.setAttribute("page",page);
		return "admin/listCategory";
	}
}
