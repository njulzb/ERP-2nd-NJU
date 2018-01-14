package presentation.stockUI;

import java.rmi.RemoteException;

import BL.stockBL.StockController;
import vo.goods.GoodsClassVO;
import vo.goods.GoodsVO;

public class test {
	public static void main(String args[]) {
		StockController controller = new StockController();
		String imgPath = "c:\\test.png";

		GoodsVO goods = new GoodsVO("测试商品", "");
		goods.setImage(imgPath);
		goods.setUpperID("FL23");
		GoodsClassVO goodsClass = new GoodsClassVO("测试类", "");
		goodsClass.setUpperID("FL1");
		goodsClass.setImage(imgPath);

		try {
			controller.add(goods);
			controller.add(goodsClass);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}
}
