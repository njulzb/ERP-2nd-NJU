package DataService.accountDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AccountPO;
import po.KeyForSearchAccount;

public interface AccountDataService extends Remote {
	
	public boolean addAccount(AccountPO in) throws RemoteException;
	public boolean deleteAccount(String id) throws RemoteException;
	public boolean editAccount(AccountPO in) throws RemoteException;
	public AccountPO getAccount(String id) throws RemoteException;
	public ArrayList<AccountPO> searchAccount(KeyForSearchAccount key) throws RemoteException;
}
                                                                                                                   