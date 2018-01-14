package presentation.userUI.StoreManager;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class StoreLeftSelectUI {
	private FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StoreLeftSelect.fxml"));
	//返回左侧选择栏
	public AnchorPane leftSelectUI() throws IOException {
		// TODO Auto-generated method stub
		AnchorPane root = fxmlLoader.load();
		StoreLeftSelectUIController LScontroller = fxmlLoader.getController();
		LScontroller.init();

		return root;
	}

	public StoreLeftSelectUIController getUIController() {
		return fxmlLoader.getController();
	}

}
