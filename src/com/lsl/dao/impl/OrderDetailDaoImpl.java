package com.lsl.dao.impl;

import org.apache.commons.lang3.StringUtils;

import com.lsl.dao.OrderDetailDao;
import com.lsl.model.OrderDetail;
import com.lsl.query.OrderDetailQuery;

public class OrderDetailDaoImpl extends BaseDaoImpl<OrderDetail, OrderDetailQuery> implements OrderDetailDao {

	@Override
	public String getHql(OrderDetailQuery q) {
		String hql = "from OrderDetail d where 1=1";
	
		return hql;
	}

	@Override
	public String getHqlCount(OrderDetailQuery q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createHqlCondition(String hql, OrderDetailQuery q) {
		// TODO Auto-generated method stub
		return null;
	}

}
