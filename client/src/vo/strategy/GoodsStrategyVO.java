package vo.strategy;


import java.util.ArrayList;
import java.util.Date;

import BL.stockBL.Goods;
import po.goods.GoodsPO;
import po.strategy.GoodsStrategyPO;
import vo.Form.tradeFormVO.SaleExportFormVO;
import vo.Form.tradeFormVO.TradeItemVO;
import vo.goods.GoodsVO;

/**
 * 组合商品销售策略
 * @author mxf,LZB
 *
 */
public class GoodsStrategyVO extends StrategyVO {
	
	
	ArrayList<GoodsVO> giftList = new ArrayList<GoodsVO>();   //组合商品列表
	double discount;					//组合商品打包销售的总体折扣
	
	public GoodsStrategyVO(Date startTime, int duration, String id, 
			ArrayList<GoodsVO> goodslist,double discount){
		super(startTime, duration, id);
		
		this.giftList = goodslist;
		this.discount = discount;
	}
	

	public GoodsStrategyVO(GoodsStrategyPO po) {

		super(po.getStartTime(),po.getDurationDays(),po.getID());
		
		
		this.discount = po.getDiscount();

		 ArrayList<GoodsVO> voList = new ArrayList<GoodsVO>();
		 for (GoodsPO e:po.getGiftList()) {
			 Goods domain = new Goods(e);
			 voList.add(domain.toVO());
		 }
		
		 this.giftList = voList;
	}
	
	

	@Override
	public GoodsStrategyPO toPO() {
		 ArrayList<GoodsPO> poList = new ArrayList<GoodsPO>();
		 for (GoodsVO eachVO:this.giftList) {
			 Goods domain = new Goods(eachVO);
			 poList.add(domain.toPO());
		 }
		 java.sql.Date sqlDate = new java.sql.Date(this.startTime.getTime());
		GoodsStrategyPO po = new GoodsStrategyPO(sqlDate, this.durationDays, 
				this.ID, poList,this.discount);
		
		return po;
	}
	
	
	
	
	
	
	
	
	//get methods 
	public ArrayList<GoodsVO> getGiftList(){return this.giftList;}
	public double getDiscount() {return this.discount;}






	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj == null) {
			return false;
		}
		
		GoodsStrategyVO b = (GoodsStrategyVO) obj;
		
		if (this.startTime.equals(b.startTime)==false)	return false;
		if (this.durationDays!=b.durationDays)	return false;
		if (this.ID.equals(b.ID)==false)	return false;
		if (this.discount!=b.discount)	return false;
		if (this.giftList.equals(b.giftList)==false)	return false;
		
		
	
		
		
		

		
		return true;
	}




	@Override
	public StrategyResult calculateResult(SaleExportFormVO form) {
		// TODO Auto-generated method stub
		ArrayList<TradeItemVO> itemList = form.getGiftList();
		ArrayList<String> goodsidList = new ArrayList<String>(itemList.size());
		for (TradeItemVO e : itemList) {
			goodsidList.add(e.getGoods().getID());
		}
		
		
		for (GoodsVO e : this.giftList) {
			if (!goodsidList.contains(e.getID())) {
				return null;
			}
		}
		
		ArrayList<Goods> resultList = new ArrayList<Goods>();
		for (GoodsVO e: this.giftList) {
			resultList.add(new Goods(e));
		}
		
		double cut = this.discount * form.getSumMoney();
		
		/**
		 * 策略降价结果的描述
		 */
		String description = String.format("组合商品降价，同时购买打%f折,本单可减%f元", 
				this.discount,cut);
		
		return new StrategyResult(cut,resultList,description);
	}

}
