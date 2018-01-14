package BL.receiptBL.stockFormBL.lossFormBL;

import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.ArrayList;

import BL.accountBL.AccountController;
import BL.accountBL.AccountInfo;
import BL.customerBL.CustomerController;
import BL.customerBL.CustomerInfo;
import BL.receiptBL.stockFormBL.StockForm;
import BL.receiptBL.stockFormBL.StockItem;
import BL.stockBL.Goods;
import BL.stockBL.StockController;
import BL.stockBL.Info.StockInfo;
import BL.userBL.UserController;
import BL.userBL.UserInfo;
import po.formPO.stockFormPO.LossFormPO;
import po.formPO.stockFormPO.StockItemPO;
import utility.FileHelper;
import utility.StateOfForm;
import vo.Form.stockFormVO.LossFormVO;
import vo.Form.stockFormVO.StockItemVO;

public class LossForm extends StockForm {
	private UserInfo uc=new UserController();
	private CustomerInfo cc=new CustomerController();
	public static void main(String args[]) {
		
		LossForm  tt =new LossForm ();
		
		tt.setID("srd");
		StockItem e=new StockItem();
		tt.setCreateTime(new Timestamp(System.currentTimeMillis()));
		e.setComment("fefg");
		e.setPresentNum(100);
		tt.setState(StateOfForm.admitted);
		tt.getList().add(e);
		
		
		
		LossFormController controller =new 	LossFormController ();
		System.out.println(controller.addForm(tt.toVO())) ;
		;
//		LossFormVO g =(LossFormVO) controller.getForm("BJD-20171229-00001");
//		String d= g.getGoodsList().get(0).getComment();
//		System.out.println(d);
		
	}
	
	public LossForm(LossFormVO vo) {
		
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
	public LossForm(LossFormPO po) {
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
	public LossForm() {
		
	}
	public LossFormVO toVO() {
		LossFormVO out =new LossFormVO ();
		
		
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
	
	public LossFormPO toPO() {
		
		LossFormPO out =new LossFormPO() ;
	
		
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
		this.state=StateOfForm.pass;
		this.setPassTime(new Timestamp(System.currentTimeMillis()));
		StockInfo st =new StockController();
		ArrayList<Goods> goodsList=new 	ArrayList<Goods>();
		for(StockItem c:getList()) {
			c.getGoods().setNumbers(c.getSystemNum()-c.getRealNum());
			goodsList.add(c.getGoods());
		}
		try {
			st.exportGoods(goodsList);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
