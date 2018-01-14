package BL.receiptBL.FinanceFormBL.receiptFormBL;

import java.util.ArrayList;

import BLService.receiptBLService.cashFormBLService;
import po.KeyForSearchForm;
import vo.Form.FormVO;
import vo.Form.FinanceFormVO.ReceiptFormVO;

/**
 * 收款单的controller
 * @author lzb
 *
 */
public class ReceiptFormController  implements cashFormBLService {
	private ReceiptFormManage manage;
	
	
	public static void main (String args[]) {
		ReceiptFormController  c=new ReceiptFormController ();
		
		ReceiptFormVO vo =new ReceiptFormVO();
		vo.setSum(19108);
		c.addForm(vo);
	}
	
	
	
	/**
	 * 构造函数初始化
	 */
	public  ReceiptFormController(){
		manage = new ReceiptFormManage() ;
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
