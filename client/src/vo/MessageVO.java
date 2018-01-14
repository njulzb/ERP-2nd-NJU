package vo;

import java.sql.Timestamp;

public class MessageVO {
	/**
	 * 
	 */

	private int ID;
	private String senderName_ID;
	private String receiverName_ID;
	private String message;
	private boolean isRead;
	private Timestamp create;
	private Timestamp readTime;

	public MessageVO() {

	}

	public MessageVO(String systemMessage,String receiverID) {
		this.message = systemMessage;
		this.senderName_ID = "SYSTEM";
		this.receiverName_ID=receiverID;
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

	public String getSenderName_ID() {
		return senderName_ID;
	}

	public void setSenderName_ID(String senderName_ID) {
		this.senderName_ID = senderName_ID;
	}

	public String getReceiverName_ID() {
		return receiverName_ID;
	}

	public void setReceiverName_ID(String receiverName_ID) {
		this.receiverName_ID = receiverName_ID;
	}

}
