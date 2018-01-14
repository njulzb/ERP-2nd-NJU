package RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

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

/**
 * RMI 閻ㄥ嫬顓归幋椋庮伂閿涘矂锟芥俺绻僀lientRunner.getInstance().get***DataService()閺傝纭堕懢宄板絿閺堝秴濮�
 * @author LZB
 *
 */
public class ClientRunner {

	private static ClientRunner runner = new ClientRunner();

	public static ClientRunner getInstance() {
		return runner;
	}

	private ClientRunner() {
		this.registerService();

	}

//	---------------------------连接的服务列表
	UserDataService userDataService;
	CustomerDataService customerDataService;
	StrategyDataService strategyDataService;
	GoodsClassDataService goodsClassDataService;
	GoodsDataService goodsDataService;
	AccountDataService accountDataService ;
	FormDataService formDataService;
	LogDataService logDataService;
	MessageDataService messageDataService;
	MainAccountDataService mainAccountDataService;
//	----------------------------


	private void registerService() {

		String ip = "127.0.0.1";

		int port = 8888;
		String url = "rmi://IPAddress:Port/ServiceName";
		url = url.replaceAll("IPAddress", ip);
		url = url.replaceAll("Port", Integer.toString(port));
		try {

			this.userDataService = (UserDataService)Naming.lookup(url.replaceAll("ServiceName", "UserDataService"));
			this.customerDataService = (CustomerDataService)Naming.lookup(url.replaceAll("ServiceName", "CustomerDataService"));
			this.strategyDataService = (StrategyDataService)Naming.lookup(url.replaceAll("ServiceName", "StrategyDataService"));

			this.goodsClassDataService = (GoodsClassDataService)Naming.lookup(url.replaceAll("ServiceName", "GoodsClassDataService"));
			this.goodsDataService = (GoodsDataService)Naming.lookup(url.replaceAll("ServiceName", "GoodsDataService"));
			this.accountDataService = (AccountDataService)Naming.lookup(url.replaceAll("ServiceName", "AccountDataService"));
			this.formDataService = (FormDataService) Naming.lookup(url.replaceAll("ServiceName", "FormDataService"));
			this.messageDataService = (MessageDataService) Naming.lookup(url.replaceAll("ServiceName", "MessageDataService"));
			this.logDataService = (LogDataService) Naming.lookup(url.replaceAll("ServiceName", "LogDataService"));
			this.mainAccountDataService = (MainAccountDataService) Naming.lookup(url.replaceAll("ServiceName", "MainAccountDataService"));


			System.out.println("connect to server successfully !!!");



		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}



	public UserDataService getUserDataService() {return this.userDataService;}
	public CustomerDataService getCustomerDataService(){return this.customerDataService;}
	public StrategyDataService getStrategyDataService() {return this.strategyDataService;}

	public GoodsClassDataService getGoodsClassDataService() {return this.goodsClassDataService;}
	public GoodsDataService getGoodsDataService() {return this.goodsDataService;}
	public AccountDataService getAccountDataService() {return this.accountDataService;}
	public FormDataService getFormDataService() {return this.formDataService;}
	public MessageDataService getMessageDataService() {return this.messageDataService;}

	public LogDataService getLogDataService() {return this.logDataService;}
	public MainAccountDataService getMainAccountDataService() {return this.mainAccountDataService;}

}

