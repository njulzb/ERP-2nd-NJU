package presentation.operatorUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import presentation.customerUI.EditCustomerUIController;
import vo.CustomerVO;
import vo.UserVO;

public class EditUserUI extends Application {
	public static Stage thisStage =new Stage();
	private UserVO user = new UserVO();

	//新建編輯用戶窗口
	@Override
	public void start(Stage stage) throws Exception {
		thisStage =stage;
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditUserUI.fxml"));
		AnchorPane pane = fxmlLoader.load();
		Scene scene = new Scene(pane, 502, 486);
		stage.setScene(scene);
		EditUserUIController editUIcontroller = fxmlLoader.getController();
		editUIcontroller.init(user);

		stage.initStyle(StageStyle.TRANSPARENT);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.showAndWait();
	}

	public void setUser(UserVO user) {
		// TODO Auto-generated method stub
		this.user=user;
	}

	public static Stage getStage() {
		// TODO Auto-generated method stub
		return thisStage;
	}

}
