package com.wdk.wms.basic.enums;

public enum ArtificialTaskStatusEnum {

	CREATE(1, "创建"), FINISH(2, "完成");

	private ArtificialTaskStatusEnum(int index, String text) {
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

	public static ArtificialTaskStatusEnum getTextByIndex(int index) {
		for (ArtificialTaskStatusEnum t : ArtificialTaskStatusEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}

}
