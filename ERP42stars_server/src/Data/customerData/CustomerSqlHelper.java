package Data.customerData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Data.receiptData.FormSqlHelper;
import po.AccountPO;
import po.CustomerPO;
import po.KeyForSearchCustomer;
import po.KeyForSearchForm;
import utility.LevelOfCustomer;
import utility.SLog;
import utility.TypeOfCustomer;

public class CustomerSqlHelper extends FormSqlHelper {
	static String TABLE = "customer";

	public static String createID(CustomerPO po) {

		Timestamp a = new Timestamp(System.currentTimeMillis());
		Timestamp min = new Timestamp(a.getYear(), a.getMonth(), a.getDate(), 0, 0, 0, 0);
		Timestamp max = new Timestamp(a.getYear(), a.getMonth(), a.getDate() + 1, 0, 0, 0, 0);

		int num = 0;

		Connection conn = getConn();

		PreparedStatement pstmt;
		try {
			String sql = "select * from " + TABLE + " where 1";
			sql = sql + "&&" + "createTime between '" + min.toString() + "' AND '" + max.toString() + "'";

			pstmt = (PreparedStatement) conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			int col = rs.getMetaData().getColumnCount();

			while (rs.next()) {

				num++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dateNowStr = sdf.format(a);

		num++;
		String str = "";
		if (po.getType() == TypeOfCustomer.importer) {
			str = str + "1-";
		} else {
			str = str + "0-";
		}

		str = str + dateNowStr + "-" + String.format("%03d", num);
		return str;
	}

	public static boolean insert(CustomerPO po) {
		boolean flag = false;
		po.setID(createID(po));

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
			SLog.wr("insertCustomer失败");
			e.printStackTrace();
		}
		if (i == 1) {
			flag = true;
		}
		return flag && update(po);
	}

	public static boolean delete(String ID) {

		// boolean flag=false;
		//
		// Connection conn = getConn();
		// int i = 0;
		//
		// String sql = "delete from "+TABLE+" where id='" + ID + "'";
		// PreparedStatement pstmt;
		// try {
		// pstmt = (PreparedStatement) conn.prepareStatement(sql);
		// i = pstmt.executeUpdate();
		// pstmt.close();
		// conn.close();
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		//
		//
		// if(i==1) {
		// flag=true;
		// }
		// return flag;

		Connection conn = getConn();

		try {
			String sql = "UPDATE " + TABLE + " SET  isUsing=0 WHERE id ='" + ID + "'";

			PreparedStatement pstmt;
			pstmt = (PreparedStatement) conn.prepareStatement(sql);

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			SLog.wr("deleteCustomer失败");
			e.printStackTrace();
			return false;
		}

	}

	public static boolean update(CustomerPO po) {
		Connection conn = getConn();

		try {
			String sql = "UPDATE customer SET ";

			if (po.getName() != null) {
				sql = sql + "name='" + po.getName() + "',";
			}
			if (po.getType() != null) {

				sql = sql + "kind=" + po.getType().ordinal() + ",";

			}
			if (po.getLevel() != null) {
				sql = sql + "vip='" + po.getLevel().ordinal() + "',";
			}
			if (po.getPhoneNumber() != null) {
				sql = sql + "phoneNumber = '" + po.getPhoneNumber() + "',";
			}
			if (po.getAddress() != null) {
				sql = sql + "address='" + po.getAddress() + "',";
			}
			if (po.getPostcode() != null) {
				sql = sql + "postCode='" + po.getPostcode() + "',";
			}
			if (po.getEmail() != null) {
				sql = sql + "email='" + po.getEmail() + "',";
			}
			if (po.getReceiveLimit() != -1) {
				sql = sql + "receiveLimit=" + po.getReceiveLimit() + ",";
			}
			if (po.getReceiveAmount() != -1) {
				sql = sql + "receiveAmount=" + po.getReceiveAmount() + ",";
			}
			if (po.getPayAmount() != -1) {
				sql = sql + "payAmount=" + po.getPayAmount() + ",";
			}
			if (po.getDefaultOperatorID() != null) {
				sql = sql + "defaultOperatorID='" + po.getDefaultOperatorID() + "',";
			}
			sql = sql + "id ='" + po.getID() + "' ";
			sql = sql + "WHERE id ='" + po.getID() + "' ";

			PreparedStatement pstmt;

			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			updateImgByte(po);

			return true;
		} catch (SQLException e) {
			SLog.wr("udateCustomer失败");
			e.printStackTrace();
			return false;
		}
	}

	private static void updateImgByte(CustomerPO po) {
		if (po.getImg() == null) {
			return;
		}
		Connection conn = getConn();

		try {
			String sql = "UPDATE " + TABLE + " SET  imgByte=? WHERE id ='" + po.getID() + "'";

			PreparedStatement pstmt;
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setBytes(1, po.getImg());

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			SLog.wr("updateCustomerImg失败");
			e.printStackTrace();
		}
	}

	public static CustomerPO get(String id) {

		CustomerPO re = new CustomerPO();
		Connection conn = getConn();

		String sql = "select * from " + TABLE + " where id='" + id + "'";

		PreparedStatement pstmt;
		ResultSet rs = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			if (rs == null) {
				return null;
			}

			while (rs.next()) {
				re.setID(rs.getString(1));
				re.setName(rs.getString(2));
				re.setType(TypeOfCustomer.values()[rs.getInt(3)]);
				re.setLevel(LevelOfCustomer.values()[rs.getInt(4)]);
				re.setPhoneNumber(rs.getString(5));
				re.setAddress(rs.getString(6));
				re.setPostcode(rs.getString(7));
				re.setEmail(rs.getString(8));
				re.setReceiveLimit(rs.getDouble(9));
				re.setReceiveAmount(rs.getDouble(10));
				re.setPayAmount(rs.getDouble(11));
				re.setDefaultOperatorID(rs.getString(12));
				re.setImg(rs.getBytes(15));

			}

		} catch (SQLException e) {
			SLog.wr("getCustomerById失败");
			e.printStackTrace();
		}

		return re;

	}

