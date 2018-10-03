package com.lsl.service.impl;

import com.lsl.dao.ProductTypeDao;
import com.lsl.model.ProductType;
import com.lsl.query.ProductTypeQuery;
import com.lsl.service.ProductTypeService;

public class ProductTypeServiceImpl extends BaseServiceImpl<ProductType, ProductTypeQuery> implements ProductTypeService {

	private ProductTypeDao productTypeDao;
	
	public void setProductTypeDao(ProductTypeDao productTypeDao) {
		this.productTypeDao = productTypeDao;
		//������ʹ�ù��õ�dao��ʱ�����Ҫһ�������dao��ֵ��baseDao
		this.baseDao = productTypeDao;
	}

	@Override
	public ProductType getProductTypeBySupplierId(ProductType pt) {
		return productTypeDao.getProductTypeBySupplierId(pt);
	}
}
