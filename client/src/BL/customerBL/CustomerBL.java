package BL.customerBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

//import Data.customerData.KeyForSearchCustomer;
import DataService.customerDataService.CustomerDataService;
import RMI.ClientRunner;
import po.CustomerPO;
import po.KeyForSearchCustomer;
import vo.CustomerVO;

public class CustomerBL {
	CustomerDataService customerList = ClientRunner.getInstance().getCustomerDataService();

	public boolean addCustomer(Customer customer) throws RemoteException {
		// TODO Auto-generated method stub
		//System.out.println(customer.getPhoneNumber());
		return customerList.addCustomer(customer.toCsutomerPO());
	}

	public ArrayList<CustomerVO> getCustomerList(KeyForSearchCustomer key) throws RemoteException {//获得key限定的客户列表
		// TODO Auto-generated method stub
		ArrayList<CustomerPO> customerPOList = customerList.searchCustomer(key);
		ArrayList<Customer> customerlist = new ArrayList<Customer>();
		for (int i=0;i<customerPOList.size();i++){
			customerlist.add(new Customer(customerPOList.get(i)));
		}
		ArrayList<CustomerVO> customerVOList = new ArrayList<CustomerVO>();
		for (int i=0;i<customerPOList.size();i++){
			customerVOList.add(customerlist.get(i).toCsutomerVO());
		}
		return customerVOList;
	}

	public CustomerVO getCustomer(String id) throws RemoteException {//用id获得客户
		// TODO Auto-generated method stub
		Customer customer = new Customer(customerList.getCustomer(id));
		return customer.toCsutomerVO();
	}

	public Boolean deleteCustomer(String id) throws RemoteException {//删除客户
		// TODO Auto-generated method stub

		return customerList.deleteCustomer(id);
	}

	public boolean modifyCustomer(CustomerVO customerVO) throws RemoteException {//更改客户
		Customer customer = new Customer(customerVO);
		customerList.modifyCustomer(customer.toCsutomerPO());
		return true;
	}

	public boolean modifyReceiveAmount(String id, double receiveAmount) throws RemoteException {//修改应收
		CustomerVO customerVO = this.getCustomer(id);
		customerVO.setReceiveAmount(receiveAmount);
		return this.modifyCustomer(customerVO);

	}

	public boolean modifyPayAmount(String id, double payAmount) throws RemoteException {//修改应付
		CustomerVO customerVO = this.getCustomer(id);
		customerVO.setPayAmount(payAmount);
		return this.modifyCustomer(customerVO);
	}

	public Customer getCustomerByID(String id) throws RemoteException {//用id获得客户
		// TODO Auto-generated method stub
		return new Customer(this.getCustomer(id));
	}

}
