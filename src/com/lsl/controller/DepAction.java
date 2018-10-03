package com.lsl.controller;
import com.lsl.query.DepQuery;
import com.lsl.service.DepService;
import com.lsl.utils.Page;
import com.opensymphony.xwork2.ActionContext;

public class DepAction extends BaseAction {

	private DepService depService;
	/*
	 * �������Ҫ�ṩset��������ʵ��ע��
	 */
	public void setDepService(DepService depService) {
		this.depService = depService;
	}
	/**
	 * һ��Ҫ��ʵ��������ֹ��ָ���쳣
	 */
	private DepQuery query = new DepQuery();
	
	public void setQuery(DepQuery query) {
		this.query = query;
	}
	/*
	 * ���ﲻ�ṩget�����ᵼ����Щֵȡ����
	 */
	public DepQuery getQuery() {
		return query;
	}
	
	public String dep_list(){
		if(query.getPageNum()==null||query.getPageNum()<=0){
			query.setPageNum(1);
		}
		//չʾ�����б�
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
