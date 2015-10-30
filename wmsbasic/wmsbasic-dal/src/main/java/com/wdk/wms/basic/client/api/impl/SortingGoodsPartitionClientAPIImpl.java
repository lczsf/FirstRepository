package com.wdk.wms.basic.client.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.wdk.wms.basic.client.api.SortingGoodsPartitionClientAPI;
import com.wdk.wms.basic.dal.dao.CabinetDAO;
import com.wdk.wms.basic.dal.dao.SortingGoodsPartitionCabinetDAO;
import com.wdk.wms.basic.dal.dao.SortingGoodsPartitionDAO;
import com.wdk.wms.basic.dal.dao.SortingGoodsPartitionUserDAO;
import com.wdk.wms.basic.daoobject.BasicCabinetDO;
import com.wdk.wms.basic.daoobject.SortingGoodsPartitionCabinetDO;
import com.wdk.wms.basic.daoobject.SortingGoodsPartitionDO;
import com.wdk.wms.basic.daoobject.SortingGoodsPartitionUserDO;
import com.wdk.wms.basic.query.parameters.SortingGoodsPartitionCabinetQuery;
import com.wdk.wms.basic.query.parameters.SortingGoodsPartitionQuery;
import com.wdk.wms.basic.query.parameters.SortingGoodsPartitionUserQuery;
import com.wdk.wms.basic.result.PageResult;

public class SortingGoodsPartitionClientAPIImpl implements SortingGoodsPartitionClientAPI {

	@Autowired
	private SortingGoodsPartitionDAO sortingGoodsPartitionDAO;

	@Autowired
	private SortingGoodsPartitionCabinetDAO sortingGoodsPartitionCabinetDAO;

	@Autowired
	private SortingGoodsPartitionUserDAO sortingGoodsPartitionUserDAO;

	@Autowired
	private TransactionTemplate transactionTemplate;

	@Autowired
	private CabinetDAO cabinetDAO;

	@Override
	public PageResult<SortingGoodsPartitionDO> querySortingGoodsPartition(SortingGoodsPartitionQuery sortingGoodsPartitionQuery) {

		// 返回数据
		PageResult<SortingGoodsPartitionDO> response = new PageResult<SortingGoodsPartitionDO>();

		List<SortingGoodsPartitionDO> results;

		// 当前页数据
		results = sortingGoodsPartitionDAO.querySortingGoodsPartition(sortingGoodsPartitionQuery);
		// 总条数
		int count = sortingGoodsPartitionDAO.querySortingGoodsPartitionCount(sortingGoodsPartitionQuery);

		response.setNum(sortingGoodsPartitionQuery.getNum());
		response.setTotalNum(count);
		response.setList(results);
		response.setIndex(sortingGoodsPartitionQuery.getIndex());
		return response;
	}

	@Override
	public SortingGoodsPartitionDO querySortingGoodsPartitionById(long id) {
		SortingGoodsPartitionDO sortingGoodsPartitionDO = sortingGoodsPartitionDAO.querySortingGoodsPartitionById(id);
		if (sortingGoodsPartitionDO == null)
			return null;
		SortingGoodsPartitionCabinetQuery sortingGoodsPartitionCabinetQuery = new SortingGoodsPartitionCabinetQuery();
		sortingGoodsPartitionCabinetQuery.setSortingGoodsPartitionCode(sortingGoodsPartitionDO.getCode());
		sortingGoodsPartitionCabinetQuery.setWarehouseId(sortingGoodsPartitionDO.getWarehouseId());
		List<SortingGoodsPartitionCabinetDO> list = sortingGoodsPartitionCabinetDAO.querySortingGoodsPartitionCabinet(sortingGoodsPartitionCabinetQuery);
		List<BasicCabinetDO> catbinetList = new ArrayList<BasicCabinetDO>();
		for (SortingGoodsPartitionCabinetDO demo : list) {
			catbinetList.add(cabinetDAO.queryCabinetById(demo.getCabinetId()));
		}
		sortingGoodsPartitionDO.setCabinetList(catbinetList);
		return sortingGoodsPartitionDO;
	}


