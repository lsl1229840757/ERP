package com.lsl.dao;

import java.util.List;

/**
 * 
 * @author 李松廉
 *这是对公共的dao类的抽取
 * @param <T>,model类
 * @param <Q>,model的query类
 */

public interface BaseDao<T,Q> {

	public void saveObj(T t);
	
	public void updateObj(T t);
	
	public T getObjById(Integer id);
	
	public void deleteObjById(Integer id);

	public void deleteObj(T t);
	
	public List<T> queryObjByCondition(Q q,List<String> exclude);
	
	public Long queryObjCountByCondition(Q q,List<String> exclude);
	
	public List<T> list();

	
}
