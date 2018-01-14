package presentation.userUI.StoreManager;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class StoreReceiptUI {
	private FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StoreReceiptSelect.fxml"));
	//返回单据左侧选择栏
	public AnchorPane receiptSelectUI() throws IOException {
		// TODO Auto-generated method stub
		AnchorPane root = fxmlLoader.load();
		//FinancialLeftSelectUIController LScontroller = fxmlLoader.getController();
		//LScontroller.init();

		return root;
	}
}