	@Override
	public long insertSortingGoodsPartition(final SortingGoodsPartitionDO sortingGoodsPartitionDO) {
		long id = (Long) transactionTemplate
.execute(new TransactionCallback<Object>() {
			@Override
			public Object doInTransaction(TransactionStatus status) {
				long id = 0;
			 try{
					id = sortingGoodsPartitionDAO.insertSortingGoodsPartition(sortingGoodsPartitionDO);// 插入拣货区信息
					List<BasicCabinetDO> cabinetList = sortingGoodsPartitionDO.getCabinetList(); // 获取库位list
					List<Long> lists = new ArrayList<Long>();
					for (BasicCabinetDO cabinetDO : cabinetList) {
						lists.add(cabinetDO.getId());
					}
					SortingGoodsPartitionCabinetDO sortiongGoodsPartitionCabinetDO = new SortingGoodsPartitionCabinetDO();// 新建关系插入对象
					sortiongGoodsPartitionCabinetDO.setSortingGoodsPartitionCode(sortingGoodsPartitionDO.getCode());// 设置分区code；
					sortiongGoodsPartitionCabinetDO.setWarehouseId(sortingGoodsPartitionDO.getWarehouseId());// 设置仓库id
					sortiongGoodsPartitionCabinetDO.setType(sortingGoodsPartitionDO.getType());// 设置类型
					for (Long cabinetId : lists) {
						sortiongGoodsPartitionCabinetDO.setCabinetId(cabinetId);// 给库位拣货区关联信息Do的库位id赋值
						sortingGoodsPartitionCabinetDAO.insertSortingGoodsPartitionCabinet(sortiongGoodsPartitionCabinetDO);// 插入库位拣货区关联信息
				}
			 }catch(Exception e){
				 status.setRollbackOnly();

					if (e instanceof UncategorizedSQLException
							&& ((UncategorizedSQLException) e)
							.getSQLException()
							.getMessage()
							.contains(
									"Duplicate entry '" + sortingGoodsPartitionDO.getWarehouseId() + "-" + sortingGoodsPartitionDO.getCode()
											+ "' for key 'codewarehouse'")) {
						throw new IllegalArgumentException("拣货分区编码已存在！请重新输入！");
					} else if (e instanceof UncategorizedSQLException
							&& ((UncategorizedSQLException) e)
							.getSQLException()
							.getMessage()
							.contains(
											"Duplicate entry '" + sortingGoodsPartitionDO.getWarehouseId() + "-" + sortingGoodsPartitionDO.getName()
											+ "' for key 'namewarehouse'")) {
						throw new IllegalArgumentException("拣货分区名称已存在！请重新输入！");

					}
			 }

				return id;
			}
		}
			);

		return id;
	}

	@Override
	public int deleteSortingGoodsPartitionById(long id) {
		SortingGoodsPartitionDO sortingGoodsPartitionDO = sortingGoodsPartitionDAO.querySortingGoodsPartitionById(id);
		sortingGoodsPartitionCabinetDAO.deleteByWarehouseIdAndPartitionCode(sortingGoodsPartitionDO.getWarehouseId(), sortingGoodsPartitionDO.getCode());// 删除库位拣货区关联信息

		return sortingGoodsPartitionDAO.deleteSortingGoodsPartitionById(id);// 删除拣货区信息
	}

	@Override
	public int updateSortingGoodsPartition(final SortingGoodsPartitionDO sortingGoodsPartitionDO) {
		int id = (Integer) transactionTemplate.execute(new TransactionCallback<Object>() {
			@Override
			public Object doInTransaction(TransactionStatus status) {
				int id = 0;
				try {
					List<BasicCabinetDO> cabinetList = sortingGoodsPartitionDO.getCabinetList();// 获取库位拣货区关联信息；
					List<Long> lists = new ArrayList<Long>();
					for (BasicCabinetDO cabinetDO : cabinetList) {
						lists.add(cabinetDO.getId());
					}
					sortingGoodsPartitionCabinetDAO.deleteByWarehouseIdAndPartitionCode(sortingGoodsPartitionDO.getWarehouseId(),
							sortingGoodsPartitionDO.getCode());// 删除此拣货区关联 的信息

					SortingGoodsPartitionCabinetDO sortiongGoodsPartitionCabinetDO = new SortingGoodsPartitionCabinetDO();// 新建关系插入对象
					sortiongGoodsPartitionCabinetDO.setSortingGoodsPartitionCode(sortingGoodsPartitionDO.getCode());// 设置分区code；
					sortiongGoodsPartitionCabinetDO.setWarehouseId(sortingGoodsPartitionDO.getWarehouseId());// 设置仓库id
					sortiongGoodsPartitionCabinetDO.setType(sortingGoodsPartitionDO.getType());// 设置类型

					for (Long cabinetId : lists) {
						sortiongGoodsPartitionCabinetDO.setCabinetId(cabinetId);// 给库位拣货区关联信息Do的库位id赋值
						sortingGoodsPartitionCabinetDAO.insertSortingGoodsPartitionCabinet(sortiongGoodsPartitionCabinetDO);// 插入库位拣货区关联信息
					}
					id = sortingGoodsPartitionDAO.updateSortingGoodsPartition(sortingGoodsPartitionDO);// 修改拣货区信息}
				} catch (Exception e) {
					status.setRollbackOnly();

					if (e instanceof UncategorizedSQLException
							&& ((UncategorizedSQLException) e)
							.getSQLException()
							.getMessage()
							.contains(
									"Duplicate entry '" + sortingGoodsPartitionDO.getWarehouseId() + "-" + sortingGoodsPartitionDO.getCode()
											+ "' for key 'codewarehouse'"))
 {
						throw new IllegalArgumentException("拣货分区编码已存在！请重新输入！");
					} else if (e instanceof UncategorizedSQLException
							&& ((UncategorizedSQLException) e)
							.getSQLException()
							.getMessage()
							.contains(
											"Duplicate entry '" + sortingGoodsPartitionDO.getWarehouseId() + "-" + sortingGoodsPartitionDO.getName()
											+ "' for key 'namewarehouse'")) {
						throw new IllegalArgumentException("拣货分区名称已存在！请重新输入！");

					}
				}

				return id;
			}
		});
		return id;
	}

