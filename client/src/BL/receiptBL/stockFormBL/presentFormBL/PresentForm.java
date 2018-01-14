package BL.receiptBL.stockFormBL.presentFormBL;

import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.ArrayList;

import BL.customerBL.Customer;
import BL.customerBL.CustomerController;
import BL.customerBL.CustomerInfo;
import BL.receiptBL.stockFormBL.StockForm;
import BL.receiptBL.stockFormBL.StockItem;
import BL.stockBL.Goods;
import BL.stockBL.StockController;
import BL.stockBL.Info.StockInfo;
import BL.userBL.UserController;
import BL.userBL.UserInfo;
import po.formPO.stockFormPO.PresentFormPO;
import po.formPO.stockFormPO.StockItemPO;
import utility.FileHelper;
import utility.StateOfForm;
import vo.Form.stockFormVO.PresentFormVO;
import vo.Form.stockFormVO.StockItemVO;

public class PresentForm extends StockForm {
	private UserInfo uc=new UserController();
	private CustomerInfo cc=new CustomerController();
	public static void main(String args[]) {
		
	}
	
	public PresentForm(PresentFormVO vo) {
		this.setCustomer(new Customer(vo.getCustomer()));
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
	public PresentForm(PresentFormPO po) {
		Timestamp v=	po.getCreateTime();
		try {
			this.setCustomer( cc.getCustomerByID(po.getCustomerID()));
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
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
			e.printStackTrace();
		}

		ArrayList<StockItemPO> poList =   (ArrayList<StockItemPO> )FileHelper.toObject(po.getByte_list())     ;                

		for(StockItemPO p:poList) {
			this.getList().add(new StockItem(p));
		}
		
		
		
	}
	public PresentForm() {
		
	}
	public PresentFormVO toVO() {
		PresentFormVO out =new PresentFormVO ();
		
		out.setCustomer(this.getCustomer().toCsutomerVO());
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
	
	public PresentFormPO toPO() {
		
		PresentFormPO out =new PresentFormPO() ;
	
		out.setCustomerID(this.getCustomer().getId());
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
			c.getGoods().setNumbers(c.getPresentNum());
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
