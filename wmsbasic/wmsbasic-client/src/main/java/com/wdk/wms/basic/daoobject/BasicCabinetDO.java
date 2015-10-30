package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:库位
 * 
 * @author 李超 Date 2015-10-13
 */
public class BasicCabinetDO {

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
	 * 库位编码
	 */
	private String code;

	/**
	 * 所属仓库id
	 */
	private Long warehouseId;

	/**
	 * 库位状态@cabinet.status
	 */
	private Integer status;

	/**
	 * 库位长度(cm)
	 */
	private Integer length;

	/**
	 * 库位宽度(cm)
	 */
	private Integer width;

	/**
	 * 库位高度(cm)
	 */
	private Integer height;

	/**
	 * 货位体积
	 */
	private Long maxCapacity;

	/**
	 * 最大承重(g)
	 */
	private Integer maxWeight;

	/**
	 * 种类数量
	 */
	private Integer maxKindNum;

	/**
	 * 商品数量
	 */
	private Integer maxNum;

	/**
	 * 库位类型
	 */
	private Integer type;

	/**
	 * 库位分类
	 */
	private Integer category;

	/**
	 * RFID
	 */
	private String rfid;

	/**
	 * 容积率
	 */
	private Integer volumeRate;

	/**
	 * 上架优先级
	 */
	private Integer rackPriority;

	/**
	 * 拣货优先级
	 */
	private Integer pickPriority;

	/**
	 * 温控类型
	 */
	private Integer temperType;

	/**
	 * 是否可售
	 */
	private Integer isActive;

	/**
	 * 最后操作员修改
	 */
	private Long operatorId;

	/**
	 * 操作人ip
	 */
	private String operatorIp;

	/**
	 * 扩展字符
	 */
	private String feature;

	/**
	 * 所属库区
	 */
	private Integer warehouseArea;

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
	 * setter for column 库位编码
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * getter for column 库位编码
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
	 * setter for column 库位状态@cabinet.status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * getter for column 库位状态@cabinet.status
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * setter for column 库位长度(cm)
	 */
	public void setLength(Integer length) {
		this.length = length;
	}

	/**
	 * getter for column 库位长度(cm)
	 */
	public Integer getLength() {
		return this.length;
	}

	/**
	 * setter for column 库位宽度(cm)
	 */
	public void setWidth(Integer width) {
		this.width = width;
	}

	/**
	 * getter for column 库位宽度(cm)
	 */
	public Integer getWidth() {
		return this.width;
	}

	/**
	 * setter for column 库位高度(cm)
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}

	/**
	 * getter for column 库位高度(cm)
	 */
	public Integer getHeight() {
		return this.height;
	}

	/**
	 * setter for column 货位体积
	 */
	public void setMaxCapacity(Long maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	/**
	 * getter for column 货位体积
	 */
	public Long getMaxCapacity() {
		return this.maxCapacity;
	}

	/**
	 * setter for column 最大承重(g)
	 */
	public void setMaxWeight(Integer maxWeight) {
		this.maxWeight = maxWeight;
	}

	/**
	 * getter for column 最大承重(g)
	 */
	public Integer getMaxWeight() {
		return this.maxWeight;
	}

	/**
	 * setter for column 种类数量
	 */
	public void setMaxKindNum(Integer maxKindNum) {
		this.maxKindNum = maxKindNum;
	}

	/**
	 * getter for column 种类数量
	 */
	public Integer getMaxKindNum() {
		return this.maxKindNum;
	}

	/**
	 * setter for column 商品数量
	 */
	public void setMaxNum(Integer maxNum) {
		this.maxNum = maxNum;
	}

	/**
	 * getter for column 商品数量
	 */
	public Integer getMaxNum() {
		return this.maxNum;
	}

	/**
	 * setter for column 库位类型
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * getter for column 库位类型
	 */
	public Integer getType() {
		return this.type;
	}

	/**
	 * setter for column 库位分类
	 */
	public void setCategory(Integer category) {
		this.category = category;
	}

	/**
	 * getter for column 库位分类
	 */
	public Integer getCategory() {
		return this.category;
	}

	/**
	 * setter for column RFID
	 */
	public void setRfid(String rfid) {
		this.rfid = rfid;
	}

	/**
	 * getter for column RFID
	 */
	public String getRfid() {
		return this.rfid;
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
	 * setter for column 上架优先级
	 */
	public void setRackPriority(Integer rackPriority) {
		this.rackPriority = rackPriority;
	}

	/**
	 * getter for column 上架优先级
	 */
	public Integer getRackPriority() {
		return this.rackPriority;
	}

	/**
	 * setter for column 拣货优先级
	 */
	public void setPickPriority(Integer pickPriority) {
		this.pickPriority = pickPriority;
	}

	/**
	 * getter for column 拣货优先级
	 */
	public Integer getPickPriority() {
		return this.pickPriority;
	}

	/**
	 * setter for column 温控类型
	 */
	public void setTemperType(Integer temperType) {
		this.temperType = temperType;
	}

	/**
	 * getter for column 温控类型
	 */
	public Integer getTemperType() {
		return this.temperType;
	}

	/**
	 * setter for column 是否可售
	 */
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	/**
	 * getter for column 是否可售
	 */
	public Integer getIsActive() {
		return this.isActive;
	}

	/**
	 * setter for column 最后操作员修改
	 */
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	/**
	 * getter for column 最后操作员修改
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
	 * setter for column 扩展字符
	 */
	public void setFeature(String feature) {
		this.feature = feature;
	}

	/**
	 * getter for column 扩展字符
	 */
	public String getFeature() {
		return this.feature;
	}

	/**
	 * setter for column 所属库区
	 */
	public void setWarehouseArea(Integer warehouseArea) {
		this.warehouseArea = warehouseArea;
	}

	/**
	 * getter for column 所属库区
	 */
	public Integer getWarehouseArea() {
		return this.warehouseArea;
	}
}