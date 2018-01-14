package Data.userData;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import po.UserPO;
import utility.RoleOfUser;

class UserDataControllerTest {

	UserDataController controller = new UserDataController();
	
	
	@BeforeEach
	void init() {
		UserInitHelper.init();
		this.controller = new UserDataController();
	}
	
	
	@Test
	void testLogin() {
		UserPO lzb = new UserPO("161250063","lzb","161250063",RoleOfUser.StoreManager);
		UserPO lyb = new UserPO("161250061","lyb","161250061",RoleOfUser.FinancialManager);
		UserPO hqj = new UserPO("161250040","hqj","161250040",RoleOfUser.SaleManager);
		UserPO mxf = new UserPO("161250088","mxf","161250088",RoleOfUser.GeneralManager);

		UserPO result = this.controller.login(lzb.getID(), lzb.getPassword());
		assertEquals(lzb,result);
		
		

		result = this.controller.login(lyb.getID(), lyb.getPassword());
		assertEquals(lyb,result);

		result = this.controller.login(hqj.getID(), hqj.getPassword());
		assertEquals(hqj,result);

		result = this.controller.login(mxf.getID(), mxf.getPassword());
		assertEquals(mxf,result);

		
	}

	@Test
	void testAddUser() {
		UserPO lzb = new UserPO("161250063","lzb","161250063",RoleOfUser.StoreManager);
		UserPO lyb = new UserPO("161250061","lyb","161250061",RoleOfUser.FinancialManager);
		UserPO hqj = new UserPO("161250040","hqj","161250040",RoleOfUser.SaleManager);
		UserPO mxf = new UserPO("161250088","mxf","161250088",RoleOfUser.GeneralManager);

		UserPO result = this.controller.login(lzb.getID(), lzb.getPassword());
		assertEquals(lzb,result);
		
		result = this.controller.login(lyb.getID(), lyb.getPassword());
		assertEquals(lyb,result);

		result = this.controller.login(hqj.getID(), hqj.getPassword());
		assertEquals(hqj,result);

		result = this.controller.login(mxf.getID(), mxf.getPassword());
		assertEquals(mxf,result);

		UserPO newer = new UserPO("161250000","qinliu","161250000",RoleOfUser.GeneralManager);
		boolean flag = this.controller.addUser(newer);
		assert(flag);
		
		result = this.controller.login(newer.getID(), newer.getPassword());
		assertEquals(newer,result);
		
		
		
	}

	@Test
	void testDeleteUser() {

		UserPO lzb = new UserPO("161250063","lzb","161250063",RoleOfUser.StoreManager);
		UserPO lyb = new UserPO("161250061","lyb","161250061",RoleOfUser.FinancialManager);
		UserPO hqj = new UserPO("161250040","hqj","161250040",RoleOfUser.SaleManager);
		UserPO mxf = new UserPO("161250088","mxf","161250088",RoleOfUser.GeneralManager);

		UserPO result = this.controller.login(lzb.getID(), lzb.getPassword());
		assertEquals(lzb,result);
		
		result = this.controller.login(lyb.getID(), lyb.getPassword());
		assertEquals(lyb,result);

		result = this.controller.login(hqj.getID(), hqj.getPassword());
		assertEquals(hqj,result);

		result = this.controller.login(mxf.getID(), mxf.getPassword());
		assertEquals(mxf,result);

		boolean flag = this.controller.deleteUser(lzb.getID());
		assert(flag);
		
		result = this.controller.login(lzb.getID(), lzb.getPassword());
		assert(result==null);
		
	
		
	}

	@Test
	void testUpdateUser() {
		UserPO lzb = new UserPO("161250063","lzb","161250063",RoleOfUser.StoreManager);
		UserPO lyb = new UserPO("161250061","lyb","161250061",RoleOfUser.FinancialManager);
		UserPO hqj = new UserPO("161250040","hqj","161250040",RoleOfUser.SaleManager);
		UserPO mxf = new UserPO("161250088","mxf","161250088",RoleOfUser.GeneralManager);

		UserPO result = this.controller.login(lzb.getID(), lzb.getPassword());
		assertEquals(lzb,result);
		
		result = this.controller.login(lyb.getID(), lyb.getPassword());
		assertEquals(lyb,result);

		result = this.controller.login(hqj.getID(), hqj.getPassword());
		assertEquals(hqj,result);

		result = this.controller.login(mxf.getID(), mxf.getPassword());
		assertEquals(mxf,result);

		lzb.setName("cuteboy!");
		boolean flag = this.controller.updateUser(lzb);
		assert(flag);
		
		result = this.controller.login(lzb.getID(), lzb.getPassword());
		assertEquals(lzb,result);
		
		
	}

}
