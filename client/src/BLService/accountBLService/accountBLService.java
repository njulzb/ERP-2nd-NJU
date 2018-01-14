package BLService.accountBLService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.KeyForSearchAccount;
import vo.AccountVO;

public interface accountBLService {
	public AccountVO getAccount(String id) throws RemoteException ;//获取银行账户
	public ArrayList<AccountVO> searchAccount(KeyForSearchAccount key)throws RemoteException ;//根据搜索条件获取符合的银行账户列表
	public boolean editAccount(AccountVO topush)throws RemoteException ;//修改银行账户名称
	public boolean newAccount(AccountVO topush)throws RemoteException ;//新建一个银行账户
	public boolean deleteAccount(String id)throws RemoteException ;//删除一个银行账户
	
}
