package Data.stockData;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import po.goods.GoodsClassPO;
import po.goods.GoodsPO;

class GoodsDataControllerTest {

	GoodsDataController controller = new GoodsDataController();
	GoodsClassDataController helper = new GoodsClassDataController();
	
	@BeforeEach
	void init() throws RemoteException {
		
		
		
		
		
		StockDBConnector connector = StockDBConnector.getConnector();
		String cmd = "truncate goodslist;";
		connector.runSql(cmd);

		
		
		cmd = "truncate goodsclasslist;";
		connector.runSql(cmd);
		
		
		GoodsClassPO root = new GoodsClassPO(1,"root",1);
		GoodsClassDataController classController = new GoodsClassDataController();
		int id= classController.add(root);
		assert(id==1);
		
		this.controller = new GoodsDataController();
		this.helper = new GoodsClassDataController();
		this.controller.setHelper(this.helper);
	}
	
	@AfterEach
	void recover() {
		StockDBConnector connector = StockDBConnector.getConnector();
		String cmd = "truncate goodslist;";
		connector.runSql(cmd);

		
		
		
	}
	

	@Test
	void testAdd() throws RemoteException {
		GoodsPO adder1 = new GoodsPO(1,"first goods", 1,null,//父类属性
				"normal type",2017,
				120,998,12,1999,
				10,"batch1001",new Date());
		GoodsPO adder2 = new GoodsPO(2,"first goods", 1,null,//父类属性
				"normal type",2017,
				120,998,12,1999,
				10,"batch1001",new Date());

		int id1 = this.controller.add(adder1);
		int id2 = this.controller.add(adder2);
		
		assert(id1==1 && id2==2);
		
		GoodsPO ans1 = this.controller.searchGoodsByIDAcurrate(id1);
		GoodsPO ans2 = this.controller.searchGoodsByIDAcurrate(id2);
		
		assertEquals(ans1,adder1);
		assertEquals(ans2,adder2);
		
	}

	@Test
	void testModify() throws RemoteException {
		GoodsPO adder1 = new GoodsPO(1,"first goods", 1,null,//父类属性
				"normal type",2017,
				120,998,12,1999,
				10,"batch1001",new Date());
		GoodsPO adder2 = new GoodsPO(2,"second goods", 1,null,//父类属性
				"normal type",2017,
				120,998,12,1999,
				10,"batch1001",new Date());

		int id1 = this.controller.add(adder1);
		int id2 = this.controller.add(adder2);
		
		assert(id1==1 && id2==2);
		
		GoodsPO ans1 = this.controller.searchGoodsByIDAcurrate(id1);
		GoodsPO ans2 = this.controller.searchGoodsByIDAcurrate(id2);
		
		assertEquals(ans1,adder1);
		assertEquals(ans2,adder2);

		ans1.setName("new first goods");
		boolean flag = this.controller.modify(ans1);
		assert(flag);
		GoodsPO result = this.controller.searchGoodsByIDAcurrate(ans1.getID());
		
		assertEquals(ans1,result);
	}

	@Test
	void testDelete() throws RemoteException {

		GoodsPO adder1 = new GoodsPO(1,"first goods", 1,null,//父类属性
				"normal type",2017,
				120,998,12,1999,
				10,"batch1001",new Date());
		GoodsPO adder2 = new GoodsPO(2,"first goods", 1,null,//父类属性
				"normal type",2017,
				120,998,12,1999,
				10,"batch1001",new Date());

		int id1 = this.controller.add(adder1);
		int id2 = this.controller.add(adder2);
		
		assert(id1==1 && id2==2);
		
		GoodsPO ans1 = this.controller.searchGoodsByIDAcurrate(id1);
		GoodsPO ans2 = this.controller.searchGoodsByIDAcurrate(id2);
		
		assertEquals(ans1,adder1);
		assertEquals(ans2,adder2);
		
		boolean flag = this.controller.delete(id1);
		assert(flag);
		
		ans1 = this.controller.searchGoodsByIDAcurrate(id1);
		assert(ans1==null);
	
	}

