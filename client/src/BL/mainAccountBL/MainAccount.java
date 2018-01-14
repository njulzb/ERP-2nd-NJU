package BL.mainAccountBL;

import java.util.Date;

import po.MainAccountPO;
import utility.FileHelper;
import vo.report.MainAccountVO;

/**
 * 账VO （建账的账）
 * 
 * @author Eli
 *
 */
public class MainAccount {
	private Date createTime;
	private Date endTime;
	private String path;
	private byte[] data;

	public MainAccount(MainAccountPO o) {
		this.setCreateTime(o.getCreateTime());
		this.setEndTime(o.getEndTime());
		this.setData(o.getData());

	}

	public MainAccount(MainAccountVO o) {
		this.setCreateTime(o.getCreateTime());
		this.setEndTime(o.getEndTime());
		this.setPath(o.getPath());

	}

	public MainAccountVO toVO() {
		MainAccountVO o = new MainAccountVO();
		o.setCreateTime(this.getCreateTime());
		o.setEndTime(this.getEndTime());
		
		if (this.getData()!= null) {
			FileHelper.createFile(data, "temp\\", createTime.toString()+".sql");
		}
		return o;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public boolean setCreateTime(Date time) {
		createTime = time;
		return true;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
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
