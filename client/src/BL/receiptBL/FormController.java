package BL.receiptBL;

import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import BL.messageBL.MessageController;
import BL.receiptBL.FinanceFormBL.cashFormBL.CashFormController;
import BL.receiptBL.FinanceFormBL.payFormBL.PayFormController;
import BL.receiptBL.FinanceFormBL.receiptFormBL.ReceiptFormController;
import BL.receiptBL.stockFormBL.alarmFormBL.AlarmFormController;
import BL.receiptBL.stockFormBL.lossFormBL.LossFormController;
import BL.receiptBL.stockFormBL.overFlowFormBl.OverFlowFormController;
import BL.receiptBL.stockFormBL.presentFormBL.PresentFormController;
import BL.receiptBL.tradeFormBL.TradeItem;
import BL.receiptBL.tradeFormBL.purchaseFormBL.PurchaseForm;
import BL.receiptBL.tradeFormBL.purchaseFormBL.PurchaseFormController;
import BL.receiptBL.tradeFormBL.purchaseReturnFormBL.PurchaseReturnForm;
import BL.receiptBL.tradeFormBL.purchaseReturnFormBL.PurchaseReturnFormController;
import BL.receiptBL.tradeFormBL.saleReturnFormBL.SaleReturnFormController;
import BL.receiptBL.tradeFormBL.saleSlipFormBL.SaleSlipForm;
import BL.receiptBL.tradeFormBL.saleSlipFormBL.SaleSlipFormController;
import BL.stockBL.Goods;
import BL.stockBL.Info.FormQueryInfoForStock;
import BLService.receiptBLService.FormBLService;
import DataService.receiptDataService.FormDataService;
import RMI.ClientRunner;
import po.KeyForSearchForm;
import po.formPO.FormPO;
import po.formPO.tradeFormPO.PurchaseFormPO;
import po.formPO.tradeFormPO.PurchaseReturnFormPO;
import po.formPO.tradeFormPO.SaleSlipFormPO;
import utility.StateOfForm;
import utility.TimeHelper;
import vo.MessageVO;
import vo.Form.FormVO;
import vo.Form.FinanceFormVO.CashFormVO;
import vo.Form.FinanceFormVO.PayFormVO;
import vo.Form.FinanceFormVO.ReceiptFormVO;
import vo.Form.stockFormVO.OverFlowFormVO;
import vo.Form.stockFormVO.PresentFormVO;
import vo.Form.tradeFormVO.PurchaseFormVO;
import vo.Form.tradeFormVO.PurchaseReturnFormVO;
import vo.Form.tradeFormVO.SaleExportFormVO;
import vo.Form.tradeFormVO.SaleReturnFormVO;
/**
 * 这是form模块总的controller，控制整个模块对外交互，和对内的任务分派
 * @author lzb
 *
 */
public class FormController implements FormBLService, FormInfo, FormQueryInfoForStock {
	FormVO toPush = null;
	FormManage manage = new FormManage();
	FormDataService rmi = ClientRunner.getInstance().getFormDataService();

	/**
	 * 掌握的下级的子单据的controller
	 */
	CashFormController cashFormController = new CashFormController();
	PayFormController payFormController = new PayFormController();
	ReceiptFormController receiptFormController = new ReceiptFormController();

	AlarmFormController alarmFormController = new AlarmFormController();
	LossFormController lossFormController = new LossFormController();
	OverFlowFormController overFlowFormController = new OverFlowFormController();
	PresentFormController presentFormController = new PresentFormController();

	PurchaseFormController purchaseFormController = new PurchaseFormController();
	PurchaseReturnFormController purchaseReturnFormController = new PurchaseReturnFormController();
	SaleSlipFormController saleSlipFormController = new SaleSlipFormController();
	SaleReturnFormController saleReturnFormController = new SaleReturnFormController();

	@Override
	/**
	 * 根据单据id搜索单据
	 */
	public FormVO getForm(String id) throws RemoteException {

		if (id.length() < 3) {
			return null;
		} else if (id.substring(0, 3).equals("SKD")) {
			return receiptFormController.getForm(id);
		} else if (id.substring(0, 3).equals("FKD")) {
			return payFormController.getForm(id);
		} else if (id.substring(0, 5).equals("XJFYD")) {
			return cashFormController.getForm(id);
		} else if (id.substring(0, 3).equals("BYD")) {
			return overFlowFormController.getForm(id);
		} else if (id.substring(0, 3).equals("BSD")) {
			return lossFormController.getForm(id);
		} else if (id.substring(0, 3).equals("ZSD")) {
			return presentFormController.getForm(id);
		} else if (id.substring(0, 3).equals("XSD")) {
			return saleSlipFormController.getForm(id);
		} else if (id.substring(0, 5).equals("XSTHD")) {
			return saleReturnFormController.getForm(id);
		} else if (id.substring(0, 3).equals("JHD")) {
			return purchaseFormController.getForm(id);
		} else if (id.substring(0, 5).equals("JHTHD")) {
			return purchaseReturnFormController.getForm(id);
		} else {
			return null;
		}
	}

