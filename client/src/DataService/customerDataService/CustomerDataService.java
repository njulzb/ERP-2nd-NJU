package DataService.customerDataService;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CustomerPO;
import po.KeyForSearchCustomer;

public interface CustomerDataService  extends Remote{
	
	public boolean addCustomer(CustomerPO current) throws RemoteException ;
	
	public CustomerPO getCustomer(String id) throws RemoteException ;
	
	public boolean modifyCustomer(CustomerPO current) throws RemoteException;
	public boolean deleteCustomer(String id) throws RemoteException;
	public ArrayList<CustomerPO> searchCustomer(KeyForSearchCustomer key) throws RemoteException;
	
}
