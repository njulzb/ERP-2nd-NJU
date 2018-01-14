package po.strategy;

import java.sql.Date;
import java.util.ArrayList;

import po.goods.GoodsPO;



/**
 * 组合商品销售策略
 * @author mxf,LZB
 *
 */
public class GoodsStrategyPO extends StrategyPO {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<GoodsPO> giftList = new ArrayList<GoodsPO>();             //组合商品列表
	double discount;					//组合商品打包销售的总体折扣
	
	public GoodsStrategyPO(Date startTime, int duration, String id, 
			ArrayList<GoodsPO> goodslist,double discount){
		super(id,startTime, duration);
		
		this.giftList = goodslist;
		this.discount = discount;
	}
	
	
	

	
	//get methods 
	public ArrayList<GoodsPO> getGiftList(){return this.giftList;}
	public double getDiscount() {return this.discount;}
	


}