	public static ArrayList<CustomerPO> search(KeyForSearchCustomer key) {
		ArrayList<CustomerPO> out = new ArrayList<CustomerPO>();

		Connection conn = getConn();

		String sql = "select * from " + TABLE + " where 1";
		if (key.getID() != null) {
			sql = sql + "&&" + "id like '%" + key.getID() + "%'";
		}
		if (key.getName() != null) {
			sql = sql + "&&" + "name like '%" + key.getName() + "%'";
		}

		if (key.getLevelMin() != null) {
			sql = sql + "&&" + "vip >= " + key.getLevelMin().ordinal() + "";
		}
		if (key.getLevelMax() != null) {
			sql = sql + "&&" + "vip <= " + key.getLevelMax().ordinal() + "";
		}

		if (key.getType() != null) {
			sql = sql + "&&" + "kind == " + key.getType().ordinal() + "";
		}
		if (key.getDefaultOperatorID() != null) {
			sql = sql + "&&" + "defaultOperatorID == '" + key.getDefaultOperatorID() + "' ";
		}

		if (key.getReceiveLimitMin() != -1) {
			sql = sql + "&&" + "receiveLimit >= " + key.getReceiveLimitMin() + "";
		}
		if (key.getReceiveLimitMax() != -1) {
			sql = sql + "&&" + "receiveLimit <= " + key.getReceiveLimitMin() + "";
		}

		if (key.getReceiveAmountMin() != -1) {
			sql = sql + "&&" + "receiveAmount>= " + key.getReceiveAmountMin() + "";
		}
		if (key.getReceiveAmountMax() != -1) {
			sql = sql + "&&" + "receiveAmount<= " + key.getReceiveAmountMax() + "";
		}

		if (key.getPayAmountMin() != -1) {
			sql = sql + "&&" + "payAmount>= " + key.getPayAmountMin() + "";
		}
		if (key.getPayAmountMax() != -1) {
			sql = sql + "&&" + "payAmount<= " + key.getPayAmountMax() + "";
		}

		PreparedStatement pstmt;
		try {

			pstmt = (PreparedStatement) conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			int col = rs.getMetaData().getColumnCount();
			System.out.println("============================");
			while (rs.next()) {
				if (rs.getInt(13) == 0) {
					continue;
				}

				CustomerPO re = new CustomerPO();
				re.setID(rs.getString(1));
				re.setName(rs.getString(2));
				re.setType(TypeOfCustomer.values()[rs.getInt(3)]);
				re.setLevel(LevelOfCustomer.values()[rs.getInt(4)]);
				re.setPhoneNumber(rs.getString(5));
				re.setAddress(rs.getString(6));
				re.setPostcode(rs.getString(7));
				re.setEmail(rs.getString(8));
				re.setReceiveLimit(rs.getDouble(9));
				re.setReceiveAmount(rs.getDouble(10));
				re.setPayAmount(rs.getDouble(11));
				re.setDefaultOperatorID(rs.getString(12));
				re.setImg(rs.getBytes(15));
				out.add(re);

			}
			System.out.println("============================");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return out;
	}

	/**
	 * 测试用方法
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

		// CustomerPO p=new CustomerPO();
		// p.setID("rqer");
		// p.setDefaultOperatorID("xiaoLi");
		// p.setPayAmount(3133);
		// p.setReceiveLimit(1111);
		// insert(p);

		//
		//// CustomerPO p=getForm("fff");
		//// insertForm(p);
	}

}
