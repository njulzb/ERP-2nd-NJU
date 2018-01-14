package Data.stockData;

import java.rmi.RemoteException;
import java.util.ArrayList;

import DataService.stockDataService.GoodsClassDataService;
import po.goods.GoodsClassPO;

/**
 * 管理商品分类表的controller
 * @author lzb
 *
 */
public class GoodsClassDataController implements GoodsClassDataService {

	GoodsClassSqlHelper goodsclassManager = new GoodsClassSqlHelper();
	GoodsDataController goodsHelper;
	
	public boolean setHelper(GoodsDataController helper) {
		if (helper == null) {
			return false;
		}
		this.goodsHelper = helper;
		return true;
	}
	
	@Override
	public GoodsClassPO getRoot() throws RemoteException {
		// TODO Auto-generated method stub
		return this.goodsclassManager.searchByID(1);
	}

	@Override
	public int add(GoodsClassPO adder) throws RemoteException {
		// TODO Auto-generated method stub
		return this.goodsclassManager.insert(adder);
	}

	@Override
	public boolean modify(GoodsClassPO newer) throws RemoteException {
		// TODO Auto-generated method stub
		return this.goodsclassManager.update(newer);
	}

	@Override
	public boolean delete(int id) throws RemoteException {
		// TODO Auto-generated method stub
		
		return this.goodsclassManager.delete(id);
	}

	@Override
	public ArrayList<GoodsClassPO> searchClassByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return this.goodsclassManager.searchByName(name);
	}

	@Override
	public GoodsClassPO searchClassByID(int id) throws RemoteException {
		// TODO Auto-generated method stub
		
		return this.goodsclassManager.searchByID(id);
	}

}
