package presentation.userUI.FinancialManager;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class FinancialLeftSelectUI {
	private FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FinancialLeftSelect.fxml"));
//返回左侧选择栏
	public AnchorPane leftSelectUI() throws IOException {
		// TODO Auto-generated method stub
		AnchorPane root = fxmlLoader.load();
		FinancialLeftSelectUIController LScontroller = fxmlLoader.getController();
		LScontroller.init();

		return root;
	}

	public FinancialLeftSelectUIController getUIController() {
		return fxmlLoader.getController();
	}

}
