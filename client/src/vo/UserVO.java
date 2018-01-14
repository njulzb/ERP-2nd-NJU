package vo;

import utility.FileHelper;
import utility.RoleOfUser;

/**
 * 用户登录与验证
 * @author mxf,lzb
 *大哥们千万不要删掉构造方法啊啊，多多益善灵活好用啊
 *re: 可是万一你信息没填完整，那不是满天下去找bug了
 */
public class UserVO {
	
	String id ;
	String name ;
	String password;
	
	RoleOfUser role;
	String imagePath;
	
	
	public UserVO(String id,String name,String password,RoleOfUser role,String imagePath){
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
		this.imagePath = imagePath;
	}
	
	public UserVO(String id,String name,String password,RoleOfUser role){
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
		
	}

	
	public UserVO() {
		
	}
	public UserVO(String id,String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj==null) {
			return false;
		}
		UserVO vo = (UserVO) obj;
		if (this.id.equals(vo.getID())==false) 	return false;
		if (this.name.equals(vo.getName()) == false) 	return false;
		if (this.password.equals(vo.getPassword())==false)return false;
		if (this.role!=vo.getRole()) 	return false;
		
		return true;
		
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
