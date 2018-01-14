package presentation.stockUI.GoodsManage;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import BL.stockBL.Goods;
import BL.stockBL.StockController;
import BLService.stockBLService.GoodsManageBLService;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
import presentation.littleUI.QiPaoUI;
import presentation.littleUI.TipUI;
import presentation.littleUI.HELP.MyButton;
import utility.LOG;
import utility.RoleOfUser;
import vo.UserVO;
import vo.goods.GoodsClassVO;
import vo.goods.GoodsVO;

/**
 * 
 * @author Alan
 */
public class StockManageUI2 extends Application {

	public UserVO user = new UserVO("李测试", "11");

	StockManageUI2 me = this;
	GoodsClassVO nowClass;
	public GoodsManageBLService controller = new StockController();
	public Pane root = new Pane(), locationPane = new Pane(), itemsPane = new Pane();
	String Path = "";
	public Stage thisStage;
	public int nowPage = 0;
	TextField tf_search;
	int pageSize = 4;
	ArrayList<GoodsClassVO> VOtoShow = new ArrayList<GoodsClassVO>();
	private MyButton label_newGoods, label_newSubClass,label_back;
	boolean isSearch = false;

	public static void main(String[] args) {
		System.out.println(11);
		launch(args);
	}

	public StockManageUI2() {
		initData();
		root = initPane(root);

	}

	@Override
	public void start(Stage stage) throws Exception {

		// GoodsSelectorUI u=new GoodsSelectorUI ();
		// u.showSelectorDialog(stage, "dd");

		thisStage = stage;

		// stage.initStyle(StageStyle. TRANSPARENT);//无边框
		// stage.setAlwaysOnTop(true);
		// stage.setResizable(false);//不能改变大小
		Scene scene = new Scene(root, 700, 600);
		// scene.getStylesheets().add(
		// "file:"+Path+"\\css\\stock\\goodsManageStyle.css") ;
		stage.setScene(scene);
		stage.show();

	}

	public Pane initPane(Pane ro3ot) {

		// Image image0 = new Image("file:"+Path+getImgPath()+"receipt\\Header.png");
		// Label label_title = new Label("", new ImageView(image0));
		// label_title .setLayoutX(0);
		// label_title .setLayoutY(0);
		// root.getChildren().add(label_title);

		Label label_title = new Label("商品管理");
		label_title.setLayoutX(30);
		label_title.setLayoutY(40);
		label_title.setFont(new Font(22));
		root.getChildren().add(label_title);

		Image image1 = new Image("file:img\\stock\\line.png");
		Label label_line1 = new Label("", new ImageView(image1));
		label_line1.setLayoutX(30);
		label_line1.setLayoutY(70);

		root.getChildren().add(label_line1);

		 label_back = new MyButton("返回", 20, 80);
		 label_back.setLayoutX(30);
		 label_back.setLayoutY(100);
		 label_back.setOnAction((ActionEvent event) -> {
			isSearch = false;
			showItem(0);

		});
		root.getChildren().add(label_back);

		label_newSubClass = new MyButton("新建子分类", 20, 80);
		label_newSubClass.setLayoutX(30);
		label_newSubClass.setLayoutY(100);
		label_newSubClass.setOnAction((ActionEvent event) -> {
			CreateGoodsClassUI ct = new CreateGoodsClassUI();
			ct.father = me;
			ct.goodsClass.setUpperID(nowClass.getID());
			ct.start(new Stage());

		});
		root.getChildren().add(label_newSubClass);

		label_newGoods = new MyButton("新建商品", 20, 80);
		label_newGoods.setLayoutX(140);
		label_newGoods.setLayoutY(100);
		label_newGoods.setOnAction((ActionEvent event) -> {

			try {
				GoodsMessageUI c = new GoodsMessageUI();
				c.thisGoods = new GoodsVO("defaultName", nowClass.getID());
				c.thisGoods.setName(null);
				c.start(new Stage());
				if (c.confirm) {
					showItem(nowPage);
					LOG.addLog("新建了商品" + c.thisGoods.getName(), user.getName());
				}

			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}

		});
		root.getChildren().add(label_newGoods);

		tf_search = new TextField();
		tf_search.setMinHeight(19);
		;
		tf_search.setMinWidth(216);
		tf_search.setLayoutX(340);
		tf_search.setLayoutY(50);
		tf_search.setPrefSize(100, 24);
		root.getChildren().add(tf_search);

		MyButton button_search = new MyButton("查找", 20, 80);
		button_search.setLayoutX(565);
		button_search.setLayoutY(50);

		button_search.setOnAction((ActionEvent event) -> {
			if (tf_search.getText() != null && tf_search.getText().trim().length() > 0) {

				try {
					if (controller.search(tf_search.getText().trim()) != null) {
						VOtoShow.addAll(controller.search(tf_search.getText().trim()));
						showSearchItem(0);
					} else {
						VOtoShow.clear();
						showItem(0);
						showTip("未找到匹配的数据");
					}
				} catch (RemoteException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}

			}

		});
		root.getChildren().add(button_search);

		showItem(0);
		return root;

	}

