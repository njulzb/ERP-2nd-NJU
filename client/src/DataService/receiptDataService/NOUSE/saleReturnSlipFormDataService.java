package DataService.receiptDataService.NOUSE;

import po.formPO.tradeFormPO.SaleReturnFormPO;

public interface saleReturnSlipFormDataService {
	public boolean addsaleReturnSlipForm(SaleReturnFormPO current);
	
	public SaleReturnFormPO getForm(String id);
	
	public boolean modifyForm(SaleReturnFormPO current);

	public boolean submitForm(SaleReturnFormPO current);
	
	public boolean approveForm(SaleReturnFormPO current);
}
