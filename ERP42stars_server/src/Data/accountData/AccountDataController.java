package Data.accountData;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AccountPO;
import po.KeyForSearchAccount;
import DataService.accountDataService.AccountDataService;

public class AccountDataController implements AccountDataService{

	@Override
	public AccountPO getAccount(String id) {
		// TODO 自动生成的方法存根
		
		return AccountSqlHelper.get(id);
	}

	@Override
	public boolean addAccount(AccountPO in) {
		// TODO 自动生成的方法存根
		return AccountSqlHelper.insert(in);
	}
	
	@Override
	public boolean deleteAccount(String id) {
		// TODO 自动生成的方法存根
		return AccountSqlHelper.delete(id);
	}

	@Override
	public ArrayList<AccountPO> searchAccount(KeyForSearchAccount key) {
		// TODO 自动生成的方法存根
		return AccountSqlHelper.search(key);
	}
	
	public static void main(String args[]){
		AccountPO p =new AccountPO();
		p.setID("sdff-erwe-1123");
		p.setName("dd");
		p.setMoneyLeft(30.00);
		p.setPassword("123456");
		
		new AccountDataController().addAccount(p);
	}

	@Override
	public boolean editAccount(AccountPO in) throws RemoteException {
		// TODO 自动生成的方法存根
		return  AccountSqlHelper.update(in);
	}


}
