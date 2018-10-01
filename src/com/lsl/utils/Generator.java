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

public class Generator {

	public static void main(String[] args) throws Exception  {
		generall("Role");
	}

	
	public static void generall(String name) throws Exception{
		generDao(name);
		generQuery(name);
		generDaoImpl(name);
		generService(name);
		generServiceImpl(name);
		generDaoConfig(name);
		generServiceConfig(name);
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
	
	
	
	
}
