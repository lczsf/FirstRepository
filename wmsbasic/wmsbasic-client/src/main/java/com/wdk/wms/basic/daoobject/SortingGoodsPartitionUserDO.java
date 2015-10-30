package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:用户拣货区关联表
 * 
 * @author 李超 Date 2015-09-23
 */
public class SortingGoodsPartitionUserDO {

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
	 * 用户id
	 */
	private Long userId;

	/**
	 * 拣货区id
	 */
	private Long sortingGoodsPartitionId;

	/**
	 * 状态：启用：未启用
	 */
	private Byte status;

	/**
	 * 仓库id
	 */
	private Long warehouseId;

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
	 * setter for column 用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * getter for column 用户id
	 */
	public Long getUserId() {
		return this.userId;
	}

	/**
	 * setter for column 拣货区id
	 */
	public void setSortingGoodsPartitionId(Long sortingGoodsPartitionId) {
		this.sortingGoodsPartitionId = sortingGoodsPartitionId;
	}

	/**
	 * getter for column 拣货区id
	 */
	public Long getSortingGoodsPartitionId() {
		return this.sortingGoodsPartitionId;
	}

	/**
	 * setter for column 状态：启用：未启用
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/**
	 * getter for column 状态：启用：未启用
	 */
	public Byte getStatus() {
		return this.status;
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
}