package com.wdk.wms.basic.daoobject;

import java.util.Date;

public class BasicPartnerDO {

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
	 * 商业伙伴编码
	 */
	private String code;

	/**
	 * 业务组编号关联业务组表
	 */
	private Long warehouseId;

	/**
	 * 商业伙伴简称
	 */
	private String simpleName;

	/**
	 * 状态编号@partner.status
	 */
	private Integer status;

	/**
	 * 商业伙伴级别@partner.level
	 */
	private Integer level;

	/**
	 * 联系人地址信息多个以（地址；地址；地址）
	 */
	private String contactAddress;

	/**
	 * 联系人信息多个以（联系人；联系人；联系人）
	 */
	private String contactName;

	/**
	 * 联系人电话信息多个以（电话；电话；电话）
	 */
	private String contactTel;

	/**
	 * 联系邮箱
	 */
	private String contactEmail;

	/**
	 * 联系传真
	 */
	private String contactFax;

	/**
	 * 备注信息
	 */
	private String remark;

	/**
	 * 操作员编号
	 */
	private Long operatorId;

	/**
	 * 扩展信息
	 */
	private String feature;

	/**
	 * 伙伴类型
	 */
	private Integer partnerType;

	/**
	 * 名字
	 */
	private String name;

	/**
	 * 货主设置的批属性规则
	 */
	private Long batchRuleId;

	/**
	 * 上架策略id
	 */
	private Long putawayStrategyId;

	/**
	 * 混放策略id
	 */
	private Long mixStrategyId;

	/**
	 * 操作人ip
	 */
	private String operatorIp;

	/**
	 * 拣选策略ID
	 */
	private Long pickingStrategyId;

	/**
	 * 关于商业合作伙伴的配置信息存放（历史部分配置放在feature中的）
	 */
	private String config;

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
	 * setter for column 商业伙伴编码
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * getter for column 商业伙伴编码
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * setter for column 业务组编号关联业务组表
	 */
	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	/**
	 * getter for column 业务组编号关联业务组表
	 */
	public Long getWarehouseId() {
		return this.warehouseId;
	}

	/**
	 * setter for column 商业伙伴简称
	 */
	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}

	/**
	 * getter for column 商业伙伴简称
	 */
	public String getSimpleName() {
		return this.simpleName;
	}



	/**
	 * setter for column 状态编号@partner.status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * getter for column 状态编号@partner.status
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * setter for column 商业伙伴级别@partner.level
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

	/**
	 * getter for column 商业伙伴级别@partner.level
	 */
	public Integer getLevel() {
		return this.level;
	}

	/**
	 * setter for column 联系人地址信息多个以（地址；地址；地址）
	 */
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	/**
	 * getter for column 联系人地址信息多个以（地址；地址；地址）
	 */
	public String getContactAddress() {
		return this.contactAddress;
	}

	/**
	 * setter for column 联系人信息多个以（联系人；联系人；联系人）
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	/**
	 * getter for column 联系人信息多个以（联系人；联系人；联系人）
	 */
	public String getContactName() {
		return this.contactName;
	}

	/**
	 * setter for column 联系人电话信息多个以（电话；电话；电话）
	 */
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	/**
	 * getter for column 联系人电话信息多个以（电话；电话；电话）
	 */
	public String getContactTel() {
		return this.contactTel;
	}

	/**
	 * setter for column 联系邮箱
	 */
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	/**
	 * getter for column 联系邮箱
	 */
	public String getContactEmail() {
		return this.contactEmail;
	}

	/**
	 * setter for column 联系传真
	 */
	public void setContactFax(String contactFax) {
		this.contactFax = contactFax;
	}

	/**
	 * getter for column 联系传真
	 */
	public String getContactFax() {
		return this.contactFax;
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
	 * setter for column 操作员编号
	 */
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	/**
	 * getter for column 操作员编号
	 */
	public Long getOperatorId() {
		return this.operatorId;
	}

	/**
	 * setter for column 扩展信息
	 */
	public void setFeature(String feature) {
		this.feature = feature;
	}

	/**
	 * getter for column 扩展信息
	 */
	public String getFeature() {
		return this.feature;
	}

	/**
	 * setter for column 伙伴类型
	 */
	public void setPartnerType(Integer partnerType) {
		this.partnerType = partnerType;
	}

	/**
	 * getter for column 伙伴类型
	 */
	public Integer getPartnerType() {
		return this.partnerType;
	}

	/**
	 * setter for column 名字
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter for column 名字
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * setter for column 货主设置的批属性规则
	 */
	public void setBatchRuleId(Long batchRuleId) {
		this.batchRuleId = batchRuleId;
	}

	/**
	 * getter for column 货主设置的批属性规则
	 */
	public Long getBatchRuleId() {
		return this.batchRuleId;
	}

	/**
	 * setter for column 上架策略id
	 */
	public void setPutawayStrategyId(Long putawayStrategyId) {
		this.putawayStrategyId = putawayStrategyId;
	}

	/**
	 * getter for column 上架策略id
	 */
	public Long getPutawayStrategyId() {
		return this.putawayStrategyId;
	}

	/**
	 * setter for column 混放策略id
	 */
	public void setMixStrategyId(Long mixStrategyId) {
		this.mixStrategyId = mixStrategyId;
	}

	/**
	 * getter for column 混放策略id
	 */
	public Long getMixStrategyId() {
		return this.mixStrategyId;
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

	/**
	 * setter for column 关于商业合作伙伴的配置信息存放（历史部分配置放在feature中的）
	 */
	public void setConfig(String config) {
		this.config = config;
	}

	/**
	 * getter for column 关于商业合作伙伴的配置信息存放（历史部分配置放在feature中的）
	 */
	public String getConfig() {
		return this.config;
	}

}
