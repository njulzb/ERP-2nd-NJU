package BL.receiptBL.stockFormBL;

import java.io.Serializable;

import BL.stockBL.Goods;
import po.formPO.stockFormPO.StockItemPO;
import po.goods.GoodsPO;
import vo.Form.stockFormVO.StockItemVO;
import vo.goods.GoodsVO;

public class StockItem    {
	

	
	private Goods goods;
	private double sumMoney=0;
	private int presentNum=0;
	private int systemNum=0,realNum=0;
	
	private double priceOne;
	private String comment;
	
	
	
	
	
	public StockItem() {
		
	}
	public StockItem(StockItemVO vo) {
		if(vo.getGoods()!=null)this.setGoods(new Goods(vo.getGoods()));
		this.setPresentNum(vo.getPresentNum());
		this.setRealNum(vo.getRealNum());
		this.setSystemNum(vo.getSystemNum());
		this.setPresentNum(vo.getPresentNum());
		this.setSumMoney(vo.getSumMoney());
		this.setPriceOne(vo.getPriceOne());
		this.setComment(vo.getComment());
		
		
	}
	public StockItem(StockItemPO po) {
		if(po.getGoods()!=null)this.setGoods(new Goods(po.getGoods()));
		this.setPresentNum(po.getPresentNum());
		this.setRealNum(po.getRealNum());
		this.setSystemNum(po.getSystemNum());
		this.setPresentNum(po.getPresentNum());
		this.setSumMoney(po.getSumMoney());
		this.setPriceOne(po.getPriceOne());
		this.setComment(po.getComment());
		
		
	}
	
	
	public StockItemVO toVO() {
		StockItemVO   out =new StockItemVO()
		;
	if(this.getGoods()!=null)	out.setGoods(this.getGoods().toVO());
		out.setPresentNum(this.getPresentNum());
		out.setRealNum(this.getRealNum());
		out.setSystemNum(this.getSystemNum());
		out.setPresentNum(this.getPresentNum());
		out.setSumMoney(this.getSumMoney());
		out.setPriceOne(this.getPriceOne());
		out.setComment(this.getComment());
		
		
		return out;
		
	}
	public StockItemPO toPO() {
				StockItemPO   out =new StockItemPO();
				if(this.getGoods()!=null)			out.setGoods(this.getGoods().toPO());
				out.setPresentNum(this.getPresentNum());
				out.setRealNum(this.getRealNum());
				out.setSystemNum(this.getSystemNum());
				out.setPresentNum(this.getPresentNum());
				out.setSumMoney(this.getSumMoney());
				out.setPriceOne(this.getPriceOne());
				out.setComment(this.getComment());
				
				
				return out;
		
	}
	
	
	
	
	
	
	
	
	
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public double getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(double sumMoney) {
		this.sumMoney = sumMoney;
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
