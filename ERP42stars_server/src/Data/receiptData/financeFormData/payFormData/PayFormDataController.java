package Data.receiptData.financeFormData.payFormData;

import java.util.ArrayList;

import po.KeyForSearchForm;
import po.formPO.FormPO;
import po.formPO.financeFormPO.FinanceFormPO;
import po.formPO.financeFormPO.PayFormPO;
import Data.receiptData.financeFormData.cashFormData.CashFormSqlHelper;
import DataService.receiptDataService.FormDataService;

public class PayFormDataController implements FormDataService {
	public PayFormDataController(){
		
		
	}
	@Override
	public FinanceFormPO getForm(String id) {
		// TODO 自动生成的方法存根
		return PayFormSqlHelper.getForm(id, "payform");
			
	}

	
	@Override
	public boolean newForm(FormPO toPush) {
		// TODO 自动生成的方法存根
	
			return PayFormSqlHelper.insertForm((PayFormPO)toPush, "payform");

	
	}

	
	
	@Override
	public boolean editForm(FormPO toPush) {
		// TODO 自动生成的方法存根
		
			return PayFormSqlHelper.updateForm((PayFormPO)toPush, "payform");
		
	}

	
	
	@Override
	public ArrayList<FormPO> searchForm(KeyForSearchForm toPush) {
		// TODO 自动生成的方法存根
	
		return PayFormSqlHelper.searchForm(toPush, "payform");
	}

	
	@Override
	public boolean deleteForm(String id) {
		// TODO 自动生成的方法存根
		return CashFormSqlHelper.deleteForm(id, "payform");
	}

}
