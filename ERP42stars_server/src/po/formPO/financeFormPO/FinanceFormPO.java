package po.formPO.financeFormPO;

import java.io.Serializable;
import java.util.Date;

import po.UserPO;
import po.formPO.FormPO;
import utility.StateOfForm;

/**
 * 财务类单据的父类
 * @author lyb
 *
 */
public class FinanceFormPO extends FormPO  implements Serializable {
	
	protected String customerID="" ; 
	protected String transList="";
	protected double sumMoney=0;
	
	
	

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

	public String getTransList() {
		return transList;
	}

	public void setTransList(String transList) {
		this.transList = transList;
	}

	public double getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(double sumMoney) {
		this.sumMoney = sumMoney;
	}


	
	


	
	
	
}
