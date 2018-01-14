package BL.userBL;


import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import utility.RoleOfUser;
import vo.UserVO;

class UserControllerTest {

	UserController controller = new UserController();
	
	@Before
	void init() {
		this.controller = new UserController();
	}
	
	@Test
	void testImage() throws RemoteException {
		UserVO vo1 = new UserVO("test1","test1","test1",RoleOfUser.admin,"c:\\Users\\lzb\\Desktop\\a.png");
		boolean flag = this.controller.addUser(vo1);
		assert(flag);
		UserVO result = this.controller.login("test1", "test1");
		System.out.println(result.getImagePath());
		
	}
	
	
	@Test
	void testSearchUserByRole() throws RemoteException {
		UserVO result = this.controller.login("161250063", "161250063");
		
		ArrayList<UserVO> ansList = new ArrayList<UserVO>();
		ansList.add(result);
		
		ArrayList<UserVO> resultList = this.controller.searchUserByRole(RoleOfUser.StoreManager);
		
		assertEquals(ansList,resultList);
		
	}
	
	
	@Test
	void testLogin() throws RemoteException {
		UserVO result = this.controller.login("161250063", "161250063");
		UserVO ans = new UserVO("161250063","lzb", "161250063",RoleOfUser.StoreManager);
		
		assertEquals(ans,result);
		
		
		result = this.controller.login("161250040", "161250040");
		ans = new UserVO("161250040","hqj", "161250040",RoleOfUser.SaleManager);

		assertEquals(ans,result);
		
		
		result = this.controller.login("161250088", "161250088");
		ans = new UserVO("161250088","mxf", "161250088",RoleOfUser.GeneralManager);

		assertEquals(ans,result);
		
		
		
	}

	@Test
	void testAddUser() throws RemoteException {
		
		String str = "161250000";
		UserVO ans = new UserVO(str,"qinliu", str,RoleOfUser.admin);
		boolean flag = this.controller.addUser(ans);
		assert(flag);
		
		UserVO result = this.controller.login(str, str);
		assertEquals(ans,result);

		
		this.controller.deleteUser(str);
	}

	@Test
	void testDeleteUser() throws RemoteException {
		
		String str = "161250000";
		UserVO ans = new UserVO(str,"qinliu", str,RoleOfUser.admin);
		boolean flag = this.controller.addUser(ans);
		assert(flag);
		
		UserVO result = this.controller.login(str, str);
		assertEquals(ans,result);

		flag = this.controller.deleteUser(str);
		result = this.controller.login(str, str);
		assert(result==null);
		
	}

	@Test
	void testUpdateUser() throws RemoteException {
		
		UserVO result = this.controller.login("161250063", "161250063");
		UserVO ans = new UserVO("161250063","lzb", "161250063",RoleOfUser.StoreManager);
		
		assertEquals(ans,result);

		ans.setName("new name");
		boolean flag = this.controller.updateUser(ans);
		
		
		assert(flag);
		
		result = this.controller.login("161250063", "161250063");
		assertEquals(ans,result);
		
		ans.setName("lzb");
		this.controller.updateUser(ans);
		
		
		
	}

}
