package Data.receiptData.financeFormData.receiptFormData;

import java.util.ArrayList;

import po.KeyForSearchForm;
import po.formPO.FormPO;
import po.formPO.financeFormPO.FinanceFormPO;
import po.formPO.financeFormPO.ReceiptFormPO;
import Data.receiptData.financeFormData.cashFormData.CashFormSqlHelper;
import DataService.receiptDataService.FormDataService;

public class ReceiptFormDataController implements FormDataService {
	public ReceiptFormDataController(){
		
		
	}
	@Override
	public FinanceFormPO getForm(String id) {
		// TODO 自动生成的方法存根
		return ReceiptFormSqlHelper.getForm(id, "receiptform");
			
	}

	
	@Override
	public boolean newForm(FormPO toPush) {
			return ReceiptFormSqlHelper.insertForm((ReceiptFormPO)toPush, "receiptform");
	}

	
	
	@Override
	public boolean editForm(FormPO toPush) {
		// TODO 自动生成的方法存根
		
			return ReceiptFormSqlHelper.updateForm((ReceiptFormPO)toPush, "receiptform");
		
	}

	
	
	@Override
	public ArrayList<FormPO> searchForm(KeyForSearchForm toPush) {
		// TODO 自动生成的方法存根
	
		return ReceiptFormSqlHelper.searchForm(toPush, "receiptform");
	}
	@Override
	public boolean deleteForm(String id) {
		// TODO 自动生成的方法存根
		return CashFormSqlHelper.deleteForm(id, "receiptform");
	}
}
