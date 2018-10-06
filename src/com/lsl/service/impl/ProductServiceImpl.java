package com.lsl.service.impl;

import com.lsl.dao.ProductDao;
import com.lsl.model.Product;
import com.lsl.query.ProductQuery;
import com.lsl.service.ProductService;

public class ProductServiceImpl extends BaseServiceImpl<Product, ProductQuery> implements ProductService {

	private ProductDao productDao;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
		//当我们使用公用的dao的时候必须要一个具体的dao赋值给baseDao
		this.baseDao = productDao;
	}
}
