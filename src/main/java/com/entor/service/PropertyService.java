package com.entor.service;

import java.util.List;

import com.entor.entity.Property;

public interface PropertyService{
	/**
	 * 新增
	 * @param t
	 */
	public void add(Property t);
	/**
	 * 根据对象类型 ,id 删除
	 * @param cls
	 * @param id
	 */
	public void deleteById(int id);
	/**
	 * 根据对象类型 ,cid 删除
	 * @param cls
	 * @param id
	 */
	public void deleteByCid(int cid);
	/**
	 * 根据主键查询角色
	 * @param cls
	 * @param id
	 * @return
	 */
	public List<Property> queryById(int id);
	/**
	 * 分页查询
	 * @param cls
	 * @param map
	 * @return
	 */
	public List<Property> queryByPage(int currentPage,int pageSize);
	/**
	 * 查询总记录数
	 * @param cls
	 * @return
	 */
	public int getTotals();
	/**
	 * 更新数据
	 */
	public void update(Property c);
	/**
	 * 根据类型查询所有记录
	 */
	public List<Property> queryAll();
}
