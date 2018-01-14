package BLService.stockBLService.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import BL.stockBL.GoodsClass;
import BLService.stockBLService.GoodsManageBLService;
import vo.goods.GoodsClassVO;
import vo.goods.GoodsVO;

public class GoodsManageBLServiceStub implements GoodsManageBLService{

	ArrayList<GoodsClassVO> goodsclassList;
	ArrayList<GoodsVO> goodsList;
	
	public GoodsManageBLServiceStub() {
		this.goodsclassList = new ArrayList<GoodsClassVO>();
		this.goodsList = new ArrayList<GoodsVO>();
		
		GoodsClassVO root = new GoodsClassVO("FL0","root","");
		this.goodsclassList.add(root);
	}
	
	private int findPosOfClass(String id) {
		for (int i=0;i<this.goodsclassList.size();i++) {
			if (this.goodsclassList.get(i).getID().equals(id)) {
				return i;
			}
		}
		return -1;//not found
	}
	
	
	private int findPosOfGoods(String id) {
		for (int i=0;i<this.goodsList.size();i++) {
			if (this.goodsList.get(i).getID().equals(id)) {
				return i;
			}
		}
		return -1;//not found

	}
	
	@Override
	public String add(GoodsClassVO newer) {
		// TODO Auto-generated method stub
		String upperid = newer.getUpperID();
		int pos = this.findPosOfClass(upperid);
		
		this.goodsclassList.add(newer);
		
//		this.goodsclassList.get(pos).addLower(newer);
		GoodsClassVO vo = this.goodsclassList.get(pos);
		GoodsClass domain = new GoodsClass(vo);
		domain.addLower(newer.getID());
		
		this.goodsclassList.remove(pos);
		this.goodsclassList.add(pos,domain.toVO());
		
		return "FL" + this.goodsclassList.indexOf(newer);
	}

	@Override
	public boolean modify(GoodsClassVO newer) {
		// TODO Auto-generated method stub
		String id = newer.getID();
		int pos = this.findPosOfClass(id);
		if (this.goodsclassList.remove(pos)==null) {
			return false;//删除失败
		}
		this.goodsclassList.add(pos, newer);
		return true;
	}

	
	
	@Override
	/**
	 * 这个方法有很多情况没有考虑，谨慎测试！！！！！！！
	 */
	public GoodsClassVO getUpper(String id) {
		// TODO Auto-generated method stub
		
//		找到id对应的商品或分类,并找到上级分类
//		
		int pos = -1;
		String upperid = null;
		if (id.contains("FL")) {
			pos = this.findPosOfClass(id);
			upperid = this.goodsclassList.get(pos).getUpperID();
		}
		else if (id.contains("SP")){
			pos = this.findPosOfGoods(id);
			upperid = this.goodsList.get(pos).getUpperID();
		}
		
		if (pos == -1) {
			System.out.println("id not found , while getUpper...");
			return null;
		}
		
		
		
//		找到上级分类
		
		
		pos = this.findPosOfClass(upperid);
		return this.goodsclassList.get(pos);
	}

