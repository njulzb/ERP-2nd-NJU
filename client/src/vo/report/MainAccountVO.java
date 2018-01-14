package vo.report;

import java.util.Date;

/**
 * 账VO
 * （建账的账）
 * @author Eli
 *
 */
public class MainAccountVO {
	private Date createTime;
	private Date endTime;
	private String path;
	
	
	public Date getCreateTime(){
		return createTime;
	}
	public boolean setCreateTime(Date time){
		createTime=time;
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
}
