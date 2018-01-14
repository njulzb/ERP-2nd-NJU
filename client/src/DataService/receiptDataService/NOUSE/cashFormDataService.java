package DataService.receiptDataService.NOUSE;

import po.formPO.financeFormPO.CashFormPO;

public interface cashFormDataService {
	public CashFormPO getForm(String id);
	public boolean newForm(CashFormPO toPush);
	public boolean editForm(CashFormPO toPush);
	public boolean deleteForm(String id);
}
