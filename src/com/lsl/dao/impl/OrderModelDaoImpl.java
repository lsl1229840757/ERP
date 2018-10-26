package com.lsl.dao.impl;

import org.apache.commons.lang3.StringUtils;

import com.lsl.dao.OrderModelDao;
import com.lsl.model.OrderModel;
import com.lsl.query.OrderModelQuery;

public class OrderModelDaoImpl extends BaseDaoImpl<OrderModel, OrderModelQuery> implements OrderModelDao {

	@Override
	public String getHql(OrderModelQuery q) {
		String hql = "from OrderModel d where 1=1";
		hql = createHqlCondition(hql, q);
		return hql;
	}

	@Override
	public String getHqlCount(OrderModelQuery q) {
		String hql = "select count(d.orderId) from OrderModel d where 1=1";
		hql  = createHqlCondition(hql, q);
		return hql;
	}

	@Override
	public String createHqlCondition(String hql, OrderModelQuery q) {
		if(q.getOrderType() != null){
			hql += " and d.orderType = :orderType";
		}
		
		if(StringUtils.isNotBlank(q.getCreatorName())){
			hql += " and d.creatorEmp.name like :creatorName";
		}
		if(q.getMinTotalNum() != null){
			hql += " and d.totalNum >= :minTotalNum";
		
		}
		if(q.getMaxTotalNum() != null){
			hql += " and d.totalNum <= :maxTotalNum";
		}
		if(q.getMinCreateTime() != null){
			hql += " and d.createTime >= :minCreateTime";
		}
		
		if(q.getMaxCreateTime() != null){
			hql += " and d.createTime <= :maxCreateTime";
		}
		if(q.getMaxTotalPrice() != null){
			hql += " and d.totalPrice <= :maxTotalPrice";
		}
		if(q.getMinTotalPrice() != null){
			hql += " and d.totalPrice >= :minTotalPrice";
		}
		if(q.getOrderType() != null){
			hql += " and d.orderType = :orderType";
		}
		if(q.getOrderState() != null){
			hql += " and d.orderState = :orderState";
		}
		if(q.getSupplierId()!= null){
			hql += " and d.supplier.supplierId = :supplierId";
		}
		if(q.getOrderState()!=null){
			hql += " and d.orderState = :orderState";
		}
		return hql;
	}

}
