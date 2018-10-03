package com.lsl.service.impl;

import com.lsl.dao.SupplierDao;
import com.lsl.model.Supplier;
import com.lsl.query.SupplierQuery;
import com.lsl.service.SupplierService;

public class SupplierServiceImpl extends BaseServiceImpl<Supplier, SupplierQuery> implements SupplierService {

	private SupplierDao supplierDao;
	
	public void setSupplierDao(SupplierDao supplierDao) {
		this.supplierDao = supplierDao;
		//������ʹ�ù��õ�dao��ʱ�����Ҫһ�������dao��ֵ��baseDao
		this.baseDao = supplierDao;
	}
}
