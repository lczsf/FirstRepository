package com.wdk.wms.basic.query.parameters;

public class PartnerQuery extends BaseQuery {

	/**
	 * 商业伙伴编码
	 */
	private String code;

	/**
	 * 中文名称
	 */
	private String name;

	/**
	 * 状态编号@partner.status
	 */
	private Integer status;

	/**
	 * 伙伴类型
	 */
	private Integer partnerType;

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getPartnerType() {
		return partnerType;
	}

	public void setPartnerType(Integer partnerType) {
		this.partnerType = partnerType;
	}

}
