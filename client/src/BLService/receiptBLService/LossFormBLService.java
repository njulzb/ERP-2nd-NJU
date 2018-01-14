package BLService.receiptBLService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.KeyForSearchForm;
import vo.Form.FormVO;

public interface LossFormBLService {
	public FormVO getForm(String id)throws RemoteException ;
	public boolean addForm(FormVO toPush)throws RemoteException ;
	public boolean editForm(FormVO toPush)throws RemoteException ;
	public boolean deleteForm(String id)throws RemoteException ;
	public ArrayList<FormVO> searchForm(KeyForSearchForm key)throws RemoteException  ;
	public boolean passForm(String id) throws RemoteException ;
}
