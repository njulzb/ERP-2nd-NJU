package BL.mainAccountBL;

import java.rmi.RemoteException;

import BLService.mainAccountBLService.MainAccountService;
import DataService.mainAccountDataService.MainAccountDataService;
import RMI.ClientRunner;
import utility.FileHelper;

public class MainAccountController implements MainAccountService {
	private MainAccountDataService rmi = ClientRunner.getInstance().getMainAccountDataService();

	@Override
	public void createNewAccount() throws RemoteException {
		rmi.createNew();

	}

	@Override
	public boolean getStartInfo(String Path) throws RemoteException {
		FileHelper.createFile(rmi.get().getData(), Path, "start_info");
		;
		return true;
	}

}
