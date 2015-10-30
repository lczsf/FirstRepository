package com.wdk.wms.basic.enums;

/**
 * 
 * @author dishi 人工任务类型，1，手工波次任务，2，手工分配任务
 *
 */
public enum ArtificialTaskTypeEnum {

	ARTIFICIAL_WAVE(1, "手工波次任务"), ARTIFICIAL_DELIVERY(2, "手工分配任务");

	private ArtificialTaskTypeEnum(int index, String text) {
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

	public static ArtificialTaskTypeEnum getTextByIndex(int index) {
		for (ArtificialTaskTypeEnum t : ArtificialTaskTypeEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}
}
