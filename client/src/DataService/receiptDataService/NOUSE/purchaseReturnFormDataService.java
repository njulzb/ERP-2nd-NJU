package DataService.receiptDataService.NOUSE;

import po.formPO.tradeFormPO.PurchaseReturnFormPO;

public interface purchaseReturnFormDataService {
	public boolean addPurchaseReturnForm(PurchaseReturnFormPO current);
	
	public PurchaseReturnFormPO getForm(String id);
	
	public boolean modifyForm(PurchaseReturnFormPO current);
	
	public boolean submitForm(PurchaseReturnFormPO current);
	
	public boolean approveForm(PurchaseReturnFormPO current);
}
