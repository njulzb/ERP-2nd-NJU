package BL.accountBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import DataService.accountDataService.AccountDataService;
import RMI.ClientRunner;
import po.AccountPO;
import po.KeyForSearchAccount;
import vo.AccountVO;

public class AccountManage  {
	private AccountDataService rmi= ClientRunner.getInstance().getAccountDataService();

	public static void main(String args[]) throws RemoteException {
		 AccountManage   man=new  AccountManage  ();
	    String str="我是中国人";
	       byte[] arr=str.getBytes();
	       System.out.println("打印："+arr);

		AccountPO p=new AccountPO();
		p.setID("test2");
		p.setImg(arr);

		String c=man.getAccount("test2").getID();
		   System.out.println("打印："+c);
	}



	public AccountVO getAccount(String id) throws RemoteException {
		return new Account(rmi.getAccount(id)).toVO() ;
	}


	public ArrayList<AccountVO> searchAccount(KeyForSearchAccount key)throws RemoteException {

		ArrayList<AccountVO> out = new ArrayList<AccountVO>();
		ArrayList<AccountPO> temp = new ArrayList<AccountPO>();
		temp = rmi.searchAccount(key);
		for(AccountPO a:temp) {
			out.add(  new Account(a).toVO()    );
		}
		return out;
	}


	public boolean editAccount(AccountVO topush) throws RemoteException{
		AccountPO 	temp  = new Account(topush).toPO();
		return rmi.editAccount(temp);
	}


	public boolean newAccount(AccountVO topush)throws RemoteException {
		// TODO 自动生成的方法存根
		AccountPO 	temp  = new Account(topush).toPO();
		return rmi.addAccount(temp);
	}


	public boolean deleteAccount(String id)throws RemoteException {
		return rmi.deleteAccount(id);
	}


	public ArrayList<AccountVO> getAccountList() throws RemoteException  {
		KeyForSearchAccount key =new KeyForSearchAccount();

		return searchAccount(key);
	}


	public boolean changeMoney(String id, double money) throws RemoteException {
		// TODO 自动生成的方法存根
		AccountVO temp =getAccount(id);
		temp.setMoney(money);
		return editAccount(temp);
	}


}
