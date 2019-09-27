package com.entor.dao;

import java.util.List;


import com.entor.entity.Product;

public interface ProductDao {
	/**
	 * 新增
	 * @param t
	 */
	public void add(Product t);
	/**
	 * 根据对象类型 ,id 删除
	 * @param cls
	 * @param id
	 */
	public void deleteById(int cid);
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
	public Product queryById(int id);
	/**
	 * 根据主键查询角色
	 * @param cls
	 * @param id
	 * @return
	 */
	public List<Product> queryByCid(int cid);
	/**
	 * 根据主键查询角色
	 * @param cls
	 * @param id
	 * @return
	 */
	public List<Product> queryByWord(String keyWord);
	/**
	 * 分页查询
	 * @param cls
	 * @param map
	 * @return
	 */
	public List<Product> queryByPage(int currentPage,int pageSize);
	/**
	 * 查询总记录数
	 * @param cls
	 * @return
	 */
	public int getTotals();
	/**
	 * 更新数据
	 */
	public void update(Product c);
	/**
	 * 根据类型查询所有记录
	 */
	public List<Product> queryAll();
}
