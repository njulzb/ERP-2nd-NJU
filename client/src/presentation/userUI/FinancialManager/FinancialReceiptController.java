package presentation.userUI.FinancialManager;

import java.io.IOException;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.receiptUI.FormMainUI;
import vo.UserVO;

public class FinancialReceiptController {
	private UserVO user;

	//根据选择button跳转不同界面
	public Pane runNewPane(String button) throws IOException {
		Pane receipt=new Pane();
		FinancialReceiptUI left= new FinancialReceiptUI();
		receipt.getChildren().add(left.receiptSelectUI());
		if (button.equals("newCashForm")){
			FormMainUI ui = new FormMainUI();
			ui.user=this.user;
			ui.formID="XJFYD";
			ui.makeUI();

			Pane right=ui.root;
			right.setLayoutX(30);
			receipt.getChildren().add(right);
		}
		if (button.equals("receiptForm")){
			FormMainUI ui = new FormMainUI();
			ui.user=this.user;
			ui.formID="SKD";
			ui.makeUI();

			Pane right=ui.root;
			right.setLayoutX(30);
			receipt.getChildren().add(right);
		}
		if (button.equals("payForm")){
			FormMainUI ui = new FormMainUI();
			ui.user=this.user;
			ui.formID="FKD";
			ui.makeUI();

			Pane right=ui.root;
			right.setLayoutX(30);
			receipt.getChildren().add(right);
		}
		return receipt;
	}
	public void setUser(UserVO user){
		this.user=user;
	}
}
