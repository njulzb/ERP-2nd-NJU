package presentation.customerUI;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import BL.customerBL.CustomerController;
import BL.userBL.UserController;
import BLService.customerBLService.CustomerBLService;
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
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import presentation.littleUI.QiPaoUI;
import presentation.mainUI.UIController;
import presentation.mainUI.UIcaller;
import presentation.userUI.SaleManager.SaleUIController;
import utility.ImageZipUtil;
import utility.LevelOfCustomer;
import utility.RoleOfUser;
import utility.TypeOfCustomer;
import vo.CustomerVO;
import vo.UserVO;
import javafx.scene.control.ChoiceBox;

public class EditCustomerUIController {
	@FXML
	private Pane pane;
	@FXML
	private ImageView custonerImg;
	@FXML
	private Label addPhotoLabel;
	@FXML
	private Label closeButtonBackground;
	@FXML
	private TextField customerName;
	@FXML
	private ChoiceBox typeOfCustomer;
	@FXML
	private ChoiceBox levelOfCustomer;
	@FXML
	private ChoiceBox defaultOperator;
	@FXML
	private TextField phone;
	@FXML
	private TextField address;
	@FXML
	private TextField postcode;
	@FXML
	private TextField email;
	@FXML
	private TextField receiveLimit;
	@FXML
	private Button confirmButton;
	@FXML
	private Button cancelButton;
	@FXML
	private Button deleteButton;
	@FXML
	private Label closeButton;
	@FXML
	private Label receiveAmount;
	@FXML
	private Label payAmount;

	private CustomerVO newCustomerVO;
	private ArrayList<UserVO> userList = new ArrayList<UserVO>();

	//初始化界面，显示原客户信息
	public void init(CustomerVO info) throws RemoteException {
		typeOfCustomer.setItems(FXCollections.observableArrayList(TypeOfCustomer.exporter, TypeOfCustomer.importer));
		levelOfCustomer.setItems(FXCollections.observableArrayList(LevelOfCustomer.level1, LevelOfCustomer.level2,
				LevelOfCustomer.level3, LevelOfCustomer.level4, LevelOfCustomer.level5));

		UserBLServiceForNormal userBlService = new UserController();
		newCustomerVO = info;

		userList = userBlService.searchUserByRole(RoleOfUser.saler);
		ArrayList<String> userNameList = new ArrayList<String>();
		String defaultname = null;
		for (UserVO i : userList) {
			userNameList.add(i.getName());
			if (i.getID().equals(info.getDefaultOperatorid())) {
				defaultname = i.getName();
			}
		}
		userList = userBlService.searchUserByRole(RoleOfUser.SaleManager);
		for (UserVO i : userList) {
			userNameList.add(i.getName());
			if (i.getID().equals(info.getDefaultOperatorid())) {
				defaultname = i.getName();
			}
		}

		ObservableList<String> list = FXCollections.observableList(userNameList);
		defaultOperator.setItems(list);
		typeOfCustomer.setTooltip(new Tooltip("选择客户类型"));
		levelOfCustomer.setTooltip(new Tooltip("选择客户等级"));
		defaultOperator.setTooltip(new Tooltip("选择默认销售人员"));

		defaultOperator.getSelectionModel().select(defaultname);
		levelOfCustomer.getSelectionModel().select(info.getLevel());
		typeOfCustomer.getSelectionModel().select(info.getType());

		address.setText(info.getAddress());
		customerName.setText(info.getName());
		phone.setText(info.getPhoneNumber());
		email.setText(info.getEmail());
		postcode.setText(info.getPostcode());

		DecimalFormat format = new DecimalFormat("#.00");

		double x = info.getReceiveLimit();
		receiveLimit.setText(format.format(x));

		x = info.getReceiveAmount();
		receiveAmount.setText(format.format(x));

		x = info.getPayAmount();
		payAmount.setText(format.format(x));

		String imgPath = info.getImagePath();
		Image imagePush = new Image("file:" + imgPath);
		custonerImg.setImage(imagePush);
	}
//
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

	// Event Listener on Label[#addPhotoButton].onMouseClicked
//替换照片
	@FXML
	public void addPhoto(MouseEvent event) {
		// TODO Autogenerated

		addPhotoLabel.setTextFill(Color.PURPLE);

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		File file;

		file = fileChooser.showOpenDialog(new Stage());

//		String filePath = "null";
//		if (file == null) {
//			return;
//		}
//		try {
//			filePath = file.getCanonicalPath();
//		} catch (IOException e1) {
//			// TODO 自动生成的 catch 块
//			UIcaller.callImagePushErrorUI();
//		}
//		;
//
//		if (!filePath.equals("null")) {
//			String imgPath = getFolderPath() + "/temp/" + filePath.hashCode() + ".png";
//			ImageZipUtil.zipWidthHeightImageFile(new File(filePath), new File(imgPath), 80, 80, 1.0f);
//			// System.out.println(imgPath);
//			Image imagePush = new Image("file:" + imgPath);
//			custonerImg.setImage(imagePush);
//
//			newCustomerVO.setImagePath(imgPath);
//		}

		String filePath = "null";
		if (file == null) {
			return;
		}
		filePath = file.getAbsolutePath();

		if (filePath!=null) {
			String imgPath = "C://temp//" + filePath.hashCode() + ".png";
			ImageZipUtil.zipWidthHeightImageFile(new File(filePath), new File(imgPath), 80, 80, 1.0f);

			Image imagePush = new Image("file:" + imgPath);
			custonerImg.setImage(imagePush);
			//System.out.println("pres"+imgPath);
			newCustomerVO.setImagePath(imgPath);

		}
	}

