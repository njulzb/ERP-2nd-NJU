package Data.stockData;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import po.goods.GoodsClassPO;
import utility.ByteHelper;

/**
 * this class is used to translate java methods into mysql command
 *  
 * it is a tool class
 * @author LZB
 *
 */
public class GoodsClassSqlHelper {

	private StockDBConnector connector = null;//this should be private after test
	
	public GoodsClassSqlHelper() {
		connector = StockDBConnector.getConnector();
	}
	
	
	
	
	
	
	/**
	 * insert a new goods class
	 * 返回-1，表示插入失败
	 * 需要注意的是：
	 * 加入进数据库的时候，对象本体的id是无效的，所以取出的时候会有问题，
	 * 现行的解决方案是，在取出对象的时候重新设置id
	 * 设想的可行的解决方案为，在加入时候先加入，后更新，这样对象的id就是正确的了
	 * @param adder
	 * @return
	 */
	public int insert(GoodsClassPO adder) {
		
		int id = -1;
		
		String cmd = "insert into goodsclasslist values(0,?,?);";
		
		try {
			PreparedStatement statement = this.connector.connection.prepareStatement(cmd);
			
			statement.setString(1, adder.getName());
			
			byte[] array = ByteHelper.ObjectToByte(adder);
			statement.setBytes(2, array);
			
			statement.executeUpdate();
			
			id = this.connector.getLastInsertid();
			
			adder.setID(id);
			
			boolean flag = this.update(adder);
			if (!flag) {
				return -1;
//				这样的返回在极端情况下是会有问题的
			}
			
			
			
			
			
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return -1;
	}

	
	/**
	 * 
	 * @param newer
	 * @return
	 */
	public boolean update(GoodsClassPO newer) {
		int id = newer.getID();
		GoodsClassPO curr = this.searchByID(id);
		if (curr==null) {
			return false;
		}
		
		String sql = "update goodsclasslist set name = ? , object = ? where id = ?;";
		
		try {
			PreparedStatement statement = this.connector.connection.prepareStatement(sql);
			statement.setString(1, newer.getName());
			
			statement.setInt(3, id);
			
			byte[] array = ByteHelper.ObjectToByte(newer);
			statement.setBytes(2,array);
			
			statement.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	
	
	/**
	 * delete the dead class 
	 * @param dead
	 */
	public boolean delete(int id) {
		
		GoodsClassPO dead = this.searchByID(id);
		if (dead==null) {
			return false;
		}
		
		String cmd = "delete from goodsclasslist where id = Id;";
		cmd = cmd.replaceAll("Id", Integer.toString(id));
		return this.connector.runSql(cmd);
		
	}


	

	
	
	
	/**
	 * search Goodsclass by its id (there id no more than one ,so return GoodsClassPO
	 * @param id
	 * @return GoodsClassPO,null if not found
	 */
	public GoodsClassPO searchByID(int id) {
		
		String cmd = "select * from goodsclasslist where id = ID;";
		cmd = cmd.replaceAll("ID", Integer.toString(id));
		

		ArrayList<GoodsClassPO> resultList = this.connector.queryGoodsClass(cmd);
		
		if (resultList ==null ||resultList.size()==0) {
			System.out.println("goodsclass not found while getClassByid...");
			return null;
		}
		
		GoodsClassPO result = resultList.get(0);
		result.setID(id);
		return result;
		
		
	}

	/**
	 * as the  method name shows
	 * @param name
	 * @return
	 */
	public ArrayList<GoodsClassPO> searchByName(String name) {
//		1.assemble the sql command
		String cmd = "select * from goodsclasslist where name= 'NAME';";
		cmd = cmd.replaceAll("NAME", name);
		
//		2. run the sql command
		ArrayList<GoodsClassPO> resultList = this.connector.queryGoodsClass(cmd);
		if (resultList==null || resultList.size()==0) {
			System.out.println("search by name failed ,"
					+ "there is no that goodsclass name");
			return null;
		}
		
		return resultList;
	}
	
	
	
	
	
	
	
	
	
	
	
}
