package BL.strategyBL;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BL.stockBL.StockController;
import utility.LevelOfCustomer;
import vo.goods.GoodsVO;
import vo.strategy.CustomerStrategyVO;
import vo.strategy.StrategyVO;
import vo.strategy.TotalStrategyVO;

class StrategyControllerTest {

	StrategyController controller = new StrategyController();
	
	@BeforeEach
	void init() {
		this.controller = new StrategyController();
	}
	
	@Test
	void testCreateStrategy() throws RemoteException {
		java.util.Date today = new java.util.Date();
		TotalStrategyVO test1 = new TotalStrategyVO(today, 15, null,
				20,10, new ArrayList<GoodsVO>());
		
		String id1 = this.controller.createStrategy(test1);
		
		StrategyVO result = this.controller.searchStrategy(id1);
		test1.setID(id1);
		StrategyVO ans = test1;
		
		ArrayList<GoodsVO> giftList  =  new ArrayList<GoodsVO>();
		StockController controller = new StockController();
		GoodsVO vo = controller.searchGoodsByID("SP5");
		giftList.add(vo);
		CustomerStrategyVO customer = new CustomerStrategyVO(today,15,null,
				LevelOfCustomer.level1,LevelOfCustomer.level1,
				0.8,giftList);
		this.controller.createStrategy(customer);
		assertEquals(ans,result);
		
//		assert(this.controller.deleteStrategy(id1));
	}

	@Test
	void testDeleteStrategy() throws RemoteException, InterruptedException {
		Thread.sleep(1000);
		java.util.Date today = new java.util.Date();
		TotalStrategyVO test1 = new TotalStrategyVO(today, 15, null,
				20,10, new ArrayList<GoodsVO>());
		
		String id1 = this.controller.createStrategy(test1);
		
		StrategyVO result = this.controller.searchStrategy(id1);
		test1.setID(id1);
		StrategyVO ans = test1;
		
		assertEquals(ans,result);
		
		assert(this.controller.deleteStrategy(id1));
		
		assert(this.controller.searchStrategy(id1)==null);
		
		
	}

	@Test
	void testUpdateStrategy() throws RemoteException, InterruptedException {
		Thread.sleep(2000);
		java.util.Date today = new java.util.Date();
		TotalStrategyVO test1 = new TotalStrategyVO(today, 15, null,
				20,10, new ArrayList<GoodsVO>());
		
		String id1 = this.controller.createStrategy(test1);
		
		StrategyVO result = this.controller.searchStrategy(id1);
		test1.setID(id1);
		StrategyVO ans = test1;
		
		assertEquals(ans,result);
		
		test1.setDuration(654654);
		ans = test1;
		
		assert(this.controller.updateStrategy(test1));
		
		result = this.controller.searchStrategy(id1);
		
		assertEquals(ans,result);
		
		assert(this.controller.deleteStrategy(id1));
		
		assert(this.controller.searchStrategy(id1)==null);

		
	}

	@Test
	void testSearchStrategy() throws RemoteException, InterruptedException {
		Thread.sleep(3000);
		java.util.Date today = new java.util.Date();
		TotalStrategyVO test1 = new TotalStrategyVO(today, 15, null,
				20,10, new ArrayList<GoodsVO>());
		
		String id1 = this.controller.createStrategy(test1);
		
		StrategyVO result = this.controller.searchStrategy(id1);
		test1.setID(id1);
		StrategyVO ans = test1;
		
		assertEquals(ans,result);
		
		assert(this.controller.deleteStrategy(id1));
		
		assert(this.controller.searchStrategy(id1)==null);

	}

	@Test
	void testGetAllStrategy() throws RemoteException, InterruptedException {
		Thread.sleep(4000);
		java.util.Date today = new java.util.Date();
		TotalStrategyVO test1 = new TotalStrategyVO(today, 15, null,
				20,10, new ArrayList<GoodsVO>());
		
		String id1 = this.controller.createStrategy(test1);
		
		StrategyVO result = this.controller.searchStrategy(id1);
		test1.setID(id1);
		StrategyVO ans = test1;
		
		assertEquals(ans,result);
		
		ArrayList<StrategyVO> resultList = this.controller.getAllStrategy();
		
		ArrayList<StrategyVO> ansList = new ArrayList<StrategyVO>();
		ansList.add(ans);
		
		assertEquals(ansList,resultList);
		
		assert(this.controller.deleteStrategy(id1));
		
		assert(this.controller.searchStrategy(id1)==null);

	}

}
