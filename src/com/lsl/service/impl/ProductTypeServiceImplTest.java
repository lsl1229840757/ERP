package com.lsl.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lsl.model.ProductType;
import com.lsl.service.ProductTypeService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:ApplicationContext.xml"})

public class ProductTypeServiceImplTest {

	/*
	 * ����ֻ��ʹ�ýӿڵ���ʽ����Ȼ�ᵼ���޷�ʵ����
	 */
	@Autowired
	private ProductTypeService pd;
	
	@Test
	public void testSetProductTypeDao() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		ProductType dp = new ProductType();
		dp.setSupplierId(1);
		dp.setName("����");
		pd.save(dp);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetObjById() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteObjById() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryObjByCondition() {
		fail("Not yet implemented");
	}

}
