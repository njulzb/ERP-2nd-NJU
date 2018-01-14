package presentation.stockUI.GoodsManage;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import BL.stockBL.StockController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import presentation.littleUI.QiPaoUI;
import presentation.littleUI.TipUI;
import presentation.littleUI.HELP.LengthLimitTextField;
import presentation.littleUI.HELP.MyButton;
import presentation.littleUI.HELP.OnlyDoubleTextField;
import presentation.littleUI.HELP.OnlyIntTextField;
import utility.ImageZipUtil;
import vo.Form.tradeFormVO.TradeItemVO;
import vo.goods.GoodsVO;

public class GoodsMessageUI extends Application {
	public Pane root = new Pane();
	public ScrollPane giftPane = new ScrollPane();
	public Stage thisStage = new Stage();
	public Scene thisScene;
	public GoodsVO thisGoods;
	public boolean eidtAble = true;
	Label label_image;
	OnlyDoubleTextField tf_reSaleMoney, tf_rebuyMoney, tf_buyMoney, tf_saleMoney;
	OnlyIntTextField tf_alarm, tf_number;
	LengthLimitTextField tf_batchID, tf_type, tf_name;

	double xOffset;
	double yOffset;
	public ArrayList<TradeItemVO> giftList = new ArrayList<TradeItemVO>();
	public double moneyStrategy = 0;
	TextArea ta_comment;
	// public StockFormItemVO item=new StockFormItemVO();
	MouseEvent e;

	public boolean confirm = false;

	private StockController controller = new StockController();

	public GoodsMessageUI() {

	}

	@Override
	public void start(Stage stage) throws Exception {

		stage.setTitle("Error");
		stage.setIconified(false);
		stage.initStyle(StageStyle.TRANSPARENT);// 无边框
		thisStage = stage;
		makeUI();
		Scene scene = new Scene(root, 450, 500);
		thisScene = scene;
//		stage.setAlwaysOnTop(true);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(scene);
		stage.showAndWait();
		// stage.show();
	}

