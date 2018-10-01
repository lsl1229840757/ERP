package com.lsl.service;

import java.util.List;

import com.lsl.utils.Page;

public interface BaseService<T,Q> {

	public void save(T t);
	
	public void update(T t);
	
	public T getObjById(Integer id);
	
	public void deleteObjById(Integer id);
	
	public Page queryObjByCondition(Q q,List<String> exclude);
	
	public List<T> list();
	
}
