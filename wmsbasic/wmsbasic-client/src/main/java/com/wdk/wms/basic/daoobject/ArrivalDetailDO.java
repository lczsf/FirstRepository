package com.wdk.wms.basic.daoobject;

/**
 * Description: 待收或已收通知单明细
 *
 * @author 刘勇
 * @Date 15/9/21
 */
public class ArrivalDetailDO {

	/**
	 * 主键id
	 */
	private Long id;

	/**
	 * 通知单id
	 */
	private Long asnId;

	/**
	 * 商品名称
	 */
	private String itemName;

	/**
	 * 商品id
	 */
	private Long itemId;

	/**
	 * 商品编码
	 */
	private String itemCode;

	/**
	 * 商品单位
	 */
	private String unit;

	/**
	 * 商品规格
	 */
	private Integer spec;

	/**
	 * 数量
	 * 
	 * @return
	 */
	private Integer quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getSpec() {
		return spec;
	}

	public void setSpec(Integer spec) {
		this.spec = spec;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getAsnId() {
		return asnId;
	}

	public void setAsnId(Long asnId) {
		this.asnId = asnId;
	}
}
