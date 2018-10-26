package com.lsl.service.impl;

import com.lsl.dao.OrderDetailDao;
import com.lsl.model.OrderDetail;
import com.lsl.query.OrderDetailQuery;
import com.lsl.service.OrderDetailService;

public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetail, OrderDetailQuery> implements OrderDetailService {

	private OrderDetailDao orderDetailDao;
	
	public void setOrderDetailDao(OrderDetailDao orderDetailDao) {
		this.orderDetailDao = orderDetailDao;
		//������ʹ�ù��õ�dao��ʱ�����Ҫһ�������dao��ֵ��baseDao
		this.baseDao = orderDetailDao;
	}
}
