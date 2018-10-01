package com.lsl.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	public List<String> exclude = new ArrayList();
	
	public HttpServletRequest request;
	
	public HttpServletResponse response;
	
	public ServletContext application;
	
	public HttpSession session;
	
	public String MAIN = "main";
	
	String LIST = "list";
	
	public BaseAction() {
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		application = ServletActionContext.getServletContext();
		session = request.getSession();
		exclude.add("startIndex");
		exclude.add("pageNum");
	}

}
