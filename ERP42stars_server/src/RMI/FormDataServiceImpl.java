package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.KeyForSearchForm;
import po.formPO.FormPO;
import Data.receiptData.FormController;
import DataService.receiptDataService.FormDataService;


public class FormDataServiceImpl extends UnicastRemoteObject implements FormDataService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4029039744279087114L;
	private FormDataService formDataService;

	public FormDataServiceImpl() throws RemoteException {
		formDataService  = new FormController();
	}

	@Override
	public FormPO getForm(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return formDataService.getForm(id);
	}

	@Override
	public boolean newForm(FormPO toPush) throws RemoteException {
		// TODO 自动生成的方法存根
		return  formDataService.newForm(toPush);
	}

	@Override
	public boolean editForm(FormPO toPush) throws RemoteException {
		// TODO 自动生成的方法存根
		return  formDataService.editForm(toPush);
	}

	@Override
	public ArrayList<FormPO> searchForm(KeyForSearchForm toPush) throws RemoteException {
		// TODO 自动生成的方法存根
		return  formDataService.searchForm(toPush);
	}

	@Override
	public boolean deleteForm(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return  formDataService.deleteForm(id);
	}




	
	


}
