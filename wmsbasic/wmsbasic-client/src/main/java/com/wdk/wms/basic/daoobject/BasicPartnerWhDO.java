package com.wdk.wms.basic.daoobject;

import java.util.Date;

public class BasicPartnerWhDO {

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
	 * 状态
	 */
	private Integer status;

	/**
	 * 合作伙伴id
	 */
	private Long partnerId;

	/**
	 * 类型0 库区，1库位
	 */
	private Integer type;

	/**
	 * 库区/库位id
	 */
	private Long whId;

	/**
	 * 关联关系0归属，1推荐
	 */
	private Integer relation;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 仓库id
	 */
	private Long warehouseId;

	/**
	 * 合作伙伴类型 货主1，供应商2
	 */
	private Integer partnerType;

	/**
	 * op
	 */
	private Long operatorId;

	/**
	 * op__ip
	 */
	private String operatorIp;
	
	/**
	 * partnerName
	 */
	private String partnerName;
	
	/**
	 * warehouseName
	 */
    private String warehouseName;
    
    /**
     * warehouseAreaName
     */
	private String warehouseAreaName;
	
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
	 * setter for column 状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * getter for column 状态
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * setter for column 合作伙伴id
	 */
	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	/**
	 * getter for column 合作伙伴id
	 */
	public Long getPartnerId() {
		return this.partnerId;
	}

	/**
	 * setter for column 类型0 库区，1库位
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * getter for column 类型0 库区，1库位
	 */
	public Integer getType() {
		return this.type;
	}

	/**
	 * setter for column 库区/库位id
	 */
	public void setWhId(Long whId) {
		this.whId = whId;
	}

	/**
	 * getter for column 库区/库位id
	 */
	public Long getWhId() {
		return this.whId;
	}

	/**
	 * setter for column 关联关系0归属，1推荐
	 */
	public void setRelation(Integer relation) {
		this.relation = relation;
	}

	/**
	 * getter for column 关联关系0归属，1推荐
	 */
	public Integer getRelation() {
		return this.relation;
	}

	/**
	 * setter for column 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * getter for column 备注
	 */
	public String getRemark() {
		return this.remark;
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
	 * setter for column 合作伙伴类型 货主1，供应商2
	 */
	public void setPartnerType(Integer partnerType) {
		this.partnerType = partnerType;
	}

	/**
	 * getter for column 合作伙伴类型 货主1，供应商2
	 */
	public Integer getPartnerType() {
		return this.partnerType;
	}

	/**
	 * setter for column op
	 */
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	/**
	 * getter for column op
	 */
	public Long getOperatorId() {
		return this.operatorId;
	}

	/**
	 * setter for column op__ip
	 */
	public void setOperatorIp(String operatorIp) {
		this.operatorIp = operatorIp;
	}

	/**
	 * getter for column op__ip
	 */
	public String getOperatorIp() {
		return this.operatorIp;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getWarehouseAreaName() {
		return warehouseAreaName;
	}

	public void setWarehouseAreaName(String warehouseAreaName) {
		this.warehouseAreaName = warehouseAreaName;
	}
	
}
