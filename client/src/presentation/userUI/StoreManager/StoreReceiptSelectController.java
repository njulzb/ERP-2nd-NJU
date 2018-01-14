package presentation.userUI.StoreManager;

import java.io.IOException;

import javafx.fxml.FXML;

import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;

public class StoreReceiptSelectController {
	@FXML
	private Label alarmForm;
	@FXML
	private Label lossForm;
	@FXML
	private Label overflowForm;
	@FXML
	private Label presentForm;


	// Event Listener on Label[#newCashForm].onMouseClicked
	@FXML
	public void toalarmForm(MouseEvent event) throws IOException {
		// TODO Autogenerated
		StoreUIController.getStoreUIController().runNewStage("receiptButton", "alarmForm");
	}
	// Event Listener on Label[#receiptForm].onMouseClicked
	@FXML
	public void tolossForm(MouseEvent event) throws IOException {
		// TODO Autogenerated
		StoreUIController.getStoreUIController().runNewStage("receiptButton", "lossForm");
	}
	// Event Listener on Label[#payForm].onMouseClicked
	@FXML
	public void tooverflowForm(MouseEvent event) throws IOException {
		// TODO Autogenerated
		StoreUIController.getStoreUIController().runNewStage("receiptButton", "overflowForm");
	}
	@FXML
	public void topresentForm(MouseEvent event) throws IOException {
		// TODO Autogenerated
		StoreUIController.getStoreUIController().runNewStage("receiptButton", "presentForm");
	}
}
