package vo.strategy;


import java.util.ArrayList;
import java.util.Date;

import BL.stockBL.Goods;
import po.goods.GoodsPO;
import po.strategy.TotalStrategyPO;
import vo.Form.tradeFormVO.SaleExportFormVO;
import vo.goods.GoodsVO;

/**
 * 总额特价销售策略 
 * @author mxf,LZB
 *
 */
public class TotalStrategyVO extends StrategyVO {


	double trigerPrice;							//触发销售策略的最低总价
	
	double moneyCut;//满减的金额
	
	
	ArrayList<GoodsVO> giftList= new ArrayList<GoodsVO>();                   //赠品列表
	
	public TotalStrategyVO(Date startTime, int duration, String id,
			double trigerPrice,double moneyCut, ArrayList<GoodsVO> giftList) {
		super(startTime, duration, id);
		
		this.trigerPrice = trigerPrice;
		this.moneyCut = moneyCut;
		this.giftList = giftList;
	}
	
	public TotalStrategyVO(TotalStrategyPO po) {
		super(po.getStartTime(),po.getDurationDays(),po.getID());
		
		this.trigerPrice = po.getTrigerPrice();
		this.moneyCut = po.getMoneyCut();
		
		for (GoodsPO e : po.getGiftList()) {
			Goods domain = new Goods(e);
			this.giftList.add(domain.toVO());
		}

		
	}
	
	
	
	//get methods
	public double getTrigerPrice() {return this.trigerPrice;}
	public ArrayList<GoodsVO> getGiftList(){return this.giftList;}
	public double getMoneyCut() {return this.moneyCut;}
	
	
	
	
	
	@Override
	public TotalStrategyPO toPO() {
		ArrayList<GoodsPO> poList = new ArrayList<GoodsPO>();
		for (GoodsVO  eachvo:this.giftList) {
			Goods domain = new Goods(eachvo);
			poList.add(domain.toPO());
		}
		java.sql.Date sqlDate = new java.sql.Date(this.startTime.getTime());
		TotalStrategyPO po = new TotalStrategyPO(sqlDate,this.durationDays, this.ID,
				this.trigerPrice,this.moneyCut, poList);
		
		return po;
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj == null) {
			return false;
		}
		
		TotalStrategyVO b = (TotalStrategyVO) obj;
		
		if (this.startTime.equals(b.startTime)==false)	return false;
		if (this.durationDays!=b.durationDays)	return false;
		if (this.ID.equals(b.ID)==false)	return false;
		if (this.moneyCut != b.getMoneyCut())	return false;


		if (this.giftList.equals(b.giftList)==false)	return false;

		
	
		
		
		

		
		return true;
	}

	@Override
	public StrategyResult calculateResult(SaleExportFormVO form) {
		// TODO Auto-generated method stub
		double total = form.getSumMoney();
		if (total > this.trigerPrice) {
			ArrayList<Goods> resultList = new ArrayList<Goods>();
			for (GoodsVO e : this.giftList) {
				resultList.add(new Goods(e));
			}
			String description = String.format("满%f元减%f元", this.trigerPrice,this.moneyCut);
			return new StrategyResult(this.moneyCut,resultList,description);
		}
		return null;
	}
	
	
	
}
