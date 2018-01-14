package po;

import java.io.Serializable;

import utility.RoleOfUser;

/**用于验证户登录
 * @author MXF , LZB
 *
 */

public class UserPO implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String id ;
	String name ;
	String password ;
	RoleOfUser role;
	
	byte[] imageByte;
	
	
	public UserPO(String id,String name,String password,RoleOfUser role){
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
	}
	
	public UserPO(String id,String name,String password,RoleOfUser role,byte[] imageByte){
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
		this.imageByte = imageByte;
	}

	
	
	//get methods
	public String getName(){return name;}
	public String getID(){return id;}
	public String getPassword(){return password;}
	public RoleOfUser getRole(){return role;}
	public byte[] getImageByte() {return this.imageByte;}
	
	//set methods
	public boolean setID(String id){this.id = id;return true;}
	public boolean setName(String name){	this.name = name;return true;}
	public boolean setPassword(String password){this.password = password;return true;}
	public boolean setRole(RoleOfUser role){this.role = role;return true;}
	public boolean setImageByte(byte[] image) {this.imageByte = image;return true;}
	
	
	
}
