package presentation.customerUI;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import vo.CustomerVO;

public class CustomerInfoUI {
	CustomerInfoUIController customerInfoUIController;

	//返回单个指定客户信息条目
	public AnchorPane InfoPane(CustomerVO customer) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CustomerInfoUI.fxml"));
		AnchorPane pane =fxmlLoader.load();
		customerInfoUIController=fxmlLoader.getController();
		customerInfoUIController.setCustomer(customer);
		customerInfoUIController.init();
		//Scene scene = new Scene(curr,800,600);

		return pane;
	}
}
