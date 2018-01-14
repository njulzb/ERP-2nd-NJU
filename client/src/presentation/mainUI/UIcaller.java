package presentation.mainUI;

import javafx.application.Application;
import javafx.stage.Stage;
//import presentation.littleUI.ConnectionErrorUI3;
import presentation.littleUI.ImagePushErrorUI;

public class UIcaller extends Application{
	
	
////各类call方法
	public static void callConnectionErrorUI() {
//		ConnectionErrorUI3 c=new ConnectionErrorUI3 ();
//		try {
//			c.start(new Stage());
//		} catch (Exception e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
	}
	public static void callImagePushErrorUI() {
		ImagePushErrorUI c=new 	ImagePushErrorUI  ();
		try {
			c.start(new Stage());
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		
	}
}
