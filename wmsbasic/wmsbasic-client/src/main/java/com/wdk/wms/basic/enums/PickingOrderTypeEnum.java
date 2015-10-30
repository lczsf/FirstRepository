package com.wdk.wms.basic.enums;

/**
 * 
 * @author ai00 差异单状态枚举
 *
 */
public enum PickingOrderTypeEnum {

	SALES(1, "销售拣货");

	private PickingOrderTypeEnum(int index, String text) {
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

	public static PickingOrderTypeEnum getTextByIndex(int index) {
		for (PickingOrderTypeEnum t : PickingOrderTypeEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}

}
