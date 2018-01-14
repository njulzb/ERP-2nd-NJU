package BL.customerBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import BLService.customerBLService.CustomerBLService;
import po.KeyForSearchCustomer;
import vo.CustomerVO;

public class CustomerController implements CustomerBLService, CustomerInfo {

	CustomerBL customerManager = null;

	/**
	 * constructor
	 */

	public CustomerController() {
		this.customerManager = new CustomerBL();

	}
//新增客户
	@Override
	public boolean addCustomer(CustomerVO customerVO) {

		Customer customer = new Customer(customerVO);
		//System.out.println(customerVO.getPhoneNumber());
		try {
			return this.customerManager.addCustomer(customer);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//获得指定id客户
	@Override
	public CustomerVO getCustomer(String id) {
		// TODO Auto-generated method stub
		try {
			return this.customerManager.getCustomer(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	//获得所有客户列表
	@Override
	public ArrayList<CustomerVO> getCustomerList() {
		// TODO Auto-generated method stub
		try {
				return this.customerManager.getCustomerList(new KeyForSearchCustomer());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	//获得key限定的客户列表
	@Override
	public ArrayList<CustomerVO> getCustomerList(KeyForSearchCustomer key) {
		// TODO Auto-generated method stub
		try {
			if (key==null)
				return this.customerManager.getCustomerList(new KeyForSearchCustomer());
			else
				return this.customerManager.getCustomerList(key);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	//更改客户
	@Override
	public boolean modifyCustomer(CustomerVO current) {
		// TODO Auto-generated method stub
		try {
			return this.customerManager.modifyCustomer(current);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//删除客户
	@Override
	public boolean deleteCustomer(CustomerVO current) {
		// TODO Auto-generated method stub

		try {
			return this.customerManager.deleteCustomer(current.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//修改应收
	@Override
	public boolean modifyReceiveAmount(String id, double receiveAmount) {
		// TODO Auto-generated method stub
		try {
			return this.customerManager.modifyReceiveAmount(id, receiveAmount);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//修改应付
	@Override
	public boolean modifyPayAmount(String id, double payAmount) {
		// TODO Auto-generated method stub
		try {
			return this.customerManager.modifyPayAmount(id, payAmount);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	//用id获得客户
	public Customer getCustomerByID(String id) {
		// TODO Auto-generated method stub
		try {
			return this.customerManager.getCustomerByID(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
