package com.wdk.wms.basic.enums;

/**
 * 
 * @author ai00 拣货单状态枚举
 *
 */
public enum PickingOrderStatusEnum {

	CREATE(1, "创建"), UNDERWAY(2, "拣货中"), FINISHED(3, "拣货完成"), ASSIGNMENTED(4, "分配完成");

	private PickingOrderStatusEnum(int index, String text) {
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

	public static PickingOrderStatusEnum getTextByIndex(int index) {
		for (PickingOrderStatusEnum t : PickingOrderStatusEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}

}
