package DataService.strategyDataService.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import DataService.strategyDataService.StrategyDataService;
import po.strategy.CustomerStrategyPO;
import po.strategy.GoodsStrategyPO;
import po.strategy.StrategyPO;
import po.strategy.TotalStrategyPO;

public class StrategyDataServiceStub implements StrategyDataService {

	ArrayList<CustomerStrategyPO> customerList = new ArrayList<CustomerStrategyPO>();
	ArrayList<GoodsStrategyPO> goodsList = new ArrayList<GoodsStrategyPO>();
	ArrayList<TotalStrategyPO> totalList = new ArrayList<TotalStrategyPO>();
	
	
	
	@Override
	public boolean createStrategy(StrategyPO newer) throws RemoteException {
		// TODO Auto-generated method stub
		if (newer instanceof CustomerStrategyPO) {
			this.customerList.add((CustomerStrategyPO)newer);
			return true;
		}
		if (newer instanceof GoodsStrategyPO) {
			this.goodsList.add((GoodsStrategyPO)newer);
			return true;
		}
		if (newer instanceof TotalStrategyPO) {
			this.totalList.add((TotalStrategyPO)newer);
			return true;
		}

		return false;
	}

	@Override
	public boolean deleteStrategy(String id) throws RemoteException {
		// TODO Auto-generated method stub
		for (CustomerStrategyPO e : this.customerList) {
			if (e.getID().equals(id)) {
				this.customerList.remove(e);
				return true;
			}
		}
		
		for (GoodsStrategyPO e : this.goodsList) {
			if (e.getID().equals(id)) {
				this.goodsList.remove(e);
				return true;
			}
		}
		
		for (TotalStrategyPO e : this.totalList) {
			if (e.getID().equals(id)) {
				this.totalList.remove(e);
				return true;
			}
		}
		
		return false;
	}

	
	
	
	
	@Override
	public boolean updateStrategy(StrategyPO newer) throws RemoteException {
		// TODO Auto-generated method stub
		if (newer instanceof CustomerStrategyPO) {
			
			for(CustomerStrategyPO each : this.customerList) {
				if (each.getID().equals(newer.getID())) {
					int index = this.customerList.indexOf(each);
					this.customerList.remove(index);
					this.customerList.add(index,(CustomerStrategyPO)newer);
					return true;
				}
			}
			
			return true;
		}
		if (newer instanceof GoodsStrategyPO) {
			
			for (GoodsStrategyPO e : this.goodsList) {
				if (e.getID().equals(newer.getID())) {
					int index = this.goodsList.indexOf(e);
					this.goodsList.remove(index);
					this.goodsList.add(index,(GoodsStrategyPO)newer);
					return true;
				}
			}
			
			
			
			return false;
		}
		if (newer instanceof TotalStrategyPO) {
			
			for (TotalStrategyPO e : this.totalList) {
				if (e.getID().equals(newer.getID())) {
					int index = this.totalList.indexOf(e);
					this.totalList.remove(index);
					this.totalList.add(index,(TotalStrategyPO)newer);
					return true;
				}
			}
			
			
			return false;
		}

		
		
		return false;
	}

	@Override
	public StrategyPO searchStrategy(String id) throws RemoteException {
		// TODO Auto-generated method stub
		for (CustomerStrategyPO e : this.customerList) {
			if (e.getID().equals(id)) {
				return e;
			}
		}
		
		for (GoodsStrategyPO e : this.goodsList) {
			if (e.getID().equals(id)) {
				return e;
			}
		}
		
		for (TotalStrategyPO e : this.totalList) {
			if (e.getID().equals(id)) {
				return e;
			}
		}
		
		
		return null;
	}

	@Override
	public ArrayList<StrategyPO> getAllStrategy() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<StrategyPO> resultList = new ArrayList<StrategyPO>();
		
		for (CustomerStrategyPO e : this.customerList) {
			resultList.add(e);
		}
		
		for (GoodsStrategyPO e : this.goodsList) {
			resultList.add(e);
		}
		
		for (TotalStrategyPO e : this.totalList) {
			resultList.add(e);
		}

		if (resultList==null || resultList.size()==0) {
			return null;
		}
		
		return resultList;
	}

}
