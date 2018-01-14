package DataService.stockDataService.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import DataService.stockDataService.GoodsClassDataService;
import DataService.stockDataService.GoodsDataService;
import po.goods.GoodsPO;

public class GoodsDataServiceStub implements GoodsDataService {

	ArrayList<GoodsPO> goodsList = new ArrayList<GoodsPO>();
	GoodsClassDataService stub ;
	int count = 0;
	public GoodsDataServiceStub() {
		
	}
	
	public void setGoodsClassDataService() {
		this.stub = new GoodsClassDataServiceStub();
	}
	
	
	private int indexOf(int id) {
		for (int i=0;i<this.goodsList.size();i++) {
			GoodsPO curr = this.goodsList.get(i);
			
			if (curr!=null && curr.getID()==id) {
				return i;
			}
		}
		return -1;
	}
	
	
	@Override
	public int add(GoodsPO newGoods) throws RemoteException {
		// TODO Auto-generated method stub
		
		count++;
		newGoods.setID(count);
	
		this.goodsList.add(newGoods);
		return count;
	}

	@Override
	public boolean modify(GoodsPO newer) throws RemoteException {
		// TODO Auto-generated method stub
		int id = newer.getID();
		
		int index = this.indexOf(id);
		if (index==-1) {
			
			return false;
		}
		
		this.goodsList.remove(index);
		this.goodsList.add(index, newer);
		return true;
	}

	@Override
	public boolean delete(int id) throws RemoteException {
		// TODO Auto-generated method stub
		int index = this.indexOf(id);
		this.goodsList.remove(index);
		this.goodsList.add(index, null);
		return true;
	}



	@Override
	public ArrayList<GoodsPO> searchGoodsByID(int id) throws RemoteException {
		// TODO Auto-generated method stub
		int index = this.indexOf(id);
		
		if (index<0) {
			System.out.println("index"+index);
			return null;
		}
		GoodsPO result = this.goodsList.get(index);
		
		ArrayList<GoodsPO> resultList = new ArrayList<GoodsPO>();
		resultList.add(result);
		return resultList;
	}

	@Override
	public ArrayList<GoodsPO> searchGoodsByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<GoodsPO> resultList = new ArrayList<GoodsPO>();
		for (int i=0;i<this.goodsList.size();i++) {
			GoodsPO curr = this.goodsList.get(i);
			if (curr!=null && curr.getName().contains(name)) {
				resultList.add(curr);
			}
		}
		return resultList;
	}

	@Override
	public ArrayList<GoodsPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<GoodsPO> resultList = new ArrayList<GoodsPO>();
		for(int i=0;i<this.goodsList.size();i++) {
			GoodsPO cur = this.goodsList.get(i);
			if (cur!=null) {
				resultList.add(cur);
			}
		}
		return resultList;
	}

	
}
