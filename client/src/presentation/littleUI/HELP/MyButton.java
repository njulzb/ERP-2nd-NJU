package presentation.littleUI.HELP;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class MyButton extends Button {
	private MyButton me = this;

	public MyButton() {

	}

	public MyButton(String imagePath) {

	}

	public MyButton(String title, int h, int w) {
		this.setText(title);
		this.setTextFill(Color.rgb(238, 238, 238));
		this.setPrefWidth(w);
		this.setPrefHeight(h);
		this.setTextAlignment(TextAlignment.CENTER);
		this.setStyle("-fx-background-color : #333333");
		// this.setBackground(new Background(new BackgroundFill(Color.rgb(51, 51, 51),
		// null, null)));
		this.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				me.setStyle("-fx-background-color : #666666");
			}
		});
		this.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				me.setStyle("-fx-background-color : #333333");
			}
		});
		this.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				me.setLayoutX(me.getLayoutX()-2);
				me.setLayoutY(me.getLayoutY()-2);
			}
		});
		this.setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				me.setLayoutX(me.getLayoutX()+2);
				me.setLayoutY(me.getLayoutY()+2);
			}
		});
	}
}
