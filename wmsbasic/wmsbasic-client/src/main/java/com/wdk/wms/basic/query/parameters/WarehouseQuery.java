package com.wdk.wms.basic.query.parameters;
 

/**
 * Description:
 *
 * @author 李超
 * @Date 15/9/7
 */
public class WarehouseQuery extends BaseQuery {
	/**
	 * 仓库编码
	 */
	private String code;
	
	/**
	 * 仓库简码（用于生成单据）
	 */
	private String simpleCode;
	
	/**
	 * 仓库名称
	 */
	private String name;

	/**
	 * 仓库状态 @ warehouse.status
	 */
	private Integer status;

	/**
	 * 收货方式手动收货0还是自动收货1
	 * 
	 */
	private Integer receivingMode;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSimpleCode() {
		return simpleCode;
	}

	public void setSimpleCode(String simpleCode) {
		this.simpleCode = simpleCode;
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

	public Integer getReceivingMode() {
		return receivingMode;
	}

	public void setReceivingMode(Integer receivingMode) {
		this.receivingMode = receivingMode;
	}

}
