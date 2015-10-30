package com.wdk.wms.basic.daoobject;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Description:商品SKU
 * 
 * @author 李超 Date 2015-09-25
 */
public class BasicItemDO {

	/**
	 * 唯一、自增Id，主键，系统编号
	 */
	private Long id;

	/**
	 * 商品编码(所属业务组别)+sku唯一，一般存放sku
	 */
	private String code;

	/**
	 * 商品状态
	 */
	private Integer status;

	/**
	 * 商品名称
	 */
	private String name;

	/**
	 * 商品简称
	 */
	private String simpleName;

	/**
	 * 规格
	 */
	private Integer specification;

	/**
	 * 默认条码，来源商品条码表
	 */
	private String barcode;

	/**
	 * 重量、默认0 克
	 */
	private Integer weight;

	/**
	 * 体积、默认0 立方厘米
	 */
	private Double volume;

	/**
	 * 价格、默认0元人民币
	 */
	private Integer price;

	/**
	 * 长
	 */
	private Double length;

	/**
	 * 宽
	 */
	private Double width;

	/**
	 * 高
	 */
	private Double height;

	/**
	 * 是否保质期（1是，0否）
	 */
	private Integer isShelflife;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 默认类别id,外键，来源商品类别表（存储分类设置到叶子节点）
	 */
	private String itemTypeCode;

	/**
	 * 操作员ID
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
	 * 品牌名称
	 */
	private String brandName;

	/**
	 * 保质期预警天数
	 */
	private Integer warnDays;

	/**
	 * 超收比例
	 */
	private BigDecimal overloadRate;

	/**
	 * 采购单位
	 */
	private String purchaseUnit;


	/**
	 * 均重
	 */
	private BigDecimal counterPoise;

	/**
	 * 库存单位
	 */
	private String inventoryUnit;

	/**
	 * 保质天数
	 */
	private Integer expirationDays;

	/**
	 * 禁收时限
	 */
	private Integer forbidReceiveDays;

	/**
	 * 禁售时限
	 */
	private Integer forbidSalesDays;

	/**
	 * 是否称重
	 */
	private Integer isWeigh;

	/**
	 * 是否大件商品
	 */
	private Integer isBigItem;

	/**
	 * 是否加工商品
	 */
	private Integer isProcessItem;

	/**
	 * 是否追溯
	 */
	private Integer isTrace;

	/**
	 * abc分类
	 */
	private Integer salesVolume;

	/**
	 * 包装方式
	 */
	private String packMode;

	/**
	 * 存储类型
	 */
	private Integer storageType;

	/**
	 * 销售单位
	 */
	private String salesUnit;

	/**
	 * 是否标品
	 */
	private Integer isStandard;

	/**
	 * 版本号
	 */
	private Integer version;

