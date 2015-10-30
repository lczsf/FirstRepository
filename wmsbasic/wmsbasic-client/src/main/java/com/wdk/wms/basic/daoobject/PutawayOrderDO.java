package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:上架单表，各个业务共用，例如移库上架单、收货上架单等。
 * 
 * @author 滴石 Date 2015-09-14
 */
public class PutawayOrderDO {

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
	 * 仓库分表code
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
	 * 是否是rf作业
	 */
	private Integer isRf;

	/**
	 * 状态：创建、上架完成
	 */
	private Integer status;

	/**
	 * 当来源为移库单时。对应的下架单id。
	 */
	private Long putdownId;

	/**
	 * 容器编号
	 */
	private String containerCode;

	/**
	 * 上架类型
	 */
	private Integer type;

	/**
	 * 来源单据code
	 */
	private String sourceOrderCode;

	/**
	 * 扩展字段，名称自定义，如：业务类型（bizType）、单据类型（orderType）
	 */
	private String feature;

	/**
	 * 操作人
	 */
	private Long operatorId;

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
	 * setter for column 上架人id
	 */
	public void setPutawayerId(Long putawayerId) {
		this.putawayerId = putawayerId;
	}

	/**
	 * getter for column 上架人id
	 */
	public Long getPutawayerId() {
		return this.putawayerId;
	}

	/**
	 * setter for column 是否是rf作业
	 */
	public void setIsRf(Integer isRf) {
		this.isRf = isRf;
	}

	/**
	 * getter for column 是否是rf作业
	 */
	public Integer getIsRf() {
		return this.isRf;
	}

	/**
	 * setter for column 状态：创建、上架完成
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * getter for column 状态：创建、上架完成
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * setter for column 当来源为移库单时。对应的下架单id。
	 */
	public void setPutdownId(Long putdownId) {
		this.putdownId = putdownId;
	}

	/**
	 * getter for column 当来源为移库单时。对应的下架单id。
	 */
	public Long getPutdownId() {
		return this.putdownId;
	}

	/**
	 * setter for column 容器编号
	 */
	public void setContainerCode(String containerCode) {
		this.containerCode = containerCode;
	}

	/**
	 * getter for column 容器编号
	 */
	public String getContainerCode() {
		return this.containerCode;
	}

	/**
	 * setter for column 上架类型
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * getter for column 上架类型
	 */
	public Integer getType() {
		return this.type;
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
	 * setter for column 扩展字段，名称自定义，如：业务类型（bizType）、单据类型（orderType）
	 */
	public void setFeature(String feature) {
		this.feature = feature;
	}

	/**
	 * getter for column 扩展字段，名称自定义，如：业务类型（bizType）、单据类型（orderType）
	 */
	public String getFeature() {
		return this.feature;
	}

	public Long getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(Long warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

}