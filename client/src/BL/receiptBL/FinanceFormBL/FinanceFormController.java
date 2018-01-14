package BL.receiptBL.FinanceFormBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import BLService.receiptBLService.FormBLService;
import po.KeyForSearchForm;
import vo.AccountVO;
import vo.CustomerVO;
import vo.Form.FormVO;

/**
 * 财务类单据的controller
 * @author lzb
 *
 */
public class FinanceFormController implements FormBLService ,FinanceFormInfo{

	@Override

	/**
	 * 根据id搜索单据的方法
	 */
	public FormVO getForm(String id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	/**
	 * 新增单据
	 */
	public boolean addForm(FormVO toPush) {
		// TODO 自动生成的方法存根
		return true;
	}






	public CustomerVO getCustomerList() {
		return null;
	}
	public AccountVO getAccountList() {
		return null;
	}

	@Override
	public ArrayList<FormVO> searchForm(KeyForSearchForm key) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean editForm(FormVO toPush) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean deleteForm(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean passForm(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
