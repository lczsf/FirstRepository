package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:容器类型表
 * 
 * @author 李超 Date 2015-09-08
 */
public class BasicContainerTypeDO {

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
	 * 容器类型编码
	 */
	private String code;

	/**
	 * 仓库id，关联仓库表 base_warehouse
	 */
	private Long warehouseId;

	/**
	 * 容器类型名称
	 */
	private String name;

	/**
	 * 容器类型状态
	 * 
	 * @containerType.status
	 */
	private Integer status;

	/**
	 * 容器自重g
	 */
	private Integer weight;

	/**
	 * 长度mm
	 */
	private Integer length;

	/**
	 * 宽度mm
	 */
	private Integer width;

	/**
	 * 高度mm
	 */
	private Integer height;

	/**
	 * 体积立方mm
	 */
	private Integer volume;

	/**
	 * 最大承重g
	 */
	private Integer maxWeight;

	/**
	 * 是否悬挂链
	 */
	private Integer isHanging;

	/**
	 * 容积率
	 */
	private Integer volumeRate;

	/**
	 * 是否带多个格子1是0否
	 */
	private Integer isHasGrid;

	/**
	 * 格子布局情况
	 */
	private String gridLayout;

	/**
	 * 播种墙格子设置
	 */
	private String seedLayout;

	/**
	 * 备注信息
	 */
	private String remark;

	/**
	 * 扩展字段
	 */
	private String feature;

	/**
	 * 操作员编号
	 */
	private Long operatorId;

	/**
	 * 操作人ip
	 */
	private String operatorIp;

	/**
	 * 分类标识
	 */
	private Integer mark;

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
	 * setter for column 容器类型编码
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * getter for column 容器类型编码
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * setter for column 仓库id，关联仓库表 base_warehouse
	 */
	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	/**
	 * getter for column 仓库id，关联仓库表 base_warehouse
	 */
	public Long getWarehouseId() {
		return this.warehouseId;
	}

	/**
	 * setter for column 容器类型名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter for column 容器类型名称
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * setter for column 容器类型状态
	 * 
	 * @containerType.status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * getter for column 容器类型状态
	 * 
	 * @containerType.status
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * setter for column 容器自重g
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	/**
	 * getter for column 容器自重g
	 */
	public Integer getWeight() {
		return this.weight;
	}

	/**
	 * setter for column 长度mm
	 */
	public void setLength(Integer length) {
		this.length = length;
	}

	/**
	 * getter for column 长度mm
	 */
	public Integer getLength() {
		return this.length;
	}

	/**
	 * setter for column 宽度mm
	 */
	public void setWidth(Integer width) {
		this.width = width;
	}

	/**
	 * getter for column 宽度mm
	 */
	public Integer getWidth() {
		return this.width;
	}

	/**
	 * setter for column 高度mm
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}

	/**
	 * getter for column 高度mm
	 */
	public Integer getHeight() {
		return this.height;
	}

	/**
	 * setter for column 体积立方mm
	 */
	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	/**
	 * getter for column 体积立方mm
	 */
	public Integer getVolume() {
		return this.volume;
	}

	/**
	 * setter for column 最大承重g
	 */
	public void setMaxWeight(Integer maxWeight) {
		this.maxWeight = maxWeight;
	}

	/**
	 * getter for column 最大承重g
	 */
	public Integer getMaxWeight() {
		return this.maxWeight;
	}

	/**
	 * setter for column 是否悬挂链
	 */
	public void setIsHanging(Integer isHanging) {
		this.isHanging = isHanging;
	}

	/**
	 * getter for column 是否悬挂链
	 */
	public Integer getIsHanging() {
		return this.isHanging;
	}

	/**
	 * setter for column 容积率
	 */
	public void setVolumeRate(Integer volumeRate) {
		this.volumeRate = volumeRate;
	}

	/**
	 * getter for column 容积率
	 */
	public Integer getVolumeRate() {
		return this.volumeRate;
	}

	/**
	 * setter for column 是否带多个格子1是0否
	 */
	public void setIsHasGrid(Integer isHasGrid) {
		this.isHasGrid = isHasGrid;
	}

	/**
	 * getter for column 是否带多个格子1是0否
	 */
	public Integer getIsHasGrid() {
		return this.isHasGrid;
	}

	/**
	 * setter for column 格子布局情况
	 */
	public void setGridLayout(String gridLayout) {
		this.gridLayout = gridLayout;
	}

	/**
	 * getter for column 格子布局情况
	 */
	public String getGridLayout() {
		return this.gridLayout;
	}

	/**
	 * setter for column 播种墙格子设置
	 */
	public void setSeedLayout(String seedLayout) {
		this.seedLayout = seedLayout;
	}

	/**
	 * getter for column 播种墙格子设置
	 */
	public String getSeedLayout() {
		return this.seedLayout;
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

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

}