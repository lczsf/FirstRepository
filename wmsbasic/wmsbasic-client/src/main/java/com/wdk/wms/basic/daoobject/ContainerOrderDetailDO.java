package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:装箱单明细
 * 
 * @author 滴石 Date 2015-09-14
 */
public class ContainerOrderDetailDO {

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 外键 装箱单Id
	 */
	private Long containerOrderId;

	/**
	 * 仓库分表code
	 */
	private Long warehouseCode;

	/**
	 * 商品编号
	 */
	private Long itemId;

	/**
	 * 商品编码
	 */
	private String itemCode;

	/**
	 * 价格
	 */
	private Integer price;

	/**
	 * 商品批次
	 */
	private Long itemBatchId;


	/**
	 * 备注信息
	 */
	private String remark;

	/**
	 * 创建时间
	 */
	private Date gmtCreate;

	/**
	 * 修改时间
	 */
	private Date gmtModified;

	/**
	 * 扩展字段
	 */
	private String feature;

	/**
	 * 单位
	 */
	private String unit;

	/**
	 * 规格
	 */
	private Integer spec;

	/**
	 * 实收件数
	 */
	private Double actualPackageQuantity;

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

	public Long getContainerOrderId() {
		return containerOrderId;
	}

	public void setContainerOrderId(Long containerOrderId) {
		this.containerOrderId = containerOrderId;
	}

	/**
	 * setter for column 商品编号
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	/**
	 * getter for column 商品编号
	 */
	public Long getItemId() {
		return this.itemId;
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
	 * setter for column 价格
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * getter for column 价格
	 */
	public Integer getPrice() {
		return this.price;
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
	 * setter for column 备注信息
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * getter for column 备注信息
	 */
	public String getRemark() {
		return this.remark;
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
	 * setter for column 实收件数
	 */
	public void setActualPackageQuantity(Double actualPackageQuantity) {
		this.actualPackageQuantity = actualPackageQuantity;
	}

	/**
	 * getter for column 实收件数
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
