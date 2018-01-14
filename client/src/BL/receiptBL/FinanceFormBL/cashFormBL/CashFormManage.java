package BL.receiptBL.FinanceFormBL.cashFormBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import DataService.receiptDataService.FormDataService;
import RMI.ClientRunner;
import po.KeyForSearchForm;
import po.formPO.FormPO;
import po.formPO.financeFormPO.CashFormPO;
import vo.Form.FormVO;
import vo.Form.FinanceFormVO.CashFormVO;

public class CashFormManage {
	private FormDataService rmi;

	public static void main (String args[]) {
		CashForm a=new CashForm();
		a.setID("rmiTest");
		CashFormManage tp =new CashFormManage();
		tp.addForm(a.toVO());
		
	}
	
	public CashFormManage() {
		rmi = ClientRunner.getInstance().getFormDataService();
	}

	public FormVO getForm(String id) {

		FormPO c = null;
		try {
			c = rmi.getForm(id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			System.out.println("未成功getFormPO  #83883");
			e.printStackTrace();
		}
		CashForm temp = new CashForm((CashFormPO) c);

		return temp.toVO();
	}

	public boolean addForm(FormVO toPush) {
		CashForm temp = new CashForm((CashFormVO) toPush);
		boolean flag = false;
		try {
			flag = rmi.newForm(temp.toPO());

		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			System.out.println("未成功newFormPO  #8343");
			e.printStackTrace();
		}

		return flag;
	}

	public boolean deleteForm(String id) {
		boolean flag = false;
		try {
			flag = rmi.deleteForm(id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			System.out.println("未成功newFormPO  #12883");
			e.printStackTrace();
		}
		return flag;
	}

	public boolean editForm(FormVO toPush) {
		boolean flag = false;
		CashForm temp = new CashForm((CashFormVO) toPush);
		try {
			flag = rmi.editForm(temp.toPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			System.out.println("未成功newFormPO  #12883");
			e.printStackTrace();
		}
		return flag;
	}

	public ArrayList<FormVO> searchForm(KeyForSearchForm key) {
		ArrayList<FormVO> out = new ArrayList<FormVO>();
		ArrayList<FormPO> temp = new ArrayList<FormPO>();
		try {
			temp = rmi.searchForm(key);
		
		} catch (RemoteException e) {
			System.out.println("未成功searchFormPO  #83343");
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	
		for (FormPO a : temp) {
//			System.out.println(new CashForm((CashFormPO) a).getList().size()+"]]]]");
			out.add(new CashForm((CashFormPO) a).toVO());
		}		
//		for (FormVO a : out) {
//			System.out.println(((CashFormVO)a).getTransList().size());
//		}	
		return out;
	}

	public boolean passForm(String id) {
		CashForm temp = new CashForm((CashFormVO) getForm(id));
		temp.pass();
		editForm(temp.toVO());
		return true;

	}
}
