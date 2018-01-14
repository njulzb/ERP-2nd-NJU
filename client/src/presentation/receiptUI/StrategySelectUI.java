package presentation.receiptUI;

import java.rmi.RemoteException;
import java.util.ArrayList;
import BL.strategyBL.StrategyController;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import presentation.littleUI.HELP.MyButton;
import vo.Form.tradeFormVO.SaleExportFormVO;
import vo.strategy.StrategyResult;

public class StrategySelectUI extends Application {

	public SaleExportFormVO form;

	public boolean editAble = true;

	public Pane root = new Pane();
	public ScrollPane giftPane = new ScrollPane();
	public Stage thisStage = new Stage();
	public Scene thisScene;

	public double xShould = 0, yShould = 0;

	double xOffset;
	double yOffset;

	public ArrayList<StrategyResult> straList = new ArrayList<StrategyResult>();
	private ScrollPane sp = new ScrollPane();
	ToggleGroup group;
	public double moneyStrategy = 0;
	TextArea ta_comment;
	// public StockFormItemVO item=new StockFormItemVO();
	MouseEvent e;
	public String comment = "";
	public boolean confirm = true;

	public StrategySelectUI() {
		makeUI();
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Stra");
		stage.setIconified(false);
		stage.initStyle(StageStyle.TRANSPARENT);// 无边框
		thisStage = stage;

		Scene scene = new Scene(root, 300, 320);
		thisScene = scene;

		makeStrategyBox();

		// stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(scene);
		stage.setX(xShould);
		stage.setY(xShould);
		// stage.showAndWait();
		stage.show();
	}

	public void makeUI() {
		Image image1 = new Image("file:img\\receipt\\header_strategy.png");
		Label label_header = new Label("", new ImageView(image1));
		label_header.setLayoutX(0);
		label_header.setLayoutY(0);
		root.setStyle("-fx-border-color:  #545454");
		root.getChildren().add(label_header);

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
			}
		});

		Image imageClose = new Image("file:img\\receipt\\closeIcon.png");
		Label label_Close = new Label("", new ImageView(imageClose));
		label_Close.setLayoutX(270);
		label_Close.setLayoutY(4);
		label_Close.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				thisStage.hide();
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

		root.getChildren().add(label_Close);

		Label label_he = new Label("可选策略：");
		label_he.setLayoutX(20);
		label_he.setLayoutY(40);
		root.getChildren().add(label_he);

		if(editAble) {
			MyButton button_submit = new MyButton("刷新可用策略", 25, 120);
			button_submit.setLayoutX(140);
			button_submit.setLayoutY(270);
			button_submit.setOnAction((ActionEvent event) -> {
				makeStrategyBox();

			});
			root.getChildren().add(button_submit);
		}
		
		//
		// MyButton button_back = new MyButton("返回", 20, 60);
		// button_back.setOnAction((ActionEvent event) -> {
		// confirm = false;
		// thisStage.hide();
		// });
		// button_back.setLayoutX(210);
		// button_back.setLayoutY(290);
		// root.getChildren().add(button_back);

	}

	public void initList() {
		StrategyController controller = new StrategyController();

		if (form != null && form.getCustomer() != null && form.getCustomer().getLevel() != null
				&& form.getGoodsList() != null) {
			try {
				straList = controller.calculateResult(form);
			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		} else {
			straList = new ArrayList<StrategyResult>();
		}

	}

	public void makeStrategyBox() {
		if (form != null)
			System.out.println(form.getID());
		straList.clear();
		initList();
		if (sp != null && root.getChildren().contains(sp)) {
			root.getChildren().remove(sp);
		}
		sp = new ScrollPane();

		sp.setPrefSize(250, 170);
		sp.setLayoutX(25);
		sp.setLayoutY(80);
		VBox vb = new VBox();

		sp.setVmax(440);
		sp.setContent(vb);
		root.getChildren().add(sp);

		if (straList == null || straList.size() == 0) {
			Text defaultText = new Text("暂无可用策略");
			defaultText.setFill(Color.GRAY);
			vb.getChildren().add(defaultText);
		} else {
			group = new ToggleGroup();

			RadioButton rb11 = new RadioButton("不适用");
			rb11.setToggleGroup(group);
			// rb11.setSelected(true);
			rb11.setUserData(null);
			vb.getChildren().add(rb11);
			for (StrategyResult sr : straList) {
				if (sr != null && sr.getDescription() != null) {
					RadioButton rb = new RadioButton("  " + sr.getDescription());
					rb.setToggleGroup(group);
					rb.setUserData(straList.indexOf(sr));
					vb.getChildren().add(rb);
				}
			}

			// 选中某个单选框时输出选中的值
			group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
				public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
					if (group.getSelectedToggle() != null) {

						System.out.println(group.getSelectedToggle().getUserData());
					}
				}
			});
		}

	}

	public StrategyResult getStra() {
		if(group==null) {
			return null;
		}
		return (StrategyResult) group.getSelectedToggle().getUserData();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
