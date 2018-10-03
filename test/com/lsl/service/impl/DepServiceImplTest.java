package com.lsl.service.impl;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lsl.model.Dep;
import com.lsl.query.DepQuery;
import com.lsl.service.DepService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:ApplicationContext.xml")
public class DepServiceImplTest {

	/**
	 * ע�⣺����ֻ���ýӿڣ�spring���ܴ���
	 */
	@Resource
	private DepService ds;
	
	@Test
	public void testSaveDep() {
		Dep dep = new Dep();
		dep.setName("���Բ���˵��");
		dep.setTel("sss");
		ds.save(dep);
	}

	@Test
	public void testUpdateDep() {
		Dep dep = ds.getObjById(10);
		dep.setTel("1");
		ds.update(dep);
	}

	@Test
	public void testGetDepById() {
	}

	@Test
	public void testDeleteDepById() {
		ds.deleteObjById(10);
	}

	@Test
	public void testQueryDepByCondition() {
		DepQuery dq = new DepQuery();
		dq.setName("��");
	}

}
