package BL.logBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import BLService.logBLService.LogService;
import po.KeyForSearchLog;
import vo.LogItemVO;

public class LogController implements LogService{
	private LogManage m=new LogManage();
	
	public static void main(String args[]) {
		 LogController c =new  LogController();
		
	
	}
	
	
	@Override
	public ArrayList<LogItemVO>  searchLog(KeyForSearchLog key) throws RemoteException {
	
		return 	m.searchLog(key);
	
	}

	@Override
	public void addLog(LogItemVO vo) throws RemoteException {
		// TODO 自动生成的方法存根
		m.addLog(vo);
	}

}
