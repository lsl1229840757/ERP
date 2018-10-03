package com.lsl.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.util.StrutsTypeConverter;

public class MyDateConverter extends StrutsTypeConverter {

	/**
	 * 
	 * @param context:��action�йص�������
	 * @param values�����յ��ַ�������
	 * @param toClass��������struts�ȸ���action��ȷ��toclass
	 * @return
	 */
	
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		Date date = null;
		if(StringUtils.isNotBlank(values[0])&&toClass==Date.class){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				date = sdf.parse(values[0]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return date;
	}

	@Override
	public String convertToString(Map context, Object o) {
		String str = "";
		if(o!=null&&(o.getClass()==Date.class || o.getClass()== Timestamp.class)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			str = sdf.format(o);
		}
		return str;
	}

}
