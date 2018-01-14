package po.formPO.stockFormPO;

import java.io.Serializable;
import po.formPO.FormPO;

/**
 * 财务类单据的父类
 * @author lyb
 *
 */
public class StockFormPO extends FormPO  implements Serializable {
	
	private String customerID="" ; 
	private String itemsList="";
	private double sumMoney=0;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2244432699951976602L;




	public String getCustomerID() {
		return customerID;
	}




	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}




	public String getItemsList() {
		return itemsList;
	}




	public void setItemsList(String itemsList) {
		this.itemsList = itemsList;
	}




	public double getSumMoney() {
		return sumMoney;
	}




	public void setSumMoney(double sumMoney) {
		this.sumMoney = sumMoney;
	}


	
	


	
	
	
}
