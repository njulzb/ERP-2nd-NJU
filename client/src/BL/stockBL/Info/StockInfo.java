package BL.stockBL.Info;

import java.rmi.RemoteException;
import java.util.ArrayList;

import BL.stockBL.Goods;

public interface StockInfo {
	
	
	/**
	 * 
	 * @param importList
	 * @return
	 */
	public boolean importGoods (ArrayList<Goods> importList) throws RemoteException;
	
	public boolean exportGoods (ArrayList<Goods> exportList) throws RemoteException;
	
	public Goods getGoodsByID (String id) throws RemoteException;

}
