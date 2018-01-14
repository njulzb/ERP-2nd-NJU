package BL.strategyBL;

import po.strategy.CustomerStrategyPO;
import po.strategy.GoodsStrategyPO;
import po.strategy.StrategyPO;
import po.strategy.TotalStrategyPO;
import vo.strategy.CustomerStrategyVO;
import vo.strategy.GoodsStrategyVO;
import vo.strategy.StrategyVO;
import vo.strategy.TotalStrategyVO;

/**
 * 这个类存在的原因是，逻辑过于简单所以舍去了domain object 
 * 将原本逻辑对象的职责封装在vo中，故而需要一个中间者来转换vo po,po因为存在server中，不可以依赖vo
 * 两边对象不一样的话rmi传过去的是一个新的对象，故而用了这个方法来解决这个问题。
 * @author lzb
 *
 */
public class VOHelper {

	public static StrategyVO toVO(StrategyPO po) {
		if (po instanceof CustomerStrategyPO) {
			return new CustomerStrategyVO((CustomerStrategyPO)po);
		}
		
		if (po instanceof TotalStrategyPO) {
			return new TotalStrategyVO((TotalStrategyPO)po);
		}
		
		if (po instanceof  GoodsStrategyPO) {
			return new  GoodsStrategyVO(( GoodsStrategyPO)po);
		}
		
		return null;
	}
	
}
