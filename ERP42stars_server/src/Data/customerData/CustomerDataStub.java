package Data.customerData;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CustomerPO;
import po.KeyForSearchCustomer;

/**
 * 客户数据层的桩 用一个list模拟数据库，可以假装实现了对客户的增删改查功能
 * 
 * @author Eli
 *
 */
public class CustomerDataStub {

	ArrayList<CustomerPO> List = new ArrayList<CustomerPO>();

	public boolean addCustomer(CustomerPO current) {
		List.add(current);
		return true;
	}

	public CustomerPO getCustomer(String id) {

		for (CustomerPO p : List) {
			if (p.getID() == id) {
				return p;
			}

		}
		return null;

	}

	public boolean modifyCustomer(CustomerPO current) {
		for (CustomerPO p : List) {
			if (p.getID() == current.getID()) {
				List.remove(p);
				List.add(current);
				return true;
			}

		}
		return false;

	}

	/**
	 * 过于复杂，只是简单实现了根据姓名关键字进行搜索，用于测试
	 * 
	 * @param key
	 * @return
	 */
	public ArrayList<CustomerPO> searchCustomer(KeyForSearchCustomer key) {

		ArrayList<CustomerPO> out = new ArrayList<CustomerPO>();
		for (CustomerPO p : List) {
			if (p.getName().indexOf(key.getName()) != -1) {
				out.add(p);

			}

		}
		return out;
	}

	public boolean deleteCustomer(String id) throws RemoteException {
		for (CustomerPO p : List) {
			if (p.getID() == id) {
				List.remove(p);
				return true;
			}

		}
		return false;
	}

}
