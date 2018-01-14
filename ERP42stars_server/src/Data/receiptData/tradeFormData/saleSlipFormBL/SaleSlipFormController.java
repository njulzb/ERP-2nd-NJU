package Data.receiptData.tradeFormData.saleSlipFormBL;

import java.util.ArrayList;

import po.KeyForSearchForm;
import po.formPO.FormPO;
import po.formPO.tradeFormPO.SaleSlipFormPO;
import Data.receiptData.financeFormData.cashFormData.CashFormSqlHelper;
import DataService.receiptDataService.FormDataService;


public class SaleSlipFormController implements FormDataService {

	@Override
	public FormPO getForm(String id) {
		// TODO 自动生成的方法存根
		return SaleSlipFormSqlHelper.getForm(id);
	}

	@Override
	public boolean newForm(FormPO toPush) {
		// TODO 自动生成的方法存根
		SaleSlipFormPO a= (SaleSlipFormPO)toPush;
		return SaleSlipFormSqlHelper.insertForm(a);
	}

	@Override
	public boolean editForm(FormPO toPush) {
		// TODO 自动生成的方法存根
		SaleSlipFormPO a= (SaleSlipFormPO)toPush;
		return SaleSlipFormSqlHelper.updateForm(a);
	}

	@Override
	public ArrayList<FormPO> searchForm(KeyForSearchForm key) {
		// TODO 自动生成的方法存根
		return SaleSlipFormSqlHelper.searchForm(key);
	}
	@Override
	public boolean deleteForm(String id) {
		// TODO 自动生成的方法存根
		return SaleSlipFormSqlHelper.deleteForm(id);
	}
}

