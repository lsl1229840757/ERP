package com.lsl.service;

import com.lsl.model.Emp;
import com.lsl.model.OrderModel;
import com.lsl.query.OrderModelQuery;

public interface OrderModelService extends BaseService<OrderModel, OrderModelQuery> {
	public boolean saveOrderMOdel(OrderModel order);
	public void updateAuditOrder(Emp checker,OrderModel order, String note);
}
