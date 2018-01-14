package po;

import java.io.Serializable;
import java.sql.Timestamp;

public class KeyForSearchMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1974444422186773703L;
	
	private String senderID;
	private String receiverID;
	private String message;
	private int isRead;
	private Timestamp 	createTimeMin=  Timestamp.valueOf("2010-01-01 00:00:00")  ,
						createTimeMax=  Timestamp.valueOf("2070-01-01 00:00:00");
	private Timestamp 	readTimeMin=  Timestamp.valueOf("2010-01-01 00:00:00")  ,
						readTimeMax=  Timestamp.valueOf("2070-01-01 00:00:00");
	public String getSenderID() {
		return senderID;
	}
	public void setSenderID(String senderID) {
		this.senderID = senderID;
	}
	public String getReceiverID() {
		return receiverID;
	}
	public void setReceiverID(String receiverID) {
		this.receiverID = receiverID;
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
	public Timestamp getReadTimeMin() {
		return readTimeMin;
	}
	public void setReadTimeMin(Timestamp readTimeMin) {
		this.readTimeMin = readTimeMin;
	}
	public Timestamp getReadTimeMax() {
		return readTimeMax;
	}
	public void setReadTimeMax(Timestamp readTimeMax) {
		this.readTimeMax = readTimeMax;
	}
	public int getIsRead() {
		return isRead;
	}
	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}
	

}
