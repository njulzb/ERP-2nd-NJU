package Data.mainAccountData;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import po.CustomerPO;
import po.MainAccountPO;
import utility.FileHelper;
import utility.LevelOfCustomer;
import utility.SLog;
import utility.SqlHelper;
import utility.TypeOfCustomer;

public class MainAccountData {

	private String TABLE = "mainaccount";

	public static void main(String args[]) {
		new MainAccountData().export("aaa") ;
	}

	private byte[] getHistory(String name) {
		return FileHelper.getBytes("F:/SJK/" + name + ".txt");
	}
	public void createNew() {
		Connection conn = SqlHelper.getConn();
		try {
			PreparedStatement pstmt;

			pstmt = (PreparedStatement) conn
					.prepareStatement("insert into " + TABLE + "(startDate,isNowOne) values(?,?)	");

			pstmt.setDate(1, new Date(System.currentTimeMillis()));
			pstmt.setInt(2, 1);
			pstmt.executeUpdate();
			
			
			pstmt = (PreparedStatement) conn
					.prepareStatement("UPDATE " + TABLE + " SET  endDate=?  ,isNowOne =0 WHERE isNowOne =1");

			pstmt.setDate(1, new Date(System.currentTimeMillis()));
			pstmt.executeUpdate();
			
			
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public MainAccountPO getNow() {
		return null;

	}

	private void export(String name) {

		String temp = Math.random() + "";
		String path = "F:/SJK/" + temp + ".txt";
		Connection conn = SqlHelper.getConn();
		try {
			PreparedStatement pstmt;

			pstmt = (PreparedStatement) conn
					.prepareStatement("	select * from customer into outfile \"F:/SJK/" + name + ".txt\"  FIELDS\r\n"
							+ "        TERMINATED BY '\\、'\r\n" + "        OPTIONALLY ENCLOSED BY '\\\"'\r\n"
							+ "    LINES\r\n" + "        STARTING BY '\\>'\r\n" + "        TERMINATED BY '\\r\\n';");
			pstmt.executeQuery();
			System.out.println("ok");
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		;

	}

	public ArrayList<MainAccountPO> getList() {
		ArrayList<MainAccountPO> out = new ArrayList<MainAccountPO>();

		Connection conn = SqlHelper.getConn();

		String sql = "select * from " + TABLE + " where 1";
		PreparedStatement pstmt;
		try {

			pstmt = (PreparedStatement) conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			int col = rs.getMetaData().getColumnCount();
			System.out.println("============================");
			while (rs.next()) {
				
				MainAccountPO re = new MainAccountPO();
			
				out.add(re);

			}
			System.out.println("============================");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return out;
	}
	
	/**
	 * 备份数据库中的商品、客户、账户三项信息到data_startInfo
	 */
	public void copyDataBase() {
		Connection conn = SqlHelper.getConn();
		try {
			PreparedStatement pstmt;
			pstmt = (PreparedStatement) conn.prepareStatement("drop database data_startInfo");
			pstmt.executeUpdate();
			pstmt = (PreparedStatement) conn.prepareStatement("CREATE DATABASE  data_startInfo");
			pstmt.executeUpdate();

			String sql = "CREATE TABLE data_startInfo.customer_start  SELECT * FROM customer;";
			String sql2 = "CREATE TABLE data_startInfo.goodsclasslist_start  SELECT * FROM goodsclasslist;";
			String sql3 = "CREATE TABLE data_startInfo.goodslist_start  SELECT * FROM goodslist;";
			String sql4 = "CREATE TABLE data_startInfo.bankaccount_start  SELECT * FROM bankaccount;";

			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.executeUpdate();
			pstmt = (PreparedStatement) conn.prepareStatement(sql2);
			pstmt.executeUpdate();
			pstmt = (PreparedStatement) conn.prepareStatement(sql3);
			pstmt.executeUpdate();
			pstmt = (PreparedStatement) conn.prepareStatement(sql4);
			pstmt.executeUpdate();
			System.out.println("ok");
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			SLog.wr("删除db失败");
			e.printStackTrace();
		}
	}

}
