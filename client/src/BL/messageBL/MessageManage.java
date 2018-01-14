package BL.messageBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import DataService.messageDataService.MessageDataService;
import RMI.ClientRunner;
import po.KeyForSearchMessage;
import po.MessagePO;
import vo.MessageVO;

public class MessageManage  {

	MessageDataService rmi =ClientRunner.getInstance().getMessageDataService();
	
	public void addMessage(MessageVO c) throws RemoteException {
		MessagePO po=new MessagePO();
		po.setSenderID(c.getSenderName_ID());
		po.setReceiverID(c.getReceiverName_ID());
		po.setRead(c.isRead());
		po.setMessage(c.getMessage());
		
		rmi.addMessage(po);
		
	}

	public void deleteMessage(int id) throws RemoteException {
	
		rmi.deleteMessage(id);;
		
	}
	
	public void editMessage(MessageVO c) throws RemoteException {
		MessagePO po=new MessagePO();
		po.setSenderID(c.getSenderName_ID());
		po.setReceiverID(c.getReceiverName_ID());
		po.setRead(c.isRead());
		po.setMessage(c.getMessage());
		
		rmi.editMessage(po);;
		
	}

	public ArrayList<MessageVO> searchMessage(KeyForSearchMessage key) throws RemoteException {
		 ArrayList<MessageVO>  out =new  ArrayList<MessageVO> ();
		 
			
		
		for(MessagePO c : rmi.searchMessage(key)) {
			 MessageVO vo=new MessageVO(); 
			vo.setCreate(c.getCreate());
			vo.setRead(c.isRead());
			vo.setReadTime(c.getReadTime());
			vo.setReceiverName_ID(c.getReceiverID());
			vo.setSenderName_ID(c.getSenderID());
			vo.setMessage(c.getMessage());
			out.add(vo);
			
		}
	
		return out;
	}

}
