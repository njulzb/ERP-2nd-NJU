package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 数据库总的连接者，<br/>
 * 两个业务方法：<br/>
 * <b>1. runsql ，单纯地执行sql语句<br/>
 * 2. query ，执行查询语句返回resultset 以供各级分类连接者分析<br/>
 * @author lzb
 *
 */
public class DBConnector {

	/**
	 * 存在的问题：
	 * 1. connection 数量可能出现问题，
	 */
	
	
	static final String IP ="localhost";
	static final String DatabaseName = "4stars";
	
	static final String DBURL = "jdbc:mysql://"+IP+"/"+DatabaseName+"?serverTimezone=GMT&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "123456";

	
	public Connection connection = null;
	
	
	/**
	 * 构造方法
	 */
	public DBConnector() {
		
//		connect to database to get the connection
		try {
			this.connection=DriverManager.getConnection(DBURL,USER,PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("fail to connect to database.... sorry for that...");
		}

	}
	
	
	/**
	 * 业务方法
	 * @param cmd
	 */
	public boolean runSql(String cmd) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(cmd);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("runsql failed...");
			return false;
		}

		return true;
	}

	
	
	public ResultSet query(String cmd) {
		ResultSet resultset = null;
		try {
			Statement statement = this.connection.createStatement(ResultSet.CONCUR_READ_ONLY,
					ResultSet.TYPE_SCROLL_SENSITIVE);
			resultset = statement.executeQuery(cmd);
			return resultset;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("query failed ,while query in dbconnector..");
			return null;
		}
		
	}
	


}
