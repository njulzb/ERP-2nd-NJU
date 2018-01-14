package BLService.logBLService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.KeyForSearchLog;
import vo.LogItemVO;

public interface LogService {
	public  ArrayList<LogItemVO> searchLog(KeyForSearchLog key) throws RemoteException ;
	public void addLog(LogItemVO c) throws RemoteException ;
}
