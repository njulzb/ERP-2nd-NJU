package presentation.customerUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class NewCustomerUI extends Application {
	static NewCustomerUI present = new NewCustomerUI();
	private static Stage newStage;

	//新建窗口显示新建客户信息
	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewCustomerUI.fxml"));
		AnchorPane pane = fxmlLoader.load();
		Scene scene = new Scene(pane, 502, 486);
		newStage =stage;
		stage.setScene(scene);
		NewCustomerUIController newUIcontroller = fxmlLoader.getController();
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
