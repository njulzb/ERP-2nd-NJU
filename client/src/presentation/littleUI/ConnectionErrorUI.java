package presentation.littleUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ConnectionErrorUI extends Application {
	//public StockFormItemVO  item=new  StockFormItemVO();
	MouseEvent e;
    @Override
    public void start(Stage stage)throws Exception {
        stage.setTitle("Error");
        stage.setAlwaysOnTop(true);
        Pane root =new Pane();
        TipUI.showMessageDialog( stage, "dsd", "dsd");
		Label label_buttonNew = new Label("错误：无法连接到服务器");
		label_buttonNew.setFont(new Font(21));
		label_buttonNew .setLayoutX(20);
		label_buttonNew  .setLayoutY(35);

		root.getChildren().add(label_buttonNew);
		
		
        
        
        
        
        
        Scene scene = new Scene(root, 300, 100);
        stage.setScene(scene);

        stage.show();
    }


    public static void main(String[]args) {
        launch(args);
   }

}


