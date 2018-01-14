package presentation.receiptUI;

import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import presentation.littleUI.HELP.CustomerSelectPane;
import vo.Form.FormVO;
import vo.Form.stockFormVO.AlarmFormVO;

public class FormHeadPane extends Pane {
	public FormVO vo;
	public  boolean hasCustomer=true;
	
	private boolean editAble=true;
	private FormHeadPane root = this;
	private FormHeadExtrnalPane exPane ;
	public FormHeadPane() {
		
	}
	public FormHeadPane(FormVO vo,boolean editAble) {
		this.vo=vo;
		this.editAble=editAble;
		make();
	}
	public ArrayList<String> updateMessage() {
		 ArrayList<String>  out =new  ArrayList<String> ();
		
		if(exPane!=null) {
			out.addAll(exPane.updateMessage());
		}
		return  out;
	}
	public void make() {
		///////////// 编号部分
		String bianhao = "--";
		if (vo.getID() != null) {
			bianhao = vo.getID();
		}

		Label label_id = new Label("编号： " + "           " + bianhao);
		label_id.setLayoutX(0);
		label_id.setLayoutY(0);
		label_id.setFont(new Font("黑体", 13));
		root.getChildren().add(label_id);

		///////////// 操作员部分

		Label label_user = new Label("操作员");
		label_user.setLayoutX(0);
		label_user.setLayoutY(30);
		label_user.setFont(new Font("黑体", 13));
		root.getChildren().add(label_user);

		 Label label_userName = new Label(vo.getOperator().getName());
		 label_userName.setLayoutX( 70);
		 label_userName.setLayoutY( 30);
		 label_userName.setFont(new Font("黑体", 15));
		 root.getChildren().add(label_userName);

		 ////////// extrnalPane
		 if(!(vo instanceof AlarmFormVO)) {
			 exPane =new  FormHeadExtrnalPane (vo,editAble);
			 exPane.setLayoutX(0);
			 exPane.setLayoutY(60);
			 root.getChildren().add(exPane);
		 }
		 
		 
		 
		///////////// 创建时间部分

		Label label_createTime = new Label("创建时间");
		label_createTime.setLayoutX(260);
		label_createTime.setLayoutY(0);
		label_createTime.setFont(new Font("黑体", 13));
		root.getChildren().add(label_createTime);

		Label label_createTimeValue = new Label(vo.getCreateTime().toString());
		label_createTimeValue.setLayoutX(330);
		label_createTimeValue.setLayoutY(0);
		label_createTimeValue.setFont(new Font("黑体", 13));
		root.getChildren().add(label_createTimeValue);

		/////////////////// 最后保存时间
		Label label_lastSaveTime = new Label("上次保存");
		label_lastSaveTime.setLayoutX(260);
		label_lastSaveTime.setLayoutY(30);
		label_lastSaveTime.setFont(new Font("黑体", 13));
		root.getChildren().add(label_lastSaveTime);

		String savetime = "---";
		if (vo.getSaveTime() != null) {
			savetime = vo.getSaveTime().toString();
		}
		Label label_lastSaveTimeValue = new Label(savetime);
		label_lastSaveTimeValue.setLayoutX(330);
		label_lastSaveTimeValue.setLayoutY(30);
		label_lastSaveTimeValue.setFont(new Font("黑体", 13));
		root.getChildren().add(label_lastSaveTimeValue);

		/////////////////// 驳回时间
		Label label_rejectTime = new Label("驳回时间");
		label_rejectTime.setLayoutX(260);
		label_rejectTime.setLayoutY(60);
		label_rejectTime.setFont(new Font("黑体", 13));
		root.getChildren().add(label_rejectTime);

		String rejecttime = "---";
		if (vo.getRejectTime() != null) {
			rejecttime = vo.getRejectTime().toString();
		}

		Label label_rejectTimeValue = new Label(rejecttime);
		label_rejectTimeValue.setLayoutX(330);
		label_rejectTimeValue.setLayoutY(60);
		label_rejectTimeValue.setFont(new Font("黑体", 13));
		root.getChildren().add(label_rejectTimeValue);

		/////////////////// 生效时间
		Label label_passTime = new Label("生效时间");
		label_passTime.setLayoutX(260);
		label_passTime.setLayoutY(90);
		label_passTime.setFont(new Font("黑体", 13));
		root.getChildren().add(label_passTime);

		String passtime = "---";
		if (vo.getPassTime() != null) {
			passtime = vo.getPassTime().toString();
		}

		Label label_passTimeValue = new Label(passtime);
		label_passTimeValue.setLayoutX(330);
		label_passTimeValue.setLayoutY(90);
		label_passTimeValue.setFont(new Font("黑体", 13));
		root.getChildren().add(label_passTimeValue);
	}
}
