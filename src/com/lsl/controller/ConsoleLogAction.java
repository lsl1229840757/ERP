package com.lsl.controller;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.lsl.model.ConsoleLog;
import com.lsl.query.ConsoleLogQuery;
import com.lsl.service.ConsoleLogService;
import com.lsl.utils.Page;
import com.opensymphony.xwork2.ActionContext;

public class ConsoleLogAction extends BaseAction {

	private ConsoleLogService consoleLogService;
	
	public void setConsoleLogService(ConsoleLogService consoleLogService) {
		this.consoleLogService = consoleLogService;
	}
	
	private ConsoleLogQuery query = new ConsoleLogQuery();
	
	public void setQuery(ConsoleLogQuery query) {
		this.query = query;
	}
	
	public ConsoleLogQuery getQuery() {
		return query;
	}
	
	public String consoleLog_list(){
		if(query.getPageNum()==null||query.getPageNum()<=0){
			query.setPageNum(1);
		}
		
		Page page = consoleLogService.queryObjByCondition(query, super.exclude);
		
		ActionContext.getContext().put("page", page);
		
		return super.SUCCESS;
	}

	public String consoleLog_input(){
		return super.SUCCESS;
	}
	
	public String consoleLog_consoleLog() throws UnsupportedEncodingException{
		//这里是对象的字符串，所以会出现中文乱码问题
		query.setOptType(new String(query.getOptType().getBytes("ISO-8859-1"),"utf-8"));
		List<ConsoleLog> list = consoleLogService.queryObjByConditionNoPage(query, super.exclude);
		ActionContext.getContext().put("logList", list);
		return SUCCESS;
	}
	
}
