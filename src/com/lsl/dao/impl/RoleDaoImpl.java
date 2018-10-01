package com.lsl.dao.impl;

import org.apache.commons.lang3.StringUtils;

import com.lsl.dao.RoleDao;
import com.lsl.model.Role;
import com.lsl.query.RoleQuery;

public class RoleDaoImpl extends BaseDaoImpl<Role, RoleQuery> implements RoleDao {

	@Override
	public String getHql(RoleQuery q) {
		String hql = "from Role d where 1=1";
		hql = createHqlCondition(hql, q);
		return hql;
	}

	@Override
	public String getHqlCount(RoleQuery q) {
		String hql = "select count(d.roleId) from Role d where 1=1";
		hql = createHqlCondition(hql, q);
		return hql;
	}

	@Override
	public String createHqlCondition(String hql, RoleQuery q) {
		if(StringUtils.isNotBlank(q.getName())){
			hql+=" and d.name = :name";
		}
		if(StringUtils.isNotBlank(q.getCode())){
			hql+=" and d.code = :code";
		}
		return hql;
	}

}
