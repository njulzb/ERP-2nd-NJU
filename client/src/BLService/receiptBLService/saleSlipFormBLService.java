package BLService.receiptBLService;

import vo.Form.tradeFormVO.SaleExportFormVO;

public interface saleSlipFormBLService {
	public boolean addsaleSlipForm(SaleExportFormVO current);
	
	public SaleExportFormVO getForm(String id);
	
	public boolean modifyForm(SaleExportFormVO current);

	public boolean submitForm(SaleExportFormVO current);
	
	public boolean approveForm(SaleExportFormVO current);
}
