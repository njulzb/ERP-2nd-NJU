package presentation.reportUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import BL.reportBL.ReportController;
import BL.reportBL.Stub.ReportBLServiceStub;
import BLService.reportBLService.ReportBLService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import presentation.littleUI.TipUI;
import utility.LOG;
import vo.UserVO;
import vo.report.KeyForSearchReport;
import vo.report.ManageProgressReportVO;
import vo.report.SaleReportItemVO;
import vo.report.SaleReportVO;

public class saleReportController implements Initializable {
	public UserVO presentOperator;
	@FXML
	private Label nomoreLabel;
	
	@FXML
    private Button btn_export;
	
	@FXML
    private Button btn_select;
	
	@FXML
	private DatePicker startT, endT;
	
	@FXML
	private ScrollPane listPane;
	private Date begin, end;
	private ArrayList<Label> labelList;
	private ArrayList<SaleReportItemVO> voList;
	private int c=0;
	


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	@FXML
	public void export(ActionEvent event)throws Exception{
		if(begin==null || end == null){
			TipUI.showMessageDialog(new Stage(), "请选择时间区间", "Warning Dialog");
		}
		if(begin != null && end != null){
			if(begin.getTime()>end.getTime()){
				TipUI.showMessageDialog(new Stage(), "请选择正确的时间区间", "Warning Dialog");
			}
			else{
				DirectoryChooser directoryChooser = new DirectoryChooser();
		    	directoryChooser .setTitle("Open Resource File");
		    	File file = directoryChooser .showDialog(new Stage());
		    	String Path = "";
		    	try {
		    		Path = file.getCanonicalPath();					
		    	} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				};
			    SaleReportVO saleReportVO = new SaleReportVO(null, 0);
				ReportBLService rbls = new ReportController();
		    	try {
					if(rbls.ExportReport(saleReportVO, Path)){
						TipUI.showMessageDialog(new Stage(), "导出成功！", "ERPsystem");
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
		    	LOG.addLog("导出了销售明细表", "161250088");
			}
		}
	}
	
	@FXML
	public void select(ActionEvent event)throws Exception{
		if(begin==null || end == null){
			TipUI.showMessageDialog(new Stage(), "请选择时间区间", "Warning Dialog");
		}
		if(begin != null && end != null){
			if(begin.getTime()>end.getTime()){
				TipUI.showMessageDialog(new Stage(), "请选择正确的时间区间", "Warning Dialog");
			}
			else{
				SaleReportVO saleReportVO = null;
				KeyForSearchReport key = new KeyForSearchReport(null, begin, end, null, null, null, null);
				ReportBLService rbls = new ReportController();
				saleReportVO = rbls.getSaleReport(key);
				voList = saleReportVO.getItemList();
				c=0;
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
	public Date getStartTime(ActionEvent event){
		java.time.LocalDate l = startT.getValue();
		ZoneId zone = ZoneId.systemDefault();
		Instant instant = l.atStartOfDay().atZone(zone).toInstant();
	    begin = Date.from(instant);
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
		VBox list = new VBox();
		for(int i=0;i<voList.size();i++){
			SaleReportItemVO saleReportItemVO = voList.get(i);
			Date d = saleReportItemVO.date;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(d);
			Label label_item = new Label(i+1+"     "+ date+"     " + saleReportItemVO.goods.getName()+"     "+saleReportItemVO.goods.getType()
			+"     "+saleReportItemVO.goods.getNumbers()+"     "+saleReportItemVO.goods.getSalePrice()+"     "+saleReportItemVO.sum);
			label_item.setLayoutX(32);
			label_item.setLayoutY(c);
			label_item.setOnMouseEntered(new EventHandler<MouseEvent>(){
	 			
	            @Override public void handle(MouseEvent e){
	            	label_item.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE,null,null)));
	            	
	              }
	            });
	 		label_item.setOnMouseExited(new EventHandler<MouseEvent>(){
	 			
	            @Override public void handle(MouseEvent e){
	            	label_item.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE,null,null)));
	              }
	            });
	 		labelList.add(label_item);
	 		c+=30;
	 		list.getChildren().add(label_item);
		}
		listPane.setContent(list);
		
	}

}