	@Override
	/**
	 * 根据id删除单据
	 */
	public boolean deleteForm(String id) throws RemoteException {
		if (id.length() < 3) {
			return false;
		} else if (id.substring(0, 3).equals("SKD")) {
			return receiptFormController.deleteForm(id);
		} else if (id.substring(0, 3).equals("FKD")) {
			return payFormController.deleteForm(id);
		} else if (id.substring(0, 5).equals("XJFYD")) {
			return cashFormController.deleteForm(id);
		} else if (id.substring(0, 3).equals("BYD")) {
			return overFlowFormController.deleteForm(id);
		} else if (id.substring(0, 3).equals("BSD")) {
			return lossFormController.deleteForm(id);
		} else if (id.substring(0, 3).equals("ZSD")) {
			return presentFormController.deleteForm(id);
		} else if (id.substring(0, 3).equals("XSD")) {
			return saleSlipFormController.deleteForm(id);
		} else if (id.substring(0, 5).equals("XSTHD")) {
			return saleReturnFormController.deleteForm(id);
		} else if (id.substring(0, 3).equals("JHD")) {
			return purchaseFormController.deleteForm(id);
		} else if (id.substring(0, 5).equals("JHTHD")) {
			return purchaseReturnFormController.deleteForm(id);
		} else {
			return false;
		}
	}

	@Override
	/**
	 * 新增单据
	 */
	public boolean addForm(FormVO toPush) throws RemoteException {
		if (toPush instanceof ReceiptFormVO) {
			return receiptFormController.addForm(toPush);
		} else if (toPush instanceof PayFormVO) {
			return payFormController.addForm(toPush);
		} else if (toPush instanceof CashFormVO) {
			return cashFormController.addForm(toPush);
		} else if (toPush instanceof OverFlowFormVO) {
			return overFlowFormController.addForm(toPush);
		} else if (toPush instanceof ReceiptFormVO) {
			return lossFormController.addForm(toPush);
		} else if (toPush instanceof PresentFormVO) {
			return presentFormController.addForm(toPush);
		} else if (toPush instanceof SaleExportFormVO) {
			return saleSlipFormController.addForm(toPush);
		} else if (toPush instanceof SaleReturnFormVO) {
			return saleReturnFormController.addForm(toPush);
		} else if (toPush instanceof PurchaseFormVO) {
			return purchaseFormController.addForm(toPush);
		} else if (toPush instanceof PurchaseReturnFormVO) {
			return purchaseReturnFormController.addForm(toPush);
		} else {
			return false;
		}
	}

	@Override
	/**
	 * 修改单据
	 */
	public boolean editForm(FormVO toPush) throws RemoteException {
		if (toPush instanceof ReceiptFormVO) {
			return receiptFormController.editForm(toPush);
		} else if (toPush instanceof PayFormVO) {
			return payFormController.editForm(toPush);
		} else if (toPush instanceof CashFormVO) {
			return cashFormController.editForm(toPush);
		} else if (toPush instanceof OverFlowFormVO) {
			return overFlowFormController.editForm(toPush);
		} else if (toPush instanceof ReceiptFormVO) {
			return lossFormController.editForm(toPush);
		} else if (toPush instanceof PresentFormVO) {
			return presentFormController.editForm(toPush);
		} else if (toPush instanceof SaleExportFormVO) {
			return saleSlipFormController.editForm(toPush);
		} else if (toPush instanceof SaleReturnFormVO) {
			return saleReturnFormController.editForm(toPush);
		} else if (toPush instanceof PurchaseFormVO) {
			return purchaseFormController.editForm(toPush);
		} else if (toPush instanceof PurchaseReturnFormVO) {
			return purchaseReturnFormController.editForm(toPush);
		} else {
			return false;
		}
	}

	@Override
	/**
	 * 根据单据的搜索关键字搜索单据，返回满足条件的一系列单据
	 */
	public ArrayList<FormVO> searchForm(KeyForSearchForm toPush) throws RemoteException {
		if (toPush.getKindOfForm() == null) {
			return manage.searchAll(toPush);
		}
		return null;
	}
	@Override
	public boolean passForm(String id) throws RemoteException {
		
		return false;
	}

