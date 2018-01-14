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
	
	int valueOfVoucher;                         //代金券面值
	int amountOfVoucher;                        //代金券数量
	double discount;                           //价格折让度（例如：0.8代表八折）
	ArrayList<GoodsPO> giftList;                   //赠品列表
	
	public CustomerStrategyPO(Date startTime, int durationDays,String id,
			LevelOfCustomer beginLevel,LevelOfCustomer endLevel,
			int value,int amount,double discount,ArrayList<GoodsPO> giftList){
		super(id,startTime, durationDays);
		
		this.beginLevel = beginLevel;
		this.endLevel = endLevel;
		
		this.valueOfVoucher = value;
		this.amountOfVoucher = amount;
		
		this.discount = discount;
		
		this.giftList = giftList;
	}
	
	
	
	//get methods
	public LevelOfCustomer getBeginLevel() {return this.beginLevel;}
	public LevelOfCustomer getEndLevel() {return this.endLevel;}
	public int getValue(){return this.valueOfVoucher;}
	public int getAmount(){	return this.amountOfVoucher;}
	public double getDiscount(){return this.discount;}
	public ArrayList<GoodsPO> getGiftList(){return this.giftList;}
	
	
	//set methods
	public boolean setVoucherValue(int value){this.valueOfVoucher = value;return true;}
	public boolean setVoucherAmount(int amount){this.amountOfVoucher = amount;return true;}
	public boolean setDiscount(double discount){this.discount = discount;return true;}
	public boolean setGift(ArrayList<GoodsPO> giftList){this.giftList = giftList;return true;}

}
