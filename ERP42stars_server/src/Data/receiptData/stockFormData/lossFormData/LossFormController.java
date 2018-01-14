package Data.receiptData.stockFormData.lossFormData;

import java.util.ArrayList;

import po.KeyForSearchForm;
import po.formPO.FormPO;
import po.formPO.stockFormPO.LossFormPO;
import Data.receiptData.financeFormData.cashFormData.CashFormSqlHelper;
import DataService.receiptDataService.FormDataService;

public class LossFormController  implements FormDataService {

	@Override
	public FormPO getForm(String id) {
		// TODO 自动生成的方法存根
		return LossFormSqlHelper.getForm(id);
	}

	@Override
	public boolean newForm(FormPO toPush) {
		
		// TODO 自动生成的方法存根
		
		return LossFormSqlHelper.insertForm((LossFormPO)toPush);
	}

	@Override
	public boolean editForm(FormPO toPush) {
		// TODO 自动生成的方法存根
		return LossFormSqlHelper.updateForm((LossFormPO)toPush);
		
	}

	@Override
	public ArrayList<FormPO> searchForm(KeyForSearchForm toPush) {
		// TODO 自动生成的方法存根
		return LossFormSqlHelper.searchForm(toPush);
	}
	@Override
	public boolean deleteForm(String id) {
		// TODO 自动生成的方法存根
		return LossFormSqlHelper.deleteForm(id);
	}
}
