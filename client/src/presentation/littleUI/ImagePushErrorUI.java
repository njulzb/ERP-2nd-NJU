package presentation.littleUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ImagePushErrorUI extends Application {
	//public StockFormItemVO  item=new  StockFormItemVO();
	MouseEvent e;
    @Override
    public void start(Stage stage)throws Exception {
    	
    	TipUI.showMessageDialog( stage, "dsd", "dsd");
    	
    	
    	
    	
    	
    	
    	
    	
    	
        stage.setTitle("Error");
        stage.setAlwaysOnTop(true);
        Pane root =new Pane();
        
        
        

		Label label_buttonNew = new Label("错误：   上传图片失败!");
		label_buttonNew.setFont(new Font(21));
		label_buttonNew .setLayoutX(20);
		label_buttonNew  .setLayoutY(26);

		root.getChildren().add(label_buttonNew);
		
		
		Label label_butte = new Label("请确认上传图片为png格式");
		label_butte.setFont(new Font(13));
		label_butte .setLayoutX(20);
		label_butte  .setLayoutY(60);

		root.getChildren().add(label_butte);
        
        
        
        
        Scene scene = new Scene(root, 300, 100);
        stage.setScene(scene);

        stage.show();
    }


    public static void main(String[]args) {
    	
       launch(args);
   }

}


