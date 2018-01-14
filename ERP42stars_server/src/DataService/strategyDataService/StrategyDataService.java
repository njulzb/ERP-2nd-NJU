package DataService.strategyDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.strategy.StrategyPO;


/**
 * 
 * @author mxf,LZB
 *
 */

public interface StrategyDataService extends Remote{
	
	/**
	 * 新增一个策略
	 * @param newStrategy
	 * @return
	 */
	public boolean createStrategy(StrategyPO newStrategy)throws RemoteException;
	
	/**
	 * 根据id 删除某个策略
	 * @param id
	 * @return
	 */
	public boolean deleteStrategy(String id)throws RemoteException;
	
	/**
	 * 更新某个策略，假设id不可更改
	 * @param newSrtategy
	 * @return
	 */
	public boolean updateStrategy(StrategyPO newSrtategy)throws RemoteException;
	
	/**
	 * 根据id 搜索策略
	 * @param id
	 * @return
	 */
	public StrategyPO searchStrategy(String id)throws RemoteException;

	/**
	 * 得到某时刻所有策略，以供显示
	 * @return
	 */
	public ArrayList<StrategyPO> getAllStrategy()throws RemoteException;
}