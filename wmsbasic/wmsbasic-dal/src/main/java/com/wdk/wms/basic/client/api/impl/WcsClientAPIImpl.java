package com.wdk.wms.basic.client.api.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.CollectionUtils;

import com.wdk.wms.basic.client.api.WcsClientAPI;
import com.wdk.wms.basic.common.Constants;
import com.wdk.wms.basic.dal.dao.WarehouseDAO;
import com.wdk.wms.basic.dal.dao.WcsPickingCompleteDAO;
import com.wdk.wms.basic.dal.dao.WcsWaveCompleteDAO;
import com.wdk.wms.basic.daoobject.BasicWarehouseDO;
import com.wdk.wms.basic.daoobject.WcsPickingCompleteDO;
import com.wdk.wms.basic.daoobject.WcsWaveCompleteDO;
import com.wdk.wms.basic.enums.WcsMsgStatusEnum;

public class WcsClientAPIImpl implements WcsClientAPI {

	@Autowired
	private WcsWaveCompleteDAO wcsWaveCompleteDAO;
	@Autowired
	private WcsPickingCompleteDAO wcsPickingCompleteDAO;
	@Autowired
	private TransactionTemplate transactionTemplate;
	@Autowired
	private WarehouseDAO warehouseDAO;

	private static final Logger log = LoggerFactory.getLogger(WcsClientAPIImpl.class);

	@Override
	public List<WcsWaveCompleteDO> queryUnsentWaveCompleteRecord() {

		return wcsWaveCompleteDAO.queryUnsentRecord();
	}

	@Override
	public List<WcsPickingCompleteDO> queryUnsentPickingCompleteRecord() {

		return wcsPickingCompleteDAO.queryUnsentRecord();
	}

	public void doSendPickingCompleteCommand() {

		List<WcsPickingCompleteDO> list = wcsPickingCompleteDAO.queryUnsentRecord();

		if (CollectionUtils.isEmpty(list)) {
			return;
		}

		for (WcsPickingCompleteDO obj : list) {

			BasicWarehouseDO warehouse = warehouseDAO.queryWarehouseById(obj.getWarehouseId());
			obj.setWcsIp(warehouse.getWcsIp());
			obj.setWcsPort(warehouse.getWcsPort());
		}

		for (final WcsPickingCompleteDO obj : list) {

			Integer result = (Integer) transactionTemplate.execute(new TransactionCallback<Object>() {
				@Override
				public Object doInTransaction(TransactionStatus transactionStatus) {
					try {

						wcsPickingCompleteDAO.updateStatus(obj.getId(), WcsMsgStatusEnum.SUCCESS.getIndex());
						boolean flag = false;

						for (int i = 0; i < 3; i++) {
							if (doSend(getPickingCompleteCommand(obj), obj.getSeqNum(), obj.getWcsIp(), obj.getWcsPort())) {
								flag = true;
								break;
							}
							log.error("reSend----------------" + obj.getId());
						}

						if (!flag) {
							throw new RuntimeException();
						}

						return Constants.TRANSACTION_SUCC;
					} catch (Exception e) {
						transactionStatus.setRollbackOnly();
						log.error("fail to send msg " + getPickingCompleteCommand(obj));
						return Constants.TRANSACTION_FAIL;
					}
				}
			});

			if (result == Constants.TRANSACTION_FAIL) {
				wcsPickingCompleteDAO.updateFailureTimes(obj.getId());
			}
		}
	}

	public void doSendWaveCompleteCommand() {

		List<WcsWaveCompleteDO> list = wcsWaveCompleteDAO.queryUnsentRecord();

		if (CollectionUtils.isEmpty(list)) {
			return;
		}

		for (WcsWaveCompleteDO obj : list) {

			BasicWarehouseDO warehouse = warehouseDAO.queryWarehouseById(obj.getWarehouseId());
			obj.setWcsIp(warehouse.getWcsIp());
			obj.setWcsPort(warehouse.getWcsPort());
		}

		for (final WcsWaveCompleteDO obj : list) {

			Integer result = (Integer) transactionTemplate.execute(new TransactionCallback<Object>() {
				@Override
				public Object doInTransaction(TransactionStatus transactionStatus) {
					try {

						wcsWaveCompleteDAO.updateStatus(obj.getId(), WcsMsgStatusEnum.SUCCESS.getIndex());
						boolean flag = false;

						for (int i = 0; i < 3; i++) {
							if (doSend(getWaveCompleteCommand(obj), obj.getSeqNum(), obj.getWcsIp(), obj.getWcsPort())) {
								flag = true;
								break;
							}
							log.error("reSend----------------" + obj.getId());
						}

						if (!flag) {
							log.error("fail to send----------------" + obj.getId());
							throw new RuntimeException();
						}

						return Constants.TRANSACTION_SUCC;
					} catch (Exception e) {
						transactionStatus.setRollbackOnly();
						log.error(e.getMessage());
						log.error("fail to send msg " + getWaveCompleteCommand(obj));
						return Constants.TRANSACTION_FAIL;
					}
				}
			});

			if (result == Constants.TRANSACTION_FAIL) {
				wcsWaveCompleteDAO.updateFailureTimes(obj.getId());
			}
		}
	}

	private boolean doSend(String msg, Long seqNum, String ip, int port) throws RuntimeException {

		try {
			Socket socket = new Socket(ip, port);
			socket.setSoTimeout(1000);
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			log.error("-------send msg : " + msg);
			os.println(msg);
			os.flush();

			int i = 0;
			String res = "";

			while ((i = is.read()) != -1) {
				res += (char) i;
				if (i == 3) {
					log.error(res);
					break;
				}
			}

			os.close();
			is.close();
			socket.close();
			return (fillupMsg("ACK" + seqNum).equals(res));
		} catch (Exception e) {
			log.error("doSend----------------" + e.getMessage());
			return false;
		}

	}

	private String getPickingCompleteCommand(WcsPickingCompleteDO obj) {

		return fillupMsg(obj.getSeqNum() + "|PICKING|" + obj.getWaveCode() + "|" + obj.getContainerCode() + "|" + obj.getAttribute());
	}

	private String getWaveCompleteCommand(WcsWaveCompleteDO obj) {

		return fillupMsg(obj.getSeqNum() + "|WAVE|" + obj.getWaveCode() + "|" + obj.getContainerNum());
	}

	private String fillupMsg(String msg) {

		return (char) (02) + msg + (char) (03);
	}
}
