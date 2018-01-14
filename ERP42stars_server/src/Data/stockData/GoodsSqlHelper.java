package Data.stockData;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import po.goods.GoodsPO;
import utility.ByteHelper;

public class GoodsSqlHelper {
	
	private StockDBConnector connector = null;

	public GoodsSqlHelper() {
		this.connector = StockDBConnector.getConnector();
	}
	
	/**
	 * insert a new GoodsPO into database,
	 * 返回新增商品id
	 * 新增失败则返回-1；
	 * @param adder
	 * @return
	 */
	public int insert(GoodsPO adder) {
		
		
		String name = adder.getName();
		byte[] objectByte = ByteHelper.ObjectToByte(adder);
		
		String cmd = "insert into goodslist values(0,'Name',?);";
		cmd = cmd.replaceAll("Name", name);
		try {
			PreparedStatement statement = this.connector.connection.prepareStatement(cmd);
			statement.setBytes(1, objectByte);
			statement.executeUpdate();
			
			int id = this.connector.getLastInsertid();
			
			
			return id;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
		
	}



	/**
	 * search for a GoodsPO by id 
	 * @param id
	 * @return GoodsPO ,<b>null if not found
	 */
	public GoodsPO searchGoodsByIDAccurate(int id) {
		
		if (id<=0) {
			return null;
		}

		String cmd = "select * from goodslist where id = ID;";
		cmd = cmd.replaceAll("ID", Integer.toString(id));
		

		ArrayList<GoodsPO> resultList = this.connector.queryGoods(cmd);
		

		if (resultList ==null || resultList.size()==0) {
			System.out.println("goods not found while search by id..");
			return null;
		}
		
		return resultList.get(0);
	}

	/**
	 * search GoodsPO by name
	 * @param name
	 * @return GoodsPO list, <b> null if not found
	 */
	public ArrayList<GoodsPO> searchGoodsByNameAccurate (String name) {

		if (name==null || name.equals("")) {
			System.out.println("illegal goods name while search by name!");
			return null;
		}
		
		
//		2.assemble the SQL command
		String cmd = "select * from goodslist where name = 'NAME';";
		cmd = cmd.replaceAll("NAME", name);
		
//		3.extract from database
		ArrayList<GoodsPO> resultList = this.connector.queryGoods(cmd);
		
//		3.1 test if found
		if (resultList==null || resultList.size()==0) {
			System.out.println("goods not found while search by name");
			return null;
		}
		return resultList;
	}

	
	/**
	 * update goods , modify all fields except the id
	 * @param newer
	 * @return
	 */
	public boolean update(GoodsPO newer) {
		
		int id = newer.getID();
		String name = newer.getName();
		byte[] objectBytes = ByteHelper.ObjectToByte(newer);
		
		String cmd = "update goodslist set name = 'Name' , object = ? where id = Id ;";
		cmd = cmd.replaceAll("Id", Integer.toString(id));
		cmd = cmd.replaceAll("Name",name);
		
		try {
			PreparedStatement statement = this.connector.connection.prepareStatement(cmd);
			statement.setBytes(1, objectBytes);
			statement.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}

	
	
	
	
	
	public boolean delete(int id) {
		
		String cmd = "delete from goodslist where id = ID;";
		cmd = cmd.replaceAll("ID", Integer.toString(id));
		
		this.connector.runSql(cmd);
		
		return true;
		
	}
	
	public ArrayList<GoodsPO> getAll(){
		String cmd = "select * from goodslist ;";
		ArrayList<GoodsPO> resultList = this.connector.queryGoods(cmd);
		
		if (resultList == null || resultList.size()==0) {
			return null;
		}
		
		return resultList;
	}
	
	
	
}
