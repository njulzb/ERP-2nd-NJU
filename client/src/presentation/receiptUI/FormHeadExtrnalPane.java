package presentation.receiptUI;

import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import presentation.littleUI.HELP.CustomerSelectPane;
import presentation.littleUI.HELP.OnlyDoubleTextField;
import vo.CustomerVO;
import vo.Form.FormVO;
import vo.Form.FinanceFormVO.FinanceFormVO;
import vo.Form.stockFormVO.PresentFormVO;
import vo.Form.tradeFormVO.TradeFormVO;

public class FormHeadExtrnalPane extends Pane {
	public FormVO vo;

	private boolean editAble = true;
	private FormHeadExtrnalPane root = this;
	CustomerSelectPane cusSP;
	OnlyDoubleTextField tf_zr, tf_djq;

	public FormHeadExtrnalPane() {

	}

	public FormHeadExtrnalPane(FormVO vo, boolean editAble) {
		this.vo = vo;
		this.editAble = editAble;
		make();
		updateMessage();
	}

	public ArrayList<String> updateMessage() {
		ArrayList<String> out = new ArrayList<String>();
		if (cusSP != null) {
			CustomerVO tpCus = cusSP.getCustomer();
			if (tpCus == null) {
				out.add("未选择客户");
			} else {
				vo.setCustomer(tpCus);
			}
		}
		if (tf_zr != null) {
			vo.setMoneyZheRang(tf_zr.value);
		}
		if (tf_zr != null) {
			vo.setMoneyDaiJinQuan(tf_djq.value);
		}
		return  out ;
	}

	public void make() {
		double yUsed = 0;
		//
		///////////// 客户部分
		//
		if (vo instanceof TradeFormVO || vo instanceof FinanceFormVO || vo instanceof PresentFormVO) {
			Label label_customer = new Label("客户");
			label_customer.setLayoutX(0);
			label_customer.setLayoutY(0);
			label_customer.setFont(new Font("黑体", 13));
			root.getChildren().add(label_customer);

			if (editAble) {
				cusSP = new CustomerSelectPane();
				cusSP.setCustomer(vo.getCustomer());
				cusSP.setSize(70, 0, 22, 130);
				root.getChildren().add(cusSP);
			} else {
				Label label_customerVal = new Label("" + vo.getCustomer().getName());
				label_customerVal.setLayoutX(70);
				label_customerVal.setLayoutY(0);
				label_customerVal.setFont(new Font("黑体", 13));
				root.getChildren().add(label_customerVal);
			}
			yUsed += 30;
		}
		///////////////////////////////////
		// 折让、代金券 部分 //
		//////////////////////////////////
		if (vo instanceof TradeFormVO) {
			Label label_zr = new Label("折让金额");
			label_zr.setLayoutX(0);
			label_zr.setLayoutY(yUsed);
			label_zr.setFont(new Font("黑体", 13));
			root.getChildren().add(label_zr);

			if (editAble) {
				tf_zr = new OnlyDoubleTextField(((TradeFormVO) vo).getMoneyZheRang() + "");
				tf_zr.setLayoutX(70);
				tf_zr.setLayoutY(yUsed);
				root.getChildren().add(tf_zr);

			} else {
				Label label_zrVal = new Label(((TradeFormVO) vo).getMoneyZheRang() + "");
				label_zrVal.setLayoutX(70);
				label_zrVal.setLayoutY(yUsed);
				label_zrVal.setFont(new Font("黑体", 13));
				root.getChildren().add(label_zrVal);
			}
			yUsed += 30;

			Label label_djq = new Label("代金券金额");
			label_djq.setLayoutX(0);
			label_djq.setLayoutY(yUsed);
			label_djq.setFont(new Font("黑体", 13));
			root.getChildren().add(label_djq);

			if (editAble) {
				tf_djq = new OnlyDoubleTextField(((TradeFormVO) vo).getMoneyDaiJinQuan() + "");
				tf_djq.setLayoutX(70);
				tf_djq.setLayoutY(yUsed);
				root.getChildren().add(tf_djq);

			} else {
				Label label_djqVal = new Label(((TradeFormVO) vo).getMoneyDaiJinQuan() + "");
				label_djqVal.setLayoutX(70);
				label_djqVal.setLayoutY(yUsed);
				label_djqVal.setFont(new Font("黑体", 13));
				root.getChildren().add(label_djqVal);
			}
			yUsed += 30;
		}

	}
}
