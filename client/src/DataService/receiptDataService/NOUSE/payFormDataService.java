package DataService.receiptDataService.NOUSE;

import po.formPO.financeFormPO.PayFormPO;

public interface payFormDataService {
	public PayFormPO getForm(String id);
	public boolean newForm(PayFormPO toPush);
	public boolean editForm(PayFormPO toPush);
	public boolean deleteForm(String id);
}
