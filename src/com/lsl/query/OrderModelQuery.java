package com.lsl.query;

import java.util.Date;

import com.lsl.model.OrderModel;

public class OrderModelQuery extends OrderModel {
	
	private Integer minTotalNum;
	
	private Integer maxTotalNum;
	
	private Date minCreateTime;
	
	private Date maxCreateTime;

	private Double minTotalPrice;
	
	private Double maxTotalPrice;
	
	private String creatorName;
	

	public Double getMinTotalPrice() {
		return minTotalPrice;
	}

	public void setMinTotalPrice(Double minTotalPrice) {
		this.minTotalPrice = minTotalPrice;
	}

	public Double getMaxTotalPrice() {
		return maxTotalPrice;
	}

	public void setMaxTotalPrice(Double maxTotalPrice) {
		this.maxTotalPrice = maxTotalPrice;
	}

	public Date getMinCreateTime() {
		return minCreateTime;
	}

	public void setMinCreateTime(Date minCreateTime) {
		this.minCreateTime = minCreateTime;
	}

	public Date getMaxCreateTime() {
		return maxCreateTime;
	}

	public void setMaxCreateTime(Date maxCreateTime) {
		this.maxCreateTime = maxCreateTime;
	}

	public Integer getMinTotalNum() {
		return minTotalNum;
	}

	public void setMinTotalNum(Integer minTotalNum) {
		this.minTotalNum = minTotalNum;
	}

	public Integer getMaxTotalNum() {
		return maxTotalNum;
	}

	public void setMaxTotalNum(Integer maxTotalNum) {
		this.maxTotalNum = maxTotalNum;
	}

	
	
	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	private Integer pageNum;
	
	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	private Integer startIndex;
	
	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
}
