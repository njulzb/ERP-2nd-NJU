package po.goods;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * @author LZB
 *
 */
public class GoodsClassPO implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String name;
	int upperClassid;
	ArrayList<Integer> lowerClassesid = new ArrayList<Integer>();
	boolean isLeaf = true;
	byte[] imageBytes;
//	---------------------------constructors below
	
	
	public GoodsClassPO(int id,String name,int upper,byte[] imageBytes){
		this.id = id;
		this.name = name;
		this.upperClassid = upper;
		
		this.imageBytes = imageBytes;
	}

	
	public GoodsClassPO(int id,String name,int upper,ArrayList<Integer> lowerClasses,boolean isLeaf,byte[] imageBytes){
		this.id = id;
		this.name = name;
		this.upperClassid = upper;
		this.lowerClassesid = lowerClasses;
		this.isLeaf = isLeaf;
		this.imageBytes = imageBytes;
	}
	
	public GoodsClassPO(int id,String name,int upper,ArrayList<Integer> lowerClasses){
		this.id = id;
		this.name = name;
		this.upperClassid = upper;
		this.lowerClassesid=lowerClasses;
		
	}
	
	public GoodsClassPO(int id,String name,int upper){
		this.id = id;
		this.name = name;
		this.upperClassid = upper;
		
		
	}

	

	
//	--------------------------constructors above
	
	
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj==null) {
			return false;
		}
		GoodsClassPO curr = (GoodsClassPO) obj;
		boolean flagid = this.id==curr.getID();
		boolean flagname= this.name.equals(curr.getName());
		boolean flagupper = this.upperClassid==curr.getUpper();
		boolean flaglower = this.lowerClassesid.equals(curr.lowerClassesid);
		return flagid&&flagname&&flagupper&&flaglower;
		
	}



	//get methods
	public int getID() {return this.id;}
	public String getName() {return this.name;}
	public int getUpper() {return this.upperClassid;}
	public ArrayList<Integer> getLower() {return this.lowerClassesid;}
	public boolean isLeaf() {return this.isLeaf;}
	public byte[] getImageBytes() {return this.imageBytes;}
	
	//set method
	public boolean setUpper(int newUpperid) {
		this.upperClassid = newUpperid;
		return true;
	}
	public boolean setIsLeaf(boolean hasGoodsFlag) {
		this.isLeaf = hasGoodsFlag;
		return true;
	}
	
	public boolean setID(int id) {this.id= id;return true;}

}
