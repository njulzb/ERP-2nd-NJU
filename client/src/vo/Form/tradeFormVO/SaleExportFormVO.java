package vo.Form.tradeFormVO;

import vo.UserVO;

public class SaleExportFormVO extends TradeFormVO{
	UserVO defaultSalesMan;
	double amountWithoutDiscount;
	double discount;
	double voucher;
	public UserVO getDefaultSalesMan() {
		return defaultSalesMan;
	}
	public void setDefaultSalesMan(UserVO defaultSalesMan) {
		this.defaultSalesMan = defaultSalesMan;
	}
	public double getAmountWithoutDiscount() {
		return amountWithoutDiscount;
	}
	public void setAmountWithoutDiscount(double amountWithoutDiscount) {
		this.amountWithoutDiscount = amountWithoutDiscount;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getVoucher() {
		return voucher;
	}
	public void setVoucher(double voucher) {
		this.voucher = voucher;
	}
	
}
