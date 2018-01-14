package vo.strategy;



import java.util.ArrayList;
import java.util.Date;

import BL.stockBL.Goods;
import po.goods.GoodsPO;
import po.strategy.CustomerStrategyPO;
import utility.LevelOfCustomer;
import vo.Form.tradeFormVO.SaleExportFormVO;
import vo.goods.GoodsVO;

/**
 * 客户级别销售策略
 * @author mxf,LZB
 *
 */
public class CustomerStrategyVO extends StrategyVO {
	
	LevelOfCustomer beginLevel,endLevel;		//该促销策略适用的客户级别区间
	
	
	
	double discount;                           //价格折让度（例如：0.8代表八折）
	ArrayList<GoodsVO> giftList = new ArrayList<GoodsVO>();   //赠品列表
	
	public CustomerStrategyVO(Date startTime, int durationDays,String id,
			LevelOfCustomer beginLevel,LevelOfCustomer endLevel,
			double discount,ArrayList<GoodsVO> giftList){
		super(startTime, durationDays, id);
		
		this.beginLevel = beginLevel;
		this.endLevel = endLevel;
		
		
		this.discount = discount;
		
		this.giftList = giftList;
	}
	
	public CustomerStrategyVO(CustomerStrategyPO po) {
		super(po.getStartTime(),po.getDurationDays(),po.getID());
		
		this.beginLevel = po.getBeginLevel();
		this.endLevel = po.getEndLevel();
		
		
		this.discount = po.getDiscount();
		
		for (GoodsPO e: po.getGiftList()) {
			Goods domain = new Goods(e);
			this.giftList.add(domain.toVO());
		}

	}
	
	
	
	@Override
	public CustomerStrategyPO toPO() {
		ArrayList<GoodsPO> poList = new ArrayList<GoodsPO>();
		for (GoodsVO each:this.giftList) {
			Goods domain = new Goods(each);
			poList.add(domain.toPO());
		}
		java.sql.Date sqlDate = new java.sql.Date(this.startTime.getTime());
		CustomerStrategyPO po = new CustomerStrategyPO(sqlDate,this.durationDays,
				this.ID,this.beginLevel,this.endLevel,
				this.discount,poList);
		
		return po;
	}
	
	
	
	
	
	
	
	//get methods
	public LevelOfCustomer getBeginLevel() {return this.beginLevel;}
	public LevelOfCustomer getEndLevel() {return this.endLevel;}
	public double getDiscount(){return this.discount;}
	public ArrayList<GoodsVO> getGift(){return this.giftList;}
	
	
	//set methods
	public boolean setDiscount(double discount){this.discount = discount;return true;}
	public boolean setGift(ArrayList<GoodsVO> giftList){this.giftList = giftList;return true;}





	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj == null) {
			return false;
		}
		
		CustomerStrategyVO b = (CustomerStrategyVO) obj;
		
		if (this.startTime.equals(b.startTime)==false)	return false;
		if (this.durationDays!=b.durationDays)	return false;
		if (this.ID.equals(b.ID)==false)	return false;
		if (this.beginLevel!=b.beginLevel)	return false;
		if (this.endLevel!=b.endLevel)	return false;
		if (this.discount!=b.discount)	return false;
		if (this.giftList.equals(b.giftList)==false)	return false;
		
		
	
		
		
		

		
		return true;
	}

	

	@Override
	public StrategyResult calculateResult(SaleExportFormVO form) {
		LevelOfCustomer level = form.getCustomer().getLevel();
		int currLevel = level.ordinal();
		int beginLevel = this.beginLevel.ordinal();
		int endLevel = this.endLevel.ordinal();
		
		if (!(beginLevel <= currLevel && currLevel <= endLevel )) {
			return null;
		}
		
		double cut = this.discount * form.getSumMoney();
		
		ArrayList<Goods> resultList = new ArrayList<Goods>();
		
		for (GoodsVO e : this.giftList) {
			resultList.add(new Goods(e));
		}
		
		/**
		 * 策略降价结果的描述
		 */
		
		String description  = String.format("vip客户尊享策略，凡消费立打%f折,本单可减%f元", this.discount,cut);
		
		return new StrategyResult(cut , resultList,description);
		
	}

}
