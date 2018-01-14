package presentation.userUI.StoreManager;

import java.io.IOException;

import javax.swing.Spring;

import BL.accountBL.AccountManage;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import presentation.accountUI.AccountManageUI;
import presentation.logUI.LogMainUI;
import presentation.mainUI.UIController;
import presentation.mainUI.mergePane;
import presentation.stockUI.GoodsManage.StockManageUI2;
import presentation.stockUI.StockProcess.StockProcessUI;
import presentation.stockUI.stockSnap.StockSnapMainUI;
//import presentation.stockUI.stockSnap.StockSnapUI;
import presentation.userUI.homeUI;
import presentation.userUI.SaleManager.SaleLeftSelectUI;
import vo.UserVO;

public class StoreUIController {
	static StoreUIController present = new StoreUIController();
	UserVO user;
	double xOffset,yOffset;

	public void setUser(UserVO user2) {
		// TODO Auto-generated method stub
		this.user=user2;
	}

	public static StoreUIController getStoreUIController(){
		return present;
	}
	//运行不同界面
	public void runNewStage(String button,String select) throws IOException{
		StoreLeftSelectUI leftSelect = new StoreLeftSelectUI();
		AnchorPane leftS = null;
		Pane root = null;
		if (button.equals("homeButton")){
			leftS = leftSelect.leftSelectUI();
			leftSelect.getUIController().setHomeBackground();

			homeUI home =new homeUI();
			home.setUser(user);

			mergePane merge = new mergePane();
			root = merge.mergerPane(leftS,home.homePane());
		}
		if (button.equals("receiptButton")){
			leftS = leftSelect.leftSelectUI();
			leftSelect.getUIController().setReceiptBackground();

			mergePane merge = new mergePane();
			if (select==null) select = "alarmForm";
			StoreReceiptController ui = new StoreReceiptController();
			ui.setUser(user);
			root = merge.mergerPane(leftS,ui.runNewPane(select));
		}
		if (button.equals("goodButton")){
			leftS = leftSelect.leftSelectUI();
			leftSelect.getUIController().setGoodBackground();

			StockManageUI2 ui= new StockManageUI2();

			mergePane merge = new mergePane();
			root = merge.mergerPane(leftS,ui.root);
		}
		if (button.equals("stockButton")){
			leftS = leftSelect.leftSelectUI();
			leftSelect.getUIController().setStockBackground();

			StockSnapMainUI ui = new StockSnapMainUI();

			mergePane merge = new mergePane();
			root = merge.mergerPane(leftS,ui.root);
		}
		if (button.equals("stockprocessButton")){
			leftS = leftSelect.leftSelectUI();
			leftSelect.getUIController().setStockprocessBackground();

			StockProcessUI logUI = new StockProcessUI();

			mergePane merge = new mergePane();
			root = merge.mergerPane(leftS,logUI.root);
		}

		//设置成可以拖动
		root.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				e.consume();
				xOffset = e.getSceneX();
				yOffset = e.getSceneY();
			}
		});
		root.setOnMouseDragged(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				e.consume();
				UIController.getUIStage().setX(e.getScreenX() - xOffset);

				// 根据自己的需求，做不同的判断
				if (e.getScreenY() - yOffset < 0) {
					UIController.getUIStage().setY(0);
				} else {
					UIController.getUIStage().setY(e.getScreenY() - yOffset);
				}
			}
		});

		Scene scene = new Scene(root,800,600);
		UIController.getUIStage().setScene(scene);
	}
}
