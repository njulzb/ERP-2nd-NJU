package vo.report;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import utility.ExcelHelper;
/**
 * 销售明细表VO
 * @author Eli, LZB
 *
 */
public class SaleReportVO {

	ArrayList<SaleReportItemVO> itemList;
	
	double sum;	

	
	public SaleReportVO(ArrayList<SaleReportItemVO> list, double sum) {
		this.itemList = list;
		this.sum = sum;
		
	}
	
	public ArrayList<SaleReportItemVO> getItemList(){return this.itemList;}
	public double getSum() {return this.sum;}
	
	
	public boolean toExcel(String filePath) {
		
		if (filePath==null || "".equals(filePath.trim())) {
			return false;
		}
		String tableName = "销售明细表";
		int numOfItem = 6;
		String[][] content = new String[this.itemList.size()][numOfItem];
		
		int col = 0, row = 0;
		content[0][0] = "日期"; 
		content[0][1] = "商品";
		content[0][2] = "型号";
		content[0][3] = "数量";
		content[0][4] = "单价";
		content[0][5] = "总额";
		
		row++;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		for (  ; row<content.length;row++) {
			String[] line = content[row];
			
			SaleReportItemVO item = this.itemList.get(row);
			
			col=0;
			line[col++] = format.format(item.date);
			line[col++] = item.goods.getName();
			line[col++] = item.goods.getType();
			line[col++] = Integer.toString(item.goods.getNumbers());
			line[col++] = Double.toString(item.goods.getSalePrice());
			line[col++] = Double.toString(item.sum);	
			
			
		}
		
		return ExcelHelper.toNewExcel(tableName, content, filePath);
		
		
	}
	
}
