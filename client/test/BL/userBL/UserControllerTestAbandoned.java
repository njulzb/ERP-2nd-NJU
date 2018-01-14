package BL.userBL;

import java.rmi.RemoteException;

import org.junit.jupiter.api.Test;

import utility.RoleOfUser;
import vo.UserVO;

class UserControllerTestAbandoned {

	
	
	
	@Test
	void testAddUser() {
		System.out.println("\n--------------add a new user-------------");
		UserController controller = new UserController();
		UserVO vo = new UserVO("161250062","lyf","161250062",RoleOfUser.SaleManager);
		try {
			controller.addUser(vo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("internet wrong");
		}
		System.out.println("\n---------------end of add user---------");
		assert(true);
	}

	@Test
	void testDeleteUser() {
		System.out.println("\n---------------delete a user---------\n");
		UserController controller = new UserController();
		String id = "161250063";
		boolean flag = false;
		try {
			flag = controller.deleteUser(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("internet wrong.");
		}
	
		System.out.println("\n---------------end of delete user---------");
		assert(flag);
	}

//	@Test
//	void testUpdateRoleOfUser() {
//		System.out.println("\n---------------update--------------");
//		UserController controller = new UserController();
//		String id = "161250088";
//		boolean flag = false;
//		try {
//			flag =controller.updateRoleOfUser(id, RoleOfUser.FinancialManager);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("\n---------------update--------------");
//		assert(flag);
//	}

//	@Test
//	void testLogin() {
//		System.out.println("\n---------------login--------------");
//		UserController controller = new UserController();
//		String id = "161250061";
//		String password = id;
//		RoleOfUser flag = null;
//		try {
//			flag =  controller.login(id, password);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("\n---------------login--------------");
//		assert(flag==RoleOfUser.FinancialManager);
//	}

}
