package com.lsl.service.impl;

import com.lsl.dao.ConsoleLogDao;
import com.lsl.model.ConsoleLog;
import com.lsl.query.ConsoleLogQuery;
import com.lsl.service.ConsoleLogService;

public class ConsoleLogServiceImpl extends BaseServiceImpl<ConsoleLog, ConsoleLogQuery> implements ConsoleLogService {

	private ConsoleLogDao consoleLogDao;
	
	public void setConsoleLogDao(ConsoleLogDao consoleLogDao) {
		this.consoleLogDao = consoleLogDao;
		//当我们使用公用的dao的时候必须要一个具体的dao赋值给baseDao
		this.baseDao = consoleLogDao;
	}
}
