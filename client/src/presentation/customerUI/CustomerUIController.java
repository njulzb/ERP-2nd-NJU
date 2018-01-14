package presentation.customerUI;

import java.io.IOException;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import po.KeyForSearchCustomer;

public class CustomerUIController {
	public AnchorPane getCustomerMainUI(KeyForSearchCustomer key,String mode) throws IOException{
		CustomerMainUI customerPane = new CustomerMainUI();
		customerPane.setKey(key);
		customerPane.setSelect(mode);
		return customerPane.CustomerPane();
	}

	public void runNewCustomerUI() throws Exception{
		NewCustomerUI newCustomerUI = new NewCustomerUI();
		newCustomerUI.start(new Stage());
	}

}
