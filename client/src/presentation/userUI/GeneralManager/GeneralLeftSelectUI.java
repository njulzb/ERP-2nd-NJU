package presentation.userUI.GeneralManager;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class GeneralLeftSelectUI {
	private FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GeneralLeftSelect.fxml"));
	//返回左侧选择栏
	public AnchorPane leftSelectUI() throws IOException {
		// TODO Auto-generated method stub
		AnchorPane root = fxmlLoader.load();
		GeneralLeftSelectUIController LScontroller = fxmlLoader.getController();
		LScontroller.init();

		return root;
	}

	public GeneralLeftSelectUIController getUIController() {
		return fxmlLoader.getController();
	}

}
