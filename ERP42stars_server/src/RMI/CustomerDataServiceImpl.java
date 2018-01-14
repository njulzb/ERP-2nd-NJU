package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Data.customerData.CustomerDataController;
import DataService.customerDataService.CustomerDataService;
import po.CustomerPO;
import po.KeyForSearchCustomer;
/**
 * 职责转包给controller，
 * @author lzb
 *
 */

public class CustomerDataServiceImpl extends UnicastRemoteObject implements CustomerDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private	CustomerDataService conttroller =new 	CustomerDataController ();
	public CustomerDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addCustomer(CustomerPO current) throws RemoteException {
		// TODO Auto-generated method stub
		return conttroller.addCustomer(current);
	}

	@Override
	public CustomerPO getCustomer(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return conttroller.getCustomer(id);
	}

	@Override
	public boolean modifyCustomer(CustomerPO current) throws RemoteException {
		// TODO Auto-generated method stub
		return conttroller.modifyCustomer(current);
	}

	@Override
	public ArrayList<CustomerPO> searchCustomer(KeyForSearchCustomer key) throws RemoteException {
		// TODO Auto-generated method stub
		return conttroller.searchCustomer(key);
	}

	@Override
	public boolean deleteCustomer(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return conttroller.deleteCustomer(id);
	}

}
