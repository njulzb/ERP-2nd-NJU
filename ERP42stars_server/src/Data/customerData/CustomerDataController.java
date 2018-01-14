package Data.customerData;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CustomerPO;
import po.KeyForSearchCustomer;
import DataService.customerDataService.CustomerDataService;

public class CustomerDataController  implements CustomerDataService{

	

	@Override
	public boolean addCustomer(CustomerPO current) {
		// TODO 自动生成的方法存根
		
		return CustomerSqlHelper.insert(current);
	}

	@Override
	public CustomerPO getCustomer(String id) {
		// TODO 自动生成的方法存根
		return CustomerSqlHelper.get(id);
	}

	@Override
	public boolean modifyCustomer(CustomerPO current) {
		// TODO 自动生成的方法存根
		return CustomerSqlHelper.update(current);
	}

	@Override
	public ArrayList<CustomerPO> searchCustomer(KeyForSearchCustomer key) {
		// TODO 自动生成的方法存根
		return  CustomerSqlHelper.search(key);
	}

	@Override
	public boolean deleteCustomer(String id) throws RemoteException {
	
		return  CustomerSqlHelper.delete(id);
	}




}
