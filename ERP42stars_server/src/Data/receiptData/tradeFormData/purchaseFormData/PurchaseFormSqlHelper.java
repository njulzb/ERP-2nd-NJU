package Data.receiptData.tradeFormData.purchaseFormData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Data.receiptData.FormSqlHelper;
import po.KeyForSearchForm;
import po.formPO.FormPO;
import po.formPO.tradeFormPO.PurchaseFormPO;
import utility.SLog;
import utility.StateOfForm;

public class PurchaseFormSqlHelper extends FormSqlHelper {
	 static  String TABLE="purchaseform";	
	
	
	public static  boolean insertForm(PurchaseFormPO po) {
		
		boolean flag=false;
		
		po.setID(createID(po));
		
																																																																															
		 Connection conn = getConn();
		    int i = 0;
		    String sql = "insert into "+TABLE+"(id) values(?)";
		    PreparedStatement pstmt;
		    try {
		        pstmt = (PreparedStatement) conn.prepareStatement(sql);
		        pstmt.setString(1, po.getID());						
		     	
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
		
		
		
		return flag&&updateForm(po);
	}
	public static  boolean deleteForm(String ID) {
		
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
	
	
	
	public static boolean updateForm(PurchaseFormPO po) {
		
	    Connection conn = getConn();
	
	    String sql = "UPDATE "+TABLE+" SET " ;
	    	
		  
	    if(po.getID()!=null) { sql=sql+"id='"+po.getID()+"',";}
	    if(po.getState()!=null) {sql=sql+"state="+po.getState().ordinal()+",";}
	    if(po.getCreateTime()!=null)sql=sql+"createTime='"+po.getCreateTime().toString()+"',";
	    if(po.getSubmitTime()!=null)sql=sql+"submitTime='"+po.getSubmitTime().toString()+"',";
	    if(po.getSaveTime()!=null)sql=sql+"finallySaveTime='"+po.getSaveTime().toString()+"',";
	    if(po.getPassTime()!=null)sql=sql+"passTime='"+po.getPassTime().toString()+"',";
	    if(po.getRejectTime()!=null)sql=sql+"rejectTime='"+po.getRejectTime().toString()+"',";
	    if(po.getOperatorID()!=null)sql=sql+"operatorID='"+po.getOperatorID()+"',";
	    if(po.getCustomerID()!=null)sql=sql+"customerID='"+po.getCustomerID()+"',";
	    if(po.getWarehouse()!=null)sql=sql+"warehouse='"+po.getWarehouse()+"',";
	    if(po.getComment()!=null)sql=sql+"comment='"+po.getComment()+"',";
		
	    if(po.getRejectConment()!=null)sql=sql+"rejectConment='"+po.getRejectConment()+"',";
	   						
	    sql=sql+"sum="+po.getSumMoney();
		sql=sql+  	"WHERE id ='"+po.getID()+"' ";
	    
	    
	    
	    PreparedStatement pstmt;
	    try {
	    	 pstmt = (PreparedStatement) conn.prepareStatement(sql);
		        pstmt.executeUpdate();
		        
		        pstmt.close();
		        conn.close();
		        
		        if(po.getGoodsList()!=null) {
			    	 updateList(po);
			    }
		        
		        return true;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	   
	}
	public static boolean updateList(PurchaseFormPO po) {
		
		  Connection conn = getConn();
			
		    String sql = "UPDATE "+TABLE+" SET  ItemList=?" ;
		    
		    PreparedStatement pstmt;
		    try {
		        pstmt = (PreparedStatement) conn.prepareStatement(sql);
		        pstmt.setBytes(1, po.getGoodsList());					
		     	
		        pstmt.executeUpdate();
		        
		        pstmt.close();
		        conn.close();
			        return true;
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }
	
	}
	
	
	public static PurchaseFormPO getForm(String id) {
		
		
		PurchaseFormPO re=new PurchaseFormPO();
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
			        
			        while (rs.next()) {
			            
			    		re.setID(rs.getString(1));
			    		re.setState(StateOfForm.values()[rs.getInt(3)]);
			    		re.setCreateTime(rs.getTimestamp(4));
			    		re.setSaveTime(rs.getTimestamp(5));
			    		re.setSubmitTime(rs.getTimestamp(6));
			    		re.setPassTime(rs.getTimestamp(7));
			    		re.setRejectTime(rs.getTimestamp(8));
			    		re.setOperatorID(rs.getString(9));
			    		re.setCustomerID(rs.getString(10));	re.setSum(rs.getDouble(12));
			    		re.setGoodsList(rs.getBytes(11));
			    		re.setSumMoney(rs.getDouble(12));
			    		re.setRejectConment(rs.getString(13));
			    		re.setComment(rs.getString(15));
			    		re.setWarehouse(rs.getString(16));
			        }
			
			        
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		 
		  return re;
	
		
	}
	
	public static ArrayList<FormPO> searchForm(KeyForSearchForm key) {
		
		ArrayList<FormPO> out =new ArrayList<FormPO>();
		
		 Connection conn = getConn();
		 
		    String sql = "select * from "+TABLE+" where 1";
		    
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
			
		    
		    
		    
		    PreparedStatement pstmt;
		    try {
		    	
		        pstmt = (PreparedStatement)conn.prepareStatement(sql);
		        
		        ResultSet rs = pstmt.executeQuery();
		        
		        int col = rs.getMetaData().getColumnCount();
		        System.out.println("============================");
		        while (rs.next()) {
		        	
		            PurchaseFormPO re =new PurchaseFormPO();
		        	re.setID(rs.getString(1));
		    		re.setState(StateOfForm.values()[rs.getInt(3)]);
		    		re.setCreateTime(rs.getTimestamp(4));
		    		re.setSaveTime(rs.getTimestamp(5));
		    		re.setSubmitTime(rs.getTimestamp(6));
		    		re.setPassTime(rs.getTimestamp(7));
		    		re.setRejectTime(rs.getTimestamp(8));
		    		re.setOperatorID(rs.getString(9));
		    		re.setCustomerID(rs.getString(10));	re.setSum(rs.getDouble(12));
		    		re.setGoodsList(rs.getBytes(11));
		    		re.setSumMoney(rs.getDouble(12));
		    		re.setRejectConment(rs.getString(13));
		    		re.setComment(rs.getString(15));
		    		re.setWarehouse(rs.getString(16));
		       
		    		out.add(re);
		        }
		            System.out.println("============================");
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    
		  return out;
	}
	
		
	public static String createID(FormPO po) {
		Timestamp a=po.getCreateTime();
		KeyForSearchForm key =new KeyForSearchForm();
		key.setCreateTimeMin(new Timestamp(  a.getYear(),a.getMonth(), a.getDate(),0,0,0,0));
		key.setCreateTimeMax(new Timestamp(  a.getYear(),a.getMonth(), a.getDate()+1,0,0,0,0));
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");  
		String dateNowStr = sdf.format(a);  
		
		
		int num=searchForm(key).size()+1;
		String str = "JHD-"+dateNowStr+"-"+String.format("%05d", num);
		return str;
		
		
		
	}
	
	
//		/**
//		 * 测试用方法
//		 * @param args
//		 */
	
	
	
	public static void main(String args[]) {
	
	
		
		PurchaseFormPO p=new PurchaseFormPO();
		p.setCreateTime(new Timestamp(System.currentTimeMillis()));
	
		p.setState(StateOfForm.draft);
		insertForm(p);
	}
	
	
}
