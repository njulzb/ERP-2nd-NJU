package BL.stockBL;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import vo.goods.GoodsClassVO;
import vo.goods.GoodsVO;

class StockControllerTest {

	
	
	@Test
	void testImportGoods() {
		assert(true);
	}

	@Test
	void testExportGoods() {
		assert(true);
	}

	@Test
	void testLookOver() {
		assert(true);
	}

	@Test
	void testExamine() {
		assert(true);
		
	}

	@Test
	void testToExcel() {
		assert(true);
	}

	
	@Test
	void testImage() throws RemoteException {
		StockController controller = new StockController();
		
		GoodsClassVO root = controller.getRoot();
		
		String path = "C:\\Users\\lzb\\Desktop\\a.png";
		GoodsClassVO vo1 = new GoodsClassVO(null,"vo1",root.getID(),path);
		
		String id1 = controller.add(vo1);
		
		GoodsClassVO result = controller.searchClassByID(id1);
		
		System.out.println(result.getImagePath());
		
	}
	
	
	
	@Test
	void testAddGoodsClassVO() throws RemoteException {
		StockController controller = new StockController();
		
		GoodsClassVO vo = new GoodsClassVO("first class","FL1");
		String id1 = controller.add(vo);

		assert(id1!=null);

		GoodsClassVO ans = new GoodsClassVO(id1,"first class","FL1");
		GoodsClassVO result = controller.searchClassByID(id1);
		assertEquals(ans,result);
		
		GoodsClassVO vo2 = new GoodsClassVO("second class",id1);
		String id2 = controller.add(vo2);
		assert(id2!=null);
		
		ans = vo2;
		ans.setID(id2);
		result = controller.searchClassByID(id2);
		assertEquals(ans,result);
		
		
		
		
		
		
		boolean flag = controller.delete(id1);
		assert(flag);
		
		
		
		
		
		
	}

	@Test
	void testModifyGoodsClassVO() throws RemoteException {
		StockController controller = new StockController();
		GoodsClassVO vo1 = new GoodsClassVO("first class","FL1");
		GoodsClassVO vo2 = new GoodsClassVO("second class","FL1");
		
		boolean flag = false;
		String id1 = controller.add(vo1);
		String id2 = controller.add(vo2);
		
		GoodsClassVO vo3 = new GoodsClassVO(id2,"second class update","FL1");
		
		flag = controller.modify(vo3);
		
		assert(flag);
		
		GoodsClassVO result = controller.searchClassByID(id2);
		
		assertEquals(vo3,result);
		
		flag = controller.delete(id1);
		assert(flag);
		flag = controller.delete(id2);
		assert(flag);
		
		
		
	}

	@Test
	void testDeleteGoodsClass() throws RemoteException {
		StockController controller = new StockController();
		GoodsClassVO vo1 = new GoodsClassVO("vo1","FL1");
		GoodsClassVO vo2 = new GoodsClassVO("vo2","FL1");
		

		String id1 = controller.add(vo1);
		String id2 = controller.add(vo2);
		
		boolean flag = controller.delete(id1);
		assert(flag);
		
		GoodsClassVO result = controller.searchClassByID(id1);
		assert(result==null);
		
		result = controller.searchClassByID(id2);
		GoodsClassVO ans = new GoodsClassVO(id2,"vo2","FL1");
		assertEquals(ans,result);
		
		flag = controller.delete(id2);
		assert(flag);
		
		
		
	
		
		
		
		
	}

	@Test
	void testGetUpper() throws RemoteException {
		
		StockController controller = new StockController();
		GoodsClassVO vo1 = new GoodsClassVO("vo1","FL1");
		String id1 = controller.add(vo1);
		
		GoodsClassVO vo2 = new GoodsClassVO("vo2",id1);
		
		
		String id2 = controller.add(vo2);
		
		GoodsClassVO result = controller.getUpper(id2);
		GoodsClassVO ans = controller.searchClassByID(id1);
		assertEquals(result,ans);
	
		boolean flag = controller.delete(id1);
		assert(flag);

	}

	@Test
	void testGetLower() throws RemoteException {
		StockController controller = new StockController();
		GoodsClassVO vo1 = new GoodsClassVO("vo1","FL1");
		String id1 = controller.add(vo1);
		GoodsClassVO vo2 = new GoodsClassVO("vo2",id1);
		GoodsClassVO vo3 = new GoodsClassVO("vo3",id1);
		GoodsClassVO vo4 = new GoodsClassVO("vo4",id1);
		

		
		
		String id2 = controller.add(vo2);
		String id3 = controller.add(vo3);
		String id4 = controller.add(vo4);
		
		
		
		ArrayList<GoodsClassVO> resultList = controller.getLower(id1);
		
		GoodsClassVO ans1 = controller.searchClassByID(id2);
		GoodsClassVO ans2 = controller.searchClassByID(id3);
		GoodsClassVO ans3 = controller.searchClassByID(id4);
		ArrayList<GoodsClassVO> ansList = new ArrayList<GoodsClassVO>();
		ansList.add(ans1);
		ansList.add(ans2);
		ansList.add(ans3);
		
		assertEquals(ansList,resultList);
	
		boolean flag = controller.delete(id1);
		assert(flag);


	}

