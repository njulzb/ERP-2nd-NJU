package presentation.strategyUI;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class NewStrategyUI extends Application {
	private Pane root = new Pane(),strategy_create = new Pane();
	private Font font1 = new Font("楷体",18), font2 = new Font("楷体",16);
	private Label titleLabel = new Label();

	public static void main(String[] args) {
		launch(args);
    }

	
	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Scene scene = new Scene(root,600,600);
		titleLabel.setText("添加新策略");
		titleLabel.setLayoutX(30);
		titleLabel.setLayoutY(30);
		titleLabel.setFont(new Font("楷体",23));
		root.getChildren().add(titleLabel);
		
		Line line = new Line();
		line.setStartX(30);
		line.setStartY(84);
		line.setEndX(580);
		line.setEndY(84);
		line.setStrokeWidth(25);
		line.setStroke(Color.CORNFLOWERBLUE);
		root.getChildren().add(line);
		
		strategy_create.setPrefSize(600, 500);
 		strategy_create.setLayoutX(0);
 		strategy_create.setLayoutY(100);
 		strategy_create.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, null, null)));
 		root.getChildren().add(strategy_create);
 		
 		create_toCustomer create_c = new create_toCustomer();
		Pane p_c = create_c.getPane(primaryStage);
		p_c.setLayoutX(0);
		p_c.setLayoutY(100);
		p_c.setPrefSize(600, 500);
		p_c.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		p_c.setVisible(false);
		root.getChildren().add(p_c);
		
		create_toGoods create_g = new create_toGoods();
		Pane p_g = create_g.getPane(primaryStage);
		p_g.setLayoutX(0);
		p_g.setLayoutY(100);
		p_g.setPrefSize(600, 500);
		p_g.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		p_g.setVisible(false);
		root.getChildren().add(p_g);
		
		create_toTotal create_t = new create_toTotal();
		Pane p_t = create_t.getPane(primaryStage);
		p_t.setLayoutX(0);
		p_t.setLayoutY(100);
		p_t.setPrefSize(600, 500);
		p_t.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		p_t.setVisible(false);
		root.getChildren().add(p_t);
		
		Label type = new Label("选择策略类型");
		type.setLayoutX(220);
		type.setLayoutY(32);
		type.setFont(font2);
		root.getChildren().add(type);
		
		ArrayList<String> optionList=new ArrayList<String>();
		optionList.add("用户级别策略");
		optionList.add("组合商品特价策略");
		optionList.add("总额促销策略");
 		ObservableList<String> options=FXCollections.observableArrayList(optionList);
 		
 		ComboBox<String> comboBox= new ComboBox<String>(options); 	
 		comboBox.setLayoutX(350);
 		comboBox.setLayoutY(28);
 		comboBox.setMaxSize(200, 10);
 		comboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {  
            @Override  
            public void changed(@SuppressWarnings("rawtypes") ObservableValue observable, Object oldValue, Object newValue) {  
            	System.out.println(newValue);
            	if(newValue.equals("用户级别策略")){
            		//Pane create = FXMLLoader.load(getClass().getResource("create_toCustomer.fxml"));
					strategy_create.setVisible(false);
					p_c.setVisible(true);
					p_g.setVisible(false);
					p_t.setVisible(false);
            
            	}else if(newValue.equals("组合商品特价策略")){
            		strategy_create.setVisible(false);
					p_g.setVisible(true);
					p_c.setVisible(false);
					p_t.setVisible(false);
            	}else {
            		strategy_create.setVisible(false);
					p_t.setVisible(true);
					p_g.setVisible(false);
					p_c.setVisible(false);
            	}
            }  
        }); 
 		root.getChildren().add(comboBox);
		
 		primaryStage.setScene(scene);
 		primaryStage.setTitle("ERPsystem");
		//primaryStage.initModality(Modality.APPLICATION_MODAL);		
 		primaryStage.show();
 			

	}
	
}
