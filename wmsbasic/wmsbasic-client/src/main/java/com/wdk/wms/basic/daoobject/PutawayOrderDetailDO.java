package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:上架单明细
 * 
 * @author 李超 Date 2015-09-17
 */
public class PutawayOrderDetailDO {

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
	 * 上架单id，FK
	 */
	private Long putawayOrderId;

	/**
	 * 计划上架货位id
	 */
	private Long cabinetId;

	/**
	 * 商品id
	 */
	private Long itemId;

	/**
	 * 商品code
	 */
	private String itemCode;

	/**
	 * 商品批次id
	 */
	private Long itemBatchId;


	/**
	 * 扩展字段
	 */
	private String feature;

	/**
	 * 最终上架货位id
	 */
	private Long actualCabinetId;

	/**
	 * 单位
	 */
	private String unit;

	/**
	 * 规格
	 */
	private Integer spec;

	/**
	 * 应上架件数
	 */
	private Double planPackageQuantity;

	/**
	 * 实际上架件数
	 */
	private Double actualPackageQuantity;

	/**
	 * 仓库分表code
	 */
	private Long warehouseCode;

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
	 * setter for column 上架单id，FK
	 */
	public void setPutawayOrderId(Long putawayOrderId) {
		this.putawayOrderId = putawayOrderId;
	}

	/**
	 * getter for column 上架单id，FK
	 */
	public Long getPutawayOrderId() {
		return this.putawayOrderId;
	}

	/**
	 * setter for column 计划上架货位id
	 */
	public void setCabinetId(Long cabinetId) {
		this.cabinetId = cabinetId;
	}

	/**
	 * getter for column 计划上架货位id
	 */
	public Long getCabinetId() {
		return this.cabinetId;
	}

	/**
	 * setter for column 商品id
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	/**
	 * getter for column 商品id
	 */
	public Long getItemId() {
		return this.itemId;
	}

	/**
	 * setter for column 商品code
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	/**
	 * getter for column 商品code
	 */
	public String getItemCode() {
		return this.itemCode;
	}

	/**
	 * setter for column 商品批次id
	 */
	public void setItemBatchId(Long itemBatchId) {
		this.itemBatchId = itemBatchId;
	}

	/**
	 * getter for column 商品批次id
	 */
	public Long getItemBatchId() {
		return this.itemBatchId;
	}

	/**
	 * setter for column 扩展字段
	 */
	public void setFeature(String feature) {
		this.feature = feature;
	}

	/**
	 * getter for column 扩展字段
	 */
	public String getFeature() {
		return this.feature;
	}

	/**
	 * setter for column 最终上架货位id
	 */
	public void setActualCabinetId(Long actualCabinetId) {
		this.actualCabinetId = actualCabinetId;
	}

	/**
	 * getter for column 最终上架货位id
	 */
	public Long getActualCabinetId() {
		return this.actualCabinetId;
	}

	/**
	 * setter for column 单位
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * getter for column 单位
	 */
	public String getUnit() {
		return this.unit;
	}

	/**
	 * setter for column 规格
	 */
	public void setSpec(Integer spec) {
		this.spec = spec;
	}

	/**
	 * getter for column 规格
	 */
	public Integer getSpec() {
		return this.spec;
	}

	/**
	 * setter for column 应上架件数
	 */
	public void setPlanPackageQuantity(Double planPackageQuantity) {
		this.planPackageQuantity = planPackageQuantity;
	}

	/**
	 * getter for column 应上架件数
	 */
	public Double getPlanPackageQuantity() {
		return this.planPackageQuantity;
	}

	/**
	 * setter for column 实际上架件数
	 */
	public void setActualPackageQuantity(Double actualPackageQuantity) {
		this.actualPackageQuantity = actualPackageQuantity;
	}

	/**
	 * getter for column 实际上架件数
	 */
	public Double getActualPackageQuantity() {
		return this.actualPackageQuantity;
	}

	public Long getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(Long warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

}