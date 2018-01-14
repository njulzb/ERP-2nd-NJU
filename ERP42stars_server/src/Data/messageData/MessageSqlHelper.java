package Data.messageData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Data.receiptData.FormSqlHelper;
import po.MessagePO;
import po.KeyForSearchMessage;
import utility.SLog;

public class MessageSqlHelper extends FormSqlHelper {
	 static  String TABLE="message";	
	
	
	public static  boolean insert(MessagePO po) {
		boolean flag=false;																																																																										
		 Connection conn = getConn();
		    int i = 0;
		  
		    try {
		    	
		    	String sql = "insert into "+TABLE+"(senderID,receiverID,message,isRead) values(?,?,?,?)";
				PreparedStatement pstmt;
				pstmt = (PreparedStatement) conn.prepareStatement(sql);
				pstmt.setString(1, po.getSenderID());
				pstmt.setString(2, po.getReceiverID());
				pstmt.setString(3, po.getMessage());
				pstmt.setBoolean(4, false);
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
	
	
	public static  boolean delete(int ID) {
		
		boolean flag=false;
		
		 Connection conn = getConn();
		    int i = 0;
		    String sql = "delete from "+TABLE+" where ID='" + ID + "'";
		    PreparedStatement pstmt;
		    try {
		        pstmt = (PreparedStatement) conn.prepareStatement(sql);
		        i = pstmt.executeUpdate();
		        pstmt.close();
		        conn.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
	
		
		if(i==1) {
			flag=true;
		}
		return flag;
	}
	
	
	
	public static boolean update(MessagePO po) {
	    Connection conn = getConn();
	   
	
	    try {
	    	String sql = "UPDATE "+TABLE+" SET " ;
		    	
			  
	 	//    if(po.getID()!=null) { sql=sql+"id='"+po.getID()+"',";}

	 	    if(po.getReceiverID()!=null)sql=sql+"receiverID='"+po.getReceiverID()+"',";
	 	   if(po.getMessage()!=null)sql=sql+"message='"+po.getMessage()+"',";
	 	   if(po.getCreate()!=null)sql=sql+"createTime='"+po.getCreate()+"',";
	 	   if(po.getReadTime()!=null)sql=sql+"readTime='"+po.getReadTime()+"',";
	 	  int c=0;
	 	  if(po.isRead()) {
	 		  c=1;
	 	  }
	 	   sql=sql+"isRead="+c+" ";
	 	  sql=sql+"WHERE ID="+po.getID()+"";
	 	    PreparedStatement pstmt ;
	 		
	 		pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    	return true;
	    } catch (SQLException e) {
	    	SLog.wr("insert失败");
	        e.printStackTrace();
			return false;
	    }
	}
	
	
	
	
	
	
	
	
	
	public static MessagePO get(String id) {
		
		MessagePO re=null;
		 Connection conn = getConn();
		 
		    String sql = "select * from "+TABLE+" where ID='"+id+"'";
		    String out[]=new String [20];
		    PreparedStatement pstmt;
		    ResultSet rs=null;
		    try {
		    	 pstmt = (PreparedStatement)conn.prepareStatement(sql);
			        
			         rs = pstmt.executeQuery();
			         if(rs==null) {
			        	 return null;
			         }
			       
			        while (rs.next()) {
			         	re=new MessagePO();
			    		re.setID(rs.getInt(1));
			    		re.setMessage(rs.getString(2));
			    		re.setSenderID(rs.getString(3));
			    		re.setReceiverID(rs.getString(4));
			    		re.setRead(rs.getBoolean(5));
			    		re.setCreate(rs.getTimestamp(6));
			    		re.setReadTime(rs.getTimestamp(7));
			        }
	
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		 
		  return re;
	
		
	}
	
	public static ArrayList<MessagePO> search(KeyForSearchMessage key) {
		ArrayList<MessagePO> out =new ArrayList<MessagePO>();
		
		 Connection conn = getConn();
		 
		    String sql=makeQuery( key) ;
		    
		    
		    
		    
		    PreparedStatement pstmt;
		    try {
		    	
		        pstmt = (PreparedStatement)conn.prepareStatement(sql);
		        
		        ResultSet rs = pstmt.executeQuery();
		        
		        int col = rs.getMetaData().getColumnCount();
		        System.out.println("============================");
		        while (rs.next()) {
		        	MessagePO re=new MessagePO();
		        	
		    		re.setID(rs.getInt(1));
		    		re.setMessage(rs.getString(2));
		    		re.setSenderID(rs.getString(3));
		    		re.setReceiverID(rs.getString(4));
		    		re.setRead(rs.getBoolean(5));
		    		re.setCreate(rs.getTimestamp(6));
		    		re.setReadTime(rs.getTimestamp(7));
		            out.add(re);
		            
		            System.out.println(re.getCreate().toString());
		        }
		            System.out.println("============================");
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    
		  return out;
	}
	protected static String makeQuery(KeyForSearchMessage key){
		String sql= "select * from "+TABLE+" where 1";
		if(key.getMessage()!=null) {
	    	sql=sql+"&&"+ "message like '%"+key.getMessage()+"%'";
	    }
	    if(key.getReceiverID()!=null) {
		 	sql=sql+"&&"+ "receiverID = '"+key.getReceiverID()+"'";
		}
	    if(key.getSenderID()!=null) {
			 	sql=sql+"&&"+ "senderID = '"+key.getSenderID()+"'";
		}
	    if(key.getIsRead()!=-1) {
		 	sql=sql+"&&"+ "isRead = "+key.getIsRead()+"";
	    }
	    
		sql=sql+"&&"+ "readTime between '"+key.getReadTimeMin().toString()+"' AND '"+key.getReadTimeMax().toString()+"'";
		sql=sql+"&&"+ "createTime between '"+key.getCreateTimeMin().toString()+"' AND '"+key.getCreateTimeMax().toString()+"'";
		
	System.out.println(sql);
		return sql;
		
	}
	
	
	
	protected static MessagePO createPO(String mes[]) {
	
		return null;
	}
		
		/**
		 * 测试用方法
		 * @param args
		 */
	public static void main(String args[]) {
		MessagePO c=new MessagePO();
		c.setSenderID("bbbb");
		c.setReceiverID("aaaa");
		c.setMessage("test");
		insert(c);
		System.out.println("a");
		
		
		
		KeyForSearchMessage key =new 	KeyForSearchMessage();
		key.setMessage("test");
		search(key);
//		
////		MessagePO p=getForm("fff");
////		insertForm(p);
	}
	
	
}
