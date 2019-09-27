package com.entor.dao;

import java.util.List;

import com.entor.entity.Property;
import com.entor.entity.PropertyValue;

public interface PropertyValueDao{
	/**
	 * 新增
	 * @param t
	 */
	public void add(PropertyValue t);
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
	public List<PropertyValue> queryById(int cid);
	/**
	 * 根据主键查询角色
	 * @param cls
	 * @param id
	 * @return
	 */
	public List<PropertyValue> queryByPid(int pid);
	/**
	 * 分页查询
	 * @param cls
	 * @param map
	 * @return
	 */
	public List<PropertyValue> queryByPage(int currentPage,int pageSize);
	/**
	 * 查询总记录数
	 * @param cls
	 * @return
	 */
	public int getTotals();
	/**
	 * 更新数据
	 */
	public void update(PropertyValue c);
	/**
	 * 根据类型查询所有记录
	 */
	public List<PropertyValue> queryAll();
}
