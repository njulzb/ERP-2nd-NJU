package Data.receiptData.financeFormData.cashFormData;

import java.util.ArrayList;

import po.KeyForSearchForm;
import po.formPO.FormPO;
import po.formPO.financeFormPO.CashFormPO;
import DataService.receiptDataService.FormDataService;

public class CashFormDataController implements FormDataService {
	public CashFormDataController(){
		
		
	}
	@Override
	public CashFormPO getForm(String id) {
		// TODO 自动生成的方法存根
		return CashFormSqlHelper.getForm(id, "cashform");
			
	}

	
	@Override
	public boolean newForm(FormPO toPush) {
		// TODO 自动生成的方法存根
	
			return CashFormSqlHelper.insertForm((CashFormPO)toPush, "cashform");

	
	}

	
	
	@Override
	public boolean editForm(FormPO toPush) {
		// TODO 自动生成的方法存根
		
			return CashFormSqlHelper.updateForm((CashFormPO)toPush, "cashform");
		
	}

	
	
	@Override
	public ArrayList<FormPO> searchForm(KeyForSearchForm toPush) {
		// TODO 自动生成的方法存根
		return CashFormSqlHelper.searchForm(toPush, "cashform");
	}
	public static void main(String args[]) {
////	CashFormPO p=new CashFormPO();
////	p.setID("test1");
////	p.setOperatorID("xiaoLi");
////	p.setCustomerID("laowang");
////	p.setCreateTime( new Timestamp(2011-1900,11,11,11,11,11,0));
////	p.setRejectConment("redo");
////	
	KeyForSearchForm key =new	KeyForSearchForm();
	key.setID("test1");
	key.setCustomerID("laowang");
	new CashFormDataController().searchForm(key);
//	
////	CashFormPO p=getForm("fff");
////	insertForm(p);
}
	@Override
	public boolean deleteForm(String id) {
		// TODO 自动生成的方法存根
		return CashFormSqlHelper.deleteForm(id, "cashform");
	}

}
