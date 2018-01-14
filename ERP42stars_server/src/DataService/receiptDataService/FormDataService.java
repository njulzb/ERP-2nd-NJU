package DataService.receiptDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.KeyForSearchForm;
import po.formPO.FormPO;


public interface FormDataService extends Remote{
	public FormPO getForm(String id)throws RemoteException;
	public boolean deleteForm(String id)throws RemoteException;
	public boolean newForm(FormPO toPush)throws RemoteException;
	public boolean editForm(FormPO toPush)throws RemoteException;
	public ArrayList<FormPO> searchForm(KeyForSearchForm toPush)throws RemoteException;
}
