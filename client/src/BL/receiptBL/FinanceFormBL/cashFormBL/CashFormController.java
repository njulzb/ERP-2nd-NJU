package BL.receiptBL.FinanceFormBL.cashFormBL;

import java.util.ArrayList;

import BLService.receiptBLService.cashFormBLService;
import po.KeyForSearchForm;
import vo.Form.FormVO;

public class CashFormController  implements cashFormBLService {
	private CashFormManage manage;
	
	public  CashFormController(){
		manage = new CashFormManage() ;
	}
	@Override
	public FormVO getForm(String id) {
		return manage.getForm(id);
	}
	@Override
	public boolean addForm(FormVO toPush) {
		return manage.addForm(toPush);
	}
	@Override
	public boolean deleteForm(String id) {
		return manage.deleteForm(id);
	}                                                

	@Override
	public boolean editForm(FormVO toPush) {
		return manage.editForm(toPush);
	}
	
	@Override
	public ArrayList<FormVO> searchForm(KeyForSearchForm key) {
		return manage.searchForm(key);
	}

	@Override
	public boolean passForm(String id) {
		return manage.passForm(id);
	}
}
