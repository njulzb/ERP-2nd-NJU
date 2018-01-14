package presentation.userUI.SaleManager;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class SaleReceiptUI {
	private FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SaleReceiptSelect.fxml"));
	//返回单据左侧选择栏
	public AnchorPane receiptSelectUI() throws IOException {
		// TODO Auto-generated method stub
		AnchorPane root = fxmlLoader.load();
		//FinancialLeftSelectUIController LScontroller = fxmlLoader.getController();
		//LScontroller.init();

		return root;
	}
}
