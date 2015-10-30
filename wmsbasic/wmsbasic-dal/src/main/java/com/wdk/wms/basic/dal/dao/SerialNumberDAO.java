package com.wdk.wms.basic.dal.dao;

import com.alibaba.dxp.daoproxy.annotation.*;
import com.wdk.wms.basic.daoobject.BasicSerialNumberDO;

import java.util.Date;

/**
 * Description: 流水号
 *
 * @author 刘勇
 * @Date 15/9/28
 */
@Dao("basic_serial_number")
public interface SerialNumberDAO {

	/**
	 * 插入流水号
	 * 
	 * @param serialNumberDO
	 * @return
	 */
	@Insert
	Long insertSerialNumber(BasicSerialNumberDO serialNumberDO);

	/**
	 * 通过时间和类型查询
	 * 
	 * @param date
	 *            流水号时间
	 * @param serialType
	 *            流水号类型
	 * @return
	 */
	@Select
	BasicSerialNumberDO queryByDateAndType(@Param("date") String date, @Param("serialType") String serialType);

	/**
	 * 更新
	 * 
	 * @param serialNumberDO
	 * @return
	 */
	@Update
	int updateSerialNumber(BasicSerialNumberDO serialNumberDO);

	/**
	 * 通过id查询
	 * 
	 * @param id
	 * @return
	 */
	@Select
	BasicSerialNumberDO queryById(Long id);
}
