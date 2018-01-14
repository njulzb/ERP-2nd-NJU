package presentation.userUI.FinancialManager;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class FinancialReceiptUI {
	private FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReceiptSelect.fxml"));
	//返回单据左侧选择栏
	public AnchorPane receiptSelectUI() throws IOException {
		// TODO Auto-generated method stub
		AnchorPane root = fxmlLoader.load();
		//FinancialLeftSelectUIController LScontroller = fxmlLoader.getController();
		//LScontroller.init();

		return root;
	}
}
