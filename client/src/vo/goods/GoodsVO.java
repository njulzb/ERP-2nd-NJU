package vo.goods;

import java.util.Date;

/**
 * @author LZB
 * 
 * @param ID name type numbers buyingPrice salePrice recentBuyingPrice recentSalePrice upperClass alarmingValue 
 * 
 */
public class GoodsVO extends GoodsClassVO{

	/*
	 * properties 
	 * 	 like id,name ,upperClass is included in super class(GoodsClassVO)
	 * 
	 * and the lowerClass property is default null in this class
	 */
	
	String type;
	int numbers;
	double buyingPrice;
	double salePrice;
	double recentBuyingPrice;
	double recentSalePrice;
	int alarmingValue;
	
	String batchID;
	 Date productionDate;

	
	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public GoodsVO(String id,String name,String upperClass,String imagePath,
			String type,int numbers,
			double buyingPrice,double salePrice,double recentBuyingPrice,double recentSalePrice,
			int alarmingValue,String batchid,Date productionDate){
		super(id,name,upperClass,imagePath);//null lower list , true is Leaf
		this.type=type;
		this.numbers=numbers;
		this.buyingPrice = buyingPrice;
		this.salePrice = salePrice;
		this.recentBuyingPrice = recentBuyingPrice;
		this.recentSalePrice = recentSalePrice;
		this.alarmingValue = alarmingValue;
		this.batchID = batchid;
		this.productionDate = productionDate;
	}
	
	public GoodsVO(String name,String upperClass,
			String type,int numbers,
			double buyingPrice,double salePrice,double recentBuyingPrice,double recentSalePrice,
			int alarmingValue,String batchid,Date productionDate){
		super(name,upperClass);//null lower list , true is Leaf
		this.type=type;
		this.numbers=numbers;
		this.buyingPrice = buyingPrice;
		this.salePrice = salePrice;
		this.recentBuyingPrice = recentBuyingPrice;
		this.recentSalePrice = recentSalePrice;
		this.alarmingValue = alarmingValue;
		this.batchID = batchid;
		this.productionDate = productionDate;
	}

	
	
	
	
	/**
	 * 这个构造方法的存在似乎是不合理的
	 * 新生成商品时，应该要求属性完备的
	 * @param id
	 * @param name
	 * @param upperid
	 */
	
	public GoodsVO(String name,String upperid) {//this methods should be deleted after test 
		super(name,upperid);
	}
	public GoodsVO(String id,String name,String upperid) {
		super(id,name,upperid);
	}
	
	
	
	@Override
	public boolean equals(Object object) {
		if(object==null) {
			return false;
		}
		if (! (object instanceof GoodsVO)) {
			 
			return false;
		}
		
		GoodsVO vo = (GoodsVO) object;
		if (!vo.getID().equals(this.id))	return false;
		if (!vo.getName().equals(this.name)) 	return false;
		if (!vo.getUpperID().equals(this.upperID)) 	return false;
		
		return true;
	}
	
	
	public String getType(){return type;}
	public int getNumbers(){return numbers;}
	public double getBuyingPrice(){return buyingPrice;}
	public double getSalePrice(){return salePrice;}
	public double getRecentBuyingPrice(){return recentBuyingPrice;}
	public double getRecentSalePrice(){return recentSalePrice;}
	public int getAlarmingValue(){return alarmingValue;}
	public String getBatchID() {return this.batchID;}
	public Date getProductionDate() {return this.productionDate;}
	
	public boolean setType(String type) {this.type=type;return true;}
	public boolean setNumbers(int numbers) {this.numbers=numbers;return true;}
	public boolean setBuyingPrice(double buyingPrice) {this.buyingPrice=buyingPrice;return true;}
	public boolean setSalePrice(double salePrice) {this.salePrice=salePrice;return true;}
	public boolean setRecentBuyingPrice(double recentBuyingPrice) { this.recentBuyingPrice=recentBuyingPrice;return true;}
	public boolean setRecentSalePrice(double recentSalePrice) {this.recentSalePrice=recentSalePrice;return true;}
	public boolean setAlarmingValue(int value) {this.alarmingValue=value;return true;}

	public void setBatchID(String b) {this.batchID=b;}
	
}
