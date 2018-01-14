package BLService.receiptBLService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.KeyForSearchForm;
import vo.Form.FormVO;

/**
 * @author LZB   _edit_on_2017.10.21
 *
 */
public interface FormBLService {
	
	public FormVO getForm(String id)throws RemoteException ;
	public boolean addForm(FormVO toPush)throws RemoteException ;
	public boolean editForm(FormVO toPush)throws RemoteException ;
	public boolean deleteForm(String id)throws RemoteException ;
	public ArrayList<FormVO> searchForm(KeyForSearchForm key)throws RemoteException  ;
	public boolean passForm(String id) throws RemoteException ;
}
