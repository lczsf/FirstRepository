package com.wdk.wms.basic.enums;

/*
 * 库存操作方式枚举
 * @author 滴石
 */
public enum InventoryOperateModeEnum {
	OCCUPY(1, "占用"), DEDUCTION(2, "扣减");

	private InventoryOperateModeEnum(int index, String text) {
		this.index = index;
		this.text = text;
	}

	private int index;

	private String text;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getText() {
		return text;
	}

	public void setStatus(String text) {
		this.text = text;
	}

	public static InventoryOperateModeEnum getTextByIndex(int index) {
		for (InventoryOperateModeEnum t : InventoryOperateModeEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}

}
