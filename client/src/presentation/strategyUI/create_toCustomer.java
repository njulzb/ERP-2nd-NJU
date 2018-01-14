package presentation.strategyUI;

import java.io.IOException;
import java.rmi.RemoteException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import BL.strategyBL.StrategyController;
import BLService.strategyBLService.StrategyBLService;
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
import javafx.scene.control.Dialog;
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
import presentation.littleUI.QiPaoUI;
import presentation.littleUI.TipUI;
import presentation.mainUI.UIController;
import presentation.stockUI.GoodsManage.GoodsSelectorUI;
import utility.LOG;
import utility.LevelOfCustomer;
import vo.goods.GoodsVO;
import vo.strategy.CustomerStrategyVO;

public class create_toCustomer extends Application {
	private ArrayList<GoodsVO> giftList = null;
	private Pane root = new Pane();
	private Label title = new Label();
	private Button btn_confirm = new Button(), btn_cancel = new Button(), btn_delete = new Button();
	private Font font_title = new Font("楷体",18);
	private Color backgroundColor = Color.CORNFLOWERBLUE;
	private LevelOfCustomer lob, loe;
	private Date startTime;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		root = getPane(primaryStage);
				
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Pane getPane(Stage primaryStage){
		title.setText("用户级别促销策略");
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
		
		
		
		Label level = new Label("客户等级");
		level.setLayoutX(80);
		level.setLayoutY(180);
		root.getChildren().add(level);
		
		@SuppressWarnings("unchecked")
		ChoiceBox cb_lb = new ChoiceBox(FXCollections.observableArrayList("level1", new Separator(), "level2", 
				new Separator(), "level3", new Separator(), "level4", new Separator(), "level5")); 
		cb_lb.setLayoutX(200);
		cb_lb.setLayoutY(174);
		cb_lb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {  
            @Override  
            public void changed(@SuppressWarnings("rawtypes") ObservableValue observable, Object oldValue, Object newValue) {  
            	String value = (String) newValue;
            	lob = convert(value);
            }  
        }); 
		root.getChildren().add(cb_lb);
		
		Line be = new Line();
		be.setLayoutX(320);
		be.setStartX(-10);
		be.setEndX(10);
		be.setLayoutY(190);
		root.getChildren().add(be);
		
