package Data.strategyData;

import java.util.ArrayList;


import po.strategy.StrategyPO;

public class StrategySqlHelper {

	private StrategyConnector strategyConnector = null;
	
	/**
	 * 构造方法
	 */
	public StrategySqlHelper() {
		this.strategyConnector = StrategyConnector.getConnector();
	}
	
//-------------------------------------------------------------------------

	/**
	 * 新增一个客户策略
	 * @param newer
	 * @return
	 */
	public boolean createStrategy(String tableName,StrategyPO newer) {

		
		String id = newer.getID();
		

		this.strategyConnector.insertObject(tableName, id, newer);
		
		
		return true;
	}

	
	public boolean deleteStrategy(String tableName,String id) {
		String cmd = "delete from Tablename where id = 'Id';";
		cmd = cmd.replaceAll("Tablename", tableName);
		cmd = cmd.replaceAll("Id", id);
		
		this.strategyConnector.runsql(cmd);
		
		return true;
	}

	
	public boolean updateStrategy(String tableName,StrategyPO newer) {
		String id = newer.getID();
//		delete older object
		String cmd = "delete from Tablename where id = 'Id';";
		cmd = cmd.replaceAll("Tablename",tableName);
		cmd = cmd.replaceAll("Id", id);
		this.strategyConnector.runsql(cmd);
//		add new object
		this.strategyConnector.insertObject(tableName, id, newer);
		
		return true;
	}

	
	public StrategyPO searchStrategy(String tableName,String id) {
		String cmd = "select * from Tablename where id = 'Id';";
		cmd = cmd.replaceAll("Tablename", tableName);
		cmd = cmd.replaceAll("Id", id);
		
		ArrayList<StrategyPO> list = this.strategyConnector.queryStrategy(cmd);
		
		if (list==null|| list.size()==0) {
			return null;
		}
		
		return list.get(0);
	}

	
	public ArrayList<StrategyPO> getAllStrategyOf(String tableName) {
		String cmd = "select * from Tablename;";
		cmd = cmd.replaceAll("Tablename", tableName);
		
		ArrayList<StrategyPO> list = this.strategyConnector.queryStrategy(cmd);
		
		if (list==null|| list.size()==0) {
			return null;
		}
		
		ArrayList<StrategyPO> resultList = new ArrayList<StrategyPO>(list.size());
		
		
		for (int i=0;i<list.size();i++) {
			resultList.add(list.get(i));
		}
		
		return resultList;
	}
	


}
