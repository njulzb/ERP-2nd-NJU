package BLService.receiptBLService;

import vo.Form.tradeFormVO.PurchaseReturnFormVO;

public interface purchaseReturnFormBLService {
	public boolean addPurchaseReturnForm(PurchaseReturnFormVO current);
	
	public PurchaseReturnFormVO getForm(String id);
	
	public boolean modifyForm(PurchaseReturnFormVO current);
	
	public boolean submitForm(PurchaseReturnFormVO current);
	
	public boolean approveForm(PurchaseReturnFormVO current);
}
