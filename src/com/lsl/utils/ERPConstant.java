package com.lsl.utils;

public interface ERPConstant {

	/**
	 * �ɹ�����
	 */
	public static final String ORDER_TYPE_BUY = "1";
	public static final String ORDER_TYPE_BUY_TEXT = "�ɹ���";
	
	
	//////////////////////////�ɹ���״̬START////////////////////////////
	
	public static final String ORDER_TYPE_BUY_AUDIT = "1";
	public static final String ORDER_TYPE_BUY_AUDIT_TEXT = "δ���";
	public static final String ORDER_TYPE_BUY_AUDIT_REJECT = "3";
	public static final String ORDER_TYPE_BUY_AUDIT_REJECT_TEXT = "��˲�ͨ��";
	public static final String ORDER_TYPE_BUY_AUDIT_PASS = "2";
	public static final String ORDER_TYPE_BUY_AUDIT_PASS_TEXT = "���ͨ��";
	//////////////////////////�ɹ���״̬END////////////////////////////
	/**
	 * ���䵥
	 */
	public static final String ORDER_TYPE_TRANS = "2";
	public static final String ORDER_TYPE_TRANS_TEXT = "���䵥";
	//////////////////////////���䵥״̬START////////////////////////////
		
	public static final String ORDER_TYPE_TRANS_BUY = "1";
	public static final String ORDER_TYPE_TRANS_BUY_TEXT = "���ɹ�";
	public static final String ORDER_TYPE_TRANS_ASSGIN = "2";
	public static final String ORDER_TYPE_TRANS_ASSGIN_TEXT = "���͵�";
	public static final String ORDER_TYPE_TRANS_BUYING = "3";
	public static final String ORDER_TYPE_TRANS_BUYING_TEXT = "ȡ����";
	//////////////////////////�ɹ���״̬END////////////////////////////
	
	/**
	 * ��ⵥ
	 */
	public static final String ORDER_TYPE_INSTOCK = "3";
	public static final String ORDER_TYPE_INSTOCK_TEXT = "��ⵥ";
	
	//////////////////////////��ⵥ״̬START////////////////////////////
		
	public static final String ORDER_TYPE_INSTOCK_WAIT = "1";
	public static final String ORDER_TYPE_INSTOCK_WAIT_TEXT = "�����";
	public static final String ORDER_TYPE_INSTOCK_INING = "2";
	public static final String ORDER_TYPE_INSTOCK_INING_TEXT = "�����";
	public static final String ORDER_TYPE_INSTOCK_FINISH = "3";
	public static final String ORDER_TYPE_INSTOCK_FINISH_TEXT = "������";
	//////////////////////////��ⵥ״̬END////////////////////////////
	
	
	/**
	 * ���۵�
	 */
	public static final String ORDER_TYPE_SALES = "4";
	public static final String ORDER_TYPE_SALES_TEXT = "���۵�";

}
