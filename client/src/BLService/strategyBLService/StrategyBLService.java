package BLService.strategyBLService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.strategy.StrategyVO;

public interface StrategyBLService {

	/**
	 * 创建新策略，返回id
	 * @param newStrategy
	 * @return
	 */
	public String createStrategy(StrategyVO newStrategy) throws RemoteException;
	
	public boolean deleteStrategy(String id) throws RemoteException;
	
	public boolean updateStrategy(StrategyVO newer) throws RemoteException;
	
	public StrategyVO searchStrategy(String id) throws RemoteException;
	
	public ArrayList<StrategyVO> getAllStrategy() throws RemoteException;
	
	
	
}
