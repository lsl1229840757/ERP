package com.lsl.service.impl;

import com.lsl.dao.ProductTypeDao;
import com.lsl.model.ProductType;
import com.lsl.query.ProductTypeQuery;
import com.lsl.service.ProductTypeService;

public class ProductTypeServiceImpl extends BaseServiceImpl<ProductType, ProductTypeQuery> implements ProductTypeService {

	private ProductTypeDao productTypeDao;
	
	public void setProductTypeDao(ProductTypeDao productTypeDao) {
		this.productTypeDao = productTypeDao;
		//当我们使用公用的dao的时候必须要一个具体的dao赋值给baseDao
		this.baseDao = productTypeDao;
	}

	@Override
	public ProductType getProductTypeBySupplierId(ProductType pt) {
		return productTypeDao.getProductTypeBySupplierId(pt);
	}
}
