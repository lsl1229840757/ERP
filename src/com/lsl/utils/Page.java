package com.lsl.utils;

import java.util.List;

public class Page {

	/**
	 * ��ҳ��С
	 */
	private Integer pageSize = 5;
	/**
	 * ��ҳ����
	 */
	private Integer pageNum = 1;
	/**
	 * ����
	 */
	private Integer totalCount = 0;
	/**
	 * ��ҳ��ʼ���к�
	 */
	private Integer startIndex = 0;
	/**
	 * ָ����ѯ�����µ���ҳ��
	 */
	private Integer totalPage = 1;
	/**
	 *��ѯ�ļ��� 
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
