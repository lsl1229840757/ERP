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
	 * @param context:与action有关的上下文
	 * @param values：接收的字符串数组
	 * @param toClass：这里是struts先根据action来确定toclass
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
