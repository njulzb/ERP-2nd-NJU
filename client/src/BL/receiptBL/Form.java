package BL.receiptBL;

import java.rmi.RemoteException;
import java.sql.Timestamp;

import BL.userBL.UserController;
import po.formPO.FormPO;
import utility.RoleOfUser;
import utility.StateOfForm;
import vo.UserVO;
import vo.Form.FormVO;

/**
 * 所有form的父类，老祖宗了
 * @author lzb
 *
 */
public class Form {
	protected String ID = "00-default";
	protected StateOfForm state = StateOfForm.draft;
	protected Timestamp createTime = new Timestamp(System.currentTimeMillis());
	protected Timestamp saveTime = new Timestamp(System.currentTimeMillis());
	protected Timestamp submitTime = new Timestamp(System.currentTimeMillis());
	protected Timestamp passTime = new Timestamp(System.currentTimeMillis());
	protected Timestamp rejectTime = new Timestamp(System.currentTimeMillis());
	protected String rejectConment = "";
	protected UserVO operator = new UserVO("001", "defaultUser", "123456", RoleOfUser.FinancialManager);

	public Form() {

	}

	public FormVO toVO() {
		return null;

	}

	public FormPO toPO() {
		return null;

	}

	public boolean pass() {
		return false;
	}

	public Form(FormVO vo) {
		ID = vo.getID();
		state = vo.getState();
		createTime = vo.getCreateTime();
		saveTime = vo.getSaveTime();
		passTime = vo.getPassTime();
		submitTime = vo.getSubmitTime();
		rejectTime = vo.getRejectTime();
		rejectConment = vo.getDeniedComment();
		operator = vo.getOperator();

	}

	public Form(FormPO po) {
		ID = po.getID();
		state = po.getState();
		createTime = po.getCreateTime();
		saveTime = po.getSaveTime();
		passTime = po.getPassTime();
		submitTime = po.getSubmitTime();
		rejectTime = po.getRejectTime();
		rejectConment = po.getRejectConment();
		if (po.getOperatorID() != null) {
			try {
				operator = new UserController().getUserByID(po.getOperatorID()).toVO();
			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		else {
			operator =new UserVO("default","--1");
		}

	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public StateOfForm getState() {
		return state;
	}

	public void setState(StateOfForm state) {
		this.state = state;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
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

	public String getRejectConment() {
		return rejectConment;
	}

	public void setRejectConment(String rejectConment) {
		this.rejectConment = rejectConment;
	}

	public UserVO getOperator() {
		return operator;
	}

	public void setOperator(UserVO operator) {
		this.operator = operator;
	}

}
