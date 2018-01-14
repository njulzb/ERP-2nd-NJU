package DataService.receiptDataService.NOUSE;

import po.formPO.tradeFormPO.SaleSlipFormPO;

public interface saleSlipFormDataService {
	public boolean addsaleSlipForm(SaleSlipFormPO current);
	
	public SaleSlipFormPO getForm(String id);
	
	public boolean modifyForm(SaleSlipFormPO current);

	public boolean submitForm(SaleSlipFormPO current);
	
	public boolean approveForm(SaleSlipFormPO current);
}
