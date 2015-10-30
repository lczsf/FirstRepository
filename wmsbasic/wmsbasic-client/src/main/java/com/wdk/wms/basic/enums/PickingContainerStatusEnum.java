package com.wdk.wms.basic.enums;

/**
 * 
 * @author dishi 拣货装箱单状态枚举
 *
 */
public enum PickingContainerStatusEnum {
	CREATE(0, "创建"), FULLTANK(1, "箱满"), ALREADYREVIEWED(2, "已复核"), TEMORARY(3, "暂存"), FINISHED(4, "完成");

	private PickingContainerStatusEnum(int index, String text) {
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

	public static PickingContainerStatusEnum getTextByIndex(int index) {
		for (PickingContainerStatusEnum t : PickingContainerStatusEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}

}
