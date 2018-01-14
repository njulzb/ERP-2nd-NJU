package presentation.strategyUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import utility.LevelOfCustomer;
import vo.goods.GoodsVO;
import vo.strategy.CustomerStrategyVO;

public class testList {
	private ArrayList<CustomerStrategyVO> list;
	private ArrayList<GoodsVO> gift;
	
	public ArrayList<CustomerStrategyVO> getList() throws ParseException{
		String time = "2018-01-12";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date d = sdf.parse(time);
	    
		CustomerStrategyVO c1 = new CustomerStrategyVO(d, 45, "stc-180112172054", LevelOfCustomer.level1, LevelOfCustomer.level1, 255.5, gift);
		list.add(c1);
		
		CustomerStrategyVO c2 = new CustomerStrategyVO(d, 60, "stc-180112174001", LevelOfCustomer.level2, LevelOfCustomer.level3, 500, gift);
		list.add(c2);
		
		CustomerStrategyVO c3 = new CustomerStrategyVO(d, 45, "stc-1801120235", LevelOfCustomer.level3, LevelOfCustomer.level5, 1000, gift);
		list.add(c3);
		
		return list;
		
	}
	public ArrayList<GoodsVO> getGiftList(){
		GoodsVO g1 = null, g2 = null;
		g1.setName("小台灯");
		gift.add(g1);
		g2.setName("彩色吊灯");
		gift.add(g2);
		return gift;
		
	}

}
