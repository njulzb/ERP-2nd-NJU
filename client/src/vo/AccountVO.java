package vo;

import javafx.scene.image.Image;

/**
 * 银行账户VO
 * @author Eli
 *
 */

public class AccountVO {
	private String 	name="未命名";
	private String 	ID="00000";
	private	double 	money=0;
	private Image image;
	private String imagePath ="";
	private String password="";
	
	
	public AccountVO(String na,String i,double mo ){
		name=na;
		ID=i;
		money=mo;
	}
	public AccountVO() {
		// TODO 自动生成的构造函数存根
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String id) {
		this.ID = id;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	
}
