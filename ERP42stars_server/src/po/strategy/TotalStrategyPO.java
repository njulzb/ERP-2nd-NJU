package po.strategy;

import java.sql.Date;
import java.util.ArrayList;

import po.goods.GoodsPO;


/**
 * 总额特价销售策略 
 * @author mxf
 *
 */
public class TotalStrategyPO extends StrategyPO {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	double trigerPrice;							//触发销售策略的最低总价
	
	int valueOfVoucher;                         //代金券面值
	int amountOfVoucher;                        //代金券数量
	
	ArrayList<GoodsPO> giftList;                   //赠品列表
	
	public TotalStrategyPO(Date startTime, int duration, String id,
			double trigerPrice, int value, int amount, ArrayList<GoodsPO> giftList) {
		super( id,startTime, duration);
		
		this.trigerPrice = trigerPrice;
		this.valueOfVoucher = value;
		this.amountOfVoucher = amount;
		this.giftList = giftList;
	}
	
	
	

	
	
	
	
	
	
	
	//get methods
	public double getTrigerPrice() {return this.trigerPrice;}
	public int getVoucherValue() {return this.valueOfVoucher;}
	public int getVouncherAmount() {return this.amountOfVoucher;}
	public ArrayList<GoodsPO> getGiftList(){return this.giftList;}

}