	private void createButton() {
		if (isSearch) {
			label_back.setVisible(true);
			label_newSubClass.setVisible(false);
			label_newGoods.setVisible(false);
		} else {
			label_back.setVisible(false);
			label_newSubClass.setVisible(true);
			label_newGoods.setVisible(true);
		}
	}

	public void showItem(int page) {
		createButton();
		nowPage = page;
		try {
			showNowLocation();
		} catch (RemoteException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		if (root.getChildren().contains(itemsPane)) {
			root.getChildren().remove(itemsPane);
		}

		itemsPane = new Pane();
		itemsPane.setLayoutX(30);
		itemsPane.setLayoutY(150);
		itemsPane.setMinWidth(640);
		itemsPane.setMinHeight(450);

		root.getChildren().add(itemsPane);

		// System.out.println(nowClass.getID());
		try {

			VOtoShow = (controller.getLower(nowClass.getID()));
			// System.out.println(VOtoShow.size());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		if (VOtoShow == null || VOtoShow.size() == 0) {
			return;
		}

		Object obj = (VOtoShow.get(0));
		System.out.println(obj instanceof GoodsVO);
		if (obj instanceof GoodsVO) {
			System.out.println("这是goods");
			int num = 0;
			for (int i = pageSize * page; i < VOtoShow.size() && i < (page + 1) * pageSize; i++) {

				myPane_goods V = new myPane_goods();
				V.page = page;
				V.item = (GoodsVO) (VOtoShow.get(i));
				System.out.println(V.item.getName());
				V.make();
				V.setLayoutX(0);
				V.setLayoutY(100 * num + 0);
				itemsPane.getChildren().add(V);
				num++;
			}
			itemsPane = createPageSelect(itemsPane, page);
		} else {
			System.out.println("这是goodsClass");
			int num = 0;
			for (int i = pageSize * page; i < VOtoShow.size() && i < (page + 1) * pageSize; i++) {
				myPane_goodsClass V = new myPane_goodsClass();
				V.page = page;
				V.item = (VOtoShow.get(i));
				V.make();
				V.setLayoutX(0);
				V.setLayoutY(100 * num + 0);
				itemsPane.getChildren().add(V);
				num++;
			}
			itemsPane = createPageSelect(itemsPane, page);
		}

	}

	protected Pane createPageSelect(Pane root, int page) {

		int endPage = (int) Math.floor(VOtoShow.size() / pageSize);
		// TODO 自动生成的方法存根
		double sX = 100, sY = -80;
		double usedX = 0;

		if (VOtoShow.size() > pageSize) {
			if (page != 0) {
				Label label_11 = new Label("首页");
				label_11.setLayoutX(sX + usedX + 30);
				usedX += 50;
				label_11.setLayoutY(sY + 485);
				label_11.setFont(new Font("黑体", 12));
				label_11.setTextFill(Color.BLUE);
				label_11.setOnMousePressed(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						if (isSearch) {
							showSearchItem(0);
						} else
							showItem(0);

					}
				});
				root.getChildren().add(label_11);

				Label label_22 = new Label("上一页 ");
				label_22.setLayoutX(sX + usedX + 30);
				usedX += 50;
				label_22.setLayoutY(sY + 485);
				label_22.setFont(new Font("黑体", 12));
				label_22.setTextFill(Color.BLUE);
				label_22.setOnMousePressed(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						if (isSearch) {
							showSearchItem(page - 1);
						} else
							showItem(page - 1);
					}
				});
				root.getChildren().add(label_22);

