package vo.goods;

public class StockProcessItemVO {
	private String  goodsName ="" ;
	private String 	goodsXingHao="" ;
	private String  kind="";
	private int num=0;
	private double singleMoney=0;
	private double sum=0;
	private int leftNum=0;
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsXingHao() {
		return goodsXingHao;
	}
	public void setGoodsXingHao(String goodsXingHao) {
		this.goodsXingHao = goodsXingHao;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		sum=(num*singleMoney);
		this.num = num;
	}
	public double getSingleMoney() {
		sum=(num*singleMoney);
		return singleMoney;
	}
	public void setSingleMoney(double singleMoney) {
		this.singleMoney = singleMoney;
	}

	
	public int getLeftNum() {
		return leftNum;
	}
	public void setLeftNum(int leftNum) {
		this.leftNum = leftNum;
	}
	public double getSum() {
		return sum;
	}

	
}
