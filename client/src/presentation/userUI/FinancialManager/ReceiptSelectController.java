package presentation.userUI.FinancialManager;

import java.io.IOException;

import javafx.fxml.FXML;

import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;

public class ReceiptSelectController {
	@FXML
	private Label newCashForm;
	@FXML
	private Label receiptForm;
	@FXML
	private Label payForm;

	// Event Listener on Label[#newCashForm].onMouseClicked
	@FXML
	public void toNewCashForm(MouseEvent event) throws IOException {
		// TODO Autogenerated
		FinancialUIController.getFinancialUIController().runNewStage("receiptButton", "newCashForm");
	}
	// Event Listener on Label[#receiptForm].onMouseClicked
	@FXML
	public void toReceiptForm(MouseEvent event) throws IOException {
		// TODO Autogenerated
		FinancialUIController.getFinancialUIController().runNewStage("receiptButton", "receiptForm");
	}
	// Event Listener on Label[#payForm].onMouseClicked
	@FXML
	public void toPayForm(MouseEvent event) throws IOException {
		// TODO Autogenerated
		FinancialUIController.getFinancialUIController().runNewStage("receiptButton", "payForm");
	}
}