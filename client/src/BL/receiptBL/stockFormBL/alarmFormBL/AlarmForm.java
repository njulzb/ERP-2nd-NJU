package BL.receiptBL.stockFormBL.alarmFormBL;

import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.ArrayList;

import BL.accountBL.AccountController;
import BL.accountBL.AccountInfo;
import BL.customerBL.CustomerController;
import BL.customerBL.CustomerInfo;
import BL.receiptBL.FinanceFormBL.FinanceForm;
import BL.receiptBL.FinanceFormBL.TransItem;
import BL.receiptBL.stockFormBL.StockForm;
import BL.receiptBL.stockFormBL.StockItem;
import BL.userBL.UserController;
import BL.userBL.UserInfo;
import po.formPO.stockFormPO.AlarmFormPO;
import po.formPO.stockFormPO.StockItemPO;
import utility.FileHelper;
import utility.StateOfForm;
import vo.Form.stockFormVO.AlarmFormVO;
import vo.Form.stockFormVO.StockItemVO;


public class AlarmForm  extends StockForm {
	private UserInfo uc=new UserController();
	private CustomerInfo cc=new CustomerController();
	public static void main(String args[]) {
		
		AlarmForm  tt =new AlarmForm ();
//		
//		tt.setID("sd");
//		StockItem e=new StockItem();
//		e.setComment("fefg");
//		e.setPresentNum(100);
//		tt.setState(StateOfForm.admitted);
//		tt.getList().add(e);
//		
		
		AlarmFormController controller =new 	AlarmFormController ();
		;
		AlarmFormVO g =(AlarmFormVO) controller.getForm("BJD-20171229-00001");
		String d= g.getGoodsList().get(0).getComment();
		System.out.println(d);
		
	}
	
	public AlarmForm(AlarmFormVO vo) {
		
		this.setPassTime(vo.getPassTime());;
		this.setRejectTime(vo.getRejectTime());
		this.setSubmitTime(vo.getSubmitTime());
		this.setSaveTime(vo.getSaveTime());
		this.setState(vo.getState());
		this.setID(vo.getID());
		this.setOperator(vo.getOperator());
		
		this.setSumMoney(vo.getSum());
		
		
		for(StockItemVO v :vo.getGoodsList()) {
			this.getList().add(new StockItem(v));
		}
		
	}
	public AlarmForm(AlarmFormPO po) {
		Timestamp v=	po.getCreateTime();
		this.setCreateTime(v);
		this.setPassTime(po.getPassTime());;
		this.setRejectTime(po.getRejectTime());
		this.setSubmitTime(po.getSubmitTime());
		this.setSaveTime(po.getSaveTime());
		this.setState(po.getState());
		this.setID(po.getID());
		this.setSumMoney(po.getSumMoney());
		
		try {
			this.setOperator(uc.getUserByID(po.getOperatorID()).toVO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		ArrayList<StockItemPO> poList =   (ArrayList<StockItemPO> )FileHelper.toObject(po.getByte_list())     ;                

		for(StockItemPO p:poList) {
			this.getList().add(new StockItem(p));
		}
		
		
		
	}
	public AlarmForm() {
		
	}
	public AlarmFormVO toVO() {
		AlarmFormVO out =new AlarmFormVO ();
		
		
		out.setCreateTime(this.getCreateTime());
		out.setPassTime(this.getPassTime());;
		out.setRejectTime(this.getRejectTime());
		out.setSubmitTime(this.getSubmitTime());
		out.setSaveTime(this.getSaveTime());
		out.setState(this.getState());
		out.setID(this.getID());
		out.setOperator(this.getOperator());
		out.setSum(this.getSumMoney());
		
		for(StockItem v :this.getList()) {
			out.getGoodsList().add(v.toVO());
		}
		
		
		
		return out;
	
		
		
	}
	
	public AlarmFormPO toPO() {
		
		AlarmFormPO out =new AlarmFormPO() ;
	
		
		out.setCreateTime(this.getCreateTime());
		out.setPassTime(this.getPassTime());;
		out.setRejectTime(this.getRejectTime());
		out.setSubmitTime(this.getSubmitTime());
		out.setSaveTime(this.getSaveTime());
		out.setState(this.getState());
		out.setID(this.getID());
		out.setOperatorID(this.getOperator().getID());
		out.setSumMoney(this.getSumMoney());
		
		
		ArrayList<StockItemPO> poList = new ArrayList<StockItemPO>();
		for(StockItem p : this.getList()) {
			poList.add(p.toPO());
		}
		
		
		out.setByte_list(FileHelper.toByteArray(poList));
		
		return out;   
		
	}
	public boolean pass() {
		this.state = StateOfForm.pass;
		this.passTime = new Timestamp(System.currentTimeMillis());
		return true;
		
	}
}
