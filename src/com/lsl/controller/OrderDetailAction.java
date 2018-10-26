package com.lsl.controller;
import com.lsl.query.OrderDetailQuery;
import com.lsl.service.OrderDetailService;
import com.lsl.utils.Page;
import com.opensymphony.xwork2.ActionContext;

public class OrderDetailAction extends BaseAction {

	private OrderDetailService orderDetailService;
	
	public void setOrderDetailService(OrderDetailService orderDetailService) {
		this.orderDetailService = orderDetailService;
	}
	
	private OrderDetailQuery query = new OrderDetailQuery();
	
	public void setQuery(OrderDetailQuery query) {
		this.query = query;
	}
	
	public OrderDetailQuery getQuery() {
		return query;
	}
	
	public String orderDetail_list(){
		if(query.getPageNum()==null||query.getPageNum()<=0){
			query.setPageNum(1);
		}
		
		Page page = orderDetailService.queryObjByCondition(query, super.exclude);
		
		ActionContext.getContext().put("page", page);
		
		return super.SUCCESS;
	}

	public String orderDetail_input(){
		return super.SUCCESS;
	}
}
