package presentation.userUI.SaleManager;

import java.io.IOException;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import po.KeyForSearchCustomer;
import presentation.customerUI.CustomerUIController;
import presentation.mainUI.UIController;
import presentation.mainUI.mergePane;
import presentation.userUI.homeUI;
import vo.UserVO;

public class SaleUIController {
	static SaleUIController present = new SaleUIController();
	private UserVO user;
	double xOffset,yOffset;
	private String select;
	String mode = "new";
	private KeyForSearchCustomer customerKey;

	public static SaleUIController getSaleUIController(){
		return present;
	}
	//运行不同界面
	public void runNewStage(String button) throws IOException{

		SaleLeftSelectUI leftSelect = new SaleLeftSelectUI();
		AnchorPane leftS = new AnchorPane();
		Pane root = new Pane();
		if (button.equals("homeButton")){
			leftS = leftSelect.leftSelectUI();
			leftSelect.getUIController().setHomeBackground();

			homeUI home =new homeUI();
			home.setUser(user);

			mergePane merge = new mergePane();
			root = merge.mergerPane(leftS,home.homePane());
		}

		if (button.equals("customerButton")){
			leftS = leftSelect.leftSelectUI();
			leftSelect.getUIController().setCustomerBackground();

			CustomerUIController customerController = new CustomerUIController();
			mergePane merge = new mergePane();
			root = merge.mergerPane(leftS,customerController.getCustomerMainUI(customerKey,mode));
		}

		if (button.equals("receiptButton")){
			leftS = leftSelect.leftSelectUI();
			leftSelect.getUIController().setReceiptBackground();

			//PurchaseFormManageUI purchaseFormManageUI= new PurchaseFormManageUI();
			mergePane merge = new mergePane();
			if (select==null) select="purchaseForm";
			SaleReceiptController ui = new SaleReceiptController();
			ui.setUser(this.user);
			root = merge.mergerPane(leftS,ui.runNewPane(select));
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

	public void setUser(UserVO user2) {
		// TODO Auto-generated method stub
		this.user=user2;
	}

	public void setSelect(String select) {
		// TODO Auto-generated method stub
		this.select=select;
	}

	public void setKey(KeyForSearchCustomer select) {
		// TODO Auto-generated method stub
		this.customerKey=select;
	}

	public void setMode(String select) {
		// TODO Auto-generated method stub
		this.mode=select;
	}
}
