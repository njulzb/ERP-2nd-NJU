package BL.receiptBL.FinanceFormBL.payFormBL;

import java.util.ArrayList;

import BLService.receiptBLService.FormBLService;
import BLService.receiptBLService.cashFormBLService;
import po.KeyForSearchForm;
import vo.Form.FormVO;

public class PayFormController  implements FormBLService {
	private PayFormManage manage;
	
	public  PayFormController(){
		manage = new PayFormManage() ;
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
