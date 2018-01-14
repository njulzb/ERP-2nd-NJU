package BL.receiptBL.tradeFormBL;

import BL.stockBL.Goods;
import po.formPO.tradeFormPO.TradeItemPO;
import vo.Form.tradeFormVO.TradeItemVO;
import vo.goods.GoodsVO;

public class TradeItem {
	Goods goods;
	String name;
	String ID;
	int number;
	double priceOne;
	String comment;
	
	
	public TradeItem(TradeItemVO o) {
		this.setGoods(new Goods(o.getGoods()));
		this.setName(o.getName());
		this.setNumber(o.getNumber());
		this.setID(o.getID());
		this.setPriceOne(o.getPriceOne());
		this.setComment(o.getComment());
	}
	public TradeItem(TradeItemPO o) {
		this.setGoods(new Goods(o.getGoods()));
		this.setName(o.getName());
		this.setNumber(o.getNumber());
		this.setID(o.getID());
		this.setPriceOne(o.getPriceOne());
		this.setComment(o.getComment());
	}
	
	public TradeItemVO toVO( ){
		TradeItemVO vo=new TradeItemVO();
		vo.setGoods(this.getGoods().toVO());
		vo.setName(this.getName());
		vo.setNumber(this.getNumber());
		vo.setID(this.getID());
		vo.setPriceOne(this.getPriceOne());
		vo.setComment(this.getComment());
		return vo;
	}
	public TradeItemPO toPO( ){
		TradeItemPO po=new TradeItemPO();
		po.setGoods(this.getGoods().toPO());
		po.setName(this.getName());
		po.setNumber(this.getNumber());
		po.setID(this.getID());
		po.setPriceOne(this.getPriceOne());
		po.setComment(this.getComment());
		return po;
	}
	
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
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
