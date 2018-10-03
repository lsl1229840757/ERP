package com.lsl.service.impl;

import com.lsl.dao.RoleDao;
import com.lsl.model.Role;
import com.lsl.query.RoleQuery;
import com.lsl.service.RoleService;

public class RoleServiceImpl extends BaseServiceImpl<Role, RoleQuery> implements RoleService {

	private RoleDao roleDao;
	
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
		//������ʹ�ù��õ�dao��ʱ�����Ҫһ�������dao��ֵ��baseDao
		this.baseDao = roleDao;
	}
}
