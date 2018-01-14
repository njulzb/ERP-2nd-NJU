package BLService.customerBLService;


import java.rmi.RemoteException;
import java.util.ArrayList;

import po.KeyForSearchCustomer;
import vo.CustomerVO;

public interface CustomerBLService {

	public boolean addCustomer(CustomerVO current) throws RemoteException ;

	public CustomerVO getCustomer(String id) throws RemoteException ;

	public ArrayList<CustomerVO> getCustomerList(KeyForSearchCustomer key) throws RemoteException ;

	public boolean modifyCustomer(CustomerVO current) throws RemoteException;

	boolean deleteCustomer(CustomerVO current) throws RemoteException;

	public ArrayList<CustomerVO> getCustomerList();

}
