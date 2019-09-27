package com.entor.dao;

import java.util.List;


import com.entor.entity.User;

public interface UserDao {
	/**
	 * 新增
	 * @param t
	 */
	public void add(User t);
	/**
	 * 根据对象类型 ,id 删除
	 * @param cls
	 * @param id
	 */
	public void deleteById(int id);
	/**
	 * 根据主键查询角色
	 * @param cls
	 * @param id
	 * @return
	 */
	public User queryById(int id);
	/**
	 * 根据主键查询角色
	 * @param cls
	 * @param id
	 * @return
	 */
	public User queryByUser(User user);
	/**
	 * 分页查询
	 * @param cls
	 * @param map
	 * @return
	 */
	public List<User> queryByPage(int currentPage,int pageSize);
	/**
	 * 查询总记录数
	 * @param cls
	 * @return
	 */
	public int getTotals();
	/**
	 * 更新数据
	 */
	public void update(User c);
	/**
	 * 根据类型查询所有记录
	 */
	public List<User> queryAll();
}
