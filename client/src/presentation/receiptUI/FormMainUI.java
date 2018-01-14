package presentation.receiptUI;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import BL.customerBL.CustomerController;
import BL.receiptBL.FormController;
import BL.receiptBL.FormFactory;
import BL.userBL.User;
import BLService.receiptBLService.FormBLService;
import BLService.receiptBLService.cashFormBLService;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import po.KeyForSearchForm;
import presentation.littleUI.QiPaoUI;
import presentation.littleUI.TipUI;
import presentation.littleUI.HELP.MyButton;
import presentation.receiptUI.FormMessageUI;
import utility.RoleOfUser;
import utility.StateOfForm;
import vo.UserVO;
import vo.Form.FormVO;
import vo.Form.FinanceFormVO.CashFormVO;
import vo.Form.FinanceFormVO.FinanceFormVO;

public class FormMainUI extends Application {

	public String formID = "";
	public UserVO user;

	private ArrayList<FormVO> formList = new ArrayList<FormVO>();
	private FormController controller = new FormController();
	private KeyForSearchForm TheKey = new KeyForSearchForm();
	private Stage thisStage;
	public Pane root = new Pane(), StateSelectPane, StateHighLightPane;
	private MyButton button_new, button_submit, button_delete, button_approve, button_reject;
	private Label label_draftNum, label_submitNum, label_rejectNum, label_passNum;
	ScrollPane FormsPane;
	private ArrayList<FormItemPane> formItemList = new ArrayList<FormItemPane>();
	private StateOfForm nowState;

	protected String Path;
	protected FormMainUI me = this;

	public FormMainUI() {
	}

