package com.wdk.wms.basic.query.parameters;

public class BaseQuery {
	// 待查询页码--分页使用
	private int begin;

	// 记录数--分页使用
	private int num = 10;

	// 总记录数--分页查询使用
	private int index;

	// 是否分页
	private boolean isDownload;

	// 排序字段
	private String order;

	public boolean getIsDownload() {
		return isDownload;
	}

	public void setIsDownload(boolean isDownload) {
		this.isDownload = isDownload;
	}

	public Integer getBegin() {
		begin = index * num;
		return begin;
	}

	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	private String sort = "DESC";
}
