package DataService.stockDataService.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import DataService.stockDataService.GoodsClassDataService;
import DataService.stockDataService.GoodsDataService;
import po.goods.GoodsClassPO;

public class GoodsClassDataServiceStub implements GoodsClassDataService {

	ArrayList<GoodsClassPO> goodsclassList = new ArrayList<GoodsClassPO>();
	GoodsDataService stub ;
	int count = 1;
	public GoodsClassDataServiceStub() {
		this.goodsclassList.add(new GoodsClassPO(1,"root",1));
	}
	
	public void setGoodsDataService() {
		this.stub = new GoodsDataServiceStub();
	}
	@Override
	public GoodsClassPO getRoot() throws RemoteException {
		// TODO Auto-generated method stub
		return this.goodsclassList.get(0);
	}

	@Override
	public int add(GoodsClassPO newGoodsClass) throws RemoteException {
		// TODO Auto-generated method stub
		this.count++;
		newGoodsClass.setID(this.count);
		this.goodsclassList.add(newGoodsClass);
		return newGoodsClass.getID();
	}

	
	private int indexOf(int id) {
		for (int i=0;i<this.goodsclassList.size();i++) {
			GoodsClassPO cur = this.goodsclassList.get(i);
			if (cur != null && cur.getID()==id) {
				return i;
			}
		}
		
		return -1;
	}
	@Override
	public boolean modify(GoodsClassPO newer) throws RemoteException {
		// TODO Auto-generated method stub
		int index = this.indexOf(newer.getID());
		this.goodsclassList.remove(index);
		this.goodsclassList.add(index, newer);
		
		return true;
	}

	@Override
	public boolean delete(int id) throws RemoteException {
		// TODO Auto-generated method stub
		int index = this.indexOf(id);
		if (index==-1) {
			return false;
		}
		this.goodsclassList.remove(index);
		return true;
	}

	

	

	@Override
	public ArrayList<GoodsClassPO> searchClassByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<GoodsClassPO> resultList = new ArrayList<GoodsClassPO>();
		for (GoodsClassPO each: this.goodsclassList) {
			if (each !=null && each.getName().contains(name)) {
				resultList.add(each);
			}
		}
		return resultList;
	}

	@Override
	public GoodsClassPO searchClassByID(int id) throws RemoteException {
		// TODO Auto-generated method stub
		int index = this.indexOf(id);
		if (index==-1) {
			return null;
		}
		GoodsClassPO result = this.goodsclassList.get(index);
		return result;
	}

}
