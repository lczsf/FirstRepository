package com.wdk.wms.basic.client.api.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.google.common.collect.Lists;
import com.wdk.wms.basic.client.api.ParceTransactionClientAPI;
import com.wdk.wms.basic.dal.dao.ContainerDAO;
import com.wdk.wms.basic.dal.dao.ParceDAO;
import com.wdk.wms.basic.dal.dao.PickingContainerDAO;
import com.wdk.wms.basic.dal.dao.WarehouseDAO;
import com.wdk.wms.basic.dal.dao.WaveOrderDAO;
import com.wdk.wms.basic.daoobject.ParcelDO;
import com.wdk.wms.basic.daoobject.PickingContainerDO;
import com.wdk.wms.basic.daoobject.WaveOrderDO;
import com.wdk.wms.basic.enums.ContainerStatusEnum;
import com.wdk.wms.basic.enums.PickingContainerStatusEnum;
import com.wdk.wms.basic.enums.WaveOrderStatusEnum;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath*:spring-burton.xml" })
public class ParceTransactionClientAPIImplTests {

	@Autowired
	private ContainerDAO containerDAO;
	@Autowired
	private ParceTransactionClientAPI parceTransactionClientAPI;
	@Autowired
	private ParceDAO basicParceDAO;
	@Autowired
	private WarehouseDAO warehouseDAO;
	@Autowired
	private WaveOrderDAO waveOrderDAO;
	
	@Autowired
	private PickingContainerDAO pickingContainerDAO;

	@Test
	public void testAfterParcelUpdate() {

		// parceTransactionClientAPI.afterParcelUpdate(56L, "1100", 47L);
		long warehouseId = 200L;
		long waveId = 200l;
		String parcelNumber = "1123123";
		boolean result = parceTransactionClientAPI.afterParcelUpdate(200l, "1123123", 200l);
		Long warehouseSplitCode = warehouseDAO.queryWarehouseCodeById(warehouseId);
		ParcelDO parcelDO = basicParceDAO.queryByWaveId(waveId, warehouseSplitCode);
		WaveOrderDO waveOrderDO = waveOrderDAO.queryWaveOrderById(waveId, warehouseId, warehouseSplitCode);

		System.out.println(waveOrderDO.getWaveStatus());
		System.out.println(parcelDO.getParcelNumber());
		Assert.assertEquals(WaveOrderStatusEnum.FINISH.getIndex(), (int) waveOrderDO.getWaveStatus());
		Assert.assertEquals(parcelNumber, parcelDO.getParcelNumber());
		Assert.assertEquals(true, result);

	}
	
    @Test
    public void testAfterScanContainerUpdate(){
    	long warehouseId = 47L;
    	long waveId = 1L;
    	List<String> containerCodes = Lists.newArrayList();
    	containerCodes.add("R000000");
    	containerCodes.add("R000001");
    	containerCodes.add("R000002");
    	boolean isUpdateWave = false; 
		long operatorId = 1L;
		boolean result = parceTransactionClientAPI.afterScanContainerUpdate(warehouseId, waveId, containerCodes, operatorId, isUpdateWave);
		int [] actualsContainerstatus = new int[10];
	    int [] expectedContainerstatus = 	new int[10];
	    int [] actualsPickingContainerstatus = new int[10];
	    int [] expectedPickingContainerstatus = 	new int[10];
		for(int i=0; i<containerCodes.size();i++){
			actualsContainerstatus[i] = containerDAO.queryContainerByCode(warehouseId, containerCodes.get(i)).getStatus();
		    List<PickingContainerDO> pickingContainerList =pickingContainerDAO.queryByWaveIdAndContainerCode(waveId, containerCodes.get(i), warehouseId, warehouseDAO.queryWarehouseCodeById(warehouseId), PickingContainerStatusEnum.FINISHED.getIndex());
		    actualsPickingContainerstatus[i] = pickingContainerList.get(0).getStatus();
		}
		for(int k=0;k<containerCodes.size();k++){
			expectedContainerstatus[k] = ContainerStatusEnum.Free.getIndex();
			expectedPickingContainerstatus[k] = PickingContainerStatusEnum.FINISHED.getIndex();
		}
		WaveOrderDO waveOrderDO = waveOrderDAO.queryWaveOrderById(waveId, warehouseId, warehouseDAO.queryWarehouseCodeById(warehouseId));
	    //判断执行结果
		Assert.assertEquals(true, result);
		//判断容器状态是否更新
		Assert.assertArrayEquals(expectedContainerstatus, actualsContainerstatus);
		//判断拣货装箱单状态是否更新
		Assert.assertArrayEquals(expectedPickingContainerstatus, actualsPickingContainerstatus);
		//判断波次单状态是否更新
		Assert.assertEquals(WaveOrderStatusEnum.FINISH.getIndex(), (int)waveOrderDO.getWaveStatus());
    }
}
