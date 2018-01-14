 package Data.strategyData;

import java.util.ArrayList;

import DataService.strategyDataService.StrategyDataService;
import po.strategy.CustomerStrategyPO;
import po.strategy.GoodsStrategyPO;
import po.strategy.StrategyPO;
import po.strategy.TotalStrategyPO;

public class StrategyDataController implements StrategyDataService{

	
	StrategySqlHelper strategyManager = new StrategySqlHelper();
	
	/**
	 * 构造方法，初始化managers
	 * @throws RemoteException 
	 */
	public StrategyDataController() {
		
		
	}

	@Override
	public boolean createStrategy(StrategyPO newStrategy) {
		// TODO Auto-generated method stub
		
		if (newStrategy instanceof CustomerStrategyPO) {
			CustomerStrategyPO newer = (CustomerStrategyPO)newStrategy;
			return this.strategyManager.createStrategy("customerstrategylist",newer);
		}
		
		if (newStrategy instanceof GoodsStrategyPO) {
			GoodsStrategyPO newer = (GoodsStrategyPO)newStrategy;
			return this.strategyManager.createStrategy("goodsstrategylist",newer);
		}
		
		if (newStrategy instanceof TotalStrategyPO) {
			TotalStrategyPO newer = (TotalStrategyPO)newStrategy;
			
			return this.strategyManager.createStrategy("totalstrategylist",newer);
		}
		
		return false;
	}

	@Override
	public boolean deleteStrategy(String id) {
		// TODO Auto-generated method stub
		
		boolean customerFlag = this.strategyManager.deleteStrategy("customerstrategylist",id);
		boolean goodsFlag = this.strategyManager.deleteStrategy("goodsstrategylist",id);
		boolean totalFlag = this.strategyManager.deleteStrategy("totalstrategylist",id);

		return (customerFlag || goodsFlag || totalFlag);
	}

	@Override
	public boolean updateStrategy(StrategyPO newStrategy) {
		// TODO Auto-generated method stub
		
		if (newStrategy instanceof CustomerStrategyPO) {
			CustomerStrategyPO newer = (CustomerStrategyPO)newStrategy;
			return this.strategyManager.updateStrategy("customerstrategylist",newer);
		}
		
		if (newStrategy instanceof GoodsStrategyPO) {
			GoodsStrategyPO newer = (GoodsStrategyPO)newStrategy;
			return this.strategyManager.updateStrategy("goodsstrategylist",newer);

		}
		
		if (newStrategy instanceof TotalStrategyPO) {
			TotalStrategyPO newer = (TotalStrategyPO)newStrategy;
			return this.strategyManager.updateStrategy("totalstrategylist",newer);

		}

		
		return false;
	}

	@Override
	public StrategyPO searchStrategy(String id) {
		// TODO Auto-generated method stub
		
		StrategyPO result = this.strategyManager.searchStrategy("customerstrategylist",id);
		if (result!=null) {
			return result;
		}
		result = this.strategyManager.searchStrategy("goodsstrategylist",id);
		if (result!=null) {
			return result;
		}
		result = this.strategyManager.searchStrategy("totalstrategylist",id);
		if (result!=null) {
			return result;
		}
//		assume that id can identify a strategy no matter of kinds
	
		
		return null;
	}

	@Override
	public ArrayList<StrategyPO> getAllStrategy() {
		// TODO Auto-generated method stub
		
		ArrayList<StrategyPO> customerList = this.strategyManager.getAllStrategyOf("customerstrategylist");
		ArrayList<StrategyPO> goodsList = this.strategyManager.getAllStrategyOf("goodsstrategylist");
		ArrayList<StrategyPO> totalList = this.strategyManager.getAllStrategyOf("totalstrategylist");
		
//		合并
		ArrayList<StrategyPO> resultList = new ArrayList<StrategyPO>();
		
		
		for (int i=0;customerList!=null && i<customerList.size();i++) {
			resultList.add(customerList.get(i));
		}
		for (int i=0;goodsList!=null && i<goodsList.size();i++) {
			resultList.add(goodsList.get(i));
		}
		for ( int i=0;totalList!=null && i<totalList.size();i++) {
			resultList.add(totalList.get(i));
		}
		
		if (resultList==null || resultList.size()==0) {
			return null;
		}
		
		return resultList;
	}
	

}
