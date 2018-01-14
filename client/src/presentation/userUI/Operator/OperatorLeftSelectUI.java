package presentation.userUI.Operator;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class OperatorLeftSelectUI {
	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OperatorLeftSelectUI.fxml"));
	//返回左侧选择栏
	public AnchorPane leftSelectUI() throws IOException{

        AnchorPane root = fxmlLoader.load();
        OperatorLeftSelectUIController saleLSUIcontroller = fxmlLoader.getController();
        saleLSUIcontroller.init();
        return root;
    }
	public OperatorLeftSelectUIController getUIController(){
		return fxmlLoader.getController();
	}
}
