package presentation.userUI.FinancialManager;

import java.io.IOException;

import BL.accountBL.AccountManage;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.accountUI.AccountManageUI;
import presentation.logUI.LogMainUI;
import presentation.mainAccountUI.MainAccountUI;
import presentation.mainUI.UIController;
import presentation.mainUI.mergePane;
import presentation.reportUI.reportManageUI;
import presentation.userUI.homeUI;
import presentation.userUI.SaleManager.SaleLeftSelectUI;
import vo.UserVO;

public class FinancialUIController {
	static FinancialUIController present = new FinancialUIController();
	UserVO user;
	double xOffset,yOffset;

	public void setUser(UserVO user2) {
		// TODO Auto-generated method stub
		this.user = user2;
	}

	public static FinancialUIController getFinancialUIController() {
		return present;
	}
//运行不同界面
	public void runNewStage(String button, String select) throws IOException {
		FinancialLeftSelectUI leftSelect = new FinancialLeftSelectUI();
		AnchorPane leftS = null;
		Pane root = new Pane();
		if (button.equals("homeButton")) {
			leftS = leftSelect.leftSelectUI();
			leftSelect.getUIController().setHomeBackground();

			homeUI home = new homeUI();
			home.setUser(user);

			mergePane merge = new mergePane();
			root = merge.mergerPane(leftS, home.homePane());
		}
		if (button.equals("receiptButton")) {
			leftS = leftSelect.leftSelectUI();
			leftSelect.getUIController().setReceiptBackground();

			mergePane merge = new mergePane();
			FinancialReceiptController receipt = new FinancialReceiptController();
			if (select == null)
				select = "newCashForm";
			receipt.setUser(user);
			root = merge.mergerPane(leftS, receipt.runNewPane(select));
		}
		if (button.equals("reportButton")) {
			leftS = leftSelect.leftSelectUI();
			leftSelect.getUIController().setReportBackground();

			reportManageUI ui =new reportManageUI();

			mergePane merge = new mergePane();
			root = merge.mergerPane(leftS, ui.getReportManageUIPane(new Stage()));
		}
		if (button.equals("bankButton")) {
			leftS = leftSelect.leftSelectUI();
			leftSelect.getUIController().setBankBackground();

			AccountManageUI accountUI = new AccountManageUI();
			mergePane merge = new mergePane();
			root = merge.mergerPane(leftS, accountUI.root);
		}
		if (button.equals("createButton")) {
			leftS = leftSelect.leftSelectUI();
			leftSelect.getUIController().setAccountBackground();

			MainAccountUI ui = new MainAccountUI();

			mergePane merge = new mergePane();
			root = merge.mergerPane(leftS, ui.root);
		}
		if (button.equals("systemlogButton")) {
			leftS = leftSelect.leftSelectUI();
			leftSelect.getUIController().setSystemlogBackground();

			LogMainUI logUI = new LogMainUI();

			mergePane merge = new mergePane();
			root = merge.mergerPane(leftS, logUI.root);
		}
		Scene scene = new Scene(root, 800, 600);

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


		UIController.getUIStage().setScene(scene);
	}
}
