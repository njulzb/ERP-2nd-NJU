package BL.receiptBL.tradeFormBL.purchaseFormBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import DataService.receiptDataService.FormDataService;
import RMI.ClientRunner;
import po.KeyForSearchForm;
import po.formPO.FormPO;
import po.formPO.tradeFormPO.PurchaseFormPO;
import vo.Form.FormVO;
import vo.Form.tradeFormVO.PurchaseFormVO;

public class PurchaseFormManage {
	private FormDataService rmi;
	
	public  PurchaseFormManage(){
		rmi=ClientRunner.getInstance().getFormDataService() ;
	}
	public FormVO getForm(String id) {
		
		 FormPO c=null;
		try {
			c = rmi.getForm(id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			System.out.println("未成功getFormPO  #83883");
			e.printStackTrace();
		}
		
		PurchaseForm temp= new PurchaseForm((PurchaseFormPO)c);
		
		return temp.toVO();
	}

	public boolean addForm(FormVO toPush) {
		PurchaseForm temp= new PurchaseForm((PurchaseFormVO)toPush);
		boolean flag=false;
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
		boolean flag=false;
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
		boolean flag=false;
		PurchaseForm temp= new PurchaseForm((PurchaseFormVO)toPush);
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
		ArrayList<FormVO>  out= new ArrayList<FormVO>();
		ArrayList<FormPO>  temp= new ArrayList<FormPO>();
		try {
			temp=rmi.searchForm(key);
		} catch (RemoteException e) {
			System.out.println("未成功searchFormPO  #83343");
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		for(FormPO a:temp) {
			out.add(new PurchaseForm((PurchaseFormPO)a).toVO()  );
		}
		
		return out;
	}
	public boolean passForm(String id)  {
		PurchaseForm  temp= new PurchaseForm((PurchaseFormVO)getForm(id));
		temp.pass();
		editForm(temp.toVO());
		return true;
		
	}
}
