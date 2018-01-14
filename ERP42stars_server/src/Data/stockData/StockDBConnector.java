package Data.stockData;

import java.sql.*;
import java.util.ArrayList;

import Data.DBConnector;
import po.goods.GoodsClassPO;
import po.goods.GoodsPO;
import utility.ByteHelper;
/**
 * singleton pattern,
 * 单件模式的stockdbconnector，访问goodsclasslist 和goodslist 两张表，
 * 避免多个controller 同时对同一个表进行操作，出现错误
 * @author LZB
 *
 */

public class StockDBConnector {

//	数据库总连接
	DBConnector dbconnector = new DBConnector();
	
//	库存商品部分 连接
	private static StockDBConnector Stockconnector=new StockDBConnector();
	
//	真正操作的 连接
	Connection connection = this.dbconnector.connection;
	
	/**
	 * 私有的构造方法
	 */
	private StockDBConnector() { 
		/**
		 * 注册一个新的connector 
		 */
		
	}
	
	/**
	 * 静态的getInstance方法
	 * @return
	 */
	public static StockDBConnector getConnector() {
		
		return Stockconnector;
	}
	
	/**
	 * 业务方法
	 * @param cmd
	 */
	public boolean runSql(String cmd) {
		return this.dbconnector.runSql(cmd);
		
	}
	
	/**
	 * to find GoodsClasses
	 * @param cmd
	 * @return
	 */
	public ArrayList<GoodsClassPO> queryGoodsClass(String cmd) {
		
		ArrayList<GoodsClassPO> goodsclassList = new ArrayList<GoodsClassPO>();
//		得到resultset
		ResultSet resultSet = this.dbconnector.query(cmd);
		
//		对结果集进行处理，包装
		try {
			while (resultSet.next()) {
				
				byte[] array = resultSet.getBytes("object");
				GoodsClassPO adder = (GoodsClassPO)ByteHelper.ByteToObject(array);
				
				goodsclassList.add(adder);

			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		结果检验准备返回
		if (goodsclassList == null || goodsclassList.size()==0) {
			System.out.println("goodsclass not found while query");
			return null;
		}
		
		return goodsclassList ;
		
	}
	
		
	public int getLastInsertid() {
		int resultid = -1;
		String cmd = "select last_insert_id();";
		try {
			
			ResultSet resultset = this.dbconnector.query(cmd);
			
			while (resultset.next()) {
				resultid = resultset.getInt("last_insert_id()");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("something wrong while get the last_insert_id;");
			e.printStackTrace();
		}
		
		return resultid;
		
	}
	
	/**
	 * to find goods
	 * @param cmd
	 * @return the GoodsPO list , null if not found
	 */
	public ArrayList<GoodsPO> queryGoods(String cmd){
		ArrayList<GoodsPO> goodslist = new ArrayList<GoodsPO>();
		try {
			
			ResultSet resultset = this.dbconnector.query(cmd);
			
//			对resultset进行拆解，包装成goods
			while (resultset.next()) {
//				assemble a GoodsPO
				byte[] array = resultset.getBytes("object");
				GoodsPO adder = (GoodsPO) ByteHelper.ByteToObject(array);
				
				adder.setID(resultset.getInt("id"));
				goodslist.add(adder);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("something wrong while query goods ...");
			e.printStackTrace();
		}
		
		if (goodslist==null || goodslist.size()==0) {
			System.out.println("goods not found");
			return null;
		}
		
		return goodslist;
	}
	
	
}
