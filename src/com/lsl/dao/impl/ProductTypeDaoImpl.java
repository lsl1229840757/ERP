package com.lsl.dao.impl;

import org.apache.commons.lang3.StringUtils;

import com.lsl.dao.ProductTypeDao;
import com.lsl.model.ProductType;
import com.lsl.query.ProductTypeQuery;

public class ProductTypeDaoImpl extends BaseDaoImpl<ProductType, ProductTypeQuery> implements ProductTypeDao {

	@Override
	public String getHql(ProductTypeQuery q) {
		String hql = "from ProductType d where 1=1";
		hql = createHqlCondition(hql, q);
		return hql;
	}

	@Override
	public String getHqlCount(ProductTypeQuery q) {
		String hql = "select count(d.productTypeId)from ProductType d where 1=1";
		hql = createHqlCondition(hql, q);
		return hql;
	}

	@Override
	public String createHqlCondition(String hql, ProductTypeQuery q) {
		// 这里用这个类的supplierId直接判断 ，而不使用supplier.supplierId是为了防止空指针异常,还有之后的动态设置参数
		if(StringUtils.isNotBlank(q.getName())){
			hql += " and d.name like :name";
		}
		if(q.getSupplierId() != null){
			hql += " and d.supplier.supplierId = :supplierId";
		}
		return hql;
	}

}
