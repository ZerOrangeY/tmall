package com.entor.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;

import com.entor.dao.UserDao;
import com.entor.entity.Product;
import com.entor.entity.User;
import com.entor.service.UserService;

@Repository("userService")
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDao userDao;

	@Override
	public void add(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User queryById(int id) {
		// TODO Auto-generated method stub
		return userDao.queryById(id);
	}

	@Override
	public List<User> queryByPage(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return userDao.queryByPage(currentPage, pageSize);
	}

	@Override
	public int getTotals() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(User c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		return userDao.queryAll();
	}
	
}
