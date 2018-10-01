package com.lsl.service.impl;

import com.lsl.dao.RoleDao;
import com.lsl.model.Role;
import com.lsl.query.RoleQuery;
import com.lsl.service.RoleService;

public class RoleServiceImpl extends BaseServiceImpl<Role, RoleQuery> implements RoleService {

	private RoleDao roleDao;
	
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
		//当我们使用公用的dao的时候必须要一个具体的dao赋值给baseDao
		this.baseDao = roleDao;
	}
}
