package vo;

import utility.LevelOfCustomer;
import utility.TypeOfCustomer;

/**
 * 顾客信息VO
 *
 * @author hqj
 *
 */

public class CustomerVO {

	String id;
	TypeOfCustomer type;
	LevelOfCustomer level;

	String name;
	String phoneNumber;
	String address;
	String postcode;
	String email;

	double receiveLimit;
	double receiveAmount;
	double payAmount;
	String imagePath;
	String defaultOperatorid;

	public CustomerVO(String id, TypeOfCustomer type, LevelOfCustomer level, String name, String phoneNumber,
			String address, String postcode, String email, double receiveLimit, double receiveAmount, double payAmount, String imagePath,
			String operatorid) {

		this.id = id;
		this.type = type;
		this.level = level;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.postcode = postcode;
		this.email = email;
		this.receiveLimit = receiveLimit;
		this.receiveAmount = receiveAmount;
		this.payAmount = payAmount;
		this.defaultOperatorid = operatorid;
		this.imagePath = imagePath;

	}

	public CustomerVO() {

	}

	public CustomerVO(String in) {
		this.name = in;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LevelOfCustomer getLevel() {
		return level;
	}

	public void setLevel(LevelOfCustomer level) {
		this.level = level;
	}

	public void setLevel(String level) {
		if (level.equals(LevelOfCustomer.level1)){
			this.level=LevelOfCustomer.level1;
		}
		if (level.equals(LevelOfCustomer.level2)){
			this.level=LevelOfCustomer.level2;
		}
		if (level.equals(LevelOfCustomer.level3)){
			this.level=LevelOfCustomer.level3;
		}
		if (level.equals(LevelOfCustomer.level4)){
			this.level=LevelOfCustomer.level4;
		}
		if (level.equals(LevelOfCustomer.level5)){
			this.level=LevelOfCustomer.level5;
		}

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

	public String getDefaultOperatorid() {
		return defaultOperatorid;
	}

	public void setDefaultOperatorid(String defaultOperatorid) {
		this.defaultOperatorid = defaultOperatorid;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setType(TypeOfCustomer type){
		this.type=type;
	}

	public void setType(String type){
		if (type.equals(TypeOfCustomer.exporter)){
			this.type=TypeOfCustomer.exporter;
		}
		if (type.equals(TypeOfCustomer.importer)){
			this.type=TypeOfCustomer.importer;
		}
	}

	public TypeOfCustomer getType(){
		return this.type;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj==null) {
			return false;
		}
		CustomerVO vo = (CustomerVO) obj;
//		if (this.id.equals(vo.getId())==false) {
//			System.out.println(this.id);
//			System.out.println(vo.id);
//			return false;
//		}
		if (this.name.equals(vo.getName()) == false)  {
			System.out.println(this.name);
			return false;
		}
		if (this.address.equals(vo.getAddress())==false) {
			System.out.println(this.address);
			return false;
		}
		if (this.defaultOperatorid.equals(vo.getDefaultOperatorid())==false)  {
			System.out.println(this.defaultOperatorid);
			return false;
		}
		if (this.email.equals(vo.getEmail())==false) {
			System.out.println(this.email);
			return false;
		}
//		if (this.imagePath.equals(vo.getImagePath())==false) {
//			System.out.println(this.imagePath);
//			System.out.println(vo.imagePath);
//			return false;
//		}
		if (this.phoneNumber.equals(vo.getPhoneNumber())==false) {
			System.out.println(this.phoneNumber);
			return false;
		}
		if (this.postcode.equals(vo.getPostcode())==false) {
			System.out.println(this.postcode);
			return false;
		}
		if (this.type.equals(vo.getType())==false) {
			System.out.println(this.type);
			return false;
		}
		if (this.level.equals(vo.getLevel())==false) {
			System.out.println(this.level);
			return false;
		}
		if (this.payAmount!=vo.getPayAmount()) {
			System.out.println(this.payAmount);
			System.out.println(vo.payAmount);
			return false;
		}
		if (this.receiveAmount!=vo.getReceiveAmount()) {
			System.out.println(this.receiveAmount);
			System.out.println(vo.receiveAmount);
			return false;
		}
		if (this.receiveLimit!=vo.getReceiveLimit()) {
			System.out.println(this.receiveLimit);
			System.out.println(vo.receiveLimit);
			return false;
		}
		return true;

	}

}
