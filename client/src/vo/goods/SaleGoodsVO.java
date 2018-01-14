package vo.goods;

//extends wrong class
public class SaleGoodsVO extends GoodsClassVO{
	
	String type;
	int numbers;
	double price;
	double totalAmount;
	String comment;

	
	
	
	public SaleGoodsVO(String id,String name,String upperClassID,String type,int numbers,
			double price,double totalAmount,String comment) {
		super(id,name,upperClassID);
		this.type=type;
		this.numbers=numbers;
		this.price=price;
		this.totalAmount=totalAmount;
		this.comment=comment;
	}
	
	
	//set method;
	public boolean setType(String type){ this.type=type; return true;}
	public boolean setNumbers(int num){ this.numbers=num; return true;}
	public boolean setPrice(double price){ this.price=price; return true;}
	public boolean setRTotalAmount(double totalAmount){ this.totalAmount=totalAmount; return true;}
	public boolean setComment(String text){ this.comment=text; return true;}
	
	//get methods;
	@Override
	public String getID(){return id;}
	@Override
	public String getName(){return name;}
	@Override
	public String getUpperID() {return upperID;}
	
	public String getType(){return type;}
	public int getNumbers(){return numbers;}
	public double getPrice(){return price;}
	public double getRTotalAmount(){return totalAmount;}
	public String getComment(){return comment;}
	
}
