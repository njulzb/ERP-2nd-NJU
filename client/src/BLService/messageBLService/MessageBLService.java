package BLService.messageBLService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.KeyForSearchMessage;
import vo.MessageVO;

public interface MessageBLService {
	public void addMessage(MessageVO c) throws RemoteException ;
	public void deleteMessage(int id) throws RemoteException ;
	public void editMessage(MessageVO c) throws RemoteException ;
	public  ArrayList<MessageVO> searchMessage(KeyForSearchMessage key) throws RemoteException ;
	
}
