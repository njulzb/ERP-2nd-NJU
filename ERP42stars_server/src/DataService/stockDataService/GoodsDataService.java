package DataService.stockDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.goods.GoodsPO;

public interface GoodsDataService  extends Remote{

	
	public int add(GoodsPO newGoods) throws RemoteException;
	
	public boolean modify(GoodsPO newer) throws RemoteException;
	
	public boolean delete(int id) throws RemoteException;
	
	
	
	public ArrayList<GoodsPO> searchGoodsByID(int id) throws RemoteException;
	
	public ArrayList<GoodsPO> searchGoodsByName(String name) throws RemoteException;
	
	public ArrayList<GoodsPO> getAll() throws RemoteException;

	
}
