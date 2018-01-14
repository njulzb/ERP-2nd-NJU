package presentation.receiptUI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import utility.StateOfForm;
import vo.Form.FormVO;

public class FormItemPane extends Pane {
	private FormItemPane me = this;
	public FormVO vo;
	public CheckBox cb;

	public FormItemPane(FormVO vo) {
		this.vo = vo;
		make();

	}

	public void make() {
		String id = "---";
		String time = "---";
		String operator = "---";

		
		this.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				Pane obj = (Pane) e.getSource();
				obj.setBackground(new Background(new BackgroundFill(Color.BISQUE, null, null)));
			}
		});
		this.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				Pane obj = (Pane) e.getSource();
				obj.setBackground(null);
			}
		});
		
		
		
		
		
		
		
		if (vo != null) {
			if (vo.getID() != null) {
				id = vo.getID();
			}
			if (vo.getOperator() != null) {
				operator = vo.getOperator().getName();
			}
			if (vo.getState() != null && vo.getState() == StateOfForm.draft) {
				if (vo.getCreateTime() != null) {
					time = vo.getCreateTime().toString();
				}
			} else if (vo.getState() != null && vo.getState() == StateOfForm.admitted) {
				if (vo.getSubmitTime() != null) {
					time = vo.getSubmitTime().toString();
				}
			} else if (vo.getState() != null && vo.getState() == StateOfForm.rejected) {
				if (vo.getRejectTime() != null) {
					time = vo.getRejectTime().toString();
				}
			} else if (vo.getState() != null && vo.getState() == StateOfForm.pass) {
				if (vo.getPassTime() != null) {
					time = vo.getPassTime().toString();
				}
			}
		}

		this.setPrefWidth(540);
		this.setPrefHeight(30);

		cb = new CheckBox("");
		cb.setLayoutX(0);
		cb.setLayoutY(4);
		Tooltip tooltip = new Tooltip("  ");
		tooltip.setFont(new Font("Arial", 16));
		cb.setTooltip(tooltip);
		me.getChildren().add(cb);

		Font tfont = new Font(12);
		Label label_id = new Label(id);
		label_id.setFont(tfont);
		label_id.setLayoutX(25);
		label_id.setLayoutY(5);
		me.getChildren().add(label_id);

		Label label_time = new Label(time);
		label_time.setFont(tfont);
		label_time.setLayoutX(180);
		label_time.setLayoutY(5);
		me.getChildren().add(label_time);

		Label label_operator = new Label(operator);
		label_operator.setFont(tfont);
		label_operator.setLayoutX(400);
		label_operator.setLayoutY(5);
		me.getChildren().add(label_operator);

	}
}
