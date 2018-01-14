package BL.receiptBL.tradeFormBL.saleSlipFormBL;

import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.ArrayList;

import BLService.receiptBLService.FormBLService;
import BLService.receiptBLService.PresentFormBLService;
import DataService.receiptDataService.FormDataService;
import RMI.ClientRunner;
import po.KeyForSearchForm;
import po.formPO.tradeFormPO.SaleSlipFormPO;
import utility.StateOfForm;
import vo.CustomerVO;
import vo.UserVO;
import vo.Form.FormVO;
import vo.Form.tradeFormVO.SaleExportFormVO;

public class SaleSlipFormController implements FormBLService {
	private SaleSlipFormManage manage = new SaleSlipFormManage();

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

	public static void main(String args[]) {
		SaleExportFormVO p=new SaleExportFormVO();
		p.setCreateTime(new Timestamp(System.currentTimeMillis()));
		p.setComment("aaaa");
		p.setOperator(new UserVO("33","2"));
		p.setCustomer(new CustomerVO("33"));
		p.setState(StateOfForm.draft);
		try {
			new  SaleSlipFormController().addForm(p);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
