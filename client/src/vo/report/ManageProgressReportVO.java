package vo.report;

import java.util.ArrayList;

import utility.ExcelHelper;
import vo.Form.FormVO;
import vo.Form.FinanceFormVO.FinanceFormVO;
import vo.Form.stockFormVO.StockFormVO;
import vo.Form.tradeFormVO.PurchaseFormVO;
import vo.Form.tradeFormVO.TradeFormVO;
/**
 * 经营历程表VO
 * @author Eli
 *
 */
public class ManageProgressReportVO {
	
	ArrayList<TradeFormVO> saleList ;
	ArrayList<PurchaseFormVO> importList;
	ArrayList<FinanceFormVO> financeList;
	ArrayList<StockFormVO> stockList;

	public ManageProgressReportVO(	ArrayList<TradeFormVO> saleList ,ArrayList<PurchaseFormVO> importList,
								ArrayList<FinanceFormVO> financeList, ArrayList<StockFormVO> stockList)	{
		this.saleList = saleList;
		this.importList = importList;
		this.financeList = financeList;
		this.stockList = stockList;
		
	}

	public ArrayList<TradeFormVO> getSaleList(){return this.saleList;}
	public ArrayList<PurchaseFormVO> getImportList() {return this.importList;}
	public ArrayList<FinanceFormVO> getFinanceList() {return this.financeList;}
	public ArrayList<StockFormVO> getStockList() {return this.stockList;}
	
	public boolean toExcel(String filePath) {
		
		String[] title = new String[11];
		title[0] = "编号";
		title[1] = "类型";
		title[2] = "状态";
		title[3] = "操作员";
		title[4] = "驳回意见";
		title[5] = "创建时间";
		title[6] = "保存时间";
		title[7] = "提交时间";
		title[8] = "通过时间";
		title[9] = "驳回时间";
		title[10] = "单据说明";
		
		
		
		
		
		
		/**
		 * 销售单据
		 */
		String sheetName = "销售单据";
		String[][] content = new String[this.saleList.size() + 1][];

		int row =0;
		content[row++] = title;//标题栏
		
		for (TradeFormVO eForm : this.saleList) {			
			content[row++] = eForm.toLine();					
		}
		
		boolean flag = ExcelHelper.toNewExcel(sheetName, content, filePath);
		if (!flag) {
			return false;
		}
		/**
		 * 进货单据
		 */
		sheetName = "进货单据";
		content = new String[this.importList.size()+1][];
		row = 0;
		content[row++] = title;
		
		for (FormVO e : this.importList) {
			content[row++] = e.toLine();
		}
		flag = ExcelHelper.appToExcel(sheetName, content, filePath);
		if(!flag) {
			return false;
		}
		
		/**
		 * 财务单据
		 */
		sheetName = "财务单据";
		content = new String[this.financeList.size()+1][];
		row = 0;
		content[row++] = title;
		
		for (FormVO e : this.financeList) {
			content[row++] = e.toLine();
		}
		flag = ExcelHelper.appToExcel(sheetName, content, filePath);
		if(!flag) {
			return false;
		}

		
		/**
		 * 库存单据
		 */
		sheetName = "库存单据";
		content = new String[this.stockList.size()+1][];
		row = 0;
		content[row++] = title;
		
		for (FormVO e : this.stockList) {
			content[row++] = e.toLine();
		}
		flag = ExcelHelper.appToExcel(sheetName, content, filePath);
		if(!flag) {
			return false;
		}

		
		
		
		return true;
	}
	
}
