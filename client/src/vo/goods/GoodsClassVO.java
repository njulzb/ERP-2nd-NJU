package vo.goods;
import java.util.ArrayList;

/**
 * 商品分类
 * @author lzb
 * 
 * 
 * @param ID ,name , upperClass , lowerClass
 * 
 * 
 *
 *  
 */
public class GoodsClassVO {
	
	String id;//id 可以区分商品和分类
	String name;
	String upperID;

	ArrayList<String> lowerIDList =new 	ArrayList<String>();
	boolean isLeaf = true;
	String imagePath;
	

	
	/**
	 * constructors of GoodsClassVO
	 * 完整版
	 * @param id
	 * @param name
	 * @param upperid
	 * @param lowerid
	 */
	public GoodsClassVO(String id,String name,String upperid,ArrayList<String> lowerid,boolean isLeaf,String imagePath){
		this.id = id;
		this.name = name;
		this.upperID = upperid;
		this.lowerIDList = lowerid;
		this.isLeaf = isLeaf;
		this.imagePath = imagePath;
	}
	
	
	
	/**
	 * only use id,name,upper id to construct one object
	 * @param id
	 * @param name
	 * @param upperid
	 */
	public GoodsClassVO(String id,String name,String upperid) {
		this.id = id;
		this.name = name;
		this.upperID = upperid;
		this.lowerIDList = new ArrayList<String>();
	}
	
	public GoodsClassVO(String id,String name,String upperid,String imagePath) {
		this.id = id;
		this.name = name;
		this.upperID = upperid;
		this.imagePath = imagePath;
	}
	
	
	public GoodsClassVO(String name,String upperid) {
		this.name = name;
		this.upperID = upperid;
	}
	public GoodsClassVO() {
	}
	
	//get methods
	public String getID() {return id;}
	public String getName() {return name;}
	public String getUpperID() {return upperID;}
	public ArrayList<String> getLowerID() {return lowerIDList;}
	public String getImagePath() {return imagePath;}
	public boolean isLeaf() {return this.isLeaf;}
	
	//set methods
	public boolean setID(String newID){id=newID;return true;}
	public boolean setName(String newName){name=newName;return true;}
	public boolean setUpperID(String newUpperClassID){upperID=newUpperClassID;return true;}
	public boolean setLowerID(ArrayList<String> newLowerClass){lowerIDList=newLowerClass;return true;}
	public void setImage(String imagePath) {this.imagePath = imagePath;}
	
	
	


	
	
	/**
	 * 尚未完成的equals方法，用于比较两个VO
	 */
	@Override
	public boolean equals(Object object) {
		GoodsClassVO vo = (GoodsClassVO) object;
		if (!vo.getID().equals(this.id))	return false;
		if (!vo.getName().equals(this.name))	return false;
		if (!vo.getUpperID().equals(this.upperID)) return false;
		
		
		
		return true;
	}
	
	
}
