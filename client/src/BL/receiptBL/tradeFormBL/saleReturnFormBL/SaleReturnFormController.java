package BL.receiptBL.tradeFormBL.saleReturnFormBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import BLService.receiptBLService.FormBLService;
import BLService.receiptBLService.PresentFormBLService;
import DataService.receiptDataService.FormDataService;
import RMI.ClientRunner;
import po.KeyForSearchForm;
import vo.Form.FormVO;

public class SaleReturnFormController implements FormBLService{
	private SaleSlipFormManage manage=new SaleSlipFormManage();
	@Override
	public FormVO getForm(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return manage.getForm(id);
	}

	@Override
	public boolean addForm(FormVO toPush) throws RemoteException {
		// TODO 自动生成的方法存根
		return manage.addForm(toPush);
	}

	@Override
	public boolean editForm(FormVO toPush) throws RemoteException {
		// TODO 自动生成的方法存根
		return manage.editForm(toPush);
	}

	@Override
	public boolean deleteForm(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return manage.deleteForm(id);
	}

	@Override
	public ArrayList<FormVO> searchForm(KeyForSearchForm key) throws RemoteException {
		// TODO 自动生成的方法存根
		return manage.searchForm(key);
	}

	@Override
	public boolean passForm(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return manage.passForm(id);
	}


}
