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
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import utility.LOG;
import vo.goods.GoodsVO;
import vo.strategy.TotalStrategyVO;

public class create_toTotal extends Application {
	private ArrayList<GoodsVO> giftList = new ArrayList<GoodsVO>();
	private Pane root = new Pane();
	private Label title = new Label();
	private Button btn_confirm = new Button(), btn_cancel = new Button(), btn_delete = new Button();
	private Font font_title = new Font("楷体",18);
	private Color backgroundColor = Color.CORNFLOWERBLUE;
	private double totalPrice;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		root = getPane(primaryStage);
		
		
				
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Pane getPane(Stage primaryStage){
		title.setText(" 总额促销策略");
		title.setLayoutX(22);
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
		startT.setLayoutY(110);
		root.getChildren().add(startT);
		
		DatePicker st = new DatePicker();
		st.setLayoutX(240);
		st.setLayoutY(105);
		st.setPrefWidth(160);
		root.getChildren().add(st);
		
		Label durations = new Label("间隔时间");
		durations.setLayoutX(80);
		durations.setLayoutY(160);
		root.getChildren().add(durations);
		
		ChoiceBox duration = new ChoiceBox(FXCollections.observableArrayList("30", new Separator(), "45", new Separator(),
				"60", new Separator(), "90"));
		duration.setLayoutX(240);
		duration.setLayoutY(155);
		duration.setPrefSize(120, 20);
		duration.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {  
            @Override  
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {  
            	String value = (String) newValue;
            	System.out.println(value);
            }  
        }); 
		root.getChildren().add(duration);
		
		Label total = new Label(" 总额 ");
		total.setLayoutX(90);
		total.setLayoutY(210);
		root.getChildren().add(total);
		
		@SuppressWarnings("unchecked")
		ChoiceBox cb_t = new ChoiceBox(FXCollections.observableArrayList("68", new Separator(), "99", 
				new Separator(), "199", new Separator(), "299", new Separator(), "500")); 
		cb_t.setLayoutX(240);
		cb_t.setLayoutY(205);
		cb_t.setPrefWidth(120);
		cb_t.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {  
            @Override  
            public void changed(@SuppressWarnings("rawtypes") ObservableValue observable, Object oldValue, Object newValue) {  
            	String value = (String) newValue;
            	totalPrice = Double.parseDouble(value);
            }  
        }); 
		root.getChildren().add(cb_t);
		
		
		Label gift = new Label("是否赠送礼品");
		gift.setLayoutX(70);
		gift.setLayoutY(260);
		root.getChildren().add(gift);
		
		ToggleGroup group = new ToggleGroup();
	    RadioButton btn_yes = new RadioButton("是");
	    btn_yes.setToggleGroup(group);
	    btn_yes.setSelected(true);
	    btn_yes.setUserData(1);
	    RadioButton btn_no = new RadioButton("否");
	    btn_no.setToggleGroup(group);
	    btn_no.setUserData(0);
	    
	    group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
	        public void changed(ObservableValue<? extends Toggle> ov,
	            Toggle old_toggle, Toggle new_toggle) {
	          if (group.getSelectedToggle() != null) {
	            System.out.println(group.getSelectedToggle().getUserData().toString());
	          }
	        }
	      });

	    
        btn_yes.setLayoutX(230);
        btn_yes.setLayoutY(260);
        btn_no.setLayoutX(330);
        btn_no.setLayoutY(260);      
	    root.getChildren().add(btn_yes);
	    root.getChildren().add(btn_no);
	
		Label value = new Label("选择代金券面值");
		value.setLayoutX(66);
		value.setLayoutY(310);
		root.getChildren().add(value);
		
		ChoiceBox cb_value = new ChoiceBox(FXCollections.observableArrayList("0", new Separator(), "10", new Separator(),
				"25", new Separator(), "50", new Separator(), "100", new Separator()));
		cb_value.setLayoutX(240);
		cb_value.setLayoutY(305);
		cb_value.setPrefSize(120, 20);
		cb_value.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {  
            @Override  
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {  
            	String value = (String) newValue;
            	System.out.println(value);
            }  
        }); 
		root.getChildren().add(cb_value);
		
		Label amount = new Label("选择代金券数量");
		amount.setLayoutX(66);
		amount.setLayoutY(360);
		root.getChildren().add(amount);
		
		ChoiceBox cb_amount = new ChoiceBox(FXCollections.observableArrayList("0", new Separator(), "1", new Separator(),
				"2", new Separator(), "3", new Separator(), "5", new Separator()));
		cb_amount.setLayoutX(240);
		cb_amount.setLayoutY(355);
		cb_amount.setPrefSize(120, 20);
		cb_amount.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {  
            @Override  
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {  
            	String value = (String) newValue;
            	System.out.println(value);
            }  
        }); 
		root.getChildren().add(cb_amount);

		
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
			    Date startTime = Date.from(instant);
			    
				int days = Integer.parseInt((String) duration.getValue());
				int v = Integer.parseInt((String) cb_value.getValue());
				int a = Integer.parseInt((String) cb_amount.getValue());
				
				if(group.getSelectedToggle().getUserData().toString()=="1"){
					TotalStrategyVO tsv = new TotalStrategyVO(startTime, days, null, totalPrice, v*a, giftList);
					StrategyBLServiceStub sbl = new StrategyBLServiceStub();
					String id = sbl.createStrategy(tsv);
					tsv.setID("stt-" + id);
				}else{
					TotalStrategyVO tsv = new TotalStrategyVO(startTime, days, null, totalPrice, v*a, null);
					StrategyBLServiceStub sbl = new StrategyBLServiceStub();
					String id = sbl.createStrategy(tsv);
					tsv.setID("stt-" + id);
				}
				
				LOG.addLog("添加了总额促销策略", "161250088");
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
	
	public static void main(String[] args){
		launch(args);
	}
	
	
}
