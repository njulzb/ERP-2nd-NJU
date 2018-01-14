package BL.logBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import DataService.logDataService.LogDataService;
import RMI.ClientRunner;
import po.KeyForSearchLog;
import po.LogItemPO;
import vo.LogItemVO;

public class LogManage {
	LogDataService rmi= ClientRunner.getInstance().getLogDataService();
	
	public  ArrayList<LogItemVO>  searchLog(KeyForSearchLog key) throws RemoteException {
		ArrayList<LogItemVO> out =new ArrayList<LogItemVO>();
		for(LogItemPO c: rmi.searchLog(key)) {
			LogItemVO a=new LogItemVO();
			a.setUserID(c.getUserID());
			a.setMessage(c.getMessage());
			
			a.setTime(c.getTime());
			out.add(a);
		}
		
		return out ;
		
	}
	public void addLog(LogItemVO vo) throws RemoteException {
		LogItemPO p=new LogItemPO();
		p.setMessage(vo.getMessage());
		p.setTime(vo.getTime());
		p.setUserID(vo.getUserID());
		rmi.addLog(p);
	}
}
