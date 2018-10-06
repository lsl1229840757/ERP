package com.lsl.utils;

public interface ERPConstant {

	/**
	 * 采购订单
	 */
	public static final String ORDER_TYPE_BUY = "1";
	public static final String ORDER_TYPE_BUY_TEXT = "采购单";
	
	
	//////////////////////////采购单状态START////////////////////////////
	
	public static final String ORDER_TYPE_BUY_AUDIT = "1";
	public static final String ORDER_TYPE_BUY_AUDIT_TEXT = "未审核";
	public static final String ORDER_TYPE_BUY_AUDIT_REJECT = "3";
	public static final String ORDER_TYPE_BUY_AUDIT_REJECT_TEXT = "审核不通过";
	public static final String ORDER_TYPE_BUY_AUDIT_PASS = "2";
	public static final String ORDER_TYPE_BUY_AUDIT_PASS_TEXT = "审核通过";
	//////////////////////////采购单状态END////////////////////////////
	/**
	 * 运输单
	 */
	public static final String ORDER_TYPE_TRANS = "2";
	public static final String ORDER_TYPE_TRANS_TEXT = "运输单";
	//////////////////////////运输单状态START////////////////////////////
		
	public static final String ORDER_TYPE_TRANS_BUY = "1";
	public static final String ORDER_TYPE_TRANS_BUY_TEXT = "待采购";
	public static final String ORDER_TYPE_TRANS_ASSGIN = "2";
	public static final String ORDER_TYPE_TRANS_ASSGIN_TEXT = "派送单";
	public static final String ORDER_TYPE_TRANS_BUYING = "3";
	public static final String ORDER_TYPE_TRANS_BUYING_TEXT = "取货中";
	//////////////////////////采购单状态END////////////////////////////
	
	/**
	 * 入库单
	 */
	public static final String ORDER_TYPE_INSTOCK = "3";
	public static final String ORDER_TYPE_INSTOCK_TEXT = "入库单";
	
	//////////////////////////入库单状态START////////////////////////////
		
	public static final String ORDER_TYPE_INSTOCK_WAIT = "1";
	public static final String ORDER_TYPE_INSTOCK_WAIT_TEXT = "待入库";
	public static final String ORDER_TYPE_INSTOCK_INING = "2";
	public static final String ORDER_TYPE_INSTOCK_INING_TEXT = "入库中";
	public static final String ORDER_TYPE_INSTOCK_FINISH = "3";
	public static final String ORDER_TYPE_INSTOCK_FINISH_TEXT = "入库完成";
	//////////////////////////入库单状态END////////////////////////////
	
	
	/**
	 * 销售单
	 */
	public static final String ORDER_TYPE_SALES = "4";
	public static final String ORDER_TYPE_SALES_TEXT = "销售单";

}
