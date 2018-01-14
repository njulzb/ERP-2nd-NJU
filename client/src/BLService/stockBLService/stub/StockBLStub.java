package BLService.stockBLService.stub;

import java.rmi.RemoteException;
import java.util.Date;

import BLService.stockBLService.StockBLService;
import vo.goods.PortVO;
import vo.goods.SnapshotVO;

public class StockBLStub implements StockBLService{

	@Override
	public PortVO lookOver(Date begin, Date end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SnapshotVO examine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean toExcel(String filePath, SnapshotVO todayShot) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	

	

}
