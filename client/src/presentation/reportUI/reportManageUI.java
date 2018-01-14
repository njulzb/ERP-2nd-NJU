package presentation.reportUI;


import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import presentation.littleUI.TipUI;
import utility.StateOfForm;
import vo.UserVO;
import vo.Form.FormVO;
import vo.Form.FinanceFormVO.CashFormVO;

public class reportManageUI extends Application{
	protected ArrayList<FormVO> formList=new ArrayList<FormVO>();
	protected ArrayList<Label> labelItemList=new ArrayList<Label>();
	private Label titleLabel = new Label(),saleLabel = new Label(),progressLabel = new Label(),stateLabel = new Label();
	private Button addButton = new Button(), selectButton = new Button();
	private Pane report = new Pane(), root = new Pane(), sale = new Pane(), progress = new Pane(), state = new Pane();;
	private Font font1 = new Font("楷体",15);
	private Font font2 = new Font("楷体",20);
	private Font font3 = new Font("楷体",16);
	private Color backgroundColor = Color.DIMGREY;
	private Color textColor = Color.CORNSILK;
	public UserVO presentOperator;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		root = getReportManageUIPane(primaryStage);
	}

	public Pane getReportManageUIPane(Stage primaryStage){
		Scene scene = new Scene(root,700,600);
		try {
            // Read file fxml and draw interface.
           sale = FXMLLoader.load(getClass()
                    .getResource("saleReport.fxml"));


           state = FXMLLoader.load(getClass()
                   .getResource("stateReport.fxml"));
           
           //progress = FXMLLoader.load(getClass()
                    //.getResource("progressReport.fxml"));
                      

        } catch(Exception e1) {
            e1.printStackTrace();
        }

		sale.setLayoutX(32);
        sale.setLayoutY(10);
        sale.setVisible(false);
       // sale.setBackground(new Background(new BackgroundFill(Color.AZURE,null,null)));
        root.getChildren().add(sale);
        
        progressReportUI prui = new progressReportUI();
        progress = prui.progressReportUI(new Stage());
        progress.setLayoutX(30);
        progress.setLayoutY(10);
        progress.setVisible(false);
        root.getChildren().add(progress);

        state.setLayoutX(30);
        state.setLayoutY(10);
        state.setVisible(true);
       // state.setBackground(new Background(new BackgroundFill(Color.AZURE,null,null)));
        root.getChildren().add(state);

		saleLabel.setText("销\n售\n明\n细\n表");
		saleLabel.setLayoutX(4);
		saleLabel.setLayoutY(40);
		saleLabel.setFont(font2);
		saleLabel.setPrefWidth(30);
		saleLabel.setBackground(new Background(new BackgroundFill(backgroundColor, null, null)));
		saleLabel.setTextFill(textColor);
		saleLabel.setOnMouseEntered(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent e) {
				saleLabel.setScaleX(0.97);
				saleLabel.setScaleY(0.97);
			}
		});
		saleLabel.setOnMouseExited(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent e) {
				saleLabel.setScaleX(1);
				saleLabel.setScaleY(1);
			}
		});
		saleLabel.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				report.setVisible(false);
				sale.setVisible(true);
				state.setVisible(false);
				progress.setVisible(false);
			}
		});
		root.getChildren().add(saleLabel);

		progressLabel.setText("经\n营\n历\n程\n表");
		progressLabel.setLayoutX(4);
		progressLabel.setLayoutY(180);
		progressLabel.setFont(font2);
		progressLabel.setPrefWidth(30);
		progressLabel.setBackground(new Background(new BackgroundFill(backgroundColor, null, null)));
		progressLabel.setTextFill(textColor);
		progressLabel.setOnMouseEntered(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent e) {
				progressLabel.setScaleX(0.97);
				progressLabel.setScaleY(0.97);
			}
		});
		progressLabel.setOnMouseExited(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent e) {
				progressLabel.setScaleX(1);
				progressLabel.setScaleY(1);
			}
		});
		progressLabel.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				report.setVisible(false);
				sale.setVisible(false);
				state.setVisible(false);
				progress.setVisible(true);
			}
		});
		root.getChildren().add(progressLabel);

		stateLabel.setText("经\n营\n情\n况\n表");
		stateLabel.setLayoutX(4);
		stateLabel.setLayoutY(320);
		stateLabel.setPrefWidth(30);
		stateLabel.setFont(font2);
		stateLabel.setBackground(new Background(new BackgroundFill(backgroundColor, null, null)));
		stateLabel.setTextFill(textColor);
		stateLabel.setOnMouseEntered(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent e) {
				stateLabel.setScaleX(0.97);
				stateLabel.setScaleY(0.97);
			}
		});
		stateLabel.setOnMouseExited(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent e) {
				stateLabel.setScaleX(1);
				stateLabel.setScaleY(1);
			}
		});
		stateLabel.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				report.setVisible(false);
				sale.setVisible(false);
				state.setVisible(true);
				progress.setVisible(false);
			}
		});
		root.getChildren().add(stateLabel);




		primaryStage.setTitle("ERPsystem");
		primaryStage.setScene(scene);
		//primaryStage.show();

		return root;

	}

	
}
