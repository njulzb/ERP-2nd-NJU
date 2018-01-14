package presentation.customerUI;

import java.text.DecimalFormat;

import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import vo.CustomerVO;

public class CustomerInfoUIController {
	@FXML
	private HBox hbox;
	@FXML
	private Label backColor;
	@FXML
	private ImageView Photo;
	@FXML
	private Label Name;
	@FXML
	private Label Phone;
	@FXML
	private Label Address;
	@FXML
	private Label ReceiveLimit;
	@FXML
	private Label ID;
	@FXML
	private Label Postcode;
	@FXML
	private Label Email;
	@FXML
	private Label ReceiveAmount;
	@FXML
	private Label PayAmount;

	private CustomerVO customer = new CustomerVO();

	@FXML
	void setVisable(MouseEvent event){
		backColor.setOpacity(0.81);
	}

	@FXML
	void setUnVisable(MouseEvent event){
		backColor.setOpacity(0.01);
	}

	//跳转生成新修改界面
	@FXML
	void editPane(MouseEvent event) throws Exception{

		EditCustomerUI editcustomer =  new EditCustomerUI();
		editcustomer.setCustomer(customer);
		editcustomer.start(new Stage());
	}

	public void setCustomer(CustomerVO customer){
		this.customer=customer;
	}
//初始化
	void init(){

		Name.setText(customer.getName());
		Phone.setText(customer.getPhoneNumber());
		Address.setText(customer.getAddress());
		ID.setText(customer.getId());
		Postcode.setText(customer.getPostcode());
		Email.setText(customer.getEmail());

		DecimalFormat format=new DecimalFormat("#.00");
		double x=customer.getReceiveLimit();
		ReceiveLimit.setText(format.format(x));
		x=customer.getReceiveAmount();
		ReceiveAmount.setText(format.format(x));
		x=customer.getPayAmount();
		PayAmount.setText(format.format(x));

		String imgPath = customer.getImagePath() ;
		//System.out.println("pres"+imgPath);
		Image imagePush = new Image("file:" + imgPath);
		Photo.setImage(imagePush);

	}
}
