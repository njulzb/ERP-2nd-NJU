package po.formPO.tradeFormPO;

import java.io.Serializable;

import po.goods.GoodsPO;

public class TradeItemPO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GoodsPO goods;
	String name;
	String ID;
	int number;
	double priceOne;
	String comment;
	
	
	
	
	
	
	
	
	
	
	public GoodsPO getGoods() {
		return goods;
	}
	public void setGoods(GoodsPO goods) {
		this.goods = goods;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
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
