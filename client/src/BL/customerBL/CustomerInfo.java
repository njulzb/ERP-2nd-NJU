package BL.customerBL;

import java.rmi.RemoteException;

public interface CustomerInfo {

	public boolean modifyReceiveAmount(String id, double receiveAmount) throws RemoteException;

	public boolean modifyPayAmount(String id, double payAmount) throws RemoteException;

	public Customer getCustomerByID(String id) throws RemoteException;
}
