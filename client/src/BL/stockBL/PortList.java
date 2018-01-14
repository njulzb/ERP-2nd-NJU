package BL.stockBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import BL.receiptBL.FormController;
import BL.stockBL.Info.FormQueryInfoForStock;
import BLService.stockBLService.StockBLService;
import DataService.stockDataService.GoodsDataService;
import RMI.ClientRunner;
import po.goods.GoodsPO;
import vo.goods.PortVO;
import vo.goods.SnapshotVO;

public class PortList implements StockBLService{
	
	GoodsDataService goodsManager = ClientRunner.getInstance().getGoodsDataService();
//	GoodsDataService goodsManager = new GoodsDataServiceStub();
	FormQueryInfoForStock formQuestioner = new FormController();

	@Override
	public PortVO lookOver(Date begin, Date end) {
		// TODO Auto-generated method stub
		
		ArrayList<Goods> importList = this.formQuestioner.getImport(begin, end);
		ArrayList<Goods> exportList = this.formQuestioner.getExport(begin, end);
		ArrayList<Goods> buyInList = this.formQuestioner.getBuyIn(begin, end);
		ArrayList<Goods> saleOutList = this.formQuestioner.getSaleOut(begin, end);
		
		return new PortVO(importList,exportList,buyInList,saleOutList);
		
		
	}

	@Override
	public SnapshotVO examine() throws RemoteException {
		// TODO Auto-generated method stub
		
		ArrayList<GoodsPO> poList = this.goodsManager.getAll();
		ArrayList<Goods> list = new ArrayList<Goods>();
		for (GoodsPO each:poList) {
			Goods curr = new Goods(each);
			list.add(curr);
		}
		return new SnapshotVO(list);
	}

	@Override
	public boolean toExcel(String filePath,SnapshotVO todayShot) {
		// TODO Auto-generated method stub
		
		return todayShot.toExcel(filePath);
	}

}
