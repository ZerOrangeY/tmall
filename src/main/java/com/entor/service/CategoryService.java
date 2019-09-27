package com.entor.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.entor.entity.Category;

public interface CategoryService {
	/**
	 * 新增
	 * @param t
	 */
	public void add(Category t);
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
	public Category queryById(int id);
	/**
	 * 分页查询
	 * @param cls
	 * @param map
	 * @return
	 */
	public List<Category> queryByPage(int pageNum,int pageSize,HttpServletRequest request);
	/**
	 * 查询总记录数
	 * @param cls
	 * @return
	 */
	public int getTotals();
	/**
	 * 更新数据
	 */
	public void update(Category c);
	/**
	 * 根据类型查询所有记录
	 */
	public List<Category> queryAll();
}
