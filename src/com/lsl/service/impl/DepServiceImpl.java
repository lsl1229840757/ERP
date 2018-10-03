package com.lsl.service.impl;

import com.lsl.dao.DepDao;
import com.lsl.model.Dep;
import com.lsl.query.DepQuery;
import com.lsl.service.DepService;

public class DepServiceImpl extends BaseServiceImpl<Dep, DepQuery> implements DepService {

	private DepDao depDao;
	
	public void setDepDao(DepDao depDao) {
		this.depDao = depDao;
		//������ʹ�ù��õ�dao��ʱ�����Ҫһ�������dao��ֵ��baseDao
		this.baseDao = depDao;
	}
}
