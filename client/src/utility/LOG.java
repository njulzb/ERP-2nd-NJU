package utility;

import java.rmi.RemoteException;
import java.sql.Timestamp;

import BL.logBL.LogController;
import BLService.logBLService.LogService;
import vo.LogItemVO;

public class LOG {
	private static LogService controller=new LogController();
	public static void addLog(String things,String operatorID) {
		Timestamp time=new Timestamp(System.currentTimeMillis());
		LogItemVO c =new LogItemVO();
		c.setMessage(things);
		c.setUserID(operatorID);
		c.setTime(time);
		try {
			controller.addLog(c );
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
