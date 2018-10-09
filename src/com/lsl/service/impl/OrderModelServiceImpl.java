package com.lsl.service.impl;

import com.lsl.dao.OrderModelDao;
import com.lsl.model.OrderModel;
import com.lsl.query.OrderModelQuery;
import com.lsl.service.OrderModelService;

public class OrderModelServiceImpl extends BaseServiceImpl<OrderModel, OrderModelQuery> implements OrderModelService {

	private OrderModelDao orderModelDao;
	
	public void setOrderModelDao(OrderModelDao orderModelDao) {
		this.orderModelDao = orderModelDao;
		//������ʹ�ù��õ�dao��ʱ�����Ҫһ�������dao��ֵ��baseDao
		this.baseDao = orderModelDao;
	}
}
