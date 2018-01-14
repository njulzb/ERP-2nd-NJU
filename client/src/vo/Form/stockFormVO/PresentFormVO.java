package vo.Form.stockFormVO;

import java.util.Date;

import utility.StateOfForm;
import vo.CustomerVO;
import vo.UserVO;

/**
 * 赠送单VO
 * @author 
 *
 */
public class PresentFormVO extends StockFormVO{

	private CustomerVO customer;

	public CustomerVO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerVO customer) {
		this.customer = customer;
	}
	
	
	
}
