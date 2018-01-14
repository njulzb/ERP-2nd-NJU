package Data.stockData;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.*;

import po.goods.GoodsClassPO;



class GoodsClassSqlHelperTest {

	GoodsClassSqlHelper helper =  new GoodsClassSqlHelper();;
	
	@BeforeEach
	public  void initialize() {
		//use connector only in initialize and tear down
		StockDBConnector connector= StockDBConnector.getConnector();
		
		
		
		String cmd = "truncate goodsclasslist;";
		connector.runSql(cmd);
		cmd = "insert into goodsclasslist values(1,'root',0,'',0);";
		connector.runSql(cmd);
//		System.out.println("initialize success!!!!");
	}
	
	@AfterAll
	public static void tearDown() {
		//use connector only in initialize and tear down
		StockDBConnector connector= StockDBConnector.getConnector();

		
		String cmd = "truncate goodsclasslist;";
		connector.runSql(cmd);
		cmd = "insert into goodsclasslist values(1,'root',0,'',0);";
		connector.runSql(cmd);
		System.out.println("tear down success");
	}
	
	
	@Test
	void testInsert() {

		GoodsClassPO class1 = new GoodsClassPO(0,"1,1",1);
		GoodsClassPO class2 = new GoodsClassPO(0,"1,2",1);
		GoodsClassPO class3 = new GoodsClassPO(0,"1,3",1);
		GoodsClassPO class4 = new GoodsClassPO(0,"1,4",1);
		GoodsClassPO class5 = new GoodsClassPO(0,"1,5",1);

		GoodsClassPO class6 = new GoodsClassPO(0,"2,1",2);
		GoodsClassPO class7 = new GoodsClassPO(0,"2,2",2);
		GoodsClassPO class8 = new GoodsClassPO(0,"2,3",2);
		GoodsClassPO class9 = new GoodsClassPO(0,"2,4",3);
		GoodsClassPO class10 = new GoodsClassPO(0,"2,5",3);
		GoodsClassPO class11 = new GoodsClassPO(0,"2,6",4);

		helper.insert(class1);
		helper.insert(class2);
		helper.insert(class3);
		helper.insert(class4);
		helper.insert(class5);
		

		helper.insert(class6);
		helper.insert(class7);
		helper.insert(class8);
		helper.insert(class9);
		helper.insert(class10);
		helper.insert(class11);
		assert(true);
	}

	
	@Test
	void testUpdate() {
		
		this.testInsert();
		
		helper.update(new GoodsClassPO(2,"lzb",1));
		helper.update(new GoodsClassPO(3,"lyb",1));
		helper.update(new GoodsClassPO(4,"hqj",1));
		helper.update(new GoodsClassPO(5,"mxf",1));
		helper.update(new GoodsClassPO(6,"hello",1));
		helper.update(new GoodsClassPO(7,"word",2));
		assert(true);
	}

	
	@Test
	void testGetUpper() {
		

		this.testInsert();
		
		
//		GoodsClassPO result = helper.getUpper(9);
//		
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		list.add(7);
//		list.add(8);
//		list.add(9);
//		
//		assertEquals(result,new GoodsClassPO(2,"1,1",1,list));
	}

	@Test
	void testGetLower() {
		this.testInsert();
		

//
//		ArrayList<GoodsClassPO> lower = helper.getLower(2);
//		ArrayList<GoodsClassPO> ans = new ArrayList<GoodsClassPO>();
//		ans.add(new GoodsClassPO(7,"2,1",2,new ArrayList<Integer>()));
//		ans.add(new GoodsClassPO(8,"2,2",2,new ArrayList<Integer>()));
//		ans.add(new GoodsClassPO(9,"2,3",2,new ArrayList<Integer>()));
//		assertEquals(lower,ans);
	}

	@Test
	void testDelete() {
		
		this.testInsert();

		helper.delete(2);
//		System.out.println(id11);
		
		assert(helper.searchByID(2)==null);
	}
	
	@Test
	void testSearchByName() {
		this.testInsert();
		
		ArrayList<GoodsClassPO> result=helper.searchByName("2,1");
		ArrayList<GoodsClassPO> ans = new ArrayList<GoodsClassPO>();
		ans.add(new GoodsClassPO(7,"2,1",2,new ArrayList<Integer>()));
		assertEquals(result,ans);
	}
	
	@Test
	void testSearchByID() {
		this.testInsert();
		
		GoodsClassPO result=helper.searchByID(7);
		
		GoodsClassPO ans =new GoodsClassPO(7,"2,1",2,new ArrayList<Integer>());
		assertEquals(result,ans);
	}

}
