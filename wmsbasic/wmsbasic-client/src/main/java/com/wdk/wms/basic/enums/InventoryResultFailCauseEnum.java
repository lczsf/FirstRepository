package com.wdk.wms.basic.enums;
/*
 * 库存操作失败 原因枚举
 * @author 滴石
 */
public enum InventoryResultFailCauseEnum {
	SUCCESS(1, "成功"), INVENTORY_OUTSTOCK(-1, "缺货原因"),INVENTORY_LOCK(-2, "库存锁原因"),INVENTORY_DECIMAL(-3, "库存小数原因"),SYSTEM_ERROR(-4, "后端系统异常");

	private InventoryResultFailCauseEnum(int index, String text) {
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

	public static InventoryResultFailCauseEnum getTextByIndex(int index) {
		for (InventoryResultFailCauseEnum t : InventoryResultFailCauseEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}


}
