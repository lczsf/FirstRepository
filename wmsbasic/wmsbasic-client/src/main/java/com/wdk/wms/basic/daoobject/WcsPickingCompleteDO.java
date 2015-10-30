package com.wdk.wms.basic.daoobject;

import java.util.Date;

/**
 * Description:拣货装箱单满箱状态后发送wcs指令
 * 
 * @author 李远 Date 2015-10-22
 */
public class WcsPickingCompleteDO {

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
	 * 容器号
	 */
	private String containerCode;

	/**
	 * 波次号
	 */
	private String waveCode;

	/**
	 * 1、普通即时达；2、普通定时达含有热食；3、普通定时达不含热食
	 */
	private Integer attribute;

	/**
	 * 0 默认值 待发送 1 正在发送 2 发送完成
	 */
	private Integer status;

	private String wcsIp;

	private Integer wcsPort;

	private Long seqNum;
	private long packingCompleteBaseLine = 200000000;
	private Long warehouseId;

	private Integer failureTimes;

	public Integer getFailureTimes() {
		return failureTimes;
	}

	public void setFailureTimes(Integer failureTimes) {
		this.failureTimes = failureTimes;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
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

	public Long getSeqNum() {
		seqNum = packingCompleteBaseLine + id;
		return seqNum;
	}

	public void setSeqNum(Long seqNum) {
		this.seqNum = seqNum;
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
	 * setter for column 容器号
	 */
	public void setContainerCode(String containerCode) {
		this.containerCode = containerCode;
	}

	/**
	 * getter for column 容器号
	 */
	public String getContainerCode() {
		return this.containerCode;
	}

	/**
	 * setter for column 波次号
	 */
	public void setWaveCode(String waveCode) {
		this.waveCode = waveCode;
	}

	/**
	 * getter for column 波次号
	 */
	public String getWaveCode() {
		return this.waveCode;
	}

	/**
	 * setter for column 1、普通即时达；2、普通定时达含有热食；3、普通定时达不含热食
	 */
	public void setAttribute(Integer attribute) {
		this.attribute = attribute;
	}

	/**
	 * getter for column 1、普通即时达；2、普通定时达含有热食；3、普通定时达不含热食
	 */
	public Integer getAttribute() {
		return this.attribute;
	}

	/**
	 * setter for column 0 默认值 待发送 1 正在发送 2 发送完成
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * getter for column 0 默认值 待发送 1 正在发送 2 发送完成
	 */
	public Integer getStatus() {
		return this.status;
	}
}