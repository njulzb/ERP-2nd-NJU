package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Data.logData.LogController;
import DataService.logDataService.LogDataService;
import po.KeyForSearchLog;
import po.LogItemPO;
import po.UserPO;

public class LogDataServiceImpl extends UnicastRemoteObject implements LogDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	LogController LogDataController = new LogController();
	
	

	public LogDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addLog(LogItemPO po) throws RemoteException {
		// TODO Auto-generated method stub
		this.LogDataController.addLog( po);
	}

	@Override
	public ArrayList<LogItemPO> searchLog(KeyForSearchLog key) throws RemoteException {
		// TODO Auto-generated method stub
		return this.LogDataController.searchLog(key);
	}

}
