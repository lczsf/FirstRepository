package com.wdk.wms.inventory.parameters;

public class ItemInventoryProcesssParameter {

	/**
	 * 来源单据
	 */
	private Long sourceOrderId;

	/**
	 * 来源单据
	 */
	private int sourceOrderType;
	/**
	 * 货主
	 */
	private Long ownerId;

	/**
	 * 仓库
	 */
	private Long warehouseId;

	/**
	 * 仓库分表code
	 */
	private Long warehouseCode;

	/**
	 * 商品ID
	 */
	private Long itemId;

	/**
	 * 商品数量（库存单位）
	 */
	private double itemQuanity;

	/**
	 * 占用还是扣减，1==占用，2=扣减
	 */
	private int occupyOrDedution;

	/**
	 * 库位类型范围
	 */
	private int[] cabinetTypeRange;
	
	/**
	 * 是否可销售
	 */
	private int isSale;

	/**
	 * 是否可多库位操作
	 */
	private boolean isMultipleCabinet;

	/**
	 * 是否可以缺货占用
	 */
	private boolean isStockoutOccupy;
	
	/**
	 * 波次id
	 */
	private Long waveId;


	public Long getSourceOrderId() {
		return sourceOrderId;
	}

	public void setSourceOrderId(Long sourceOrderId) {
		this.sourceOrderId = sourceOrderId;
	}

	public int getSourceOrderType() {
		return sourceOrderType;
	}

	public void setSourceOrderType(int sourceOrderType) {
		this.sourceOrderType = sourceOrderType;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public double getItemQuanity() {
		return itemQuanity;
	}

	public void setItemQuanity(double itemQuanity) {
		this.itemQuanity = itemQuanity;
	}

	public int getOccupyOrDedution() {
		return occupyOrDedution;
	}

	public void setOccupyOrDedution(int occupyOrDedution) {
		this.occupyOrDedution = occupyOrDedution;
	}

	public int[] getCabinetTypeRange() {
		return cabinetTypeRange;
	}

	public void setCabinetTypeRange(int[] cabinetTypeRange) {
		this.cabinetTypeRange = cabinetTypeRange;
	}

	public boolean isMultipleCabinet() {
		return isMultipleCabinet;
	}

	public void setMultipleCabinet(boolean isMultipleCabinet) {
		this.isMultipleCabinet = isMultipleCabinet;
	}

	public boolean isStockoutOccupy() {
		return isStockoutOccupy;
	}

	public void setStockoutOccupy(boolean isStockoutOccupy) {
		this.isStockoutOccupy = isStockoutOccupy;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Long getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(Long warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public int getIsSale() {
		return isSale;
	}

	public void setIsSale(int isSale) {
		this.isSale = isSale;
	}

	public Long getWaveId() {
		return waveId;
	}

	public void setWaveId(Long waveId) {
		this.waveId = waveId;
	}
	
}
