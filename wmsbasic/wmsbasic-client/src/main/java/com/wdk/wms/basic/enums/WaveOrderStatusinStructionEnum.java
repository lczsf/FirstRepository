package com.wdk.wms.basic.enums;

/*
 * 波次状态说明枚举@dishi
 */
public enum WaveOrderStatusinStructionEnum {

	ORDER_ALL_CANCEL_WAVE(1, "订单全取消-生成波次"), ORDERS_ALL_CANCEL_PICKING(2, "订单全取消-拣货中");

	private WaveOrderStatusinStructionEnum(int index, String text) {
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

	public static WaveOrderStatusinStructionEnum getTextByIndex(int index) {
		for (WaveOrderStatusinStructionEnum t : WaveOrderStatusinStructionEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}


}
