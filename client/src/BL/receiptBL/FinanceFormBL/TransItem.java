package BL.receiptBL.FinanceFormBL;

import vo.Form.FinanceFormVO.TransItemVO;

/**
 * 单据中的条目项
 * @author lzb
 *
 */
public class TransItem  {
	String AccountID="";
	private String AccountName="";
	private String comment="";
	double money=0;
	
	public TransItem() {
		
	}
	public TransItem(TransItemVO vo) {
		AccountID=vo.getBankAccount().getID();
		AccountName=vo.getBankAccount().getName();
		money=vo.getMoney();
		setComment(vo.getComments());
	}
	
	public String getAccountID() {
		return AccountID;
	}
	public void setAccountID(String accountID) {
		AccountID = accountID;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getAccountName() {
		return AccountName;
	}
	public void setAccountName(String accountName) {
		AccountName = accountName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
