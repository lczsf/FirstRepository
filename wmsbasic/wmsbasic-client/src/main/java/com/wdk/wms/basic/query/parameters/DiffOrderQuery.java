package com.wdk.wms.basic.query.parameters;

import java.util.Date;

public class DiffOrderQuery extends BaseQuery {

	/**
	 * 单据code
	 */
	private String code;

	/**
	 * 来源类型
	 */
	private Integer sourceType;

	/**
	 * 来源单据code
	 */
	private String sourceOrderCode;

	/**
	 * 货主id
	 */
	private Long ownerId;

	/**
	 * 商品条码 多个用","号分隔
	 */
	private String itemCode;

	/**
	 * 状态：创建、已处理
	 */
	private Byte status;

	/**
	 * 创建时间起始时间
	 */
	private Date gmtCreateBegin;

	/**
	 * 创建时间截止时间
	 */
	private Date gmtCreateEnd;

	/**
	 * 
	 * @return
	 */
	private Long warehouseId;

	/**
	 * 仓库分表Code
	 */
	private Long warehouseCode;
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getSourceType() {
		return sourceType;
	}

	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
	}

	public String getSourceOrderCode() {
		return sourceOrderCode;
	}

	public void setSourceOrderCode(String sourceOrderCode) {
		this.sourceOrderCode = sourceOrderCode;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
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

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Long getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(Long warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

}
