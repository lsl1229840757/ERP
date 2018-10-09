package com.lsl.controller;
import com.lsl.query.OrderModelQuery;
import com.lsl.service.OrderModelService;
import com.lsl.utils.Page;
import com.opensymphony.xwork2.ActionContext;

public class OrderModelAction extends BaseAction {

	private OrderModelService orderModelService;
	
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
		return super.SUCCESS;
	}
}
