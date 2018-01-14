package po;

import java.io.Serializable;
import java.sql.Timestamp;

import utility.KindOfForm;
import utility.StateOfForm;

public class KeyForSearchForm implements Serializable{
	private int MAX= 2147483647,MIN=-2147483648;
	/**
	 * 
	 */
	private static final long serialVersionUID = -3715343448435953041L;
	
	private String ID;
	private StateOfForm state;	//there are 3 states of form 1. draft 2. admitted 3. pass
	private String operatorID;
	private String storeHouse;
	private String customerID ; 
	private String transList;
	
	private KindOfForm kind;
	
	private int sumMoneyMin=MIN,sumMoneyMax=MAX;
	private int MoneyPreDiscountMin=MIN,MoneyPreDiscountMax=MAX;
	private int MoneyAfterDiscountMin=MIN,MoneyAfterDiscountMax=MAX;
	private int DiscountMin=MIN,DiscountMax=MAX;
	
	
	public KindOfForm getKindOfForm() {return this.kind;}
	public boolean setKindOfForm(KindOfForm kind) {this.kind = kind;return true;}
	
	
	private Timestamp 	createTimeMin=  Timestamp.valueOf("2010-01-01 00:00:00")  ,
						createTimeMax=  Timestamp.valueOf("2070-01-01 00:00:00");
	
	private Timestamp 	saveTimeMin=  Timestamp.valueOf("2010-01-01 00:00:00") ,
						saveTimeMax=  Timestamp.valueOf("2070-01-01 00:00:00");
	
	private Timestamp 	submitTimeMin=  Timestamp.valueOf("2010-01-01 00:00:00") ,
						submitTimeMax=  Timestamp.valueOf("2070-01-01 00:00:00");
	
	private Timestamp 	passTimeMin=  Timestamp.valueOf("2010-01-01 00:00:00") ,
						passTimeMax=  Timestamp.valueOf("2070-01-01 00:00:00");
	
	private Timestamp 	rejectTimeMin=  Timestamp.valueOf("2010-01-01 00:00:00") ,
						rejectTimeMax=  Timestamp.valueOf("2070-01-01 00:00:00");

	private String rejectConment;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public StateOfForm getState() {
		return state;
	}

	public void setState(StateOfForm state) {
		this.state = state;
	}

	public String getOperatorID() {
		return operatorID;
	}

	public void setOperatorID(String operatorID) {
		this.operatorID = operatorID;
	}

	public Timestamp getCreateTimeMin() {
		return createTimeMin;
	}

	public void setCreateTimeMin(Timestamp createTimeMin) {
		this.createTimeMin = createTimeMin;
	}

	public Timestamp getCreateTimeMax() {
		return createTimeMax;
	}

	public void setCreateTimeMax(Timestamp createTimeMax) {
		this.createTimeMax = createTimeMax;
	}

	public Timestamp getSaveTimeMin() {
		return saveTimeMin;
	}

	public void setSaveTimeMin(Timestamp saveTimeMin) {
		this.saveTimeMin = saveTimeMin;
	}

	public Timestamp getSaveTimeMax() {
		return saveTimeMax;
	}

	public void setSaveTimeMax(Timestamp saveTimeMax) {
		this.saveTimeMax = saveTimeMax;
	}

	public Timestamp getSubmitTimeMin() {
		return submitTimeMin;
	}

	public void setSubmitTimeMin(Timestamp submitTimeMin) {
		this.submitTimeMin = submitTimeMin;
	}

	public Timestamp getSubmitTimeMax() {
		return submitTimeMax;
	}

	public void setSubmitTimeMax(Timestamp submitTimeMax) {
		this.submitTimeMax = submitTimeMax;
	}

	public Timestamp getPassTimeMin() {
		return passTimeMin;
	}

	public void setPassTimeMin(Timestamp passTimeMin) {
		this.passTimeMin = passTimeMin;
	}

	public Timestamp getPassTimeMax() {
		return passTimeMax;
	}

	public void setPassTimeMax(Timestamp passTimeMax) {
		this.passTimeMax = passTimeMax;
	}

	public Timestamp getRejectTimeMin() {
		return rejectTimeMin;
	}

	public void setRejectTimeMin(Timestamp rejectTimeMin) {
		this.rejectTimeMin = rejectTimeMin;
	}

	public Timestamp getRejectTimeMax() {
		return rejectTimeMax;
	}

	public void setRejectTimeMax(Timestamp rejectTimeMax) {
		this.rejectTimeMax = rejectTimeMax;
	}

	public String getRejectConment() {
		return rejectConment;
	}

	public void setRejectConment(String rejectConment) {
		this.rejectConment = rejectConment;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getTransList() {
		return transList;
	}

	public void setTransList(String transList) {
		this.transList = transList;
	}

	public int getSumMoneyMin() {
		return sumMoneyMin;
	}

	public void setSumMoneyMin(int sumMoneyMin) {
		this.sumMoneyMin = sumMoneyMin;
	}

	public int getSumMoneyMax() {
		return sumMoneyMax;
	}

	public void setSumMoneyMax(int sumMoneyMax) {
		this.sumMoneyMax = sumMoneyMax;
	}

	public String getStoreHouse() {
		return storeHouse;
	}

	public void setStoreHouse(String storeHouse) {
		this.storeHouse = storeHouse;
	}

	public int getMoneyPreDiscountMin() {
		return MoneyPreDiscountMin;
	}

	public void setMoneyPreDiscountMin(int moneyPreDiscountMin) {
		MoneyPreDiscountMin = moneyPreDiscountMin;
	}

	public int getMoneyPreDiscountMax() {
		return MoneyPreDiscountMax;
	}

	public void setMoneyPreDiscountMax(int moneyPreDiscountMax) {
		MoneyPreDiscountMax = moneyPreDiscountMax;
	}

	public int getMoneyAfterDiscountMin() {
		return MoneyAfterDiscountMin;
	}

	public void setMoneyAfterDiscountMin(int moneyAfterDiscountMin) {
		MoneyAfterDiscountMin = moneyAfterDiscountMin;
	}

	public int getMoneyAfterDiscountMax() {
		return MoneyAfterDiscountMax;
	}

	public void setMoneyAfterDiscountMax(int moneyAfterDiscountMax) {
		MoneyAfterDiscountMax = moneyAfterDiscountMax;
	}

	public int getDiscountMin() {
		return DiscountMin;
	}

	public void setDiscountMin(int discountMin) {
		DiscountMin = discountMin;
	}

	public int getDiscountMax() {
		return DiscountMax;
	}

	public void setDiscountMax(int DiscountMax) {
		this.DiscountMax = DiscountMax;
	}
}
