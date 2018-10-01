package com.lsl.service.impl;

import java.lang.reflect.Field;
import java.util.List;


import com.lsl.dao.BaseDao;
import com.lsl.service.BaseService;
import com.lsl.utils.Page;

public class BaseServiceImpl<T,Q> implements BaseService<T,Q> {

	public BaseDao<T,Q> baseDao;
	
	@Override
	public void save(T t) {
		baseDao.saveObj(t);
	}

	@Override
	public void update(T t) {
		baseDao.updateObj(t);
	}

	@Override
	public T getObjById(Integer id) {
		return baseDao.getObjById(id);
	}

	@Override
	public void deleteObjById(Integer id) {
		baseDao.deleteObjById(id);
	}


	@Override
	public List<T> list(){
		return baseDao.list();
	}

	@Override
	public Page queryObjByCondition(Q q, List<String> exclude) {
		Page page = new Page();
		//获得查询对象的pageNum
		Class<? extends Object> class1 = q.getClass();
		Integer pageNum = 1;
		try {
			//这里计算出startIndex
			Field field = class1.getDeclaredField("pageNum");
			field.setAccessible(true);
			pageNum = (Integer) field.get(q);
			page.setPageNum(pageNum);
			Integer startIndex = page.getStartIndex();
			//给Q对象设置startIndex
			Field startIndexField = class1.getDeclaredField("startIndex");
			startIndexField.setAccessible(true);
			startIndexField.set(q, startIndex);
			//查询结果集
			List<T> list = baseDao.queryObjByCondition(q, exclude);
			//把结果集设置给page对象
			page.setList(list);
			Long totalcount = baseDao.queryObjCountByCondition(q, exclude);
			page.setTotalCount(new Integer(totalcount+""));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}
	
}
