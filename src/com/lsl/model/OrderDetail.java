package com.lsl.model;

/**
 * OrderDetail entity. @author MyEclipse Persistence Tools
 */

public class OrderDetail implements java.io.Serializable {

	// Fields

	private Integer orderDetailId;
	private Integer detailNum;
	private Double detailPrice;
	private Integer productId;
	private String orderId;
	private Integer surplus;
	private Product product;
	
	// Constructors

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	/** default constructor */
	public OrderDetail() {
	}

	/** full constructor */
	public OrderDetail(Integer detailNum, Double detailPrice, Integer productId, String orderId, Integer surplus) {
		this.detailNum = detailNum;
		this.detailPrice = detailPrice;
		this.productId = productId;
		this.orderId = orderId;
		this.surplus = surplus;
	}

	// Property accessors

	public Integer getOrderDetailId() {
		return this.orderDetailId;
	}

	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Integer getDetailNum() {
		return this.detailNum;
	}

	public void setDetailNum(Integer detailNum) {
		this.detailNum = detailNum;
	}

	public Double getDetailPrice() {
		return this.detailPrice;
	}

	public void setDetailPrice(Double detailPrice) {
		this.detailPrice = detailPrice;
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getSurplus() {
		return this.surplus;
	}

	public void setSurplus(Integer surplus) {
		this.surplus = surplus;
	}

}