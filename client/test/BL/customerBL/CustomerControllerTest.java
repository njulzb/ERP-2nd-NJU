package BL.customerBL;

import static org.junit.Assert.*;

import java.io.File;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import po.KeyForSearchCustomer;
import utility.LevelOfCustomer;
import utility.TypeOfCustomer;
import vo.CustomerVO;

public class CustomerControllerTest {
	CustomerController controller = new CustomerController();

	String getFolderPath() {
		File directory = new File("");// 璁惧畾涓哄綋鍓嶆枃浠跺す
		String folderPath = "";
		try {
			folderPath = directory.getCanonicalPath();

		} catch (Exception e) {
		}
		return folderPath;
	}

	Boolean compare(CustomerVO a, CustomerVO b) {

		if (a.getAddress().equals(b.getAddress()) && a.getDefaultOperatorid().equals(b.getDefaultOperatorid())
				&& a.getEmail().equals(b.getEmail()) && a.getId().equals(b.getId())
				&& a.getImagePath().equals(b.getImagePath()) && a.getLevel().equals(b.getLevel())
				&& a.getName().equals(b.getName()) && a.getPayAmount() == b.getPayAmount()
				&& a.getPhoneNumber().equals(b.getPhoneNumber()) && a.getPostcode().equals(b.getPostcode())
				&& a.getReceiveAmount() == b.getReceiveAmount() && a.getReceiveLimit() == b.getReceiveLimit()
				&& a.getType().equals(b.getType())) {
			return true;
		}
		return false;

	}

	@Before
	public void init() {
		this.controller = new CustomerController();
	}

	@Test
	public void testAddCustomer() {
		CustomerVO hqj1 = new CustomerVO("111", TypeOfCustomer.exporter, LevelOfCustomer.level3, "fortest", "0592-8585555",
				"Xian Yue mental hospital", "361000", "5438438@163.com", 100, 50, 1000,
				getFolderPath() + "/temp/33492312.png", "111");

		this.controller.addCustomer(hqj1);
		KeyForSearchCustomer key=new KeyForSearchCustomer();
		key.setName("fortest");
		ArrayList<CustomerVO> cus= this.controller.getCustomerList(key);
		for (CustomerVO i:cus){
			System.out.println(i.getName());
		}
		System.out.println(cus.size()+"???");

		assertEquals(hqj1,this.controller.getCustomer(cus.get(0).getId()));

		for (CustomerVO i:cus){
			this.controller.deleteCustomer(i);
		}
	}

	@Test
	public void testGetCustomer() {
		CustomerVO hqj1 = new CustomerVO("111", TypeOfCustomer.exporter, LevelOfCustomer.level1, "testGetCustomer", "0592-8585555",
				"Xian Yue mental hospital", "361000", "5438438@163.com", 100, 50, 1000,
				getFolderPath() + "/temp/33492312.png", "111");

		this.controller.addCustomer(hqj1);

		KeyForSearchCustomer key=new KeyForSearchCustomer();
		key.setName("testGetCustomer");
		ArrayList<CustomerVO> cus= this.controller.getCustomerList(key);
		System.out.println(cus.size()+"???");

		assertEquals(hqj1, this.controller.getCustomer(cus.get(0).getId()));

		for (CustomerVO i:cus){
			this.controller.deleteCustomer(i);
		}
	}

	@Test
	public void testGetCustomerList() {
		CustomerVO hqj1 = new CustomerVO("111", TypeOfCustomer.exporter, LevelOfCustomer.level1, "hqj", "0592-8585555",
				"Xian Yue mental hospital", "361000", "5438438@163.com", 100, 50, 1000,
				getFolderPath() + "/temp/33492312.png", "newlist");
		CustomerVO lzb2 = new CustomerVO("11111",TypeOfCustomer.exporter,LevelOfCustomer.level2,"lzb","438438","250",
				"361000","5438438@163.com",100,50,1000,"/temp/33492312.png","newlist");

		this.controller.addCustomer(hqj1);
		this.controller.addCustomer(lzb2);

		KeyForSearchCustomer key=new KeyForSearchCustomer();
		key.setDefaultOperatorID("newlist");
		ArrayList<CustomerVO> cus= this.controller.getCustomerList();

		assertEquals(hqj1, this.controller.getCustomer(cus.get(0).getId()));

		for (CustomerVO i:cus){
			this.controller.deleteCustomer(i);
		}
	}