	@Override
	/**
	 * 得到所有进货单据
	 */
	public ArrayList<Goods> getImport(Date begin, Date end) {
		ArrayList<Goods> out = new ArrayList<Goods>();
		KeyForSearchForm key = new KeyForSearchForm();
		key.setID("JHD");
		key.setPassTimeMin(TimeHelper.dateToTimestamp(begin));
		key.setPassTimeMax(TimeHelper.dateToTimestamp(end));
		try {
			ArrayList<FormPO> tp = rmi.searchForm(key);
			for (FormPO d : tp) {

				for (TradeItem c : new PurchaseForm((PurchaseFormPO) d).getGoodsList()) {
					out.add(c.getGoods());
				}

			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		key.setID("XSTHD");
		key.setPassTimeMin(TimeHelper.dateToTimestamp(begin));
		key.setPassTimeMax(TimeHelper.dateToTimestamp(end));
		try {
			ArrayList<FormPO> tp = rmi.searchForm(key);
			for (FormPO d : tp) {

				for (TradeItem c : new PurchaseForm((PurchaseFormPO) d).getGoodsList()) {
					out.add(c.getGoods());
				}

			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return out;
		
		
	}

	@Override
	/**
	 * 得到所有出货单据
	 */
	public ArrayList<Goods> getExport(Date begin, Date end) {
		ArrayList<Goods> out = new ArrayList<Goods>();
		KeyForSearchForm key = new KeyForSearchForm();
		key.setID("XSD");
		key.setPassTimeMin(TimeHelper.dateToTimestamp(begin));
		key.setPassTimeMax(TimeHelper.dateToTimestamp(end));
		try {
			ArrayList<FormPO> tp = rmi.searchForm(key);
			for (FormPO d : tp) {

				for (TradeItem c : new SaleSlipForm((SaleSlipFormPO) d).getGoodsList()) {
					out.add(c.getGoods());
				}

			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		key.setID("JHTHD");
		key.setPassTimeMin(TimeHelper.dateToTimestamp(begin));
		key.setPassTimeMax(TimeHelper.dateToTimestamp(end));
		try {
			ArrayList<FormPO> tp = rmi.searchForm(key);
			for (FormPO d : tp) {

				for (TradeItem c : new PurchaseReturnForm((PurchaseReturnFormPO) d).getGoodsList()) {
					out.add(c.getGoods());
				}

			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return out;
	}

	@Override
	/**
	 * 得到所有销售进货单据
	 */
	public ArrayList<Goods> getBuyIn(Date begin, Date end) {
		ArrayList<Goods> out = new ArrayList<Goods>();
		KeyForSearchForm key = new KeyForSearchForm();
		key.setID("JHD");
		key.setPassTimeMin(TimeHelper.dateToTimestamp(begin));
		key.setPassTimeMax(TimeHelper.dateToTimestamp(end));
		try {
			ArrayList<FormPO> tp = rmi.searchForm(key);
			for (FormPO d : tp) {

				for (TradeItem c : new PurchaseForm((PurchaseFormPO) d).getGoodsList()) {
					out.add(c.getGoods());
				}

			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return out;
	}

	@Override
	/**
	 * 得到所有销售出货单据
	 */
	public ArrayList<Goods> getSaleOut(Date begin, Date end) {
		ArrayList<Goods> out = new ArrayList<Goods>();
		KeyForSearchForm key = new KeyForSearchForm();
		key.setID("XSD");
		key.setPassTimeMin(TimeHelper.dateToTimestamp(begin));
		key.setPassTimeMax(TimeHelper.dateToTimestamp(end));
		try {
			ArrayList<FormPO> tp = rmi.searchForm(key);
			for (FormPO d : tp) {

				for (TradeItem c : new SaleSlipForm((SaleSlipFormPO) d).getGoodsList()) {
					out.add(c.getGoods());
				}

			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		return out;
	}

	/**
	 * 审批通过单据
	 * @param vo
	 * @throws RemoteException
	 */
	public void passForm(FormVO vo) throws RemoteException {
		// TODO 自动生成的方法存根
	
		manage.passForm(vo);
	}
	

	/**
	 * 提交单据
	 * @param vo
	 * @throws RemoteException
	 */
	public void submitForm(FormVO vo) throws RemoteException {
		if (vo.getID() == null||vo.getID().length()<10) {
			addForm(vo);
		}
		vo.setState(StateOfForm.admitted);
		
		vo.setSubmitTime(new Timestamp(System.currentTimeMillis()));
		editForm(vo);
	}

	/**
	 * 驳回单据
	 * @param vo
	 * @throws RemoteException
	 */
	public void rejectForm(FormVO vo) throws RemoteException {
		vo.setState(StateOfForm.rejected);
		vo.setRejectTime(new Timestamp(System.currentTimeMillis()));
		editForm(vo);
	}

}
