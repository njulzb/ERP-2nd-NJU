package BL.stockBL;

import java.util.Date;

import po.goods.GoodsPO;
import vo.goods.GoodsForShotVO;
import vo.goods.GoodsVO;

public class Goods extends GoodsClass{

	/*
	 * properties 
	 * 	 like id,name ,upperClass is included in super class(GoodsClass)
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
	
//	----------------------------------------------constructors below
	
	
	/**
	 * 完整版构造函数
	 * @param id
	 * @param name
	 * @param upperid
	 * @param type
	 * @param numbers
	 * @param buyingPrice
	 * @param salePrice
	 * @param recentBuyingPrice
	 * @param recentSalePrice
	 * @param alarmingValue
	 * @param batchID
	 * @param productionDate
	 */
	public Goods(String id,String name,String upperid,String imgPath,
			String type,int numbers,
			double buyingPrice,double salePrice,double recentBuyingPrice,double recentSalePrice,
			int alarmingValue,String batchID,Date productionDate){
		super(id,name,upperid,imgPath);
		
		this.type=type;
		this.numbers=numbers;
		this.buyingPrice = buyingPrice;
		this.salePrice = salePrice;
		this.recentBuyingPrice = recentBuyingPrice;
		this.recentSalePrice = recentSalePrice;
		this.alarmingValue = alarmingValue;
		
		this.batchID = batchID;
		this.productionDate = productionDate;
		
	}
	
	/**
	 * 由VO构造函数
	 * @param vo
	 */
	public Goods (GoodsVO vo) {
		
		this(vo.getID(),vo.getName(),vo.getUpperID(),vo.getImagePath(),
				vo.getType(),vo.getNumbers(),
				vo.getBuyingPrice(),vo.getSalePrice(),vo.getRecentBuyingPrice(),vo.getRecentSalePrice(),
				vo.getAlarmingValue(),vo.getBatchID(),vo.getProductionDate());


		
	}
	
	public Goods (GoodsPO po) {
		super(po);
		this.id = Goods.goodsIdToString(po.getID());
//		super(Goods.goodsIdToString(po.getID()),
//				po.getName(),
//				Goods.classIdToString(po.getUpper()));
		
		
		
		this.type = po.getType();
		this.numbers = po.getNumber();
		this.buyingPrice = po.getBuyingPrice();
		this.salePrice = po.getSalePrice();
		this.recentBuyingPrice = po.getRecenBuyingtPrice();
		this.recentSalePrice = po.getRecentSalePrice();
		
		this.batchID = po.getBatchID();
		this.productionDate = po.getProductionDate();
	}
//	-------------------------constructors above
	
	@Override
	public GoodsVO toVO() {
		
		String id = this.id;
		String name = this.name;
		String upperid = this.upperClassID;
		String imagePath = this.imagePath;
		
		String type = this.type;
		int numbers = this.numbers;
		double buyingPrice = this.buyingPrice;
		double salePrice = this.salePrice;
		double recentBuyingPrice = this.recentBuyingPrice;
		double recentSalePrice = this.recentSalePrice;
		int alarmingValue = this.alarmingValue;

		String batchID = this.batchID;
		Date productionDate = this.productionDate;
		
		GoodsVO result = new GoodsVO(id,name,upperid,imagePath,
				type,numbers,buyingPrice,salePrice,recentBuyingPrice,recentSalePrice,alarmingValue,
				batchID,productionDate);
		return result;
	}
	
	@Override
	public GoodsPO toPO() {
		
		
		
		
		GoodsPO result = new GoodsPO(goodsIdToInt(this.id),this.name,GoodsClass.classIdToInt(this.upperClassID),super.imageToByte(this.imagePath),
				this.type,this.numbers,
				this.buyingPrice,this.salePrice,this.recentBuyingPrice,this.recentSalePrice,
				this.alarmingValue,this.batchID,this.productionDate);
		
		return result;
	}
	
	/**
	 * 转成商品快照的方法
	 * @return
	 */
	public GoodsForShotVO toSnapShot() {
		return new GoodsForShotVO(this.id,this.name,this.type,this.numbers,this.salePrice,this.batchID,this.productionDate);
	}
	
	public static int goodsIdToInt(String id) {
		
		if (id == null) {
			return 0;
		}
		if (!id.contains("SP")) {
			
			return 0;
		}
		id = id.substring(2);
		int result = 0;
		for (char c:id.toCharArray()) {
			if ('0'<=c && c<='9') {
				result = result* 10 + c -'0';
			}
			
		}
		
		return result;
	}
	
	public static String goodsIdToString(int id) {
		if (id<=0) {
			return null;
		}
		return "SP" + id;
	}
	
	public String getType(){return type;}
	public int getNumbers(){return numbers;}
	public double getBuyingPrice(){return buyingPrice;}
	public double getSalePrice(){return salePrice;}
	public double getRecentBuyingPrice(){return recentBuyingPrice;}
	public double getRecentSalePrice(){return recentSalePrice;}
	public int getAlarmingValue(){return alarmingValue;}
	

	
	public boolean setType(String type) {this.type=type;return true;}
	public boolean setNumbers(int numbers) {this.numbers=numbers;return true;}
	public boolean setBuyingPrice(double buyingPrice) {this.buyingPrice=buyingPrice;return true;}
	public boolean setSalePrice(double salePrice) {this.salePrice=salePrice;return true;}
	public boolean setRecentBuyingPrice(double recentBuyingPrice) { this.recentBuyingPrice=recentBuyingPrice;return true;}
	public boolean setRecentSalePrice(double recentSalePrice) {this.recentSalePrice=recentSalePrice;return true;}
	public boolean setAlarmingValue(int value) {this.alarmingValue=value;return true;}
	

}
