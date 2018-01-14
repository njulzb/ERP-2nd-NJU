package po;

import java.io.Serializable;
import java.sql.Timestamp;

public class MessagePO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -197444442343703L;
	private int ID;
	private String senderID;
	private String receiverID;
	private String message;
	private boolean isRead;
	private Timestamp 	create;
	private Timestamp 	readTime;
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
	public boolean isRead() {
		return isRead;
	}
	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}
	public Timestamp getCreate() {
		return create;
	}
	public void setCreate(Timestamp create) {
		this.create = create;
	}
	public Timestamp getReadTime() {
		return readTime;
	}
	public void setReadTime(Timestamp readTime) {
		this.readTime = readTime;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	

}
