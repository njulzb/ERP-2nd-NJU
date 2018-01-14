package po.formPO.stockFormPO;

import java.io.Serializable;

import po.goods.GoodsPO;
import vo.goods.GoodsVO;

public class StockItemPO implements Serializable {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3544697943679774064L;
	private GoodsPO goods;
	private double sumMoney=0;
	private int presentNum=0;
	private int systemNum=0,realNum=0;
	
	private double priceOne;
	private String comment;
	
	public GoodsPO getGoods() {
		return goods;
	}
	public void setGoods(GoodsPO goods) {
		this.goods = goods;
	}
	public int getPresentNum() {
		return presentNum;
	}
	public void setPresentNum(int presentNum) {
		this.presentNum = presentNum;
	}
	public int getSystemNum() {
		return systemNum;
	}
	public void setSystemNum(int systemNum) {
		this.systemNum = systemNum;
	}
	public int getRealNum() {
		return realNum;
	}
	public void setRealNum(int realNum) {
		this.realNum = realNum;
	}
	public double getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(double sumMoney) {
		this.sumMoney = sumMoney;
	}
	public double getPriceOne() {
		return priceOne;
	}
	public void setPriceOne(double priceOne) {
		this.priceOne = priceOne;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	

	
	
}
