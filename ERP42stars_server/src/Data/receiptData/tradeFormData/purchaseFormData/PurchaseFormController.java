package Data.receiptData.tradeFormData.purchaseFormData;

import java.util.ArrayList;

import po.KeyForSearchForm;
import po.formPO.FormPO;
import po.formPO.tradeFormPO.PurchaseFormPO;
import Data.receiptData.financeFormData.cashFormData.CashFormSqlHelper;
import DataService.receiptDataService.FormDataService;


public class PurchaseFormController  implements FormDataService {

	@Override
	public FormPO getForm(String id) {
		// TODO 自动生成的方法存根
		return PurchaseFormSqlHelper.getForm(id);
	}

	@Override
	public boolean newForm(FormPO toPush) {
		// TODO 自动生成的方法存根
		PurchaseFormPO a= (PurchaseFormPO)toPush;
		return PurchaseFormSqlHelper.insertForm(a);
	}

	@Override
	public boolean editForm(FormPO toPush) {
		// TODO 自动生成的方法存根
		PurchaseFormPO a= (PurchaseFormPO)toPush;
		return PurchaseFormSqlHelper.updateForm(a);
	}

	@Override
	public ArrayList<FormPO> searchForm(KeyForSearchForm key) {
		// TODO 自动生成的方法存根
		return PurchaseFormSqlHelper.searchForm(key);
	}
	@Override
	public boolean deleteForm(String id) {
		// TODO 自动生成的方法存根
		return PurchaseFormSqlHelper.deleteForm(id);
	}
}
