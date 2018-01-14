package presentation.userUI.SaleManager;

import java.io.IOException;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.receiptUI.FormMainUI;
import vo.UserVO;


public class SaleReceiptController {
	private UserVO user;

	public void setUser(UserVO user2) {
		// TODO Auto-generated method stub
		this.user=user2;
	}

	//根据选择button跳转不同界面
	public Pane runNewPane(String button) throws IOException {
		Pane receipt=new Pane();
		SaleReceiptUI left= new SaleReceiptUI();
		receipt.getChildren().add(left.receiptSelectUI());

		if (button.equals("purchaseForm")){
			FormMainUI ui = new FormMainUI();
			ui.user=this.user;
			ui.formID="JHD";
			ui.makeUI();

			Pane right=ui.root;
			right.setLayoutX(30);
			receipt.getChildren().add(right);
		}
		if (button.equals("purchaseReturnForm")){
			FormMainUI ui = new FormMainUI();
			ui.user=this.user;
			ui.formID="JHTHD";
			ui.makeUI();

			Pane right=ui.root;
			right.setLayoutX(30);
			receipt.getChildren().add(right);
		}
		if (button.equals("saleSlipForm")){
			FormMainUI ui = new FormMainUI();
			ui.user=this.user;
			ui.formID="XSD";
			ui.makeUI();

			Pane right=ui.root;
			right.setLayoutX(30);
			receipt.getChildren().add(right);
		}
		if (button.equals("saleReturnSlipForm")){
			FormMainUI ui = new FormMainUI();
			ui.user=this.user;
			ui.formID="XSTHD";
			ui.makeUI();

			Pane right=ui.root;
			right.setLayoutX(30);
			receipt.getChildren().add(right);
		}
		return receipt;
	}
}
