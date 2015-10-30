package com.wdk.wms.basic.enums;

/**
 * 
 * @author dishi 归位装箱单状态枚举
 *
 */
public enum BackContainerOrderStatusEnum {

	CREATE(1, "创建"), TEMORARY(2, "暂存"), FINISH(3, "完成");

	private BackContainerOrderStatusEnum(int index, String text) {
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

	public static BackContainerOrderStatusEnum getTextByIndex(int index) {
		for (BackContainerOrderStatusEnum t : BackContainerOrderStatusEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}

}
