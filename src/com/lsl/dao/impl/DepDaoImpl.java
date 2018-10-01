package com.lsl.dao.impl;

import org.apache.commons.lang3.StringUtils;

import com.lsl.dao.DepDao;
import com.lsl.model.Dep;
import com.lsl.query.DepQuery;
import com.lsl.query.EmpQuery;

public class DepDaoImpl extends BaseDaoImpl<Dep, DepQuery> implements DepDao {

	@Override
	public String getHql(DepQuery q) {
		String hql = "from Dep d where 1=1";
		hql = createHqlCondition(hql,q);
		return hql;
	}

	@Override
	public String getHqlCount(DepQuery q) {
		String hql = "select count(d.depId) from Dep d where 1=1";
		hql = createHqlCondition(hql, q);
		return hql;
	}

	public String createHqlCondition(String hql,DepQuery q){
		if(StringUtils.isNotBlank(q.getName())){
			hql+=" and d.name like :name";
		}
		if(StringUtils.isNotBlank(q.getTel())){
			hql+=" and d.tel like :tel";
		}
		if(q.getDepId()!=null){
			hql+=" and d.depId = :depId";
		}
		return hql;
	}
	
}
