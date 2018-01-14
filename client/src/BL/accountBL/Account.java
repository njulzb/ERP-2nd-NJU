package BL.accountBL;

import java.io.File;

import javafx.scene.image.Image;
import po.AccountPO;
import utility.FileHelper;
import vo.AccountVO;

public class Account {
	private String 	name="未命名";
	private String 	ID="00000";
	private	double 	money=0;
	private Image image;
	private String imagePath ="";
	private String password="";
	
	
 	
	public Account(String na,String i,double mo ){
		name=na;
		ID=i;
		money=mo;
	}
	public Account(AccountVO vo) {
		name=vo.getName();
		ID=vo.getID();
		money=vo.getMoney();
		image=vo.getImage();
		setImagePath(vo.getImagePath());
		setPassword(vo.getPassword());
		
	}
	public Account(AccountPO po) {
		name=po.getName();
		ID=po.getID();
		money=po.getMoneyLeft();
		setPassword(po.getPassword());
		
		String Path="c:\\temp";
		String na= po.getImg().hashCode()+".png";
		 
		FileHelper.createFile(po.getImg(), Path,na);
		imagePath =Path+"\\"+na;
	}
	public Account() {
		// TODO 自动生成的构造函数存根
	}
	
	
	public AccountVO toVO() {
		AccountVO out=new AccountVO();
		out.setID(ID);
		out.setImage(image);
		out.setImagePath(imagePath);
		out.setMoney(money);
		out.setName(name);
		out.setPassword(password);
		
		return out;
		
		
	}
	public AccountPO toPO() {
		AccountPO out=new AccountPO();
		out.setID(ID);
		out.setImg(FileHelper.getBytes(imagePath));
		out.setMoneyLeft(money);
		out.setName(name);
		out.setPassword(password);
		
		return out;
	
		
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
