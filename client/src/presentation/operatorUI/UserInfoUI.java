package presentation.operatorUI;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import vo.UserVO;

public class UserInfoUI {
	UserInfoUIController userInfoUIController;

	//返回指定用户的用户信息条目pane
	public AnchorPane InfoPane(UserVO user) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserInfoUI.fxml"));
		AnchorPane pane =fxmlLoader.load();
		userInfoUIController=fxmlLoader.getController();
		userInfoUIController.init(user);
		//Scene scene = new Scene(curr,800,600);

		return pane;
	}
}
