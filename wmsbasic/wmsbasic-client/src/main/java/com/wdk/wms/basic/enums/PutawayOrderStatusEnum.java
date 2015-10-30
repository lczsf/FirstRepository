package com.wdk.wms.basic.enums;

/**
 * 
 * @author dishi 上架单状态枚举
 *
 */
public enum PutawayOrderStatusEnum {

	CREATE(1, "创建"), FINISH(2, "完成");

	private PutawayOrderStatusEnum(int index, String text) {
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

	public static PutawayOrderStatusEnum getTextByIndex(int index) {
		for (PutawayOrderStatusEnum t : PutawayOrderStatusEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}
}