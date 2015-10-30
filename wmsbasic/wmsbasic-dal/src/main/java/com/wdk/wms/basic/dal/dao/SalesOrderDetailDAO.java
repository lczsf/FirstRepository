package com.wdk.wms.basic.dal.dao;

import java.util.List;

import com.alibaba.dxp.daoproxy.annotation.Dao;
import com.alibaba.dxp.daoproxy.annotation.Insert;
import com.alibaba.dxp.daoproxy.annotation.Param;
import com.alibaba.dxp.daoproxy.annotation.Select;
import com.alibaba.dxp.daoproxy.annotation.Update;
import com.wdk.wms.basic.daoobject.SalesOrderDetailDO;
import com.wdk.wms.basic.query.parameters.SalesOrderDetailQuery;

@Dao("sales_order_detail")
public interface SalesOrderDetailDAO {

	@Select
	List<SalesOrderDetailDO> querySalesOrderDetail(SalesOrderDetailQuery salesOrderDetailQuery);

	@Update
	int updateStatusById(@Param("status") int status, @Param("id") long id, @Param("waveId") long waveId, @Param("warehouseCode") long warehouseCode);

	@Select
	int querySalesOrderDetailCount(SalesOrderDetailQuery salesOrderDetailQuery);

	@Insert
	long insertSalesOrderDetail(SalesOrderDetailDO salesOrderDetailDO);

	/**
	 * 通过波次id 查询
	 * 
	 * @param status
	 *            状态
	 * @param salesOrderId
	 *            销售单id
	 * @param waveId
	 *            波次id
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            分表code
	 * @return
	 */
	@Select
	List<SalesOrderDetailDO> queryByWaveId(@Param("status") Integer status, @Param("salesOrderId") Long salesOrderId, @Param("waveId") Long waveId,
			@Param("warehouseCode") Long warehouseCode);

	/**
	 * 通过波次id 和子订单id 查找子订单
	 * 
	 * @param childOrderId
	 *            子订单id
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            仓库分表code
	 * @return
	 */
	@Select
	public SalesOrderDetailDO queryByDetailIdAndWaveId(@Param("childOrderId") long childOrderId, @Param("waveId") long waveId,
			@Param("warehouseCode") long warehouseCode);

	@Select
	public int queryByWaveIdNoStatus(@Param("waveId") long waveId, @Param("warehouseCode") long warehouseCode);

	@Select
	public SalesOrderDetailDO queryDetailBySubOrderId(@Param("subOrderId") long subOrderId, @Param("waveId") long waveId,
			@Param("warehouseCode") long warehouseCode);
	
	/**
	 * 更新所有拣货数量接口，不更新的字段传null
	 * 
	 * @param id
	 *            子订单id
	 * @param waveId
	 *            波次id
	 * @param warehouseCode
	 *            仓库分表code
	 * @param mainSortNumber
	 *            主计价单位拣货数量
	 * @param marketingSortNumber
	 *            销售单位拣货数量
	 * @param pickingSortNumber
	 *            拣货单位拣货数量
	 * @return
	 */
	@Update
	public int updateSortQuanity(@Param("id") long id, @Param("waveId") long waveId, @Param("warehouseCode") long warehouseCode,
			@Param("mainSortNumber") Double mainSortNumber, @Param("marketingSortNumber") Double marketingSortNumber,
			@Param("pickingSortNumber") Double pickingSortNumber);

	@Update
	int updateRefundAmount(@Param("id") Long id, @Param("refundAmount") Double refundAmount, @Param("waveId") Long waveId,
			@Param("warehouseCode") Long warehouseCode);

	@Update
	int updateMainSortNumberByWaveId(@Param("waveId") Long waveId, @Param("warehouseCode") Long warehouseCode);
}
