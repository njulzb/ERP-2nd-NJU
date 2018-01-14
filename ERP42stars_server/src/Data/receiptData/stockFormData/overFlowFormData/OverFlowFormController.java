package Data.receiptData.stockFormData.overFlowFormData;

import java.util.ArrayList;

import po.KeyForSearchForm;
import po.formPO.FormPO;
import po.formPO.stockFormPO.OverFlowFormPO;
import po.formPO.stockFormPO.StockFormPO;
import Data.receiptData.financeFormData.cashFormData.CashFormSqlHelper;
import DataService.receiptDataService.FormDataService;


public class OverFlowFormController  implements FormDataService {

	@Override
	public FormPO getForm(String id) {
		// TODO 自动生成的方法存根
		return OverFlowSqlHelper.getForm(id);
	}

	@Override
	public boolean newForm(FormPO toPush) {
		
		// TODO 自动生成的方法存根
		
		return OverFlowSqlHelper.insertForm(( OverFlowFormPO)toPush);
	}

	@Override
	public boolean editForm(FormPO toPush) {
		// TODO 自动生成的方法存根
		return OverFlowSqlHelper.updateForm(( OverFlowFormPO)toPush);
		
	}

	@Override
	public ArrayList<FormPO> searchForm(KeyForSearchForm toPush) {
		// TODO 自动生成的方法存根
		return OverFlowSqlHelper.searchForm(toPush);
	}

	@Override
	public boolean deleteForm(String id) {
		// TODO 自动生成的方法存根
		return  OverFlowSqlHelper.deleteForm(id);
	}
}
