package com.wdk.wms.basic.enums;

/**
 * 
 * @author ai00 差异单状态枚举
 *
 */
public enum DifferOrderStatusEnum {

	CREATE(1, "创建"), PROCCED(2, "已处理");

	private DifferOrderStatusEnum(int index, String text) {
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

	public static DifferOrderStatusEnum getTextByIndex(int index) {
		for (DifferOrderStatusEnum t : DifferOrderStatusEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}

}
