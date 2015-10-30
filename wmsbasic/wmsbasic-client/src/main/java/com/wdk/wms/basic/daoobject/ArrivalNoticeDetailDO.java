package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:到货通知详细表
 * 
 * @author 滴石 Date 2015-09-14
 */

public class ArrivalNoticeDetailDO {

	/**
	 * 外键关联到货通知单主表
	 */
	private Long asnId;

	/**
	 * 仓库分表code
	 */
	private Long warehouseCode;

	/**
	 * 商品编号
	 */
	private Long itemId;

	/**
	 * 价格，单位分
	 */
	private Integer price;

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
	 * 主键
	 */
	private Long id;

	/**
	 * 扩展字段，记录批属性
	 */
	private String feature;

	/**
	 * 品牌id（冗余字段）
	 */
	private Long brandId;

	/**
	 * 单位
	 */
	private String unit;

	/**
	 * 规格
	 */
	private Integer spec;

	/**
	 * 应收件数
	 */
	private Double planPackageQuantity;

	/**
	 * 实收件数
	 */
	private Double actualPackageQuantity;

	/**
	 * 版本控制，解决并发冲突问题
	 */
	private Integer version;

	/**
	 * 商品code
	 */
	private String itemCode;

	/**
	 * 待收数量
	 */
	private Integer quantity;


	/**
	 * 逻辑仓id
	 */
	private Long logicWarehouseId;

	/**
	 * setter for column 外键关联到货通知单主表
	 */
	public void setAsnId(Long asnId) {
		this.asnId = asnId;
	}

	/**
	 * getter for column 外键关联到货通知单主表
	 */
	public Long getAsnId() {
		return this.asnId;
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
	 * setter for column 价格，单位分
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * getter for column 价格，单位分
	 */
	public Integer getPrice() {
		return this.price;
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
	 * setter for column 扩展字段，记录批属性
	 */
	public void setFeature(String feature) {
		this.feature = feature;
	}

	/**
	 * getter for column 扩展字段，记录批属性
	 */
	public String getFeature() {
		return this.feature;
	}

	/**
	 * setter for column 品牌id（冗余字段）
	 */
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	/**
	 * getter for column 品牌id（冗余字段）
	 */
	public Long getBrandId() {
		return this.brandId;
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
	 * setter for column 应收件数
	 */
	public void setPlanPackageQuantity(Double planPackageQuantity) {
		this.planPackageQuantity = planPackageQuantity;
	}

	/**
	 * getter for column 应收件数
	 */
	public Double getPlanPackageQuantity() {
		return this.planPackageQuantity;
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

	/**
	 * setter for column 版本控制，解决并发冲突问题
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * getter for column 版本控制，解决并发冲突问题
	 */
	public Integer getVersion() {
		return this.version;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(Long warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public Long getLogicWarehouseId() {
		return logicWarehouseId;
	}

	public void setLogicWarehouseId(Long logicWarehouseId) {
		this.logicWarehouseId = logicWarehouseId;
	}
}
