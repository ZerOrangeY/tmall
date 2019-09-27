package com.entor.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;

import com.entor.dao.CategoryDao;
import com.entor.entity.Category;
import com.entor.service.CategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Repository("categoryService")
public class CategoryServiceImpl implements CategoryService{
	@Resource
	private CategoryDao categoryDao;

	@Override
	public void add(Category t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category queryById(int id) {
		// TODO Auto-generated method stub
		return categoryDao.queryById(id);
	}

	@Override
	public List<Category> queryByPage(int pageNum,int pageSize,HttpServletRequest request) {
		PageHelper.startPage(pageNum,pageSize);
		List<Category> list = categoryDao.queryAll();
        //取记录总条数
        PageInfo<Category> page = new PageInfo<>(list); 
		
        System.out.println("总记录"+page.getTotal());
		for (Category category : list) {
			System.out.println(category);
		}
		request.setAttribute("page", page);
		return list;
	}

	@Override
	public int getTotals() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Category c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Category> queryAll() {
		// TODO Auto-generated method stub
		
		return categoryDao.queryAll();
	}
	
}
