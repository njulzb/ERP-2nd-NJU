package BL.receiptBL.tradeFormBL.saleReturnFormBL;

import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.ArrayList;

import BL.customerBL.Customer;
import BL.customerBL.CustomerController;
import BL.receiptBL.tradeFormBL.TradeForm;
import BL.receiptBL.tradeFormBL.TradeItem;
import BL.stockBL.Goods;
import BL.stockBL.StockController;
import BL.stockBL.Info.StockInfo;
import BL.userBL.UserController;
import po.formPO.FormPO;
import po.formPO.stockFormPO.LossFormPO;
import po.formPO.tradeFormPO.PurchaseFormPO;
import po.formPO.tradeFormPO.PurchaseReturnFormPO;
import po.formPO.tradeFormPO.SaleReturnFormPO;
import po.formPO.tradeFormPO.SaleSlipFormPO;
import po.formPO.tradeFormPO.TradeItemPO;
import utility.FileHelper;
import utility.StateOfForm;
import vo.Form.FormVO;
import vo.Form.stockFormVO.LossFormVO;
import vo.Form.tradeFormVO.PurchaseFormVO;
import vo.Form.tradeFormVO.PurchaseReturnFormVO;
import vo.Form.tradeFormVO.SaleExportFormVO;
import vo.Form.tradeFormVO.SaleReturnFormVO;
import vo.Form.tradeFormVO.TradeItemVO;

public class SaleReturnForm extends TradeForm {


	public SaleReturnForm(SaleReturnFormVO vo) {
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
		this.setMoneyDaiJinQuan(vo.getMoneyDaiJinQuan());
		this.setMoneyStrategy(vo.getMoneyStrategy());
		this.setMoneyZheRang(vo.getMoneyZheRang());
		for(TradeItemVO v :vo.getGoodsList()) {
			this.getGoodsList().add( new TradeItem(v));
		}
		for(TradeItemVO v :vo.getGiftList()) {
			this.getGiftList().add( new TradeItem(v));
		}
	}
	public SaleReturnForm(SaleReturnFormPO po) {
		
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
		this.setMoneyDaiJinQuan(po.getMoneyDaiJinQuan());
		this.setMoneyStrategy(po.getMoneyStrategy());
		this.setMoneyZheRang(po.getMoneyZheRang());
		ArrayList <TradeItemPO >  inr =(ArrayList <TradeItemPO >)FileHelper.toObject(po.getGoodsList())     ;       
		for(TradeItemPO v :inr) {
			this.getGoodsList().add( new TradeItem(v));
		}
		
		
		ArrayList <TradeItemPO >  in3r =(ArrayList <TradeItemPO >)FileHelper.toObject(po.getGiftList())     ;       
		for(TradeItemPO v :in3r) {
			this.getGiftList().add( new TradeItem(v));
		}
		
		
	}
	
	public SaleExportFormVO toVO() {
		SaleExportFormVO out =new SaleExportFormVO();
		
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
		out.setMoneyDaiJinQuan(this.getMoneyDaiJinQuan());
		out.setMoneyStrategy(this.getMoneyStrategy());
		out.setMoneyZheRang(this.getMoneyZheRang());
		
		
		
		for(TradeItem v :this.getGoodsList()) {
			out.getGoodsList().add( v.toVO());
		}
		for(TradeItem v :this.getGiftList()) {
			out.getGiftList().add( v.toVO());
		}
		
		return out;
		
	}
	public SaleReturnFormPO toPO() {
		SaleReturnFormPO out =new SaleReturnFormPO();
		
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
		out.setMoneyDaiJinQuan(this.getMoneyDaiJinQuan());
		out.setMoneyStrategy(this.getMoneyStrategy());
		out.setMoneyZheRang(this.getMoneyZheRang());
		
		ArrayList<TradeItemPO>  inr =new ArrayList<TradeItemPO>();
		for(TradeItem v :this.getGoodsList()) {
			inr.add( v.toPO());
		}
		out.setGoodsList(FileHelper.toByteArray(inr));  ;   
		
		
		
		ArrayList<TradeItemPO>  in3r =new ArrayList<TradeItemPO>();
		for(TradeItem v :this.getGiftList()) {
			in3r.add( v.toPO());
		}
		out.setGiftList(FileHelper.toByteArray(in3r));
		
		    
		
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
			st.importGoods(goodsList);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
}
