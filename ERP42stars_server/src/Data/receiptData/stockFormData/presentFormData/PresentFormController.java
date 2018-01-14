package Data.receiptData.stockFormData.presentFormData;

import java.util.ArrayList;

import po.KeyForSearchForm;
import po.formPO.FormPO;
import po.formPO.stockFormPO.PresentFormPO;
import Data.receiptData.financeFormData.cashFormData.CashFormSqlHelper;
import DataService.receiptDataService.FormDataService;


public class PresentFormController  implements FormDataService {

	@Override
	public FormPO getForm(String id) {
		// TODO 自动生成的方法存根
		return PresentFormSqlHelper.getForm(id);
	}

	@Override
	public boolean newForm(FormPO toPush) {
		
		// TODO 自动生成的方法存根
		
		return PresentFormSqlHelper.insertForm((PresentFormPO)toPush);
	}

	@Override
	public boolean editForm(FormPO toPush) {
		// TODO 自动生成的方法存根
		return PresentFormSqlHelper.updateForm((PresentFormPO)toPush);
		
	}

	@Override
	public ArrayList<FormPO> searchForm(KeyForSearchForm toPush) {
		// TODO 自动生成的方法存根
		return PresentFormSqlHelper.searchForm(toPush);
	}
	@Override
	public boolean deleteForm(String id) {
		// TODO 自动生成的方法存根
		return PresentFormSqlHelper.deleteForm(id);
	}
}
