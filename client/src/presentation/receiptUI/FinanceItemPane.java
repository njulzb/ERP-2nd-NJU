package presentation.receiptUI;

import java.util.ArrayList;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import presentation.littleUI.HELP.AccountSelectPane;
import presentation.littleUI.HELP.LengthLimitTextField;
import presentation.littleUI.HELP.OnlyDoubleTextField;
import presentation.littleUI.HELP.OnlyIntTextField;
import utility.SYSNUM;
import vo.Form.FinanceFormVO.TransItemVO;

public class FinanceItemPane extends ItemPane {

	public boolean editAble = false;
	public TransItemVO item;

	private FinanceItemPane me = this;
	private OnlyIntTextField tf_num;
	private OnlyDoubleTextField tf_money;
	private Label label_itemSum;
	AccountSelectPane accSelector;
	private DoubleProperty moneyOne = new SimpleDoubleProperty(0);
	private IntegerProperty num = new SimpleIntegerProperty(0);
	private LengthLimitTextField tf_comment;

	public FinanceItemPane(TransItemVO item, boolean editAble) {
		this.item = item;
		this.editAble = editAble;
		make();
	}

	public void make() {
		me.setPrefHeight(30);
		me.setPrefWidth(540);
	
		
		Line line1 = new Line();
		line1.setStartX(0);
		line1.setStartY(1);
		line1.setEndX(540);
		line1.setEndY(1);
		line1.setStrokeWidth(0.1);
		me.getChildren().add(line1);

		TransItemVO vo = (TransItemVO) item;

		if (editAble) {
			accSelector = new AccountSelectPane();
			accSelector.setLayoutX(40);
			accSelector.setLayoutY(3);
			if (item.getBankAccount() != null) {
				accSelector.setAccount(item.getBankAccount());
			}
			me.getChildren().add(accSelector);

			tf_money = new OnlyDoubleTextField(vo.getMoney() + "");
			tf_money.setLayoutX(190);
			tf_money.setPrefWidth(70);
			tf_money.setLayoutY(5);
			me.getChildren().add(tf_money);
			createCommitBinding(tf_money).addListener((obs, oldText, newText) -> updateMessage());

			if (vo.getComments() == null) {
				vo.setComments("");
			}
			tf_comment = new LengthLimitTextField(vo.getComments(), SYSNUM.getCommentLengthLimit());
			tf_comment.setLayoutX(300);
			tf_comment.setPrefWidth(200);
			tf_comment.setLayoutY(5);
			me.getChildren().add(tf_comment);
		} else {
			Label label_account = new Label("" + vo.getBankAccount().getName());
			label_account.setFont(new Font(12));
			label_account.setLayoutX(40);
			label_account.setLayoutY(3);
			me.getChildren().add(label_account);

			Label l_money = new Label(vo.getMoney() + "");
			l_money.setLayoutX(190);
			l_money.setLayoutY(5);
			me.getChildren().add(l_money);
			
			Label l_comment = new Label(vo.getComments() + "");
			l_comment.setLayoutX(300);
			l_comment.setLayoutY(5);
			me.getChildren().add(l_comment);
		}

	}

	public void remake() {
		me.getChildren().removeAll(me.getChildren());
		make();
	}

	private StringBinding createCommitBinding(TextField textField) {
		StringBinding binding = Bindings.createStringBinding(() -> textField.getText());

		textField.addEventHandler(ActionEvent.ACTION, evt -> binding.invalidate());

		textField.focusedProperty().addListener((obs, wasFocused, isFocused) -> {
			if (!isFocused)
				binding.invalidate();
		});
		return binding;
	}

	public ArrayList<String> updateMessage() {

		ArrayList<String> out = new ArrayList<String>();
		if (accSelector.getAccount() == null) {
			out.add("第" + getNo() + "条中账户不能为空");
		} else {

			if (tf_money != null) {
				item.setMoney(tf_money.value);

			}
			item.setComments(tf_comment.getText());
			item.setBankAccount(accSelector.getAccount());
		}
		return out;

	}
}