	@Test
	void testGetRoot() throws RemoteException {
		StockController controller = new StockController();

		GoodsClassVO result = controller.getRoot();
		GoodsClassVO ans = controller.searchClassByID("FL1");
		
		assertEquals(result,ans);
	
		
	}

	@Test
	void testAddGoodsVO() throws RemoteException {
		
		StockController controller = new StockController();
		GoodsClassVO classvo1 = new GoodsClassVO("vo1","FL1");
		

		String id1 = controller.add(classvo1);
		
		
		
		GoodsVO vo1 = new GoodsVO("白炽灯",id1);
		
		GoodsVO vo2 = new GoodsVO("节能灯",id1);
		
		
		String goods1 = controller.add(vo1);
		String goods2 = controller.add(vo2);
		
		
		
		GoodsVO result = controller.searchGoodsByID(goods1);
		GoodsVO ans = new GoodsVO(goods1,"白炽灯",id1);
		
		assertEquals(result,ans);
		
		result = controller.searchGoodsByID(goods2);
		vo2.setID(goods2);
		ans = vo2;
		
		assertEquals(ans,result);
		
		boolean flag = controller.delete(id1);
		assert(flag);
		
	

		
		
	}

	@Test
	void testModifyGoodsVO() throws RemoteException {

		StockController controller = new StockController();
		
		GoodsClassVO classvo1 = new GoodsClassVO("vo1","FL1");
		String id1 = controller.add(classvo1);
		
		
		GoodsVO vo1 = new GoodsVO("白炽灯",id1);
		String goods1 = controller.add(vo1);
		
		
		GoodsVO newer = new GoodsVO(goods1,"节能灯",id1);
		boolean flag = controller.modify(newer);
		assert(flag);
		
		GoodsVO result = controller.searchGoodsByID(goods1);
		assertEquals(newer,result);
		
	
		flag = controller.delete(id1);
		assert(flag);
		
		
		
	
	
	}

	@Test
	void testSearchByID() throws RemoteException {
		StockController controller = new StockController();
		
		GoodsClassVO vo1 = new GoodsClassVO("vo1","FL1");
		String id = controller.add(vo1);
		
		GoodsClassVO result = controller.searchClassByID(id);
		vo1.setID(id);
		GoodsClassVO ans = vo1;
		assertEquals(ans,result);
		
		boolean flag = controller.delete(id);
		assert(flag);
		
		
	}
	
	
	@Test
	void testSearchGoods() throws RemoteException {

		
		StockController controller = new StockController();
		
		GoodsClassVO classvo1 = new GoodsClassVO("vo1","FL1");
		String id1 = controller.add(classvo1);
		
		GoodsClassVO classvo2 = new GoodsClassVO("vo2","FL1");
		String id2 = controller.add(classvo2);
		
		GoodsVO vo1 = new GoodsVO("白炽灯",id1);
		GoodsVO vo2 = new GoodsVO("节能灯",id1);
		GoodsVO vo3 = new GoodsVO("节能灯",id2);
		
		String goods1 = controller.add(vo1);
		String goods2 = controller.add(vo2);
		String goods3 = controller.add(vo3);
		
		
		ArrayList<GoodsVO> resultList = controller.search("灯");
		
		ArrayList<GoodsVO> ansList = new ArrayList<GoodsVO>();
		ansList.add(new GoodsVO(goods1,"白炽灯",id1));
		ansList.add(new GoodsVO(goods2,"节能灯",id1));
		ansList.add(new GoodsVO(goods3,"节能灯",id2));
		
		
		

		assertEquals(ansList,resultList);
		
		
		boolean flag = controller.delete(id1);
		assert(flag);
		
		flag = controller.delete(id2);
		assert(flag);
		
		
		
	
	}

	@Test
	void testGetLower2() throws RemoteException {
		StockController controller = new StockController();
		

		
		String id1 = controller.add(new GoodsClassVO("vo1","FL1"));
		
		
		String goods1 = controller.add(new GoodsVO("goods1",id1));
		
		
		ArrayList<GoodsClassVO> resultList = controller.getLower(id1);
		
		
		ArrayList<GoodsClassVO> ansList = new ArrayList<GoodsClassVO>();
		GoodsClassVO result = controller.searchGoodsByID(goods1);
		ansList.add(result);
		
		assertEquals(ansList,resultList);
		
		
		boolean flag = controller.delete(id1);
		assert(flag);
		
	


	}

}