	/**
	 * setter for column 唯一、自增Id，主键，系统编号
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * getter for column 唯一、自增Id，主键，系统编号
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * setter for column 商品编码(所属业务组别)+sku唯一，一般存放sku
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * getter for column 商品编码(所属业务组别)+sku唯一，一般存放sku
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * setter for column 商品状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * getter for column 商品状态
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * setter for column 商品名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter for column 商品名称
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * setter for column 商品简称
	 */
	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}

	/**
	 * getter for column 商品简称
	 */
	public String getSimpleName() {
		return this.simpleName;
	}

	/**
	 * setter for column 规格
	 */
	public void setSpecification(Integer specification) {
		this.specification = specification;
	}

	/**
	 * getter for column 规格
	 */
	public Integer getSpecification() {
		return this.specification;
	}

	/**
	 * setter for column 默认条码，来源商品条码表
	 */
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	/**
	 * getter for column 默认条码，来源商品条码表
	 */
	public String getBarcode() {
		return this.barcode;
	}


	/**
	 * setter for column 重量、默认0 克
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	/**
	 * getter for column 重量、默认0 克
	 */
	public Integer getWeight() {
		return this.weight;
	}

	/**
	 * setter for column 体积、默认0 立方厘米
	 */
	public void setVolume(Double volume) {
		this.volume = volume;
	}

	/**
	 * getter for column 体积、默认0 立方厘米
	 */
	public Double getVolume() {
		return this.volume;
	}

	/**
	 * setter for column 价格、默认0元人民币
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * getter for column 价格、默认0元人民币
	 */
	public Integer getPrice() {
		return this.price;
	}


	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Integer getIsStandard() {
		return isStandard;
	}

	public void setIsStandard(Integer isStandard) {
		this.isStandard = isStandard;
	}

	/**
	 * setter for column 是否保质期（1是，0否）
	 */
	public void setIsShelflife(Integer isShelflife) {
		this.isShelflife = isShelflife;
	}

	/**
	 * getter for column 是否保质期（1是，0否）
	 */
	public Integer getIsShelflife() {
		return this.isShelflife;
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
	 * setter for column 默认类别id,外键，来源商品类别表（存储分类设置到叶子节点）
	 */


	/**
	 * setter for column 操作员ID
	 */
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public String getItemTypeCode() {
		return itemTypeCode;
	}

	public void setItemTypeCode(String itemTypeCode) {
		this.itemTypeCode = itemTypeCode;
	}

	/**
	 * getter for column 操作员ID
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

	/**
	 * setter for column 品牌名称
	 */


	/**
	 * setter for column 保质期预警天数
	 */
	public void setWarnDays(Integer warnDays) {
		this.warnDays = warnDays;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	/**
	 * getter for column 保质期预警天数
	 */
	public Integer getWarnDays() {
		return this.warnDays;
	}

	/**
	 * setter for column 超收比例
	 */
	public void setOverloadRate(BigDecimal overloadRate) {
		this.overloadRate = overloadRate;
	}

	/**
	 * getter for column 超收比例
	 */
	public BigDecimal getOverloadRate() {
		return this.overloadRate;
	}

	/**
	 * setter for column 采购单位
	 */
	public void setPurchaseUnit(String purchaseUnit) {
		this.purchaseUnit = purchaseUnit;
	}

	/**
	 * getter for column 采购单位
	 */
	public String getPurchaseUnit() {
		return this.purchaseUnit;
	}

	/**
	 * setter for column ERP预扣款重量
	 */
	public void setCounterPoise(BigDecimal counterPoise) {
		this.counterPoise = counterPoise;
	}

	/**
	 * getter for column ERP预扣款重量
	 */
	public BigDecimal getCounterPoise() {
		return this.counterPoise;
	}

	/**
	 * setter for column 库存单位
	 */
	public void setInventoryUnit(String inventoryUnit) {
		this.inventoryUnit = inventoryUnit;
	}

	/**
	 * getter for column 库存单位
	 */
	public String getInventoryUnit() {
		return this.inventoryUnit;
	}

	/**
	 * setter for column 保质天数
	 */
	public void setExpirationDays(Integer expirationDays) {
		this.expirationDays = expirationDays;
	}

	/**
	 * getter for column 保质天数
	 */
	public Integer getExpirationDays() {
		return this.expirationDays;
	}

	/**
	 * setter for column 禁收时限
	 */
	public void setForbidReceiveDays(Integer forbidReceiveDays) {
		this.forbidReceiveDays = forbidReceiveDays;
	}

	/**
	 * getter for column 禁收时限
	 */
	public Integer getForbidReceiveDays() {
		return this.forbidReceiveDays;
	}

	/**
	 * setter for column 禁售时限
	 */
	public void setForbidSalesDays(Integer forbidSalesDays) {
		this.forbidSalesDays = forbidSalesDays;
	}

	/**
	 * getter for column 禁售时限
	 */
	public Integer getForbidSalesDays() {
		return this.forbidSalesDays;
	}

	/**
	 * setter for column 是否称重
	 */
	public void setIsWeigh(Integer isWeigh) {
		this.isWeigh = isWeigh;
	}

	/**
	 * getter for column 是否称重
	 */
	public Integer getIsWeigh() {
		return this.isWeigh;
	}

	/**
	 * setter for column 是否大件商品
	 */
	public void setIsBigItem(Integer isBigItem) {
		this.isBigItem = isBigItem;
	}

	/**
	 * getter for column 是否大件商品
	 */
	public Integer getIsBigItem() {
		return this.isBigItem;
	}

	/**
	 * setter for column 是否加工商品
	 */
	public void setIsProcessItem(Integer isProcessItem) {
		this.isProcessItem = isProcessItem;
	}

	/**
	 * getter for column 是否加工商品
	 */
	public Integer getIsProcessItem() {
		return this.isProcessItem;
	}

	/**
	 * setter for column 是否追溯
	 */
	public void setIsTrace(Integer isTrace) {
		this.isTrace = isTrace;
	}

	/**
	 * getter for column 是否追溯
	 */
	public Integer getIsTrace() {
		return this.isTrace;
	}

	/**
	 * setter for column abc分类
	 */
	public void setSalesVolume(Integer salesVolume) {
		this.salesVolume = salesVolume;
	}

	/**
	 * getter for column abc分类
	 */
	public Integer getSalesVolume() {
		return this.salesVolume;
	}

	/**
	 * setter for column 包装方式
	 */
	public void setPackMode(String packMode) {
		this.packMode = packMode;
	}

	/**
	 * getter for column 包装方式
	 */
	public String getPackMode() {
		return this.packMode;
	}

	/**
	 * setter for column 温控类型
	 */

	public Integer getStorageType() {
		return storageType;
	}

	public void setStorageType(Integer storageType) {
		this.storageType = storageType;
	}

	/**
	 * setter for column 销售单位
	 */
	public void setSalesUnit(String salesUnit) {
		this.salesUnit = salesUnit;
	}

	/**
	 * getter for column 销售单位
	 */
	public String getSalesUnit() {
		return this.salesUnit;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}