package serverRunner;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import DataService.accountDataService.AccountDataService;
import DataService.customerDataService.CustomerDataService;
import DataService.logDataService.LogDataService;
import DataService.mainAccountDataService.MainAccountDataService;
import DataService.messageDataService.MessageDataService;
import DataService.receiptDataService.FormDataService;
import DataService.stockDataService.GoodsClassDataService;
import DataService.stockDataService.GoodsDataService;
import DataService.strategyDataService.StrategyDataService;
import DataService.userDataService.UserDataService;
import RMI.AccountDataServiceImpl;
import RMI.CustomerDataServiceImpl;
import RMI.FormDataServiceImpl;
import RMI.GoodsClassDataServiceImpl;
import RMI.GoodsDataServiceImpl;
import RMI.LogDataServiceImpl;
import RMI.MainAccountDataServiceImpl;
import RMI.MessageDataServiceImpl;
import RMI.StrategyDataServiceImpl;
import RMI.UserDataServiceImpl;

public class ServerRunner {
	
	
	public ServerRunner(){
		registerServices();
	}
	


	/**
	 * 将所会用到的服务注册在表上
	 */
	public void registerServices(){
		String ip = "127.0.0.1";
		int port = 8888;
		
		String url = "rmi://IPAddress:Port/ServiceName";
		url = url.replaceAll("IPAddress", ip);
		url = url.replaceAll("Port", Integer.toString(port));
		

		try {
			
			LocateRegistry.createRegistry(port);
//			FormDataServiceImpl dataRemoteObject;
//			dataRemoteObject = new FormDataServiceImpl();
//			Naming.bind("rmi://127.0.0.1:8888/DataRemoteObject",
//					dataRemoteObject);
			
//			------------------------------------以下是绑定的服务
	
			UserDataService userDataService = new UserDataServiceImpl();
			Naming.bind(url.replaceAll("ServiceName", "UserDataService"), userDataService);
			
			
			GoodsClassDataService goodsclassDataService = new GoodsClassDataServiceImpl();
			Naming.bind(url.replaceAll("ServiceName","GoodsClassDataService"),goodsclassDataService);

			
			GoodsDataService goodsDataService = new GoodsDataServiceImpl();
			Naming.bind(url.replaceAll("ServiceName", "GoodsDataService"), goodsDataService);
			
			StrategyDataService strategyDataService = new StrategyDataServiceImpl();
			Naming.bind(url.replaceAll("ServiceName", "StrategyDataService"), strategyDataService);
			
			AccountDataService accountDataService = new AccountDataServiceImpl();
			Naming.bind(url.replaceAll("ServiceName", "AccountDataService"), accountDataService);
			
			CustomerDataService  customerDataService = new CustomerDataServiceImpl();
			Naming.bind(url.replaceAll("ServiceName", "CustomerDataService"), customerDataService);
			
			FormDataService formDataService = new FormDataServiceImpl();
			Naming.bind(url.replaceAll("ServiceName", "FormDataService"), formDataService);
			
			LogDataService logDataService = new LogDataServiceImpl();
			Naming.bind(url.replaceAll("ServiceName", "LogDataService"), logDataService);
			
			MessageDataService messageDataService = new MessageDataServiceImpl();
			Naming.bind(url.replaceAll("ServiceName", "MessageDataService"), messageDataService);
			
			MainAccountDataService mainAccountDataService = new MainAccountDataServiceImpl();
			Naming.bind(url.replaceAll("ServiceName", "MainAccountDataService"), mainAccountDataService);
			
			
//			-------------------------------------
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("server launcher successfully!!!");
		
	}
}
