package vo.Form.FinanceFormVO;

import BL.receiptBL.FinanceFormBL.TransItem;
import vo.AccountVO;

public class TransItemVO{
	private AccountVO bankAccount=new AccountVO("default","0000",0);
	private double money=0;
	private String comments="default ";
	
	
	
	public TransItemVO(AccountVO bA,int mo,String co){
		setBankAccount(bA);
		setMoney(mo);
		setComments(co);
	}
	public TransItemVO() {
		
	}
	public TransItemVO(TransItem t) {
		bankAccount =new AccountVO(t.getAccountID(),t.getAccountName(),1000);
		money =t.getMoney();
		comments=t.getComment();
	}
	
	
	
	
	
	
	
	
	
	
	
	public AccountVO getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(AccountVO bankAccount) {
		this.bankAccount = bankAccount;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
