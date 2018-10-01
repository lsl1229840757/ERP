package com.lsl.model;

/**
 * Supplier entity. @author MyEclipse Persistence Tools
 */

public class Supplier implements java.io.Serializable {

	// Fields

	private Integer supplierId;
	private String name;
	private String address;
	private String contact;
	private String tel;
	private Integer needs;

	// Constructors

	/** default constructor */
	public Supplier() {
	}

	/** full constructor */
	public Supplier(String name, String address, String contact, String tel, Integer needs) {
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.tel = tel;
		this.needs = needs;
	}

	// Property accessors

	public Integer getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getNeeds() {
		return this.needs;
	}

	public void setNeeds(Integer needs) {
		this.needs = needs;
	}

}