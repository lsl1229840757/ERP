package com.lsl.dao.impl;

import org.apache.commons.lang3.StringUtils;

import com.lsl.dao.ProductTypeDao;
import com.lsl.model.ProductType;
import com.lsl.query.ProductTypeQuery;

public class ProductTypeDaoImpl extends BaseDaoImpl<ProductType, ProductTypeQuery> implements ProductTypeDao {

	@Override
	public String getHql(ProductTypeQuery q) {
		String hql = "from ProductType d where 1=1";
	
		return hql;
	}

	@Override
	public String getHqlCount(ProductTypeQuery q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createHqlCondition(String hql, ProductTypeQuery q) {
		// TODO Auto-generated method stub
		return null;
	}

}
