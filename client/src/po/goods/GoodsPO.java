package po.goods;

import java.io.Serializable;
import java.util.Date;

/**
 * @author LZB
 *
 */
public class GoodsPO extends GoodsClassPO implements Serializable{



	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * id ,name is included in superclass
	 * lowerClasses is default null 
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
	
	public GoodsPO(int id, String name, int upper,byte[] imageByte,//父类属性
			String type,int numbers,
			double buyingPrice,double salePrice,double recentBuyingPrice,double recentSalePrice,
			int alarmingValue,String batchID,Date productionDate) {
		super(id, name, upper,imageByte);
		//null initialization may be something wrong
		// TODO Auto-generated constructor stub
		this.type = type;
		this.numbers=numbers;
		this.buyingPrice=buyingPrice;
		this.salePrice=salePrice;
		this.recentBuyingPrice=recentBuyingPrice;
		this.recentSalePrice=recentSalePrice;
		this.alarmingValue=alarmingValue;
		this.batchID = batchID;
		this.productionDate = productionDate;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof GoodsPO == false) {
			return false;
		}
		GoodsPO b = (GoodsPO)obj;
		
		if (super.equals(b)==false)	return false;
		if (!this.type.equals(b.type))	return false;
		if (this.numbers!=b.numbers)	return false;
		if (this.buyingPrice!=b.buyingPrice)	return false;
		if (this.salePrice!=b.salePrice)	return false;
		if (this.recentBuyingPrice!=b.recentBuyingPrice)	return false;
		if (this.recentSalePrice!=b.recentSalePrice)	return false;
		if (this.alarmingValue!=b.alarmingValue)	return false;
		if (this.batchID.equals(b.batchID)==false)	return false;
		if (this.productionDate.equals(b.productionDate) == false)	return false;
		

		
		return true;
	}
	
	
	//get methods 
	public String getType() {return this.type;}
	public int getNumber() {return this.numbers;}
	public double getBuyingPrice() {return this.buyingPrice;}
	public double getSalePrice() {return this.salePrice;}
	public double getRecenBuyingtPrice() {return this.recentBuyingPrice;}
	public double getRecentSalePrice() {return this.recentSalePrice;}
	public int getAlarmingValue() {return this.alarmingValue;}
	
	public String getBatchID() {return this.batchID;}
	public Date getProductionDate() {return this.productionDate;}
}
