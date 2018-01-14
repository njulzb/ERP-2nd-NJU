package presentation.strategyUI;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import BL.strategyBL.StrategyController;
import BLService.strategyBLService.StrategyBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import presentation.littleUI.QiPaoUI;
import presentation.littleUI.TipUI;
import presentation.mainUI.UIController;
import utility.LOG;
import utility.LevelOfCustomer;
import vo.strategy.CustomerStrategyVO;

public class CustomerStrategyInfoController implements Initializable{
	@FXML
	private Label titleLabel, startTime, duration, level, discount, gift;
	
	@FXML
	private Button btn_delete, btn_modify;
	
	private CustomerStrategyVO strategy;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void delete(ActionEvent event)throws Exception{
		TipUI.showConfirmDialog(UIController.getUIStage(), "你真的要删除此项吗？", "Confirm Dialog");
		if (TipUI.buttonSelected == TipUI.Response.YES) {
			QiPaoUI notice = new QiPaoUI();
			try {
				notice.showTip((Pane)UIController.getUIController().getUIStage().getScene().getRoot(), "成功删除策略"+ strategy.getID());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			strategyManageUI s = new strategyManageUI();
			s.deleteS();
			s.getStrategyManageUIPane(UIController.getUIController().getUIStage());
			LOG.addLog("删除策略"+strategy.getID(), "161250088");
		}
	}
	
	@FXML
	public void enterDelete(MouseEvent e){
		btn_delete.setLayoutX(btn_delete.getLayoutX()+2);
		btn_delete.setLayoutY(btn_delete.getLayoutY()+2);
	}
	
	@FXML
	public void exitDelete(MouseEvent e){
		btn_delete.setLayoutX(btn_delete.getLayoutX()-2);
		btn_delete.setLayoutY(btn_delete.getLayoutY()-2);
	}
	
	@FXML
	public void modify(ActionEvent event)throws Exception{
		TipUI.showConfirmDialog(UIController.getUIStage(), "你真的要修改这些数据吗？", "Confirm Dialog");
		if (TipUI.buttonSelected == TipUI.Response.YES) {
			QiPaoUI notice = new QiPaoUI();
			try {
				notice.showTip((Pane)UIController.getUIController().getUIStage().getScene().getRoot(), "成功修改策略"+ strategy.getID() +"的相关信息");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LOG.addLog("修改策略"+strategy.getID(), "161250088");
		}
	}
	
	@FXML
	public void enterModify(MouseEvent e){
		btn_modify.setLayoutX(btn_modify.getLayoutX()+2);
		btn_modify.setLayoutY(btn_modify.getLayoutY()+2);
	}
	
	@FXML
	public void exitModify(MouseEvent e){
		btn_modify.setLayoutX(btn_modify.getLayoutX()-2);
		btn_modify.setLayoutY(btn_modify.getLayoutY()-2);
	}

	public void setStrategy(CustomerStrategyVO vo){
		this.strategy = vo;
	}
	
	public void init(){
		this.titleLabel.setText(strategy.getID());
		Date d = strategy.getStartTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(d);
		this.startTime.setText(time);
		this.duration.setText(String.valueOf(45));
		this.discount.setText(String.valueOf(858.5));
		if(convert(strategy.getBeginLevel()).equals(convert(strategy.getEndLevel()))){
			this.level.setText(convert(strategy.getBeginLevel()));
		}else{
			this.level.setText(convert(strategy.getBeginLevel())+" - "+convert(strategy.getEndLevel()));
		}		
		String giftName = "小台灯, 小彩灯";
		this.gift.setText(giftName);
	}
	public String convert(LevelOfCustomer loc){
		switch(loc){
		case level1:
			return "level1";
		
	    case level2:
		    return "level2";
	    
        case level3:
	        return "level3";
	        
        case level4:
        	return "level4";
        	
        case level5:
        	return "level5";	
        	
		}
		return null;
	}

}
