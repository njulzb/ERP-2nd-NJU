package BL.userBL;

import java.rmi.RemoteException;

public interface UserInfo {
	public User  getUserByID (String ID) throws RemoteException;

}
