package BL.receiptBL.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import BLService.receiptBLService.FormBLService;
import po.KeyForSearchForm;
import vo.Form.FormVO;

public class FormBLStub implements FormBLService{
	public ArrayList<FormVO> list=new ArrayList <FormVO>(); 
	
	
	@Override
	public FormVO getForm(String id) {
		for( FormVO c :list) {
			if(c.getID()==id) {
				return c;
			}
		}
		
		return null;
	}

	@Override
	public boolean addForm(FormVO toPush) {
		list.add(toPush);
		return true;
	}

	@Override
	public boolean editForm(FormVO toPush) throws RemoteException {
		for( FormVO c :list) {
			if(c.getID()==toPush.getID()) {
				list.remove(c);
				list.add(toPush);
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean deleteForm(String id) throws RemoteException {
		for( FormVO c :list) {
			if(c.getID()==id) {
				list.remove(c);
			}
		}
		
		return false;
	}

	
	@Override
	public ArrayList<FormVO> searchForm(KeyForSearchForm key) throws RemoteException {
		return null;
	}

	@Override
	public boolean passForm(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

}
