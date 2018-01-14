package vo.goods;

import java.util.Date;

/**
 * 各种商品的名称，型号，库存数量，库存均价，批次，批号，出厂日期
 * @author lzb
 *
 */
public class GoodsForShotVO {

	String id;
	String name;
	String type;
	int number;
	double averPrice=0;
	String batchID;
	Date productionDate;
	
	public GoodsForShotVO(String id,String name,String type,int number,double averPrice,String batchID,Date productionDate) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.number = number;
		this.averPrice = averPrice;
		this.batchID = batchID;
		this.productionDate = productionDate;
	}
	
	

	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}
	
	public int getNumber() {return number;}
	public void setNumber(int number) {this.number = number;}
	
	public double getAverPrice() {return averPrice;}
	public void setAverPrice(double averPrice) {this.averPrice = averPrice;}
	
	public String getBatchID() {return batchID;}
	public void setBatchID(String batchID) {this.batchID = batchID;}
	
	public Date getProductionDate() {return productionDate;}
	public void setProductionDate(Date productionDate) {this.productionDate = productionDate;}
}
