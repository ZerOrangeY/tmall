package com.entor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.entor.dao.PropertyDao;
import com.entor.entity.Property;
import com.entor.service.PropertyService;
@Repository("propertyService")
public class PropertyServiceImpl implements PropertyService{
	@Resource
	private PropertyDao propertyDao;
	@Override
	public void add(Property t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Property> queryById(int id) {
		// TODO Auto-generated method stub
		return propertyDao.queryById(id);
	}

	@Override
	public List<Property> queryByPage(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotals() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Property c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Property> queryAll() {
		// TODO Auto-generated method stub
		return propertyDao.queryAll();
	}

	@Override
	public void deleteByCid(int cid) {
		propertyDao.deleteByCid(cid);
		
	}

}
