package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Data.DBConnector;


public class SqlHelper {
	 public static void main (String args[]) {
		 getConn();
	 }
	
	public static Connection getConn() {
//	  //  String driver = "com.mysql.cj.jdbc.Driver";
//	    String url = "jdbc:mysql://localhost:3306/erp?serverTimezone=GMT%2B8";
//	    String username = "root";
//	    String password = "";
//	    Connection conn = null;
//	    try {
//	    
//	   //     Class.forName(driver); //classLoader,加载对应驱动
//	        conn = (Connection) DriverManager.getConnection(url, username, password);
//	    	System.out.println("成功连接数据库");
//	    	
//	    } catch (SQLException e) {
//	    	SLog.wr("连接数据库失败");
//	        e.printStackTrace();
//	    }
	    return  new DBConnector().connection ;
	}
	
	
	
}
