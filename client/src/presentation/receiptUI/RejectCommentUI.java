package presentation.receiptUI;

import java.io.File;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import presentation.littleUI.HELP.MyButton;
import vo.Form.tradeFormVO.TradeItemVO;

public class RejectCommentUI extends Application {
	public Pane root = new Pane();
	public ScrollPane giftPane = new ScrollPane();
	public Stage thisStage = new Stage();
	public Scene thisScene;
	double xOffset;
	double yOffset;
	public ArrayList<TradeItemVO> giftList = new ArrayList<TradeItemVO>();
	public double moneyStrategy = 0;
	TextArea ta_comment;
	// public StockFormItemVO item=new StockFormItemVO();
	MouseEvent e;

	public String comment = "";
	public boolean confirm = true;

	public RejectCommentUI() {

		makeUI();
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Error");
		stage.setIconified(false);
		stage.initStyle(StageStyle.TRANSPARENT);// 无边框
		thisStage = stage;

		Scene scene = new Scene(root, 400, 320);
		thisScene = scene;

		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(scene);
		stage.showAndWait();
		// stage.show();
	}

	public void makeUI() {
		Image image1 = new Image("file:img\\receipt\\header_comment.png");
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
		label_Close.setLayoutX(370);
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

		Label label_he = new Label("驳回意见：");
		label_he.setLayoutX(20);
		label_he.setLayoutY(40);
		root.getChildren().add(label_he);

		ta_comment = new TextArea();
		ta_comment.setLayoutX(30);
		ta_comment.setLayoutY(65);
		ta_comment.setPrefSize(340, 140);

		root.getChildren().add(ta_comment);

		Label label_quick = new Label("快速选择：");
		label_quick.setLayoutX(20);
		label_quick.setLayoutY(220);
		root.getChildren().add(label_quick);

		CheckBox cb_1 = new CheckBox("单价不合理");
		cb_1.setLayoutX(20);
		cb_1.setLayoutY(250);
		cb_1.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) {
				if (new_val) {
					ta_comment.appendText("单价不合理;\n");
				} else {
					String a = ta_comment.getText().replaceAll("单价不合理;\n", "");
					String b = a.replaceAll("单价不合理;", "");
					ta_comment.setText(b);
				}
			}
		});
		root.getChildren().add(cb_1);
		CheckBox cb_2 = new CheckBox("库存问题暂不通过");
		cb_2.setLayoutX(120);
		cb_2.setLayoutY(250);
		cb_2.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) {
				if (new_val) {
					ta_comment.appendText("库存问题暂不通过;\n");
				} else {
					String a = ta_comment.getText().replaceAll("库存问题暂不通过;\n", "");
					String b = a.replaceAll("库存问题暂不通过;", "");
					ta_comment.setText(b);
				}
			}
		});
		root.getChildren().add(cb_2);
		CheckBox cb_3 = new CheckBox("仍需研究");
		cb_3.setLayoutX(250);
		cb_3.setLayoutY(250);
		cb_3.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) {
				if (new_val) {
					ta_comment.appendText("仍需研究;\n");
				} else {
					String a = ta_comment.getText().replaceAll("仍需研究;\n", "");
					String b = a.replaceAll("仍需研究;", "");
					ta_comment.setText(b);
				}
			}
		});
		root.getChildren().add(cb_3);

		MyButton button_submit = new MyButton("提交", 20, 80);
		button_submit.setLayoutX(200);
		button_submit.setLayoutY(290);
		button_submit.setOnAction((ActionEvent event) -> {
			if (ta_comment.getText() != null) {
				comment = ta_comment.getText();
			}
			confirm = true;
			thisStage.hide();
		});
		root.getChildren().add(button_submit);

		MyButton button_back = new MyButton("返回", 20, 80);
		button_back.setOnAction((ActionEvent event) -> {
			confirm = false;
			thisStage.hide();
		});
		button_back.setLayoutX(290);
		button_back.setLayoutY(290);
		root.getChildren().add(button_back);

	}

	public static void main(String[] args) {
		launch(args);
	}

}
