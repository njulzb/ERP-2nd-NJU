package BL.receiptBL.FinanceFormBL.payFormBL;

import java.rmi.RemoteException;
import java.sql.Timestamp;

import BL.accountBL.AccountController;
import BL.accountBL.AccountInfo;
import BL.customerBL.CustomerController;
import BL.customerBL.CustomerInfo;
import BL.receiptBL.FinanceFormBL.FinanceForm;
import BL.receiptBL.FinanceFormBL.TransItem;
import po.formPO.financeFormPO.PayFormPO;
import utility.StateOfForm;
import vo.Form.FinanceFormVO.PayFormVO;

public class PayForm extends FinanceForm {

	public PayForm(PayFormVO vo) {
		super(vo);
	}

	public PayForm(PayFormPO po) {
		super(po);
	}

	public PayForm() {
	}

	public PayFormVO toVO() {
		PayFormVO out = new PayFormVO(this);
		return out;
	}

	public PayFormPO toPO() {
		PayFormPO out = new PayFormPO();
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

		double sum = 0;
		AccountInfo acc = new AccountController();
		for (TransItem t : getList()) {
			sum += t.getMoney();
			try {
				acc.changeMoney(t.getAccountID(), t.getMoney() * (-1));
			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		CustomerInfo cus = new CustomerController();

		try {
			cus.modifyReceiveAmount(getCustomer().getId(),
					cus.getCustomerByID(getCustomer().getId()).getReceiveAmount() + sum);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		return true;
	}
}
