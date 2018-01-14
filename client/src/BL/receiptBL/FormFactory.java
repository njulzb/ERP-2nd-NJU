package BL.receiptBL;

import BL.receiptBL.FinanceFormBL.cashFormBL.CashForm;
import BL.receiptBL.FinanceFormBL.payFormBL.PayForm;
import BL.receiptBL.FinanceFormBL.receiptFormBL.ReceiptForm;
import BL.receiptBL.stockFormBL.alarmFormBL.AlarmForm;
import BL.receiptBL.stockFormBL.lossFormBL.LossForm;
import BL.receiptBL.stockFormBL.overFlowFormBl.OverFlowForm;
import BL.receiptBL.stockFormBL.presentFormBL.PresentForm;
import BL.receiptBL.tradeFormBL.purchaseFormBL.PurchaseForm;
import BL.receiptBL.tradeFormBL.purchaseReturnFormBL.PurchaseReturnForm;
import BL.receiptBL.tradeFormBL.saleReturnFormBL.SaleReturnForm;
import BL.receiptBL.tradeFormBL.saleSlipFormBL.SaleSlipForm;
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
import utility.KindOfForm;
import vo.Form.FormVO;
import vo.Form.FinanceFormVO.CashFormVO;
import vo.Form.FinanceFormVO.PayFormVO;
import vo.Form.FinanceFormVO.ReceiptFormVO;
import vo.Form.stockFormVO.AlarmFormVO;
import vo.Form.stockFormVO.LossFormVO;
import vo.Form.stockFormVO.OverFlowFormVO;
import vo.Form.stockFormVO.PresentFormVO;
import vo.Form.tradeFormVO.PurchaseFormVO;
import vo.Form.tradeFormVO.PurchaseReturnFormVO;
import vo.Form.tradeFormVO.SaleExportFormVO;
import vo.Form.tradeFormVO.SaleReturnFormVO;

public class FormFactory {

	
	public static String toTitle(KindOfForm kind) {
		if (kind==KindOfForm.FinanceForm) {
			return "SKD";
		}
		if (kind==KindOfForm.PortForm) {
			return "JHD";
		}
		if (kind == KindOfForm.SalesForm) {
			return "XSD";
		}
		if (kind == KindOfForm.StockForm) {
			return "BYD";
		}
		return null;
	}
	
	
	public static String getTitle(String formID) {
		if(formID=="" ) {
			return "审批单据";
		}
		else if(formID=="SKD" ) {
			return "收款单";
		}
		else 	if(formID=="FKD" ) {
			return "付款单";
		}
		else 	if(formID=="XJFYD" ) {
			return "现金费用单";
		}
		else 	if(formID=="BJD" ) {
			return "报警单";
		}
		else 	if(formID=="BYD" ) {
			return "报溢单";
		}
		else 	if(formID=="BSD" ) {
			return "报损单";
		}
		else 	if(formID=="ZSD" ) {
			return "赠送单";
		}
		else 	if(formID=="JHD" ) {
			return "进货单";
		}
		else 	if(formID=="JHTHD" ) {
			return "进货退货单";
		}
		else 	if(formID=="XSD" ) {
			return "销售单";
		}
		else 	if(formID=="XSTHD" ) {
			return "销售退货单";
		}
		else {
			return null;
		}
				
			
		
	}
	
	public static FormVO createEmptyVO(String formID) {
		if(formID=="" ) {
			return null;
		}
		else if(formID=="SKD" ) {
			return new ReceiptFormVO();
		}
		else 	if(formID=="FKD" ) {
			return new PayFormVO();
		}
		else 	if(formID=="XJFYD" ) {
			return new CashFormVO();
		}
		else 	if(formID=="BJD" ) {
			return new AlarmFormVO();
		}
		else 	if(formID=="BYD" ) {
			return new OverFlowFormVO();
		}
		else 	if(formID=="BSD" ) {
			return new LossFormVO();
		}
		else 	if(formID=="ZSD" ) {
			return new PresentFormVO();
		}
		else 	if(formID=="JHD" ) {
			return new PurchaseFormVO();
		}
		else 	if(formID=="JHTHD" ) {
			return new PurchaseReturnFormVO();
		}
		else 	if(formID=="XSD" ) {
			return new SaleExportFormVO();
		}
		else 	if(formID=="XSTHD" ) {
			return new SaleReturnFormVO();
		}
		else {
			return null;
		}
				
			
		
	}
	
	public static Form VOtoForm (FormVO vo) {
		if(vo instanceof CashFormVO  ) {
			return new CashForm((CashFormVO) vo);
		}
		else if(vo instanceof ReceiptFormVO ) {
			return new ReceiptForm((ReceiptFormVO) vo);
		}
		else if(vo instanceof PayFormVO ) {
			return new PayForm((PayFormVO) vo);
		}
		else if(vo instanceof LossFormVO ) {
			return new LossForm((LossFormVO) vo);
		}
		else if(vo instanceof OverFlowFormVO ) {
			return new OverFlowForm((OverFlowFormVO) vo);
		}
		else if(vo instanceof AlarmFormVO ) {
			return new AlarmForm((AlarmFormVO) vo);
		}
		else if(vo instanceof PresentFormVO ) {
			return new PresentForm((PresentFormVO) vo);
		}
		else if(vo instanceof PurchaseFormVO ) {
			return new PurchaseForm((PurchaseFormVO) vo);
		}
		else if(vo instanceof PurchaseReturnFormVO ) {
			return new PurchaseReturnForm((PurchaseReturnFormVO) vo);
		}
		else if(vo instanceof SaleExportFormVO ) {
			return new SaleSlipForm((SaleExportFormVO) vo);
		}
		else if(vo instanceof SaleReturnFormVO ) {
			return new SaleReturnForm((SaleReturnFormVO) vo);
		}
		else {
			return null;
		}
		
		
	}
	
	
	public static FormVO createVO(FormPO po) {
		if(po instanceof CashFormPO ) {
			return new CashForm((CashFormPO) po).toVO();
		}
		else if(po instanceof ReceiptFormPO ) {
			return new ReceiptForm((ReceiptFormPO) po).toVO();
		}
		else if(po instanceof PayFormPO ) {
			return new PayForm((PayFormPO) po).toVO();
		}
		else if(po instanceof LossFormPO ) {
			return new LossForm((LossFormPO) po).toVO();
		}
		else if(po instanceof OverFlowFormPO ) {
			return new OverFlowForm((OverFlowFormPO) po).toVO();
		}
		else if(po instanceof AlarmFormPO ) {
			return new AlarmForm((AlarmFormPO) po).toVO();
		}
		else if(po instanceof PresentFormPO ) {
			return new PresentForm((PresentFormPO) po).toVO();
		}
		else if(po instanceof PurchaseFormPO ) {
			return new PurchaseForm((PurchaseFormPO) po).toVO();
		}
		else if(po instanceof PurchaseReturnFormPO ) {
			return new PurchaseReturnForm((PurchaseReturnFormPO) po).toVO();
		}
		else if(po instanceof SaleSlipFormPO ) {
			return new SaleSlipForm((SaleSlipFormPO) po).toVO();
		}
		else if(po instanceof SaleReturnFormPO ) {
			return new SaleReturnForm((SaleReturnFormPO) po).toVO();
		}
		else {
			return null;
		}
		
	}
	
	
	
}
