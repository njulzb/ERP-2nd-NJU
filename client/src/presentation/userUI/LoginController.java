package presentation.userUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import presentation.littleUI.QiPaoUI;
import presentation.mainUI.UIController;
import utility.RoleOfUser;
import vo.UserVO;

import java.io.IOException;

import BL.userBL.UserController;
import BLService.userBLService.UserBLServiceForNormal;
import BLService.userBLService.stub.UserBLServiceStub;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.PasswordField;

public class LoginController {
	@FXML
	private Button loginButton;
	@FXML
	private Button closeButton;
	@FXML
	private AnchorPane allUI;
	@FXML
	private TextField idTextField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Label forgetPassword;

//判断登录
	void login() throws IOException{
		UserBLServiceForNormal userBlService= new UserController();

		//System.out.println(userBlService.login(idTextField.getText(), passwordField.getText()));
		if (userBlService.login(idTextField.getText(), passwordField.getText())!=null){

			UserVO user=userBlService.login(idTextField.getText(), passwordField.getText());
			if (user.getRole().equals(RoleOfUser.admin)) {
				UIController.getUIController().runOperatorUI();
			}else {
				UIController.getUIController().runMainUI(user);
			}

		}else{
			QiPaoUI fail =new QiPaoUI();
			fail.showTip(allUI, "账号或密码不正确!");
		}
	}

	// Event Listener on Button[#closeButton].onAction
	@FXML
	public void onButtonClick(ActionEvent event) throws Exception {
		// TODO Autogenerated
		login();

	}

	@FXML
	public void closeAction(MouseEvent event) throws Exception {
		UIController.getUIController().exit();
	}

	@FXML
	public void setColor(MouseEvent event) {
		// TODO Autogenerated
		forgetPassword.setTextFill(Color.PURPLE);
	}

	@FXML
	public void cancelColor(MouseEvent event) {
		// TODO Autogenerated
		forgetPassword.setTextFill(Color.BLACK);
	}

	@FXML
	public void judgeEnter(KeyEvent event) throws Exception {
		if (event.getCode()==KeyCode.ENTER){
			login();
		}
	}

	@FXML
	public void showTips(MouseEvent event) throws Exception {
		QiPaoUI fail =new QiPaoUI();
		fail.showTip(allUI, "请与管理者联系，联系公司：天台4人组");
	}
}