package Data.stockData;

import java.rmi.RemoteException;

import po.goods.GoodsClassPO;

public class InitStock {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		new InitStock().initStock();
	}

	public void initStock() throws RemoteException{
		StockDBConnector connector = StockDBConnector.getConnector();
		String cmd = "truncate goodsclasslist;";
		connector.runSql(cmd);
		
		cmd = "truncate goodslist;";
		connector.runSql(cmd);
		
		GoodsClassPO root = new GoodsClassPO(1,"root",1);
		GoodsClassDataController controller = new GoodsClassDataController();
		int id= controller.add(root);
		System.out.println(id);

	}
	
}
