package BL.receiptBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.Form.tradeFormVO.SaleExportFormVO;
import vo.strategy.StrategyResult;
/**
 * 
 * @author Eli
 * form调用strategy的接口
 * goodsVo 的number 表示数量
 */
public interface StrategyInfo {
	
	/**
	 * 获得所有可能的策略适用结果
	 * @param form
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<StrategyResult> calculateResult(SaleExportFormVO form) throws RemoteException;
}
