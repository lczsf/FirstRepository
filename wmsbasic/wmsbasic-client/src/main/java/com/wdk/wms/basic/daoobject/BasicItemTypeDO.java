package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:存储分类
 * 
 * @author 逸遥 Date 2015-09-02
 */
public class BasicItemTypeDO {
	
	@Override
	public String toString() {
		return "BasicItemTypeDO [id=" + id + ", code=" + code + ", name=" + name + ", parentId=" + parentId + ", status=" + status + ", remark=" + remark + ", operatorId=" + operatorId
				+ ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}

	/**
	 * 主键,系统编码
	 */
	private Long id;

	/**
	 * 商品类别编码
	 */
	private String code;

	/**
	 * 商品类别名称
	 */
	private String name;

	/**
	 * 上级类别编码，0表示顶级，包括所有的商品类别
	 */
	private Long parentId;

	/**
	 * 商品类别状态
	 */
	private Integer status;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 操作人员ID
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
	 * setter for column 主键,系统编码
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * getter for column 主键,系统编码
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * setter for column 商品类别编码
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * getter for column 商品类别编码
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * setter for column 商品类别名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter for column 商品类别名称
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * setter for column 上级类别编码，0表示顶级，包括所有的商品类别
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * getter for column 上级类别编码，0表示顶级，包括所有的商品类别
	 */
	public Long getParentId() {
		return this.parentId;
	}

	/**
	 * setter for column 商品类别状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * getter for column 商品类别状态
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
	 * setter for column 操作人员ID
	 */
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	/**
	 * getter for column 操作人员ID
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