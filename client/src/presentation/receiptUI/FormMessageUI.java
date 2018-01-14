package presentation.receiptUI;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import BL.receiptBL.FormController;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import presentation.littleUI.QiPaoUI;
import presentation.littleUI.TipUI;
import presentation.littleUI.HELP.MyButton;
import utility.RoleOfUser;
import utility.StateOfForm;
import vo.UserVO;
import vo.Form.FormVO;
import vo.Form.FinanceFormVO.PayFormVO;
import vo.Form.stockFormVO.LossFormVO;
import vo.Form.tradeFormVO.PurchaseFormVO;
import vo.Form.tradeFormVO.SaleExportFormVO;

public class FormMessageUI extends Application {

	public boolean editAble = true;
	public boolean HCable = false;
	public FormVO formVO;
	public UserVO user;
	Pane Main;

	public boolean confirm = false;

	private FormHeadPane headPane;
	private ItemsBox ib;
	private FormController controller = new FormController();
	private Stage thisStage;
	private StrategySelectUI straSelector = new StrategySelectUI();
	double xOffset;
	double yOffset;

	@Override
	public void start(Stage stage) {

		thisStage = stage;
		// initTestData();
		Main = new Pane();
		stage.initStyle(StageStyle.TRANSPARENT);// 无边框

		Image image1 = new Image("file:img\\receipt\\Header.png");
		Label label_header = new Label("", new ImageView(image1));
		label_header.setLayoutX(0);
		label_header.setLayoutY(0);
		Main.setStyle("-fx-border-color:  #545454");
		Main.getChildren().add(label_header);

		label_header.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				e.consume();
				xOffset = e.getSceneX();
				yOffset = e.getSceneY();
			}
		});
		label_header.setOnMouseDragged(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				e.consume();
				thisStage.setX(e.getScreenX() - xOffset);
				// 根据自己的需求，做不同的判断
				if (e.getScreenY() - yOffset < 0) {
					thisStage.setY(0);

				} else {
					thisStage.setY(e.getScreenY() - yOffset);
				}

				straSelector.thisStage.setX(thisStage.getX() + 610);
				straSelector.thisStage.setY(thisStage.getY());
			}
		});

		Image imageClose = new Image("file:img\\receipt\\closeIcon.png");
		Label label_Close = new Label("", new ImageView(imageClose));
		label_Close.setLayoutX(570);
		label_Close.setLayoutY(11);
		label_Close.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				exitThis();
			}
		});
		label_Close.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				Label obj = (Label) e.getSource();
				double x = obj.getLayoutX();
				double y = obj.getLayoutY();
				obj.setLayoutX(x + 3);
				obj.setLayoutY(y + 3);
			}
		});
		label_Close.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				Label obj = (Label) e.getSource();
				double x = obj.getLayoutX();
				double y = obj.getLayoutY();
				obj.setLayoutX(x - 3);
				obj.setLayoutY(y - 3);
			}
		});

		Main.getChildren().add(label_Close);

		headPane = new FormHeadPane(formVO, editAble);
		headPane.setLayoutX(30);
		headPane.setLayoutY(50);
		Main.getChildren().add(headPane);

		ib = new ItemsBox(formVO, editAble);
		ib.setLayoutX(30);
		ib.setLayoutY(200);
		Main.getChildren().add(ib);
		createButton();
		SaleForm();
		rejectPart();
		Scene scene = new Scene(Main, 600, 600);
		 stage.initModality(Modality.APPLICATION_MODAL);

		stage.setScene(scene);
		stage.setTitle("form");
		 stage.showAndWait();
