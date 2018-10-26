package com.lsl.service.impl;

import com.lsl.dao.OrderDetailDao;
import com.lsl.model.OrderDetail;
import com.lsl.query.OrderDetailQuery;
import com.lsl.service.OrderDetailService;

public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetail, OrderDetailQuery> implements OrderDetailService {

	private OrderDetailDao orderDetailDao;
	
	public void setOrderDetailDao(OrderDetailDao orderDetailDao) {
		this.orderDetailDao = orderDetailDao;
		//当我们使用公用的dao的时候必须要一个具体的dao赋值给baseDao
		this.baseDao = orderDetailDao;
	}
}
