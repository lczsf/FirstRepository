package com.wdk.wms.basic.query.parameters;


/**
 * Description:
 *
 * @author 刘勇
 * @Date 15/9/8
 */
public class AuthActionQuery extends BaseQuery {

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 代码（唯一）
	 */
	private String code;

	/**
	 * 状态（1=正常；-1=注销）@authAction.status
	 */
	private Integer status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
