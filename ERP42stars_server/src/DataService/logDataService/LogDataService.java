package DataService.logDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.KeyForSearchLog;
import po.LogItemPO;
import po.UserPO;

public interface LogDataService extends Remote {
	public void addLog (LogItemPO po) throws RemoteException;
	public ArrayList<LogItemPO> searchLog (KeyForSearchLog key) throws RemoteException;
}
