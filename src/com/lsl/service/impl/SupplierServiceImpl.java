package com.lsl.service.impl;

import com.lsl.dao.SupplierDao;
import com.lsl.model.Supplier;
import com.lsl.query.SupplierQuery;
import com.lsl.service.SupplierService;

public class SupplierServiceImpl extends BaseServiceImpl<Supplier, SupplierQuery> implements SupplierService {

	private SupplierDao supplierDao;
	
	public void setSupplierDao(SupplierDao supplierDao) {
		this.supplierDao = supplierDao;
		//当我们使用公用的dao的时候必须要一个具体的dao赋值给baseDao
		this.baseDao = supplierDao;
	}
}