	private boolean judgenull() {
		// TODO Auto-generated method stub
		if (customerName.getText().equals("") || levelOfCustomer.getSelectionModel().getSelectedItem()==null ||
			typeOfCustomer.getSelectionModel().getSelectedItem()==null || defaultOperator.getSelectionModel().getSelectedItem()==null
			|| receiveLimit.getText().equals(""))
		return true;
		return false;
	}

	// Event Listener on Button[#confirmButton].onMouseClicked
	//确认编辑，修改客户信息
	@FXML
	public void uploadCustomerInfo(MouseEvent event) throws IOException {
		// TODO Autogenerated
		if (judgenull()){
			QiPaoUI notice = new QiPaoUI();
			notice.showTip(pane, "客户核心信息不能为空！");
		}else{

			newCustomerVO.setAddress(address.getText());
			newCustomerVO.setEmail(email.getText());
			newCustomerVO.setName(customerName.getText());
			newCustomerVO.setPhoneNumber(phone.getText());
			newCustomerVO.setPostcode(postcode.getText());
			newCustomerVO.setReceiveLimit(Double.valueOf(receiveLimit.getText()).doubleValue());
			newCustomerVO.setLevel(typeOfCustomer.getSelectionModel().getSelectedItem().toString());
			newCustomerVO.setType(levelOfCustomer.getSelectionModel().getSelectedItem().toString());
			//newCustomerVO.setDefaultOperatorid(defaultOperator.getSelectionModel().getSelectedItem().toString());

			if (defaultOperator.getSelectionModel().getSelectedItem()!=null){
				for (int i = 0; i < userList.size(); i++) {
					if (userList.get(i).getName().equals(defaultOperator.getSelectionModel().getSelectedItem().toString())) {
						newCustomerVO.setDefaultOperatorid(userList.get(i).getID());
					}
				}
			}

			CustomerBLService customerBlService = new CustomerController();
			customerBlService.modifyCustomer(newCustomerVO);

			EditCustomerUI.thisStage.hide();
			SaleUIController.getSaleUIController().runNewStage("customerButton");

			QiPaoUI notice = new QiPaoUI();
			notice.showTip((Pane)UIController.getUIController().getUIStage().getScene().getRoot(), "修改成功！");
		}
	}

	// Event Listener on Button[#deleteButton].onMouseClicked
	//删除客户信息
	@FXML
	public void deleteCustomer(MouseEvent event) throws IOException {
		CustomerBLService customerBlService = new CustomerController();

		if (newCustomerVO.getPayAmount()!=0 || newCustomerVO.getReceiveAmount()!=0){
			QiPaoUI notice = new QiPaoUI();
			notice.showTip(pane, "客户应收应付不为零，无法删除！");
		}else{
			customerBlService.deleteCustomer(newCustomerVO);

			EditCustomerUI.thisStage.hide();
			SaleUIController.getSaleUIController().runNewStage("customerButton");
			QiPaoUI notice = new QiPaoUI();
			notice.showTip((Pane)UIController.getUIController().getUIStage().getScene().getRoot(), "删除成功！");
		}
		QiPaoUI notice = new QiPaoUI();
		//notice.showTip((Pane)UIController.getUIController().getUIStage().getScene().getRoot(), "删除成功！");
	}

	// Event Listener on Button[#cancelButton].onMouseClicked
	@FXML
	public void closeStage(MouseEvent event) {
		// TODO Autogenerated
		EditCustomerUI.thisStage.hide();
	}

	//增加进出反馈

	@FXML
	public void enterlabel(MouseEvent event) {
		// TODO Autogenerated
		addPhotoLabel.setTextFill(Color.PURPLE);
		addPhotoLabel.setLayoutX(addPhotoLabel.getLayoutX() + 1);
		addPhotoLabel.setLayoutY(addPhotoLabel.getLayoutY() + 1);
	}

	@FXML
	public void exitlabel(MouseEvent event) {
		// TODO Autogenerated
		addPhotoLabel.setTextFill(Color.BLACK);
		addPhotoLabel.setLayoutX(addPhotoLabel.getLayoutX() - 1);
		addPhotoLabel.setLayoutY(addPhotoLabel.getLayoutY() - 1);
	}

	@FXML
	public void enterconfirmButton(MouseEvent event) {
		// TODO Autogenerated
		confirmButton.setLayoutX(confirmButton.getLayoutX() + 1);
		confirmButton.setLayoutY(confirmButton.getLayoutY() + 1);
	}

	@FXML
	public void exitconfirmButton(MouseEvent event) {
		// TODO Autogenerated
		confirmButton.setLayoutX(confirmButton.getLayoutX() - 1);
		confirmButton.setLayoutY(confirmButton.getLayoutY() - 1);
	}

	@FXML
	public void entercancelButton(MouseEvent event) {
		// TODO Autogenerated
		cancelButton.setLayoutX(cancelButton.getLayoutX() + 1);
		cancelButton.setLayoutY(cancelButton.getLayoutY() + 1);
	}

	@FXML
	public void exitcancelButton(MouseEvent event) {
		// TODO Autogenerated
		cancelButton.setLayoutX(cancelButton.getLayoutX() - 1);
		cancelButton.setLayoutY(cancelButton.getLayoutY() - 1);
	}

	@FXML
	public void enterdeleteButton(MouseEvent event) {
		// TODO Autogenerated
		cancelButton.setLayoutX(cancelButton.getLayoutX() + 1);
		cancelButton.setLayoutY(cancelButton.getLayoutY() + 1);
	}

	@FXML
	public void exitdeleteButton(MouseEvent event) {
		// TODO Autogenerated
		deleteButton.setLayoutX(deleteButton.getLayoutX() - 1);
		deleteButton.setLayoutY(deleteButton.getLayoutY() - 1);
	}

}
