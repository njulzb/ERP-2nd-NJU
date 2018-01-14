package presentation.customerUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import vo.CustomerVO;

public class EditCustomerUI extends Application {

	private CustomerVO customer = new CustomerVO();
	public static Stage thisStage =new Stage();

	//新建窗口显示修改客户信息
	@Override
	public void start(Stage stage) throws Exception {
		thisStage =stage;
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditCustomerUI.fxml"));
		Pane pane = fxmlLoader.load();
		Scene scene = new Scene(pane, 502, 486);
		stage.setScene(scene);
		EditCustomerUIController editUIcontroller = fxmlLoader.getController();
		editUIcontroller.init(customer);
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.showAndWait();
	}

	public void setCustomer(CustomerVO customer){
		this.customer=customer;
	}

}
