package presentation.userUI;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import vo.UserVO;

public class homeUI {
	homeUIController homeController;
	UserVO user;
	//返回用户登录信息界面
	public AnchorPane homePane() throws IOException{

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("homeUI.fxml"));
		AnchorPane pane =fxmlLoader.load();
		homeController=fxmlLoader.getController();
		homeController.init(user);
		return pane;
	}

	public void setUser(UserVO user2){
		user=user2;
	}
}
