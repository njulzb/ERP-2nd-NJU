package Data.stockData;

import java.rmi.RemoteException;
import java.util.ArrayList;

import DataService.stockDataService.GoodsDataService;
import po.goods.GoodsPO;

public class GoodsDataController implements GoodsDataService{

	GoodsSqlHelper goodsManager = new GoodsSqlHelper();
	GoodsClassDataController goodsclassHelper;
	
	public boolean setHelper(GoodsClassDataController helper) {
		if (helper==null) {
			return false;
		}
		this.goodsclassHelper = helper;
		return true;
	}
	
	@Override
	public int add(GoodsPO newGoods) throws RemoteException {
		// TODO Auto-generated method stub
		return this.goodsManager.insert(newGoods);
	}

	@Override
	public boolean modify(GoodsPO newer) throws RemoteException {
		// TODO Auto-generated method stub
		return this.goodsManager.update(newer);
	}

	@Override
	public boolean delete(int id) throws RemoteException {
		// TODO Auto-generated method stub
		
		return this.goodsManager.delete(id);
	}

	

	public GoodsPO searchGoodsByIDAcurrate(int id) throws RemoteException  {
		
		return this.goodsManager.searchGoodsByIDAccurate(id);
	}
	
	
	@Override
	public ArrayList<GoodsPO> searchGoodsByID(int id) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<GoodsPO> resultList = new ArrayList<GoodsPO>();
		
		
		if (this.getAll()!=null) {
			for (GoodsPO each : this.getAll()) {
				if (this.isSimilar(each.getID(), id)) {
					resultList.add(each);
				}
			}

		}
		
		if (resultList==null || resultList.size()==0) {
			return null;
		}
		
		return resultList;
	}

	
	private boolean isSimilar(int id1,int id2) {
		return this.isSimilar(Integer.toString(id1), Integer.toString(id2));
	}
	
	private boolean isSimilar(String str1,String str2) {
		if (str2==null || str1==null) {
			return false;
		}
		
		boolean flag1 = str1.contains(str2);
		boolean flag2 = str2.contains(str1);
		
		return flag1||flag2;
		
	}
	
	public ArrayList<GoodsPO> searchGoodsByNameAccurate(String name) throws RemoteException{
		return this.goodsManager.searchGoodsByNameAccurate(name);
	}
	
	@Override
	public ArrayList<GoodsPO> searchGoodsByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<GoodsPO> resultList = new ArrayList<GoodsPO>();
		
		
		if (this.getAll()!=null) {
			for (GoodsPO each : this.getAll()) {
				if (this.isSimilar(each.getName(), name)) {
					resultList.add(each);
				}
			}
		}
		
		
		return resultList;
	}

	@Override
	public ArrayList<GoodsPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		return this.goodsManager.getAll();
	}

	
}
