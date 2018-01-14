package vo.Form.tradeFormVO;

import java.util.ArrayList;
import vo.CustomerVO;
import vo.Form.FormVO;

/**
 * 销售类单据父类
 * @author hqj
 *	合作方，操作员，仓库，备注，总额
 */

public class TradeFormVO extends FormVO{
	
	
	
	protected double sumMoney = 0;
	protected ArrayList<TradeItemVO> goodsList = new ArrayList<TradeItemVO>();
	protected ArrayList<TradeItemVO> giftList = new ArrayList<TradeItemVO>();
	protected CustomerVO customer = new CustomerVO();
	
	private String warehouse;
	private String comment;
	
	
	
	
	private double moneyZheRang=0;
	private double moneyDaiJinQuan=0;
	private double moneyStrategy=0;
	
	
	
	
	
	
	public double getMoneyZheRang() {
		return moneyZheRang;
	}
	public void setMoneyZheRang(double moneyZheRang) {
		this.moneyZheRang = moneyZheRang;
	}
	public double getMoneyDaiJinQuan() {
		return moneyDaiJinQuan;
	}
	public void setMoneyDaiJinQuan(double moneyDaiJinQuan) {
		this.moneyDaiJinQuan = moneyDaiJinQuan;
	}
	public double getMoneyStrategy() {
		return moneyStrategy;
	}
	public void setMoneyStrategy(double moneyStrategy) {
		this.moneyStrategy = moneyStrategy;
	}
	public double getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(double sumMoney) {
		this.sumMoney = sumMoney;
	}
	public ArrayList<TradeItemVO> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(ArrayList<TradeItemVO> goodsList) {
		this.goodsList = goodsList;
	}
	public ArrayList<TradeItemVO> getGiftList() {
		return giftList;
	}
	public void setGiftList(ArrayList<TradeItemVO> giftList) {
		this.giftList = giftList;
	}
	public CustomerVO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerVO customer) {
		this.customer = customer;
	}
	public String getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
	
	
	
	
}
