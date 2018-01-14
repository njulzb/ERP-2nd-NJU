package presentation.userUI.SaleManager;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class SaleLeftSelectUI {
	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SaleLeftSelectUI.fxml"));
	//返回左侧选择栏
	public AnchorPane leftSelectUI() throws IOException{

        AnchorPane root = fxmlLoader.load();
        SaleLeftSelectUIController saleLSUIcontroller = fxmlLoader.getController();
        saleLSUIcontroller.init();
        return root;
    }
	public SaleLeftSelectUIController getUIController(){
		return fxmlLoader.getController();
	}
}
