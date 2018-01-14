package Data.userData;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import po.UserPO;
import utility.RoleOfUser; 

public class UserSqlHelper {
	
	private UserDBConnector connector = UserDBConnector.getConnector();
	
	/**
	 * 根据id查询用户，返回用户PO，失败返回null
	 * @param id
	 * @return
	 */
	public UserPO searchByID(String id) {
		String cmd = "select * from userlist where id = 'ID';";
		cmd = cmd.replaceAll("ID", id);
		
		ArrayList<UserPO> resultList = this.connector.queryUser(cmd);
		if (resultList==null || resultList.size()==0) {
			return null;
		}
		UserPO result = resultList.get(0);
		return result;
	}
	
	public ArrayList<UserPO> searchUserByRole(RoleOfUser role) {
		String cmd = "select * from userlist where role = Role;";
		cmd = cmd.replaceAll("Role", Integer.toString(role.ordinal()));
		
		return this.connector.queryUser(cmd);
	}

	
	
	public boolean addUser(UserPO user)  {
		
		String id = user.getID();
		String name = user.getName();
		String password = user.getPassword();
		RoleOfUser role = user.getRole();
		
		String cmd = "insert into userlist values('Id','Name','Password',Role,?);";
		cmd  =  cmd.replaceAll("Id", id);
		cmd = cmd.replaceAll("Name", name);
		cmd = cmd.replaceAll("Password",password);
		cmd = cmd.replaceAll("Role", Integer.toString(role.ordinal()));
		
		try {
			PreparedStatement statement = this.connector.connection.prepareStatement(cmd);
			statement.setBytes(1, user.getImageByte());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
		
		
	}
	
	public boolean deleteUser(String id) {
		
		String cmd = "delete from userlist where id = 'ID';";
		cmd = cmd.replaceAll("ID", id);
		
		return this.connector.runSql(cmd);
	}
	
	public boolean updateUser(UserPO newer) {
		
		String id = newer.getID();
		String password = newer.getPassword();
		String name = newer.getName();
		RoleOfUser role = newer.getRole();
		
		String cmd = "update userlist set name = 'Name' , password = 'Password',role = Role ,image = ? where id = 'Id';";
		cmd = cmd.replaceAll("Role", Integer.toString(role.ordinal()));
		cmd = cmd.replaceAll("Id", id);
		cmd = cmd.replaceAll("Name", name);
		cmd = cmd.replaceAll("Password", password);
		
		PreparedStatement statement;
		try {
			statement = this.connector.connection.prepareStatement(cmd);
			statement.setBytes(1, newer.getImageByte());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
}
