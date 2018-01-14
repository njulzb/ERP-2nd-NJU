package presentation.operatorUI;

import java.io.IOException;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UserUIController {
	//获得用户管理主界面
	public AnchorPane getUserMainUI() throws IOException{
		UserMainUI userPane = new UserMainUI();
		return userPane.UserPane();
	}
//运行新增用户新窗口
	public void runNewUserUI() throws Exception{
		NewUserUI newUserUI = new NewUserUI();
		newUserUI.start(new Stage());
	}

}
