package BLService.customerBLService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import BLService.customerBLService.*;
import po.KeyForSearchCustomer;
import utility.LevelOfCustomer;
import utility.RoleOfUser;
import utility.TypeOfCustomer;
import vo.CustomerVO;
import vo.UserVO;

public class CustomerBLStub implements CustomerBLService{
	static CustomerBLStub stub=new CustomerBLStub();

	UserVO lzb = new UserVO("161250063","李泽斌","161250063",RoleOfUser.StoreManager);
	UserVO lyb = new UserVO("161250061","李一冰","161250061",RoleOfUser.FinancialManager);
	UserVO hqj = new UserVO("1","洪铨健","1",RoleOfUser.SaleManager);
	UserVO mxf = new UserVO("161250088","马小方","161250088",RoleOfUser.GeneralManager);

	CustomerVO hqj2 = new CustomerVO("111",TypeOfCustomer.exporter,LevelOfCustomer.level1,"hqj","0592-8585555","Xian Yue mental hospital",
			"361000","5438438@163.com",100,50,1000,"/temp/-265608525.png","111");
	CustomerVO hqj1 = new CustomerVO("111",TypeOfCustomer.exporter,LevelOfCustomer.level1,"hqj","0592-8585555","Xian Yue mental hospital",
			"361000","5438438@163.com",100,50,1000,"/temp/-265608525.png","111");
	CustomerVO lzb2 = new CustomerVO("11111",TypeOfCustomer.exporter,LevelOfCustomer.level2,"lzb","438438","250",
			"361000","5438438@163.com",100,50,1000,"/temp/-265608525.png","111");
	CustomerVO lzb1 = new CustomerVO("11111",TypeOfCustomer.exporter,LevelOfCustomer.level2,"lzb","438438","250",
			"361000","5438438@163.com",100,50,1000,"/temp/-265608525.png","111");

	ArrayList<CustomerVO> cus= new ArrayList<CustomerVO>();

	public CustomerBLStub getCustomerBLStub(){
		return stub;
	}

	public CustomerBLStub(){
		cus.add(lzb2);
		cus.add(hqj2);
		cus.add(hqj1);
		cus.add(lzb1);
		cus.add(lzb2);
	}

	@Override
	public boolean addCustomer(CustomerVO current) {
		// TODO 自动生成的方法存根
		cus.add(current);
		return true;
	}

	@Override
	public CustomerVO getCustomer(String id) {
		// TODO Auto-generated method stub
		for (int i=0;i<cus.size();i++){
			if (cus.get(i).getId().equals(id)){
				return cus.get(i);
			}
		}
		return null;
	}

	@Override
	public boolean modifyCustomer(CustomerVO current) {
		// TODO Auto-generated method stub
		for (int i=0;i<cus.size();i++){
			if (cus.get(i).getId().equals(current.getId())){
				cus.set(i, current);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteCustomer(CustomerVO current) {
		// TODO Auto-generated method stub
		for (int i=0;i<cus.size();i++){
			if (cus.get(i).getId().equals(current.getId())){
				cus.remove(i);
				return true;
			}
		}
		return false;
	}


	@Override
	public ArrayList<CustomerVO> getCustomerList(KeyForSearchCustomer key) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CustomerVO> getCustomerList() {
		// TODO Auto-generated method stub
		return null;
	}

}
