package presentation.userUI.StoreManager;

import java.io.IOException;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.receiptUI.FormMainUI;
import vo.UserVO;

public class StoreReceiptController {
	private UserVO user;

	public void setUser(UserVO user2) {
		// TODO Auto-generated method stub
		this.user=user2;
	}

	//根据选择button跳转不同界面
	public Pane runNewPane(String button) throws IOException {
		Pane receipt=new Pane();
		StoreReceiptUI left= new StoreReceiptUI();
		receipt.getChildren().add(left.receiptSelectUI());

		if (button.equals("alarmForm")){
			FormMainUI ui = new FormMainUI();
			ui.user=this.user;
			ui.formID="BJD";
			ui.makeUI();

			Pane right=ui.root;
			right.setLayoutX(30);
			receipt.getChildren().add(right);
		}
		if (button.equals("lossForm")){
			FormMainUI ui = new FormMainUI();
			ui.user=this.user;
			ui.formID="BSD";
			ui.makeUI();

			Pane right=ui.root;
			right.setLayoutX(30);
			receipt.getChildren().add(right);
		}
		if (button.equals("overflowForm")){
			FormMainUI ui = new FormMainUI();
			ui.user=this.user;
			ui.formID="XYD";
			ui.makeUI();

			Pane right=ui.root;
			right.setLayoutX(30);
			receipt.getChildren().add(right);
		}
		if (button.equals("presentForm")){
			FormMainUI ui = new FormMainUI();
			ui.user=this.user;
			ui.formID="ZSD";
			ui.makeUI();

			Pane right=ui.root;
			right.setLayoutX(30);
			receipt.getChildren().add(right);
		}
		return receipt;
	}
}
