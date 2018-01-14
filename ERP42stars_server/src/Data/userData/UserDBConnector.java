package Data.userData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Data.DBConnector;
import po.UserPO;
import utility.RoleOfUser;

public class UserDBConnector {

	
//	数据库总连接
	DBConnector dbconnector = new DBConnector();

	
//	库存商品部分 连接
	private static UserDBConnector userConnector= new UserDBConnector();
	
//	真正操作的 连接
	Connection connection = this.dbconnector.connection;

	
	/**
	 * getInstance 方法
	 * @return
	 */
	public static UserDBConnector getConnector() {
		
		
		return userConnector;
	}
	
	/**
	 * 构造函数
	 */
	private UserDBConnector() {
		
	}
	
	
	/**
	 * 业务方法
	 * 
	 */
	
	public boolean runSql(String cmd) {
		try {
			Statement statement = this.connection.createStatement();
			statement.executeUpdate(cmd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 查询用户，失败返回null
	 * @param cmd
	 * @return
	 */
	public ArrayList<UserPO> queryUser(String cmd) {
		ArrayList<UserPO> resultList = new ArrayList<UserPO>();
		
		try {
			Statement statement = this.connection.createStatement(ResultSet.CONCUR_READ_ONLY,ResultSet.TYPE_SCROLL_SENSITIVE);
			ResultSet resultset = statement.executeQuery(cmd);
			
			while (resultset.next()) {
				String id = resultset.getString("id");
				String name = resultset.getString("name");
				String password = resultset.getString("password");
				RoleOfUser role = RoleOfUser.values()[resultset.getInt("role")];
				byte[] imageByte = resultset.getBytes("image");
				resultList.add(new UserPO(id,name,password,role,imageByte));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultList;
	}
}
