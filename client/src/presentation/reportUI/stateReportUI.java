package presentation.reportUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class stateReportUI extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		try {
            // Read file fxml and draw interface.
            Parent root = FXMLLoader.load(getClass()
                    .getResource("stateReport.fxml"));

            primaryStage.setTitle("ERPSystem");   
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);//不能改变大小
            //primaryStage.initStyle(StageStyle. TRANSPARENT);//无边框
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
	}
	
	public static void main(String[] args) {
        launch(args);
    }
	/*private Pane root = new Pane();
	private Label titleLabel = new Label(),incomeLabel = new Label(),outLabel = new Label(),profitLabel = new Label();
	private Font font1 = new Font("楷体",15);
	private Font font2 = new Font("楷体",20);
	private Font font3 = new Font("楷体",16);
	private Color backgroundColor = Color.CORNFLOWERBLUE;
	private Color textColor = Color.WHITE;

	@Override
    public void start(Stage primaryStage) {
		try {
	        // Read file fxml and draw interface.
	        Parent root = FXMLLoader.load(getClass()
	                .getResource("stateReport.fxml"));

	        //primaryStage.setTitle("My Application");
	        
	        primaryStage.setScene(new Scene(root));
	        primaryStage.setResizable(false);//不能改变大小
            primaryStage.initStyle(StageStyle. TRANSPARENT);//无边框
	        primaryStage.show();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public static void main(String[] args) {
	    launch(args);
	}


	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		stateReportUI(primaryStage);
		
	}
	
	protected void stateReportUI(Stage primaryStage){
		//double sx = 0,sy=0;
		Scene scene = new Scene(root,680,600);
		
		titleLabel.setText("经营情况表");
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
		
		Label timeLabel = new Label("选择日期");
		timeLabel.setLayoutX(180);
		timeLabel.setLayoutY(16);
        timeLabel.setFont(font3);
        root.getChildren().add(timeLabel);
        
        DatePicker startDatePicker =new DatePicker();
		startDatePicker.setLayoutX(260);
		startDatePicker.setLayoutY(16);
		startDatePicker.setMaxWidth(100);
		root.getChildren().add(startDatePicker);
		
        
        Label label = new Label("——");
        label.setLayoutX(364);
        label.setLayoutY(16);
       // label.setFont(font1);
        root.getChildren().add(label);
        
        DatePicker endDatePicker =new DatePicker();
		endDatePicker.setLayoutX(400);
		endDatePicker.setLayoutY(16);
		endDatePicker.setMaxWidth(100);
		root.getChildren().add(endDatePicker);
        
        
        Button searchButton = new Button("查询");
        searchButton.setLayoutX(530);
        searchButton.setLayoutY(11);
        searchButton.setFont(font3);
        searchButton.setTextFill(textColor);
        searchButton.setBackground(new Background(new BackgroundFill(Color.DARKGREY, null, null)));
        searchButton.setOnMouseEntered(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent e) {
				searchButton.setScaleX(1.1);
				searchButton.setScaleY(1.1);
			}
		});
        searchButton.setOnMouseExited(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent e) {
				searchButton.setScaleX(1);
				searchButton.setScaleY(1);
			}
		});
        searchButton.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        root.getChildren().add(searchButton);
        
        Button exportButton = new Button("导出");
        exportButton.setLayoutX(620);
        exportButton.setLayoutY(11);
        exportButton.setFont(font3);
        exportButton.setTextFill(textColor);
        exportButton.setBackground(new Background(new BackgroundFill(Color.DARKGREY, null, null)));
        exportButton.setOnMouseEntered(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent e) {
				exportButton.setScaleX(1.1);
				exportButton.setScaleY(1.1);
			}
		});
        exportButton.setOnMouseExited(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent e) {
				exportButton.setScaleX(1);
				exportButton.setScaleY(1);
			}
		});
        exportButton.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				exportUI export = new exportUI();
				export.start(new Stage());
				
			}
		});
        root.getChildren().add(exportButton);
        
        incomeLabel.setText(" 收入类 ");
        incomeLabel.setLayoutX(50);
        incomeLabel.setLayoutY(80);
        incomeLabel.setFont(font2);
        incomeLabel.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, null, null)));
        root.getChildren().add(incomeLabel);
        
        outLabel.setText(" 支出类 ");
        outLabel.setLayoutX(50);
        outLabel.setLayoutY(200);
        outLabel.setFont(font2);
        outLabel.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, null, null)));
        root.getChildren().add(outLabel);
        
        profitLabel.setText(" 利润 ");
        outLabel.setLayoutX(50);
        outLabel.setLayoutY(380);
        outLabel.setFont(font2);
        outLabel.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, null, null)));
        root.getChildren().add(profitLabel);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        //return root;				
	}*/

}
