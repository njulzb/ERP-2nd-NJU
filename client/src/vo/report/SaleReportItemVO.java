package vo.report;

import java.util.Date;

import vo.goods.GoodsVO;

public class SaleReportItemVO {

	public Date date;
	public GoodsVO goods;
	public double sum ;
	public SaleReportItemVO(Date date , GoodsVO goods) {
		this.date = date;
		this.goods = goods;
		this.sum = this.goods.getSalePrice() * this.goods.getNumbers();
	}
}
