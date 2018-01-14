package vo.Form.FinanceFormVO;

import java.util.ArrayList;
import java.util.Date;

import BL.receiptBL.FinanceFormBL.FinanceForm;
import BL.receiptBL.FinanceFormBL.TransItem;
import utility.StateOfForm;
import vo.AccountVO;
import vo.CustomerVO;
import vo.UserVO;
import vo.Form.FormVO;

/**
 * 现金费用单VO
 * @author Eli
 *
 */

public class FinanceFormVO extends FormVO{

	protected double sum=0;
	protected  CustomerVO customer=new CustomerVO();
	ArrayList<TransItemVO>  List= new ArrayList<TransItemVO> ();

	public FinanceFormVO(UserVO operatorx, String idx, StateOfForm statex,
			Date times) {
		super(operatorx, idx, statex, times);
		// TODO 自动生成的构造函数存根
	}
	public FinanceFormVO() {
		// TODO 自动生成的构造函数存根
	}
	public FinanceFormVO(FinanceForm form) {
		super(form);
		sum = form.getSumMoney();
		customer =form.getCustomer();
		for (TransItem tp : form.getList()) {
			List.add(new TransItemVO(tp));
		}

	}
	

	
	public void updateSum() {
		sum=0;
		for(int i=0;i<List.size();i++) {
			sum+=(List.get(i)).getMoney();
		}
	}
	

	
	public ArrayList<TransItemVO>  getTransList(){
		return List;
	}
	public boolean addTransItemVO(AccountVO bA,int mo,String co){
		List.add(new TransItemVO( bA, mo, co));
		return true;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public CustomerVO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerVO customer) {
		this.customer = customer;
	}
	
	
	
	
	
	

}
