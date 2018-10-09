package com.lsl.service.impl;

import com.lsl.dao.OrderModelDao;
import com.lsl.model.OrderModel;
import com.lsl.query.OrderModelQuery;
import com.lsl.service.OrderModelService;

public class OrderModelServiceImpl extends BaseServiceImpl<OrderModel, OrderModelQuery> implements OrderModelService {

	private OrderModelDao orderModelDao;
	
	public void setOrderModelDao(OrderModelDao orderModelDao) {
		this.orderModelDao = orderModelDao;
		//当我们使用公用的dao的时候必须要一个具体的dao赋值给baseDao
		this.baseDao = orderModelDao;
	}
}
