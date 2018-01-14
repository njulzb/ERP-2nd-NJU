package po;

import java.io.Serializable;
import java.sql.Timestamp;

import utility.StateOfForm;

public class KeyForSearchLog implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1973384422186773703L;
	
	private String operatorID;
	private String message;
	private Timestamp 	createTimeMin=  Timestamp.valueOf("2010-01-01 00:00:00")  ,
						createTimeMax=  Timestamp.valueOf("2070-01-01 00:00:00");
	public String getOperatorID() {
		return operatorID;
	}
	public void setOperatorID(String operatorID) {
		this.operatorID = operatorID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getCreateTimeMin() {
		return createTimeMin;
	}
	public void setCreateTimeMin(Timestamp createTimeMin) {
		this.createTimeMin = createTimeMin;
	}
	public Timestamp getCreateTimeMax() {
		return createTimeMax;
	}
	public void setCreateTimeMax(Timestamp createTimeMax) {
		this.createTimeMax = createTimeMax;
	}


}
