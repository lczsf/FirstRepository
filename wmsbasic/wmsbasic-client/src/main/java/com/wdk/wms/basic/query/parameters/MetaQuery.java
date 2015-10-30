package com.wdk.wms.basic.query.parameters;


/**
 * Description: 字典表查询条件
 *
 * @author 刘勇
 * @Date 15/9/7
 */
public class MetaQuery extends BaseQuery {

	// Code
	private String code;

	// 名称
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
