package com.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.dao.CategoryDao;
import com.entor.entity.Category;
import com.entor.service.CategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class Test01 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CategoryService cService = (CategoryService) context.getBean("categoryService");
		
		
		PageHelper.startPage(2, 3);
		List<Category> list = cService.queryAll();
        //取记录总条数
        PageInfo<Category> page = new PageInfo<>(list); 
		
        System.out.println("分页"+page.getTotal());
		for (Category category : list) {
			System.out.println(category);
		}
		
		
	}
}
