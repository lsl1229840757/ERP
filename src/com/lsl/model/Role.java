package com.lsl.model;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

	// Fields

	private Integer roleId;
	private String name;
	private String code;
	private String select;

	// Constructors

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	/** default constructor */
	public Role() {
	}

	/** full constructor */
	public Role(String name, String code) {
		this.name = name;
		this.code = code;
	}

	// Property accessors

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}