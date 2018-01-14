package po.formPO.tradeFormPO;

import po.UserPO;

public class SaleReturnFormPO  extends TradeFormPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserPO defaultSalesMan;
	double amountWithoutDiscount;
	double discount;
	double voucher;
	public UserPO getDefaultSalesMan() {
		return defaultSalesMan;
	}
	public void setDefaultSalesMan(UserPO defaultSalesMan) {
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
