package BL.stockBL;

import java.io.File;
import java.util.ArrayList;

import po.goods.GoodsClassPO;
import utility.ByteHelper;
import vo.goods.GoodsClassVO;

public class GoodsClass {
	
	String id;
	String name;
	String upperClassID;
	ArrayList<String> lowerClassesID = new ArrayList<String>();
	boolean isLeaf = true;
	String imagePath ;
	
	
	
	
//	------------------------------constructors below
	/**
	 * constructor 完整版
	 * @param id
	 * @param name
	 * @param upper
	 * @param lowers
	 */
	public GoodsClass(String id,String name,String upper,ArrayList<String> lowers,boolean isLeaf,String imagePath){
		this.id = id;
		this.name = name;
		this.upperClassID = upper;
		if (lowers!=null) {
			this.lowerClassesID = lowers;
		}
		
		this.isLeaf = isLeaf;
		this.imagePath = imagePath;
	}
	
	/**
	 * constructor 简略版，为新增商品服务
	 * @param id
	 * @param name
	 * @param upper
	 */
	public GoodsClass(String id,String name,String upper) {
		this.id = id;
		this.name = name;
		this.upperClassID = upper;
	}
	
	public GoodsClass(String id,String name,String upper,boolean isLeaf,String imagePath) {
		this.id = id;
		this.name = name;
		this.upperClassID = upper;
		this.isLeaf = isLeaf;
		this.imagePath = imagePath;
	}

	public GoodsClass(String id,String name,String upper,String imagePath) {
		this.id = id;
		this.name = name;
		this.upperClassID = upper;
		
		this.imagePath = imagePath;
	}

	
	/**
	 * constructor from PO
	 * @param po
	 */
	public GoodsClass(GoodsClassPO po) {
		int poID = po.getID();
		String id = classIdToString(poID);
		
		String name = po.getName();
		
		int poUpper = po.getUpper();
		String upperid = classIdToString(poUpper);
		
		ArrayList<Integer> poLowerList = po.getLower();
		ArrayList<String> resultLowerList = new ArrayList<String>();
		
		
		if (poLowerList==null || poLowerList.size()==0) {
//			do nothing
		}
		else {
			if (po.isLeaf()) {
//				下级是商品
				for (Integer each : poLowerList) {
					int idint = each.intValue();
					String idstr = Goods.goodsIdToString(idint);
					resultLowerList.add(idstr);
				}

			}
			else {
//				下级是分类
				for (Integer each : poLowerList) {
					int idint = each.intValue();
					String idstr = GoodsClass.classIdToString(idint);
					resultLowerList.add(idstr);
				}
			}
		}
		
		
		
		
		
		this.id = id;
		this.name = name;
		this.upperClassID = upperid;
		this.lowerClassesID = resultLowerList;
		
		this.isLeaf = po.isLeaf();
		this.imagePath = this.imageToFilePath(po.getImageBytes());
		
	}

			
	
	
	/**
	 * constructor from VO
	 * @param vo
	 */
	public GoodsClass(GoodsClassVO vo) {
		this(vo.getID(),vo.getName(),vo.getUpperID(),vo.getLowerID(),vo.isLeaf(),vo.getImagePath());
		
	}
	
	
	
//	------------------------constructors above
	
	/**
	 * convert class to VO
	 * @return
	 */
	public GoodsClassVO toVO() {
		String id = this.id;
		String name = this.name;
		String upperid = this.upperClassID;
		
		ArrayList<String> lowerList = this.lowerClassesID;
		boolean isLeaf = this.isLeaf;
		String image = this.imagePath;
		GoodsClassVO result = new GoodsClassVO(id,name,upperid,lowerList,isLeaf,image);
		return result;
	}
	
