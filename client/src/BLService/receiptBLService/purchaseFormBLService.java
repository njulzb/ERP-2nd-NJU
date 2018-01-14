package BLService.receiptBLService;

import vo.Form.tradeFormVO.PurchaseFormVO;

public interface purchaseFormBLService {
	
	public boolean addPurchaseForm(PurchaseFormVO current);
	
	public PurchaseFormVO getForm(String id);
	
	public boolean modifyForm(PurchaseFormVO current);
	
	public boolean submitForm(PurchaseFormVO current);
	
	public boolean approveForm(PurchaseFormVO current);
}