	/**
	 * 库区拣货区
	 */
	@Override
	public List<SortingGoodsPartitionCabinetDO> queryBySortingGoodsPartitionId(long sortingGoodsPartitionId) {

		SortingGoodsPartitionDO sortingGoodsPartitionDO = sortingGoodsPartitionDAO.querySortingGoodsPartitionById(sortingGoodsPartitionId);
		return sortingGoodsPartitionCabinetDAO.queryByWarehouseIdAndPartitionCode(sortingGoodsPartitionDO.getWarehouseId(), sortingGoodsPartitionDO.getCode());

	}

	@Override
	public PageResult<SortingGoodsPartitionCabinetDO> querySortingGoodsPartitionCabinet(SortingGoodsPartitionCabinetQuery sortingGoodsPartitionCabinetQuery) {

		// 返回数据
		PageResult<SortingGoodsPartitionCabinetDO> response = new PageResult<SortingGoodsPartitionCabinetDO>();

		List<SortingGoodsPartitionCabinetDO> results;

		// 当前页数据
		results = sortingGoodsPartitionCabinetDAO.querySortingGoodsPartitionCabinet(sortingGoodsPartitionCabinetQuery);
		// 总条数
		int count = sortingGoodsPartitionCabinetDAO.querySortingGoodsPartitionCabinetCount(sortingGoodsPartitionCabinetQuery);

		response.setNum(sortingGoodsPartitionCabinetQuery.getNum());
		response.setTotalNum(count);
		response.setList(results);
		response.setIndex(sortingGoodsPartitionCabinetQuery.getIndex());
		return response;
	}

	/**
	 * 用户拣货区
	 */
	@Override
	public PageResult<SortingGoodsPartitionUserDO> querySortingGoodsPartitionUser(SortingGoodsPartitionUserQuery sortingGoodsPartitionUserQuery) {

		// 返回数据
		PageResult<SortingGoodsPartitionUserDO> response = new PageResult<SortingGoodsPartitionUserDO>();

		List<SortingGoodsPartitionUserDO> results;

		// 当前页数据
		results = sortingGoodsPartitionUserDAO.querySortingGoodsPartitionUser(sortingGoodsPartitionUserQuery);
		// 总条数
		int count = sortingGoodsPartitionUserDAO.querySortingGoodsPartitionUserCount(sortingGoodsPartitionUserQuery);

		response.setNum(sortingGoodsPartitionUserQuery.getNum());
				response.setTotalNum(count);
				response.setList(results);
		response.setIndex(sortingGoodsPartitionUserQuery.getIndex());

		return response;
	}

	@Override
	public long insertSortingGoodsPartitionUser(SortingGoodsPartitionUserDO sortingGoodsPartitionUserDO) {

		return sortingGoodsPartitionUserDAO.insertSortingGoodsPartitionUser(sortingGoodsPartitionUserDO);
	}

	@Override
	public int deleteSortingGoodsPartitionUserById(long sortingGoodsPartitionUserId) {

		return sortingGoodsPartitionUserDAO.deleteSortingGoodsPartitioUsernById(sortingGoodsPartitionUserId);
	}

	@Override
	public SortingGoodsPartitionUserDO querySortingGoodsPartitionUserDOById(long id) {

		return sortingGoodsPartitionUserDAO.querySortingGoodsPartitionUserById(id);
	}

	@Override
	public List<String> queryCodeByUserIdAndWarehouseId(long userId, long warehouseId) {
		List<SortingGoodsPartitionUserDO> list = sortingGoodsPartitionUserDAO.queryByUserIdAndWarehouseId(userId, warehouseId);// 查询拣货分区集合
		String code;
		List<String> codelist = new ArrayList<String>();
		for (SortingGoodsPartitionUserDO sgp : list) {
			SortingGoodsPartitionDO sdo = sortingGoodsPartitionDAO.querySortingGoodsPartitionById(sgp.getSortingGoodsPartitionId());
			if (sdo != null) {
				code = sdo.getCode();// 查询拣货分区code
				codelist.add(code);// 增加code
			}
		}
		return codelist;
	}

	@Override
	public List<SortingGoodsPartitionDO> queryByCodes(List<String> codes, long warehouseId) {

		return sortingGoodsPartitionDAO.queryByCodes(codes, warehouseId);
	}

	@Override
	public int updateSortingGoodsPartitionUser(SortingGoodsPartitionUserDO sortingGoodsPartitionUserDO) {

		return sortingGoodsPartitionUserDAO.updateSortingGoodsPartitionUser(sortingGoodsPartitionUserDO);

	}

	@Override
	public String queryByCabinetIdAndType(long cabinetId, int areaType, long warehouseId) {

		return sortingGoodsPartitionCabinetDAO.queryByCabinetIdAndType(cabinetId, areaType, warehouseId);

	}

}
