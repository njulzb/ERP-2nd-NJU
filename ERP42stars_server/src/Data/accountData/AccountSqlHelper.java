package Data.accountData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Data.receiptData.FormSqlHelper;
import po.AccountPO;
import po.KeyForSearchAccount;
import utility.SLog;

public class AccountSqlHelper extends FormSqlHelper {
	static String TABLE = "bankaccount";

	public static boolean insert(AccountPO po) {
		boolean flag = false;
		Connection conn = getConn();
		int i = 0;

		try {

			String sql = "insert into " + TABLE + "(id) values(?)";
			PreparedStatement pstmt;
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, po.getID());
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			SLog.wr("insertAccount失败");
			e.printStackTrace();
		}
		if (i == 1) {
			flag = true;
		}
		return flag && update(po);
	}

	protected static PreparedStatement makePstmt(PreparedStatement pstmt, AccountPO po) throws SQLException {

		pstmt.setString(1, po.getID());
		pstmt.setString(2, po.getName());
		pstmt.setDouble(3, po.getMoneyLeft());
		pstmt.setString(4, po.getPassword());
		pstmt.setBoolean(5, po.isUsing());

		return pstmt;

	}

	public static boolean delete(String ID) {

		boolean flag = false;

//		Connection conn = getConn();
//		int i = 0;
//		String sql = "delete from " + TABLE + " where id='" + ID + "'";
//		PreparedStatement pstmt;
//		try {
//			pstmt = (PreparedStatement) conn.prepareStatement(sql);
//			i = pstmt.executeUpdate();
//			pstmt.close();
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		if (i == 1) {
//			flag = true;
//		}
		
		
		Connection conn = getConn();

		try {
			String sql = "UPDATE " + TABLE + " SET ";
			sql = sql + "isUsing= 0 ";
			sql = sql + " WHERE id ='" + ID + "' ";
			PreparedStatement pstmt;
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			SLog.wr("deleteAccount失败");
			e.printStackTrace();
			return false;
		}
	}

	public static boolean update(AccountPO po) {
		Connection conn = getConn();

		try {
			String sql = "UPDATE " + TABLE + " SET ";

			if (po.getID() != null) {
				sql = sql + "id='" + po.getID() + "',";
			}
			if (po.getName() != null) {
				sql = sql + "name='" + po.getName() + "',";
			}
			if (po.getPassword() != null)
				sql = sql + "password='" + po.getPassword() + "',";
			sql = sql + "moneyLeft=" + po.getMoneyLeft();
			sql = sql + " WHERE id ='" + po.getID() + "' ";
			updateImgByte(po);
			PreparedStatement pstmt;

			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			SLog.wr("updateAccount失败");
			e.printStackTrace();
			return false;
		}
	}

	private static void updateImgByte(AccountPO po) {
		Connection conn = getConn();

		try {
			String sql = "UPDATE " + TABLE + " SET  imgByte=? WHERE id ='" + po.getID() + "'";

			PreparedStatement pstmt;
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			if (po.getImg() != null) {
				pstmt.setBytes(1, po.getImg());
			}
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			SLog.wr(" updateAccountImgByte失败");
			e.printStackTrace();
		}
	}

	public static AccountPO get(String id) {

		AccountPO re = null;
		Connection conn = getConn();

		String sql = "select * from " + TABLE + " where id='" + id + "'";
		String out[] = new String[20];
		PreparedStatement pstmt;
		ResultSet rs = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			if (rs == null) {
				return null;
			}

			while (rs.next()) {
				re = new AccountPO();
				re.setID(rs.getString(1));
				re.setName(rs.getString(2));
				re.setMoneyLeft(rs.getDouble(3));
				re.setPassword(rs.getString(4));
				re.setImg(rs.getBytes(5));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return re;

	}

	public static ArrayList<AccountPO> search(KeyForSearchAccount key) {
		ArrayList<AccountPO> re = new ArrayList<AccountPO>();

		Connection conn = getConn();

		String sql = makeQuery(key);

		PreparedStatement pstmt;
		try {

			pstmt = (PreparedStatement) conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			int col = rs.getMetaData().getColumnCount();
			System.out.println("============================");
			while (rs.next()) {
				
				if(rs.getInt(7)==0) {
					continue;
				}
				AccountPO rt = new AccountPO();
				rt.setID(rs.getString(1));
				rt.setName(rs.getString(2));
				rt.setMoneyLeft(rs.getDouble(3));
				rt.setPassword(rs.getString(4));
				rt.setImg(rs.getBytes(5));
				System.out.println(rt.getMoneyLeft());
				
				re.add(rt);
			}
			System.out.println("============================");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return re;
	}

	protected static String makeQuery(KeyForSearchAccount key) {
		String sql = "select * from " + TABLE + " where 1";
		if (key.getID() != null) {
			sql = sql + "&&" + "id like '%" + key.getID() + "%'";
		}
		if (key.getName() != null) {
			sql = sql + "&&" + "name like '%" + key.getName() + "%'";
		}
		if (key.getMoneyLeftMin() != -2147483648 || key.getMoneyLeftMax() != 2147483647) {
			sql = sql + "&&" + "moneyLeft < " + key.getMoneyLeftMax();
			sql = sql + "&&" + "moneyLeft > " + key.getMoneyLeftMin();
		}
		System.out.println(sql);
		return sql;

	}

	protected static AccountPO createPO(String mes[]) {

		return null;
	}

	
}
