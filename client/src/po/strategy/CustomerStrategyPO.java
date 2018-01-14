package po.strategy;


import java.sql.Date;
import java.util.ArrayList;

import po.goods.GoodsPO;
import utility.LevelOfCustomer;



/**
 * 客户级别销售策略
 * @author mxf,LZB
 *
 */
public class CustomerStrategyPO extends StrategyPO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	LevelOfCustomer beginLevel,endLevel;		//该促销策略适用的客户级别区间
	
	double discount;                           //价格折让度（例如：0.8代表八折）
	ArrayList<GoodsPO> giftList;                   //赠品列表
	
	public CustomerStrategyPO(Date startTime, int durationDays,String id,
			LevelOfCustomer beginLevel,LevelOfCustomer endLevel,
			double discount,ArrayList<GoodsPO> giftList){
		super(id,startTime, durationDays);
		
		this.beginLevel = beginLevel;
		this.endLevel = endLevel;
		
		
		this.discount = discount;
		
		this.giftList = giftList;
	}
	
	
	
	//get methods
	public LevelOfCustomer getBeginLevel() {return this.beginLevel;}
	public LevelOfCustomer getEndLevel() {return this.endLevel;}
	public double getDiscount(){return this.discount;}
	public ArrayList<GoodsPO> getGiftList(){return this.giftList;}
	
	
	//set methods
	public boolean setDiscount(double discount){this.discount = discount;return true;}
	public boolean setGift(ArrayList<GoodsPO> giftList){this.giftList = giftList;return true;}

}
