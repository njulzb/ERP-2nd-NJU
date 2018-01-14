package BL.receiptBL.FinanceFormBL;

import java.util.ArrayList;

import BL.customerBL.CustomerController;
import BL.receiptBL.Form;
import po.formPO.financeFormPO.FinanceFormPO;
import vo.CustomerVO;
import vo.Form.FinanceFormVO.FinanceFormVO;
import vo.Form.FinanceFormVO.TransItemVO;

public class FinanceForm extends Form {

	protected double sumMoney = 0;
	protected ArrayList<TransItem> list = new ArrayList<TransItem>();
	protected CustomerVO customer = new CustomerVO();

	public FinanceForm(FinanceFormVO vo) {
		super(vo);
		sumMoney = vo.getSum();
		customer = vo.getCustomer();
		for (TransItemVO tp : vo.getTransList()) {
			list.add(new TransItem(tp));
		}

	}

	public FinanceForm(FinanceFormPO po) {
		super(po);
		sumMoney = po.getSumMoney();
		customer = new CustomerController().getCustomer( po.getCustomerID())  ;
//		System.out.println();
//		System.out.println();
//		System.out.println(po.getTransList());
////		System.out.println(in.length);
		if(po.getTransList()==null||po.getTransList().length()==0) {
			return;
		}
		
		String in[] = po.getTransList().split("&1");
		for (String tp : in) {
			if(tp.indexOf("&2")==-1) {
				continue;
			}
			String item[] = tp.split("&2");
			TransItem temp = new TransItem();
			if(item.length>0)temp.setAccountID(item[0]);
			if(item.length>1)temp.setMoney(Double.valueOf(item[1]));
			if(item.length>2)temp.setComment(item[2]);
			list.add(temp);
		}
	
		
	}

	public FinanceForm() {

	}

	public double getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(double sumMoney) {
		this.sumMoney = sumMoney;
	}

	public ArrayList<TransItem> getList() {
		return list;
	}

	public void setList(ArrayList<TransItem> list) {
		this.list = list;
	}

	public CustomerVO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerVO customer) {
		this.customer = customer;
	}

}
