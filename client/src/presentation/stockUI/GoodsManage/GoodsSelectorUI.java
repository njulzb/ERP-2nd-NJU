package presentation.stockUI.GoodsManage;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import BL.stockBL.StockController;
import BLService.stockBLService.GoodsManageBLService;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import presentation.stockUI.GoodsManage.StockManageUI2.button;
import presentation.stockUI.GoodsManage.StockManageUI2.myPane_goods;
import presentation.stockUI.GoodsManage.StockManageUI2.myPane_goodsClass;
import vo.goods.GoodsClassVO;
import vo.goods.GoodsVO;

/**
 * JavaFxȷ�ϵ�����
 * 
 * @author clzhu 2014/12/15
 * 
 */
public class GoodsSelectorUI {
	public GoodsVO VO;
	Dialog dial;
	VBox box;
	Pane root = new Pane(), selectMessagePane = new Pane(), routeMessagePane = new Pane();
	Scene scene;
	ListView<String> list;
	Label label = new Label();

	public GoodsVO beSelected;
	ArrayList<GoodsClassVO> goodsList = new ArrayList<GoodsClassVO>();
	ArrayList<String> goodsNameList = new ArrayList<String>();

	GoodsClassVO nowClass;
	GoodsManageBLService controller = new StockController();
	Pane locationPane = new Pane();
	Pane itemsPane = new Pane();
	Stage stage;
	int nowPage = 0;
	TextField tf_search;
	int pageSize = 4;
	ArrayList<GoodsClassVO> VOtoShow = new ArrayList<GoodsClassVO>();

	protected String Path;

	public GoodsSelectorUI() {

		try {
			nowClass = controller.getRoot();

		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		try {
			Path = new File("").getCanonicalPath() + "\\img\\";
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

	private ImageView icon = new ImageView();

	class Dialog extends Stage {
		public Dialog(String title, Stage owner, Scene scene) {

			setTitle(title);
			initStyle(StageStyle.TRANSPARENT);
			initModality(Modality.APPLICATION_MODAL);
			initOwner(owner);
			setResizable(false);
			setScene(scene);
			icon.setImage(new Image("file:" + Path + "default\\error.png"));
		}

		// public Dialog(String title, Stage owner, Scene scene, String iconFile) {
		// setTitle(title);
		// initStyle(StageStyle.UTILITY);
		// initModality(Modality.APPLICATION_MODAL);
		// initOwner(owner);
		// setResizable(false);
		// setScene(scene);
		// icon.setImage(new Image(getClass().getResourceAsStream(iconFile)));
		// }
		public void showDialog() {

			// this.setX(100);

			sizeToScene();
			centerOnScreen();
			showAndWait();
		}
	}

	class Message extends Text {

		public Message(String msg) {
			super(msg);
			setWrappingWidth(250);
		}
	}

	public void showSelectorDialog(Stage owner, String title) {

		scene = new Scene(root, 300, 300);
		showItem(null);

		dial = new Dialog(title, owner, scene);
		dial.showDialog();

	}

	private void showItem(GoodsClassVO goodsClass) {

		if (box != null && selectMessagePane != null && box.getChildren().contains(selectMessagePane)) {
			box.getChildren().remove(selectMessagePane);
		}

		if (goodsClass instanceof GoodsVO) {
			System.out.println("!!!!!");

			this.VO = (GoodsVO) goodsClass;

			Image image4 = new Image("file:" + Path + "button\\button_save.png");
			Label label_searchPane = new Label("", new ImageView(image4));
			label_searchPane.setLayoutX(120);
			label_searchPane.setLayoutY(2);
			label_searchPane.setScaleX(0.6);
			label_searchPane.setScaleY(0.6);
			label_searchPane.setOnMousePressed(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					dial.hide();
				}
			});
			label_searchPane.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					label_searchPane.setScaleX(0.7);
					label_searchPane.setScaleY(0.7);
				}
			});
			label_searchPane.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					label_searchPane.setScaleX(0.6);
					label_searchPane.setScaleY(0.6);
				}
			});
			selectMessagePane.getChildren().add(label_searchPane);
			box.getChildren().add(selectMessagePane);
			return;
		} else {
			root.getChildren().remove(box);
			try {
				iniRoute();
			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			goodsList.clear();
			;
			goodsNameList.clear();
			;
			// routeMessagePane.setMinHeight(20);
			// selectMessagePane.setMinHeight(20);
		}

		list = new ListView<>();
		try {
			for (GoodsClassVO v : controller.getLower(nowClass.getID())) {
				goodsList.add(v);
				goodsNameList.add(v.getName());
			}

		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		ObservableList<String> data = FXCollections.observableArrayList(goodsNameList);

		routeMessagePane.setLayoutY(0);
		list.setLayoutY(30);
		list.setMaxHeight(200);
		selectMessagePane.setLayoutY(230);

		box = new VBox();
		box.getChildren().addAll(routeMessagePane, list, selectMessagePane);
		VBox.setVgrow(list, Priority.ALWAYS);
		// label.setLayoutX(10);
		// label.setLayoutY(115);
		// label.setFont(Font.font("Verdana", 20));

		list.setItems(data);

		// list.setCellFactory((ListView<String> l) -> new ColorRectCell());

		list.getSelectionModel().selectedItemProperty()
				.addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
					// label.setText("选择："+new_val);
					// System.out.println("aaa");
					nowClass = goodsList.get(list.getSelectionModel().getSelectedIndex());
					showItem(nowClass);
				});

		//
		//
		// box.setLayoutX(0);
		// box.setLayoutY(40);

		root.getChildren().add(box);

	}

	private void iniRoute() throws RemoteException {
		if (box != null && box.getChildren().contains(routeMessagePane)) {
			box.getChildren().remove(routeMessagePane);
		}

		routeMessagePane = new Pane();
		ArrayList<GoodsClassVO> route = new ArrayList<GoodsClassVO>();
		GoodsClassVO tempClass = nowClass;
		while (true) {
			route.add(tempClass);
			if (tempClass.equals(controller.getRoot())) {
				break;
			} else {
				tempClass = controller.getUpper(tempClass.getID());
			}
		}

		Label label_11 = new Label("当前:");
		label_11.setLayoutX(0);
		label_11.setLayoutY(5);
		label_11.setFont(new Font("黑体", 10));
		routeMessagePane.getChildren().add(label_11);

		int num = 0;
		for (int i = route.size() - 1; i >= 0; i--) {

			GoodsClassVO tp = (route.get(i));
			Label label_t = new Label(">>" + tp.getName());
			label_t.setLayoutX(20 + num * 60);
			label_t.setLayoutY(5);
			label_t.setFont(new Font("黑体", 10));
			num++;
			if (i != 0) {
				label_t.setTextFill(Color.BLUE);
				label_t.setOnMousePressed(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						nowClass = tp;
						showItem(nowClass);
					}
				});
			}

			routeMessagePane.getChildren().add(label_t);
		}

		root.getChildren().add(routeMessagePane);
	}

	public void main(String args[]) {
		showSelectorDialog(new Stage(), "dd");
	}

	class ColorRectCell extends ListCell<String> {
		@Override
		public void updateItem(String item, boolean empty) {
			super.updateItem(item, empty);
			Rectangle rect = new Rectangle(100, 20);
			if (item != null) {
				rect.setFill(Color.web(item));
				setGraphic(rect);
			} else {
				setGraphic(null);
			}
		}
	}

}