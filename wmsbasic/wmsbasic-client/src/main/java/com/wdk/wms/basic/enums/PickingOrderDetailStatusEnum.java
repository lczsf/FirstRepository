package com.wdk.wms.basic.enums;

/**
 * 
 * @author ai00 差异单状态枚举
 *
 */
public enum PickingOrderDetailStatusEnum {

	CREATE(1, "创建"), OUTOFSTOCK(2, "缺货完成"), FINISHED(3, "正常完成");

	private PickingOrderDetailStatusEnum(int index, String text) {
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

	public static PickingOrderDetailStatusEnum getTextByIndex(int index) {
		for (PickingOrderDetailStatusEnum t : PickingOrderDetailStatusEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}

}
