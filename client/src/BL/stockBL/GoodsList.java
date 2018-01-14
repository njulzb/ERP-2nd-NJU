package BL.stockBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import DataService.stockDataService.GoodsDataService;
import RMI.ClientRunner;
import po.goods.GoodsPO;
import vo.goods.GoodsClassVO;
import vo.goods.GoodsVO;

public class GoodsList {

	GoodsDataService goodsManager = ClientRunner.getInstance().getGoodsDataService();
	GoodsClassList goodsClassHelper;//这里的初始化将会放在外部，由controller进行依赖注入
//	GoodsDataService goodsManager = new GoodsDataServiceStub();
	
	
	
	/**
	 * 进行依赖注入的方法
	 * @param list
	 * @return
	 */
	public boolean setGoodsClassList(GoodsClassList list) {
		if (list==null) {
			return false;
		}
		this.goodsClassHelper = list;
		return true;
	}
	
	/**
	 * 删除id所示的商品，不存在则返回null
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public boolean delete(String id)throws RemoteException{
//		1.得到id所示的商品
		GoodsVO dead = this.searchGoodsByID(id);
		
//		2.向上级分类取消注册
		
//			2.1获得上级分类
		String upperidstr = dead.getUpperID();
		GoodsClassVO upperVO = this.goodsClassHelper.searchClassByID(upperidstr);
		
//			2.2上级分类取消对下级分类的注册
		boolean flag = false;
		if (upperVO!=null) {
			GoodsClass upper = new GoodsClass(upperVO);
			flag = upper.removeLower(id);//key
			if (!flag) {
				return false;
			}
			flag = this.goodsClassHelper.modify(upper.toVO());
			if (!flag) {
				return false;
			}
		}
		
//		3.删除当前商品
		int idint = Goods.goodsIdToInt(id);
		
		flag = this.goodsManager.delete(idint);
		
		return flag;
	}
	
	
	
	/**
	 * 添加新的商品
	 * @param newGoods
	 * @return
	 * @throws RemoteException
	 */
	public String add(GoodsVO newGoods) throws RemoteException{
//		1.添加新商品
		
		Goods domain = new Goods(newGoods);
		GoodsPO po = domain.toPO();
		int idint = this.goodsManager.add(po);
		
		String id = Goods.goodsIdToString(idint);
		
//		2.向上级分类注册
		String upperidstr = newGoods.getUpperID();
		
		GoodsClassVO upperVO = this.goodsClassHelper.searchClassByID(upperidstr);
		GoodsClass upper = new GoodsClass(upperVO);
		upper.addLower(id);
		
		this.goodsClassHelper.modify(upper.toVO());
		
		return id;
		
	}
	
	
	public boolean modify(GoodsVO newer) throws RemoteException{
//		1.根据id得到原有商品
		String id = newer.getID();
		GoodsVO older = this.searchGoodsByID(id);
		
//		2.修改上级分类
		
		if (!older.getUpperID().equals(newer.getUpperID())){
//			2.1 向原有上级分类取消
			GoodsClassVO oldUpperVO = this.searchGoodsByID(older.getUpperID());
			GoodsClass oldUpper = new GoodsClass(oldUpperVO);
			oldUpper.removeLower(id);
			this.goodsClassHelper.modify(oldUpper.toVO());
			
//			2.2 向新上级分类注册
			
			GoodsClassVO newUpperVO = this.searchGoodsByID(newer.getUpperID());
			GoodsClass newUpper = new GoodsClass(newUpperVO);
			newUpper.addLower(id);
			this.goodsClassHelper.modify(newUpper.toVO());
			
		}

//		3.更新当前商品
		Goods domain = new Goods(newer);
		
		GoodsPO po = domain.toPO();
		
		return this.goodsManager.modify(po);
		
	}
	
	/**
	 * 根据id精准找到商品，不存在则返回null
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public GoodsVO searchGoodsByID(String id) throws RemoteException {
		int idint = Goods.goodsIdToInt(id);
		
		ArrayList<GoodsPO> poList = this.goodsManager.searchGoodsByID(idint);
		if (poList == null || poList.size()==0) {
			return null;
		}
		
		for (GoodsPO each:poList) {
			if (each.getID()==idint) {
				
				Goods domain = new Goods(each);
				
				GoodsVO vo = domain.toVO();
				
				return vo;
			}
		}
		
		
		return null;
	}
	
	
	/**
	 * 根据name或者id进行模糊搜索
	 * @param nameOrID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<GoodsVO> search(String nameOrID) throws RemoteException{
		/**
		 * 两个列表，一个根据id，一个根据name
		 */
		ArrayList<GoodsPO> idList = new ArrayList<GoodsPO>();
		ArrayList<GoodsPO> nameList = new ArrayList<GoodsPO>();
		
		/**
		 * 根据id搜索
		 */
		int id = Goods.goodsIdToInt(nameOrID);
		
		if (id>0) {
			
			idList = this.goodsManager.searchGoodsByID(id);
		}
		
		
		/**
		 * 根据name搜索
		 */
		nameList = this.goodsManager.searchGoodsByName(nameOrID);
		
		ArrayList<GoodsVO> resultList = new ArrayList<GoodsVO>();
		
		
		/**
		 * 将id结果合并进resultList
		 */
		for (int i=0;idList!=null && i<idList.size();i++) {
			Goods domain = new Goods(idList.get(i));
			GoodsVO vo = domain.toVO();
			
			if (resultList.contains(vo)) {
				continue;
			}
			resultList.add(vo);
		}
		
		/**
		 * 将nameList合并进resultList
		 */
		for (int i=0;nameList!=null && i<nameList.size();i++) {
			Goods domain = new Goods(nameList.get(i));
			GoodsVO vo = domain.toVO();
			if (resultList.contains(vo)) {
				continue;
			}
			resultList.add(vo);
		}
		
		if (resultList==null || resultList.size()==0) {
			return null;
		}
		
		return resultList;
		
	}
	
	
	
	
	/**
	 * 库存入库方法
	 * @param importList
	 * @return
	 * @throws RemoteException
	 */
	public boolean importGoods(ArrayList<Goods> importList) throws RemoteException{
		// TODO Auto-generated method stub
		if (importList==null || importList.size()==0) {
			System.out.println("importList is empty ,while GoodsList.importGoods()..");
			return false;
		}
		
		for (Goods goods : importList) {
			GoodsPO po = goods.toPO();
			this.goodsManager.modify(po);
		}
		return true;
	}

	/**
	 * 库存出库方法
	 * @param exportList
	 * @return
	 * @throws RemoteException
	 */
	public boolean exportGoods(ArrayList<Goods> exportList)throws RemoteException {
		// TODO Auto-generated method stub
		if (exportList==null || exportList.size()==0) {
			System.out.println("importList is empty ,while GoodsList.exportGoods()..");
			return false;
		}
		
		for (Goods goods : exportList) {
			GoodsPO po = goods.toPO();
			this.goodsManager.modify(po);
		}
		return true;

		
	}

	
	
}
