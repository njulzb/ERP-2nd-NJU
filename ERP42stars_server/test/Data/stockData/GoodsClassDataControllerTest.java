package Data.stockData;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import po.goods.GoodsClassPO;

class GoodsClassDataControllerTest {

	GoodsClassDataController controller = new GoodsClassDataController();
	GoodsDataController helper = new GoodsDataController();
	
	@BeforeEach
	void init() throws RemoteException {
		StockDBConnector connector = StockDBConnector.getConnector();
		String cmd = "truncate goodsclasslist;";
		connector.runSql(cmd);
		
		
		GoodsClassPO root = new GoodsClassPO(1,"root",1);
		GoodsClassDataController controller = new GoodsClassDataController();
		int id= controller.add(root);
		System.out.println("initializing sucess root id = " + id);

		this.controller = new GoodsClassDataController();
		this.helper = new GoodsDataController();
		this.controller.setHelper(this.helper);
	}
	
	@AfterEach
	 void recover() throws RemoteException {
		StockDBConnector connector = StockDBConnector.getConnector();
		String cmd = "truncate goodsclasslist;";
		connector.runSql(cmd);
		
		
		GoodsClassPO root = new GoodsClassPO(1,"root",1);
		GoodsClassDataController controller = new GoodsClassDataController();
		int id= controller.add(root);
		System.out.println("initializing sucess root id = " + id);
		System.out.println("-------------");

		this.controller = new GoodsClassDataController();

	}
	
	@Test
	void testGetRoot() throws RemoteException {
		
		GoodsClassPO ans = new GoodsClassPO(1,"root",1);
		GoodsClassPO result = this.controller.getRoot();
		
		assertEquals(ans,result);
	}

	@Test
	void testAdd() throws RemoteException {
		
		GoodsClassPO adder = new GoodsClassPO(2,"first class",1);
		int id = this.controller.add(adder);
		
		GoodsClassPO result = this.controller.searchClassByID(id);
		
		assertEquals(adder,result);
		
		
		
	}

	@Test
	void testModify() throws RemoteException {
		
		GoodsClassPO adder1 = new GoodsClassPO(2,"first class",1);
		int id = this.controller.add(adder1);

		GoodsClassPO result = this.controller.searchClassByID(id);
		
		assertEquals(adder1,result);

		GoodsClassPO update1 = new GoodsClassPO(2,"first class update",1);
		boolean flag = this.controller.modify(update1);
		assert(flag);
		
		result = this.controller.searchClassByID(id);
		
		assertEquals(update1,result);
		
		
		
	}

	@Test
	void testDelete() throws RemoteException {
		
		GoodsClassPO adder = new GoodsClassPO(2,"first class",1);
		int id = this.controller.add(adder);

		GoodsClassPO result = this.controller.searchClassByID(id);
		
		assertEquals(adder,result);

		boolean flag = this.controller.delete(id);
		assert(flag);
		
		GoodsClassPO dead = this.controller.searchClassByID(id);
		assert(dead==null);
		
	}

	@Test
	void testSearchClassByName() throws RemoteException {

		
		GoodsClassPO adder = new GoodsClassPO(2,"first class",1);
		int id = this.controller.add(adder);
		
		GoodsClassPO result = this.controller.searchClassByID(id);
		
		assertEquals(adder,result);
		
		ArrayList<GoodsClassPO> resultList = this.controller.searchClassByName(adder.getName());
		ArrayList<GoodsClassPO> ansList = new ArrayList<GoodsClassPO>();
		ansList.add(adder);
		
		assertEquals(ansList,resultList);
		
		
		
	
	}

	@Test
	void testSearchClassByID() throws RemoteException {
		GoodsClassPO ans = new GoodsClassPO(1,"root",1);
		GoodsClassPO result = this.controller.getRoot();
	
		assertEquals(ans,result);
		
		
		
		
		
	}

}
