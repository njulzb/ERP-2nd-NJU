package Data.strategyData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Data.DBConnector;
import po.strategy.StrategyPO;
import utility.ByteHelper;

/**
 * 避免多个controller 同时对同一个表进行操作，出现错误
 * @author lzb
 *
 */
public class StrategyConnector {

//	数据库总连接
	DBConnector dbconnector = null;
//	促销策略部分连接
	static StrategyConnector strategyConnector = null;
//	connection
	Connection connection = null;
	
	/**
	 * 私有构造方法
	 */
	private StrategyConnector() {
		this.dbconnector = new DBConnector();
		this.connection = this.dbconnector.connection;
	}
	
	
	/**
	 * 公有的getInstance 方法
	 */
	public static StrategyConnector getConnector() {
		if (strategyConnector==null) {
			strategyConnector = new StrategyConnector();
		}
		
		return strategyConnector;
	}
	
	/**
	 * 业务方法
	 */
	public void runsql(String cmd) {
		this.dbconnector.runSql(cmd);
	}
	
	public void insertObject(String tableName,String id,Object object) {
		
		String cmd = "insert into Tablename value('Id',?);";
		cmd = cmd.replaceAll("Tablename", tableName);
		cmd = cmd.replaceAll("Id",id);
		
		
		byte[] bytesdata = null;
		bytesdata = ByteHelper.ObjectToByte(object);
		
		

		
		try {
			PreparedStatement prestate  = this.connection.prepareStatement(cmd);
			prestate.setBytes(1, bytesdata);
			prestate.executeUpdate();
			System.out.println("insert object success!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("insert object failed....");
		}
	}
	
	
	public ArrayList<StrategyPO> queryStrategy(String cmd) {
		ArrayList<StrategyPO> resultList = new ArrayList<StrategyPO>();
		
		
//		得到resultset
		ResultSet resultset = this.dbconnector.query(cmd);
		
//		对resultset进行拆解，包装成strategyPO
		try {
			while (resultset.next()) {
				byte[] byteArray = resultset.getBytes("object"); 
				StrategyPO curr =(StrategyPO) ByteHelper.ByteToObject(byteArray);
				
				
				resultList.add(curr);

				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		if (resultList==null || resultList.size()==0) {
			System.out.println("there is no strategy there ,while query strategy...");
			return null;
		}
		
		return resultList;
		
		
	}
	
	
	

}
