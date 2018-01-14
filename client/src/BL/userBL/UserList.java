package BL.userBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import DataService.userDataService.UserDataService;
import RMI.ClientRunner;
import po.UserPO;
import utility.RoleOfUser;

public class UserList {

	/**
	 * Dataservice 的代表
	 */
	UserDataService userDataManager = ClientRunner.getInstance().getUserDataService();
//	UserDataService userDataManager = new UserDataServiceStub();
	
	
	public boolean addUser(User user) throws RemoteException {
		// TODO Auto-generated method stub
		
		
		return this.userDataManager.addUser(user.toPO());
	}

	
	public boolean deleteUser(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return this.userDataManager.deleteUser(id);
	}

	
	public boolean updateUser(User newer) throws RemoteException {
		// TODO Auto-generated method stub
		return this.userDataManager.updateUser(newer.toPO());
	}

	
	public User login(String id, String password) throws RemoteException {
		// TODO Auto-generated method stub
		UserPO result = this.userDataManager.login(id, password);
		if (result==null){
			return null;
		}
		User domain = new User(result);
		return domain;
	}
	
	
	public ArrayList<User> searchUserByRole(RoleOfUser role) throws RemoteException{
		ArrayList<UserPO> list = this.userDataManager.searchUserByRole(role);
		ArrayList<User> resultList = new ArrayList<User>(list.size());
		for (UserPO e : list) {
			resultList.add(new User(e));
		}
		return resultList;
	}
	
	public User searchUserByID(String id) throws RemoteException{
		UserPO po = this.userDataManager.searchUserByID(id);
		User result = new User(po);
		return result;
	}
	
	
}
