package com.entor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.entor.dao.OrderDao;
import com.entor.entity.Order;
import com.entor.service.OrderService;
@Repository("orderService")
public class OrderServiceImpl implements OrderService{
	
	@Resource
	private OrderDao orderDao;
	@Override
	public void add(Order t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order queryById(int id) {
		// TODO Auto-generated method stub
		return orderDao.queryById(id);
	}

	@Override
	public List<Order> queryByPage(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return orderDao.queryByPage(currentPage, pageSize);
	}

	@Override
	public int getTotals() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Order c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> queryAll() {
		// TODO Auto-generated method stub
		return orderDao.queryAll();
	}

}
