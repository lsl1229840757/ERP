package com.lsl.dao.impl;

import org.apache.commons.lang3.StringUtils;

import com.lsl.dao.ProductDao;
import com.lsl.model.Product;
import com.lsl.query.ProductQuery;

public class ProductDaoImpl extends BaseDaoImpl<Product, ProductQuery> implements ProductDao {

	@Override
	public String getHql(ProductQuery q) {
		String hql = "from Product d where 1=1 ";
		hql = createHqlCondition(hql, q)+" order by d.productId desc";
		return hql;
	}

	@Override
	public String getHqlCount(ProductQuery q) {
		String hql = "select count(d.productId) from Product d where 1 = 1";
		hql = createHqlCondition(hql, q);
		return hql;
	}

	@Override
	public String createHqlCondition(String hql, ProductQuery q) {
		if(q.getSupplierId() != null){
			hql += " and d.productType.supplier.supplierId = :supplierId";
		}		
		
		if(StringUtils.isNotBlank(q.getName())){
			hql += " and d.name like :name";
			
		}
		if(StringUtils.isNotBlank(q.getProducer())){
			hql += " and d.producer like :producer";
			
		}
		if(StringUtils.isNotBlank(q.getOrigin())){
			hql += " and d.origin like :origin";
		}
		if(StringUtils.isNotBlank(q.getUnit())){
			hql += " and d.unit like :unit";
		}
		if(q.getMaxInPrice()!= null){
			hql += " and d.inPrice <= :maxInPrice";
		}
		if(q.getMinInPrice() != null){
			hql += " and d.inPrice >= :minInPrice";
		}
		if(q.getMaxOutPrice() != null){
			hql += " and d.outPrice <= :maxOutPrice";
		}
		if(q.getMinOutPrice() != null){
			hql += " and d.outPrice >= :minOutPrice";
		}
		return hql;
	}

}
