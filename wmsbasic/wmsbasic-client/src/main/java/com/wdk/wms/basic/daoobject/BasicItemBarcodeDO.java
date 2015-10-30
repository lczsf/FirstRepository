package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:商品条码 从属商品表
 * 
 * @author 逸遥 Date 2015-09-02
 */
public class BasicItemBarcodeDO {

	@Override
	public String toString() {
		return "BasicItemBarcodeDO [id=" + id + ", itemId=" + itemId + ", barcode=" + barcode + ", status=" + status + ", isDefault=" + isDefault + ", remark="
				+ remark + ", operatorId=" + operatorId + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 所属商品编码，外键, 来源商品表
	 */
	private Long itemId;

	/**
	 * 商品条码
	 */
	private String barcode;

	/**
	 * 条码状态
	 */
	private Integer status;

	/**
	 * 此是否为默认条码，0否，1是
	 */
	private Integer isDefault;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 操作人ID
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
	 * setter for column 所属商品编码，外键, 来源商品表
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	/**
	 * getter for column 所属商品编码，外键, 来源商品表
	 */
	public Long getItemId() {
		return this.itemId;
	}

	/**
	 * setter for column 商品条码
	 */
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	/**
	 * getter for column 商品条码
	 */
	public String getBarcode() {
		return this.barcode;
	}

	/**
	 * setter for column 条码状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * getter for column 条码状态
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * setter for column 此是否为默认条码，0否，1是
	 */
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	/**
	 * getter for column 此是否为默认条码，0否，1是
	 */
	public Integer getIsDefault() {
		return this.isDefault;
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
	 * setter for column 操作人ID
	 */
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	/**
	 * getter for column 操作人ID
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
}