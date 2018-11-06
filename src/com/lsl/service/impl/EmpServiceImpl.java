package com.lsl.service.impl;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import com.lsl.dao.EmpDao;
import com.lsl.dao.RoleDao;
import com.lsl.model.Emp;
import com.lsl.model.Role;
import com.lsl.query.EmpQuery;
import com.lsl.service.EmpService;
public class EmpServiceImpl extends BaseServiceImpl<Emp,EmpQuery> implements EmpService {

	private RoleDao roleDao;
	
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	private EmpDao empDao;
	
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
		/**
		 * 这里在调用baseService的方法的时候必须要对baseDao实例化
		 */
		this.baseDao = empDao;	
	}

	@Override
	public Emp getEmpByUsername(String username) {
		return empDao.getEmpByUsername(username);
	}

	@Override
	public void updateEmp(Emp emp) {
		Emp emp1 = empDao.getObjById(emp.getEmpId());
		//将emp的属性拷贝到emp1中,并且忽略密码
		String[] str = {"password"};
		BeanUtils.copyProperties(emp,emp1,str);
		empDao.saveObj(emp1);
	}

	@Override
	public List<Role> getStateRoles(Integer empId) {
		Set<Role> roles = empDao.getObjById(empId).getRoles();
		List<Role> lists = roleDao.list();
		for(Role r:lists){
			for(Role r2:roles){
				if(r.getRoleId() == r2.getRoleId()){
					r.setSelect("yes");
				}
			}
		}
		return lists;
	}

	@Override
	public void updateEmpRole(Integer empId, String roleIds) {
		if(StringUtils.isNotBlank(roleIds)){
			Emp emp = empDao.getObjById(empId);
			Set<Role> roles = emp.getRoles();
			String[] split = roleIds.split(",");
			roles.clear();
			for(String s:split){
				Role role = new Role();
				role.setRoleId(Integer.valueOf(s));
				roles.add(role);
			}
		}
	}
}
