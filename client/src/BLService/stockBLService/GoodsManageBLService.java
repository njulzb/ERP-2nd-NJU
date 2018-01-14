package BLService.stockBLService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.goods.GoodsClassVO;
import vo.goods.GoodsVO;

/**
 * 这是商品及分类管理的接口，包括商品及分类的增删改查
 * 这里我们设定 id 可以区分商品和商品分类（前缀SP，FL）
 * @author LZB
 *
 */
public interface GoodsManageBLService {
	
	/**
	 * 增加商品分类，返回商品分类id
	 * @param newGoodsClass
	 * @return
	 * @throws RemoteException
	 */
	public String add(GoodsClassVO newGoodsClass) throws RemoteException ;
	
	/**
	 * 修改商品分类，成功返回true
	 * @param newer
	 * @return
	 * @throws RemoteException
	 */
	public boolean modify(GoodsClassVO newer) throws RemoteException;
	
	
	/**
	 * 如果是分类，默认会删除所有子类
	 * @param current
	 * @return
	 */
	public boolean delete(String id) throws RemoteException;
	
	/**
	 * 得到id所示商品或分类的上级分类
	 * 这个方法既可以获得商品上级也可以获得分类的上级
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public GoodsClassVO getUpper(String id) throws RemoteException;
	
	
	/**
	 * 得到商品分类的下级分类
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<GoodsClassVO> getLower(String id) throws RemoteException;
	
	
	/**
	 * 得到商品根节点，这个根节点是虚拟的，所有商品分类的最终父类，老祖宗了，什么东西都在祖宗手下
	 * @return
	 * @throws RemoteException
	 */
	public GoodsClassVO getRoot() throws RemoteException;


	/**
	 * 增加新商品，返回新商品的id
	 * @param newGoods
	 * @return
	 * @throws RemoteException
	 */
	public String add(GoodsVO newGoods) throws RemoteException ;
	
	
	/**
	 * 修改商品，返回是否成功
	 * @param newer
	 * @return
	 * @throws RemoteException
	 */
	public boolean modify(GoodsVO newer)throws RemoteException;
	

	/**
	 * 根据name或id进行模糊查找商品
	 * @param nameOrID
	 * @return
	 */
	public ArrayList<GoodsVO> search(String nameOrID)throws RemoteException;
	
	
	/**
	 * 根据id精确查找商品分类，若不存在则返回null
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public GoodsClassVO searchClassByID(String id) throws RemoteException;

	/**
	 * 根据name搜索商品分类，因为有重名可能，故返回的结果可能不止一个，调用者要小心。
	 * @param name
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<GoodsClassVO> searchClassByName(String name)throws RemoteException;

}