				Label label_33 = new Label(" " + Integer.toString(page));
				label_33.setLayoutX(sX + usedX + 30);
				usedX += 50;
				label_33.setLayoutY(sY + 485);
				label_33.setFont(new Font("黑体", 12));
				label_33.setTextFill(Color.BLUE);
				label_33.setOnMousePressed(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						if (isSearch) {
							showSearchItem(page - 1);
						} else
							showItem(page - 1);
					}
				});
				root.getChildren().add(label_33);
			}

			Label label_44 = new Label(Integer.toString(page + 1) + " ");
			label_44.setLayoutX(sX + usedX + 30);
			usedX += 50;
			label_44.setLayoutY(sY + 485);
			label_44.setFont(new Font("黑体", 12));
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
						if (isSearch) {
							showSearchItem(page + 1);
						} else
							showItem(page + 1);
					}
				});
				root.getChildren().add(label_33);

				Label label_22 = new Label("下一页 ");
				label_22.setLayoutX(sX + usedX + 30);
				usedX += 40;
				label_22.setLayoutY(sY + 485);
				label_22.setFont(new Font("黑体", 12));
				label_22.setTextFill(Color.BLUE);
				label_22.setOnMousePressed(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						if (isSearch) {
							showSearchItem(page + 1);
						} else
							showItem(page + 1);
					}
				});
				root.getChildren().add(label_22);

				Label label_11 = new Label(" 尾页");
				label_11.setLayoutX(sX + usedX + 30);
				usedX += 50;
				label_11.setLayoutY(sY + 485);
				label_11.setFont(new Font("黑体", 12));
				label_11.setTextFill(Color.BLUE);
				label_11.setOnMousePressed(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						if (isSearch) {
							showSearchItem(endPage);
						} else
							showItem(endPage);
					}
				});
				root.getChildren().add(label_11);
			}
		}
		return root;
	}

	public void showSearchItem(int page) {
		isSearch = true;
		createButton();
		if (root.getChildren().contains(locationPane)) {
			root.getChildren().remove(locationPane);
		}

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

		ArrayList<GoodsVO> list = null;
		try {
			list = (controller.search(tf_search.getText().trim()));
			// System.out.println(VOtoShow.size());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		if (list == null || list.size() == 0) {
			return;
		}

		int num = 0;
		for (int i = pageSize * page; i < list.size() && i < (page + 1) * pageSize; i++) {
			myPane_goods V = new myPane_goods();
			V.page = page;
			V.item = (list.get(i));
			V.make();
			V.setLayoutX(0);
			V.setLayoutY(100 * num + 0);
			itemsPane.getChildren().add(V);
			num++;
		}
		itemsPane = createPageSelect(itemsPane, page);

	}

	public void showNowLocation() throws RemoteException {
		if (root.getChildren().contains(locationPane)) {
			root.getChildren().remove(locationPane);
		}

		locationPane = new Pane();
		locationPane.setLayoutX(30);
		locationPane.setLayoutY(120);

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
		label_11.setFont(new Font("黑体", 11));
		locationPane.getChildren().add(label_11);

		int num = 0;
		for (int i = route.size() - 1; i >= 0; i--) {

			GoodsClassVO tp = (route.get(i));
			Label label_t = new Label(">>" + tp.getName());
			label_t.setLayoutX(30 + num * 70);
			label_t.setLayoutY(5);
			label_t.setFont(new Font("黑体", 12));
			num++;
			if (i != 0) {
				label_t.setTextFill(Color.BLUE);
				label_t.setOnMousePressed(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						nowClass = tp;
						showItem(0);
					}
				});
			}

			locationPane.getChildren().add(label_t);
		}

		root.getChildren().add(locationPane);

	}

	public String goRoot() {
		ArrayList<String> route = new ArrayList<String>();
		return null;
	}

	public void showTip(String message) {
		try {
			QiPaoUI.showTip(root, message);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public void initData() {

		File directory = new File("");// 设定为当前文件夹
		try {

			Path = directory.getCanonicalPath();

		} catch (Exception e) {
		}

		// controller=new GoodsManageBLServiceStub();
		try {
			nowClass = controller.getRoot();
			System.out.println(nowClass.getID());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

	/**
	 * 用于显示goodsclass的itemPane 每一条表示一条goodsclass信息
	 * 
	 * @author Eli
	 *
	 */
	public class myPane_goodsClass extends Pane {
		GoodsClassVO item;
		myPane_goodsClass thisPane = this;
		int page = 0;

		public void make() {

			this.setMaxHeight(100);
			this.setMinHeight(100);
			this.setMaxWidth(640);

			Line line1 = new Line();
			line1.setStartX(0);
			line1.setStartY(1);
			line1.setEndX(640);
			line1.setEndY(1);
			line1.setStrokeWidth(0.1);
			this.getChildren().add(line1);
			if (item == null) {
				System.out.println("item=null");
			}
			if (item.getImagePath() == null) {
				item.setImage("img\\default\\test.png");
			}

			System.out.println(item.getImagePath() + ".....");
			Image image4 = new Image("file:" + item.getImagePath());

			Label label_img = new Label("", new ImageView(image4));
			label_img.setMaxHeight(80);
			label_img.setMaxWidth(80);
			label_img.setLayoutX(10);
			label_img.setLayoutY(10);
			this.getChildren().add(label_img);

			if (item.getName() == null) {
				item.setName("default");
			}

			Label label_Name = new Label("【分类】 " + item.getName());
			label_Name.setFont(new Font(14));
			label_Name.setLayoutX(150);
			label_Name.setLayoutY(17);
			this.getChildren().add(label_Name);

			Label label_ID = new Label("ID: " + item.getID());
			label_ID.setTextFill(Color.DARKSLATEGREY);
			label_ID.setFont(new Font(11));
			label_ID.setLayoutX(350);
			label_ID.setLayoutY(19);
			this.getChildren().add(label_ID);

			Line line2 = new Line();
			line2.setStartX(150);
			line2.setStartY(40);
			line2.setEndX(600);
			line2.setEndY(40);
			line2.setStrokeWidth(1);
			this.getChildren().add(line2);

			Label label_edit = new Label("编辑");
			label_edit.setFont(new Font(12));
			label_edit.setTextFill(Color.DARKGRAY);
			label_edit.setLayoutX(610);
			label_edit.setLayoutY(10);
			label_edit.setOnMousePressed(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					CreateGoodsClassUI ui = new CreateGoodsClassUI();
					ui.goodsClass = item;
					ui.isEdit = true;
					ui.father = me;
					ui.start(new Stage());
				}
			});
			label_edit.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					Label obj = (Label) e.getSource();
					obj.setBackground(new Background(new BackgroundFill(Color.BISQUE, null, null)));
				}
			});
			label_edit.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					Label obj = (Label) e.getSource();
					obj.setBackground(null);
				}
			});
			this.getChildren().add(label_edit);

			this.setOnMousePressed(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					if (e.getX() < 600) {
						System.out.println((item instanceof GoodsVO));
						if (!(item instanceof GoodsVO)) {
							nowClass = item;
							showItem(0);
						}

					}

				}
			});
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
			Label label_delete = new Label("删除");
			label_delete.setFont(new Font(12));
			label_delete.setTextFill(Color.DARKGRAY);
			label_delete.setLayoutX(610);
			label_delete.setLayoutY(40);
			label_delete.setOnMousePressed(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					TipUI.showConfirmDialog(thisStage, "您确定要删除这个分类吗？", "confirm");
					if (TipUI.buttonSelected == TipUI.Response.YES) {
						try {
							controller.delete(item.getID());
							showItem(nowPage);
							QiPaoUI.showTip(root, "删除成功");
						} catch (IOException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}

					}

				}
			});
			label_delete.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					Label obj = (Label) e.getSource();
					obj.setBackground(new Background(new BackgroundFill(Color.BISQUE, null, null)));
				}
			});
			label_delete.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					Label obj = (Label) e.getSource();
					obj.setBackground(null);
				}
			});
			this.getChildren().add(label_delete);
		}
	}

	/**
	 * 用于显示goods的itemPane 每一条表示一条goods信息
	 * 
	 * @author Eli
	 *
	 */
	public class myPane_goods extends myPane_goodsClass {
		GoodsVO item;
		myPane_goodsClass me = this;
		int page = 0;

		@Override
		public void make() {
			me.setMaxHeight(100);
			me.setMaxWidth(640);
			Line line1 = new Line();
			line1.setStartX(0);
			line1.setStartY(1);
			line1.setEndX(640);
			line1.setEndY(1);
			line1.setStrokeWidth(0.1);
			me.getChildren().add(line1);

			if (item.getImagePath() == null) {
				item.setImage("img\\default\\test.png");
			}

			System.out.println(item.getImagePath() + ".....");
			Image image42 = new Image("file:" + item.getImagePath());

			Label label_img = new Label("", new ImageView(image42));
			label_img.setMaxHeight(80);
			label_img.setMaxWidth(80);
			label_img.setLayoutX(10);
			label_img.setLayoutY(10);
			me.getChildren().add(label_img);
			if (item.getName() == null) {
				item.setName("default");
			}
			Label label_Name = new Label("名称：" + item.getName());
			label_Name.setFont(new Font(12));
			label_Name.setLayoutX(120);
			label_Name.setLayoutY(7);
			me.getChildren().add(label_Name);

			Label label_ID = new Label("ID：" + item.getID());
			label_ID.setFont(new Font(12));
			label_ID.setLayoutX(270);
			label_ID.setLayoutY(7);
			me.getChildren().add(label_ID);

			Label label_type = new Label("型号：" + item.getType());
			label_type.setFont(new Font(12));
			label_type.setLayoutX(400);
			label_type.setLayoutY(7);
			me.getChildren().add(label_type);

			Label label_Num = new Label("数量：" + item.getNumbers());
			label_Num.setFont(new Font(12));
			label_Num.setLayoutX(120);
			label_Num.setLayoutY(30);
			me.getChildren().add(label_Num);

			Label label_recentBuyPrice = new Label("最近进价：" + item.getRecentBuyingPrice());
			label_recentBuyPrice.setFont(new Font(12));
			label_recentBuyPrice.setLayoutX(270);
			label_recentBuyPrice.setLayoutY(30);
			me.getChildren().add(label_recentBuyPrice);

			Label label_recentsalePrice = new Label("最近售价：" + item.getRecentSalePrice());
			label_recentsalePrice.setFont(new Font(12));
			label_recentsalePrice.setLayoutX(400);
			label_recentsalePrice.setLayoutY(30);
			me.getChildren().add(label_recentsalePrice);

			Label label_alarm = new Label("警戒值：" + item.getAlarmingValue());
			label_alarm.setFont(new Font(12));
			label_alarm.setLayoutX(120);
			label_alarm.setLayoutY(53);
			me.getChildren().add(label_alarm);

			Label label_BuyPrice = new Label("综合进价：" + item.getBuyingPrice());
			label_BuyPrice.setFont(new Font(12));
			label_BuyPrice.setLayoutX(270);
			label_BuyPrice.setLayoutY(53);
			me.getChildren().add(label_BuyPrice);

			Label label_salePrice = new Label("综合售价：" + item.getSalePrice());
			label_salePrice.setFont(new Font(12));
			label_salePrice.setLayoutX(400);
			label_salePrice.setLayoutY(53);
			me.getChildren().add(label_salePrice);

			Label label_edit = new Label("编辑");
			label_edit.setFont(new Font(12));
			label_edit.setTextFill(Color.DARKGRAY);
			label_edit.setLayoutX(610);
			label_edit.setLayoutY(10);
			label_edit.setOnMousePressed(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {

				}
			});
			me.getChildren().add(label_edit);

			this.setOnMousePressed(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					try {
						if (e.getX() < 600) {
							GoodsMessageUI ui = new GoodsMessageUI();
							ui.thisGoods = (GoodsVO) item;
							System.out.println(((GoodsVO) item).getName());
							ui.start(new Stage());
							if (ui.confirm) {
								showItem(nowPage);
								QiPaoUI.showTip(root, "操作成功");

							}

						}
					} catch (Exception e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}
			});
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
			Label label_delete = new Label("删除");
			label_delete.setFont(new Font(12));
			label_delete.setTextFill(Color.DARKGRAY);
			label_delete.setLayoutX(610);
			label_delete.setLayoutY(40);
			label_delete.setOnMousePressed(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {

					TipUI.showConfirmDialog(thisStage, "你确定要删除吗？", "confirm");
					if (TipUI.buttonSelected == TipUI.Response.YES) {
						try {
							controller.delete(item.getID());
						} catch (RemoteException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
						showItem(me.page);
						showTip("成功删除" + item.getName());
					}

				}
			});
			label_delete.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					Label obj = (Label) e.getSource();
					obj.setBackground(new Background(new BackgroundFill(Color.BISQUE, null, null)));
				}
			});
			label_delete.setOnMouseExited(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent e) {
					Label obj = (Label) e.getSource();
					obj.setBackground(null);
				}
			});
			me.getChildren().add(label_delete);

		}
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

	public void delete() {

	}

}