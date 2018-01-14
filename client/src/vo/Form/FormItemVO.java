package vo.Form;

import vo.AccountVO;
import vo.goods.GoodsVO;

public class FormItemVO  {
	GoodsVO goods;
	private AccountVO account;
	String name;
	String ID;
	int number;
	double priceOne;
	String comment;
	public GoodsVO getGoods() {
		return goods;
	}
	public void setGoods(GoodsVO goods) {
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
	public AccountVO getAccount() {
		return account;
	}
	public void setAccount(AccountVO account) {
		this.account = account;
	}
	
	
	
	
}
