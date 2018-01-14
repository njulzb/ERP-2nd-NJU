package Data.receiptData.stockFormData.alarmFormData;

import java.util.ArrayList;

import po.KeyForSearchForm;
import po.formPO.FormPO;
import po.formPO.stockFormPO.AlarmFormPO;
import DataService.receiptDataService.FormDataService;

public class AlarmFormController  implements FormDataService {

	@Override
	public FormPO getForm(String id) {
		// TODO 自动生成的方法存根
		return AlarmFormSqlHelper.getForm(id);
	}

	@Override
	public boolean newForm(FormPO toPush) {
		
		// TODO 自动生成的方法存根
		
		return AlarmFormSqlHelper.insertForm((AlarmFormPO)toPush);
	}

	@Override
	public boolean editForm(FormPO toPush) {
		// TODO 自动生成的方法存根
		return AlarmFormSqlHelper.updateForm((AlarmFormPO)toPush);
		
	}

	@Override
	public ArrayList<FormPO> searchForm(KeyForSearchForm toPush) {
		// TODO 自动生成的方法存根
		return AlarmFormSqlHelper.searchForm(toPush);
	}
	@Override
	public boolean deleteForm(String id) {
		// TODO 自动生成的方法存根
		return AlarmFormSqlHelper.deleteForm(id);
	}
}
