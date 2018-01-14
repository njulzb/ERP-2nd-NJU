package presentation.receiptUI;

import java.util.ArrayList;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import presentation.littleUI.HELP.OnlyDoubleTextField;
import presentation.littleUI.HELP.OnlyIntTextField;
import presentation.stockUI.GoodsManage.GoodsSelectorUI;
import vo.Form.stockFormVO.StockItemVO;

public class StockItemPane extends ItemPane {

	public boolean editAble = false;
	public StockItemVO item;

	private StockItemPane me = this;
	private OnlyIntTextField tf_num;
	private OnlyDoubleTextField tf_money;
	private Label label_itemSum;
	private DoubleProperty moneyOne = new SimpleDoubleProperty(0);
	private IntegerProperty num = new SimpleIntegerProperty(0);

	public StockItemPane(StockItemVO item, boolean editAble) {
		this.item = item;
		this.editAble = editAble;
		make();
	}

	public void make() {
		me.setMinWidth(515);
		me.setMinHeight(30);
		me.setMaxWidth(515);

		Line line1 = new Line();
		line1.setStartX(0);
		line1.setStartY(1);
		line1.setEndX(540);
		line1.setEndY(1);
		line1.setStrokeWidth(0.1);
		me.getChildren().add(line1);

		StockItemVO vo = (StockItemVO) item;
		if (editAble) {
			me.setOnMousePressed(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					if(e.getX()<30) {
						return;
					}
					GoodsSelectorUI u = new GoodsSelectorUI();
					u.showSelectorDialog(new Stage(), "ERP");
					vo.setGoods(u.VO);
					
					vo.getGoods().setNumbers(0);
					remake();
				}
			});
		}

		if (vo.getGoods() == null) {
			Label label_buttonGoodsSelect = new Label("点击这里，选择一个商品……");
			label_buttonGoodsSelect.setFont(new Font(12));
			label_buttonGoodsSelect.setLayoutX(33);
			label_buttonGoodsSelect.setLayoutY(3);
			me.getChildren().add(label_buttonGoodsSelect);
		} else {
			Label label_goodsName = new Label(vo.getGoods().getName());
			label_goodsName.setLayoutX(40);
			label_goodsName.setLayoutY(5);
			me.getChildren().add(label_goodsName);

			Label label_ID = new Label(vo.getGoods().getID());
			label_ID.setLayoutX(150);
			label_ID.setLayoutY(5);
			me.getChildren().add(label_ID);

			Label l_money = new Label(vo.getGoods().getBuyingPrice() + "");
			l_money.setLayoutX(240);
			l_money.setLayoutY(5);
			me.getChildren().add(l_money);
			
			if (editAble) {
				tf_num = new OnlyIntTextField(vo.getGoods().getNumbers() + "");
				tf_num.setLayoutX(330);
				tf_num.setPrefWidth(80);
				tf_num.setLayoutY(5);
				me.getChildren().add(tf_num);
				createCommitBinding(tf_num).addListener((obs, oldText, newText) -> updateMessage());
				
			
			} else {
				
				Label l_num = new Label(vo.getGoods().getNumbers() + "");
				l_num.setLayoutX(330);
				l_num.setLayoutY(5);
				me.getChildren().add(l_num);
			}
			
			label_itemSum = new Label(vo.getGoods().getBuyingPrice()* tf_num.value + "");
			label_itemSum.setLayoutX(450);
			label_itemSum.setLayoutY(5);
			me.getChildren().add(label_itemSum);

		}

	}

	public void remake() {
		me.getChildren().removeAll(me.getChildren());
		make();
	}

	private StringBinding createCommitBinding(TextField textField) {
		StringBinding binding = Bindings.createStringBinding(() -> textField.getText());

		textField.addEventHandler(ActionEvent.ACTION, evt -> binding.invalidate());

		textField.focusedProperty().addListener((obs, wasFocused, isFocused) -> {
			if (!isFocused)
				binding.invalidate();
		});
		return binding;
	}

	public ArrayList<String> updateMessage() {
		ArrayList<String> out = new ArrayList<String>();

		if (item.getGoods() == null) {
			System.out.println("第"+(getNo()+1)+"条中商品不能为空");
			out.add("第"+(getNo()+1)+"条中商品不能为空");
		} else {
			
			if (tf_num != null) {
				item.getGoods().setNumbers(tf_num.value);
				System.out.println("item.getGoods().numbers ="+tf_num.value);
			}
			
		}
		return out;

	}
}
