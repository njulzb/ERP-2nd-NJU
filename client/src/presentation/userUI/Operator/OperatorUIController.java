package presentation.userUI.Operator;

import java.io.IOException;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import presentation.mainUI.UIController;
import presentation.mainUI.mergePane;
import presentation.operatorUI.UserUIController;
import presentation.userUI.homeUI;
import vo.UserVO;

public class OperatorUIController {
	static OperatorUIController present = new OperatorUIController();
	UserVO user;
	double xOffset,yOffset;

	public static OperatorUIController getOperatorUIController(){
		return present;
	}
	//运行不同界面
	public void runNewStage(String button) throws IOException{

		OperatorLeftSelectUI leftSelect = new OperatorLeftSelectUI();
		AnchorPane leftS = null;
		Pane root = null;
		if (button.equals("homeButton")){
			leftS = leftSelect.leftSelectUI();
			leftSelect.getUIController().setHomeBackground();

			homeUI home =new homeUI();
			home.setUser(null);

			mergePane merge = new mergePane();
			root = merge.mergerPane(leftS,home.homePane());
		}

		if (button.equals("userButton")){
			leftS = leftSelect.leftSelectUI();
			leftSelect.getUIController().setUserBackground();

			UserUIController userController = new UserUIController();
			mergePane merge = new mergePane();
			root = merge.mergerPane(leftS,userController.getUserMainUI());
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
		//@SuppressWarnings("restriction")
		//UIController contro =UIController.getUIController();
		UIController.getUIStage().setScene(scene);
		//contro.getUIStage().setScene(scene);

	}

	public void setUser(UserVO user2) {
		// TODO Auto-generated method stub
		this.user=user2;
	}
}
