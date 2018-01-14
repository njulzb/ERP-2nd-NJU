package BL.stockBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import BL.stockBL.Info.StockInfo;
import BLService.stockBLService.GoodsManageBLService;
import BLService.stockBLService.StockBLService;
import vo.goods.GoodsClassVO;
import vo.goods.GoodsVO;
import vo.goods.PortVO;
import vo.goods.SnapshotVO;


/**
 * stock模块的控制器，实现了GoodsManageBLService,StockBLService ,StockInfo接口<br/>
 * 假设根据id可以区分是商品还是分类<br/>
 * <b>商品：SP                  <br/>
 * 商品分类：FL
 * 
 * @author LZB
 *
 */
public class StockController implements GoodsManageBLService,StockBLService,StockInfo{

	private GoodsClassList goodsClassManager = new GoodsClassList();
	private GoodsList goodsManager = new GoodsList();
	private PortList portManager = new PortList();
	
	/**
	 * 构造函数，其中对goodsclasslist，goodslist进行依赖注入，避免互相依赖。
	 */
	public StockController() {
		this.goodsClassManager.setGoodsList(this.goodsManager);
		this.goodsManager.setGoodsClassList(this.goodsClassManager);
	}
	
	
	@Override
	public boolean importGoods(ArrayList<Goods> importList)  throws RemoteException{
		// TODO Auto-generated method stub
		return this.goodsManager.importGoods(importList);
	}

	@Override
	public boolean exportGoods(ArrayList<Goods> exportList)  throws RemoteException{
		// TODO Auto-generated method stub
		return this.goodsManager.exportGoods(exportList);
	}

	@Override
	public PortVO lookOver(Date begin, Date end) throws RemoteException{
		// TODO Auto-generated method stub
		return this.portManager.lookOver(begin, end);
	}

	@Override
	public SnapshotVO examine() throws RemoteException{
		// TODO Auto-generated method stub
		return this.portManager.examine();
	}

	@Override
	public boolean toExcel(String filePath,SnapshotVO todayShot) throws RemoteException{
		// TODO Auto-generated method stub
		return this.portManager.toExcel(filePath,todayShot);
	}

	@Override
	public String add(GoodsClassVO newGoodsClass) throws RemoteException{
		// TODO Auto-generated method stub
		return this.goodsClassManager.add(newGoodsClass);
	}

	@Override
	public boolean modify(GoodsClassVO newer) throws RemoteException{
		// TODO Auto-generated method stub
		return this.goodsClassManager.modify(newer);
	}

	@Override
	public boolean delete(String id)throws RemoteException {
		// TODO Auto-generated method stub
		if (id.contains("FL")) {
			
			return this.goodsClassManager.delete(id);
		}
		if (id.contains("SP")) {
			return this.goodsManager.delete(id);
		}
		return false;//id 错误
	}

	@Override
	/**
	 * 在controller中完成任务分配，确定是商品或是商品分类
	 */
	public GoodsClassVO getUpper(String id)throws RemoteException {
		// TODO Auto-generated method stub
		
		/**
		 * 若是商品分类
		 */
		if (id.contains("FL")) {
			GoodsClassVO cur = this.searchClassByID(id);
			String upperidstr = cur.getUpperID();
			GoodsClassVO result = this.searchClassByID(upperidstr);
			return result;
		}
		
		/**
		 * 若是商品
		 */
		if (id.contains("SP")) {
			GoodsVO cur = this.searchGoodsByID(id);
			String upperidstr = cur.getUpperID();
			GoodsClassVO result = this.searchClassByID(upperidstr);
			return result;
		}

		return null;//不存在对应id
	}

	
	/**
	 * 得到id所示分类的下级分类,下级分类有可能是商品，使用者应当进行考察后使用
	 * 不存在则返回null
	 */
	@Override
	public ArrayList<GoodsClassVO> getLower(String id)throws RemoteException {
		// TODO Auto-generated method stub
//		1.得到当前分类，判断是否有下级分类
		GoodsClassVO curr = this.searchClassByID(id);
		
		ArrayList<String> loweridList = curr.getLowerID();
		if (loweridList==null || loweridList.size()==0) {
			return null;
		}
		
		
//		2.判断下级列表是分类还是商品
		ArrayList<GoodsClassVO> resultList = new ArrayList<GoodsClassVO>();
		if (curr.isLeaf()) {
//			2.1是商品
			
			
			for (String each : loweridList) {
							
				GoodsVO vo = this.searchGoodsByID(each);
				resultList.add(vo);
			}
			return resultList;
		}
		else {
//			2.2是分类
			for (String e:loweridList) {
				GoodsClassVO cur= this.searchClassByID(e);
				resultList.add(cur);
				
			}
			return resultList;
			
		}
		
	}

	@Override
	public GoodsClassVO getRoot() throws RemoteException{
		// TODO Auto-generated method stub
		return this.goodsClassManager.getRoot();
	}

	@Override
	public String add(GoodsVO newGoods) throws RemoteException{
		// TODO Auto-generated method stub
		
		return this.goodsManager.add(newGoods);
	}

	@Override
	public boolean modify(GoodsVO newer) throws RemoteException{
		// TODO Auto-generated method stub
		return this.goodsManager.modify(newer);
	}

	

	@Override
	public ArrayList<GoodsVO> search(String nameOrID) throws RemoteException{
		// TODO Auto-generated method stub
		return this.goodsManager.search(nameOrID);
	}

	@Override
	public GoodsClassVO searchClassByID(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return this.goodsClassManager.searchClassByID(id);
	}

	@Override
	public ArrayList<GoodsClassVO> searchClassByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public GoodsVO searchGoodsByID(String id) throws RemoteException {
		return this.goodsManager.searchGoodsByID(id);
	}


	@Override
	public Goods getGoodsByID(String id) throws RemoteException {
		// TODO Auto-generated method stub
		Goods result = new Goods(this.searchGoodsByID(id));
		
		
		return result;
	}


	
}
