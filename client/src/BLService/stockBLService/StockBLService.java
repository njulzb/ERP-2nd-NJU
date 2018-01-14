package BLService.stockBLService;

import java.rmi.RemoteException;
import java.util.Date;

import vo.goods.PortVO;
import vo.goods.SnapshotVO;

/**
 * @author LZB
 *
 */
public interface StockBLService {
	
	/**
	 * 库存查看方法，
	 * 设定一个时间段，查看此时间段内的出/入库数量/金额，销售/进货的数量/金额。
	 * 库存数量有合计
	 * @param begin
	 * @param end
	 * @return
	 */
	public PortVO lookOver(Date begin,Date end)throws RemoteException;

	
	/**
	 * 
	 * 盘点的是当天的库存快照，<br/>
	 * 包括当天的各种商品的名称，型号，库存数量，库存均价，批次，批号，出厂日期，<br/>
	 * 并且显示行号<br/>
	 * @return
	 */
	public SnapshotVO examine()throws RemoteException;
	
	
	/**
	 * 要求库存快照可以导出excel
	 * @param list
	 * @return
	 */
	public boolean toExcel(String filePath,SnapshotVO todayShot)throws RemoteException;
}
