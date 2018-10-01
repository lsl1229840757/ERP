package com.lsl.dao;

import com.lsl.model.Emp;
import com.lsl.query.EmpQuery;

public interface EmpDao extends BaseDao<Emp,EmpQuery> {

	public Emp getEmpByUsername(String username);
	
	
}
