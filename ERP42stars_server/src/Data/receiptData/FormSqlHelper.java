package Data.receiptData;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import po.formPO.FormPO;
import po.formPO.financeFormPO.FinanceFormPO;
import utility.SLog;
import utility.SqlHelper;

public class FormSqlHelper extends SqlHelper {
	
	
	public static String createID(FormPO po) {
		
		    
		 Connection conn = getConn();
		 int i = 0;
		 String sql = "insert into formid (date,formID,num) values(?,?,?)";
		 PreparedStatement pstmt;
		 try {
		        pstmt = (PreparedStatement) conn.prepareStatement(sql);
		        pstmt.setDate(1, new Date(System.currentTimeMillis())   );
		        pstmt.setInt(2, po.getState().ordinal());
		        pstmt.setTimestamp(3,  po.getCreateTime());
		        i=pstmt.executeUpdate();
		        pstmt.close();
		        conn.close();
		   } catch (SQLException e) {
		    	SLog.wr("insert失败");
		        e.printStackTrace();
		   }  
		 
		 
		 
		return null;
		
	}
	public static  boolean insertItem(String kind) {
		boolean flag=false;
		
		 Connection conn = getConn();
		 int i = 0;
		 String sql = "insert into formid (date,formID,num) values(?,?,?)";
		 PreparedStatement pstmt;
		 try {
		        pstmt = (PreparedStatement) conn.prepareStatement(sql);
		        pstmt.setDate(1, new Date(System.currentTimeMillis())   );
		        pstmt.setString(2,kind);
		        pstmt.setInt(3, 0);
		       
		        
		         i=pstmt.executeUpdate();
		        
		        pstmt.close();
		        conn.close();
		        flag=true;
		   } catch (SQLException e) {
		    	SLog.wr("insert失败");
		        e.printStackTrace();
		   }  
		
		return flag;
	}
}
