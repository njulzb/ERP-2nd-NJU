package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Data.stockData.GoodsClassDataController;
import Data.stockData.GoodsDataController;
import DataService.stockDataService.GoodsClassDataService;
import po.goods.GoodsClassPO;

/**
 * 单纯实现任务的转包
 * @author lzb
 *
 */
public class GoodsClassDataServiceImpl extends UnicastRemoteObject implements GoodsClassDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	GoodsClassDataController controller = new GoodsClassDataController();
	GoodsDataController helper = new GoodsDataController();//dependency injection 依赖注入
	
	
	
	public GoodsClassDataServiceImpl() throws RemoteException {
		super();
		this.controller.setHelper(this.helper);
		this.helper.setHelper(this.controller);
	}

	@Override
	public GoodsClassPO getRoot() throws RemoteException {
		// TODO Auto-generated method stub
		return this.controller.getRoot();
	}

	@Override
	public int add(GoodsClassPO newGoodsClass) throws RemoteException {
		// TODO Auto-generated method stub
		return this.controller.add(newGoodsClass);
	}

	@Override
	public boolean modify(GoodsClassPO newer) throws RemoteException {
		// TODO Auto-generated method stub
		return this.controller.modify(newer);
	}

	@Override
	public boolean delete(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return this.controller.delete(id);
	}



	@Override
	public ArrayList<GoodsClassPO> searchClassByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return this.controller.searchClassByName(name);
	}

	@Override
	public GoodsClassPO searchClassByID(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return this.controller.searchClassByID(id);
	}

}