	@Override
	public ArrayList<GoodsClassVO> getLower(String id) {
		// TODO Auto-generated method stub
//		1. 根据id找到分类
		int dadPos = this.findPosOfClass(id);
		GoodsClassVO curr = this.goodsclassList.get(dadPos);
		
		
		ArrayList<GoodsClassVO> lowerList = new ArrayList<GoodsClassVO>();
		
		ArrayList<String> idList = curr.getLowerID();
		for (int i=0;i<idList.size();i++) {
			String idtmp = idList.get(i);
			int pos = this.findPosOfClass(idtmp);
			GoodsClassVO tmp = this.goodsclassList.get(pos);
			lowerList.add(tmp);
		}
		
		
		
		return lowerList;
	}

	
	@Override
	public GoodsClassVO getRoot() {
		// TODO Auto-generated method stub
		return this.goodsclassList.get(0);
	}



	
	public boolean deleteClass(String id) {
		// TODO Auto-generated method stub
//		1. 找到分类
		int deadPos = this.findPosOfClass(id);
		GoodsClassVO current = this.goodsclassList.get(deadPos);
		
//		kill all the sons
		ArrayList<String> lowerList = current.getLowerID();
		for (int i=0;lowerList!=null && i<lowerList.size();i++) {
			String idtmp = lowerList.get(i);
			int pos = this.findPosOfClass(idtmp);
			GoodsClassVO dead = this.goodsclassList.remove(pos);
			if (dead==null) {
				System.out.println("there is no the son ,your son is lost ,sorry to hear that......");
				return false;
			}
		}
		
		String upperid = current.getUpperID();
		int pos = this.findPosOfClass(upperid);
//		this.goodsclassList.get(pos).removeLower(current);
		GoodsClassVO vo = this.goodsclassList.get(pos);
		GoodsClass domain = new GoodsClass(vo);
		domain.removeLower(current.getID());
		this.goodsclassList.remove(pos);
		this.goodsclassList.add(pos,domain.toVO());
		
		String idtemp = current.getID();
		pos = this.findPosOfClass(idtemp);
		this.goodsclassList.remove(pos);
		
		return true;
	}

	@Override
	public String add(GoodsVO newer) {
		// TODO Auto-generated method stub
		this.goodsList.add(newer);
		
		String upperid = newer.getUpperID();
		int pos = this.findPosOfClass(upperid);
//		this.goodsclassList.get(pos).addLower(newer);
		GoodsClassVO vo = this.goodsclassList.get(pos);
		GoodsClass domain = new GoodsClass(vo);
		domain.addLower(newer.getID());
		
		this.goodsclassList.remove(pos);
		this.goodsclassList.add(pos,domain.toVO());

		return "SP" + this.goodsclassList.indexOf(newer);
	}

	@Override
	public boolean modify(GoodsVO newer) {
		// TODO Auto-generated method stub
		this.deleteGoods(newer.getID());
		this.add(newer);
		return true;
	}

	
	public boolean deleteGoods(String id) {
		// TODO Auto-generated method stub
//		1.找到id对应商品
		int deadPos = this.findPosOfGoods(id);
		GoodsVO curr = this.goodsList.get(deadPos);
		
//		2.删除商品
		this.goodsList.remove(deadPos);
		
//		3.取消注册
		String upperid = curr.getUpperID();
		int upperPos = this.findPosOfClass(upperid);
		GoodsClassVO dad = this.goodsclassList.get(upperPos);
//		dad.removeLower(curr);
		GoodsClass domain = new GoodsClass(dad);
		domain.removeLower(curr.getID());
		this.goodsclassList.remove(upperPos);
		this.goodsclassList.add(upperPos,domain.toVO());
		
		return false;
	}

	

	@Override
	public ArrayList<GoodsVO> search(String nameOrID) {
		// TODO Auto-generated method stub
		ArrayList<GoodsVO> resultList = new ArrayList<GoodsVO>();
		
		for (int i=0;this.goodsList!=null && i<this.goodsList.size();i++) {
			if (this.goodsList.get(i).getID().equals(nameOrID)) {
				resultList.add(this.goodsList.get(i));
			}
		}
		
		if (resultList.size()==0) {
			for (int i=0;this.goodsList!=null && i<this.goodsList.size();i++) {
				if (this.goodsList.get(i).getID().contains(nameOrID)) {
					resultList.add(this.goodsList.get(i));
				}
			}

		}
		
		return resultList;
	}

	

	@Override
	public boolean delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		if (id.contains("FL")) {
			return this.deleteClass(id);
		}
		if (id.contains("SP")) {
			return this.deleteGoods(id);
		}
		return false;
	}

	@Override
	public GoodsClassVO searchClassByID(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GoodsClassVO> searchClassByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	
	
	
	
	
	

}
