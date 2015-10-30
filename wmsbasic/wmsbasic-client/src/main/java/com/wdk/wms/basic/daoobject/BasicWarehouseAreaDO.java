package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:区域
 * 
 * @author 李超 Date 2015-09-07
 */
public class BasicWarehouseAreaDO {

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
	 * 区域编码
	 */
	private String code;

	/**
	 * 所属仓库id
	 */
	private Long warehouseId;

	/**
	 * 区域状态, @ area.status 同状态字典
	 */
	private Integer status;

	/**
	 * 区域名称
	 */
	private String name;

	/**
	 * 区域类型,@ area.type
	 */
	private Integer type;

	/**
	 * 拣货排序号
	 */
	private Integer pickSort;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 最后操作员修改人
	 */
	private Long operatorId;

	/**
	 * 操作人ip
	 */
	private String operatorIp;

	/**
	 * 扩展字段
	 */
	private String feature;

	/**
	 * 货主@area.partnerId
	 */
	private Long partnerId;

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
	 * setter for column 区域编码
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * getter for column 区域编码
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * setter for column 所属仓库id
	 */
	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	/**
	 * getter for column 所属仓库id
	 */
	public Long getWarehouseId() {
		return this.warehouseId;
	}

	/**
	 * setter for column 区域状态, @ area.status 同状态字典
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * getter for column 区域状态, @ area.status 同状态字典
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * setter for column 区域名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter for column 区域名称
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * setter for column 区域类型,@ area.type
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * getter for column 区域类型,@ area.type
	 */
	public Integer getType() {
		return this.type;
	}

	/**
	 * setter for column 拣货排序号
	 */
	public void setPickSort(Integer pickSort) {
		this.pickSort = pickSort;
	}

	/**
	 * getter for column 拣货排序号
	 */
	public Integer getPickSort() {
		return this.pickSort;
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
	 * setter for column 最后操作员修改人
	 */
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	/**
	 * getter for column 最后操作员修改人
	 */
	public Long getOperatorId() {
		return this.operatorId;
	}

	/**
	 * setter for column 操作人ip
	 */
	public void setOperatorIp(String operatorIp) {
		this.operatorIp = operatorIp;
	}

	/**
	 * getter for column 操作人ip
	 */
	public String getOperatorIp() {
		return this.operatorIp;
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
	 * setter for column 货主@area.partnerId
	 */
	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	/**
	 * getter for column 货主@area.partnerId
	 */
	public Long getPartnerId() {
		return this.partnerId;
	}
}