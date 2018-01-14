package DataService.stockDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.goods.GoodsClassPO;

public interface GoodsClassDataService  extends Remote{

	public GoodsClassPO getRoot() throws RemoteException;
	
	public int add(GoodsClassPO newGoodsClass) throws RemoteException;
	
	public boolean modify(GoodsClassPO newer) throws RemoteException;
	
	public boolean delete(int id) throws RemoteException;
	
	public ArrayList<GoodsClassPO> searchClassByName(String name) throws RemoteException;
	
	public GoodsClassPO searchClassByID(int id) throws RemoteException;


}
