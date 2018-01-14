package presentation.operatorUI;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import BL.userBL.UserController;
import BLService.userBLService.UserBLServiceForAdmin;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import presentation.customerUI.CustomerInfoUI;
import presentation.customerUI.CustomerMainUIController;
import utility.RoleOfUser;
import vo.UserVO;



public class UserMainUI {
	ArrayList<UserVO> userList = new ArrayList<UserVO>();

	//获得用户列表
	void getList() throws RemoteException{
		UserBLServiceForAdmin userBLService = new UserController();

		for (RoleOfUser role : RoleOfUser.values()){
			ArrayList<UserVO> List = userBLService.searchUserByRole(role);
			if (List != null) {
				for (int i = 0; i < List.size(); i++) {
					UserVO user = List.get(i);
					userList.add(user);
				}
			}
		}

	}

	//返回用户管理主界面
	public AnchorPane UserPane() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("userMainUI.fxml"));
		AnchorPane pane = fxmlLoader.load();
		UserMainUIController controller = fxmlLoader.getController();

		getList();

		VBox list=new VBox();
		for (int i=0;i<userList.size();i++){
			UserInfoUI userInfoUI =new UserInfoUI();
			AnchorPane userPane=userInfoUI.InfoPane(userList.get(i));
			userPane.toFront();
			list.getChildren().add(userPane);
		}
		controller.setScrollPane(list);

		return pane;
	}

}
