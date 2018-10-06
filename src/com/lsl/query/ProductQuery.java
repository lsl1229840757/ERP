package com.lsl.query;

import com.lsl.model.Product;

public class ProductQuery extends Product {
	
	private Double minInPrice;
	
	private Double maxInPrice;
	
	private Double minOutPrice;
	
	private Double maxOutPrice;
	
	

	public Double getMinInPrice() {
		return minInPrice;
	}

	public void setMinInPrice(Double minInPrice) {
		this.minInPrice = minInPrice;
	}

	public Double getMaxInPrice() {
		return maxInPrice;
	}

	public void setMaxInPrice(Double maxInPrice) {
		this.maxInPrice = maxInPrice;
	}

	public Double getMinOutPrice() {
		return minOutPrice;
	}

	public void setMinOutPrice(Double minOutPrice) {
		this.minOutPrice = minOutPrice;
	}

	public Double getMaxOutPrice() {
		return maxOutPrice;
	}

	public void setMaxOutPrice(Double maxOutPrice) {
		this.maxOutPrice = maxOutPrice;
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
