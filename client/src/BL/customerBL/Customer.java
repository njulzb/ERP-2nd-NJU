package BL.customerBL;

import java.io.File;

import po.CustomerPO;
import utility.FileHelper;
import utility.LevelOfCustomer;
import utility.TypeOfCustomer;
import vo.CustomerVO;

public class Customer {

	String id;
	TypeOfCustomer type;
	LevelOfCustomer level;
	String name;
	String phoneNumber;
	String address;
	String postcode;
	String email;
	String imagePath;

	double receiveLimit;
	double receiveAmount;
	double payAmount;

	String defaultOperatorid;

	public Customer(String id, TypeOfCustomer type, LevelOfCustomer level, String name, String phoneNumber,
			String address, String postcode, String email, double receiveLimit, double receiveAmount, double payAmount,
			String operatorid, String imagePath) {

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

	public Customer() {
		// TODO 自动生成的构造函数存根
		//this.imagePath = getFolderPath()+"/img/default/test.png";
		//this.imagePath = getFolderPath() + "/img/default/test.png";
	}
//
//	String getFolderPath() {//获得文件夹路径
//		File directory = new File("");// 设定为当前文件夹
//		String folderPath = "";
//		try {
//			folderPath = directory.getCanonicalPath();
//
//		} catch (Exception e) {
//		}
//		return folderPath;
//	}

	public Customer(CustomerPO customerPO) {//用customerpo构造customer
		// TODO Auto-generated constructor stub
		if (customerPO.getImg()==null){
			this.imagePath = "c:\\temp\\default.png";
		}else{
			String imageName = customerPO.getImg().hashCode()+".png";
			String Path="c:\\temp";

			FileHelper.createFile(customerPO.getImg(), Path, imageName);
			this.imagePath = Path+"\\" + imageName;
		}


		this.id = customerPO.getID();
		this.type=customerPO.getType();
		this.level = customerPO.getLevel();
		this.name = customerPO.getName();
		this.phoneNumber = customerPO.getPhoneNumber();
		this.address = customerPO.getAddress();
		this.postcode = customerPO.getPostcode();
		this.email = customerPO.getEmail();
		this.receiveLimit = customerPO.getReceiveLimit();
		this.receiveAmount = customerPO.getReceiveAmount();
		this.payAmount = customerPO.getPayAmount();
		this.defaultOperatorid = customerPO.getDefaultOperatorID();
	}

	public Customer(CustomerVO customerVO) {//用customervo构造customer
		// TODO Auto-generated constructor stub

		this.id = customerVO.getId();
		this.type=customerVO.getType();
		this.level = customerVO.getLevel();
		this.name = customerVO.getName();
		this.phoneNumber = customerVO.getPhoneNumber();
		this.address = customerVO.getAddress();
		this.postcode = customerVO.getPostcode();
		this.email = customerVO.getEmail();
		this.receiveLimit = customerVO.getReceiveLimit();
		this.receiveAmount = customerVO.getReceiveAmount();
		this.payAmount = customerVO.getPayAmount();
		this.defaultOperatorid = customerVO.getDefaultOperatorid();
		this.imagePath = customerVO.getImagePath();
	}

	// set methods;

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

	public TypeOfCustomer getType(){
		return this.type;
	}

	public CustomerPO toCsutomerPO() {
		byte image[] = FileHelper.getBytes(this.imagePath);

		CustomerPO customerPO = new CustomerPO();
		customerPO.setType(this.type);
		customerPO.setAddress(this.address);
		customerPO.setDefaultOperatorID(this.defaultOperatorid);
		customerPO.setEmail(this.email);
		customerPO.setID(this.id);
		customerPO.setImg(image);
		customerPO.setLevel(this.level);
		customerPO.setName(this.name);
		customerPO.setPayAmount(this.payAmount);
		customerPO.setPhoneNumber(this.phoneNumber);
		customerPO.setPostcode(this.postcode);
		customerPO.setReceiveAmount(this.receiveAmount);
		customerPO.setReceiveLimit(this.receiveLimit);
		return customerPO;
	}

	public CustomerVO toCsutomerVO() {
		CustomerVO customerVO = new CustomerVO();
		customerVO.setType(this.type);
		customerVO.setAddress(this.address);
		customerVO.setDefaultOperatorid(this.defaultOperatorid);
		customerVO.setEmail(this.email);
		customerVO.setId(this.id);
		customerVO.setImagePath(this.imagePath);
		customerVO.setLevel(this.level);
		customerVO.setName(this.name);
		customerVO.setPayAmount(this.payAmount);
		customerVO.setPhoneNumber(this.phoneNumber);
		customerVO.setPostcode(this.postcode);
		customerVO.setReceiveAmount(this.receiveAmount);
		customerVO.setReceiveLimit(this.receiveLimit);
		return customerVO;
	}
}
