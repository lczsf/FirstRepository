package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:差异单。各个业务共用，例如：移库下架差异单、移库上架差异单。
 * 
 * @author 李超 Date 2015-09-16
 */
public class DiffOrderDO {

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 创建时间
	 */
	private Date gmtCreate;

	/**
	 * 修改时间
	 */
	private Date gmtModified;

	/**
	 * 单据code
	 */
	private String code;

	/**
	 * 来源类型
	 */
	private Integer sourceType;

	/**
	 * 来源单据id
	 */
	private Long sourceOrderId;

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
	 * 创建人
	 */
	private Long creatorId;

	/**
	 * 状态：创建、已处理
	 */
	private Integer status;

	/**
	 * 来源单据code
	 */
	private String sourceOrderCode;

	/**
	 * 容器code
	 */
	private String containerCode;

	/**
	 * 处理人
	 */
	private Long dealId;

	/**
	 * 创建人
	 */
	private String creatorName;


	/**
	 * setter for column 主键
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * getter for column 主键
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * setter for column 创建时间
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	/**
	 * getter for column 创建时间
	 */
	public Date getGmtCreate() {
		return this.gmtCreate;
	}

	/**
	 * setter for column 修改时间
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	/**
	 * getter for column 修改时间
	 */
	public Date getGmtModified() {
		return this.gmtModified;
	}

	/**
	 * setter for column 单据code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * getter for column 单据code
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * setter for column 来源类型
	 */
	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
	}

	/**
	 * getter for column 来源类型
	 */
	public Integer getSourceType() {
		return this.sourceType;
	}

	/**
	 * setter for column 来源单据id
	 */
	public void setSourceOrderId(Long sourceOrderId) {
		this.sourceOrderId = sourceOrderId;
	}

	/**
	 * getter for column 来源单据id
	 */
	public Long getSourceOrderId() {
		return this.sourceOrderId;
	}

	/**
	 * setter for column 仓库id
	 */
	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	/**
	 * getter for column 仓库id
	 */
	public Long getWarehouseId() {
		return this.warehouseId;
	}

	/**
	 * setter for column 货主id
	 */
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * getter for column 货主id
	 */
	public Long getOwnerId() {
		return this.ownerId;
	}

	/**
	 * setter for column 创建人
	 */
	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	/**
	 * getter for column 创建人
	 */
	public Long getCreatorId() {
		return this.creatorId;
	}

	/**
	 * setter for column 状态：创建、已处理
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * getter for column 状态：创建、已处理
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * setter for column 来源单据code
	 */
	public void setSourceOrderCode(String sourceOrderCode) {
		this.sourceOrderCode = sourceOrderCode;
	}

	/**
	 * getter for column 来源单据code
	 */
	public String getSourceOrderCode() {
		return this.sourceOrderCode;
	}

	/**
	 * setter for column 容器id
	 */
	public void setContainerId(String containerCode) {
		this.containerCode = containerCode;
	}

	/**
	 * getter for column 容器id
	 */
	public String getContainerCode() {
		return this.containerCode;
	}

	/**
	 * setter for column 处理人
	 */
	public void setDealId(Long dealId) {
		this.dealId = dealId;
	}

	/**
	 * getter for column 处理人
	 */
	public Long getDealId() {
		return this.dealId;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}


	public void setContainerCode(String containerCode) {
		this.containerCode = containerCode;
	}

	public Long getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(Long warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

}