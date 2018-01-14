package Data.receiptData.stockFormData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import Data.receiptData.FormSqlHelper;
import po.KeyForSearchForm;
import po.formPO.FormPO;
import po.formPO.stockFormPO.StockFormPO;
import utility.SLog;
import utility.StateOfForm;

public class StockFormSqlHelper extends FormSqlHelper {
	 static  String TABLE="";	
	
	
	public static  boolean insertForm(StockFormPO po,String table) {
		TABLE=table;
		boolean flag=false;																																																																										
		 Connection conn = getConn();
		    int i = 0;
		  
		    try {
		    	 PreparedStatement pstmt =  makePstmt(conn,po);
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
	protected static PreparedStatement makePstmt(	 Connection cnn,StockFormPO po) throws SQLException{
		String sql = "insert into "+TABLE+"(id,state,createTime,finallySaveTime,submitTime,passTime,rejectTime,operatorID,customerID,transItemList,sum,rejectConment) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt;
		pstmt = (PreparedStatement) cnn.prepareStatement(sql);
			
		    	
		pstmt.setString(1, po.getID());
		pstmt.setInt(2, po.getState().ordinal());
		pstmt.setTimestamp(3,  po.getCreateTime());
		pstmt.setTimestamp(4,  po.getSaveTime());
		pstmt.setTimestamp(5,  po.getSubmitTime());
		pstmt.setTimestamp(6,  po.getPassTime());
		pstmt.setTimestamp(7,  po.getRejectTime());
		pstmt.setString(8, po.getOperatorID());
		 pstmt.setString(9, po.getCustomerID());
		 pstmt.setString(10, po.getItemsList());
		 pstmt.setDouble(11, po.getSumMoney());
		pstmt.setString(12, po.getRejectConment());
		        
		        
		
		return pstmt;
		
	}
	
	public static  boolean deleteForm(String ID,String table) {
		TABLE=table;
		boolean flag=false;
		
		 Connection conn = getConn();
		    int i = 0;
		    String sql = "delete from "+TABLE+" where id='" + ID + "'";
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
	
	
	
	public static boolean updateForm(StockFormPO po,String table) {
		TABLE=table;
	    Connection conn = getConn();

	
	    PreparedStatement pstmt ;
	
	    try {
	    	pstmt =  makePstmt(conn,po);
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
	public static StockFormPO getForm(String id,String table) {
		TABLE=table;
		
		StockFormPO re=null;
		 Connection conn = getConn();
		 
		    String sql = "select * from "+TABLE+" where id='"+id+"'";
		    String out[]=new String [20];
		    PreparedStatement pstmt;
		    ResultSet rs=null;
		    try {
		    	 pstmt = (PreparedStatement)conn.prepareStatement(sql);
			        
			         rs = pstmt.executeQuery();
			         if(rs==null) {
			        	 return null;
			         }
			        
			        int col = rs.getMetaData().getColumnCount();
		
			        while (rs.next()) {
			            for (int i = 1; i <= col; i++) {
			            	out[i]=rs.getString(i);
			             
			            }
			        }
			     re=   createPO(out)    ;
			        
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		 
		  return re;
	
		
	}
	
	public static ArrayList<FormPO> searchForm(KeyForSearchForm key,String table) {
		TABLE=table;
		ArrayList<FormPO> re =new ArrayList<FormPO>();
		
		 Connection conn = getConn();
		 
		    String sql=makeQuery( key) ;
		    
		    
		    
		    
		    PreparedStatement pstmt;
		    try {
		    	
		        pstmt = (PreparedStatement)conn.prepareStatement(sql);
		        
		        ResultSet rs = pstmt.executeQuery();
		        
		        int col = rs.getMetaData().getColumnCount();
		        System.out.println("============================");
		        while (rs.next()) {
		        	String out[]=new String [30];
		        	
		            for (int i = 1; i <= col; i++) {
		            	out[i]=rs.getString(i);
		                System.out.print(rs.getString(i) + "\t");
		            
		             }
		            System.out.println("");
		            re.add(createPO(out));
		        }
		            System.out.println("============================");
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    
		  return re;
	}
	protected static String makeQuery(KeyForSearchForm key){
		String sql= "select * from "+TABLE+" where 1";
		if(key.getID()!=null) {
	    	sql=sql+"&&"+ "id='"+key.getID()+"'";
	    }
	    if(key.getCustomerID()!=null) {
		 	sql=sql+"&&"+ "customerID='"+key.getCustomerID()+"'";
		}
	    if(key.getOperatorID()!=null) {
		 	sql=sql+"&&"+ "operatorID='"+key.getOperatorID()+"'";
		}
	    if(key.getState()!=null) {
		 	sql=sql+"&&"+ "state="+key.getState().ordinal()+"";
		}
	    if(key.getRejectConment()!=null) {
		 	sql=sql+"&&"+ "rejectConment like '%"+key.getRejectConment()+"%'";
		}
	    
		sql=sql+"&&"+ "sum < "+key.getSumMoneyMax();
		
		sql=sql+"&&"+ "sum > "+key.getSumMoneyMin();
	    
		
		sql=sql+"&&"+ "submitTime between '"+key.getSubmitTimeMin().toString()+"' AND '"+key.getSubmitTimeMax().toString()+"'";
		sql=sql+"&&"+ "finallySaveTime between '"+key.getSaveTimeMin().toString()+"' AND '"+key.getSaveTimeMax().toString()+"'";
		sql=sql+"&&"+ "passTime between '"+key.getPassTimeMin().toString()+"' AND '"+key.getPassTimeMax().toString()+"'";
		sql=sql+"&&"+ "createTime between '"+key.getCreateTimeMin().toString()+"' AND '"+key.getCreateTimeMax().toString()+"'";
		
	    
		
		return sql;
		
	}
	
	
	
	protected static StockFormPO createPO(String mes[]) {
		StockFormPO re=new StockFormPO();
		re.setID(mes[1]);
		re.setState(StateOfForm.values()[Integer.valueOf(mes[3])]);
		re.setCreateTime(Timestamp.valueOf(mes[4]));
		re.setSaveTime(Timestamp.valueOf(mes[5]));
		re.setSubmitTime(Timestamp.valueOf(mes[6]));
		re.setPassTime(Timestamp.valueOf(mes[7]));
		re.setRejectTime(Timestamp.valueOf(mes[8]));
		re.setOperatorID(mes[9]);
		re.setCustomerID(mes[10]);
		re.setItemsList(mes[11]);
		re.setSumMoney(Integer.valueOf(mes[12]));
		re.setRejectConment(mes[13]);
		
		
		return re;
	}
		
		/**
		 * 测试用方法
		 * @param args
		 */
	public static void main(String args[]) {
//		StockFormPO p=new StockFormPO();
//		p.setID("test1");
//		p.setOperatorID("xiaoLi");
//		p.setCustomerID("laowang");
//		p.setCreateTime( new Timestamp(2011-1900,11,11,11,11,11,0));
//		p.setRejectConment("redo");
//		insertForm(p,"cashForm");
//		
//		KeyForSearchForm key =new	KeyForSearchForm();
//		key.setID("test1");
//		key.setCustomerID("laowang");
//		searchForm(key,"cashForm");
//		
////		StockFormPO p=getForm("fff");
////		insertForm(p);
	}
	
	
}
