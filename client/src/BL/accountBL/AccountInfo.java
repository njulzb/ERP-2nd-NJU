package BL.accountBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.AccountVO;

public interface AccountInfo {
	public	ArrayList<AccountVO> getAccountList()throws RemoteException;
	public	boolean changeMoney(String id ,double money)throws RemoteException;
}
