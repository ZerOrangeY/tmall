package com.entor.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;

import com.entor.dao.ProductDao;
import com.entor.entity.Product;
import com.entor.service.ProductService;
@Repository("productService")
public class ProductServiceImpl implements ProductService{
	@Resource
	private ProductDao productDao;
	@Override
	public void add(Product t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product queryById(int id) {
		// TODO Auto-generated method stub
		return productDao.queryById(id);
	}

	@Override
	public List<Product> queryByPage(int pageNum, int pageSize, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return productDao.queryByPage(pageNum, pageSize);
	}

	@Override
	public int getTotals() {
		// TODO Auto-generated method stub
		return productDao.getTotals();
	}

	@Override
	public void update(Product c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> queryAll() {
		// TODO Auto-generated method stub
		return productDao.queryAll();
	}

	@Override
	public void deleteByCid(int cid) {
		productDao.deleteByCid(cid);
		
	}

	@Override
	public List<Product> queryByCid(int cid) {
		// TODO Auto-generated method stub
		return productDao.queryByCid(cid);
	}

}
