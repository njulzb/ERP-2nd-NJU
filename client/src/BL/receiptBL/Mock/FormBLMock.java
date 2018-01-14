package BL.receiptBL.Mock;

import java.util.ArrayList;
import java.util.Collection;

import BL.receiptBL.Form;
import utility.StateOfForm;
import vo.UserVO;
import vo.Form.FormVO;

public class FormBLMock extends Form{
	public FormVO getForm(String id) {
		// TODO 自动生成的方法存根
		FormVO a=new FormVO(new UserVO("ddw", "mike", "F",null), "FHE-20171111-42225", null, null);
		
		return a;
	}
	public boolean addForm(FormVO toPush) {
		// TODO 自动生成的方法存根
		return true;
	}
	public boolean admitForm(FormVO toBeAdmitted) {
		// TODO 自动生成的方法存根
		return true;
	}
	public boolean modifyForm(FormVO toPush) {
		// TODO 自动生成的方法存根
		return true;
	}
	public boolean changeState(FormVO form, StateOfForm newState) {
		// TODO 自动生成的方法存根
		return true;
	}
	
	@SuppressWarnings("unchecked")
	
	public ArrayList<FormVO> searchForm(FormVO toPush) {
		// TODO 自动生成的方法存根
		return new ArrayList<FormVO>((Collection<? extends FormVO>) new FormVO(new UserVO("ddw", "mike", "F",null), "FHE-20171111-42225", null, null));
	}


}
