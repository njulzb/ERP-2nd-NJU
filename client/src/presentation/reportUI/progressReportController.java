package presentation.reportUI;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import BL.reportBL.ReportController;
import BL.reportBL.Stub.ReportBLServiceStub;
import BLService.reportBLService.ReportBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import vo.Form.FormVO;
import vo.report.KeyForSearchReport;
import vo.report.ManageProgressReportVO;

public class progressReportController implements Initializable{
	private KeyForSearchReport k;
	@FXML
	private ScrollPane listPane;
	
	@FXML
    private Button btn_export;
	
	@FXML
    private Button btn_select;
	
	@FXML
    private TextField key;	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void export(ActionEvent event)throws Exception{
		
		exportUI export = new exportUI();
		
		export.start(new Stage());
	}
	
	@FXML
	public void select(ActionEvent event)throws Exception{
		ArrayList<FormVO> list = new ArrayList<FormVO>();
		KeyForSearchReport k = getKey();
		ReportBLService reportBLService = new ReportController();
		ManageProgressReportVO manageProgressReportVO = new ManageProgressReportVO(null, null, null, null);
		manageProgressReportVO = reportBLService.getManageProgress(k);
		for(int i=0;i<manageProgressReportVO.getFinanceList().size();i++){
			list.add(manageProgressReportVO.getFinanceList().get(i));
		}
		for(int i=0;i<manageProgressReportVO.getImportList().size();i++){
			list.add(manageProgressReportVO.getImportList().get(i));
		}
		for(int i=0;i<manageProgressReportVO.getSaleList().size();i++){
			list.add(manageProgressReportVO.getSaleList().get(i));
		}
		for(int i=0;i<manageProgressReportVO.getStockList().size();i++){
			list.add(manageProgressReportVO.getStockList().get(i));
		}
		
		progressReportUI pr = new progressReportUI();
		Pane root  = pr.progressReportUI(new Stage());
		//root.setLayoutX(value);
		//listPane = root;
		
		
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
	public void btn_selectEntered(MouseEvent e){
		btn_select.setScaleX(0.9);
		btn_select.setScaleY(0.9);
	}
	
	@FXML
	public void btn_selectExited(MouseEvent e){
		btn_select.setScaleX(1);
		btn_select.setScaleY(1);
	}
	
	@FXML
	public KeyForSearchReport getKey(){		
		String text = key.getText();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		Date d = null;
		try {
			d = simpleDateFormat.parse(text);
		    k = new KeyForSearchReport(null, d, d, null, null, null, null);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			k = new KeyForSearchReport(null, d, d, text, null, null, text);
			e.printStackTrace();
		}
		
	    return k;
	}
	

}