	/**
	 * convert class to PO
	 * @return
	 */
	public GoodsClassPO toPO() {
		
		int id = classIdToInt(this.id);
		String name = this.name;
		int upperid = classIdToInt(this.upperClassID);
		ArrayList<Integer> lowerList = new ArrayList<Integer>();
		for (String each: this.getLower()) {
			int lowerid = classIdToInt(each);
			lowerList.add(Integer.valueOf(lowerid));
		}
		boolean isLeaf = this.isLeaf;
		String imagePath = this.imagePath;
		
		byte[] imageByte = this.imageToByte(imagePath);
		
		GoodsClassPO result = new GoodsClassPO(id,name,upperid,lowerList,isLeaf,imageByte);
		return result;
	}
	
	
	/**
	 * 将文件路径下的文件转换成byte[]
	 * @param imagePath
	 * @return
	 */
	byte[] imageToByte(String imagePath) {
		return ByteHelper.imageToByte(imagePath);
	}
	
	/**
	 * 将byte[] 转换成文件，返回文件路径,这里的相对路径设置可能会有问题，后期需注意
	 * 这里的文件会放在bin/tempImage 下，现在应该不会有问题了
	 * @param imageByte
	 * @return
	 */
	String imageToFilePath(byte[] imageByte) {
//		String bin = this.getClass().getResource("").getPath();//bin 的路径
	
		String filePath ="C:\\temp\\" +  this.name + ".png";
		
//		File dir = new File(bin+"cacheImg/");
//		dir.mkdirs();
		
		boolean flag = ByteHelper.byteToImage(imageByte, filePath);
		if (!flag) {
			return null;
		}
		return filePath;
	}
	
	/**
	 * 将字符串形式的id 转换成 int 形式
	 * @param id
	 * @return
	 */
	public static int classIdToInt(String id) {
		
		if (id==null || id.equals("")) {
			return 0;
		}
		if (id.contains("FL")==false && id.contains("SP")==false) {
			return 0;
		}
		return Integer.valueOf(id.substring(2));
	}
	
	/**
	 * 将int 形式的id 转换成字符串形式
	 * @param id
	 * @return
	 */
	public static String classIdToString(int id) {
		
		return "FL" + id;
	}

	
	/**
	 * 向商品分类中增加下级
	 * @param id
	 * @return
	 */
	public boolean addLower(String id) {
		if (id==null) {
			return false;
		}
		
		if (id.contains("SP")) {//新加入的是商品
			
			if (this.isLeaf==false) {
				return false;
			}
			else {//本节点是叶节点，允许加入
				this.lowerClassesID.add(id);
				return true;
			}
		}
		else {
			
			
			if (id.contains("FL")) {//是分类
				if (this.isLeaf==true && this.lowerClassesID!=null && this.lowerClassesID.size()!=0) {
//					本节点是叶节点 ，但下级列表不为空，则已有商品加入
					return false;
				}
				else {
					this.lowerClassesID.add(id);
					this.isLeaf= false;
					return true;
				}
			}
			else {//id既不是分类也不是商品，输入错误
				return false;
			}
			
			
		}
		
		
		
		
		
	}
	
	
	public boolean removeLower(String id) {
		if (id ==null) {
			return false;
		}
		
		if (this.lowerClassesID.contains(id)==false) {
			return false;//不存在
		}
		
		
		if (id.contains("FL") && this.lowerClassesID.size()==1) {
			this.isLeaf = true;
		}
			
	
		
		return this.lowerClassesID.remove(id);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//get methods
	public String getID() {return id;}
	public String getName() {return name;}
	public String getUpper() {return upperClassID;}
	public ArrayList<String> getLower() {return lowerClassesID;}
	
	//set methods
	public boolean setID(String newID){id=newID;return true;}
	public boolean setName(String newName){name=newName;return true;}
	public boolean setUpper(String newUpperClass){upperClassID=newUpperClass;return true;}
	public boolean setLower(ArrayList<String> newLowerClass){lowerClassesID=newLowerClass;return true;}
	


}
