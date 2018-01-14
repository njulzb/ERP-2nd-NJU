package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Data.stockData.GoodsClassDataController;
import Data.stockData.GoodsDataController;
import DataService.stockDataService.GoodsDataService;
import po.goods.GoodsPO;

/**
 * 单纯实现任务的转包
 * @author lzb
 *
 */
public class GoodsDataServiceImpl extends UnicastRemoteObject implements GoodsDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	GoodsDataController controller = new GoodsDataController();
	GoodsClassDataController helper  = new GoodsClassDataController();
	
	public GoodsDataServiceImpl() throws RemoteException {
		super();
		this.controller.setHelper(this.helper);
		this.helper.setHelper(this.controller);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int add(GoodsPO newGoods) throws RemoteException {
		// TODO Auto-generated method stub
		return this.controller.add(newGoods);
	}

	@Override
	public boolean modify(GoodsPO newer) throws RemoteException {
		// TODO Auto-generated method stub
		return this.controller.modify(newer);
	}

	@Override
	public boolean delete(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return this.controller.delete(id);
	}

	

	@Override
	public ArrayList<GoodsPO> searchGoodsByID(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return this.controller.searchGoodsByID(id);
	}

	@Override
	public ArrayList<GoodsPO> searchGoodsByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return this.controller.searchGoodsByName(name);
	}

	@Override
	public ArrayList<GoodsPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		return this.controller.getAll();
	}

	
}
