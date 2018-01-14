package presentation.mainUI;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


public class mergePane {

	//返回左边选择列和相应的界面合成的一个pane
	public Pane mergerPane(AnchorPane left, Pane root) throws IOException {
		Pane pane = new Pane();

		pane.getChildren().add(left);
		root.setLayoutX(83);
		pane.getChildren().add(root);

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ControBar.fxml"));
		AnchorPane bar = fxmlLoader.load();
		ControBarController barcontroller = fxmlLoader.getController();
		barcontroller.init();
		bar.setLayoutX(684);
		pane.getChildren().add(bar);

		return pane;
	}
}
