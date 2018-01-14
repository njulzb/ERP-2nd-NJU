package BL.receiptBL.stockFormBL.overFlowFormBl;

import java.util.ArrayList;

import BLService.receiptBLService.FormBLService;
import BLService.receiptBLService.LossFormBLService;
import po.KeyForSearchForm;
import vo.Form.FormVO;

public class OverFlowFormController  implements FormBLService {
	private OverFlowFormManage manage;
	
	public  OverFlowFormController(){
		manage = new OverFlowFormManage() ;
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