	public void makeUI() {
		Image image1 = new Image("file:img\\stock\\header_goods.png");
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
		label_Close.setLayoutX(410);
		label_Close.setLayoutY(6);
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

		Label label_he = new Label("：");
		label_he.setLayoutX(20);
		label_he.setLayoutY(40);
		root.getChildren().add(label_he);

		String path = "img\\default\\test.png";
		if (thisGoods != null && thisGoods.getImagePath() != null) {
			path = thisGoods.getImagePath();
		}
		
		
		label_image = new Label("", new ImageView(new Image("file:"+path)));

		label_image.setLayoutX(30);
		label_image.setLayoutY(65);
		// label_image.setPrefSize(340, 140);
		root.getChildren().add(label_image);

		MyButton button_changeImg = new MyButton("更改图片", 20, 80);
		button_changeImg.setOnAction((ActionEvent event) -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open Resource File");
			File file = fileChooser.showOpenDialog(new Stage());

			
			if(file!=null) {
				String t = "temp//" + file.hashCode() + ".png";
				ImageZipUtil.zipWidthHeightImageFile(file, new File(t), 80, 80, 1.0f);

				root.getChildren().remove(label_image);
				Image image3 = new Image("file:" + t);
				label_image = new Label("", new ImageView(image3));
				label_image.setLayoutX(30);
				label_image.setLayoutY(65);
				root.getChildren().add(label_image);
				thisGoods.setImage( new File(t).getAbsolutePath());
			System.out.println("absolute="+new File(t).getAbsolutePath());
				System.out.println("这个goods的image:" + t);
				try {
					QiPaoUI.showTip(root, "图片更新成功");
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
			

		});
		button_changeImg.setLayoutX(110);
		button_changeImg.setLayoutY(140);
		button_changeImg.setScaleX(0.7);
		button_changeImg.setScaleY(0.7);
		root.getChildren().add(button_changeImg);

		Label label_quick = new Label("商品名称");
		label_quick.setLayoutX(180);
		label_quick.setLayoutY(60);
		root.getChildren().add(label_quick);

		String name = "-";
		if (thisGoods != null && thisGoods.getName() != null) {
			name = thisGoods.getName();
		}
		tf_name = new LengthLimitTextField(name, 20);
		tf_name.setLayoutX(240);
		tf_name.setLayoutY(57);
		root.getChildren().add(tf_name);

		Label label_type = new Label("型号");
		label_type.setLayoutX(180);
		label_type.setLayoutY(90);
		root.getChildren().add(label_type);

		String type = "";
		if (thisGoods != null && thisGoods.getType() != null) {
			type = thisGoods.getType();
		}
		tf_type = new LengthLimitTextField(type, 20);
		tf_type.setLayoutX(240);
		tf_type.setLayoutY(87);
		root.getChildren().add(tf_type);

		Label label_batch = new Label("批次批号");
		label_batch.setLayoutX(180);
		label_batch.setLayoutY(120);
		root.getChildren().add(label_batch);

		String batchID = "";
		if (thisGoods != null && thisGoods.getBatchID() != null) {
			batchID = thisGoods.getBatchID();
		}
		tf_batchID = new LengthLimitTextField(batchID, 20);
		tf_batchID.setLayoutX(240);
		tf_batchID.setLayoutY(117);
		root.getChildren().add(tf_batchID);

		Label label_buyMoney = new Label("进价");
		label_buyMoney.setLayoutX(30);
		label_buyMoney.setLayoutY(180);
		root.getChildren().add(label_buyMoney);

		double buyMoney = 0;
		if (thisGoods != null) {
			buyMoney = thisGoods.getBuyingPrice();
		}
		tf_buyMoney = new OnlyDoubleTextField(buyMoney + "");
		tf_buyMoney.setPrefWidth(300);
		tf_buyMoney.setLayoutX(110);
		tf_buyMoney.setLayoutY(177);
		root.getChildren().add(tf_buyMoney);

		Label label_saleMoney = new Label("售价");
		label_saleMoney.setLayoutX(30);
		label_saleMoney.setLayoutY(210);
		root.getChildren().add(label_saleMoney);

		double saleMoney = 0;
		if (thisGoods != null) {
			saleMoney = thisGoods.getSalePrice();
		}
		tf_saleMoney = new OnlyDoubleTextField(saleMoney + "");
		tf_saleMoney.setPrefWidth(300);
		tf_saleMoney.setLayoutX(110);
		tf_saleMoney.setLayoutY(207);
		root.getChildren().add(tf_saleMoney);

		Label label_rebuyMoney = new Label("最近进价");
		label_rebuyMoney.setLayoutX(30);
		label_rebuyMoney.setLayoutY(240);
		root.getChildren().add(label_rebuyMoney);

		double rebuyMoney = 0;
		if (thisGoods != null) {
			rebuyMoney = thisGoods.getRecentBuyingPrice();
		}
		tf_rebuyMoney = new OnlyDoubleTextField(rebuyMoney + "");
		tf_rebuyMoney.setPrefWidth(300);
		tf_rebuyMoney.setLayoutX(110);
		tf_rebuyMoney.setLayoutY(237);
		root.getChildren().add(tf_rebuyMoney);

		Label label_reSaleMoney = new Label("最近售价");
		label_reSaleMoney.setLayoutX(30);
		label_reSaleMoney.setLayoutY(270);
		root.getChildren().add(label_reSaleMoney);

		double reSaleMoney = 0;
		if (thisGoods != null) {
			reSaleMoney = thisGoods.getRecentSalePrice();
		}
		tf_reSaleMoney = new OnlyDoubleTextField(reSaleMoney + "");
		tf_reSaleMoney.setPrefWidth(300);
		tf_reSaleMoney.setLayoutX(110);
		tf_reSaleMoney.setLayoutY(267);
		root.getChildren().add(tf_reSaleMoney);

		Label label_number = new Label("现有数量");
		label_number.setLayoutX(30);
		label_number.setLayoutY(300);
		root.getChildren().add(label_number);

		int number = 0;
		if (thisGoods != null) {
			System.out.println("现有数量：" + thisGoods.getNumbers());
			number = thisGoods.getNumbers();
		}
		tf_number = new OnlyIntTextField(number + "");
		tf_number.setPrefWidth(300);
		tf_number.setLayoutX(110);
		tf_number.setLayoutY(297);
		root.getChildren().add(tf_number);

		Label label_alarm = new Label("警戒数量");
		label_alarm.setLayoutX(30);
		label_alarm.setLayoutY(330);
		root.getChildren().add(label_alarm);

		int alarmNum = 0;
		if (thisGoods != null) {
			alarmNum = thisGoods.getAlarmingValue();
		}
		tf_alarm = new OnlyIntTextField(alarmNum + "");
		tf_alarm.setPrefWidth(300);
		tf_alarm.setLayoutX(110);
		tf_alarm.setLayoutY(327);
		root.getChildren().add(tf_alarm);

		MyButton button_submit = new MyButton("保存", 20, 80);
		button_submit.setLayoutX(150);
		button_submit.setLayoutY(400);
		button_submit.setOnAction((ActionEvent event) -> {
			if (updateMessage().size() != 0) {
				try {
					QiPaoUI.showTip(root, updateMessage().get(0));
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			} else {
				try {
					if (thisGoods.getID() == null) {
						updateMessage();
						thisGoods.setProductionDate(new Date(System.currentTimeMillis()));
						controller.add(thisGoods);
						thisStage.hide();
					} else {
						updateMessage();
						controller.modify(thisGoods);

					}
				} catch (RemoteException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}

				confirm = true;
				thisStage.hide();
			}

		});
		root.getChildren().add(button_submit);

		MyButton button_delete = new MyButton("删除", 20, 80);
		button_delete.setLayoutX(240);
		button_delete.setLayoutY(400);
		button_delete.setOnAction((ActionEvent event) -> {

			TipUI.showConfirmDialog(thisStage, "您真的要删除这个商品吗？？", "confirm");
			if (TipUI.buttonSelected == TipUI.Response.YES) {
				if (thisGoods.getID() == null) {
					thisStage.hide();
				} else {
					updateMessage();
					confirm = true;

					try {
						controller.delete(thisGoods.getID());
					} catch (RemoteException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
					thisStage.hide();
				}

			}

		});
		root.getChildren().add(button_delete);

		MyButton button_back = new MyButton("返回", 20, 80);
		button_back.setOnAction((ActionEvent event) -> {
			confirm = false;
			thisStage.hide();
		});
		button_back.setLayoutX(330);
		button_back.setLayoutY(400);
		root.getChildren().add(button_back);

	}

	private ArrayList<String> updateMessage() {
		ArrayList<String> errorList = new ArrayList<String>();
		if (tf_name.getText().trim().length() < 1) {
			errorList.add("商品名称不得为空;");
		}
		if (thisGoods != null) {
			thisGoods.setName(tf_name.getText().trim());
			thisGoods.setBuyingPrice(tf_buyMoney.value);
			thisGoods.setSalePrice(tf_saleMoney.value);
			thisGoods.setAlarmingValue(tf_alarm.value);
			thisGoods.setNumbers(tf_number.value);
			thisGoods.setType(tf_type.value);
			thisGoods.setRecentBuyingPrice(tf_rebuyMoney.value);
			thisGoods.setRecentSalePrice(tf_reSaleMoney.value);
			thisGoods.setBatchID(tf_batchID.value);
		}
		return errorList;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
