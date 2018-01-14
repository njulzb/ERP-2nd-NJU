package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Data.strategyData.StrategyDataController;
import DataService.strategyDataService.StrategyDataService;
import po.strategy.StrategyPO;
/**
 * 职责转包给controller，
 * @author lzb
 *
 */

public class StrategyDataServiceImpl extends UnicastRemoteObject implements StrategyDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	StrategyDataController controller = new StrategyDataController();
	
	
	public StrategyDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean createStrategy(StrategyPO newStrategy) {
		// TODO Auto-generated method stub
		System.out.println(newStrategy.getID()+newStrategy.getDurationDays());
		return this.controller.createStrategy(newStrategy);
	}

	@Override
	public boolean deleteStrategy(String id) {
		// TODO Auto-generated method stub
		return this.controller.deleteStrategy(id);
	}

	@Override
	public boolean updateStrategy(StrategyPO newStrategy) {
		// TODO Auto-generated method stub
		return this.controller.updateStrategy(newStrategy);
	}

	@Override
	public StrategyPO searchStrategy(String id) {
		// TODO Auto-generated method stub
		return this.controller.searchStrategy(id);
	}

	@Override
	public ArrayList<StrategyPO> getAllStrategy() {
		// TODO Auto-generated method stub
		return this.controller.getAllStrategy();
	}

}
