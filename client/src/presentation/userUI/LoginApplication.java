package presentation.userUI;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginApplication extends Application {
	double xOffset;
	double yOffset;

	//新建登录窗口
	@Override
	public void start(Stage primaryStage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
		Parent root = fxmlLoader.load();
		// 如果使用 Parent root = FXMLLoader.load(...) 静态读取方法，无法获取到Controller的实例对象
		Scene scene = new Scene(root, 800, 600);

		primaryStage.setTitle("");
		primaryStage.setScene(scene);

		root.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				e.consume();
				xOffset = e.getSceneX();
				yOffset = e.getSceneY();
			}
		});

		//设置成可随意拖动
		root.setOnMouseDragged(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				e.consume();
				primaryStage.setX(e.getScreenX() - xOffset);

				// 根据自己的需求，做不同的判断
				if (e.getScreenY() - yOffset < 0) {
					primaryStage.setY(0);
				} else {
					primaryStage.setY(e.getScreenY() - yOffset);
				}
			}
		});

		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
