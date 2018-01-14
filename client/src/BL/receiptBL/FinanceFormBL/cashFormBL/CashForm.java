package BL.receiptBL.FinanceFormBL.cashFormBL;

import java.rmi.RemoteException;
import java.sql.Timestamp;

import BL.accountBL.AccountController;
import BL.accountBL.AccountInfo;
import BL.customerBL.CustomerController;
import BL.customerBL.CustomerInfo;
import BL.messageBL.MessageController;
import BL.receiptBL.FinanceFormBL.FinanceForm;
import BL.receiptBL.FinanceFormBL.TransItem;
import po.formPO.financeFormPO.CashFormPO;
import utility.StateOfForm;
import vo.MessageVO;
import vo.Form.FinanceFormVO.CashFormVO;

public class CashForm extends FinanceForm {

	public CashForm(CashFormVO vo) {
		super(vo);
	}

	public CashForm(CashFormPO po) {
		super(po);
	}

	public CashForm() {
	}

	public CashFormVO toVO() {
		CashFormVO out = new CashFormVO(this);
		return out;
	}

	public CashFormPO toPO() {
		CashFormPO out = new CashFormPO();
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

		String l = "";
		for (int i = 0; i < list.size(); i++) {
			TransItem t = list.get(i);
			l = l + t.getAccountID() + "&2" + t.getMoney() + "&2" + t.getComment();
			if (i != list.size() - 1) {
				l = l + "&1";
			}
		}
		out.setTransList(l);
		return out;

	}

	public boolean pass() {
		this.state = StateOfForm.pass;
		this.passTime = new Timestamp(System.currentTimeMillis());

		
		
		AccountInfo acc = new AccountController();
		for (TransItem t : getList()) {
			try {
				acc.changeMoney(t.getAccountID(), t.getMoney() * (-1));
			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
		return true;

	}
}
