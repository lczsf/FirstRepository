package com.wdk.wms.basic.enums;

/*
 * 批次或者订单履约类型枚举
 * @author 滴石
 */
public enum OrderPerformanceTypeEnum {
	
	DELIVERY(1, "配送"), SCENE_PURCHASE(2, "现场购买"), APPOINT_PURCHASE(3, "预约自提"),WHOLESALE(4, "批发");

	private OrderPerformanceTypeEnum(int index, String text) {
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

	public static OrderPerformanceTypeEnum getTextByIndex(int index) {
		for (OrderPerformanceTypeEnum t : OrderPerformanceTypeEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}

}
