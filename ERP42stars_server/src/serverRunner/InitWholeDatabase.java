package serverRunner;

import java.rmi.RemoteException;

import Data.stockData.InitStock;
import Data.userData.UserInitHelper;

/**
 * 这个类用于初始化整个数据库表
 * @author lzb
 *
 */
public class InitWholeDatabase {

	public static void main(String[] args) throws RemoteException {
		new InitStock().initStock();//初始化goodsclasslist,goodslist;
		UserInitHelper.init();
	}
}
