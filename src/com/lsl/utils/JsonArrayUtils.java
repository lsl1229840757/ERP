package com.lsl.utils;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
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
	

	public static void getObjJson(HttpServletResponse response,Object obj,String[] excludes){
		response.setCharacterEncoding("utf-8");
		JsonConfig jc = new JsonConfig();
		jc.setExcludes(excludes);
		JSONObject jb =  JSONObject.fromObject(obj,jc);
		try {
			response.getWriter().print(jb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
