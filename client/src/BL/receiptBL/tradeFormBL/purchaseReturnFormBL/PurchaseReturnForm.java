package BL.receiptBL.tradeFormBL.purchaseReturnFormBL;

import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.ArrayList;

import BL.customerBL.Customer;
import BL.customerBL.CustomerController;
import BL.receiptBL.stockFormBL.StockItem;
import BL.receiptBL.tradeFormBL.TradeForm;
import BL.receiptBL.tradeFormBL.TradeItem;
import BL.stockBL.Goods;
import BL.stockBL.StockController;
import BL.stockBL.Info.StockInfo;
import BL.userBL.UserController;
import po.formPO.FormPO;
import po.formPO.stockFormPO.LossFormPO;
import po.formPO.tradeFormPO.PurchaseReturnFormPO;
import po.formPO.tradeFormPO.TradeItemPO;
import utility.FileHelper;
import utility.StateOfForm;
import vo.Form.FormVO;
import vo.Form.stockFormVO.LossFormVO;
import vo.Form.stockFormVO.StockItemVO;
import vo.Form.tradeFormVO.PurchaseReturnFormVO;
import vo.Form.tradeFormVO.TradeItemVO;

public class PurchaseReturnForm extends TradeForm {
	
	
	public static void main (String args[]) {
		
		
		PurchaseReturnFormController uo= new 	PurchaseReturnFormController ();
		
		PurchaseReturnForm o=new 	PurchaseReturnForm();
		o.setSumMoney(1000);
		try {
			uo.addForm(o.toVO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
	public PurchaseReturnForm() {
		
	}
	
	
	
	public PurchaseReturnForm(PurchaseReturnFormVO vo) {
		this.setCustomer(new Customer(vo.getCustomer()));
		this.setPassTime(vo.getPassTime());;
		this.setRejectTime(vo.getRejectTime());
		this.setSubmitTime(vo.getSubmitTime());
		this.setSaveTime(vo.getSaveTime());
		this.setState(vo.getState());
		this.setID(vo.getID());
		this.setOperator(vo.getOperator());
		this.setSumMoney(vo.getSumMoney());
		this.setWarehouse(vo.getWarehouse());
		this.setComment(vo.getComment());
		for(TradeItemVO v :vo.getGoodsList()) {
			this.getGoodsList().add( new TradeItem(v));
		}
	}
	public PurchaseReturnForm(PurchaseReturnFormPO po) {
		
		this.setCustomer(new CustomerController().getCustomerByID(po.getCustomerID()));
		this.setPassTime(po.getPassTime());;
		this.setRejectTime(po.getRejectTime());
		this.setSubmitTime(po.getSubmitTime());
		this.setSaveTime(po.getSaveTime());
		this.setState(po.getState());
		this.setID(po.getID());
		try {
			this.setOperator(new UserController().getUserByID(po.getOperatorID()).toVO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		this.setSumMoney(po.getSumMoney());
		this.setWarehouse(po.getWarehouse());
		this.setComment(po.getComment());
		
		ArrayList <TradeItemPO >  inr =(ArrayList <TradeItemPO >)FileHelper.toObject(po.getGoodsList())     ;       
	
		for(TradeItemPO v :inr) {
			this.getGoodsList().add( new TradeItem(v));
		}
	}
	
	public PurchaseReturnFormVO toVO() {
		PurchaseReturnFormVO out =new PurchaseReturnFormVO();
		
		out.setCustomer(this.getCustomer().toCsutomerVO());
		out.setPassTime(this.getPassTime());;
		out.setRejectTime(this.getRejectTime());
		out.setSubmitTime(this.getSubmitTime());
		out.setSaveTime(this.getSaveTime());
		out.setState(this.getState());
		out.setID(this.getID());
		out.setOperator(this.getOperator());
		out.setSumMoney(this.getSumMoney());
		out.setWarehouse(this.getWarehouse());
		out.setComment(this.getComment());
		for(TradeItem v :this.getGoodsList()) {
			out.getGoodsList().add( v.toVO());
		}
		
		
		return out;
		
	}
	public PurchaseReturnFormPO toPO() {
		PurchaseReturnFormPO out =new PurchaseReturnFormPO();
		
		out.setCustomerID(this.getCustomer().getId());
		out.setPassTime(this.getPassTime());;
		out.setRejectTime(this.getRejectTime());
		out.setSubmitTime(this.getSubmitTime());
		out.setSaveTime(this.getSaveTime());
		out.setState(this.getState());
		out.setID(this.getID());
		out.setOperatorID(this.getOperator().getID());
		out.setSumMoney(this.getSumMoney());
		out.setWarehouse(this.getWarehouse());
		out.setComment(this.getComment());
		
		ArrayList<TradeItemPO>  inr =new ArrayList<TradeItemPO>();
		for(TradeItem v :this.getGoodsList()) {
			inr.add( v.toPO());
		}
		
		out.setGoodsList(FileHelper.toByteArray(inr));  ;       
		
		return out;
		
	}
	public boolean pass() {
		this.state=StateOfForm.pass;
		this.setPassTime(new Timestamp(System.currentTimeMillis()));
		StockInfo st =new StockController();
		ArrayList<Goods> goodsList=new 	ArrayList<Goods>();
		for(TradeItem c:getGoodsList()) {
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
