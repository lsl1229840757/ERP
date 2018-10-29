package com.lsl.controller;
import com.lsl.model.OrderModel;
import com.lsl.query.OrderModelQuery;
import com.lsl.service.OrderModelService;
import com.lsl.service.SupplierService;
import com.lsl.utils.Page;
import com.opensymphony.xwork2.ActionContext;

public class OrderModelAction extends BaseAction {
	
	private SupplierService supplierService;
	
	private OrderModel order = new OrderModel();

	private OrderModelService orderModelService;
	
	
	public SupplierService getSupplierService() {
		return supplierService;
	}

	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
	}

	public OrderModel getOrder() {
		return order;
	}

	public void setOrder(OrderModel order) {
		this.order = order;
	}

	public OrderModelService getOrderModelService() {
		return orderModelService;
	}

	public void setOrderModelService(OrderModelService orderModelService) {
		this.orderModelService = orderModelService;
	}
	
	private OrderModelQuery query = new OrderModelQuery();
	
	public void setQuery(OrderModelQuery query) {
		this.query = query;
	}
	
	public OrderModelQuery getQuery() {
		return query;
	}
	
	public String orderModel_list(){
		if(query.getPageNum()==null||query.getPageNum()<=0){
			query.setPageNum(1);
		}
		
		Page page = orderModelService.queryObjByCondition(query, super.exclude);
		
		ActionContext.getContext().put("page", page);
		
		return super.SUCCESS;
	}

	public String orderModel_input(){
		ActionContext.getContext().put("suppliers", supplierService.list());
		return super.SUCCESS;
	}
	
	public String orderModel_orderDetails(){
		order = orderModelService.getObjById(query.getOrderId());
		return SUCCESS;
	}
	
}
