package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:商品批次信息
 * 
 * @author 滴石 Date 2015-09-06
 */
public class InventoryBatchDO {

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
	 * 生产日期
	 */
	private Date produceDate;

	/**
	 * 到货日期
	 */
	private Date arriveDate;

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
	 * setter for column 生产日期
	 */
	public void setProduceDate(Date produceDate) {
		this.produceDate = produceDate;
	}

	/**
	 * getter for column 生产日期
	 */
	public Date getProduceDate() {
		return this.produceDate;
	}

	/**
	 * setter for column 到货日期
	 */
	public void setArriveDate(Date arriveDate) {
		this.arriveDate = arriveDate;
	}

	/**
	 * getter for column 到货日期
	 */
	public Date getArriveDate() {
		return this.arriveDate;
	}
}
