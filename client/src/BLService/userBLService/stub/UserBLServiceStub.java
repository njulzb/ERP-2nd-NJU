package BLService.userBLService.stub;

import java.util.ArrayList;

import BLService.userBLService.UserBLServiceForAdmin;
import BLService.userBLService.UserBLServiceForNormal;
import utility.RoleOfUser;
import vo.UserVO;

public class UserBLServiceStub implements UserBLServiceForNormal , UserBLServiceForAdmin{

	UserVO lzb = new UserVO("4","李泽斌","4",RoleOfUser.StoreManager);
	UserVO lyb = new UserVO("2","李一冰","2",RoleOfUser.FinancialManager);
	UserVO hqj = new UserVO("1","洪铨健","1",RoleOfUser.SaleManager);
	UserVO mxf = new UserVO("3","马小方","3",RoleOfUser.GeneralManager);

	ArrayList<UserVO> userlist = new ArrayList<UserVO>();

	public UserBLServiceStub() {

		userlist.add(lzb);
		userlist.add(lyb);
		userlist.add(hqj);
		userlist.add(mxf);

	}


	@Override
	public UserVO login(String id, String password) {
		// TODO Auto-generated method stub

		for (int i=0;i<userlist.size();i++) {
			UserVO  curr = userlist.get(i);
			if (curr.getID().equals(id) && curr.getPassword().equals(password)) {
				return curr;
			}
		}

		return null;
	}

	/**
	 * 增加user，成功返回true
	 */
	@Override
	public boolean addUser(UserVO user) {
		// TODO Auto-generated method stub
		userlist.add(user);
		return true;
	}

	/**
	 * 删除user ，失败则返回false
	 */
	@Override
	public boolean deleteUser(String id) {
		// TODO Auto-generated method stub
		for (int i=0;i<userlist.size();i++) {
			UserVO curr = userlist.get(i);
			if (curr.getID().equals(id) ) {
				userlist.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * 更新用户角色，失败返回false
	 */
	@Override
	public boolean updateUser(UserVO newer) {
		// TODO Auto-generated method stub
		for (int i=0;i<userlist.size();i++) {
			UserVO curr = userlist.get(i);
			if (curr.getID().equals(newer.getID())) {
				this.userlist.remove(i);
				this.userlist.add(i,newer);
				return true;
			}
		}
		return false;
	}


	@Override
	public ArrayList<UserVO> searchUserByRole(RoleOfUser role) {
		// TODO Auto-generated method stub
		ArrayList<UserVO> newUserList = new ArrayList<UserVO>();
		if (role!=null){
			if (role.equals(RoleOfUser.saler) || role.equals(RoleOfUser.SaleManager)){
				for (int i=0;i<userlist.size();i++){
					if (userlist.get(i).getRole().equals(RoleOfUser.saler) || userlist.get(i).getRole().equals(RoleOfUser.SaleManager)){
						newUserList.add(userlist.get(i));
					}
				}
			}else{
				for (int i=0;i<userlist.size();i++){
					if (userlist.get(i).getRole().equals(role)){
						newUserList.add(userlist.get(i));
					}
				}
			}

		}else{
			for (int i=0;i<userlist.size();i++){
				newUserList.add(userlist.get(i));
			}
		}

		return newUserList;
	}

}
