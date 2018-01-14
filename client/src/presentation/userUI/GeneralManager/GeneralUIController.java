package presentation.userUI.GeneralManager;

import java.io.IOException;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.logUI.LogMainUI;
import presentation.mainUI.UIController;
import presentation.mainUI.mergePane;
import presentation.receiptUI.FormMainUI;
import presentation.reportUI.reportManageUI;
import presentation.strategyUI.strategyManageUI;
import presentation.userUI.homeUI;
import vo.UserVO;

public class GeneralUIController {
	static GeneralUIController present = new GeneralUIController();
	UserVO user;
	double xOffset,yOffset;

	public void setUser(UserVO user2) {
		// TODO Auto-generated method stub
		this.user=user2;
	}

	public static GeneralUIController getGeneralUIController(){
		return present;
	}
	//运行不同界面
	public void runNewStage(String button) throws IOException{
		GeneralLeftSelectUI leftSelect = new GeneralLeftSelectUI();
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
			FormMainUI ui = new FormMainUI();
			ui.user=this.user;
			ui.formID="";
			ui.makeUI();

			root = merge.mergerPane(leftS,ui.root);
		}
		if (button.equals("reportButton")){
			leftS = leftSelect.leftSelectUI();
			leftSelect.getUIController().setReportBackground();

			reportManageUI ui =new reportManageUI();


			mergePane merge = new mergePane();
			root = merge.mergerPane(leftS,ui.getReportManageUIPane(new Stage()));
		}
		if (button.equals("strategyButton")){
			leftS = leftSelect.leftSelectUI();
			leftSelect.getUIController().setStrategyBackground();

			strategyManageUI ui = new strategyManageUI();

			mergePane merge = new mergePane();
			root = merge.mergerPane(leftS,ui.getStrategyManageUIPane(new Stage()));
		}
		if (button.equals("systemlogButton")){
			leftS = leftSelect.leftSelectUI();
			leftSelect.getUIController().setSystemlogBackground();

			LogMainUI logUI = new LogMainUI();

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
