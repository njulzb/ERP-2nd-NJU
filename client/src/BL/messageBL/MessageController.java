package BL.messageBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import BLService.messageBLService.MessageBLService;
import po.KeyForSearchMessage;
import vo.MessageVO;

public class MessageController implements MessageBLService{
private MessageManage manage=new MessageManage();

	@Override
	public void addMessage(MessageVO c) throws RemoteException {
		manage.addMessage(c);
		
	}

	@Override
	public void deleteMessage(int id) throws RemoteException {
		manage.deleteMessage(id);
		
	}

	@Override
	public void editMessage(MessageVO c) throws RemoteException {
		manage.editMessage(c);
		
		
	}

	@Override
	public ArrayList<MessageVO> searchMessage(KeyForSearchMessage key) throws RemoteException {

		return manage.searchMessage(key)
				;
	}

}
