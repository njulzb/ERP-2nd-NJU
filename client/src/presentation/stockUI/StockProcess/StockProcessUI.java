package presentation.stockUI.StockProcess;

import java.io.File;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import BL.stockBL.StockController;
import BLService.stockBLService.GoodsManageBLService;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import presentation.littleUI.HELP.MyButton;
import utility.TimeHelper;
import vo.goods.GoodsVO;
import vo.goods.PortVO;
import vo.goods.StockProcessItemVO;

/**
 * 
 * @author Alan
 */
public class StockProcessUI extends Application {
	DatePicker startDatePicker, endDatePicker;
	StockProcessUI me = this;
	PortVO nowVO = new PortVO();
	StockController controller = new StockController();
	public Pane root = new Pane(), locationPane = new Pane(), itemsPane = new Pane(), table = new Pane();
	String Path = "";
	Stage stage;
	TextField tf_search;
	int pageSize = 10;

	ArrayList<StockProcessItemVO> VOtoShow = new ArrayList<StockProcessItemVO>();
	boolean isSearchResult = false;

	public StockProcessUI() {
		root = initPane(root);
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		// stage.initStyle(StageStyle. TRANSPARENT);//无边框
		stage.setAlwaysOnTop(true);
		// stage.setResizable(false);//不能改变大小

		initData();

		root = initPane(root);

		Scene scene = new Scene(root, 700, 600);
		stage.setScene(scene);
		stage.show();

	}

	public Pane initPane(Pane roo3t) {

		Label label_title = new Label("库存查看");
		label_title.setLayoutX(30);
		label_title.setLayoutY(40);
		label_title.setFont(new Font(22));
		root.getChildren().add(label_title);

		Image image1 = new Image("file:img\\stock\\line.png");
		Label label_line1 = new Label("", new ImageView(image1));
		label_line1.setLayoutX(30);
		label_line1.setLayoutY(70);

		root.getChildren().add(label_line1);

		Image image3 = new Image("file:" + Path + getImgPath() + "button\\button_output.png");
		button label_output = new button("", new ImageView(image3));
		label_output.setLayoutX(30);
		label_output.setLayoutY(87);
		label_output.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				// CreateGoodsUI c= new CreateGoodsUI();
				// c.father=me;
				// c.goods.setUpperID(nowVO.getID());
				// c.start(new Stage());
			}
		});
		root.getChildren().add(label_output);

		startDatePicker = new DatePicker();
		startDatePicker.setLayoutX(310);
		startDatePicker.setLayoutY(50);
		startDatePicker.setMaxWidth(120);
		root.getChildren().add(startDatePicker);

		Label label_searchPane = new Label("-->");
		label_searchPane.setLayoutX(432);
		label_searchPane.setLayoutY(55);
		root.getChildren().add(label_searchPane);

		endDatePicker = new DatePicker();
		endDatePicker.setLayoutX(460);
		endDatePicker.setLayoutY(50);
		endDatePicker.setMaxWidth(120);
		root.getChildren().add(endDatePicker);

		;
		MyButton label_search = new MyButton("确认", 30, 90);
		label_search.setLayoutX(590);
		label_search.setLayoutY(50);
		label_search.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				reNew();
			}
		});
		root.getChildren().add(label_search);

		startDatePicker.setValue(LocalDate.now());
		endDatePicker.setValue(LocalDate.now());
		reNew();

		return root;

	}

	public void reNew() {
		System.out.println(1);

		try {
			nowVO = controller.lookOver(TimeHelper.LocalDateToDate(startDatePicker.getValue()),
					TimeHelper.LocalDateToDate(endDatePicker.getValue()));
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		if (root.getChildren().contains(table)) {
			root.getChildren().remove(table);

		}

		table = new Pane();
		table.setLayoutX(30);
		table.setLayoutY(130);

		Label label_timephase = new Label("当前时间段：" + startDatePicker.getValue() + "-->" + endDatePicker.getValue());
		label_timephase.setLayoutX(0);
		label_timephase.setLayoutY(0);
		table.getChildren().add(label_timephase);

		Label label_importNum = new Label("总入库量： " + nowVO.getImportNumber());
		label_importNum.setLayoutX(70);
		label_importNum.setLayoutY(30);
		table.getChildren().add(label_importNum);

		Label label_importMoney = new Label("入库总额： " + nowVO.getSaleInMoney());
		label_importMoney.setLayoutX(70);
		label_importMoney.setLayoutY(50);
		table.getChildren().add(label_importMoney);

		Label label_exporNum = new Label("总出库量： " + nowVO.getexportNumber());
		label_exporNum.setLayoutX(70);
		label_exporNum.setLayoutY(90);
		table.getChildren().add(label_exporNum);

		Label label_exporMoney = new Label("出库总额： " + nowVO.getExportMoney());
		label_exporMoney.setLayoutX(70);
		label_exporMoney.setLayoutY(110);
		table.getChildren().add(label_exporMoney);

		Label label_saleNum = new Label("总销售量： " + nowVO.getexportNumber());
		label_saleNum.setLayoutX(70);
		label_saleNum.setLayoutY(160);
		table.getChildren().add(label_saleNum);

		Label label_salerMoney = new Label("销售总额： " + nowVO.getSaleOutMoney());
		label_salerMoney.setLayoutX(70);
		label_salerMoney.setLayoutY(180);
		table.getChildren().add(label_salerMoney);

		Label label_buyNum = new Label("总进货量： " + nowVO.getImportNumber());
		label_buyNum.setLayoutX(70);
		label_buyNum.setLayoutY(230);
		table.getChildren().add(label_buyNum);

		Label label_buyMoney = new Label("进货总额： " + nowVO.getSaleInMoney());
		label_buyMoney.setLayoutX(70);
		label_buyMoney.setLayoutY(250);
		table.getChildren().add(label_buyMoney);

		root.getChildren().add(table);
	}

	public void initData() {

		File directory = new File("");// 设定为当前文件夹
		try {

			Path = directory.getCanonicalPath();

		} catch (Exception e) {
		}

		// controller=new GoodsManageBLServiceStub();
		// nowVO=controller.getRoot();
		for (int i = 0; i < 30; i++) {
			StockProcessItemVO temp = new StockProcessItemVO();

			temp.setGoodsName("ddd");
			temp.setGoodsXingHao("3A");
			temp.setKind("JIN HUo");
			temp.setNum(300);
			temp.setSingleMoney(100);
			VOtoShow.add(temp);
		}

	}

	public String getImgPath() {
		return "\\img\\";

	}

	public class button extends Label {
		public button(String a, ImageView c) {
			super(a, c);
			this.setOnMouseEntered(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent e) {

					Label obj = (Label) e.getSource();
					double x = obj.getLayoutX();
					double y = obj.getLayoutY();
					obj.setLayoutX(x + 3);
					obj.setLayoutY(y + 3);
				}
			});
			this.setOnMouseExited(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent e) {
					Label obj = (Label) e.getSource();
					double x = obj.getLayoutX();
					double y = obj.getLayoutY();
					obj.setLayoutX(x - 3);
					obj.setLayoutY(y - 3);
				}
			});
		}

		public button() {

		}
	}

	private void showTip(String message) {
	}

}