package BLService.receiptBLService;

import vo.Form.tradeFormVO.SaleReturnFormVO;

public interface saleReturnSlipFormBLService {
	public boolean addsaleReturnSlipForm(SaleReturnFormVO current);
	
	public SaleReturnFormVO getForm(String id);
	
	public boolean modifyForm(SaleReturnFormVO current);

	public boolean submitForm(SaleReturnFormVO current);
	
	public boolean approveForm(SaleReturnFormVO current);
}
