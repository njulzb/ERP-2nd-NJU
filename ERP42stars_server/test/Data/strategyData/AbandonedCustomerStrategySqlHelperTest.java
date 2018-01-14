package Data.strategyData;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import Data.DBConnector;
import po.goods.GoodsPO;
import po.strategy.CustomerStrategyPO;
import utility.LevelOfCustomer;

class CustomerStrategySqlHelperTest {
	
	StrategySqlHelper manager = new StrategySqlHelper();

	@AfterEach
	void truncate() {
		String cmd = "truncate customerstrategylist;";
		new DBConnector().runSql(cmd);
		
	}
	@Test
	void testCreateStrategy() {
//		Date date = new Date();
//		int days = 10;
//		String id = "1";
//		LevelOfCustomer begin = LevelOfCustomer.level1;
//		LevelOfCustomer end = LevelOfCustomer.level5;
//		int value = 20;
//		int amount = 30;
//		double discount = 0.8;
//		ArrayList<GoodsPO> giftList = new ArrayList<GoodsPO>();
//		
//		CustomerStrategyPO curr = new CustomerStrategyPO(date,days,id,begin,end,value,amount,discount,giftList);
//		
//		manager.createStrategy(curr);
//		assert(true);
	}

	@Test
	void testDeleteStrategy() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateStrategy() {
		fail("Not yet implemented");
	}

	@Test
	void testSearchStrategy() {
//		this.testCreateStrategy();
//		CustomerStrategyPO curr = this.manager.searchStrategy("1");
//		System.out.println(curr.getDiscount());
//		assert (true);
	}

	@Test
	void testGetAllStrategy() {
		fail("Not yet implemented");
	}

}
