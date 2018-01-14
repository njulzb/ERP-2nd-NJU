package BL.reportBL.domainObject;

import java.util.ArrayList;

import vo.Form.FinanceFormVO.CashFormVO;
import vo.Form.FinanceFormVO.PayFormVO;
import vo.Form.FinanceFormVO.ReceiptFormVO;
import vo.Form.stockFormVO.LossFormVO;
import vo.Form.stockFormVO.OverFlowFormVO;
import vo.Form.stockFormVO.PresentFormVO;
import vo.Form.tradeFormVO.PurchaseFormVO;
import vo.Form.tradeFormVO.PurchaseReturnFormVO;
import vo.Form.tradeFormVO.SaleExportFormVO;
import vo.Form.tradeFormVO.SaleReturnFormVO;
/**
 * 经营情况表，包含所有单据列表
 * @author lzb
 *
 */
public class ManageProgressReport {
	
	ArrayList<SaleExportFormVO> saleExportList;
	ArrayList<SaleReturnFormVO> saleExportReturnList;
	
	ArrayList<PurchaseFormVO> purchaseList;
	ArrayList<PurchaseReturnFormVO> purchaseReturnList;
	
	ArrayList<CashFormVO> cashFormList;
	ArrayList<PayFormVO> payFormList;
	ArrayList<ReceiptFormVO> receiptFormList;
	
	ArrayList<PresentFormVO> PresentFormList;
	ArrayList<OverFlowFormVO> OverflowFormList;
	ArrayList<LossFormVO> LossFormList;
	
}
