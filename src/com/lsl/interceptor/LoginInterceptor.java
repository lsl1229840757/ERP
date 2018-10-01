package com.lsl.interceptor;

import java.util.Map;

import com.lsl.controller.BaseAction;
import com.lsl.model.Emp;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//检验是否登录
		ActionContext context = invocation.getInvocationContext();
		Map<String, Object> session = context.getSession();
		// 这里其实可以写一个方法进行判断
		Emp emp = (Emp)session.get("user");
		if(emp != null){
			//验证通过
			return invocation.invoke();
		}else{
			return BaseAction.LOGIN;
		}
	}
}
