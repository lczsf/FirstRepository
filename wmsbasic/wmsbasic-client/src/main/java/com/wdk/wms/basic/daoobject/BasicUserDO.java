package com.wdk.wms.basic.daoobject;

import java.util.Date;
import java.util.List;

/**
 * Description:用户信息表
 * 
 * @author 刘勇 Date 2015-09-02
 */
public class BasicUserDO {

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
	 * 登录账号
	 */
	private String account;

	/**
	 * 工号（+归属仓库唯一，与归属仓库必须同时出现）
	 */
	private String workNumber;

	/**
	 * 归属仓库（一个用户只有一个）
	 */
	private Long warehouseId;

	/**
	 * 归属仓库name
	 */
	private String warehouseName;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 姓名
	 */
	private String userName;

	/**
	 * 状态（1=正常；-1=注销）@user.status
	 */
	private Integer status;

	/**
	 * 性别（1=男；2=女）
	 */
	private Integer sex;

	/**
	 * 年龄
	 */
	private Integer age;

	/**
	 * 手机号码
	 */
	private String mobile;

	/**
	 * 电话（手机和电话必填一个）
	 */
	private String tel;

	/**
	 * 联系地址
	 */
	private String address;

	/**
	 * 最后一次登录时间
	 */
	private Date lastLoginTime;

	/**
	 * 扩展字段
	 */
	private String feature;

	/**
	 * 用户类型（1=库工）
	 */
	private Integer type;

	/**
	 * 组别（收货质检组，库内操作组）
	 */
	private Integer groupType;

	/**
	 * 操作人
	 */
	private Long operatorId;

	/**
	 * 操作人ip
	 */
	private String operatorIp;

	/**
	 * 集团小二账号
	 */
	private String xiaoerAccount;


	/**
	 * 可操作仓库Ids xx,xx,xx
	 */
	private String warehouseIds;

	/**
	 * 可操作仓库集合
	 */
	private List<BasicWarehouseDO> warehouseDOs;

	public List<BasicWarehouseDO> getWarehouseDOs() {
		return warehouseDOs;
	}

	public void setWarehouseDOs(List<BasicWarehouseDO> warehouseDOs) {
		this.warehouseDOs = warehouseDOs;
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
	 * setter for column 登录账号
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * getter for column 登录账号
	 */
	public String getAccount() {
		return this.account;
	}

	/**
	 * setter for column 工号（+归属仓库唯一，与归属仓库必须同时出现）
	 */
	public void setWorkNumber(String workNumber) {
		this.workNumber = workNumber;
	}

	/**
	 * getter for column 工号（+归属仓库唯一，与归属仓库必须同时出现）
	 */
	public String getWorkNumber() {
		return this.workNumber;
	}

	/**
	 * setter for column 归属仓库（一个用户只有一个）
	 */
	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	/**
	 * getter for column 归属仓库（一个用户只有一个）
	 */
	public Long getWarehouseId() {
		return this.warehouseId;
	}

	/**
	 * setter for column 密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * getter for column 密码
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * setter for column 姓名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * getter for column 姓名
	 */
	public String getUserName() {
		return this.userName;
	}

	/**
	 * setter for column 状态（1=正常；-1=注销）@user.status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * getter for column 状态（1=正常；-1=注销）@user.status
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * setter for column 性别（1=男；2=女）
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	/**
	 * getter for column 性别（1=男；2=女）
	 */
	public Integer getSex() {
		return this.sex;
	}

	/**
	 * setter for column 年龄
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * getter for column 年龄
	 */
	public Integer getAge() {
		return this.age;
	}

	/**
	 * setter for column 手机号码
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * getter for column 手机号码
	 */
	public String getMobile() {
		return this.mobile;
	}

	/**
	 * setter for column 电话（手机和电话必填一个）
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * getter for column 电话（手机和电话必填一个）
	 */
	public String getTel() {
		return this.tel;
	}

	/**
	 * setter for column 联系地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * getter for column 联系地址
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * setter for column 最后一次登录时间
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * getter for column 最后一次登录时间
	 */
	public Date getLastLoginTime() {
		return this.lastLoginTime;
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
	 * setter for column 用户类型（1=库工）
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * getter for column 用户类型（1=库工）
	 */
	public Integer getType() {
		return this.type;
	}

	/**
	 * setter for column 组别（收货质检组，库内操作组）
	 */
	public void setGroupType(Integer groupType) {
		this.groupType = groupType;
	}

	/**
	 * getter for column 组别（收货质检组，库内操作组）
	 */
	public Integer getGroupType() {
		return this.groupType;
	}

	/**
	 * setter for column 操作人
	 */
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	/**
	 * getter for column 操作人
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
	 * setter for column 集团小二账号
	 */
	public void setXiaoerAccount(String xiaoerAccount) {
		this.xiaoerAccount = xiaoerAccount;
	}

	/**
	 * getter for column 集团小二账号
	 */
	public String getXiaoerAccount() {
		return this.xiaoerAccount;
	}

	public String getWarehouseIds() {
		return warehouseIds;
	}

	public void setWarehouseIds(String warehouseIds) {
		this.warehouseIds = warehouseIds;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

}
