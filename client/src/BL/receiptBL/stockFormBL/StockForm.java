package BL.receiptBL.stockFormBL;

import java.util.ArrayList;

import BL.customerBL.Customer;
import BL.receiptBL.Form;
import po.formPO.financeFormPO.FinanceFormPO;
import po.formPO.stockFormPO.StockFormPO;
import vo.CustomerVO;
import vo.Form.FinanceFormVO.FinanceFormVO;
import vo.Form.stockFormVO.StockFormVO;

public class StockForm extends Form {

	protected double sumMoney = 0;
	protected ArrayList<StockItem> list = new ArrayList<StockItem>();
	protected Customer customer = new Customer();

	public StockForm(StockFormVO vo) {
	}

	public StockForm(StockFormPO po) {
	}

	public StockForm() {

	}

	public double getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(double sumMoney) {
		this.sumMoney = sumMoney;
	}

	public ArrayList<StockItem> getList() {
		return list;
	}

	public void setList(ArrayList<StockItem> list) {
		this.list = list;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
