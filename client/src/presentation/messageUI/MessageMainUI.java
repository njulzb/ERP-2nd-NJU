package presentation.messageUI;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import BL.messageBL.MessageController;
import BLService.messageBLService.MessageBLService;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import po.KeyForSearchMessage;
import presentation.littleUI.QiPaoUI;
import presentation.littleUI.TipUI;
import vo.MessageVO;
import vo.UserVO;

/**
 * 
 * @author Alan
 */
public class MessageMainUI extends Application {
	MessageMainUI me = this;
	String lastState = "";
	public UserVO user = null;
	// GoodsClassVO nowClass ;
	MessageBLService controller = new MessageController();
	public Pane root = new Pane(), locationPane = new Pane(), itemsPane = new Pane();
	String Path = "";
	Stage thisStage;
	TextField tf_search;
	Label label_searchMes;
	int pageSize = 5;
	public int nowPage = 0;

	boolean isSearching = false;

	ArrayList<MessageVO> VOtoShow = new ArrayList<MessageVO>();
	button label_newSubClass, label_searchbutton;
	boolean isSearchResult = false;
	int isRead = 0;
	double xOffset;
	double yOffset;

	//
	public static void main(String[] args) {
		launch(args);
	}

	public MessageMainUI() {
		initData();
	}

	@Override
	public void start(Stage stage) throws Exception {
		System.out.println("111");

		this.thisStage = stage;
		stage.initStyle(StageStyle.TRANSPARENT);// 无边�?
		stage.setAlwaysOnTop(true);

		root.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				e.consume();
				xOffset = e.getSceneX();
				yOffset = e.getSceneY();
			}
		});
		root.setOnMouseDragged(new EventHandler<MouseEvent>() {

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

		root.setStyle("-fx-border-color:  #545454");
		// stage.setResizable(false);//不能改变大小
		Scene scene = new Scene(root, 700, 600);
		root = initPane();

		stage.setScene(scene);
		stage.show();

	}

	public Pane initPane() {

		Image imageClose = new Image("file:" + Path + getImgPath() + "stock\\closeIcon.png");
		button label_Close = new button("", new ImageView(imageClose));
		label_Close.setLayoutX(670);
		label_Close.setLayoutY(10);
		label_Close.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				thisStage.hide();
			}
		});
		root.getChildren().add(label_Close);

		Label label_title = new Label("通知与消息");
		label_title.setLayoutX(30);
		label_title.setLayoutY(40);
		label_title.setFont(new Font(22));
		root.getChildren().add(label_title);

		Label label_wd = new Label("未读消息");
		label_wd.setLayoutX(30);
		label_wd.setTextFill(Color.ROYALBLUE);
		label_wd.setLayoutY(100);
		label_wd.setFont(new Font(12));
		label_wd.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				isRead = 0;
				showItem(0);
			}
		});
		root.getChildren().add(label_wd);

		Label label_yd = new Label("已读消息");
		label_yd.setLayoutX(110);
		label_yd.setTextFill(Color.ROYALBLUE);
		label_yd.setLayoutY(100);
		label_yd.setFont(new Font(12));
		label_yd.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				isRead = 1;
				showItem(0);
			}
		});
		root.getChildren().add(label_yd);

		Label label_fs = new Label("发送消息");
		label_fs.setLayoutX(190);
		label_fs.setTextFill(Color.ROYALBLUE);
		label_fs.setLayoutY(100);
		label_fs.setFont(new Font(12));
		label_fs.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				showSendUI();
			}
		});
		root.getChildren().add(label_fs);

		//
		// Image imageleft = new Image("file:"+Path+getImgPath()+"message\\left.png");
		// button label_left = new button("", new ImageView(imageleft));
		// label_left .setLayoutX(0);
		// label_left .setLayoutY(0);
		// label_left.setOnMousePressed(new EventHandler<MouseEvent>(){
		// @Override public void handle(MouseEvent e){
		// stage.hide();
		// }
		// });
		// root.getChildren().add(label_left);

		Image image1 = new Image("file:" + Path + getImgPath() + "stock\\line.png");
		Label label_line1 = new Label("", new ImageView(image1));
		label_line1.setLayoutX(30);
		label_line1.setLayoutY(70);

		root.getChildren().add(label_line1);

		// Image imag1 = new
		// Image("file:"+Path+getImgPath()+"button\\button_search.png");
		// label_searchbutton = new button("", new ImageView(imag1));
		// label_searchbutton .setLayoutX(30);
		// label_searchbutton.setLayoutY(100);
		// System.out.println(1);
		// label_searchbutton.setOnMousePressed(new EventHandler<MouseEvent>(){
		// @Override public void handle(MouseEvent e){
		// System.out.println(1);
		//
		//
		// }
		// });
		// root.getChildren().add(label_searchbutton);

		showItem(0);
		return root;

	}

	public void showItem(int page) {

		initList();
		nowPage = page;
		if (root.getChildren().contains(itemsPane)) {
			root.getChildren().remove(itemsPane);
		}

		itemsPane = new Pane();
		itemsPane.setLayoutX(30);
		itemsPane.setLayoutY(150);
		itemsPane.setMinWidth(640);
		itemsPane.setMinHeight(450);

		root.getChildren().add(itemsPane);

		if (VOtoShow.size() == 0) {
			return;
		}

		int num = 0;
		for (int i = pageSize * page; i < VOtoShow.size() && i < (page + 1) * pageSize; i++) {
			myPane_Item V = new myPane_Item();
			V.page = page;
			V.item = VOtoShow.get(i);

			V.make();
			V.setLayoutX(0);
			V.setLayoutY(80 * num + 0);
			itemsPane.getChildren().add(V);
			num++;
		}
		itemsPane = createPageSelect(itemsPane, page);

	}

	protected Pane createPageSelect(Pane root, int page) {

		int endPage = (int) Math.floor(VOtoShow.size() / pageSize);

		double sX = 100, sY = -80;
		double usedX = 0;

		if (VOtoShow.size() > pageSize) {
			if (page != 0) {
				Label label_11 = new Label("首页");
				label_11.setLayoutX(sX + usedX + 30);
				usedX += 50;
				label_11.setLayoutY(sY + 485);
				label_11.setFont(new Font(12));
				label_11.setTextFill(Color.BLUE);
				label_11.setOnMousePressed(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {

						showItem(0);

					}
				});
				root.getChildren().add(label_11);

				Label label_22 = new Label("上一页");
				label_22.setLayoutX(sX + usedX + 30);
				usedX += 50;
				label_22.setLayoutY(sY + 485);
				label_22.setFont(new Font(12));
				label_22.setTextFill(Color.BLUE);
				label_22.setOnMousePressed(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {

						showItem(page - 1);

					}
				});
				root.getChildren().add(label_22);

				Label label_33 = new Label(" " + Integer.toString(page));
				label_33.setLayoutX(sX + usedX + 30);
				usedX += 50;
				label_33.setLayoutY(sY + 485);
				label_33.setFont(new Font(12));
				label_33.setTextFill(Color.BLUE);
				label_33.setOnMousePressed(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {

						showItem(page - 1);

					}
				});
				root.getChildren().add(label_33);
			}

			Label label_44 = new Label(Integer.toString(page + 1) + " ");
			label_44.setLayoutX(sX + usedX + 30);
			usedX += 50;
			label_44.setLayoutY(sY + 485);
			label_44.setFont(new Font(12));
			label_44.setTextFill(Color.GREY);

			root.getChildren().add(label_44);

			if (page != endPage) {

				Label label_33 = new Label(Integer.toString(page + 2));
				label_33.setLayoutX(sX + usedX + 30);
				usedX += 40;
				label_33.setLayoutY(sY + 485);
				label_33.setFont(new Font("黑体", 12));
				label_33.setTextFill(Color.BLUE);
				label_33.setOnMousePressed(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {

						showItem(page + 1);

					}
				});
				root.getChildren().add(label_33);

				Label label_22 = new Label("下一页");
				label_22.setLayoutX(sX + usedX + 30);
				usedX += 40;
				label_22.setLayoutY(sY + 485);
				label_22.setFont(new Font(12));
				label_22.setTextFill(Color.BLUE);
				label_22.setOnMousePressed(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {

						showItem(page + 1);

					}
				});
				root.getChildren().add(label_22);

				Label label_11 = new Label("末页");
				label_11.setLayoutX(sX + usedX + 30);
				usedX += 50;
				label_11.setLayoutY(sY + 485);
				label_11.setFont(new Font(12));
				label_11.setTextFill(Color.BLUE);
				label_11.setOnMousePressed(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {

						showItem(endPage);

					}
				});
				root.getChildren().add(label_11);

			}

		}

		return root;

	}

	public void initData() {

		File directory = new File("");// 设定为当前文件夹
		try {

			Path = directory.getCanonicalPath();

		} catch (Exception e) {
		}

	}

	public void initList() {
		System.out.println("now User:" + user.getID());
		VOtoShow.clear();
		KeyForSearchMessage key = new KeyForSearchMessage();
		key.setIsRead(isRead);
		if (user != null) {
			key.setReceiverID(user.getID());
		}
		try {
			VOtoShow = controller.searchMessage(key);
		} catch (RemoteException e) {
			TipUI.showMessageDialog(thisStage, "错误/n无法连接到服务器", "error");
			e.printStackTrace();
		}

	}

	public String getImgPath() {
		return "\\img\\";

	}

	public class myPane_Item extends Pane {
		MessageVO item;
		// myPane_Item meItem=this;
		Label label_toYD;
		int page = 0;

		public void make() {
			this.setMaxHeight(80);
			this.setMaxWidth(640);
			this.setMinWidth(640);
			this.setMinHeight(80);

			Line line1 = new Line();
			line1.setStartX(0);
			line1.setStartY(1);
			line1.setEndX(640);
			line1.setEndY(1);
			line1.setStrokeWidth(0.1);
			this.getChildren().add(line1);

			Label label_senderID = new Label("发件人" + item.getSenderName_ID());
			label_senderID.setFont(new Font(10));
			label_senderID.setTextFill(Color.GREY);
			label_senderID.setLayoutX(10);
			label_senderID.setLayoutY(10);
			this.getChildren().add(label_senderID);

			Label label_time = new Label(item.getCreate().toString());
			label_time.setFont(new Font(10));
			label_time.setTextFill(Color.GREY);
			label_time.setLayoutX(470);
			label_time.setLayoutY(10);
			this.getChildren().add(label_time);

			Label label_message = new Label(item.getMessage());
			label_message.setWrapText(true);
			label_message.setMaxHeight(40);
			label_message.setMinHeight(40);
			label_message.setMaxWidth(500);
			label_message.setMinWidth(500);
			// label_message.setBackground(new Background(new BackgroundFill(Color.BISQUE,
			// null, null)));
			label_message.setFont(new Font(12));
			label_message.setLayoutX(80);
			label_message.setLayoutY(25);
			this.getChildren().add(label_message);

			// label_toYD = new Label("", new ImageView(new
			// Image("file:"+Path+getImgPath()+"message/toYD.png")));
			label_toYD = new Label("❤");
			label_toYD.setFont(new Font(20));
			label_toYD.setTextFill(Color.RED);
			label_toYD.setTooltip(new Tooltip("标记为已读"));
			label_toYD.setLayoutX(20);
			label_toYD.setLayoutY(30);
			label_toYD.setOnMousePressed(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					try {
						item.setRead(true);
						controller.editMessage(item);
						showTip("已将其标为已读");
						showItem(nowPage);
					} catch (RemoteException e1) {
						// TODO 自动生成的 catch 块
						item.setRead(false);
						TipUI.showMessageDialog(thisStage, "网络错误\n无法连接至服务器", "error");
						e1.printStackTrace();
					}
				}
			});
			this.getChildren().add(label_toYD);

			this.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					Pane obj = (Pane) e.getSource();
					obj.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));

				}
			});
			this.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					Pane obj = (Pane) e.getSource();
					obj.setBackground(null);
				}
			});

		}
	}

	public void showTip(String message) {
		try {
			QiPaoUI.showTip(root, message);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public void showSendUI() {
		if (root.getChildren().contains(itemsPane)) {
			root.getChildren().remove(itemsPane);
		}

		itemsPane = new Pane();
		itemsPane.setLayoutX(30);
		itemsPane.setLayoutY(150);
		itemsPane.setMinWidth(640);
		itemsPane.setMinHeight(450);
		root.getChildren().add(itemsPane);

		Label l_reId = new Label("收件人：");
		l_reId.setLayoutX(0);
		l_reId.setLayoutY(0);
		itemsPane.getChildren().add(l_reId);

		TextField tf_rece = new TextField();
		tf_rece.setLayoutX(50);
		tf_rece.setLayoutY(0);
		itemsPane.getChildren().add(tf_rece);

		Label l_mes = new Label("信息：");
		l_mes.setLayoutX(0);
		l_mes.setLayoutY(50);
		itemsPane.getChildren().add(l_mes);

		Label l_tip = new Label("");
		l_tip.setLayoutX(50);
		l_tip.setLayoutY(220);
		l_tip.setTextFill(Color.GREY);
		itemsPane.getChildren().add(l_tip);

		TextArea tf_message = new TextArea();
		tf_message.setLayoutX(50);
		tf_message.setLayoutY(50);
		tf_message.setMaxWidth(590);
		tf_message.setMinWidth(590);
		itemsPane.getChildren().add(tf_message);
		tf_message.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				int n = (200 - tf_message.getText().length());
				if (n < 0) {
					tf_message.setText(lastState);
				} else if (n == 200) {
					l_tip.setText("");
					lastState = tf_message.getText();
				} else {
					lastState = tf_message.getText();
					l_tip.setText("还可以继续输入 " + n + " 个字符");
				}

			}
		});

		Image image12 = new Image("file:" + Path + getImgPath() + "button/button_send.png");
		button label_send = new button("", new ImageView(image12));
		label_send.setLayoutX(540);
		label_send.setLayoutY(250);
		label_send.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				MessageVO vo = new MessageVO();
				TipUI.showConfirmDialog(thisStage, "  确认发送？", "confirm");

				if (TipUI.buttonSelected == TipUI.Response.YES) {

					if (user == null) {
						vo.setSenderName_ID("SYSTEM");
					} else {
						vo.setSenderName_ID(user.getID());
					}
					if (tf_rece.getText() == null) {
						vo.setReceiverName_ID("");

					} else {
						vo.setReceiverName_ID(tf_rece.getText());

					}
					if (tf_message.getText() == null) {
						vo.setMessage("");

					} else {
						vo.setMessage(tf_message.getText());

					}
				}

				try {
					controller.addMessage(vo);
					TipUI.showMessageDialog(thisStage, "恭喜您\n操作成功", "congratulation");
					showSendUI();
				} catch (RemoteException e1) {
					// TODO 自动生成的 catch 块
					TipUI.showMessageDialog(thisStage, "网络错误\n无法连接至服务器", "error");
					e1.printStackTrace();
				}

			}
		});
		itemsPane.getChildren().add(label_send);
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