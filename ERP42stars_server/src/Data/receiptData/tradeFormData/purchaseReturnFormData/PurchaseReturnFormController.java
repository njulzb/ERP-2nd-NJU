package Data.receiptData.tradeFormData.purchaseReturnFormData;

import java.util.ArrayList;

import po.KeyForSearchForm;
import po.formPO.FormPO;
import po.formPO.tradeFormPO.PurchaseReturnFormPO;
import Data.receiptData.financeFormData.cashFormData.CashFormSqlHelper;
import DataService.receiptDataService.FormDataService;


public class PurchaseReturnFormController  implements FormDataService {

	@Override
	public FormPO getForm(String id) {
		// TODO 自动生成的方法存根
		return PurchaseReturnFormSqlHelper.getForm(id);
	}

	@Override
	public boolean newForm(FormPO toPush) {
		// TODO 自动生成的方法存根
		PurchaseReturnFormPO a= (PurchaseReturnFormPO)toPush;
		return PurchaseReturnFormSqlHelper.insertForm(a);
	}

	@Override
	public boolean editForm(FormPO toPush) {
		// TODO 自动生成的方法存根
		PurchaseReturnFormPO a= (PurchaseReturnFormPO)toPush;
		return PurchaseReturnFormSqlHelper.updateForm(a);
	}

	@Override
	public ArrayList<FormPO> searchForm(KeyForSearchForm key) {
		// TODO 自动生成的方法存根
		return PurchaseReturnFormSqlHelper.searchForm(key);
	}
	@Override
	public boolean deleteForm(String id) {
		// TODO 自动生成的方法存根
		return PurchaseReturnFormSqlHelper.deleteForm(id);
	}
}
