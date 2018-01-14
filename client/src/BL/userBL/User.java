



package BL.userBL;

import java.io.File;
import java.io.IOException;

import po.UserPO;
import utility.ByteHelper;
import utility.FileHelper;
import utility.RoleOfUser;
import vo.UserVO;

public class User {

	String id ;
	String name ;
	String password;
	RoleOfUser role;

	String imagePath;

	public User(String id,String name,String password,RoleOfUser role,String imagePath){
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
		this.imagePath = imagePath;
	}

	public User(String id,String name,String password,RoleOfUser role){
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;

	}



	public User(UserVO vo) {
		this.id = vo.getID();
		this.name = vo.getName();
		this.password = vo.getPassword();
		this.role = vo.getRole();
		this.imagePath = vo.getImagePath();
	}


	public User (UserPO po) {
		if (po==null) {
			return ;
		}
		this.id = po.getID();
		this.name = po.getName();
		this.password = po.getPassword();
		this.role = po.getRole();

		//String bin = this.getClass().getResource("").getPath();


		//System.out.println("this is bin"+bin);
//		this.imagePath = bin + this.id + ".png";

		this.imagePath = "c:\\temp\\" + this.id + ".png";


//		File dir = new File(bin + "userheadimg");
//		dir.mkdirs();

//=======
		//this.imagePath = bin + "userhead/" + this.id + ".png";
//>>>>>>> branch 'master' of http://101.37.19.32:10080/4-stars-on-the-rooftop/4-stars-on-the-rooftop.git
		ByteHelper.byteToImage(po.getImageByte(), this.imagePath);


	}



	public UserPO toPO() {
		byte[] image = ByteHelper.imageToByte(this.imagePath);
		return new UserPO(this.id,this.name,this.password,this.role,image);
	}

	public UserVO toVO() {

		return new UserVO(this.id,this.name,this.password,this.role,this.imagePath);
	}


//	get methods
	public String getID(){return id;}
	public String getName(){return name;}
	public String getPassword(){return password;}
	public RoleOfUser getRole(){return role;}
	public String getImagePath() {return this.imagePath;}

//	set methods
	public boolean setID(String newId){id = newId;return true;}
	public boolean setName(String newName){name = newName;return true;}
	public boolean setPassword(String newPassword){password = newPassword;return true;}
	public boolean setRole(RoleOfUser newRole){role = newRole;return true;}
	public boolean setImagePath(String imagePath) {

		boolean isCorrect = FileHelper.isFile(imagePath);
		if (!isCorrect) {
			return false;
		}

		this.imagePath = imagePath;
		return true;
	}



}
