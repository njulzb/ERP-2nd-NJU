package DataService.receiptDataService.NOUSE;

import po.formPO.tradeFormPO.PurchaseFormPO;

public interface purchaseFormDataService {
	
	public boolean addPurchaseForm(PurchaseFormPO current);
	
	public PurchaseFormPO getForm(String id);
	
	public boolean modifyForm(PurchaseFormPO current);
	
	public boolean submitForm(PurchaseFormPO current);
	
	public boolean approveForm(PurchaseFormPO current);
}
