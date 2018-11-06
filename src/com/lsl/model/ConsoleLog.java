package com.lsl.model;

import java.sql.Timestamp;

/**
 * ConsoleLog entity. @author MyEclipse Persistence Tools
 */

public class ConsoleLog implements java.io.Serializable {

	// Fields

	private Integer logId;
	private Integer entityId;
	private String tableName;
	private String optType;
	private Timestamp optTime;
	private Integer empId;
	private String note;
	private Emp checker;
	
	// Constructors

	public Emp getChecker() {
		return checker;
	}

	public void setChecker(Emp checker) {
		this.checker = checker;
	}

	/** default constructor */
	public ConsoleLog() {
	}

	/** full constructor */
	public ConsoleLog(Integer entityId, String tableName, String optType, Timestamp optTime, Integer empId,
			String note) {
		this.entityId = entityId;
		this.tableName = tableName;
		this.optType = optType;
		this.optTime = optTime;
		this.empId = empId;
		this.note = note;
	}

	// Property accessors

	public Integer getLogId() {
		return this.logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public Integer getEntityId() {
		return this.entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getOptType() {
		return this.optType;
	}

	public void setOptType(String optType) {
		this.optType = optType;
	}

	public Timestamp getOptTime() {
		return this.optTime;
	}

	public void setOptTime(Timestamp optTime) {
		this.optTime = optTime;
	}

	public Integer getEmpId() {
		return this.empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}