	public void initTestData() {
		formID = "SKD";
		user = new User("161250061", "lyb", "123456", RoleOfUser.FinancialManager).toVO();
		// user.setRole(RoleOfUser.GeneralManager);
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		thisStage = primaryStage;
		makeUI();
		Scene scene = new Scene(root, 600, 600);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void makeUI() {
		if (user != null && user.getRole() != RoleOfUser.GeneralManager) {

		}
		// initTestData();
		TheKey.setID(formID);
		makeButton();
		makeStateSelectUI();
		makeItemArea();
		updateNum();

	}

	private void makeStateSelectUI() {
		Text title = new Text();
		title.setText(FormFactory.getTitle(formID));
		title.setFont(new Font(30));
		title.setLayoutX(30);
		title.setLayoutY(60);
		root.getChildren().add(title);

		StateSelectPane = new Pane();
		StateSelectPane.setPrefSize(540, 60);
		StateSelectPane.setLayoutX(30);
		StateSelectPane.setLayoutY(80);
		root.getChildren().add(StateSelectPane);
		StateSelectPane.setBackground(new Background(new BackgroundFill(Color.rgb(91, 91, 91), null, null)));

		StateHighLightPane = new Pane();

		StateHighLightPane.setPrefSize(180, 60);
		StateHighLightPane.setLayoutX(360);
		StateHighLightPane.setOpacity(0.5);
		StateHighLightPane.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), null, null)));
		StateSelectPane.getChildren().add(StateHighLightPane);

		if (user != null && user.getRole() == RoleOfUser.GeneralManager) {
			StateSelectPane.setOnMousePressed(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent e) {
					if (e.getX() < 180) {
						StateHighLightPane.setLayoutX(0);
						makeStateUI(StateOfForm.admitted);
					} else if (e.getX() > 360) {
						StateHighLightPane.setLayoutX(360);
						makeStateUI(StateOfForm.pass);
					} else if (e.getX() < 360 && e.getX() > 180) {
						StateHighLightPane.setLayoutX(180);
						makeStateUI(StateOfForm.rejected);
					} else {

					}
				}
			});

			Line line1 = new Line();
			line1.setStroke(Color.WHITE);
			line1.setStartX(180);
			line1.setStartY(1);
			line1.setEndX(180);
			line1.setEndY(59);
			line1.setStrokeWidth(0.9);
			StateSelectPane.getChildren().add(line1);

			Line line2 = new Line();
			line2.setStroke(Color.WHITE);
			line2.setStartX(360);
			line2.setStartY(1);
			line2.setEndX(360);
			line2.setEndY(59);
			line2.setStrokeWidth(0.9);
			StateSelectPane.getChildren().add(line2);

			label_submitNum = new Label("待 审 批\n" + 0);
			label_submitNum.setAlignment(Pos.CENTER);
			label_submitNum.setTextAlignment(TextAlignment.CENTER);
			label_submitNum.setTextFill(Color.WHITE);
			label_submitNum.setLayoutX(70);
			label_submitNum.setLayoutY(14);
			StateSelectPane.getChildren().add(label_submitNum);

			label_rejectNum = new Label("已 驳 回\n" + 0);
			label_rejectNum.setAlignment(Pos.CENTER);
			label_rejectNum.setTextAlignment(TextAlignment.CENTER);
			label_rejectNum.setTextFill(Color.WHITE);
			label_rejectNum.setLayoutX(250);
			label_rejectNum.setLayoutY(14);
			StateSelectPane.getChildren().add(label_rejectNum);

			label_rejectNum = new Label("已 通 过\n" + 0);
			label_rejectNum.setAlignment(Pos.CENTER);
			label_rejectNum.setTextAlignment(TextAlignment.CENTER);
			label_rejectNum.setTextFill(Color.WHITE);
			label_rejectNum.setLayoutX(430);
			label_rejectNum.setLayoutY(14);
			StateSelectPane.getChildren().add(label_rejectNum);

		} else {
			StateHighLightPane.setPrefSize(135, 60);
			StateHighLightPane.setLayoutX(405);
			StateSelectPane.setOnMousePressed(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent e) {
					updateNum();
					if (e.getX() < 135) {
						StateHighLightPane.setLayoutX(0);
						makeStateUI(StateOfForm.draft);
					} else if (e.getX() < 270 && e.getX() > 135) {
						StateHighLightPane.setLayoutX(135);
						makeStateUI(StateOfForm.admitted);
					} else if (e.getX() < 405 && e.getX() > 270) {
						StateHighLightPane.setLayoutX(270);
						makeStateUI(StateOfForm.rejected);
					} else if (e.getX() > 405) {
						StateHighLightPane.setLayoutX(405);
						makeStateUI(StateOfForm.pass);
					} else {

					}
				}
			});

			Line line1 = new Line();
			line1.setStroke(Color.WHITE);
			line1.setStartX(135);
			line1.setStartY(1);
			line1.setEndX(135);
			line1.setEndY(59);
			line1.setStrokeWidth(0.9);
			StateSelectPane.getChildren().add(line1);

			Line line2 = new Line();
			line2.setStroke(Color.WHITE);
			line2.setStartX(270);
			line2.setStartY(1);
			line2.setEndX(270);
			line2.setEndY(59);
			line2.setStrokeWidth(0.9);
			StateSelectPane.getChildren().add(line2);

			Line line3 = new Line();
			line3.setStroke(Color.WHITE);
			line3.setStartX(405);
			line3.setStartY(1);
			line3.setEndX(405);
			line3.setEndY(59);
			line3.setStrokeWidth(0.9);
			StateSelectPane.getChildren().add(line3);

			label_draftNum = new Label("草  稿\n" + 0);
			label_draftNum.setAlignment(Pos.CENTER);
			label_draftNum.setTextAlignment(TextAlignment.CENTER);
			label_draftNum.setTextFill(Color.WHITE);
			label_draftNum.setLayoutX(50);
			label_draftNum.setLayoutY(14);
			StateSelectPane.getChildren().add(label_draftNum);

			label_submitNum = new Label("待 审 批\n" + 0);
			label_submitNum.setAlignment(Pos.CENTER);
			label_submitNum.setTextAlignment(TextAlignment.CENTER);
			label_submitNum.setTextFill(Color.WHITE);
			label_submitNum.setLayoutX(185);
			label_submitNum.setLayoutY(14);
			StateSelectPane.getChildren().add(label_submitNum);

			label_rejectNum = new Label("已 驳 回\n" + 0);
			label_rejectNum.setAlignment(Pos.CENTER);
			label_rejectNum.setTextAlignment(TextAlignment.CENTER);
			label_rejectNum.setTextFill(Color.WHITE);
			label_rejectNum.setLayoutX(320);
			label_rejectNum.setLayoutY(14);
			StateSelectPane.getChildren().add(label_rejectNum);

			label_passNum = new Label("已 通 过\n" + 0);
			label_passNum.setAlignment(Pos.CENTER);
			label_passNum.setTextAlignment(TextAlignment.CENTER);
			label_passNum.setTextFill(Color.WHITE);
			label_passNum.setLayoutX(455);
			label_passNum.setLayoutY(14);
			StateSelectPane.getChildren().add(label_passNum);

		}

	}

	private void makeItemArea() {
		Image image3 = new Image("file:img//receipt//FormHead.png");
		Label label_fh = new Label("", new ImageView(image3));
		label_fh.setLayoutX(30);
		label_fh.setLayoutY(150);
		root.getChildren().add(label_fh);

		makeStateUI(StateOfForm.pass);
	}

	private void makeButton() {
		Pane buttonPane = new Pane();
		buttonPane.setLayoutX(0);
		buttonPane.setLayoutY(550);
		root.getChildren().add(buttonPane);

		//

		button_new = new MyButton("新建", 20, 80);
		button_new.setOnAction((ActionEvent event) -> {
			FormVO vo = FormFactory.createEmptyVO(formID);
			vo.setOperator(user);
			FormMessageUI u = new FormMessageUI();

			u.formVO = vo;
			u.editAble = true;
			u.user = user;

			u.start(new Stage());
			if (u.confirm) {
				showTip("操作成功！");
				makeStateUI(StateOfForm.draft);
				updateNum();
			}

			// System.out.println(11);

		});
		button_new.setLayoutX(300);
		buttonPane.getChildren().add(button_new);

		button_submit = new MyButton("提交", 20, 80);
		button_submit.setOnAction((ActionEvent event) -> {
			ArrayList<FormItemPane> select = new ArrayList<FormItemPane>();

			for (FormItemPane fb : formItemList) {
				if (fb.cb.isSelected()) {
					select.add(fb);
				}
			}
			if (select.size() == 0) {
				try {
					QiPaoUI.showTip(root, "您未选中任何单据");
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			} else {
				TipUI.showConfirmDialog(thisStage, "你确定要提交这" + select.size() + "条吗？", "confirm");

				if (TipUI.buttonSelected == TipUI.Response.YES) {
					try {
						for (FormItemPane fb : select) {
							controller.submitForm(fb.vo);
						}
						makeStateUI(nowState);
						showTip("成功提交" + select.size() + "条单据");
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
			}
			updateNum();

		});
		button_submit.setLayoutX(390);
		buttonPane.getChildren().add(button_submit);

		button_delete = new MyButton("删除", 20, 80);
		button_delete.setOnAction((ActionEvent event) -> {
			ArrayList<FormItemPane> select = new ArrayList<FormItemPane>();

			for (FormItemPane fb : formItemList) {
				if (fb.cb.isSelected()) {
					select.add(fb);
				}
			}
			if (select.size() == 0) {
				try {
					QiPaoUI.showTip(root, "您未选中任何单据");
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			} else {
				TipUI.showConfirmDialog(thisStage, "你确定要删除这" + select.size() + "条吗？", "confirm");

				if (TipUI.buttonSelected == TipUI.Response.YES) {
					try {
						for (FormItemPane fb : select) {
							controller.deleteForm(fb.vo.getID());
						}
						makeStateUI(nowState);
						QiPaoUI.showTip(root, "成功删除" + select.size() + "条单据");
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
			}
			updateNum();
		});
		button_delete.setLayoutX(480);
		buttonPane.getChildren().add(button_delete);

		button_approve = new MyButton("批准", 20, 80);
		button_approve.setOnAction((ActionEvent event) -> {
			ArrayList<FormItemPane> select = new ArrayList<FormItemPane>();

			for (FormItemPane fb : formItemList) {
				if (fb.cb.isSelected()) {
					select.add(fb);
				}
			}
			if (select.size() == 0) {
				try {
					QiPaoUI.showTip(root, "您未选中任何单据");
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			} else {
				TipUI.showConfirmDialog(thisStage, "你确定要通过这" + select.size() + "条吗？", "confirm");

				if (TipUI.buttonSelected == TipUI.Response.YES) {
					try {
						for (FormItemPane fb : select) {
							controller.passForm(fb.vo);
						}
						makeStateUI(nowState);
						QiPaoUI.showTip(root, "成功通过" + select.size() + "条单据");
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
			}
			updateNum();
		});
		button_approve.setLayoutX(390);
		buttonPane.getChildren().add(button_approve);

		button_reject = new MyButton("驳回", 20, 80);
		button_reject.setOnAction((ActionEvent event) -> {
			updateNum();
		});
		button_reject.setLayoutX(480);
		buttonPane.getChildren().add(button_reject);
		button_new.setVisible(false);
		button_delete.setVisible(false);
		button_submit.setVisible(false);
		button_approve.setVisible(false);
		button_reject.setVisible(false);
	}

	private void makeStateUI(StateOfForm s) {
		nowState = s;
		TheKey.setState(s);
		initList();
		if (root.getChildren().contains(FormsPane)) {
			root.getChildren().remove(FormsPane);
			formItemList.clear();
		}

		FormsPane = new ScrollPane();
		FormsPane.setLayoutX(30);
		FormsPane.setLayoutY(180);
		FormsPane.setMinWidth(540);
		FormsPane.setMaxWidth(540);
		FormsPane.setMinHeight(300);
		FormsPane.setMaxHeight(300);
		VBox vb = new VBox();

		FormsPane.setVmax(440);
		FormsPane.setPrefSize(115, 150);
		FormsPane.setContent(vb);
		root.getChildren().add(FormsPane);

		for (FormVO vo : formList) {
			FormItemPane fip = new FormItemPane(vo);
			fip.setOnMousePressed(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent e) {
					FormMessageUI ui = new FormMessageUI();
					ui.user = user;
					ui.editAble = false;
					if (user.getRole() == RoleOfUser.GeneralManager) {
						if (vo.getState() == StateOfForm.admitted) {
							ui.editAble = true;
						}
					} else {
						if (vo.getState() == StateOfForm.draft || vo.getState() == StateOfForm.rejected) {
							ui.editAble = true;
						}
					}

					ui.formVO = vo;
					ui.start(new Stage());
					
					if (ui.confirm) {
						showTip("操作成功！");
						makeStateUI(StateOfForm.draft);
						updateNum();
					}
				}
			});
			formItemList.add(fip);
			vb.getChildren().add(fip);
		}
		showButton(s);
	}

	private void showButton(StateOfForm state) {
		if (button_new == null) {
			return;
		}
		button_new.setVisible(false);
		button_delete.setVisible(false);
		button_submit.setVisible(false);
		button_approve.setVisible(false);
		button_reject.setVisible(false);

		if (state == StateOfForm.draft) {
			button_new.setVisible(true);
			button_delete.setVisible(true);
			button_submit.setVisible(true);

		} else if (state == StateOfForm.admitted) {
			if (user.getRole() == RoleOfUser.GeneralManager) {

				button_approve.setVisible(true);
				button_reject.setVisible(true);
			} else {

			}
		} else if (state == StateOfForm.rejected) {
			if (user.getRole() == RoleOfUser.GeneralManager) {

			} else {
				button_delete.setVisible(true);
				button_submit.setVisible(true);
			}
		} else {

		}
	}

	private void updateNum() {
		
		if(user!=null&&user.getRole()==RoleOfUser.GeneralManager) {
			if (label_draftNum != null) {
				label_draftNum.setText("草稿");
			}
			if (label_submitNum != null) {
				label_submitNum.setText("提交");
			}
			if (label_rejectNum != null) {
				label_rejectNum.setText("拒绝");
			}
			if (label_passNum != null) {
				label_passNum.setText("通过");
			}
			return ;
		}
		else {
			if (label_draftNum != null) {
				label_draftNum.setVisible(true);
			}
			if (label_submitNum != null) {
				label_submitNum.setVisible(true);
			}
			if (label_rejectNum != null) {
				label_rejectNum.setVisible(true);
			}
			if (label_passNum != null) {
				label_passNum.setVisible(true);
			}
			
		}
		try {
			
			
			
			
			
			KeyForSearchForm key = new KeyForSearchForm();
			key.setID(formID);
			key.setOperatorID(user.getID());
			key.setState(StateOfForm.draft);
			int num = 0;
			num = controller.searchForm(key).size();
			if (label_draftNum != null) {
				label_draftNum.setText("草  稿\n" + num);
			}
			key.setState(StateOfForm.admitted);
			num = controller.searchForm(key).size();
			if (label_submitNum != null) {
				label_submitNum.setText("待审核\n" + num);
			}
			key.setState(StateOfForm.rejected);
			num = controller.searchForm(key).size();
			if (label_rejectNum != null) {
				label_rejectNum.setText("已驳回\n" );
			}
			key.setState(StateOfForm.pass);
			num = controller.searchForm(key).size();
			if (label_passNum != null) {
				label_passNum.setText("已通过\n" + num);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

	private void showTip(String message) {
		try {
			QiPaoUI.showTip(root, message);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	private void initList() {

		if (user.getRole() != RoleOfUser.GeneralManager) {
			TheKey.setOperatorID(user.getID());
		} else {
			TheKey.setID("ALL");
		}

		try {
			formList = controller.searchForm(TheKey);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
