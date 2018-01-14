package presentation.reportUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import BL.reportBL.ReportController;
import BL.reportBL.Stub.ReportBLServiceStub;
import BLService.reportBLService.ReportBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import presentation.littleUI.TipUI;
import utility.LOG;
import vo.report.ManageStateReportVO;

public class stateReportController implements Initializable {
	@FXML
	private Label income_sale, out_sale, income_goods, out_goods, income_total, out_total, discount, profit;
	
	@FXML
    private Button btn_export;
	
	@FXML
    private Button btn_search;
	
	@FXML
	private DatePicker startT;
	
	@FXML
	private DatePicker endT;
	
	private Date begin, end;
	private ManageStateReportVO s;
	private String Path = null;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void export(ActionEvent event)throws Exception{
		if(begin == null || end == null){
			TipUI.showMessageDialog(new Stage(), "您未选择时间区间", "Warning Dialog");
		}	
		if(begin != null && end != null){
			if(begin.getTime()>end.getTime()){
				TipUI.showMessageDialog(new Stage(), "请选择正确的时间区间", "Warning Dialog");
			}
			else{
				DirectoryChooser directoryChooser = new DirectoryChooser();
		    	directoryChooser .setTitle("Open Resource File");
		    	File file = directoryChooser .showDialog(new Stage());
		    	
		    	try {
		    		Path = file.getCanonicalPath();
					//System.out.println( file.getCanonicalPath());
					//tf_filePath.setText(Path);
		    	} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				};
				ReportBLService rbls = new ReportController();
		    	if(rbls.ExportReport(s, Path)){
		    		TipUI.showMessageDialog(new Stage(), "导出成功！", "ERPsystem");
		    		LOG.addLog("导出了经营情况表", "161250088");
		    	}           	
					
			}
		}		
	}
	
	@FXML
	public void search(ActionEvent event)throws Exception{
		//s = new ManageStateReportVO(begin, end, 0, 0, 0, 0, 0);
		//ReportBLService rbls = new ReportController();
		//s = rbls.getManageState(begin, end);
		//double salein = s.getSaleIncome(), saleout = s.getSaleCost(), goodsin = s.getGoodsIncome(), goodsout = s.getGoodsExpense();
		if(begin == null || end == null){
			TipUI.showMessageDialog(new Stage(), "您未选择时间区间", "Warning Dialog");
		}	
		if(begin != null && end != null){
			if(begin.getTime()>end.getTime()){
				TipUI.showMessageDialog(new Stage(), "请选择正确的时间区间", "Warning Dialog");
			}
			else{
				showList();
			}
			
		}
			
	}
	
	@FXML
	public void btn_exportEntered(MouseEvent e){
		btn_export.setScaleX(0.9);
		btn_export.setScaleY(0.9);
	}
	
	@FXML
	public void btn_exportExited(MouseEvent e){
		btn_export.setScaleX(1);
		btn_export.setScaleY(1);
	}
	
	@FXML
	public void btn_searchEntered(MouseEvent e){
		btn_search.setScaleX(0.9);
		btn_search.setScaleY(0.9);
	}
	
	@FXML
	public void btn_searchExited(MouseEvent e){
		btn_search.setScaleX(1);
		btn_search.setScaleY(1);
	}
	
	@FXML
	public Date getStartTime(ActionEvent event){
		java.time.LocalDate l = startT.getValue();
		ZoneId zone = ZoneId.systemDefault();
		Instant instant = l.atStartOfDay().atZone(zone).toInstant();
	    begin = Date.from(instant);
	    //System.out.println(begin);
		return begin;
		
	}
	
	@FXML
	public Date getEndTime(ActionEvent event){
		java.time.LocalDate l = endT.getValue();
		ZoneId zone = ZoneId.systemDefault();
		Instant instant = l.atStartOfDay().atZone(zone).toInstant();
	    end = Date.from(instant);
		return end;
		
	}
	public void showList(){
		income_sale.setText(String.valueOf(3005.6));
		income_goods.setText(String.valueOf(1080));
		income_total.setText(String.valueOf(4085.6));
		discount.setText(String.valueOf(808.4));
		out_sale.setText(String.valueOf(1689));
		out_goods.setText(String.valueOf(1023));
		out_total.setText(String.valueOf(2712));
		profit.setText(String.valueOf(2182));
	}


}
