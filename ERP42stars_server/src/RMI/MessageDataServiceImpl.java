package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Data.messageData.MessageController;
import DataService.messageDataService.MessageDataService;
import po.KeyForSearchMessage;
import po.MessagePO;
import po.UserPO;

public class MessageDataServiceImpl extends UnicastRemoteObject implements MessageDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	MessageController MessageDataController = new MessageController();
	
	

	public MessageDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void addMessage(MessagePO c) throws RemoteException {
		// TODO 自动生成的方法存根
		MessageDataController.addMessage(c);
	}



	@Override
	public void deleteMessage(int id) throws RemoteException {
		// TODO 自动生成的方法存根
		MessageDataController.deleteMessage(id);
	}



	@Override
	public void editMessage(MessagePO c) throws RemoteException {
		// TODO 自动生成的方法存根
		MessageDataController.editMessage(c);
	}



	@Override
	public ArrayList<MessagePO> searchMessage(KeyForSearchMessage key) throws RemoteException {
		// TODO 自动生成的方法存根
		return MessageDataController.searchMessage(key);
	}


}
