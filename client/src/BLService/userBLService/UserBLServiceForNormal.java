package BLService.userBLService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import utility.RoleOfUser;
import vo.UserVO;
/**
 *
 * @author lzb
 *
 */
public interface UserBLServiceForNormal {

	/**
	 * 用户登陆验证，成功返回roleofuser ， 失败返回null
	 * @param id
	 * @param password
	 * @return
	 */

	public UserVO login(String id,String password) throws RemoteException;

	public ArrayList<UserVO> searchUserByRole(RoleOfUser role) throws RemoteException;




}
