package com.lsl.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.lsl.utils.ERPConstant;

public class OrderStateTag extends TagSupport {
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
				switch(orderState){
					case ERPConstant.ORDER_TYPE_BUY_AUDIT:
						text = ERPConstant.ORDER_TYPE_BUY_AUDIT_TEXT;
					case ERPConstant.ORDER_TYPE_BUY_AUDIT_REJECT:
						text = ERPConstant.ORDER_TYPE_BUY_AUDIT_REJECT_TEXT;
					case ERPConstant.ORDER_TYPE_BUY_AUDIT_PASS:
						text = ERPConstant.ORDER_TYPE_BUY_AUDIT_PASS_TEXT;
				}
				break;
			case ERPConstant.ORDER_TYPE_INSTOCK:
				switch(orderState){
					case ERPConstant.ORDER_TYPE_INSTOCK_WAIT:
						text = ERPConstant.ORDER_TYPE_INSTOCK_WAIT_TEXT;
						break;
					case ERPConstant.ORDER_TYPE_INSTOCK_INING:
						text = ERPConstant.ORDER_TYPE_INSTOCK_INING_TEXT;
						break;
					case ERPConstant.ORDER_TYPE_INSTOCK_FINISH:
						text = ERPConstant.ORDER_TYPE_INSTOCK_FINISH_TEXT;
						break;
				}
			case ERPConstant.ORDER_TYPE_TRANS:
				switch(orderState){
					case ERPConstant.ORDER_TYPE_TRANS_BUY:
						text = ERPConstant.ORDER_TYPE_TRANS_BUY_TEXT;
					case ERPConstant.ORDER_TYPE_TRANS_ASSGIN:
						text = ERPConstant.ORDER_TYPE_TRANS_ASSGIN_TEXT;
					case ERPConstant.ORDER_TYPE_TRANS_BUYING:
						text = ERPConstant.ORDER_TYPE_TRANS_BUYING_TEXT;
				}
			case ERPConstant.ORDER_TYPE_SALES:
				text = ERPConstant.ORDER_TYPE_SALES_TEXT;
		}
		try {
			out.write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}
}
