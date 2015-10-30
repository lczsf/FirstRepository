package com.wdk.wms.basic.daoobject;

import java.util.Date;
import java.util.List;

/**
 * Description:拣货分区表
 * 
 * @author 李超 Date 2015-09-22
 */
public class SortingGoodsPartitionDO {

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
	 * 区域名称
	 */
	private String name;

	/**
	 * 所属仓库id
	 */
	private Long warehouseId;

	/**
	 * 拣货排序号
	 */
	private Integer pickSort;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 最后操作员修改人id
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
	 * 拣货工具
	 */
	private Integer pickTool;

	/**
	 * 包裹生成方式
	 */
	private Integer packageGenerationMethod;

	/**
	 * 是否悬挂链
	 */
	private Integer isHanging;

	/**
	 * 类型
	 */
	private Integer type;
	/**
	 * 库位的list集合
	 */
	private List<BasicCabinetDO> cabinetList;

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
	 * setter for column 最后操作员修改人id
	 */
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	/**
	 * getter for column 最后操作员修改人id
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
	 * setter for column 拣货工具
	 */
	public void setPickTool(Integer pickTool) {
		this.pickTool = pickTool;
	}

	/**
	 * getter for column 拣货工具
	 */
	public Integer getPickTool() {
		return this.pickTool;
	}

	/**
	 * setter for column 包裹生成方式
	 */
	public void setPackageGenerationMethod(Integer packageGenerationMethod) {
		this.packageGenerationMethod = packageGenerationMethod;
	}

	/**
	 * getter for column 包裹生成方式
	 */
	public Integer getPackageGenerationMethod() {
		return this.packageGenerationMethod;
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

	public List<BasicCabinetDO> getCabinetList() {
		return cabinetList;
	}

	public void setCabinetList(List<BasicCabinetDO> cabinetList) {
		this.cabinetList = cabinetList;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}