		@SuppressWarnings("unchecked")
		ChoiceBox cb_le = new ChoiceBox(FXCollections.observableArrayList("level1", new Separator(), "level2", 
				new Separator(), "level3", new Separator(), "level4", new Separator(), "level5")); 
		cb_le.setLayoutX(350);
		cb_le.setLayoutY(174);
		cb_le.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {  
            @Override  
            public void changed(@SuppressWarnings("rawtypes") ObservableValue observable, Object oldValue, Object newValue) {  
            	String value = (String) newValue;
            	loe = convert(value);
            }  
        }); 
		root.getChildren().add(cb_le);
		
		Label gift = new Label("是否赠送礼品");
		gift.setLayoutX(70);
		gift.setLayoutY(226);
		root.getChildren().add(gift);
		
		ToggleGroup group = new ToggleGroup();
	    RadioButton btn_yes = new RadioButton("是");
	    btn_yes.setToggleGroup(group);
	    btn_yes.setSelected(true);
	    btn_yes.setUserData(1);
	    RadioButton btn_no = new RadioButton("否");
	    btn_no.setToggleGroup(group);
	    btn_no.setUserData(0);
	    
	    
        btn_yes.setLayoutX(230);
        btn_yes.setLayoutY(226);
        btn_no.setLayoutX(330);
        btn_no.setLayoutY(226);      
	    root.getChildren().add(btn_yes);
	    root.getChildren().add(btn_no);
	
		Label value = new Label("选择代金券面值");
		value.setLayoutX(66);
		value.setLayoutY(276);
		root.getChildren().add(value);
		
		ChoiceBox cb_value = new ChoiceBox(FXCollections.observableArrayList("0", new Separator(), "100", new Separator(),
				"200", new Separator(), "500", new Separator(), "1000", new Separator()));
		cb_value.setLayoutX(240);
		cb_value.setLayoutY(270);
		cb_value.setPrefSize(120, 20);
		cb_value.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {  
            @Override  
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {  
            	String value = (String) newValue;
            	//System.out.println(value);
            }  
        }); 
		root.getChildren().add(cb_value);
		
		Label amount = new Label("选择代金券数量");
		amount.setLayoutX(66);
		amount.setLayoutY(326);
		root.getChildren().add(amount);
		
		ChoiceBox cb_amount = new ChoiceBox(FXCollections.observableArrayList("0", new Separator(), "1", new Separator(),
				"2", new Separator(), "3", new Separator(), "5", new Separator()));
		cb_amount.setLayoutX(240);
		cb_amount.setLayoutY(320);
		cb_amount.setPrefSize(120, 20);
		cb_amount.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {  
            @Override  
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {  
            	String value = (String) newValue;
            	System.out.println(value);
            }  
        }); 
		root.getChildren().add(cb_amount);
		
		Label discount = new Label("价格折让");
		discount.setLayoutX(80);
		discount.setLayoutY(376);
		root.getChildren().add(discount);
		
		ChoiceBox cb_discount = new ChoiceBox(FXCollections.observableArrayList("0", new Separator(), "0.9", new Separator(), "0.88", new Separator(), "0.8"));
		cb_discount.setLayoutX(240);
		cb_discount.setLayoutY(370);
		cb_discount.setPrefSize(120, 20);
		cb_discount.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {  
            @Override  
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {  
            	String value = (String) newValue;
            	//System.out.println(value);
            }  
        }); 
		root.getChildren().add(cb_discount);
		
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
			    
			    if(lob==null || loe==null || duration.getValue() == null || cb_value.getValue() == null || cb_amount.getValue() == null || cb_discount.getValue() == null){
			    	TipUI.showMessageDialog(primaryStage, "信息填写不完整", "Warning Dialog");
			    }
				int days = Integer.parseInt((String) duration.getValue());
				int v = Integer.parseInt((String) cb_value.getValue());
				int a = Integer.parseInt((String) cb_amount.getValue());
				double d = Double.parseDouble((String) cb_discount.getValue());
				
				//test
				/*testList tl = new  testList();
				for(int i=0;i<tl.getGiftList().size();i++){
					giftList.add(tl.getGiftList().get(i));
				}*/
				
				CustomerStrategyVO c = new  CustomerStrategyVO(startTime, days, "stc-", lob, loe, a*v, giftList);
				StrategyBLService sbl = new StrategyController();
				String id = null;
				try {
					id = sbl.createStrategy(c);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				LOG.addLog("添加了用户级别促销策略"+id, "161250088");
				if(!id.substring(0, 3).equals("stc")){
					TipUI.showMessageDialog(primaryStage, "添加失败", "Warning Dialog");
				}
				
				
				QiPaoUI notice = new QiPaoUI();
				try {
					notice.showTip((Pane)UIController.getUIController().getUIStage().getScene().getRoot(), "成功添加用户级别促销策略"+id);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				primaryStage.hide();
			}
			
		});
		root.getChildren().add(btn_confirm);
		
		Scene scene = new Scene(root, 600, 500);
		primaryStage.setTitle("ERPsystem");
		primaryStage.setResizable(false);//不能改变大小
		primaryStage.initStyle(StageStyle. TRANSPARENT);//无边框
		primaryStage.setScene(scene);
		primaryStage.show();
		
		return root;		
	}
	
	public LevelOfCustomer convert(String level){
		LevelOfCustomer loc = null;
		switch(level){
		case "level1":
			return loc.level1;
		
	    case "level2":
		    return loc.level2;
	    
        case "level3":
	        return loc.level3;
	        
        case "level4":
        	return loc.level4;
        	
        case "level5":
        	return loc.level5;	
        	
		}
		return null;
	}

	
	public static void main(String[] args){
		launch(args);
	}
	
	
	
}
