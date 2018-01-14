package Data.messageData;

import java.rmi.RemoteException;
import java.util.ArrayList;

import DataService.messageDataService.MessageDataService;
import po.KeyForSearchMessage;
import po.MessagePO;

public class MessageController implements MessageDataService {

	@Override
	public void addMessage(MessagePO c) throws RemoteException {
		// TODO 自动生成的方法存根
		MessageSqlHelper.insert(c);
	}

	@Override
	public void deleteMessage(int id) throws RemoteException {
		// TODO 自动生成的方法存根
		MessageSqlHelper.delete(id);;
	}

	@Override
	public void editMessage(MessagePO c) throws RemoteException {
		// TODO 自动生成的方法存根
		MessageSqlHelper.update(c);;
	}

	@Override
	public ArrayList<MessagePO> searchMessage(KeyForSearchMessage key) throws RemoteException {
		// TODO 自动生成的方法存根
		return 		MessageSqlHelper.search(key);
	}

}
