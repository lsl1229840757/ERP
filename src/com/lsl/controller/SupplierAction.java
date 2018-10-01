package com.lsl.controller;
import com.lsl.query.SupplierQuery;
import com.lsl.service.SupplierService;
import com.lsl.utils.Page;
import com.opensymphony.xwork2.ActionContext;

public class SupplierAction extends BaseAction {

	private SupplierService supplierService;
	
	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
	}
	
	private SupplierQuery query = new SupplierQuery();
	
	public void setQuery(SupplierQuery query) {
		this.query = query;
	}
	
	public SupplierQuery getQuery() {
		return query;
	}
	
	public String supplier_list(){
		if(query.getPageNum()==null||query.getPageNum()<=0){
			query.setPageNum(1);
		}
		
		Page page = supplierService.queryObjByCondition(query, super.exclude);
		
		ActionContext.getContext().put("page", page);
		
		return super.SUCCESS;
	}

	public String Supplier_input(){
		return super.SUCCESS;
	}

	public String Supplier_changePwd(){
		return super.SUCCESS;
	}
}
