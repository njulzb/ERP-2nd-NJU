package Data.accountData;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;

import DataService.accountDataService.AccountDataService;
import po.AccountPO;
import po.KeyForSearchAccount;
public class accountDataStub implements AccountDataService {
	public AccountPO getAccount(int id){
		return new AccountPO();
	}
	public boolean addAccount(AccountPO in){
		return true;
	}
	public boolean deleteAccount(AccountPO in){
		return true;
	}
	@SuppressWarnings("unchecked")
	public ArrayList<AccountPO> searchAccount(String name,int lowMoney){
		return new ArrayList<AccountPO>();
		
	}
	@Override
	public boolean deleteAccount(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}
	@Override
	public boolean editAccount(AccountPO in) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}
	@Override
	public AccountPO getAccount(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ArrayList<AccountPO> searchAccount(KeyForSearchAccount key) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}
}
