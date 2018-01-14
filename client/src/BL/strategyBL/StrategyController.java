package BL.strategyBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import BL.receiptBL.StrategyInfo;
import BLService.strategyBLService.StrategyBLService;
import vo.Form.tradeFormVO.SaleExportFormVO;
import vo.strategy.StrategyResult;
import vo.strategy.StrategyVO;

/**
 * 策略部分的controller
 * @author lzb
 *
 */
public class StrategyController implements StrategyBLService , StrategyInfo {

	private StrategyList list = new StrategyList();
	
	
	
	
	
	@Override
	public String createStrategy(StrategyVO newer) throws RemoteException {
		// TODO Auto-generated method stub
		
		return this.list.createStrategy(newer);
	}

	@Override
	public boolean deleteStrategy(String id)  throws RemoteException{
		// TODO Auto-generated method stub
		return this.list.deleteStrategy(id);
	}

	@Override
	public boolean updateStrategy(StrategyVO newer) throws RemoteException {
		// TODO Auto-generated method stub
		return this.list.updateStrategy(newer);
	}

	@Override
	public StrategyVO searchStrategy(String id)  throws RemoteException{
		// TODO Auto-generated method stub
		return this.list.searchStrategy(id);
	}

	@Override
	public ArrayList<StrategyVO> getAllStrategy()  throws RemoteException{
		// TODO Auto-generated method stub
		ArrayList<StrategyVO> resultList = this.list.getAllStrategy();
		if (resultList==null || resultList.size()==0) {
			return null;
		}
		return resultList;
	}


	@Override
	/**
	 * 根据传入的单据，搜索所有可用的策略，并返回策略结果，以供界面进行选择
	 */
	public ArrayList<StrategyResult> calculateResult(SaleExportFormVO form) throws RemoteException {
		// TODO Auto-generated method stub
		
		ArrayList<StrategyResult> resultList = new ArrayList<StrategyResult>();
		
		
		ArrayList<StrategyVO> allList = this.getAllStrategy();
		
		if(allList==null||allList.size()==0) {
			return null;//没有可用的策略
		}
		
		
		for (StrategyVO e : allList) {
			/**
			 * 根据日期判断判断是否可用
			 */
			if (e.getStartTime().before(new Date())) {
				StrategyResult eachResult = e.calculateResult(form);
				
				/**
				 * 若为null ，则表示该策略不可用
				 */
				if(eachResult==null) {
					continue;
			
				}
				resultList.add(eachResult);
				
			}
		}
		
		if (resultList.size()==0) {
			return null;//没有可用的策略
		}
		
		return resultList;
	}

}
