package com.lsl.dao.impl;

import org.apache.commons.lang3.StringUtils;

import com.lsl.dao.ConsoleLogDao;
import com.lsl.model.ConsoleLog;
import com.lsl.query.ConsoleLogQuery;

public class ConsoleLogDaoImpl extends BaseDaoImpl<ConsoleLog, ConsoleLogQuery> implements ConsoleLogDao {

	@Override
	public String getHql(ConsoleLogQuery q) {
		String hql = "from ConsoleLog d where 1=1";
	
		return hql;
	}

	@Override
	public String getHqlCount(ConsoleLogQuery q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createHqlCondition(String hql, ConsoleLogQuery q) {
		// TODO Auto-generated method stub
		return null;
	}

}
