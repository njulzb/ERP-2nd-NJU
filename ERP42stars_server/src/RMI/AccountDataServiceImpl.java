package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Data.accountData.AccountDataController;
import Data.receiptData.FormController;
import DataService.accountDataService.AccountDataService;
import DataService.receiptDataService.FormDataService;
import po.AccountPO;
import po.KeyForSearchAccount;
/**
 * 职责转包给controller，
 * @author lzb
 *
 */

public class AccountDataServiceImpl extends UnicastRemoteObject implements AccountDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AccountDataService accountDataService;
	public AccountDataServiceImpl() throws RemoteException {
		accountDataService  = new AccountDataController();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addAccount(AccountPO in) throws RemoteException {
		// TODO Auto-generated method stub
		return accountDataService.addAccount(in);
	}

	@Override
	public boolean deleteAccount(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return accountDataService.deleteAccount(id);
	}

	@Override
	public AccountPO getAccount(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return accountDataService.getAccount(id);
	}

	@Override
	public ArrayList<AccountPO> searchAccount(KeyForSearchAccount key) throws RemoteException {
		// TODO Auto-generated method stub
		return accountDataService.searchAccount(key);
	}

	@Override
	public boolean editAccount(AccountPO in) throws RemoteException {
		// TODO 自动生成的方法存根
		return accountDataService.editAccount(in);
	}
	
}
