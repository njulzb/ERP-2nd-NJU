package presentation.operatorUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class NewUserUI extends Application {
	//static NewUserUI present = new NewUserUI();
	private static Stage newStage;

	//新建新增用户窗口
	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewUserUI.fxml"));
		AnchorPane pane = fxmlLoader.load();
		Scene scene = new Scene(pane, 502, 486);
		stage.setScene(scene);
		newStage = stage;
		NewUserUIController newUIcontroller = fxmlLoader.getController();
		newUIcontroller.init();
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.showAndWait();
	}

	public static Stage getStage(){
		return newStage;
	}

}
