package DataService.mainAccountDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.KeyForSearchLog;
import po.LogItemPO;
import po.MainAccountPO;

public interface MainAccountDataService extends Remote{
	public void createNew () throws RemoteException;
	public MainAccountPO get () throws RemoteException;
}
