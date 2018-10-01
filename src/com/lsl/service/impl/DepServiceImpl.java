package com.lsl.service.impl;

import com.lsl.dao.DepDao;
import com.lsl.model.Dep;
import com.lsl.query.DepQuery;
import com.lsl.service.DepService;

public class DepServiceImpl extends BaseServiceImpl<Dep, DepQuery> implements DepService {

	private DepDao depDao;
	
	public void setDepDao(DepDao depDao) {
		this.depDao = depDao;
		//当我们使用公用的dao的时候必须要一个具体的dao赋值给baseDao
		this.baseDao = depDao;
	}
}
