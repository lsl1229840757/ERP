package com.lsl.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import com.lsl.dao.ConsoleLogDao;
import com.lsl.dao.OrderModelDao;
import com.lsl.model.ConsoleLog;
import com.lsl.model.Emp;
import com.lsl.model.OrderModel;
import com.lsl.query.OrderModelQuery;
import com.lsl.service.OrderModelService;

public class OrderModelServiceImpl extends BaseServiceImpl<OrderModel, OrderModelQuery> implements OrderModelService {

	private OrderModelDao orderModelDao;
	private ConsoleLogDao consoleLogDao;
	
	public ConsoleLogDao getConsoleLogDao() {
		return consoleLogDao;
	}

	public void setConsoleLogDao(ConsoleLogDao consoleLogDao) {
		this.consoleLogDao = consoleLogDao;
	}

	public OrderModelDao getOrderModelDao() {
		return orderModelDao;
	}

	public void setOrderModelDao(OrderModelDao orderModelDao) {
		this.orderModelDao = orderModelDao;
		//当我们使用公用的dao的时候必须要一个具体的dao赋值给baseDao
		this.baseDao = orderModelDao;
	}
	
	public boolean saveOrderMOdel(OrderModel order){
		if(order!=null){
			orderModelDao.saveObj(order);
			return true;
		}
		return false;
	}

	@Override
	public void updateAuditOrder(Emp checker,OrderModel order, String note) {
		OrderModel order1 = orderModelDao.getObjById(order.getOrderId());
		order1.setOrderState(order.getOrderState());
		order1.setCheckTime(new Date());
		order1.setCheckEmp(checker);
		// 组装一个consol_log入库
		ConsoleLog cl = new ConsoleLog();
		cl.setChecker(checker);
		cl.setEntityId(order.getOrderId());
		cl.setNote(note);
		cl.setOptTime(new Timestamp(new Date().getTime()));
		cl.setOptType("审核订单");
		cl.setTableName("order_model");
		consoleLogDao.saveObj(cl);
	}
}
