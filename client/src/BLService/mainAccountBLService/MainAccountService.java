package BLService.mainAccountBLService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.KeyForSearchMessage;
import vo.MessageVO;
import vo.report.MainAccountVO;

public interface MainAccountService {
	public void createNewAccount() throws RemoteException ;
	public boolean getStartInfo(String Path) throws RemoteException ;
	
}
