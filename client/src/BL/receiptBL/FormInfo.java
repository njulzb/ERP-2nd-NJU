package BL.receiptBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.KeyForSearchForm;
import vo.Form.FormVO;
/**
 * form模块提供给外部模块调用的接口
 * 提供根据关键字，id搜索的功能
 * @author lzb
 *
 */
public interface FormInfo {
	public ArrayList<FormVO> searchForm(KeyForSearchForm key) throws RemoteException  ;
	public FormVO getForm(String id) throws RemoteException ;
	
}