	@Test
	public void testModifyCustomer() {
		CustomerVO hqj1 = new CustomerVO("", TypeOfCustomer.exporter, LevelOfCustomer.level1, "testModi", "0592-8585555",
				"Xian Yue mental hospital", "361000", "5438438@163.com", 100, 50, 1000,
				getFolderPath() + "/temp/33492312.png", "111");

		this.controller.addCustomer(hqj1);
		KeyForSearchCustomer key=new KeyForSearchCustomer();
		key.setName("testModi");
		ArrayList<CustomerVO> cus= this.controller.getCustomerList(key);

		hqj1.setId(cus.get(0).getId());
		hqj1.setEmail("361");

		this.controller.modifyCustomer(hqj1);

		assertEquals(hqj1, this.controller.getCustomer(cus.get(cus.size()-1).getId()));

		for (CustomerVO i:cus){
			this.controller.deleteCustomer(i);
		}
	}

	@Test
	public void testDeleteCustomer() {
		CustomerVO hqj1 = new CustomerVO("", TypeOfCustomer.exporter, LevelOfCustomer.level1, "testDelete", "0592-8585555",
				"Xian Yue mental hospital", "361000", "5438438@163.com", 100, 50, 1000,
				getFolderPath() + "/temp/33492312.png", "111");

		this.controller.addCustomer(hqj1);
		KeyForSearchCustomer key=new KeyForSearchCustomer();
		key.setName("testDelete");
		ArrayList<CustomerVO> cus= this.controller.getCustomerList(key);
		this.controller.deleteCustomer(cus.get(0));
		cus= this.controller.getCustomerList(key);
		assert(cus.size()==0);
	}

	@Test
	public void testModifyReceiveAmount() {
		CustomerVO hqj1 = new CustomerVO("111", TypeOfCustomer.exporter, LevelOfCustomer.level1, "testReceive", "0592-8585555",
				"Xian Yue mental hospital", "361000", "5438438@163.com", 100, 50, 1000,
				getFolderPath() + "/temp/33492312.png", "111");
		CustomerVO hqj2 = new CustomerVO("111", TypeOfCustomer.exporter, LevelOfCustomer.level1, "testReceive", "0592-8585555",
				"Xian Yue mental hospital", "361000", "5438438@163.com", 100, 100, 1000,
				getFolderPath() + "/temp/33492312.png", "111");

		this.controller.addCustomer(hqj1);
		KeyForSearchCustomer key=new KeyForSearchCustomer();
		key.setName("testReceive");
		ArrayList<CustomerVO> cus= this.controller.getCustomerList(key);

		System.out.println(cus.size()+"???");

		for (CustomerVO i:cus){
			System.out.println(i.getName());
		}

		this.controller.modifyReceiveAmount(cus.get(cus.size()-1).getId(), 100);

		assertEquals(hqj2, this.controller.getCustomer(cus.get(cus.size()-1).getId()));

		for (CustomerVO i:cus){
			this.controller.deleteCustomer(i);
		}
	}

	@Test
	public void testModifyPayAmount() {
		CustomerVO hqj1 = new CustomerVO("111", TypeOfCustomer.exporter, LevelOfCustomer.level1, "testModify", "0592-8585555",
				"Xian Yue mental hospital", "361000", "5438438@163.com", 100, 50, 1000,
				getFolderPath() + "/temp/33492312.png", "111");
		CustomerVO hqj2 = new CustomerVO("111", TypeOfCustomer.exporter, LevelOfCustomer.level1, "testModify", "0592-8585555",
				"Xian Yue mental hospital", "361000", "5438438@163.com", 100, 50, 0,
				getFolderPath() + "/temp/33492312.png", "111");

		this.controller.addCustomer(hqj1);
		KeyForSearchCustomer key=new KeyForSearchCustomer();
		key.setName("testModify");
		ArrayList<CustomerVO> cus= this.controller.getCustomerList(key);

		System.out.println(cus.size()+"???");

		this.controller.modifyPayAmount(cus.get(0).getId(), 0);

		assertEquals(hqj2, this.controller.getCustomer(cus.get(0).getId()));

		for (CustomerVO i:cus){
			this.controller.deleteCustomer(i);
		}
	}

	@Test
	public void testGetCustomerByID() {
		CustomerVO hqj1 = new CustomerVO("111", TypeOfCustomer.exporter, LevelOfCustomer.level1, "testGet", "0592-8585555",
				"Xian Yue mental hospital", "361000", "5438438@163.com", 100, 50, 1000,
				getFolderPath() + "/temp/33492312.png", "111");

		this.controller.addCustomer(hqj1);
		KeyForSearchCustomer key=new KeyForSearchCustomer();
		key.setName("testGet");
		ArrayList<CustomerVO> cus= this.controller.getCustomerList(key);

		System.out.println(cus.size()+"???");

		assertEquals(hqj1, this.controller.getCustomer(cus.get(0).getId()));

		for (CustomerVO i:cus){
			this.controller.deleteCustomer(i);
		}
	}

}
