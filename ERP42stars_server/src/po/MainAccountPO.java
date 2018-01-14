package po;

import java.io.Serializable;
import java.util.Date;

/**
 * 账VO
 * （建账的账）
 * @author Eli
 *
 */
public class MainAccountPO implements Serializable  {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 3L;
	Date createTime;
	public Date getCreateTime(){
		return createTime;
	}
	public boolean setCreateTime(Date time){
		createTime=time;
		return true;
	}
}
