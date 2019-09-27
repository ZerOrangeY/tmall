package com.entor.dao;

import java.util.List;
import java.util.Map;

import com.entor.entity.Category;
import com.entor.entity.ProductImage;

public interface ProductImageDao {
	/**
	 * 新增
	 * @param t
	 */
	public void add(ProductImage t);
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
	public ProductImage queryById(int id);
	/**
	 * 根据主键pid查询图片
	 * @param String 模糊查询名称
	 * @param Integer pid
	 * @return
	 */
	public List<ProductImage> queryByPid(Map<String,String> map);
	/**
	 * 分页查询
	 * @param cls
	 * @param map
	 * @return
	 */
	public List<ProductImage> queryByPage(int currentPage,int pageSize);
	/**
	 * 查询总记录数
	 * @param cls
	 * @return
	 */
	public int getTotals();
	/**
	 * 更新数据
	 */
	public void update(ProductImage c);
	/**
	 * 根据类型查询所有记录
	 */
	public List<ProductImage> queryAll();
}
