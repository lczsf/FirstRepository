package com.wdk.wms.basic.common;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonUtils {

	private static final Logger log = LoggerFactory.getLogger(CommonUtils.class);

	/**
	 * 通过反射获取fields然后进行赋值; 有继承关系的field无法赋值
	 * 
	 * @param sour
	 * @param dest
	 * @throws Exception
	 */
	public static void doTrans(Object sour, Object dest) throws Exception {

		if (sour == null) {
			dest = null;
			return;
		}

		Class<?> sourClass = sour.getClass();
		Class<?> destClass = dest.getClass();

		for (Field modelField : sourClass.getDeclaredFields()) {

			String fieldName = modelField.getName();
			Object value;

			if (fieldName.equals("serialVersionUID")) {
				continue;
			}

			try {
				PropertyDescriptor pdModel = new PropertyDescriptor(fieldName, sourClass);
				value = pdModel.getReadMethod().invoke(sour);
			} catch (Exception e) {
				if (log.isDebugEnabled()) {
					log.debug(sour.getClass().getName() + " - " + dest.getClass().getName() + " - " + fieldName + " - " + e.getMessage());
				}
				continue;
			}

			if (value == null) {
				continue;
			}

			try {
				PropertyDescriptor pdDto = new PropertyDescriptor(fieldName, destClass);
				pdDto.getWriteMethod().invoke(dest, value);
			} catch (Exception e) {
				if (log.isDebugEnabled()) {
					log.debug(sour.getClass().getName() + " - " + dest.getClass().getName() + " - " + fieldName + " - " + e.getMessage());
				}
				continue;
			}
		}
	}

	/**
	 * 通过反射获取所有set为前缀的方法,然后截断set字符串,余下的字符串作为field进行赋值; 优先使用doTrans方法
	 * 
	 * @param sour
	 * @param dest
	 * @throws Exception
	 */
	public static void doTransAll(Object sour, Object dest) throws Exception {

		if (sour == null) {
			dest = null;
			return;
		}

		Class<?> sourClass = sour.getClass();
		Class<?> destClass = dest.getClass();

		for (Method method : sourClass.getMethods()) {

			String methodName = method.getName();

			if (!methodName.startsWith("set")) {
				continue;
			}

			String fieldName = methodName.substring(3);
			Object value;

			if (fieldName.equals("serialVersionUID")) {
				continue;
			}

			try {
				PropertyDescriptor pdModel = new PropertyDescriptor(fieldName, sourClass);
				value = pdModel.getReadMethod().invoke(sour);
			} catch (Exception e) {
				if (log.isDebugEnabled()) {
					log.debug(sour.getClass().getName() + " - " + dest.getClass().getName() + " - " + fieldName + " - " + e.getMessage());
				}
				continue;
			}

			if (value == null) {
				continue;
			}

			try {
				PropertyDescriptor pdDto = new PropertyDescriptor(fieldName, destClass);
				pdDto.getWriteMethod().invoke(dest, value);
			} catch (Exception e) {
				if (log.isDebugEnabled()) {
					log.debug(sour.getClass().getName() + " - " + dest.getClass().getName() + " - " + fieldName + " - " + e.getMessage());
				}
				continue;
			}
		}
	}

}
