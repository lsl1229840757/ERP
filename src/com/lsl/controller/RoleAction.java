package com.lsl.controller;
import com.lsl.query.RoleQuery;
import com.lsl.service.RoleService;
import com.lsl.utils.Page;
import com.opensymphony.xwork2.ActionContext;

public class RoleAction extends BaseAction {

	private RoleService roleService;
	
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	private RoleQuery query = new RoleQuery();
	
	public void setQuery(RoleQuery query) {
		this.query = query;
	}
	
	public RoleQuery getQuery() {
		return query;
	}
	
	public String role_list(){
		if(query.getPageNum()==null||query.getPageNum()<=0){
			query.setPageNum(1);
		}
		
		Page page = roleService.queryObjByCondition(query, super.exclude);
		
		ActionContext.getContext().put("page", page);
		
		return super.SUCCESS;
	}

	public String Role_input(){
		return super.SUCCESS;
	}

	public String Role_changePwd(){
		return super.SUCCESS;
	}
}
