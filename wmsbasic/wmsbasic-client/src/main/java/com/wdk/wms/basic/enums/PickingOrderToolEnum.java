package com.wdk.wms.basic.enums;

/**
 * 
 * @author ai00 拣货工具枚举
 *
 */
public enum PickingOrderToolEnum {

	RF(1, "RF拣货工具");

	private PickingOrderToolEnum(int index, String text) {
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

	public static PickingOrderToolEnum getTextByIndex(int index) {
		for (PickingOrderToolEnum t : PickingOrderToolEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}

}
