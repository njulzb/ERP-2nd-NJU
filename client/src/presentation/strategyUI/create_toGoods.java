package presentation.strategyUI;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import BLService.strategyBLService.stub.StrategyBLServiceStub;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import utility.LOG;
import vo.goods.GoodsVO;
import vo.strategy.GoodsStrategyVO;

public class create_toGoods extends Application {
	private ArrayList<GoodsVO> giftList = new ArrayList<GoodsVO>();
	private Pane root = new Pane();
	private Label title = new Label();
	private Button btn_confirm = new Button(), btn_cancel = new Button();
	private Font font_title = new Font("楷体",18);
	private Color backgroundColor = Color.CORNFLOWERBLUE;
	private Date startTime;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		getPane(primaryStage);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Pane getPane(Stage primaryStage){
		title.setText("组合商品特价策略");
		title.setLayoutX(14);
		title.setLayoutY(22);
		title.setFont(font_title);
		title.setTextFill(Color.CORNFLOWERBLUE);
		root.getChildren().add(title);
		
		Line line = new Line();
		line.setStartX(-100);
		line.setStartY(70);
		line.setEndX(180);
		line.setEndY(70);
		line.setStrokeWidth(1.5);
		line.setStroke(Color.GRAY);
		root.getChildren().add(line);
		
		Line line1 = new Line();
		line1.setLayoutX(160);
		line1.setLayoutY(36);
		line1.setStartX(-15);
		line1.setEndX(54);
		line1.setRotate(90);
		line1.setStrokeWidth(1.5);
		line1.setStroke(Color.GRAY);
		root.getChildren().add(line1);
		
		Label startT = new Label("起始时间");
		startT.setLayoutX(80);
		startT.setLayoutY(90);
		root.getChildren().add(startT);
		
		DatePicker st = new DatePicker();
		st.setLayoutX(240);
		st.setLayoutY(85);
		st.setPrefWidth(160);
		root.getChildren().add(st);
		
		Label durations = new Label("间隔时间");
		durations.setLayoutX(80);
		durations.setLayoutY(130);
		root.getChildren().add(durations);
		
		ChoiceBox duration = new ChoiceBox(FXCollections.observableArrayList("30", new Separator(), "45", new Separator(),
				"60", new Separator(), "90"));
		duration.setLayoutX(240);
		duration.setLayoutY(125);
		duration.setPrefSize(120, 20);
		duration.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {  
            @Override  
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {  
            	String value = (String) newValue;
            	System.out.println(value);
            }  
        }); 
		root.getChildren().add(duration);
		
		btn_cancel.setText("取消");
		btn_cancel.setLayoutX(170);
		btn_cancel.setLayoutY(440);
		btn_cancel.setBackground(new Background(new BackgroundFill(backgroundColor,null,null)));
		btn_cancel.setOnMouseEntered(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				btn_cancel.setLayoutX(btn_cancel.getLayoutX()+3);
				btn_cancel.setLayoutY(btn_cancel.getLayoutY()+3);
			}
			
		});
		btn_cancel.setOnMouseExited(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				btn_cancel.setLayoutX(btn_cancel.getLayoutX()-3);
				btn_cancel.setLayoutY(btn_cancel.getLayoutY()-3);
			}
			
		});
		btn_cancel.setOnMousePressed(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				primaryStage.hide();
			}
			
		});
		root.getChildren().add(btn_cancel);
		
		btn_confirm.setText("确认");
		btn_confirm.setLayoutX(330);
		btn_confirm.setLayoutY(440);
		btn_confirm.setBackground(new Background(new BackgroundFill(backgroundColor,null,null)));
		btn_confirm.setOnMouseEntered(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				btn_confirm.setLayoutX(btn_confirm.getLayoutX()+3);
				btn_confirm.setLayoutY(btn_confirm.getLayoutY()+3);
			}
			
		});
		btn_confirm.setOnMouseExited(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				btn_confirm.setLayoutX(btn_confirm.getLayoutX()-3);
				btn_confirm.setLayoutY(btn_confirm.getLayoutY()-3);
			}
			
		});
		btn_confirm.setOnMousePressed(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				LocalDate t = st.getValue();
				ZoneId zone = ZoneId.systemDefault();
				Instant instant = t.atStartOfDay().atZone(zone).toInstant();
			    startTime = Date.from(instant);
			    
				int days = Integer.parseInt((String) duration.getValue());
				GoodsStrategyVO g = new GoodsStrategyVO(null, 0, "stg-", giftList, 0);
				StrategyBLServiceStub sbl = new StrategyBLServiceStub();
				String id = sbl.createStrategy(g);
				
				LOG.addLog("添加了组合商品特价策略", "161250088");
			}
			
		});
		root.getChildren().add(btn_confirm);
		
		Scene scene = new Scene(root, 600, 500);
		primaryStage.setTitle("ERPsystem");
		//primaryStage.setResizable(false);//不能改变大小
		//primaryStage.initStyle(StageStyle. TRANSPARENT);//无边框
		primaryStage.setScene(scene);
		primaryStage.show();
		
		return root;		
	}

}
