package presentation.reportUI;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import po.KeyForSearchCustomer;
import presentation.customerUI.CustomerMainUIController;
import vo.CustomerVO;
import vo.report.KeyForSearchReport;
import vo.report.SaleReportItemVO;

public class saleReportUI {
	private Pane root = new Pane();
	private AnchorPane pane;
	private KeyForSearchReport key;
	private ArrayList<Label> labelList;
	private ArrayList<SaleReportItemVO> voList;

	public AnchorPane SaleReportPane() throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("saleReport.fxml"));
		pane =fxmlLoader.load();
		saleReportController controller = fxmlLoader.getController();
		
		VBox list = new VBox();
		return pane;
		
	}
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		saleReportUI(primaryStage);
		
	}
	
	protected void saleReportUI(Stage primaryStage){
		double sx = 0,sy=0;
		Scene scene = new Scene(root,680,600);
		
		Label titleLabel = new Label("销售明细表");
		titleLabel.setLayoutX(30);
		titleLabel.setLayoutY(10);
		titleLabel.setFont(font2);
		root.getChildren().add(titleLabel);
		
		Line line = new Line();
		line.setStartX(28);
		line.setStartY(45);
		line.setEndX(680);
		line.setEndY(45);
		line.setStrokeWidth(1.5);
		line.setStroke(Color.GRAY);
		root.getChildren().add(line);
		
		
	}*/
}
