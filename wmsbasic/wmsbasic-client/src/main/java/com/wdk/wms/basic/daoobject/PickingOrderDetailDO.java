package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:拣货单明细表
 * 
 * @author 李超 Date 2015-10-12
 */
public class PickingOrderDetailDO {

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
	 * 拣货单id
	 */
	private Long pickingOrderId;

	/**
	 * 商品id
	 */
	private Long itemId;

	/**
	 * 商品名称
	 */
	private String itemName;

	/**
	 * 主计价单位
	 */
	private String mainUnit;

	/**
	 * 主计价单位应拣数量
	 */
	private Double mainShouldNumber;

	/**
	 * 主计价单位实拣数量
	 */
	private Double mainActualNumber;

	/**
	 * 拣货单位
	 */
	private String pickingUnit;

	/**
	 * 拣货单位应拣数量
	 */
	private Double pickingShouldNumber;

	/**
	 * 拣货单位实拣数量
	 */
	private Double pickingActualNumber;

	/**
	 * 附加服务
	 */
	private String accessorialService;

	/**
	 * 仓库分表code
	 */
	private Long warehouseCode;

	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 库位id
	 */
	private Long cabinetId;

	/**
	 * 波次id
	 */
	private Long waveId;

	/**
	 * 销售订单详情Id
	 */
	private Long salesOrderDetailId;

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
	 * setter for column 拣货单id
	 */
	public void setPickingOrderId(Long pickingOrderId) {
		this.pickingOrderId = pickingOrderId;
	}

	/**
	 * getter for column 拣货单id
	 */
	public Long getPickingOrderId() {
		return this.pickingOrderId;
	}

	/**
	 * setter for column 商品id
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	/**
	 * getter for column 商品id
	 */
	public Long getItemId() {
		return this.itemId;
	}

	/**
	 * setter for column 商品名称
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * getter for column 商品名称
	 */
	public String getItemName() {
		return this.itemName;
	}

	/**
	 * setter for column 主计价单位
	 */
	public void setMainUnit(String mainUnit) {
		this.mainUnit = mainUnit;
	}

	/**
	 * getter for column 主计价单位
	 */
	public String getMainUnit() {
		return this.mainUnit;
	}

	/**
	 * setter for column 主计价单位应拣数量
	 */
	public void setMainShouldNumber(Double mainShouldNumber) {
		this.mainShouldNumber = mainShouldNumber;
	}

	/**
	 * getter for column 主计价单位应拣数量
	 */
	public Double getMainShouldNumber() {
		return this.mainShouldNumber;
	}

	/**
	 * setter for column 主计价单位实拣数量
	 */
	public void setMainActualNumber(Double mainActualNumber) {
		this.mainActualNumber = mainActualNumber;
	}

	/**
	 * getter for column 主计价单位实拣数量
	 */
	public Double getMainActualNumber() {
		return this.mainActualNumber;
	}

	/**
	 * setter for column 拣货单位
	 */
	public void setPickingUnit(String pickingUnit) {
		this.pickingUnit = pickingUnit;
	}

	/**
	 * getter for column 拣货单位
	 */
	public String getPickingUnit() {
		return this.pickingUnit;
	}

	/**
	 * setter for column 拣货单位应拣数量
	 */
	public void setPickingShouldNumber(Double pickingShouldNumber) {
		this.pickingShouldNumber = pickingShouldNumber;
	}

	/**
	 * getter for column 拣货单位应拣数量
	 */
	public Double getPickingShouldNumber() {
		return this.pickingShouldNumber;
	}

	/**
	 * setter for column 拣货单位实拣数量
	 */
	public void setPickingActualNumber(Double pickingActualNumber) {
		this.pickingActualNumber = pickingActualNumber;
	}

	/**
	 * getter for column 拣货单位实拣数量
	 */
	public Double getPickingActualNumber() {
		return this.pickingActualNumber;
	}


	/**
	 * setter for column 附加服务
	 */
	public void setAccessorialService(String accessorialService) {
		this.accessorialService = accessorialService;
	}

	/**
	 * getter for column 附加服务
	 */
	public String getAccessorialService() {
		return this.accessorialService;
	}

	/**
	 * setter for column 仓库分表code
	 */
	public void setWarehouseCode(Long warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	/**
	 * getter for column 仓库分表code
	 */
	public Long getWarehouseCode() {
		return this.warehouseCode;
	}

	/**
	 * setter for column 状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * getter for column 状态
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * setter for column 库位id
	 */
	public void setCabinetId(Long cabinetId) {
		this.cabinetId = cabinetId;
	}

	/**
	 * getter for column 库位id
	 */
	public Long getCabinetId() {
		return this.cabinetId;
	}

	public Long getSalesOrderDetailId() {
		return salesOrderDetailId;
	}

	public void setSalesOrderDetailId(Long salesOrderDetailId) {
		this.salesOrderDetailId = salesOrderDetailId;
	}

	public Long getWaveId() {
		return waveId;
	}

	public void setWaveId(Long waveId) {
		this.waveId = waveId;
	}

}