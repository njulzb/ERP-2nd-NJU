package po;

import java.io.Serializable;

import utility.LevelOfCustomer;
import utility.TypeOfCustomer;

/**
 * 顾客信息PO
 * @author hqj,LZB
 *
 */


public class CustomerPO  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1258425311343659672L;
	private String ID;
	private TypeOfCustomer type;
	private LevelOfCustomer level;
	
	private String name;
	private String phoneNumber;
	private String address;
	private String postcode;
	private String email;
	private byte[] img;
	
	private double receiveLimit;
	private double receiveAmount;
	private double payAmount;

	private String defaultOperatorID;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public TypeOfCustomer getType() {
		return type;
	}

	public void setType(TypeOfCustomer type) {
		this.type = type;
	}

	public LevelOfCustomer getLevel() {
		return level;
	}

	public void setLevel(LevelOfCustomer level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public double getReceiveLimit() {
		return receiveLimit;
	}

	public void setReceiveLimit(double receiveLimit) {
		this.receiveLimit = receiveLimit;
	}

	public double getReceiveAmount() {
		return receiveAmount;
	}

	public void setReceiveAmount(double receiveAmount) {
		this.receiveAmount = receiveAmount;
	}

	public double getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}

	public String getDefaultOperatorID() {
		return defaultOperatorID;
	}

	public void setDefaultOperatorID(String defaultOperatorID) {
		this.defaultOperatorID = defaultOperatorID;
	}
	


	
}
