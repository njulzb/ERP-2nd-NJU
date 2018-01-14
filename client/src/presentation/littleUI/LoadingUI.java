package presentation.littleUI;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Alan
 */
public class LoadingUI extends Application {
static double y=440;
static double x=660;
	public static void showLoadingUI(Pane owner,String message) throws IOException {
		QiPaoView qipao =new QiPaoView();
//		  mainPane=null;
		
		final	Pane mainPane =qipao.InfoPane(message);
		mainPane.setMaxWidth(owner.getWidth());
		mainPane.setMinWidth(owner.getWidth());
		mainPane.setLayoutY(999);
		Text text = new Text(message);
		text.setFont(new Font(20));
		text.setFill(Color.YELLOW);
		VBox box = new VBox();
		box.getChildren().add(text);
		box.setStyle("-fx-background:transparent;");

		final int width = 200;
		final int height = 50;
		final Scene scene = new Scene(mainPane, width, height);
		scene.setFill(null);

		
	 owner.getChildren().add(mainPane);
		
		
//		
//		final Stage stage = new Stage();
//		stage.setAlwaysOnTop(true);
//		stage.initStyle(StageStyle.TRANSPARENT);
//		stage.setScene(scene);
//		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
//		stage.setX(primaryScreenBounds.getWidth() / 2 - width);
//		stage.setY(primaryScreenBounds.getHeight() / 2 - height);
//		stage.show();

		Task t = new Task() {
			@Override
			protected Object call() throws Exception {
				double toY =owner.getHeight()-30;
				double nowY =owner.getHeight()+30;
				System.out.println("startNowY="+nowY);
				while(nowY>=toY+3) {
					nowY-=4;
					mainPane.setLayoutY(nowY);
					Thread.sleep(20);
				}
				
				Thread.sleep(1300);
				for(int i=0;i<20;i++) {
					;
					mainPane.setLayoutY(nowY+2*i);
					mainPane.setOpacity(0.6-i*0.03);
					Thread.sleep(50);
					
				}
				
//				owner.getChildren().remove(mainPane);
				mainPane.setVisible(false);
//				Platform.runLater(stage::close);
				return "";
			}
		};
		new Thread(t).start();
	}

	@Override
	public void start(Stage primaryStage) {
		Button btn = new Button();
		btn.setText("显示提示");
//		btn.setOnMousePressed(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent e) {
//				x=e.getSceneX();
//				y=e.getSceneY();
//				showTip("hqj!!!!!");
//
//			}
//		});
		

		Pane root = new  Pane();
		root.getChildren().add(btn);
		Scene scene = new Scene(root, 300, 250);
		
		btn.setOnAction((ActionEvent event) -> {
			try {
				showLoadingUI(root,"金币 +15");
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		});
		
		
		primaryStage.setTitle("Hello World!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

}