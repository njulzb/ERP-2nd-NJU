package BL.strategyBL;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import DataService.strategyDataService.StrategyDataService;
import RMI.ClientRunner;
import po.strategy.StrategyPO;
import vo.strategy.StrategyVO;

/**
 * 真正管理strategy的类
 * @author lzb
 *
 */
public class StrategyList {
	
	StrategyDataService strategyDataManager = 
			ClientRunner.getInstance().getStrategyDataService();
	
	
//	StrategyDataService strategyDataManager  = new StrategyDataServiceStub();
	
	
	
	/**
	 * 创建新的策略，返回策略id，若失败则返回null,
	 * 在这里我们做出假设id能够唯一确定一个策略，
	 * 
	 * @param newer
	 * @return
	 * @throws RemoteException
	 */
	public String createStrategy(StrategyVO newer) throws RemoteException {
		// TODO Auto-generated method stub
		Date today = new Date();
		DateFormat format = new SimpleDateFormat("yyMMddhhmmss");
		String id = format.format(today);
		newer.setID(newer.getID()+id);
		
		/**
		 * 实际上这个id是每一秒一个
		 * 假设不存在同一秒多个策略的情况
		 */
		
		
		StrategyPO cur = newer.toPO();
		
		boolean flag = this.strategyDataManager.createStrategy(cur);
		if (!flag) {
			return null;
		}
		return newer.getID();
	}

	
	public boolean deleteStrategy(String id)  throws RemoteException{
		// TODO Auto-generated method stub
		return this.strategyDataManager.deleteStrategy(id);
	}

	
	public boolean updateStrategy(StrategyVO newSrtategy)  throws RemoteException{
		// TODO Auto-generated method stub
		return this.strategyDataManager.updateStrategy(newSrtategy.toPO());
	}

	
	public StrategyVO searchStrategy(String id)  throws RemoteException{
		// TODO Auto-generated method stub
		StrategyPO po = this.strategyDataManager.searchStrategy(id);
		if (po==null) {
			return null;
		}
		StrategyVO vo = VOHelper.toVO(po);
		return vo;
	}

	
	public ArrayList<StrategyVO> getAllStrategy() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<StrategyVO> voList = new ArrayList<StrategyVO>();
		ArrayList<StrategyPO> poList =  this.strategyDataManager.getAllStrategy();
		
		if (poList==null || poList.size()==0) {
			return null;
		}
		for (StrategyPO each: poList) {
			voList.add(VOHelper.toVO(each));
		}
		return voList;
	}
	
	
}
