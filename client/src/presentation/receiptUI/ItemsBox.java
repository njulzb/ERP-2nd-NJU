package presentation.receiptUI;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import presentation.littleUI.HELP.MyButton;
import vo.Form.FormVO;
import vo.Form.FinanceFormVO.FinanceFormVO;
import vo.Form.FinanceFormVO.TransItemVO;
import vo.Form.stockFormVO.StockFormVO;
import vo.Form.stockFormVO.StockItemVO;
import vo.Form.tradeFormVO.TradeFormVO;
import vo.Form.tradeFormVO.TradeItemVO;

public class ItemsBox extends Pane {

	private FormVO vo;
	private boolean editAble = false;
	private ScrollPane sp = new ScrollPane();
	private ItemsBox me = this;
	private ArrayList<ItemPane> itemList = new ArrayList<ItemPane>();
	private Label label_sum;

	public ItemsBox(FormVO vo, boolean editAble) {
		this.vo = vo;
		this.editAble = editAble;
		make();
	}

	public void make() {
		me.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				updateSum();
			}
		});

		reMakeSP();

		MyButton button_new = new MyButton("新增", 20, 80);
		button_new.setLayoutX(0);
		button_new.setLayoutY(320);
		button_new.setOnAction((ActionEvent event) -> {
			updateMessage();
			if (vo instanceof FinanceFormVO) {
				((FinanceFormVO) vo).getTransList().add(new TransItemVO());
			} else if (vo instanceof StockFormVO) {
				((StockFormVO) vo).getGoodsList().add(new StockItemVO());
			} else if (vo instanceof TradeFormVO) {
				((TradeFormVO) vo).getGoodsList().add(new TradeItemVO());
			}
			reMakeSP();
		});

		me.getChildren().add(button_new);

		label_sum = new Label("总额" + 0);
		label_sum.setLayoutX(470);
		label_sum.setLayoutY(320);
		me.getChildren().add(label_sum);

		if(!editAble) {
			button_new.setVisible(false);
		}
		
	}

	public ArrayList<String> updateMessage() {
		updateSum();
		ArrayList<String> out = new ArrayList<String>();
		for (ItemPane ip : itemList) {
			out.addAll(ip.updateMessage());
		}
		return out;

	}

	public void updateSum() {
		double sum = 0;
		if (vo instanceof FinanceFormVO) {
			for (TransItemVO v : ((FinanceFormVO) vo).getTransList()) {
				if (v.getBankAccount() != null)
					sum += v.getMoney();
			}
			((FinanceFormVO) vo).setSum(sum);
		} else if (vo instanceof StockFormVO) {
			for (StockItemVO v : ((StockFormVO) vo).getGoodsList()) {
				if (v.getGoods() != null)
					sum += v.getGoods().getBuyingPrice() * v.getGoods().getNumbers();
			}
			((StockFormVO) vo).setSum(sum);
		} else if (vo instanceof TradeFormVO) {
			for (TradeItemVO v : ((TradeFormVO) vo).getGoodsList()) {
				if (v.getGoods() != null)
					sum += v.getPriceOne() * v.getGoods().getNumbers();
			}
			((TradeFormVO) vo).setSumMoney(sum);
		}
		System.out.println("sum=" + sum);
		if (label_sum != null) {
			label_sum.setText("总额" + sum + "");
		}
	}

	public void reMakeSP() {
		updateSum();
		itemList.clear();
		if (sp != null && me.getChildren().contains(sp)) {
			me.getChildren().remove(sp);
		}
		sp = new ScrollPane();
		sp.setLayoutX(0);
		sp.setMinWidth(540);
		sp.setMaxWidth(540);
		sp.setMinHeight(300);
		sp.setMaxHeight(300);
		sp.setLayoutY(0);
		VBox vb = new VBox();

		sp.setVmax(440);
		sp.setPrefSize(115, 150);
		sp.setContent(vb);
		me.getChildren().add(sp);

		if (vo instanceof TradeFormVO) {
			int num = ((TradeFormVO) vo).getGoodsList().size();
			Image c = new Image("file:img//receipt//formFH_Tra.png");
			Label label_FH = new Label("", new ImageView(c));
			vb.getChildren().add(label_FH);
			for (int i = 0; i < num; i++) {
				TradeItemVO temp = ((TradeFormVO) vo).getGoodsList().get(i);
				TradeItemPane tp = new TradeItemPane(temp, editAble);
				Label label_delete = new Label("删除");
				label_delete.setLayoutY(3);
				label_delete.setOnMousePressed(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						((TradeFormVO) vo).getGoodsList().remove(temp);
						reMakeSP();
					}
				});
				tp.getChildren().add(label_delete);

				tp.setNo(i);
				itemList.add(tp);
				vb.getChildren().add(tp);
			}
		} else if (vo instanceof StockFormVO) {
			int num = ((StockFormVO) vo).getGoodsList().size();
			
			Image c = new Image("file:img//receipt//formFH_Sto.png");
			Label label_FH = new Label("", new ImageView(c));
			vb.getChildren().add(label_FH);
			
			
			for (int i = 0; i < num; i++) {
				StockItemVO temp = ((StockFormVO) vo).getGoodsList().get(i);
				StockItemPane tp = new StockItemPane(temp, editAble);
				Label label_delete = new Label("删除");
				label_delete.setLayoutY(3);
				label_delete.setOnMousePressed(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						((StockFormVO) vo).getGoodsList().remove(temp);
						reMakeSP();
					}
				});
				tp.getChildren().add(label_delete);
				tp.setNo(i);
				itemList.add(tp);
				vb.getChildren().add(tp);
			}
		} else if (vo instanceof FinanceFormVO) {
			int num = ((FinanceFormVO) vo).getTransList().size();
			
			Image c = new Image("file:img//receipt//formFH_Fin.png");
			Label label_FH = new Label("", new ImageView(c));
			vb.getChildren().add(label_FH);
			
			for (int i = 0; i < num; i++) {
				TransItemVO temp = ((FinanceFormVO) vo).getTransList().get(i);
				FinanceItemPane tp = new FinanceItemPane(temp, editAble);
				Label label_delete = new Label("删除");
				label_delete.setLayoutY(3);
				label_delete.setOnMousePressed(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						((FinanceFormVO) vo).getTransList().remove(temp);
						reMakeSP();
					}
				});
				tp.getChildren().add(label_delete);
				tp.setNo(i);
				itemList.add(tp);
				vb.getChildren().add(tp);
			}
		}
	}
}
