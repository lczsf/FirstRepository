package com.wdk.wms.basic.enums;

/**
 * 
 * @author lichao 容器状态
 *
 */
public enum ContainerStatusEnum {
	Free(1, "空闲"), Occupy(2, "占用"), Disable(3, "停用");

	private ContainerStatusEnum(int index, String text) {
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

	public static ContainerStatusEnum getTextByIndex(int index) {
		for (ContainerStatusEnum t : ContainerStatusEnum.values()) {
			if (t.getIndex() == index) {
				return t;
			}
		}
		return null;
	}

}
