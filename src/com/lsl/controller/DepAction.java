package com.lsl.controller;
import com.lsl.query.DepQuery;
import com.lsl.service.DepService;
import com.lsl.utils.Page;
import com.opensymphony.xwork2.ActionContext;

public class DepAction extends BaseAction {

	private DepService depService;
	/*
	 * 这里必须要提供set方法才能实现注入
	 */
	public void setDepService(DepService depService) {
		this.depService = depService;
	}
	/**
	 * 一定要先实例化，防止空指针异常
	 */
	private DepQuery query = new DepQuery();
	
	public void setQuery(DepQuery query) {
		this.query = query;
	}
	/*
	 * 这里不提供get方法会导致有些值取不到
	 */
	public DepQuery getQuery() {
		return query;
	}
	
	public String dep_list(){
		if(query.getPageNum()==null||query.getPageNum()<=0){
			query.setPageNum(1);
		}
		//展示部门列表
		Page page = depService.queryObjByCondition(query, super.exclude);
		ActionContext.getContext().put("page", page);
		return super.SUCCESS;
	}

	public String Dep_input(){
		return super.SUCCESS;
	}

	public String Dep_changePwd(){
		return super.SUCCESS;
	}
}
