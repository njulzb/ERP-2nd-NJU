package vo.report;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import utility.ExcelHelper;

/**
 * 经营情况表VO
 * @author lzb
 *
 */
public class ManageStateReportVO {
	
	
	double saleIncome=0,goodsIncome=0,finalIncome=0;
	double saleCost=0,goodsCost=0,finalCost =0;
	double	profit=0 , discountCut=0;
	
	Date begin ,end;
	
	public ManageStateReportVO(Date begin,Date end,double saleIncome,double goodsIncome,
			double saleCost ,double goodsCost,double discountCut) {
		
		this.begin = begin;
		this.end = end;
		
		
		this.saleIncome = saleIncome;
		this.goodsIncome = goodsIncome;
		this.finalIncome = this.saleIncome + this.goodsIncome ;
		
		this.saleCost = saleCost;
		this.goodsCost = goodsCost;
		this.finalCost = this.saleCost + this.goodsCost ;
		
		this.profit = this.finalIncome - this.finalCost;
		this.discountCut = discountCut;
		
	}
	
	
	public boolean toExcel(String filePath) {
		
		String tableName = "经营情况表";
		String[][] content = new String[2][10] ;
		
		content[0][0] = "起始时间";
		content[0][1] = "截至时间";
		content[0][2] = "销售收入";
		content[0][3] = "商品收入";
		content[0][4] = "总收入";
		content[0][5] = "销售支出";
		content[0][6] = "商品支出";
		content[0][7] = "总支出";
		content[0][8] = "利润";
		content[0][9] = "折让金额";
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		content[1][0] = format.format(this.begin);
		content[1][1] = format.format(this.end);
		content[1][2] = Double.toString(this.saleIncome);
		content[1][3] = Double.toString(this.goodsIncome);
		content[1][4] = Double.toString(this.finalIncome);
		content[1][5] = Double.toString(this.saleCost);
		content[1][6] = Double.toString(this.goodsCost);
		content[1][7] = Double.toString(this.finalCost);
		content[1][8] = Double.toString(this.profit);
		content[1][9] = Double.toString(this.discountCut);

		return ExcelHelper.toNewExcel(tableName, content, filePath);
		
		
	}
	
	
	
	
	
	public double getSaleIncome(){return  saleIncome;}
	public boolean setSaleIncome(double in){ saleIncome=in;return true;}
	
	public double getGoodsIncome(){return  goodsIncome;}
	public boolean setGoodsIncome(double in){goodsIncome=in;return true;}
	
	public double getDiscount(){return  finalIncome;}
	public boolean setDiscount(double in){finalIncome=in;return true;}
	
	public double getSaleCost(){return  saleCost;}
	public boolean setSaleCost(double in){saleCost=in;return true;}
	
	public double getGoodsExpense(){return  goodsCost;}
	public boolean setGoodsExpense(double in){goodsCost=in;return true;}
	
	public double getProfit(){return  profit;}
	public boolean setProfit(double in){profit=in;return true;}
	
	/**
	 * 附上此报表的计算公式
	 * 经营情况表

1. 收入类
   1. 销售收入 = saleExportFormVO.sum
   2. 商品类收入 = OverflowFormVO.sum +saleExportFormVO.sum-saleReturnFormVO.sum 
   3. 折让金额 = saleExportFormVO.discount
   4. 总收入 = 销售收入 + 商品类收入 
2. 支出类
   1. 销售成本 =PurchaseFormVO.sum 
   2. 商品类支出  = LossFormVO .sum + (presentForm.sum) + PurchaseFormVO.sum - PruchaseReturnFormVO.sum
   3. 总支出 = 销售成本 + 商品类支出
3. 利润
   1. 利润 = 总收入 - 总支出

	 */
	
	
}
