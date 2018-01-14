package DataService.userDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.UserPO;
import utility.RoleOfUser;

/**
 * 
 * @author MXF,LZB
 *
 */
public interface UserDataService  extends Remote{
	
	
	
	/**
	 * 用户登陆验证，成功返回roleofuser ， 失败返回null
	 * @param id
	 * @param password
	 * @return
	 */
	
	public UserPO login(String id,String password) throws RemoteException;

	
	/**
	 * 增加用户
	 */
	
	public boolean addUser(UserPO user)throws RemoteException;
	
	/**
	 * 删除用户
	 */
	public boolean deleteUser(String id)throws RemoteException;
	
	/**
	 * 修改用户权限
	 * @param id
	 * @param newRole
	 * @return
	 */
	public boolean updateUser(UserPO newer)throws RemoteException;
	
	
	/**
	 * 根据role搜索user
	 * @param role
	 * @return
	 */
	public ArrayList<UserPO> searchUserByRole(RoleOfUser role) throws RemoteException;
	
	
	/**
	 * 根据id搜索user
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public UserPO searchUserByID(String id) throws RemoteException;

	
}
