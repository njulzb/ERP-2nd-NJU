package BL.userBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import BLService.userBLService.UserBLServiceForAdmin;
import BLService.userBLService.UserBLServiceForNormal;
import utility.RoleOfUser;
import vo.UserVO;

public class UserController implements UserBLServiceForNormal,UserBLServiceForAdmin, UserInfo{

	UserList userList = new UserList();

	@Override
	public UserVO login(String id, String password) throws RemoteException {
		// TODO Auto-generated method stub
		User result = this.userList.login(id, password);
		if (result==null) {
			return null;
		}
		UserVO vo = result.toVO();
		return vo;
	}

	@Override
	public boolean addUser(UserVO newer) throws RemoteException {
		// TODO Auto-generated method stub
		User domain = new User(newer);
		return this.userList.addUser(domain);
	}

	@Override
	public boolean deleteUser(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return this.userList.deleteUser(id);
	}

	@Override
	public boolean updateUser(UserVO newer) throws RemoteException {
		// TODO Auto-generated method stub
		User domain = new User(newer);
		return this.userList.updateUser(domain);
	}

	@Override
	public User getUserByID(String id) throws RemoteException {
		// TODO 自动生成的方法存根

		
		
		return this.userList.searchUserByID(id);

	}

	@Override
	public ArrayList<UserVO> searchUserByRole(RoleOfUser role) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<User> list = this.userList.searchUserByRole(role);
		ArrayList<UserVO> resultList = new ArrayList<UserVO>(list.size());
		for (User e : list) {
			resultList.add(e.toVO());
		}
		return resultList;
	}






}
