package presentation.operatorUI;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import BL.userBL.UserController;
import BLService.customerBLService.CustomerBLService;
import BLService.userBLService.UserBLServiceForAdmin;
import BLService.userBLService.UserBLServiceForNormal;
import BLService.userBLService.stub.UserBLServiceStub;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import presentation.littleUI.QiPaoUI;
import presentation.mainUI.UIController;
import presentation.mainUI.UIcaller;
import presentation.userUI.Operator.OperatorUIController;
import presentation.userUI.SaleManager.SaleUIController;
import utility.ImageZipUtil;
import utility.LevelOfCustomer;
import utility.RoleOfUser;
import utility.TypeOfCustomer;
import vo.CustomerVO;
import vo.UserVO;
import javafx.scene.control.ChoiceBox;

public class NewUserUIController {
	@FXML
	private AnchorPane Apane;
	@FXML
	private ImageView Img;
	@FXML
	private Label addPhotoLabel;
	@FXML
	private Label closeButtonBackground;
	@FXML
	private TextField userName;
	@FXML
	private ChoiceBox role;
	@FXML
	private TextField passwordcode;
	@FXML
	private TextField id;
	@FXML
	private Button confirmButton;
	@FXML
	private Button cancelButton;
	@FXML
	private Button clearButton;
	@FXML
	private Label closeButton;

	private UserVO newUserVO = new UserVO();

	//初始化
	public void init() throws RemoteException{
		System.out.println(role);
		role.setItems(FXCollections.observableArrayList(RoleOfUser.FinancialManager,RoleOfUser.GeneralManager,RoleOfUser.SaleManager,RoleOfUser.saler,RoleOfUser.StoreManager));
		role.setTooltip(new Tooltip("Select the role of user"));
	}

//	String getFolderPath() {
//		File directory = new File("");// 设定为当前文件夹
//		String folderPath = "";
//		try {
//			folderPath = directory.getCanonicalPath();
//
//		} catch (Exception e) {
//		}
//		return folderPath;
//	}

	//增添照片
	// Event Listener on Label[#addPhotoButton].onMouseClicked
	@FXML
	public void addPhoto(MouseEvent event) {
		// TODO Autogenerated

		addPhotoLabel.setTextFill(Color.PURPLE);

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		File file;

		file = fileChooser.showOpenDialog(new Stage());

		String filePath = "null";
		if (file == null) {
			return;
		}
		filePath = file.getAbsolutePath();

		if (filePath!=null) {
			String imgPath = "C://temp/" + filePath.hashCode() + ".png";
			ImageZipUtil.zipWidthHeightImageFile(new File(filePath), new File(imgPath), 80, 80, 1.0f);

			Image imagePush = new Image("file:" + imgPath);
			Img.setImage(imagePush);
			//System.out.println("pres"+imgPath);
			newUserVO.setImagePath(imgPath);

		}
	}


	private boolean judgenull() {
		// TODO Auto-generated method stub
		if (id.getText().equals("") || userName.getText().equals("")
				|| role.getSelectionModel().getSelectedItem() == null || passwordcode.getText().equals(""))
			return true;
		return false;
	}
	//上传用户信息
	// Event Listener on Button[#confirmButton].onMouseClicked
	@FXML
	public void uploadCustomerInfo(MouseEvent event) throws IOException {
		// TODO Autogenerated
		if (judgenull()) {
			QiPaoUI notice = new QiPaoUI();
			notice.showTip(Apane, "用户核心信息不能为空！");
		} else {

			newUserVO.setName(userName.getText());
			newUserVO.setID(id.getText());
			newUserVO.setPassword(passwordcode.getText());
			String work=role.getSelectionModel().getSelectedItem().toString();
			if (work.equals(RoleOfUser.FinancialManager.toString()))
				newUserVO.setRole(RoleOfUser.FinancialManager);
			if (work.equals(RoleOfUser.GeneralManager.toString()))
				newUserVO.setRole(RoleOfUser.GeneralManager);
			if (work.equals(RoleOfUser.SaleManager.toString()))
				newUserVO.setRole(RoleOfUser.SaleManager);
			if (work.equals(RoleOfUser.saler.toString()))
				newUserVO.setRole(RoleOfUser.saler);
			if (work.equals(RoleOfUser.StoreManager.toString()))
				newUserVO.setRole(RoleOfUser.StoreManager);
			if (Img==null){
				newUserVO.setImagePath("c:\\temp\\default.png");
			}

			UserBLServiceForAdmin userBlService= new UserController();
			userBlService.addUser(newUserVO);

			NewUserUI.getStage().close();
			OperatorUIController.getOperatorUIController().runNewStage("userButton");

			QiPaoUI notice = new QiPaoUI();
			notice.showTip((Pane)UIController.getUIController().getUIStage().getScene().getRoot(), "新增成功！");
		}


	}

	// Event Listener on Button[#cancelButton].onMouseClicked
	@FXML
	public void closeStage(MouseEvent event) {
		// TODO Autogenerated
		NewUserUI.getStage().close();
	}

	//清除输入
	// Event Listener on Button[#cleearButton].onMouseClicked
	@FXML
	public void clearInput(MouseEvent event) {
		// TODO Autogenerated
		id.setText("");
		userName.setText("");
		passwordcode.setText("");
		role.getSelectionModel().select(null);

		Image noneImg = new Image("c:\\temp\\default.png");
		Img.setImage(noneImg);
	}
}
