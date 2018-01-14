package Data.receiptData;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Data.receiptData.financeFormData.cashFormData.CashFormDataController;
import Data.receiptData.financeFormData.payFormData.PayFormDataController;
import Data.receiptData.financeFormData.receiptFormData.ReceiptFormDataController;
import Data.receiptData.stockFormData.alarmFormData.AlarmFormController;
import Data.receiptData.stockFormData.lossFormData.LossFormController;
import Data.receiptData.stockFormData.overFlowFormData.OverFlowFormController;
import Data.receiptData.stockFormData.presentFormData.PresentFormController;
import Data.receiptData.tradeFormData.purchaseFormData.PurchaseFormController;
import Data.receiptData.tradeFormData.purchaseReturnFormData.PurchaseReturnFormController;
import Data.receiptData.tradeFormData.saleReturnFormBL.SaleReturnFormController;
import Data.receiptData.tradeFormData.saleSlipFormBL.SaleSlipFormController;
import DataService.receiptDataService.FormDataService;
import po.KeyForSearchForm;
import po.formPO.FormPO;
import po.formPO.financeFormPO.CashFormPO;
import po.formPO.financeFormPO.PayFormPO;
import po.formPO.financeFormPO.ReceiptFormPO;
import po.formPO.stockFormPO.AlarmFormPO;
import po.formPO.stockFormPO.LossFormPO;
import po.formPO.stockFormPO.OverFlowFormPO;
import po.formPO.stockFormPO.PresentFormPO;
import po.formPO.tradeFormPO.PurchaseFormPO;
import po.formPO.tradeFormPO.PurchaseReturnFormPO;
import po.formPO.tradeFormPO.SaleReturnFormPO;
import po.formPO.tradeFormPO.SaleSlipFormPO;

public class FormController implements FormDataService {
	FormPO toPush = null;

	CashFormDataController cashFormController = new CashFormDataController();
	PayFormDataController payFormController = new PayFormDataController();
	ReceiptFormDataController receiptFormController = new ReceiptFormDataController();

	LossFormController lossFormController = new LossFormController();
	OverFlowFormController overFlowFormController = new OverFlowFormController();
	PresentFormController presentFormController = new PresentFormController();
	AlarmFormController alarmFormController = new AlarmFormController();

	PurchaseFormController purchaseFormController = new PurchaseFormController();
	PurchaseReturnFormController purchaseReturnFormController = new PurchaseReturnFormController();
	SaleSlipFormController saleSlipFormController = new SaleSlipFormController();
	SaleReturnFormController saleReturnFormController = new SaleReturnFormController();

