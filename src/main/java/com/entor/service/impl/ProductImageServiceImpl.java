package com.entor.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.entor.dao.ProductImageDao;
import com.entor.entity.ProductImage;
import com.entor.service.ProductImageService;
@Repository("productImageService")
public class ProductImageServiceImpl implements ProductImageService{
	
	@Resource
	private ProductImageDao proImageDao;
	@Override
	public void add(ProductImage t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductImage queryById(int id) {
		// TODO Auto-generated method stub
		return proImageDao.queryById(id);
	}

	@Override
	public List<ProductImage> queryByPage(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return proImageDao.queryByPage(currentPage, pageSize);
	}

	@Override
	public int getTotals() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(ProductImage c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductImage> queryAll() {
		// TODO Auto-generated method stub
		return proImageDao.queryAll();
	}

	@Override
	public List<ProductImage> queryByPid(Map<String, String> map) {
		// TODO Auto-generated method stub
		return proImageDao.queryByPid(map);
	}


}
