package com.lsl.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lsl.model.ConsoleLog;
import com.lsl.query.ConsoleLogQuery;
import com.lsl.service.ConsoleLogService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:ApplicationContext.xml"})


public class ConsoleLogTest {
	
	@Resource
	private ConsoleLogService cs;

	@Test
	public void test() {
		ConsoleLogQuery q = new ConsoleLogQuery();
		
		List<String> exclude = new ArrayList<String>(); 
		exclude.add("startIndex");
		exclude.add("pageNum");
		
		q.setEntityId(32);
		q.setOptType("…Û∫À∂©µ•");
		q.setTableName("order_model");
		List<ConsoleLog> list = cs.queryObjByConditionNoPage(q, exclude);
		for(ConsoleLog c:list){
			System.out.println(c.getNote());
		}
		
	}

}
