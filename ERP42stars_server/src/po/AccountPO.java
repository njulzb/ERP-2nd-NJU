package po;

import java.io.Serializable;

public class AccountPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4562005442680709535L;
	/**
	 * 
	 */
	/**
	 * 
	 */

	private String ID;
	private String name;
	private String password;
	private double moneyLeft=0;
	private  byte[]img;
	boolean isUsing =true;
	
	public String getID() {
		return ID;
	}
	public void setID(String id) {
		this.ID = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMoneyLeft() {
		return moneyLeft;
	}
	public void setMoneyLeft(double moneyLeft) {
		this.moneyLeft = moneyLeft;
	}

	public boolean isUsing() {
		return isUsing;
	}
	public void setUsing(boolean isUsing) {
		this.isUsing = isUsing;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
	
}
