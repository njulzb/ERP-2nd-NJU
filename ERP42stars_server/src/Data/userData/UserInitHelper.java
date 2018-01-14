package Data.userData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Data.DBConnector;
import po.UserPO;
import utility.ByteHelper;
import utility.RoleOfUser;

public class UserInitHelper {

	public static void main(String[] args) {
		init();
		
	}

	
	public static void init() {

		// TODO Auto-generated method stub
		ArrayList<UserPO> userList = new ArrayList<UserPO>();
		userList.add(new UserPO("161250063","lzb","161250063",RoleOfUser.StoreManager));		
		userList.add(new UserPO("161250061","lyb","161250061",RoleOfUser.FinancialManager));
		userList.add(new UserPO("161250040","hqj","161250040",RoleOfUser.SaleManager));
		userList.add(new UserPO("161250088","mxf","161250088",RoleOfUser.GeneralManager));
		userList.add(new UserPO("admin","admin","admin",RoleOfUser.admin));
		
		
		Connection connection = new DBConnector().connection;
		try {
			Statement statement = connection.createStatement();
			statement.execute("truncate userlist;");
			String cmd = "insert into userlist values(?,?,?,?,?);";
			PreparedStatement prestate = connection.prepareStatement(cmd);
			for (int i=0;i<userList.size();i++) {
				UserPO po = userList.get(i);
				prestate.setString(1, po.getID());
				prestate.setString(2, po.getName());
				prestate.setString(3, po.getPassword());
				prestate.setInt(4, po.getRole().ordinal());
				prestate.setBytes(5, ByteHelper.imageToByte("D:\\test.png"));
				
				prestate.execute();
				
			}
			
			System.out.println("userlist initialize successfully .");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
