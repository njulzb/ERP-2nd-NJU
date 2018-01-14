package presentation.littleUI;

import javafx.fxml.FXML;

import javafx.scene.control.Label;

public class QiPaoViewController {
	@FXML
	private Label text_message;
	public void init(String message) {
		text_message.setText(message);
	}
}
