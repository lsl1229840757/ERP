package com.lsl.dao.impl;

import org.apache.commons.lang3.StringUtils;

import com.lsl.dao.SupplierDao;
import com.lsl.model.Supplier;
import com.lsl.query.SupplierQuery;

public class SupplierDaoImpl extends BaseDaoImpl<Supplier, SupplierQuery> implements SupplierDao {

	@Override
	public String getHql(SupplierQuery q) {
		String hql = "from Supplier d where 1=1";
		hql = createHqlCondition(hql, q);
		return hql;
	}

	@Override
	public String getHqlCount(SupplierQuery q) {
		String hql = "select count(d.supplierId) where 1 = 1";
		hql = createHqlCondition(hql, q);
		return hql;
	}

	@Override
	public String createHqlCondition(String hql, SupplierQuery q) {
		return null;
	}

}
