package presentation.strategyUI;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import vo.strategy.CustomerStrategyVO;

public class CustomerStrategyInfoUI {
	CustomerStrategyInfoController controller;
	AnchorPane root;
	
	public void InfoPane(CustomerStrategyVO strategy) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CustomerStrategyInfoUI.fxml"));
		root =fxmlLoader.load();
		controller=fxmlLoader.getController();
		controller.setStrategy(strategy);
		controller.init();
		
		Scene scene = new Scene(root,500,400);
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//return root;
	}


}
