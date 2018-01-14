package BLService.userBLService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import utility.RoleOfUser;
import vo.UserVO;

/**
 * 这是专门为管理员权限设计的接口
 * 为了符合isp ，接口隔离原则，避免出现权限混乱的问题。
 * @author lzb
 *
 */
public interface UserBLServiceForAdmin {


	/**
	 * 增加用户
	 */

	public boolean addUser(UserVO user)throws RemoteException;

	/**
	 * 删除用户，根据id
	 */
	public boolean deleteUser(String id)throws RemoteException;

	/**
	 * 修改用户权限
	 * @param id
	 * @param newRole
	 * @return
	 */
	public boolean updateUser(UserVO newer)throws RemoteException;

	
	/**
	 * 得到角色对应的用户列表
	 * @param role
	 * @return
	 * @throws RemoteException 
	 */
	public ArrayList<UserVO> searchUserByRole(RoleOfUser role) throws RemoteException;
	
	
	
}
