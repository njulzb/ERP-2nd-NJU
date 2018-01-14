package vo.strategy;

import java.util.ArrayList;

import BL.stockBL.Goods;

/**
 * 运用策略后得到的优惠结果
 * @author lzb
 *
 */
public class StrategyResult {

	ArrayList<Goods> giftList;//赠送的商品
	double moneyCut;//减去的金额
	String description;//策略降价结果的描述
	
	
	
	public StrategyResult( double cut , ArrayList<Goods> list , String des) {
		this.giftList = list;
		this.moneyCut = cut;
		this.description = des;
	}
	
	public ArrayList<Goods> getGiftList() {return this.giftList;}
	public double getMoneyCut() {return this.moneyCut;}
	public String getDescription() {return this.description;}
}
