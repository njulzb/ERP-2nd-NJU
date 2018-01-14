package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Data.mainAccountData.MainAccountData;
import DataService.logDataService.LogDataService;
import DataService.mainAccountDataService.MainAccountDataService;
import po.MainAccountPO;

public class MainAccountDataServiceImpl extends UnicastRemoteObject implements MainAccountDataService{

	public MainAccountDataServiceImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	MainAccountData cont=new MainAccountData();

	@Override
	public void createNew() throws RemoteException {
		// TODO 自动生成的方法存根
		cont.createNew();
	}

	@Override
	public MainAccountPO get() throws RemoteException {
		// TODO 自动生成的方法存根
		return cont.getNow();
	}

}
