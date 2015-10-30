package com.wdk.wms.basic.result;

import java.util.List;

public class PageResult<T> {
    
	//当前页数
	private Integer index;
	
	// 开始位置--分页使用
	private Integer begin;

	// 记录数--分页使用
	private Integer num;

	// 总记录数--分页查询使用
	private int totalNum;

	// 排序字段
	private String order;

	// 返回list
	List<T> list;

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getBegin() {
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

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
