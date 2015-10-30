package com.wdk.wms.basic.client.api;

import java.util.List;

import com.wdk.wms.basic.daoobject.SalesOrderDO;
import com.wdk.wms.basic.daoobject.SalesOrderDetailDO;
import com.wdk.wms.basic.daoobject.WaveOrderDO;
import com.wdk.wms.basic.query.parameters.SalesOrderDetailQuery;
import com.wdk.wms.basic.query.parameters.SalesOrderQuery;
import com.wdk.wms.basic.result.PageResult;

/**
 * Description:销售单，销售单详情
 * 
 * @author 李超 Date 2015-09-07
 */
public interface SalesOrderClientAPI {

	/**
	 * 分页查询销售订单
	 * 
	 * @param salesOrderDOQuery
	 * @return
	 */
	public PageResult<SalesOrderDO> querySalesOrderPage(SalesOrderQuery salesOrderDOQuery);

	/**
	 * 插入订单详情
	 * 
	 * @param salesOrderDO
	 * @return
	 */
	public long insertSalesOrder(SalesOrderDO salesOrderDO);



	/**
	 * 插入波次，销售单，销售单详情。(销售主订单重复插入，返回0；销售子订单重复插入返回-2;其他错误返回-1；正常插入返回1)
	 * 
	 * @param waveOrderDO
	 * @param salesOrderDO
	 * @param salesOrderDetailDOs
	 * @return
	 */
	public int insertWholeSalesOrder(WaveOrderDO waveOrderDO, SalesOrderDO salesOrderDO, List<SalesOrderDetailDO> salesOrderDetailDOs);

	public int updateSalesOrder(SalesOrderDO salesOrderDO);

	/**
	 * 根据id查询销售订单
	 * 
	 * @param id
	 * @return
	 */
	public SalesOrderDO querySalesOrderById(Long id, Long warehouseId);

	/**
	 * 分页查询销售子订单详情
	 * 
	 * @param salesOrderDODetailQuery
	 * @return
	 */
	public PageResult<SalesOrderDetailDO> querySalesOrderDetailPage(SalesOrderDetailQuery salesOrderDODetailQuery);

	/**
	 * 插入销售子订单详情
	 * 
	 * @param salesOrderDetailDO
	 * @return
	 */
	public long insertSalesOrderDetail(SalesOrderDetailDO salesOrderDetailDO);

	/**
	 * 
	 * @param status
	 *            状态
	 * @param id
	 *            子订单id
	 * @param waveId
	 *            波次id
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public int updateStatusById(int status, long id, long waveId, long warehouseId);

	/**
	 * 根据外部销售单号，仓库id，仓库分表code查询子订单总数
	 * 
	 * @param waveId
	 * @param warehouseId
	 *            仓库id
	 * @return
	 */
	public int queryChildOrderQuanityByWaveId(Long waveId, long warehouseId);

	/**
	 * 根据外部销售单号，批次单号，货主id，仓库id，仓库分表code查询销售主订单
	 * 
	 * @param externalSalesNumber
	 * @param outBatchCode
	 * @param ownerId
	 * @param warehouseId
	 * @param warehouseCode
	 * @return
	 */
	public SalesOrderDO querySalesOrderByOutCode(String externalSalesNumber, Long outBatchCode, long ownerId, long warehouseId);

	/**
	 * 通过波次id 查询销售订单
	 * 
	 * @param waveId
	 *            波次id
	 * @param warehouseId
	 *            仓库id
	 * @param warehouseCode
	 *            分表code
	 * @return
	 */
	public List<SalesOrderDO> querySalesOrdersByWaveOrderId(Long waveId, Long warehouseId, Long warehouseCode);

	/**
	 * 通过波次id 查询销售单明细
	 * 
	 * @param status
	 *            状态
	 * @param salesOrdersId
	 *            销售单id 可为空，如果为空时，就不对波次id下的主订单进行过滤
	 * @param waveId
	 *            波次id
	 * @param warehouseCode
	 *            分表code
	 * @return
	 */
	public List<SalesOrderDetailDO> querySalesOrderDetailsByWaveOrderId(int status, Long salesOrdersId, Long waveId, Long warehouseCode);

	/**
	 * 通过外部子订单Id，波次Id,查询子订单详情对象
	 * 
	 * @param subOrderId
	 * @param waveId
	 * @param warehouseId
	 * @return
	 */
	public SalesOrderDetailDO queryDetailBySubOrderId(long subOrderId, long waveId, long warehouseId);

	/**
	 * 通过外来批次code查询销售定订单对象
	 * 
	 * @param outBatchCode
	 * @param warehouseId
	 * @return
	 */
	public SalesOrderDO querySalesOrderByOutBatchCode(Long outBatchCode, long warehouseId);

	/**
	 * 更改销售主订单，子订单的退款金额，更新失败回滚返回0，更新成功返回1，数据库异常抛异常。
	 * 
	 * @param salesOrderDO
	 * @param salesOrderDetailDO
	 * @return
	 */
	public int updateAllCompensationAmount(SalesOrderDO salesOrderDO, List<SalesOrderDetailDO> salesOrderDetailDOs);

	/**
	 * 将波次下所有子订单的主计价单位购买数量更新到主计价单位拣货数量，返回更新数量
	 * 
	 * @param waveId
	 *            波次Id
	 * @param warehouseId
	 *            仓库Id
	 * @return
	 */
	public int updateMainSortNumberByWaveId(long waveId, long warehouseId);
}
