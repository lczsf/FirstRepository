package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:库位拣货分区关联表
 * 
 * @author 李超 Date 2015-10-08
 */
public class SortingGoodsPartitionCabinetDO {

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
	 * 分区code
	 */
	private String sortingGoodsPartitionCode;

	/**
	 * 库位id
	 */
	private Long cabinetId;

	/**
	 * 仓库id
	 */
	private Long warehouseId;

	/**
	 * 类型
	 */
	private Integer type;

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
	 * setter for column 分区code
	 */
	public void setSortingGoodsPartitionCode(String sortingGoodsPartitionCode) {
		this.sortingGoodsPartitionCode = sortingGoodsPartitionCode;
	}

	/**
	 * getter for column 分区code
	 */
	public String getSortingGoodsPartitionCode() {
		return this.sortingGoodsPartitionCode;
	}

	/**
	 * setter for column 库位id
	 */
	public void setCabinetId(Long cabinetId) {
		this.cabinetId = cabinetId;
	}

	/**
	 * getter for column 库位id
	 */
	public Long getCabinetId() {
		return this.cabinetId;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}