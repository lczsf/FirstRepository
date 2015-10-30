package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:仓库
 * 
 * @author 李超 Date 2015-09-07
 */
public class BasicWarehouseDO {

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
	 * 仓库编码
	 */
	private String code;

	/**
	 * 仓库名称
	 */
	private String name;

	/**
	 * 仓库状态 @ warehouse.status
	 */
	private Integer status;

	/**
	 * 仓库类型,@ warehouse.type
	 */
	private Integer type;

	/**
	 * 仓库简码（用于生成单据）
	 */
	private String simpleCode;

	/**
	 * 仓库联系地址
	 */
	private String address;

	/**
	 * 仓库主管
	 */
	private String major;

	/**
	 * 主管电话 或者 手机
	 */
	private String tel;

	/**
	 * 联系人传真
	 */
	private String fax;

	/**
	 * 联系人电子邮件
	 */
	private String email;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 最后修改人
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
	 * 仓库批属性规则id
	 */
	private Long batchRuleId;

	/**
	 * 上架策略ID
	 */
	private Long putawayStrategyId;

	/**
	 * 混放策略ID
	 */
	private Long mixStrategyId;

	/**
	 * 拣选策略ID
	 */
	private Long pickingStrategyId;

	/**
	 * 收货方式（手动收货0还是自动收货1）
	 */
	private Integer receivingMode;

	/**
	 * 仓库分表code
	 */
	private Long warehouseCode;

	/**
	 * wcsIp
	 */
	private String wcsIp;

	/**
	 * wcsPort
	 */
	private Integer wcsPort;
	
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
	 * setter for column 仓库编码
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * getter for column 仓库编码
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * setter for column 仓库名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter for column 仓库名称
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * setter for column 仓库状态 @ warehouse.status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * getter for column 仓库状态 @ warehouse.status
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * setter for column 仓库类型,@ warehouse.type
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * getter for column 仓库类型,@ warehouse.type
	 */
	public Integer getType() {
		return this.type;
	}

	/**
	 * setter for column 仓库简码（用于生成单据）
	 */
	public void setSimpleCode(String simpleCode) {
		this.simpleCode = simpleCode;
	}

	/**
	 * getter for column 仓库简码（用于生成单据）
	 */
	public String getSimpleCode() {
		return this.simpleCode;
	}

	/**
	 * setter for column 仓库联系地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * getter for column 仓库联系地址
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * setter for column 仓库主管
	 */
	public void setMajor(String major) {
		this.major = major;
	}

	/**
	 * getter for column 仓库主管
	 */
	public String getMajor() {
		return this.major;
	}

	/**
	 * setter for column 主管电话 或者 手机
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * getter for column 主管电话 或者 手机
	 */
	public String getTel() {
		return this.tel;
	}

	/**
	 * setter for column 联系人传真
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * getter for column 联系人传真
	 */
	public String getFax() {
		return this.fax;
	}

	/**
	 * setter for column 联系人电子邮件
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * getter for column 联系人电子邮件
	 */
	public String getEmail() {
		return this.email;
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
	 * setter for column 最后修改人
	 */
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	/**
	 * getter for column 最后修改人
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
	 * setter for column 仓库批属性规则id
	 */
	public void setBatchRuleId(Long batchRuleId) {
		this.batchRuleId = batchRuleId;
	}

	/**
	 * getter for column 仓库批属性规则id
	 */
	public Long getBatchRuleId() {
		return this.batchRuleId;
	}

	/**
	 * setter for column 上架策略ID
	 */
	public void setPutawayStrategyId(Long putawayStrategyId) {
		this.putawayStrategyId = putawayStrategyId;
	}

	/**
	 * getter for column 上架策略ID
	 */
	public Long getPutawayStrategyId() {
		return this.putawayStrategyId;
	}

	/**
	 * setter for column 混放策略ID
	 */
	public void setMixStrategyId(Long mixStrategyId) {
		this.mixStrategyId = mixStrategyId;
	}

	/**
	 * getter for column 混放策略ID
	 */
	public Long getMixStrategyId() {
		return this.mixStrategyId;
	}

	/**
	 * setter for column 拣选策略ID
	 */
	public void setPickingStrategyId(Long pickingStrategyId) {
		this.pickingStrategyId = pickingStrategyId;
	}

	/**
	 * getter for column 拣选策略ID
	 */
	public Long getPickingStrategyId() {
		return this.pickingStrategyId;
	}

	public Integer getReceivingMode() {
		return receivingMode;
	}

	public void setReceivingMode(Integer receivingMode) {
		this.receivingMode = receivingMode;
	}

	public Long getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(Long warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public String getWcsIp() {
		return wcsIp;
	}

	public void setWcsIp(String wcsIp) {
		this.wcsIp = wcsIp;
	}

	public Integer getWcsPort() {
		return wcsPort;
	}

	public void setWcsPort(Integer wcsPort) {
		this.wcsPort = wcsPort;
	}

}