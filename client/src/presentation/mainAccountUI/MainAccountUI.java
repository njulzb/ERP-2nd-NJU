package presentation.mainAccountUI;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import BL.mainAccountBL.MainAccountController;
import BL.messageBL.MessageController;
import BLService.mainAccountBLService.MainAccountService;
import BLService.messageBLService.MessageBLService;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import presentation.littleUI.HELP.MyButton;
import presentation.receiptUI.FormMessageUI;
import vo.MessageVO;
import vo.UserVO;
import vo.Form.FinanceFormVO.FinanceFormVO;
import vo.Form.FinanceFormVO.TransItemVO;
import vo.Form.stockFormVO.StockFormVO;
import vo.Form.stockFormVO.StockItemVO;
import vo.Form.tradeFormVO.TradeFormVO;
import vo.Form.tradeFormVO.TradeItemVO;

/**
 * 
 * @author Alan
 */
public class MainAccountUI extends Application {

	public Pane root = new Pane();
	public UserVO user = null;

	MainAccountUI me = this;
	String lastState = "";
	MainAccountService controller = new MainAccountController();
	String Path = "";
	Stage stage;

	public static void main(String[] args) {
		System.out.println("1511");
		launch(args);
	}

	public MainAccountUI() {
		initData();
		root = initPane();

	}

	@Override
	public void start(Stage stage) throws Exception {
		System.out.println("111");

		this.stage = stage;
		stage.initStyle(StageStyle.TRANSPARENT);// 无边�?
		stage.setAlwaysOnTop(true);
		// stage.setResizable(false);//不能改变大小
		Scene scene = new Scene(root, 700, 600);

		stage.setScene(scene);
		stage.show();

	}

	public Pane initPane() {

		Label label_title = new Label("账本操作");
		label_title.setLayoutX(30);
		label_title.setLayoutY(40);
		label_title.setFont(new Font(22));
		root.getChildren().add(label_title);

		Date startDate = new Date(System.currentTimeMillis());
		Label label_wd = new Label("当前经营季度 ：     " + startDate.toString() + "   至今");
		label_wd.setLayoutX(30);
		label_wd.setTextFill(Color.ROYALBLUE);
		label_wd.setLayoutY(100);
		label_wd.setFont(new Font(12));
		label_wd.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {

			}
		});
		root.getChildren().add(label_wd);

		Image image1 = new Image("file:" + Path + getImgPath() + "stock\\line.png");
		Label label_line1 = new Label("", new ImageView(image1));
		label_line1.setLayoutX(30);
		label_line1.setLayoutY(70);

		root.getChildren().add(label_line1);

		MyButton button_create = new MyButton("新建一个账期", 50, 160);
		button_create.setLayoutX(100);
		button_create.setLayoutY(200);
		button_create.setOnAction((ActionEvent event) -> {
			try {
				controller.createNewAccount();
			} catch (RemoteException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		});
		root.getChildren().add(button_create);

		MyButton button_startInfo = new MyButton("加载期初信息", 50, 160);
		button_startInfo.setLayoutX(370);
		button_startInfo.setLayoutY(200);
		button_startInfo.setOnAction((ActionEvent event) -> {
			DirectoryChooser directoryChooser = new DirectoryChooser();
			directoryChooser.setTitle("Open Resource File");
			File file = directoryChooser.showDialog(stage);

			try {
				controller.getStartInfo(file.getCanonicalPath());
			} catch (RemoteException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		});
		root.getChildren().add(button_startInfo);

		return root;

	}

	public void initData() {

		File directory = new File("");// 设定为当前文件夹
		try {

			Path = directory.getCanonicalPath();

		} catch (Exception e) {
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

}