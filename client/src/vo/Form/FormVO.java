package vo.Form;

import java.sql.Timestamp;
import java.util.Date;

import BL.receiptBL.Form;
import utility.KindOfForm;
import utility.StateOfForm;
import vo.CustomerVO;
import vo.UserVO;

/**
 * 所有单据（form）的父类 主要包含 时间、 编号、 操作员、审批状态
 * 
 * @author Eli , LZB
 *
 */
public class FormVO {

	String ID;
	StateOfForm state = StateOfForm.draft; // 单据的审批状态：1.draft，2.admitted，3.pass 4.rejected

	String longstr;
	KindOfForm kind;

	protected UserVO operator;
	protected String deniedComment;// 驳回意见 String timestamp = String.valueOf();
	protected Timestamp createTime = new Timestamp(System.currentTimeMillis());
	protected Timestamp saveTime = new Timestamp(System.currentTimeMillis());
	protected Timestamp submitTime = new Timestamp(System.currentTimeMillis());
	protected Timestamp passTime = new Timestamp(System.currentTimeMillis());
	protected Timestamp rejectTime = new Timestamp(System.currentTimeMillis());

	public FormVO() {

	}

	public KindOfForm getKind() {
		return this.kind;
	}

	public String getAnalysis() {
		return this.longstr;
	}

	public String[] toLine() {

		int numOfItem = 11;
		String[] content = new String[numOfItem];

		int col = 0;
		content[col++] = this.getID();
		content[col++] = this.getKind().toString();
		content[col++] = this.getState().toString();
		content[col++] = this.getOperator().getID();
		content[col++] = this.getDeniedComment();
		content[col++] = this.getCreateTime().toString();
		content[col++] = this.getSaveTime().toString();
		content[col++] = this.getSubmitTime().toString();
		content[col++] = this.getPassTime().toString();
		content[col++] = this.getRejectTime().toString();
		content[col++] = this.getAnalysis();

		return content;

	}

	public FormVO(UserVO operatorx, String idx, StateOfForm statex, Date times) {
		operator = operatorx;
		ID = idx;
		state = statex;
		// setCreateTime(times);

	}

	public FormVO(Form form) {
		ID = form.getID();
		state = form.getState();
		setCreateTime(form.getCreateTime());
		saveTime = form.getSaveTime();
		passTime = form.getPassTime();
		rejectTime = form.getRejectTime();
		submitTime = form.getSubmitTime();
		deniedComment = form.getRejectConment();
		operator = form.getOperator();
	}

	// get methods
	public String getID() {
		return ID;
	}

	public StateOfForm getState() {
		return state;
	}

	public UserVO getOperator() {
		return operator;
	}

	// set methods
	public boolean setID(String id) {
		this.ID = id;
		return true;
	}

	public boolean setState(StateOfForm state) {
		this.state = state;
		return true;
	}

	public boolean setOperator(UserVO operator) {
		this.operator = operator;
		return true;
	}

	public String getDeniedComment() {
		return deniedComment;
	}

	public void setDeniedComment(String deniedComment) {
		this.deniedComment = deniedComment;
	}

	public Timestamp getSaveTime() {
		return saveTime;
	}

	public void setSaveTime(Timestamp saveTime) {
		this.saveTime = saveTime;
	}

	public Timestamp getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Timestamp submitTime) {
		this.submitTime = submitTime;
	}

	public Timestamp getPassTime() {
		return passTime;
	}

	public void setPassTime(Timestamp passTime) {
		this.passTime = passTime;
	}

	public Timestamp getRejectTime() {
		return rejectTime;
	}

	public void setRejectTime(Timestamp rejectTime) {
		this.rejectTime = rejectTime;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	////// ————————————————————————垃圾方法（勿删）————————————————————————————————————
	public CustomerVO getCustomer() {
		return null;
	}
	public void setCustomer(CustomerVO customer) {
		
	}
	public double getMoneyZheRang() {
		return -1;
	}

	public void setMoneyZheRang(double moneyZheRang) {

	}

	public double getMoneyDaiJinQuan() {
		return -1;

	}

	public void setMoneyDaiJinQuan(double moneyDaiJinQuan) {

	}

	public double getMoneyStrategy() {
		return -1;

	}

	public void setMoneyStrategy(double moneyStrategy) {

	}
}
