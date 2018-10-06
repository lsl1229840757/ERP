package com.lsl.service.impl;

import com.lsl.dao.ProductDao;
import com.lsl.model.Product;
import com.lsl.query.ProductQuery;
import com.lsl.service.ProductService;

public class ProductServiceImpl extends BaseServiceImpl<Product, ProductQuery> implements ProductService {

	private ProductDao productDao;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
		//������ʹ�ù��õ�dao��ʱ�����Ҫһ�������dao��ֵ��baseDao
		this.baseDao = productDao;
	}
}
