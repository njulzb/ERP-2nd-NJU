package vo.goods;

import java.util.ArrayList;

import BL.stockBL.Goods;
/**
 * 出入库情况
 * @author LZB
 *
 */
public class PortVO {
	
	//入库
	int importNumber=0;
	double importMoney=0;
	
	//出库
	int exportNumber=0;
	double exportMoney=0;
	
	//进货
	int buyInNumber=0;
	double buyInMoney=0;
	
	//销售
	int saleOutNumber=0;
	double saleOutMoney=0;
	
	/**
	 * 统计list中的信息，分配到属性中
	 * @param list
	 */
	public PortVO (ArrayList<Goods> importList,ArrayList<Goods> exportList,
			ArrayList<Goods> buyInList,ArrayList<Goods> saleOutList) {
		
		for (Goods each:importList) {
			this.importNumber += each.getNumbers();
			this.importMoney += each.getNumbers()*each.getBuyingPrice();
		}
		
		for (Goods each:exportList) {
			this.exportNumber += each.getNumbers();
			this.exportMoney += each.getNumbers()*each.getSalePrice();
		}
		
		for (Goods each: buyInList) {
			this.buyInNumber += each.getNumbers();
			this.buyInMoney += each.getNumbers()*each.getBuyingPrice();
		}
		
		for (Goods each: saleOutList) {
			this.saleOutNumber += each.getNumbers();
			this.saleOutMoney += each.getNumbers()*each.getSalePrice();
		}
	}

	
	public PortVO() {
		// TODO 自动生成的构造函数存根
	}


	public int getImportNumber() {return this.importNumber;}
	public int getexportNumber() {return this.exportNumber;}
	public int saleInNumber() {return this.buyInNumber;}
	public int saleOutNumber() {return this.saleOutNumber;}
	
	public double getImportMoney() {return this.importMoney;}
	public double getExportMoney() {return this.exportMoney;}
	public double getSaleInMoney() {return this.buyInMoney;}
	public double getSaleOutMoney() {return this.saleOutMoney;}
	
}
