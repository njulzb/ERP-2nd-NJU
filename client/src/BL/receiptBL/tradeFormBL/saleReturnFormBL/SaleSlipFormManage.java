package BL.receiptBL.tradeFormBL.saleReturnFormBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import BL.receiptBL.tradeFormBL.saleSlipFormBL.SaleSlipForm;
import DataService.receiptDataService.FormDataService;
import RMI.ClientRunner;
import po.KeyForSearchForm;
import po.formPO.FormPO;
import po.formPO.tradeFormPO.SaleSlipFormPO;
import vo.Form.FormVO;
import vo.Form.tradeFormVO.SaleExportFormVO;

public class SaleSlipFormManage {
	private FormDataService rmi;
	
	public  SaleSlipFormManage(){
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
		
		SaleSlipForm temp= new SaleSlipForm((SaleSlipFormPO)c);
		
		return temp.toVO();
	}

	public boolean addForm(FormVO toPush) {
		SaleSlipForm temp= new SaleSlipForm((SaleExportFormVO)toPush);
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
		SaleSlipForm temp= new SaleSlipForm((SaleExportFormVO)toPush);
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
			out.add(new SaleSlipForm((SaleSlipFormPO)a).toVO()  );
		}
		
		return out;
	}
	public boolean passForm(String id)  {
		SaleSlipForm  temp= new SaleSlipForm((SaleExportFormVO)getForm(id));
		temp.pass();
		editForm(temp.toVO());
		return true;
		
	}
}