	@Override
	public FormPO getForm(String id) throws RemoteException {

		if (id.length() < 3) {
			return null;
		} else if (id.substring(0, 3).equals("SKD")) {
			return receiptFormController.getForm(id);
		} else if (id.substring(0, 3).equals("FKD")) {
			return payFormController.getForm(id);
		} else if (id.length() >= 5 && id.substring(0, 5).equals("XJFYD")) {
			return cashFormController.getForm(id);
		} else if (id.substring(0, 3).equals("BYD")) {
			return overFlowFormController.getForm(id);
		} else if (id.substring(0, 3).equals("BSD")) {
			return lossFormController.getForm(id);
		} else if (id.substring(0, 3).equals("ZSD")) {
			return presentFormController.getForm(id);
		} else if (id.substring(0, 3).equals("XSD")) {
			return saleSlipFormController.getForm(id);
		} else if (id.length() >= 5 && id.substring(0, 5).equals("XSTHD")) {
			return saleReturnFormController.getForm(id);
		} else if (id.substring(0, 3).equals("JHD")) {
			return purchaseFormController.getForm(id);
		} else if (id.substring(0, 3).equals("BJD")) {
			return alarmFormController.getForm(id);
		} else if (id.length() >= 5 && id.substring(0, 5).equals("JHTHD")) {
			return purchaseReturnFormController.getForm(id);
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteForm(String id) throws RemoteException {
		if (id.length() < 3) {
			return false;
		} else if (id.substring(0, 3).equals("SKD")) {
			return receiptFormController.deleteForm(id);
		} else if (id.substring(0, 3).equals("FKD")) {
			return payFormController.deleteForm(id);
		} else if (id.length() >= 5 && id.substring(0, 5).equals("XJFYD")) {
			return cashFormController.deleteForm(id);
		} else if (id.substring(0, 3).equals("BYD")) {
			return overFlowFormController.deleteForm(id);
		} else if (id.substring(0, 3).equals("BSD")) {
			return lossFormController.deleteForm(id);
		} else if (id.substring(0, 3).equals("ZSD")) {
			return presentFormController.deleteForm(id);
		} else if (id.substring(0, 3).equals("XSD")) {
			return saleSlipFormController.deleteForm(id);
		} else if (id.length() >= 5 && id.substring(0, 5).equals("XSTHD")) {
			return saleReturnFormController.deleteForm(id);
		} else if (id.substring(0, 3).equals("JHD")) {
			return purchaseFormController.deleteForm(id);
		} else if (id.substring(0, 3).equals("BJD")) {
			return alarmFormController.deleteForm(id);
		} else if (id.length() >= 5 && id.substring(0, 5).equals("JHTHD")) {
			return purchaseReturnFormController.deleteForm(id);
		} else {
			return false;
		}
	}

	@Override
	public boolean newForm(FormPO toPush) throws RemoteException {

		if (toPush instanceof ReceiptFormPO) {
			return receiptFormController.newForm(toPush);
		} else if (toPush instanceof PayFormPO) {
			return payFormController.newForm(toPush);
		} else if (toPush instanceof CashFormPO) {
			return cashFormController.newForm(toPush);
		} else if (toPush instanceof OverFlowFormPO) {
			return overFlowFormController.newForm(toPush);
		} else if (toPush instanceof ReceiptFormPO) {
			return lossFormController.newForm(toPush);
		} else if (toPush instanceof PresentFormPO) {
			return presentFormController.newForm(toPush);
		} else if (toPush instanceof SaleSlipFormPO) {
			return saleSlipFormController.newForm(toPush);
		} else if (toPush instanceof SaleReturnFormPO) {
			return saleReturnFormController.newForm(toPush);
		} else if (toPush instanceof PurchaseFormPO) {
			return purchaseFormController.newForm(toPush);
		} else if (toPush instanceof PurchaseReturnFormPO) {
			return purchaseReturnFormController.newForm(toPush);
		} else if (toPush instanceof AlarmFormPO) {
			return alarmFormController.newForm(toPush);
		} else if (toPush instanceof LossFormPO) {
			return lossFormController.newForm(toPush);
		} else {
			return false;
		}
	}

	@Override
	public boolean editForm(FormPO toPush) throws RemoteException {
		if (toPush instanceof ReceiptFormPO) {
			return receiptFormController.editForm(toPush);
		} else if (toPush instanceof PayFormPO) {
			return payFormController.editForm(toPush);
		} else if (toPush instanceof CashFormPO) {
			return cashFormController.editForm(toPush);
		} else if (toPush instanceof OverFlowFormPO) {
			return overFlowFormController.editForm(toPush);
		} else if (toPush instanceof ReceiptFormPO) {
			return lossFormController.editForm(toPush);
		} else if (toPush instanceof PresentFormPO) {
			return presentFormController.editForm(toPush);
		} else if (toPush instanceof SaleSlipFormPO) {
			return saleSlipFormController.editForm(toPush);
		} else if (toPush instanceof SaleReturnFormPO) {
			return saleReturnFormController.editForm(toPush);
		} else if (toPush instanceof PurchaseFormPO) {
			return purchaseFormController.editForm(toPush);
		} else if (toPush instanceof PurchaseReturnFormPO) {
			return purchaseFormController.editForm(toPush);
		} else if (toPush instanceof LossFormPO) {
			return lossFormController.editForm(toPush);
		} else if (toPush instanceof AlarmFormPO) {
			return alarmFormController.editForm(toPush);
		}

		else {
			return false;
		}
	}

	@Override
	public ArrayList<FormPO> searchForm(KeyForSearchForm toPush) throws RemoteException {
		 System.out.println("现在有人开始searchForm：key.id="+toPush.getID()+",key.kindOfForm="+toPush.getKindOfForm());;

		ArrayList<FormPO> out = new ArrayList<FormPO>();
		if (toPush.getID().length()>=3&& toPush.getID().equals("ALL") ) {
			System.out.println("正在search所有form");
			out.addAll(receiptFormController.searchForm(toPush));
			out.addAll(payFormController.searchForm(toPush));
			out.addAll(cashFormController.searchForm(toPush));
			out.addAll(alarmFormController.searchForm(toPush));
			out.addAll(lossFormController.searchForm(toPush));
			out.addAll(overFlowFormController.searchForm(toPush));
			out.addAll(this.presentFormController.searchForm(toPush));
			out.addAll(this.purchaseFormController.searchForm(toPush));
			out.addAll(this.purchaseReturnFormController.searchForm(toPush));
			out.addAll(this.saleSlipFormController.searchForm(toPush));
			out.addAll(this.saleReturnFormController.searchForm(toPush));
			return out;
	
		} else if (toPush.getID().length()>=3&&toPush.getID().substring(0, 3).equals("SKD")) {
			return receiptFormController.searchForm(toPush);
		} else if (toPush.getID().length()>=3&&toPush.getID().substring(0, 3).equals("FKD")) {
			return payFormController.searchForm(toPush);
		} else if (toPush.getID().length() >= 5 && toPush.getID().substring(0, 5).equals("XJFYD")) {
			return cashFormController.searchForm(toPush);
		} else if (toPush.getID().length()>=3&&toPush.getID().substring(0, 3).equals("BYD")) {
			return overFlowFormController.searchForm(toPush);
		} else if (toPush.getID().length()>=3&&toPush.getID().substring(0, 3).equals("BSD")) {
			return lossFormController.searchForm(toPush);
		} else if (toPush.getID().length()>=3&&toPush.getID().substring(0, 3).equals("ZSD")) {
			return presentFormController.searchForm(toPush);
		} else if (toPush.getID().length()>=3&&toPush.getID().substring(0, 3).equals("XSD")) {
			return saleSlipFormController.searchForm(toPush);
		} else if (toPush.getID().length() >= 5 && toPush.getID().substring(0, 5).equals("XSTHD")) {
			return saleReturnFormController.searchForm(toPush);
		} else if (toPush.getID().length()>=3&&toPush.getID().substring(0, 3).equals("JHD")) {
			return purchaseFormController.searchForm(toPush);
		} else if (toPush.getID().length()>=3&&toPush.getID().substring(0, 3).equals("BJD")) {
			return alarmFormController.searchForm(toPush);
		} else if (toPush.getID().length() >= 5 && toPush.getID().substring(0, 5).equals("JHTHD")) {
			return purchaseReturnFormController.searchForm(toPush);
		} else {
			return out ;
		}
	}

	public static void main(String args[]) {
		KeyForSearchForm key = new KeyForSearchForm();
		try {
			int i = new FormController().searchForm(key).size();
			System.out.println(i);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
