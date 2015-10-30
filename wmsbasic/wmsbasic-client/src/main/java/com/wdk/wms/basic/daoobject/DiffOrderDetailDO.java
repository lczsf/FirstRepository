package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:差异单明细表。
 * 
 * @author 李超 Date 2015-09-17
 */
public class DiffOrderDetailDO {

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
	 * 来源单据明细id
	 */
	private Long sourceOrderDetailId;

	/**
	 * 差异单id，FK
	 */
	private Long diffOrderId;

	/**
	 * 货位id
	 */
	private Long cabinetId;

	/**
	 * 商品id
	 */
	private Long itemId;

	/**
	 * 商品批次
	 */
	private Long itemBatchId;


	/**
	 * 单位
	 */
	private String unit;

	/**
	 * 规格
	 */
	private Integer spec;

	/**
	 * 差异件数
	 */
	private Double diffPackageQuantity;

	/**
	 * 商品code
	 */
	private String itemCode;
	
	/**
	 * 仓库id
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
	 * setter for column 来源单据明细id
	 */
	public void setSourceOrderDetailId(Long sourceOrderDetailId) {
		this.sourceOrderDetailId = sourceOrderDetailId;
	}

	/**
	 * getter for column 来源单据明细id
	 */
	public Long getSourceOrderDetailId() {
		return this.sourceOrderDetailId;
	}

	/**
	 * setter for column 差异单id，FK
	 */
	public void setDiffOrderId(Long diffOrderId) {
		this.diffOrderId = diffOrderId;
	}

	/**
	 * getter for column 差异单id，FK
	 */
	public Long getDiffOrderId() {
		return this.diffOrderId;
	}

	/**
	 * setter for column 货位id
	 */
	public void setCabinetId(Long cabinetId) {
		this.cabinetId = cabinetId;
	}

	/**
	 * getter for column 货位id
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
	 * setter for column 商品批次
	 */
	public void setItemBatchId(Long itemBatchId) {
		this.itemBatchId = itemBatchId;
	}

	/**
	 * getter for column 商品批次
	 */
	public Long getItemBatchId() {
		return this.itemBatchId;
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
	 * setter for column 件数
	 */
	public void setDiffPackageQuantity(Double diffPackageQuantity) {
		this.diffPackageQuantity = diffPackageQuantity;
	}

	/**
	 * getter for column 件数
	 */
	public Double getDiffPackageQuantity() {
		return this.diffPackageQuantity;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public Long getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(Long warehouseCode) {
		this.warehouseCode = warehouseCode;
	}


}