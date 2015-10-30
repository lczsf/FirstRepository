package com.wdk.wms.basic.query.parameters;

import java.util.Date;

public class PutawayOrderQuery extends BaseQuery {

	/**
	 * 单据code
	 */
	private String code;

	/**
	 * 仓库id
	 */
	private Long warehouseId;

	/**
	 * 仓库分表Code
	 */
	private Long warehouseCode;

	/**
	 * 货主id
	 */
	private Long ownerId;

	/**
	 * 上架人id
	 */
	private Long putawayerId;

	/**
	 * 状态：创建、上架完成
	 */
	private Byte status;

	/**
	 * 容器编码
	 */
	private String containerCode;

	/**
	 * 上架类型
	 */
	private Byte type;

	/**
	 * 创建起始时间
	 * 
	 */
	private Date gmtCreateBegin;

	/**
	 * 创建截止时间
	 * 
	 */
	private Date gmtCreateEnd;

	/**
	 * 来源单据code
	 */
	private String sourceOrderCode;


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Long getPutawayerId() {
		return putawayerId;
	}

	public void setPutawayerId(Long putawayerId) {
		this.putawayerId = putawayerId;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getContainerCode() {
		return containerCode;
	}

	public void setContainerCode(String containerCode) {
		this.containerCode = containerCode;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public Date getGmtCreateBegin() {
		return gmtCreateBegin;
	}

	public void setGmtCreateBegin(Date gmtCreateBegin) {
		this.gmtCreateBegin = gmtCreateBegin;
	}

	public Date getGmtCreateEnd() {
		return gmtCreateEnd;
	}

	public void setGmtCreateEnd(Date gmtCreateEnd) {
		this.gmtCreateEnd = gmtCreateEnd;
	}

	public String getSourceOrderCode() {
		return sourceOrderCode;
	}

	public void setSourceOrderCode(String sourceOrderCode) {
		this.sourceOrderCode = sourceOrderCode;
	}


	public Long getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(Long warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

}
