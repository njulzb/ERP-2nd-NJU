package BL.stockBL.Info;

import java.util.ArrayList;
import java.util.Date;

import BL.stockBL.Goods;

public interface FormQueryInfoForStock {


	public ArrayList<Goods> getImport(Date begin ,Date end);

	/**
	 * 得到出库商品列表
	 * @param begin
	 * @param end
	 * @return
	 */
	public ArrayList<Goods> getExport(Date begin ,Date end);
	
	/**
	 * 得到进货商品列表
	 * @param begin
	 * @param end
	 * @return
	 */
	public ArrayList<Goods> getBuyIn(Date begin ,Date end);
	
	/**
	 * 得到销售商品列表
	 * @param begin
	 * @param end
	 * @return
	 */
	public ArrayList<Goods> getSaleOut(Date begin ,Date end);
}
