package com.lsl.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.lsl.utils.ERPConstant;

public class OrderTypeTag extends TagSupport {

	private String orderType;
	
	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
	private String orderState;
	
	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		String text = "";
		switch(orderType){
			case ERPConstant.ORDER_TYPE_BUY:
				text = ERPConstant.ORDER_TYPE_BUY_TEXT;
				break;
			case ERPConstant.ORDER_TYPE_INSTOCK:
				text = ERPConstant.ORDER_TYPE_INSTOCK_TEXT;
			case ERPConstant.ORDER_TYPE_TRANS:
				text = ERPConstant.ORDER_TYPE_TRANS_TEXT;
		}
		try {
			out.write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}
}
