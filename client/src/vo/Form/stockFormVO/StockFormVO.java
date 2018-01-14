package vo.Form.stockFormVO;

import java.util.ArrayList;
import java.util.Date;

import utility.StateOfForm;
import vo.UserVO;
import vo.Form.FormVO;


/**
 * 库存类单据父类
 * @author lzb
 *
 */
public class StockFormVO extends FormVO{
	
	private double sum=0;
	private	ArrayList<StockItemVO> goodsList =new ArrayList<StockItemVO>();
	

	public StockFormVO() {
		// TODO 自动生成的构造函数存根
	}


	public ArrayList<StockItemVO> getGoodsList() {
		return goodsList;
	}


	public void setGoodsList(ArrayList<StockItemVO> goodsList) {
		this.goodsList = goodsList;
	}


	public double getSum() {
		return sum;
	}


	public void setSum(double sum) {
		this.sum = sum;
	}


	

}
