package Data.receiptData.tradeFormData.saleReturnFormBL;

import java.util.ArrayList;

import po.KeyForSearchForm;
import po.formPO.FormPO;
import po.formPO.tradeFormPO.SaleReturnFormPO;
import Data.receiptData.financeFormData.cashFormData.CashFormSqlHelper;
import DataService.receiptDataService.FormDataService;


public class SaleReturnFormController implements FormDataService {

	@Override
	public FormPO getForm(String id) {
		// TODO 自动生成的方法存根
		return SaleReturnFormSqlHelper.getForm(id);
	}

	@Override
	public boolean newForm(FormPO toPush) {
		// TODO 自动生成的方法存根
		SaleReturnFormPO a= (SaleReturnFormPO)toPush;
		return SaleReturnFormSqlHelper.insertForm(a);
	}

	@Override
	public boolean editForm(FormPO toPush) {
		// TODO 自动生成的方法存根
		SaleReturnFormPO a= (SaleReturnFormPO)toPush;
		return SaleReturnFormSqlHelper.updateForm(a);
	}

	@Override
	public ArrayList<FormPO> searchForm(KeyForSearchForm key) {
		// TODO 自动生成的方法存根
		return SaleReturnFormSqlHelper.searchForm(key);
	}
	@Override
	public boolean deleteForm(String id) {
		// TODO 自动生成的方法存根
		return SaleReturnFormSqlHelper.deleteForm(id);
	}
}

