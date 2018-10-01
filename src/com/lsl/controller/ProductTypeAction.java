package com.lsl.controller;
import java.util.List;

import com.lsl.model.Supplier;
import com.lsl.query.ProductTypeQuery;
import com.lsl.service.ProductTypeService;
import com.lsl.service.SupplierService;
import com.lsl.utils.Page;
import com.opensymphony.xwork2.ActionContext;

public class ProductTypeAction extends BaseAction {
	

	private ProductTypeService productTypeService;
	
	private SupplierService supplierService;
	
	public SupplierService getSupplierService() {
		return supplierService;
	}

	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
	}

	public ProductTypeService getProductTypeService() {
		return productTypeService;
	}

	public void setProductTypeService(ProductTypeService productTypeService) {
		this.productTypeService = productTypeService;
	}
	
	private ProductTypeQuery query = new ProductTypeQuery();
	
	public void setQuery(ProductTypeQuery query) {
		this.query = query;
	}
	
	public ProductTypeQuery getQuery() {
		return query;
	}
	
	public String productType_list(){
		if(query.getPageNum()==null||query.getPageNum()<=0){
			query.setPageNum(1);
		}
		List<Supplier> list = supplierService.list();
		ActionContext.getContext().put("list", list);
		Page page = productTypeService.queryObjByCondition(query, super.exclude);
		
		ActionContext.getContext().put("page", page);
		
		return super.SUCCESS;
	}

	public String ProductType_input(){
		return super.SUCCESS;
	}
}
