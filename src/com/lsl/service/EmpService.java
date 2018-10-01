package com.lsl.service;

import java.util.List;

import com.lsl.model.Emp;
import com.lsl.model.Role;
import com.lsl.query.EmpQuery;

public interface EmpService extends BaseService<Emp, EmpQuery> {
	public Emp getEmpByUsername(String username);
	
	public void updateEmp(Emp emp);

	public List<Role> getStateRoles(Integer empId);
	
	public void updateEmpRole(Integer empId,String roleIds);
}
