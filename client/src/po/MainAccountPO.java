package po;

import java.util.Date;

/**
 * 账VO
 * （建账的账）
 * @author Eli
 *
 */
public class MainAccountPO {
	private Date createTime;
	private Date endTime;
	private byte[]data;
	
	
	public Date getCreateTime(){
		return createTime;
	}
	public boolean setCreateTime(Date time){
		createTime=time;
		return true;
	}


	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
}
