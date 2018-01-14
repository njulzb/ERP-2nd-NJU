package BL.accountBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import BLService.accountBLService.accountBLService;
import po.KeyForSearchAccount;
import vo.AccountVO;

public class AccountController implements AccountInfo ,accountBLService {
	private AccountManage manage=new AccountManage();

	@Override
	public AccountVO getAccount(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return manage.getAccount(id);
	}

	@Override
	public ArrayList<AccountVO> searchAccount(KeyForSearchAccount key)throws RemoteException {
		// TODO 自动生成的方法存根
		return manage.searchAccount(key);
	}

	@Override
	public boolean editAccount(AccountVO topush)throws RemoteException {
		// TODO 自动生成的方法存根
		return manage.editAccount(topush);
	}

	@Override
	public boolean newAccount(AccountVO topush)throws RemoteException {
		// TODO 自动生成的方法存根
		return manage.newAccount(topush);
	}

	@Override
	public boolean deleteAccount(String id)throws RemoteException {
		// TODO 自动生成的方法存根
		return manage.deleteAccount(id);
	}

	@Override
	public ArrayList<AccountVO> getAccountList() throws RemoteException{
	
			return manage.getAccountList();
	
	}

	@Override
	public boolean changeMoney(String id, double money) throws RemoteException {
		// TODO 自动生成的方法存根
		return manage.changeMoney(id, money);
	}
	
}
