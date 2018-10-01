package com.lsl.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lsl.model.Emp;
import com.lsl.query.EmpQuery;
import com.lsl.service.EmpService;
import com.lsl.utils.Page;
//配置Junit的spring运行环境
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:ApplicationContext.xml"})

public class EmpServiceImplTest {

	//注入
	@Autowired
	private EmpService empService;
	
	@Test
	public void testSaveEmp() {
		Emp emp = new Emp();
		emp.setAddress("巴中");
		emp.setName("李大仙");
		emp.setBirthday(new Date());
		empService.save(emp);
	}

	@Test
	public void testUpdateEmp() {
		Emp emp = empService.getObjById(9);
		emp.setUsername("你逼");
		empService.update(emp);
	}

	@Test
	public void testGetEmpById() {
	//上面测过了
	}

	@Test
	public void testDeleteEmpById() {
		empService.deleteObjById(12);
	}

	@Test
	public void testQueryEmpByCondition() {
		EmpQuery eq = new EmpQuery();
		eq.setPageNum(3);
		List<String> exclude = new ArrayList<String>();
		exclude.add("startIndex");
		exclude.add("pageNum");
		Page page = empService.queryObjByCondition(eq, exclude);
		System.out.println(page);
	}

}
