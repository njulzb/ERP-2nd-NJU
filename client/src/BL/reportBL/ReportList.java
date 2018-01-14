package BL.reportBL;

import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import BL.receiptBL.FormController;
import BL.receiptBL.FormFactory;
import BL.receiptBL.FormInfo;
import po.KeyForSearchForm;
import utility.KindOfForm;
import vo.Form.FormVO;
import vo.Form.FinanceFormVO.FinanceFormVO;
import vo.Form.stockFormVO.LossFormVO;
import vo.Form.stockFormVO.OverFlowFormVO;
import vo.Form.stockFormVO.PresentFormVO;
import vo.Form.stockFormVO.StockFormVO;
import vo.Form.tradeFormVO.PurchaseFormVO;
import vo.Form.tradeFormVO.PurchaseReturnFormVO;
import vo.Form.tradeFormVO.SaleExportFormVO;
import vo.Form.tradeFormVO.SaleReturnFormVO;
import vo.Form.tradeFormVO.TradeFormVO;
import vo.Form.tradeFormVO.TradeItemVO;
import vo.goods.GoodsVO;
import vo.report.KeyForSearchReport;
import vo.report.ManageProgressReportVO;
import vo.report.ManageStateReportVO;
import vo.report.SaleReportItemVO;
import vo.report.SaleReportVO;

/**
 * 真正对report进行管理的类
 * 
 * @author lzb
 *
 */
public class ReportList {

	FormInfo formHelper = new FormController();
	
	
	public SaleReportVO getSaleReport(KeyForSearchReport key) throws RemoteException {
		// TODO Auto-generated method stub
		
		
		/**
		 * 将keyForSearchReport 转换成 keyForSearchForm
		 */
		
		KeyForSearchForm newKey = this.keyToSearchForm(key);
		
		
		/**
		 * 根据newKey 得到符合要求的单据，（销售单据）
		 */
		ArrayList<FormVO> resultList = this.formHelper.searchForm(newKey);
		
		
		
		/**
		 * 解析单据，组装saleReportItemVO 
		 */
		ArrayList<SaleReportItemVO> itemList = new ArrayList<SaleReportItemVO>();
		
		for (FormVO eForm : resultList) {
			SaleExportFormVO form = (SaleExportFormVO) eForm;
			ArrayList<TradeItemVO> tradeItemList = form.getGoodsList();
			
			Date date = eForm.getCreateTime();
			
			for (TradeItemVO eItem : tradeItemList) {
				
				GoodsVO eGoods = eItem.getGoods();
				
				
				
				SaleReportItemVO item = new SaleReportItemVO(date,eGoods);
				itemList.add(item);

			}
			
		}
		
		/**
		 * 根据goodsname 对item 进行筛选
		 */
		if (key.goodsName!=null && !"".equals(key.goodsName.trim())) {
			
			for (SaleReportItemVO eItem : itemList) {
				if (!eItem.goods.getName().equals(key.goodsName)) {
					itemList.remove(eItem);
				}
			}
		
			

		}
		
		
		/**
		 * 组装saleReportVO
		 */
		double sum = 0;
		for (SaleReportItemVO eItem : itemList) {
			sum += eItem.sum;
		}
		SaleReportVO result = new SaleReportVO(itemList,sum);
		
		return result;
	}

	
	public boolean ExportReport(SaleReportVO toBeExport, String path) {
		// TODO Auto-generated method stub
		return toBeExport.toExcel(path);
	}

