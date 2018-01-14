package Data.receiptData.financeFormData.payFormData;

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
import po.formPO.financeFormPO.PayFormPO;
import utility.SLog;
import utility.StateOfForm;

public class PayFormSqlHelper extends FormSqlHelper {
	 static  String TABLE="payform";	
	
	
	public static  boolean insertForm(PayFormPO po,String table) {
		TABLE=table;
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
		
		
		
		return flag&&updateForm(po,"payform");
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
	
	
	
	public static boolean updateForm(PayFormPO po,String table) {
		TABLE=table;
	    Connection conn = getConn();
	
	    String sql = "UPDATE payform SET " ;
	    	
		  
	    if(po.getID()!=null) { sql=sql+"id='"+po.getID()+"',";}
	    if(po.getState()!=null) {sql=sql+"state="+po.getState().ordinal()+",";}
	    if(po.getCreateTime()!=null)sql=sql+"createTime='"+po.getCreateTime().toString()+"',";
	    if(po.getSubmitTime()!=null)sql=sql+"submitTime='"+po.getSubmitTime().toString()+"',";
	    if(po.getSaveTime()!=null)sql=sql+"finallySaveTime='"+po.getSaveTime().toString()+"',";
	    if(po.getPassTime()!=null)sql=sql+"passTime='"+po.getPassTime().toString()+"',";
	    if(po.getRejectTime()!=null)sql=sql+"rejectTime='"+po.getRejectTime().toString()+"',";
	    if(po.getOperatorID()!=null)sql=sql+"operatorID='"+po.getOperatorID()+"',";
	    if(po.getCustomerID()!=null)sql=sql+"customerID='"+po.getCustomerID()+"',";
	    if(po.getTransList()!=null)sql=sql+"transItemList='"+po.getTransList()+"',";
	    if(po.getRejectConment()!=null)sql=sql+"rejectConment='"+po.getRejectConment()+"',";
	   						
	    sql=sql+"sum="+po.getSumMoney();
		sql=sql+  	"WHERE id ='"+po.getID()+"' ";
	    
	    
	    
	    PreparedStatement pstmt;
	    try {
	    	 pstmt = (PreparedStatement) conn.prepareStatement(sql);
		        pstmt.executeUpdate();
		        
		        pstmt.close();
		        conn.close();
		        return true;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	   
	}
	public static PayFormPO getForm(String id,String table) {
		TABLE=table;
		
		PayFormPO re=null;
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
		 System.out.print("imhere");
		TABLE=table;
		ArrayList<FormPO> re =new ArrayList<FormPO>();
		
		 Connection conn = getConn();
		 
		    String sql = "select * from "+TABLE+" where 1";
		    
//		    if(key.getID()!=null) {
//		    	sql=sql+"&&"+ "id like '%"+key.getID()+"%'";
//		    }
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
	private static PayFormPO createPO(String mes[]) {
		PayFormPO re=new PayFormPO();
		re.setID(mes[1]);
		re.setState(StateOfForm.values()[Integer.valueOf(mes[3])]);
		re.setCreateTime(Timestamp.valueOf(mes[4]));
		re.setSaveTime(Timestamp.valueOf(mes[5]));
		re.setSubmitTime(Timestamp.valueOf(mes[6]));
		re.setPassTime(Timestamp.valueOf(mes[7]));
		re.setRejectTime(Timestamp.valueOf(mes[8]));
		re.setOperatorID(mes[9]);
		re.setCustomerID(mes[10]);
		re.setTransList(mes[11]);
		re.setSumMoney(Integer.valueOf(mes[12]));
		re.setRejectConment(mes[13]);
		
		
		return re;
	}
		
	public static String createID(FormPO po) {
		Timestamp a=po.getCreateTime();
		KeyForSearchForm key =new KeyForSearchForm();
		key.setCreateTimeMin(new Timestamp(  a.getYear(),a.getMonth(), a.getDate(),0,0,0,0));
		key.setCreateTimeMax(new Timestamp(  a.getYear(),a.getMonth(), a.getDate()+1,0,0,0,0));
	
      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");  
      String dateNowStr = sdf.format(a);  
		
		
		int num=searchForm(key,"payform").size()+1;
		String str = "FKD-"+dateNowStr+"-"+String.format("%05d", num);
		return str;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
//		/**
//		 * 测试用方法
//		 * @param args
//		 */
	
	
	
	public static void main(String args[]) {
	
	
		
		PayFormPO p=new PayFormPO();

		p.setID("XJFYD-20171219-00001");
		p.setState(StateOfForm.draft);
		insertForm(p,"payform");
	}
	
	
}
