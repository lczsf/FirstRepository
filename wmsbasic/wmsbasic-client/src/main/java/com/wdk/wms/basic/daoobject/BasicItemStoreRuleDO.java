package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:商品存放规则
 * 
 * @author 逸遥 Date 2015-09-02
 */
public class BasicItemStoreRuleDO {

	/**
	 * 自增Id，主键
	 */
	private Long id;

	/**
	 * 仓库id，来源仓库表，外键
	 */
	private Long warehouseId;

	/**
	 * 商品类别id，外键，来源商品类型表 (商品类别id和商品id不能同时空)
	 */
	private Long itemTypeId;

	/**
	 * 商品id，外键，来源商资料表，(商品类别id和商品id不能同时为空)
	 */
	private Long itemId;

	/**
	 * 货位id，外键，来源货位表( 仓库区域id、货位类别id、货位id不能同时为空)
	 */
	private Long cabinetId;

	/**
	 * 商品存放规则状态
	 */
	private Integer status;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 操作员ID
	 */
	private Long operatorId;

	/**
	 * 创建时间
	 */
	private Date gmtCreate;

	/**
	 * 修改时间
	 */
	private Date gmtModified;


	/**
	 * 货主id
	 */
	private Long ownerId;

	/**
	 * 商品编码
	 */
	private String itemCode;

	/**
	 * 商品名称
	 */
	private String itemName;

	/**
	 * 存放规则类型
	 */
	private Integer storeType;

	/**
	 * setter for column 自增Id，主键
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * getter for column 自增Id，主键
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * setter for column 仓库id，来源仓库表，外键
	 */
	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	/**
	 * getter for column 仓库id，来源仓库表，外键
	 */
	public Long getWarehouseId() {
		return this.warehouseId;
	}

	/**
	 * setter for column 商品类别id，外键，来源商品类型表 (商品类别id和商品id不能同时空)
	 */
	public void setItemTypeId(Long itemTypeId) {
		this.itemTypeId = itemTypeId;
	}

	/**
	 * getter for column 商品类别id，外键，来源商品类型表 (商品类别id和商品id不能同时空)
	 */
	public Long getItemTypeId() {
		return this.itemTypeId;
	}

	/**
	 * setter for column 商品id，外键，来源商资料表，(商品类别id和商品id不能同时为空)
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	/**
	 * getter for column 商品id，外键，来源商资料表，(商品类别id和商品id不能同时为空)
	 */
	public Long getItemId() {
		return this.itemId;
	}


	/**
	 * setter for column 货位id，外键，来源货位表( 仓库区域id、货位类别id、货位id不能同时为空)
	 */
	public void setCabinetId(Long cabinetId) {
		this.cabinetId = cabinetId;
	}

	/**
	 * getter for column 货位id，外键，来源货位表( 仓库区域id、货位类别id、货位id不能同时为空)
	 */
	public Long getCabinetId() {
		return this.cabinetId;
	}

	/**
	 * setter for column 商品存放规则状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * getter for column 商品存放规则状态
	 */
	public Integer getStatus() {
		return this.status;
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
	 * setter for column 操作员ID
	 */
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	/**
	 * getter for column 操作员ID
	 */
	public Long getOperatorId() {
		return this.operatorId;
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
	 * setter for column 商品编码
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	/**
	 * getter for column 商品编码
	 */
	public String getItemCode() {
		return this.itemCode;
	}

	/**
	 * setter for column 存放规则类型
	 */
	public void setStoreType(Integer storeType) {
		this.storeType = storeType;
	}

	/**
	 * getter for column 存放规则类型
	 */
	public Integer getStoreType() {
		return this.storeType;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

}