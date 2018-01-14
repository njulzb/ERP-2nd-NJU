package vo.report;

import java.util.Date;

import utility.KindOfForm;
import vo.CustomerVO;
import vo.UserVO;

public class KeyForSearchReport {

	public KindOfForm kindOfForm;
	public Date begin,end;
	public String goodsName;
	public CustomerVO customer;
	public UserVO operator;
	public String warehouse;

	public KeyForSearchReport(KindOfForm kind,Date begin, Date end,
			String goodsname , CustomerVO customer , UserVO operator ,String warehouse) {
		this.kindOfForm = kind;
		this.begin = begin;
		this.end = end;
		this.goodsName = goodsname;
		this.operator = operator;
		this.warehouse = warehouse;
	}
	
}
