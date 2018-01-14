package Data.userData;

import java.rmi.RemoteException;
import java.util.ArrayList;

import DataService.userDataService.UserDataService;
import po.UserPO;
import utility.RoleOfUser;

public class UserDataController  implements UserDataService{

	UserSqlHelper userManager = new UserSqlHelper();

	public UserDataController() {
		this.userManager = new UserSqlHelper();
	}

	

	@Override
	public UserPO login(String id, String password) {
		// TODO Auto-generated method stub
		System.out.println("有人在尝试登录，"+id+" - "+password);
		
		UserPO user = this.userManager.searchByID(id);
		if (user == null) {
			return null;
		}
		String currpass = user.getPassword();
		if (password.equals(currpass)) {
			System.out.println("登陆验证通过");
			return user;
		}
		
		return null;
	}

	@Override
	public boolean addUser(UserPO user) {
		// TODO Auto-generated method stub
		return this.userManager.addUser(user);
	}

	@Override
	public boolean deleteUser(String id) {
		// TODO Auto-generated method stub
		return this.userManager.deleteUser(id);
	}

	@Override
	public boolean updateUser(UserPO newer) {
		// TODO Auto-generated method stub
		return this.userManager.updateUser(newer);
	}



	@Override
	public ArrayList<UserPO> searchUserByRole(RoleOfUser role) {
		// TODO Auto-generated method stub
		return this.userManager.searchUserByRole(role);
	}



	@Override
	public UserPO searchUserByID(String id) throws RemoteException {
		// TODO Auto-generated method stub
		
		return this.userManager.searchByID(id);
	}
	
	

}
