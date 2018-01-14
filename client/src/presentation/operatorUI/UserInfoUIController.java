package presentation.operatorUI;

import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import presentation.customerUI.EditCustomerUI;
import vo.UserVO;

public class UserInfoUIController {
	@FXML
	private HBox Info;
	@FXML
	private Label backColor;
	@FXML
	private Label name;
	@FXML
	private Label role;
	@FXML
	private Label id;
	@FXML
	private Label password;
	@FXML
	private ImageView img;
	private UserVO user = new UserVO();

//初始化
	void init(UserVO user){
		name.setText(user.getName());
		role.setText(user.getRole().toString());
		id.setText(user.getID());

		password.setText(user.getPassword());
		String imgPath = user.getImagePath() ;
		Image imagePush = new Image("file:" + imgPath);
		img.setImage(imagePush);
		this.user=user;
	}
//增加进出效果
	@FXML
	void editPane(MouseEvent event) throws Exception{

		EditUserUI editUser =  new EditUserUI();
		editUser.setUser(user);
		editUser.start(new Stage());
	}

	@FXML
	void enterHBox(MouseEvent event) throws Exception{
		backColor.setOpacity(0.81);
	}

	@FXML
	void exitHBox(MouseEvent event) throws Exception{
		backColor.setOpacity(0.01);
	}
}
