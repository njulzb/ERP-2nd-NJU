package po.goods;

public class saleGoodsPO extends GoodsClassPO{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String type;
	int numbers;
	double price;
	double totalAmount;
	String comment;
	
	public saleGoodsPO(int id,String name,int upperClass,String type,int numbers,
			double price,double totalAmount,String comment) {
		super(id,name,upperClass);
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
	public int getID(){return id;}
	public String getName(){return name;}

	
	public String getType(){return type;}
	public int getNumbers(){return numbers;}
	public double getPrice(){return price;}
	public double getRTotalAmount(){return totalAmount;}
	public String getComment(){return comment;}
	
}
