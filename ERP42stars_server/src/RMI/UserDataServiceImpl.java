package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Data.userData.UserDataController;
import DataService.userDataService.UserDataService;
import po.UserPO;
import utility.RoleOfUser;

public class UserDataServiceImpl extends UnicastRemoteObject implements UserDataService{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private  UserDataController userController = new UserDataController();
//	private UserDataController userController = new MockUserDataController();
	
	
	public UserDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public UserPO login(String id, String password) {
		// TODO Auto-generated method stub
		return this.userController.login(id, password);
	}

	@Override
	public boolean addUser(UserPO user) {
		// TODO Auto-generated method stub
		return this.userController.addUser(user);
	}

	@Override
	public boolean deleteUser(String id) {
		// TODO Auto-generated method stub
		return this.userController.deleteUser(id);
	}

	@Override
	public boolean updateUser(UserPO newer) {
		// TODO Auto-generated method stub
		return this.userController.updateUser(newer);
	}



	@Override
	public ArrayList<UserPO> searchUserByRole(RoleOfUser role) throws RemoteException {
		// TODO Auto-generated method stub
		return this.userController.searchUserByRole(role);
	}



	@Override
	public UserPO searchUserByID(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return this.userController.searchUserByID(id);
	}

}
