package com.lsl.utils;

import java.util.List;

public class Page {

	/**
	 * 分页大小
	 */
	private Integer pageSize = 5;
	/**
	 * 分页号码
	 */
	private Integer pageNum = 1;
	/**
	 * 总数
	 */
	private Integer totalCount = 0;
	/**
	 * 分页开始的行号
	 */
	private Integer startIndex = 0;
	/**
	 * 指定查询条件下的总页数
	 */
	private Integer totalPage = 1;
	/**
	 *查询的集合 
	 */
	private List<?> list;
	
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	public Integer getTotalPage() {
		totalPage = totalCount/pageSize;
		if(totalPage==0||(totalCount%pageSize!=0)){
			totalPage++;
		}
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
	public Integer getStartIndex() {
		return (pageNum-1)*pageSize;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	
}