	/**
	 * 根据时间区间得到经营情况表
	 * @param begin
	 * @param end
	 * @return
	 * @throws RemoteException 
	 */
	public ManageStateReportVO getManageState(Date begin ,Date end) throws RemoteException {
		// TODO Auto-generated method stub
			
		KeyForSearchForm key = new KeyForSearchForm();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String beginstr = format.format(begin);
		String endstr = format.format(end);
		key.setCreateTimeMin(Timestamp.valueOf(beginstr));
		key.setCreateTimeMax(Timestamp.valueOf(endstr));
		
		
		/**
		 * 查找销售单据
		 */
		double saleIncome =0 , saleCost =0,discountCut =0 , goodsIncome = 0, goodsCost =0 ;
		key.setKindOfForm(KindOfForm.SalesForm);
		ArrayList<FormVO> formList = this.formHelper.searchForm(key);
		for (FormVO eForm : formList) {
			if (eForm instanceof SaleExportFormVO) {
				saleIncome += ((SaleExportFormVO) eForm).getSumMoney();
				goodsIncome += ((SaleExportFormVO) eForm).getSumMoney();
				discountCut += ((SaleExportFormVO) eForm).getDiscount();
				continue;
			}
			if (eForm instanceof SaleReturnFormVO) {
				goodsIncome -= ((SaleReturnFormVO) eForm).getSumMoney();
				continue;
			}
			if (eForm instanceof PurchaseFormVO) {
				saleCost += ((PurchaseFormVO) eForm).getSumMoney();
				goodsCost -= ((PurchaseFormVO) eForm).getSumMoney();
				continue;
			}
			if (eForm instanceof PurchaseReturnFormVO) {
				goodsCost += ((PurchaseReturnFormVO) eForm).getSumMoney();
				continue;
			}
		}
		
		
		/**
		 * 查找库存类单据
		 */
		
		key.setKindOfForm(KindOfForm.StockForm);
		ArrayList<FormVO> stockList = this.formHelper.searchForm(key);
		for (FormVO eForm: stockList) {
			if (eForm instanceof OverFlowFormVO) {
				goodsIncome += ((OverFlowFormVO) eForm).getSum();
				continue;
			}
			
			if (eForm instanceof LossFormVO) {
				goodsCost += ((LossFormVO) eForm).getSum();
				continue;
			}
			
			
			if (eForm instanceof PresentFormVO) {
				goodsCost += ((PresentFormVO) eForm).getSum();
				continue;
			}
		}
		
		
		
		ManageStateReportVO result = new ManageStateReportVO(begin,end,saleIncome,goodsIncome,
				saleCost,goodsCost,discountCut);
		
		return result;
	}

	
	public boolean ExportReport(ManageStateReportVO toBeExport, String path) {
		// TODO Auto-generated method stub
		return toBeExport.toExcel(path);
	}

	
	public ManageProgressReportVO getManageProgress(KeyForSearchReport key) throws RemoteException {
		// TODO Auto-generated method stub
		
		/**
		 * 生成查找单据的key
		 */
		KeyForSearchForm newKey = this.keyToSearchForm(key);
		
		/**
		 * 查找销售类单据
		 */
		newKey.setKindOfForm(KindOfForm.SalesForm);
		ArrayList<FormVO> searchList = this.formHelper.searchForm(newKey);
		if (searchList==null){
			return null;
		}
		ArrayList<TradeFormVO> saleList = new ArrayList<TradeFormVO>(searchList.size());
		
		if (searchList!=null && searchList.size()!=0) {
			
			for (FormVO eForm : searchList) {
				saleList.add((TradeFormVO)eForm);
			}

		}
		
		/**
		 * 查找进货单据
		 */
		newKey.setKindOfForm(KindOfForm.PortForm);
		searchList = this.formHelper.searchForm(newKey);
		if (searchList==null){
			return null;
		}
		ArrayList<PurchaseFormVO> importList = new ArrayList<PurchaseFormVO>(searchList.size());
		
		if (searchList!=null && searchList.size()!=0) {
			for (FormVO eForm : searchList) {
				importList.add((PurchaseFormVO)eForm);
			}
		}
		

		
		/**
		 * 查找财务类单据
		 */
		newKey.setKindOfForm(KindOfForm.FinanceForm);
		searchList = this.formHelper.searchForm(newKey);
		if (searchList==null){
			return null;
		}
		ArrayList<FinanceFormVO> financeList = new ArrayList<FinanceFormVO>(searchList.size());
		
		if (searchList!=null && searchList.size()!=0) {
			for (FormVO eForm : searchList) {
				financeList.add((FinanceFormVO)eForm);
			}
		}
		

		
		
		/**
		 * 查找库存类单据
		 */
		
		
		newKey.setKindOfForm(KindOfForm.StockForm);
		searchList = this.formHelper.searchForm(newKey);
		if (searchList==null){
			return null;
		}
		ArrayList<StockFormVO> stockList = new ArrayList<StockFormVO>(searchList.size());
		if (searchList!=null && searchList.size()!=0) {
			for (FormVO eForm : searchList) {
				stockList.add((StockFormVO)eForm);
			}
		}
		

		ManageProgressReportVO result = new ManageProgressReportVO(saleList,importList,financeList,stockList);
				
		
		return result;
	}

	
	public boolean ExportReport(ManageProgressReportVO toBeExport, String path) {
		// TODO Auto-generated method stub
		return toBeExport.toExcel(path);
	}

	/**
	 * 将keyForSearchReport 转换成 keyForSearchForm 
	 * @param key
	 * @return
	 */
	private KeyForSearchForm keyToSearchForm(KeyForSearchReport key) {
		
		KeyForSearchForm newKey = new KeyForSearchForm();
		
//		newKey.setKindOfForm(key.kindOfForm);
		newKey.setID(FormFactory.toTitle(key.kindOfForm));
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String beginstr = format.format(key.begin);
		String endstr = format.format(key.end);
		newKey.setCreateTimeMin(Timestamp.valueOf(beginstr));
		newKey.setCreateTimeMax(Timestamp.valueOf(endstr));
		if (key.customer!=null){
			newKey.setCustomerID(key.customer.getId());
		}
		if (key.operator!=null){
			newKey.setOperatorID(key.operator.getID());

		}
				
		return newKey;
	}
	
	
	


	
	
}
