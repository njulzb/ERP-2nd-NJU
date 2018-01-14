package DataService.receiptDataService.NOUSE;

import po.formPO.financeFormPO.ReceiptFormPO;

public interface receiptFormDataService {
	public ReceiptFormPO getReceiptForm(String id);
	public boolean newReceiptForm(ReceiptFormPO toPush);
	public boolean editReceiptForm(ReceiptFormPO toPush);
	public boolean deleteForm(String id);
}
