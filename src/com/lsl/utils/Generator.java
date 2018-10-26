package com.lsl.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import jxl.read.biff.File;
/**
 * 
 * @author lsl
 *	代码生成器
 *
 */
public class Generator {

	public static void main(String[] args) throws Exception  {
		generall("OrderDetail");
	}

	
	public static void generall(String name) throws Exception{
		generDao(name);
		generQuery(name);
		generDaoImpl(name);
		generService(name);
		generServiceImpl(name);
		generDaoConfig(name);
		generServiceConfig(name);
		generAction(name);
		generActionConfig(name);
	}
	
	public static void generDao(String name) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("config/com/lsl/template/DemoDao.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("src/com/lsl/dao/"+name+"Dao.java"));
		String line = null;
		String newline = null;
		while((line=br.readLine())!=null){
			newline = line.replace("Demo", name);
			bw.write(newline);
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}

	public static void generQuery(String name) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("config/com/lsl/template/DemoQuery.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("src/com/lsl/query/"+name+"Query.java"));
		String line = null;
		String newline = null;
		while((line=br.readLine())!=null){
			newline = line.replace("Demo", name);
			bw.write(newline);
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}
	
	public static void generDaoImpl(String name) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("config/com/lsl/template/DemoDaoImpl.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("src/com/lsl/dao/impl/"+name+"DaoImpl.java"));
		String line = null;
		String newline = null;
		while((line=br.readLine())!=null){
			newline = line.replace("Demo", name);
			bw.write(newline);
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}

	public static void generService(String name) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("config/com/lsl/template/DemoService.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("src/com/lsl/service/"+name+"Service.java"));
		String line = null;
		String newline = null;
		while((line=br.readLine())!=null){
			newline = line.replace("Demo", name);
			bw.write(newline);
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}

	public static void generServiceImpl(String name) throws Exception{
		String smallname = name.substring(0,1).toLowerCase()+name.substring(1);
		BufferedReader br = new BufferedReader(new FileReader("config/com/lsl/template/DemoServiceImpl.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("src/com/lsl/service/impl/"+name+"ServiceImpl.java"));
		String line = null;
		String newline = null;
		while((line=br.readLine())!=null){
			newline = line.replace("Demo", name).replace("demo", smallname);
			bw.write(newline);
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}

	public static void generDaoConfig(String name) throws Exception{
		String smallname = name.substring(0,1).toLowerCase()+name.substring(1);
		SAXReader srd = new SAXReader();
		Document doc = srd.read(new FileReader("config/ApplicationContext-dao.xml"));
		Element rootEle = doc.getRootElement();
		Element addEle = rootEle.addElement("bean");
		addEle = addEle.addAttribute("id", smallname+"Dao").addAttribute("class", "com.lsl.dao.impl."+name+"DaoImpl");
		addEle.addElement("property").addAttribute("name", "sessionFactory").addAttribute("ref", "sessionFactory");
		//查询这个方法的作用
		XMLWriter xw = new XMLWriter(new FileWriter("config/ApplicationContext-dao.xml"), OutputFormat.createPrettyPrint());
		xw.write(doc);
		xw.close();
	}
	
	public static void generServiceConfig(String name) throws Exception{
		String smallname = name.substring(0,1).toLowerCase()+name.substring(1);
		SAXReader srd = new SAXReader();
		Document doc = srd.read(new FileReader("config/ApplicationContext-service.xml"));
		Element rootEle = doc.getRootElement();
		Element addEle = rootEle.addElement("bean");
		addEle = addEle.addAttribute("id", smallname+"Service").addAttribute("class", "com.lsl.service.impl."+name+"ServiceImpl");
		addEle.addElement("property").addAttribute("name", smallname+"Dao").addAttribute("ref", smallname+"Dao");
		//查询这个方法的作用
		XMLWriter xw = new XMLWriter(new FileWriter("config/ApplicationContext-service.xml"), OutputFormat.createPrettyPrint());
		xw.write(doc);
		xw.close();
	}
	
	public static void generAction(String name) throws Exception{
		String lowerName = name.substring(0,1).toLowerCase()+name.substring(1);//获得小写的名字
		BufferedReader br = new BufferedReader(new FileReader("config/com/lsl/template/DemoAction.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("src/com/lsl/controller/"+name+"Action.java"));
		String line = null;
		while((line = br.readLine()) != null){
			//开始替换
			line = line.replace("Demo", name).replace("demo", lowerName);
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
	}
	
	public static void generActionConfig(String name) throws Exception{
		String lowerName = name.substring(0,1).toLowerCase()+name.substring(1);//获得小写的名字
		SAXReader sr = new SAXReader();
		Document document = sr.read(new FileReader("config/ApplicationContext-action.xml"));
		Element root = document.getRootElement();
		Element addele = root.addElement("bean").addAttribute("id",lowerName+"Action")
									.addAttribute("class", "com.lsl.controller."+name+"Action")
									.addAttribute("scope", "prototype");
		addele.addElement("property").addAttribute("name", lowerName+"Service")
										.addAttribute("ref", lowerName+"Service");
		XMLWriter xw = new XMLWriter(new FileWriter("config/ApplicationContext-action.xml"), OutputFormat.createPrettyPrint());
		xw.write(document);
		xw.close();
	}
}
