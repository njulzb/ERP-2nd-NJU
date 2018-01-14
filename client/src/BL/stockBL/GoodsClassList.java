package BL.stockBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import DataService.stockDataService.GoodsClassDataService;
import RMI.ClientRunner;
import po.goods.GoodsClassPO;
import vo.goods.GoodsClassVO;

/**
 * 负责商品分类管理的逻辑
 * @author LZB
 *
 */
public class GoodsClassList {
	
	GoodsClassDataService goodsclassManager = ClientRunner.getInstance().getGoodsClassDataService();
	GoodsList goodsHelper ;//等待外部controller对其进行初始化，依赖注入
//	GoodsClassDataService goodsclassManager = new GoodsClassDataServiceStub();
	
	
	/**
	 * 进行依赖注入的方法
	 * @param list
	 * @return
	 */
	public boolean setGoodsList(GoodsList list) {
		if (list == null) {
			return false;
		}
		
		this.goodsHelper = list;		
		return true;
	}
	
	
	
	
	
	
	
	/**
	 * 根据id查找商品分类，不存在则返回null
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public GoodsClassVO searchClassByID(String id) throws RemoteException {
		
		int idint = GoodsClass.classIdToInt(id);
		GoodsClassPO po = this.goodsclassManager.searchClassByID(idint);
		if (po==null) {
			return null;
		}
		
		GoodsClass domain = new GoodsClass(po);
		GoodsClassVO vo = domain.toVO();
		return vo;
		
	}
	
	
	/**
	 * 根据name查找商品分类，不存在则返回null
	 * @param name
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<GoodsClassVO> searchClassByName(String name) throws RemoteException{
		ArrayList<GoodsClassPO> poList = this.goodsclassManager.searchClassByName(name);
		
//		
		if (poList==null || poList.size()==0) {
			return null;
		}
		
		ArrayList<GoodsClassVO> voList = new ArrayList<GoodsClassVO>();
		for (GoodsClassPO each: poList) {
			GoodsClass domain = new GoodsClass(each);
			GoodsClassVO vo = domain.toVO();
			voList.add(vo);
		}
		
		return voList;
	}
	
	public GoodsClassVO getRoot() throws RemoteException {
		GoodsClassPO po = this.goodsclassManager.getRoot();
		GoodsClass domain = new GoodsClass(po);
		GoodsClassVO vo = domain.toVO();
		
		return vo;
		
	}
	
	
	/**
	 * 增加一个新的商品分类，同时应向此分类的上级分类注册，并更新
	 * @param newer
	 * @return
	 * @throws RemoteException
	 */
	public String add(GoodsClassVO newer) throws RemoteException {
		
//		1.添加商品分类本体
		GoodsClass domain = new GoodsClass(newer);
		GoodsClassPO po = domain.toPO();
		int idint = this.goodsclassManager.add(po);
		
		String id = GoodsClass.classIdToString(idint);
		if (id.equals("FL0")) {
			return null;
		}
		
		
//		2.向上级分类注册
		String upperidstr = newer.getUpperID();
		
		GoodsClassVO uppervo = this.searchClassByID(upperidstr);
		if (uppervo==null) {
			return null;
		}
		
		GoodsClass upper = new GoodsClass(uppervo);
		upper.addLower(id);
		
//		3.更新上级分类
		this.modify(upper.toVO());
		
		
		return id ;
		
	}
	
	/**
	 * 对原有分类进行修改，
	 * 不能对原分类的下级分类进行修改，而应通过修改下级分类达到目的
	 * @param newer
	 * @return
	 * @throws RemoteException
	 */
	public boolean modify(GoodsClassVO newer) throws RemoteException {
//		1.得到原有旧分类
		String id = newer.getID();
		GoodsClassVO older = this.searchClassByID(id);
		
//		2.若修改了上级分类，则对原有上级分类进行修改
		if (older.getUpperID().equals(newer.getUpperID())==false) {
			
//			2.1 向原有上级分类取消注册
			GoodsClassVO oldUpperVO = this.searchClassByID(older.getUpperID());
			GoodsClass oldUpper = new GoodsClass(oldUpperVO);
			oldUpper.removeLower(id);
			this.modify(oldUpper.toVO());
			
//			2.2向新上级分类注册下级
			GoodsClassVO newUpperVO = this.searchClassByID(id);
			GoodsClass newUpper = new GoodsClass(newUpperVO);
			newUpper.addLower(id);
			this.modify(newUpperVO);
			
			
		}

		/**
		 * 存在问题，若下级分类改变应判断错误
		 */
		
//		4.对当前分类进行修改
		GoodsClass domain = new GoodsClass(newer);
		GoodsClassPO po = domain.toPO();
	
		return this.goodsclassManager.modify(po);
		
	}
	
	
	public boolean delete(String id) throws RemoteException{
//		1. 向上级分类取消下级注册	
		
//		1.1 得到当前分类
		GoodsClassVO curr = this.searchClassByID(id);
		
		if (curr == null) {
			return false;
		}
		
//		1.2 得到上级分类
		
		String upperidstr = curr.getUpperID();
		GoodsClassVO uppervo = this.searchClassByID(upperidstr);
		boolean flag = false;
		if (uppervo !=null) {//
//			1.3 上级分类取消下级分类
			GoodsClass upper = new GoodsClass(uppervo);
			upper.removeLower(id);
			
			
//			1.4 更新上级分类
			
			 flag = this.modify(upper.toVO());
			
			if (!flag) {
				return false;
			}
		}
		

		
//		2.删除所有下级分类
		for (String each : curr.getLowerID() ) {
			if (curr.isLeaf()) {
				this.goodsHelper.delete(each);
			}
			else {
				
				this.delete(each);
			}
		}
		
		
//		3.删除id 对应实体
		int idint = GoodsClass.classIdToInt(id);
		
		flag = this.goodsclassManager.delete(idint);
		
		
		
		
		return flag;
		
		
	}
	
	
	
	
	
	
	
	
}
