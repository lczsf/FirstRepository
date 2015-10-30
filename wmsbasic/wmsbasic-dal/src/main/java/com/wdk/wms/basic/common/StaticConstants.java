package com.wdk.wms.basic.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 静态参数类
 *
 * @author 刘勇
 * @Date 15/10/23
 */
public abstract class StaticConstants {

	/**
	 * 可以有 3位小数的单位
	 */
	final static List<String> units = new ArrayList<String>();

	static {
		units.add("KG");
	}
}
