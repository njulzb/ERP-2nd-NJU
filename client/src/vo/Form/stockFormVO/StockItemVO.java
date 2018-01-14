package vo.Form.stockFormVO;

import po.goods.GoodsPO;
import vo.goods.GoodsVO;

public class StockItemVO  {
	

	
	private GoodsVO goods;
	private int presentNum=0;
	
	
	private double sumMoney=0;
	private int systemNum=0,realNum=0;
	private double priceOne;
	private String comment;
	
	
	public GoodsVO getGoods() {
		return goods;
	}
	public void setGoods(GoodsVO goods) {
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
