package com.lsl.query;

import com.lsl.model.ProductType;

public class ProductTypeQuery extends ProductType {

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
