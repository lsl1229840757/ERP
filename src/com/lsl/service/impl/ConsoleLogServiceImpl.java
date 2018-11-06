package com.lsl.service.impl;

import com.lsl.dao.ConsoleLogDao;
import com.lsl.model.ConsoleLog;
import com.lsl.query.ConsoleLogQuery;
import com.lsl.service.ConsoleLogService;

public class ConsoleLogServiceImpl extends BaseServiceImpl<ConsoleLog, ConsoleLogQuery> implements ConsoleLogService {

	private ConsoleLogDao consoleLogDao;
	
	public void setConsoleLogDao(ConsoleLogDao consoleLogDao) {
		this.consoleLogDao = consoleLogDao;
		//������ʹ�ù��õ�dao��ʱ�����Ҫһ�������dao��ֵ��baseDao
		this.baseDao = consoleLogDao;
	}
}
