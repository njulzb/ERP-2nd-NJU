package Data.customerData;

import po.AccountPO;
import po.CustomerPO;
import po.KeyForSearchAccount;
import po.KeyForSearchCustomer;
import utility.LevelOfCustomer;

public class CustomerTest {
	/**
	 * 测试用方法
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

		// 新增
		CustomerPO cus1 = new CustomerPO();
		cus1.setName("testName1");
		cus1.setDefaultOperatorID("161250061");
		cus1.setLevel(LevelOfCustomer.level1);
		CustomerSqlHelper.insert(cus1);
		CustomerPO cus2 = new CustomerPO();
		cus2.setName("testName2");
		cus2.setDefaultOperatorID("161250061");
		cus2.setLevel(LevelOfCustomer.level1);
		CustomerSqlHelper.insert(cus2);
		CustomerPO cus3 = new CustomerPO();
		cus3.setName("1testName3");
		cus3.setDefaultOperatorID("161250061");
		cus3.setLevel(LevelOfCustomer.level1);
		CustomerSqlHelper.insert(cus3);

		// 新增delete
		CustomerSqlHelper.delete("0-20180104-001");

		// 筛选
		KeyForSearchCustomer key = new KeyForSearchCustomer();
		key.setName("test");
		CustomerSqlHelper.search(key);

		//编辑
		CustomerPO cus = new CustomerPO();
		cus.setName("newtestName");
		cus.setDefaultOperatorID("16123333");
		CustomerSqlHelper.update(cus);
	}

}
