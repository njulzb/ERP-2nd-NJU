package BL.receiptBL.tradeFormBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import BLService.receiptBLService.FormBLService;
import po.KeyForSearchForm;
import vo.Form.FormVO;
import vo.goods.GoodsVO;
import vo.CustomerVO;

public class TradeFormController  implements FormBLService {

	
	
	public CustomerVO getCustomerList() {
		return null;
	}
	public GoodsVO getGoodsList() {
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
	public ArrayList<FormVO> searchForm(KeyForSearchForm key) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean passForm(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}
	@Override
	public FormVO getForm(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public boolean addForm(FormVO toPush) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}
}
