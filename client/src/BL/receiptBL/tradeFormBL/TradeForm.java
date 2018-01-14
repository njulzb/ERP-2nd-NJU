package BL.receiptBL.tradeFormBL;

import java.util.ArrayList;

import BL.customerBL.Customer;
import BL.receiptBL.Form;

public class TradeForm extends Form {

	protected double sumMoney = 0;
	protected ArrayList<TradeItem> goodsList = new ArrayList<TradeItem>();
	protected ArrayList<TradeItem> giftList = new ArrayList<TradeItem>();
	protected Customer customer = new Customer();
	
	
	
	
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
	public ArrayList<TradeItem> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(ArrayList<TradeItem> goodsList) {
		this.goodsList = goodsList;
	}
	public ArrayList<TradeItem> getGiftList() {
		return giftList;
	}
	public void setGiftList(ArrayList<TradeItem> giftList) {
		this.giftList = giftList;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
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
