package po.formPO.tradeFormPO;

import java.io.Serializable;
import po.formPO.FormPO;

/**
 * 财务类单据的父类
 * @author lyb
 *
 */
public class TradeFormPO extends FormPO  implements Serializable {

		
	/**
	 * 
	 */
	private static final long serialVersionUID = 7981331144130068407L;
	protected double sumMoney = 0;
	protected byte[] goodsList ;
	protected byte[] giftList ;
	private String customerID ;
	
	private String warehouse;
	private String comment;
	private double sum=0;
	
	
	
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
	public byte[] getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(byte[] goodsList) {
		this.goodsList = goodsList;
	}
	public byte[] getGiftList() {
		return giftList;
	}
	public void setGiftList(byte[] giftList) {
		this.giftList = giftList;
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
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	
	
	
	
	
	


	
	
	
}
