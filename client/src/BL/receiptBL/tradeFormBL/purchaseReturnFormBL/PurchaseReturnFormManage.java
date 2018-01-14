package BL.receiptBL.tradeFormBL.purchaseReturnFormBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import DataService.receiptDataService.FormDataService;
import RMI.ClientRunner;
import po.KeyForSearchForm;
import po.formPO.FormPO;
import po.formPO.tradeFormPO.PurchaseReturnFormPO;
import vo.Form.FormVO;
import vo.Form.tradeFormVO.PurchaseReturnFormVO;

public class PurchaseReturnFormManage {
	private FormDataService rmi;
	
	public  PurchaseReturnFormManage(){
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
		
		PurchaseReturnForm temp= new PurchaseReturnForm((PurchaseReturnFormPO)c);
		
		return temp.toVO();
	}

	public boolean addForm(FormVO toPush) {
		PurchaseReturnForm temp= new PurchaseReturnForm((PurchaseReturnFormVO)toPush);
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
		PurchaseReturnForm temp= new PurchaseReturnForm((PurchaseReturnFormVO)toPush);
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
			out.add(new PurchaseReturnForm((PurchaseReturnFormPO)a).toVO()  );
		}
		
		return out;
	}
	public boolean passForm(String id)  {
		PurchaseReturnForm  temp= new PurchaseReturnForm((PurchaseReturnFormVO)getForm(id));
		temp.pass();
		editForm(temp.toVO());
		return true;
		
	}
}
