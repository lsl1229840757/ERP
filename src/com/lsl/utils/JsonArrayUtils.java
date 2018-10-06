package com.lsl.utils;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class JsonArrayUtils {

	public static void getProductsBySupplier(HttpServletResponse response,Collection coll,String[] excludes){
		response.setCharacterEncoding("utf-8");
		JsonConfig jc = new JsonConfig();
		jc.setExcludes(excludes);
		JSONArray ja =  JSONArray.fromObject(coll,jc);
		try {
			response.getWriter().print(ja.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
