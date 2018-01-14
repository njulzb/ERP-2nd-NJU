package BL.receiptBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import BL.messageBL.MessageController;
import DataService.receiptDataService.FormDataService;
import RMI.ClientRunner;
import po.KeyForSearchForm;
import po.formPO.FormPO;
import vo.MessageVO;
import vo.Form.FormVO;

/**
 * formcontroller 某些方法的具体实施者
 * @author lzb
 *
 */
public class FormManage {
	FormDataService rmi = ClientRunner.getInstance().getFormDataService();

	/**
	 * 根据单据搜索关键字搜索所有单据
	 * @param key
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<FormVO> searchAll(KeyForSearchForm key) throws RemoteException {
		ArrayList<FormVO> voList = new ArrayList<FormVO>();
		ArrayList<FormPO> poList = rmi.searchForm(key);
		poList = rmi.searchForm(key);

		for (FormPO po : poList) {
			voList.add(FormFactory.createVO(po));
		}

		return voList;

	}
	

	/**
	 * 审批通过单据
	 * @param vo
	 * @throws RemoteException
	 */
	public void passForm(FormVO vo) throws RemoteException {
		
		
		Form temp = FormFactory.VOtoForm(vo);
		temp.pass();
		
		try {
			new  MessageController().addMessage(new MessageVO("你制定的"+vo.getID()+"已经通过审批！",vo.getOperator().getID()));
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		rmi.editForm(temp.toPO());
	}

}


