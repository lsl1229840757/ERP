package com.lsl.controller;
import com.lsl.query.RoleQuery;
import com.lsl.service.RoleService;
import com.lsl.utils.Page;
import com.opensymphony.xwork2.ActionContext;

public class RoleAction extends BaseAction {

	private RoleService roleService;
	/*
	 * 这里必须要提供set方法才能实现注入
	 */
	public void setroleService(RoleService roleService) {
		this.roleService = roleService;
	}
	/**
	 * 一定要先实例化，防止空指针异常
	 */
	private RoleQuery query = new RoleQuery();
	
	public void setQuery(RoleQuery query) {
		this.query = query;
	}
	/*
	 * 这里不提供get方法会导致有些值取不到
	 */
	public RoleQuery getQuery() {
		return query;
	}
	
	public String role_list(){
		if(query.getPageNum()==null||query.getPageNum()<=0){
			query.setPageNum(1);
		}
		//展示部门列表
		Page page = roleService.queryObjByCondition(query, super.exclude);
		ActionContext.getContext().put("page", page);
		return super.SUCCESS;
	}

	public String role_input(){
		return super.SUCCESS;
	}

	public String role_changePwd(){
		return super.SUCCESS;
	}
}