	@Test
	void testSearchGoodsByIDAcurrate() throws RemoteException {
		GoodsPO adder1 = new GoodsPO(1,"first goods", 1,null,//父类属性
				"normal type",2017,
				120,998,12,1999,
				10,"batch1001",new Date());
		GoodsPO adder2 = new GoodsPO(2,"first goods", 1,null,//父类属性
				"normal type",2017,
				120,998,12,1999,
				10,"batch1001",new Date());

		int id1 = this.controller.add(adder1);
		int id2 = this.controller.add(adder2);
		
		assert(id1==1 && id2==2);
		
		GoodsPO ans1 = this.controller.searchGoodsByIDAcurrate(id1);
		GoodsPO ans2 = this.controller.searchGoodsByIDAcurrate(id2);
		
		assertEquals(ans1,adder1);
		assertEquals(ans2,adder2);
		
		GoodsPO result = this.controller.searchGoodsByIDAcurrate(ans1.getID());
		assertEquals(ans1,result);
		
	}

	@Test
	void testSearchGoodsByID() throws RemoteException {

		GoodsPO adder1 = new GoodsPO(1,"first goods", 1,null,//父类属性
				"normal type",2017,
				120,998,12,1999,
				10,"batch1001",new Date());
		GoodsPO adder2 = new GoodsPO(2,"first goods", 1,null,//父类属性
				"normal type",2017,
				120,998,12,1999,
				10,"batch1001",new Date());

		int id1 = this.controller.add(adder1);
		int id2 = this.controller.add(adder2);
		
		assert(id1==1 && id2==2);
		
		GoodsPO ans1 = this.controller.searchGoodsByIDAcurrate(id1);
		GoodsPO ans2 = this.controller.searchGoodsByIDAcurrate(id2);
		
		assertEquals(ans1,adder1);
		assertEquals(ans2,adder2);
		
	
	}

	@Test
	void testSearchGoodsByName() throws RemoteException {
		GoodsPO adder1 = new GoodsPO(1,"first goods", 1,null,//父类属性
				"normal type",2017,
				120,998,12,1999,
				10,"batch1001",new Date());
		GoodsPO adder2 = new GoodsPO(2,"second goods", 1,null,//父类属性
				"normal type",2017,
				120,998,12,1999,
				10,"batch1001",new Date());

		int id1 = this.controller.add(adder1);
		int id2 = this.controller.add(adder2);
		
		assert(id1==1 && id2==2);
		
		GoodsPO ans1 = this.controller.searchGoodsByIDAcurrate(id1);
		GoodsPO ans2 = this.controller.searchGoodsByIDAcurrate(id2);
		
		assertEquals(ans1,adder1);
		assertEquals(ans2,adder2);

		
		ArrayList<GoodsPO> resultList = this.controller.searchGoodsByNameAccurate(ans1.getName());
		ArrayList<GoodsPO> ansList = new ArrayList<GoodsPO>();
		ansList.add(ans1);
		
		assertEquals(ansList,resultList);
		
	}

	@Test
	void testGetAll() throws RemoteException {
		GoodsPO adder1 = new GoodsPO(1,"first goods", 1,null,//父类属性
				"normal type",2017,
				120,998,12,1999,
				10,"batch1001",new Date());
		GoodsPO adder2 = new GoodsPO(2,"second goods", 1,null,//父类属性
				"normal type",2017,
				120,998,12,1999,
				10,"batch1001",new Date());

		int id1 = this.controller.add(adder1);
		int id2 = this.controller.add(adder2);
		
		assert(id1==1 && id2==2);
		
		GoodsPO ans1 = this.controller.searchGoodsByIDAcurrate(id1);
		GoodsPO ans2 = this.controller.searchGoodsByIDAcurrate(id2);
		
		assertEquals(ans1,adder1);
		assertEquals(ans2,adder2);

		ArrayList<GoodsPO> resultList = this.controller.getAll();
		ArrayList<GoodsPO> ansList = new ArrayList<GoodsPO>();
		ansList.add(ans1);
		ansList.add(ans2);
		
		assertEquals(ansList,resultList);
		
		
	}

}
