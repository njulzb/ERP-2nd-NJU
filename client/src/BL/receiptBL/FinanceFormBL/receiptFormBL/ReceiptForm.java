package BL.receiptBL.FinanceFormBL.receiptFormBL;

import java.rmi.RemoteException;
import java.sql.Timestamp;

import BL.accountBL.AccountController;
import BL.accountBL.AccountInfo;
import BL.customerBL.CustomerController;
import BL.customerBL.CustomerInfo;
import BL.receiptBL.FinanceFormBL.FinanceForm;
import BL.receiptBL.FinanceFormBL.TransItem;
import po.formPO.financeFormPO.ReceiptFormPO;
import utility.StateOfForm;
import vo.Form.FinanceFormVO.ReceiptFormVO;

/**
 * 收款单实体
 * @author lzb
 *
 */
public class ReceiptForm   extends FinanceForm {

	
	public ReceiptForm(ReceiptFormVO vo) {
		super(vo);
	}
	public ReceiptForm(ReceiptFormPO po) {
		super(po);
	}
	public ReceiptForm() {
	}
	public ReceiptFormVO toVO() {
		ReceiptFormVO out =new ReceiptFormVO(this) ;
		return out;
	}
	public ReceiptFormPO toPO() {
		ReceiptFormPO out =new ReceiptFormPO() ;
		out.setID(ID);
		out.setCreateTime(createTime);
		out.setPassTime(passTime);
		out.setRejectConment(rejectConment);
		out.setRejectTime(rejectTime);
		out.setSaveTime(saveTime);
		out.setOperatorID(operator.getID());
		out.setCustomerID(customer.getId());
		out.setState(state);
		out.setSubmitTime(submitTime);
		out.setSumMoney(sumMoney);
		
		String l="";
		for( int i=0;i<list.size();i++) {
			TransItem t= list.get(i);
			l=l+t.getAccountID()+"&2"+t.getMoney()+"&2"+t.getComment();
			if(i!=list.size()-1) {
				l=l+"&1";
			}
		}
		out.setTransList(l);
		return out;   
		
	}
	
	/**
	 * 单据通过审批生效的方法
	 */
	public boolean pass() {
		this.state = StateOfForm.pass;
		this.passTime = new Timestamp(System.currentTimeMillis());
		double sum = 0;
		AccountInfo acc = new AccountController();
		for (TransItem t : getList()) {
			sum += t.getMoney();
			try {
				acc.changeMoney(t.getAccountID(), t.getMoney());
			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		CustomerInfo cus = new CustomerController();

		try {
			cus.modifyPayAmount(getCustomer().getId(),
					cus.getCustomerByID(getCustomer().getId()).getPayAmount() + sum);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		return true;
		
	}
}
