package Data.logData;

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
public class LogDataStub {

	ArrayList<String> List = new ArrayList<String>();

	public boolean addLog(String in) {
		List.add(in);
		return true;
	}

	
	public ArrayList<String> searchLog(String key) {

		 ArrayList<String> out = new  ArrayList<String>();
		for (String p : List) {
			if (p.indexOf(key)!= -1) {
				out.add(p);

			}

		}
		return out;
	}



}
