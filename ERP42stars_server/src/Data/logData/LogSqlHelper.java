package Data.logData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Data.receiptData.FormSqlHelper;
import po.LogItemPO;
import po.KeyForSearchLog;
import utility.SLog;

public class LogSqlHelper extends FormSqlHelper {
	 static  String TABLE="log";	
	
	
	public static  boolean insert(LogItemPO po) {
		boolean flag=false;																																																																										
		 Connection conn = getConn();
		    int i = 0;
		  
		    try {
		    	
		    	String sql = "insert into "+TABLE+"(message,operatorID,time) values(?,?,?)";
				PreparedStatement pstmt;
				pstmt = (PreparedStatement) conn.prepareStatement(sql);
				pstmt.setString(1, po.getMessage());
				pstmt.setString(2, po.getUserID());
				pstmt.setTimestamp(3, po.getTime());
		        i=pstmt.executeUpdate();
		        pstmt.close();
		        conn.close();
		    } catch (SQLException e) {
		    	SLog.wr("insert失败");
		        e.printStackTrace();
		    }
		if(i==1) {
			flag=true;
		}
		return flag;
	}

	
	public static ArrayList<LogItemPO> search(KeyForSearchLog key) {
		ArrayList<LogItemPO> re =new ArrayList<LogItemPO>();
		
		 Connection conn = getConn();
		 
		    String sql=makeQuery( key) ;
		    
		    PreparedStatement pstmt;
		    try {
		    	
		        pstmt = (PreparedStatement)conn.prepareStatement(sql);
		        
		        ResultSet rs = pstmt.executeQuery();
		        
		        int col = rs.getMetaData().getColumnCount();
		        System.out.println("============================");
		        while (rs.next()) {
		        	LogItemPO rt=new LogItemPO();
		    		rt.setMessage(rs.getString(1));
		    		rt.setUserID(rs.getString(2));
		    		rt.setTime(rs.getTimestamp(3));
		    		
		            re.add(rt);
		        }
		            System.out.println("============================");
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    
		  return re;
	}
	protected static String makeQuery(KeyForSearchLog key){
		String sql= "select * from "+TABLE+" where 1";
		if(key.getMessage()!=null) {
	    	sql=sql+"&&"+ "message like '%"+key.getMessage()+"%'";
	    }
	    if(key.getOperatorID()!=null) {
		 	sql=sql+"&&"+ "operatorID like '%"+key.getOperatorID()+"%'";
		}
	    sql=sql+"&&"+ "time between '"+key.getCreateTimeMin().toString()+"' AND '"+key.getCreateTimeMax().toString()+"'";
			
	    System.out.println(sql);
		return sql;
		
	}
	
	
	
	protected static LogItemPO createPO(String mes[]) {
	
		return null;
	}
		
		/**
		 * 测试用方法
		 * @param args
		 */
	public static void main(String args[]) {
		LogItemPO c=new LogItemPO();
		c.setMessage("新增");
		
		insert(c);
	
	
//
//		KeyForSearchLog key =new 	KeyForSearchLog();
//		key.setMessage("aaa");
//		for(	LogItemPO c:search(key)) {
//			System.out.println(c.getTime().toString());
//		}
//		
////		LogItemPO p=getForm("fff");
////		insertForm(p);
	}
	
}
