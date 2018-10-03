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
		// ������������supplierIdֱ���ж� ������ʹ��supplier.supplierId��Ϊ�˷�ֹ��ָ���쳣,����֮��Ķ�̬���ò���
		if(StringUtils.isNotBlank(q.getName())){
			hql += " and d.name like :name";
		}
		if(q.getSupplierId() != null){
			hql += " and d.supplier.supplierId = :supplierId";
		}
		return hql;
	}

}
