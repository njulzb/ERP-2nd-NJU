package Data.userData.mock;

import java.util.ArrayList;

import Data.userData.UserDataController;
import po.UserPO;
import utility.RoleOfUser;

public class MockUserDataController extends UserDataController{

	ArrayList<UserPO> userList = new ArrayList<UserPO>();
	
	
	public MockUserDataController() {
		userList.add(new UserPO("161250063","lzb","161250063",RoleOfUser.StoreManager));		
		userList.add(new UserPO("161250061","lyb","161250061",RoleOfUser.FinancialManager));
		userList.add(new UserPO("161250040","hqj","161250040",RoleOfUser.SaleManager));
		userList.add(new UserPO("161250088","mxf","161250088",RoleOfUser.GeneralManager));
	}
	
	
	@Override
	public UserPO login(String id, String password) {
		// TODO Auto-generated method stub
		for (int i=0;i<this.userList.size();i++) {
			UserPO curr = userList.get(i);
			if (curr.getID().equals(id) && curr.getPassword().equals(password)) {
				this.showList();
				return curr;
			}
		}
		
		return null;
	}

	@Override
	public boolean addUser(UserPO user)  {
		// TODO Auto-generated method stub
		userList.add(user);
		this.showList();
		return true;
	}

	@Override
	public boolean deleteUser(String id) {
		// TODO Auto-generated method stub
		for (int i=0;i<this.userList.size();i++) {
			if (userList.get(i).getID().equals(id)) {
				this.userList.remove(i);
				this.showList();
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean updateUser(UserPO newer) {
		for (int i=0;i<this.userList.size();i++) {
			UserPO curr = userList.get(i);
			if (curr.getID().equals(newer.getID())) {
				this.userList.remove(i);
				this.userList.add(i,newer);
				this.showList();
				return true;
			}
		}
		
		return false;
	}
	
	
	private void showList() {
		System.out.println("\n---------current list-----------");
		for (int i=0;i<this.userList.size();i++) {
			UserPO curr = this.userList.get(i);
			System.out.println(curr.getID()+" "+curr.getName()+" "+curr.getPassword()+" "+curr.getRole());
		}
		System.out.println("---------current list-----------\n");
	}

}