//		stage.show();
	}

	private void initTestData() {
		// TODO 自动生成的方法存根
		formVO = new SaleExportFormVO();
		formVO.setID("333333");
		formVO.setState(StateOfForm.admitted);
		formVO.setOperator(new UserVO());

		user = new UserVO();
		user.setID("161250061");

		user.setName("lyb");
		user.setRole(RoleOfUser.GeneralManager);

	}

	public void showTip(String message) {
		try {
			QiPaoUI.showTip(Main, message);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public void createButton() {
		MyButton button_submit = new MyButton("提交", 20, 80);
		button_submit.setOnAction((ActionEvent event) -> {
			ArrayList<String> errrorList = updateMessage();
			if (errrorList.size() != 0) {
				String mes = "不能提交：";
				for (String to : errrorList) {
					mes = mes + to + ";";
				}
				showTip(mes);
			} else {
				// System.out.println("成功提交");
				try {
					controller.submitForm(formVO);
				} catch (RemoteException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				confirm=true;
				exitThis();
			}

		});
		button_submit.setLayoutX(300);
		button_submit.setLayoutY(540);
		Main.getChildren().add(button_submit);

		MyButton button_save = new MyButton("保存", 20, 80);
		button_save.setOnAction((ActionEvent event) -> {
			ArrayList<String> errrorList = updateMessage();
			if (errrorList.size() != 0) {
				String mes = "不能保存：";
				for (String to : errrorList) {
					mes = mes + to + ";";
				}
				showTip(mes);
			} else {
				System.out.println("成功保存" + formVO.getCustomer().getName());
				try {
					if (formVO.getID() != null) {
						controller.editForm(formVO);
					} else {
						controller.addForm(formVO);
					}
					confirm=true;
				} catch (RemoteException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				exitThis();
			}
		});
		button_save.setLayoutX(390);
		button_save.setLayoutY(540);
		Main.getChildren().add(button_save);

		MyButton button_delete = new MyButton("删除", 20, 80);
		button_delete.setOnAction((ActionEvent event) -> {

			TipUI.showConfirmDialog(thisStage, "你确定要删除吗？", "confirm");
			if (TipUI.buttonSelected == TipUI.Response.YES) {
				try {
					if (formVO.getID() != null) {
						controller.deleteForm(formVO.getID());
						confirm=true;
					}

					exitThis();

				} catch (RemoteException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}

		});
		button_delete.setLayoutX(480);
		button_delete.setLayoutY(540);
		Main.getChildren().add(button_delete);

		MyButton button_approve = new MyButton("批准", 20, 80);
		button_approve.setOnAction((ActionEvent event) -> {
			ArrayList<String> errrorList = updateMessage();
			if (errrorList.size() != 0) {
				String mes = "不能批准：";
				for (String to : errrorList) {
					mes = mes + to + ";";
				}
				showTip(mes);
			} else {
				System.out.println("成功批准");
				try {
					controller.passForm(formVO);
					confirm=true;
				} catch (RemoteException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				exitThis();
			}
		});
		button_approve.setLayoutX(390);
		button_approve.setLayoutY(540);
		Main.getChildren().add(button_approve);

		MyButton button_reject = new MyButton("驳回", 20, 80);
		button_reject.setOnAction((ActionEvent event) -> {
			ArrayList<String> errrorList = updateMessage();
			if (errrorList.size() != 0) {
				String mes = "不能駁回：";
				for (String to : errrorList) {
					mes = mes + to + ";";
				}
				showTip(mes);
			} else {
				RejectCommentUI rui = new RejectCommentUI();
				try {
					rui.start(new Stage());
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				if (rui.confirm) {
					formVO.setDeniedComment(rui.comment);
					System.out.println("成功駁回");
					confirm=true;
					exitThis();
					try {
						controller.rejectForm(formVO);
					} catch (RemoteException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				} else {

				}

			}
		});
		button_reject.setLayoutX(480);
		button_reject.setLayoutY(540);
		Main.getChildren().add(button_reject);

		MyButton button_HC = new MyButton("红冲", 20, 80);
		button_HC.setOnAction((ActionEvent event) -> {
			TipUI.showMessageDialog(thisStage, "红冲操作成功！", "HC");
			exitThis();
		});
		button_HC.setLayoutX(480);
		button_HC.setLayoutY(540);
		button_HC.setVisible(HCable);
		Main.getChildren().add(button_HC);

		if (formVO.getState() == StateOfForm.draft) {
			button_submit.setVisible(true);
			button_delete.setVisible(true);
			button_save.setVisible(true);
			button_approve.setVisible(false);
			button_reject.setVisible(false);
		} else if (formVO.getState() == StateOfForm.admitted) {
			if (user.getRole() == RoleOfUser.GeneralManager) {
				button_submit.setVisible(false);
				button_delete.setVisible(false);
				button_save.setVisible(false);
				button_approve.setVisible(true);
				button_reject.setVisible(true);
			} else {
				button_submit.setVisible(false);
				button_delete.setVisible(false);
				button_save.setVisible(false);
				button_approve.setVisible(false);
				button_reject.setVisible(false);
			}
		} else if (formVO.getState() == StateOfForm.rejected) {
			if (user.getRole() == RoleOfUser.GeneralManager) {
				button_submit.setVisible(false);
				button_delete.setVisible(false);
				button_save.setVisible(false);
				button_approve.setVisible(false);
				button_reject.setVisible(false);
			} else {
				button_submit.setVisible(true);
				button_delete.setVisible(true);
				button_save.setVisible(true);
				button_approve.setVisible(false);
				button_reject.setVisible(false);
			}
		} else {
			button_submit.setVisible(false);
			button_delete.setVisible(false);
			button_save.setVisible(false);
			button_approve.setVisible(false);
			button_reject.setVisible(false);
		}
	}

	public void rejectPart() {
		if(formVO.getDeniedComment()!=null&&formVO.getDeniedComment().length()>-1) {
			Label l_comment = new Label("<鼠标移至此，查看驳回意见> ");
			l_comment.setLayoutX(430);
			l_comment.setLayoutY(175);
			Main.getChildren().add(l_comment);
			Tooltip tooltip = new Tooltip(formVO.getDeniedComment());
			tooltip.setFont(new Font("Arial", 16));
			l_comment.setTooltip(tooltip);
		}
		
	
	}
	public void SaleForm() {
		if (!(formVO instanceof SaleExportFormVO)) {
			return;
		}

		straSelector.form = (SaleExportFormVO) formVO;
		straSelector.editAble = this.editAble;
		straSelector.xShould = thisStage.getX() + 610;
		straSelector.yShould = thisStage.getY();
		try {
			straSelector.start(new Stage());
			System.out.println(1121212);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		straSelector.thisStage.hide();

		CheckBox cb_gift = new CheckBox(" 显示销售策略 ");
		cb_gift.setLayoutX(475);
		cb_gift.setLayoutY(175);
		Tooltip tooltip = new Tooltip("点击显示销售策略");
		tooltip.setFont(new Font("Arial", 16));
		cb_gift.setTooltip(tooltip);
		cb_gift.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) {
				if (new_val == true) {
					formVO.setID("ccccccccc");
					straSelector.thisStage.show();
				} else {
					straSelector.thisStage.hide();
					;
				}
			}
		});
		Main.getChildren().add(cb_gift);
	}

	public ArrayList<String> updateMessage() {
		ArrayList<String> out = new ArrayList<String>();

		out.addAll(headPane.updateMessage());
		out.addAll(ib.updateMessage());

		return out;

	}

	public void exitThis() {
		thisStage.hide();
		if (straSelector != null) {
			straSelector.thisStage.hide();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}