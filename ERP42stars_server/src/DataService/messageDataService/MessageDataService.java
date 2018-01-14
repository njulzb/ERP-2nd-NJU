package DataService.messageDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.KeyForSearchMessage;
import po.LogItemPO;
import po.MessagePO;

public interface MessageDataService extends Remote{
	public void addMessage(MessagePO c) throws RemoteException ;
	public void deleteMessage(int id) throws RemoteException ;
	public void editMessage(MessagePO c) throws RemoteException ;
	public  ArrayList<MessagePO> searchMessage(KeyForSearchMessage key) throws RemoteException ;
	
}
