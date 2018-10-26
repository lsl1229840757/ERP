package com.lsl.query;

import com.lsl.model.OrderDetail;

public class OrderDetailQuery extends OrderDetail {
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
