package po.formPO;

import java.io.Serializable;
import java.sql.Timestamp;
import utility.StateOfForm;


/**
 * @author LZB
 *
 */
public class FormPO  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private byte[] byte_list;
	protected String ID="clientPO";
	protected StateOfForm state=StateOfForm.draft;	//there are 3 states of form 1. draft 2. admitted 3. pass
	protected String operatorID="";
	protected Timestamp createTime=new Timestamp(System.currentTimeMillis());
	protected Timestamp saveTime=new Timestamp(System.currentTimeMillis());
	protected Timestamp submitTime=new Timestamp(System.currentTimeMillis());
	protected Timestamp passTime=new Timestamp(System.currentTimeMillis());
	protected Timestamp rejectTime=new Timestamp(System.currentTimeMillis());
	protected String rejectConment="";
	
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
	public String getOperatorID() {
		return operatorID;
	}
	public void setOperatorID(String operatorID) {
		this.operatorID = operatorID;
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
	public void setRejectConment(String rejectComment) {
		this.rejectConment = rejectComment;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public byte[] getByte_list() {
		return byte_list;
	}
	public void setByte_list(byte[] byte_list) {
		this.byte_list = byte_list;
	}
	


}
