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
		//�����Ƿ��¼
		ActionContext context = invocation.getInvocationContext();
		Map<String, Object> session = context.getSession();
		// ������ʵ����дһ�����������ж�
		Emp emp = (Emp)session.get("user");
		if(emp != null){
			//��֤ͨ��
			return invocation.invoke();
		}else{
			return BaseAction.LOGIN;
		}
	}
}
