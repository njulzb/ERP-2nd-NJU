package Data.logData;

import java.rmi.RemoteException;
import java.util.ArrayList;

import DataService.logDataService.LogDataService;
import po.KeyForSearchLog;
import po.LogItemPO;
import po.UserPO;

public class LogController implements LogDataService{


	@Override
	public void addLog(LogItemPO po) throws RemoteException {
		LogSqlHelper.insert(po);
	}

	@Override
	public ArrayList<LogItemPO> searchLog(KeyForSearchLog key) throws RemoteException {
		// TODO 自动生成的方法存根
		return 	LogSqlHelper.search(key);
	}
	
}
