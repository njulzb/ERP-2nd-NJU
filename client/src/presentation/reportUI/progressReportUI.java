package presentation.reportUI;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import BL.reportBL.ReportController;
import BLService.reportBLService.ReportBLService;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import presentation.littleUI.TipUI;
import presentation.receiptUI.FormMessageUI;
import utility.KindOfForm;
import utility.LOG;
import utility.RoleOfUser;
import vo.UserVO;
import vo.Form.FormVO;
import vo.Form.FinanceFormVO.CashFormVO;
import vo.report.KeyForSearchReport;
import vo.report.ManageProgressReportVO;


public class progressReportUI extends Application{
	protected ArrayList<FormVO> formList = new ArrayList<FormVO>();
	protected ArrayList<Label> list = new ArrayList<Label>();
	protected int pageSize=10;
	protected Label label_formHighLight= new Label();
	private Pane root = new Pane();
	private Label titleLabel = new Label();
	private Button searchButton = new Button(), exportButton = new Button();
	private Font font2 = new Font("楷体",20);
	private Date startTime, endTime;
	private DatePicker startT = new DatePicker(), endT = new DatePicker();
	public UserVO presentOperator;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub		
		root = progressReportUI(primaryStage);
	}

	
	//经营历程表主界面
	public Pane progressReportUI(Stage primaryStage){
		titleLabel.setText("经营历程表");
		titleLabel.setLayoutX(30);
		titleLabel.setLayoutY(12);
		titleLabel.setFont(font2);
		root.getChildren().add(titleLabel);
		
		Line line = new Line();
		line.setLayoutX(10);
		line.setLayoutY(50);
		line.setStartX(-80);
		line.setEndX(620);
		line.setStrokeWidth(1.5);
		root.getChildren().add(line);
		
		//root.setPrefSize(660, 580);
		double sX=0,sY=0;
		
		//root.setBackground(new Background(new BackgroundFill(Color.AZURE,null,null)));
		
		Label time = new Label("选择时间");
		time.setLayoutX(40);
		time.setLayoutY(70);
		root.getChildren().add(time);
	
		startT.setLayoutX(140);
		startT.setLayoutY(65);
		startT.setPrefWidth(150);
		//startT.setShowWeekNumbers(false);
		root.getChildren().add(startT);
		
		Line se = new Line();
		se.setLayoutX(320);
		se.setLayoutY(80);
		se.setStartX(-14);
		se.setEndX(14);
		root.getChildren().add(se);
		
		DatePicker endT = new DatePicker();
		endT.setLayoutX(350);
		endT.setLayoutY(65);
		endT.setPrefWidth(150);
		//endT.setShowWeekNumbers(false);

		root.getChildren().add(endT);
		
		searchButton.setText("查找");
		searchButton.setLayoutX(520);
		searchButton.setLayoutY(65);
		searchButton.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE,null,null)));
		searchButton.setOnMouseEntered(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				searchButton.setLayoutX(searchButton.getLayoutX()+3);
				searchButton.setLayoutY(searchButton.getLayoutY()+3);
			}
			
		});
		searchButton.setOnMouseExited(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				searchButton.setLayoutX(searchButton.getLayoutX()-3);
				searchButton.setLayoutY(searchButton.getLayoutY()-3);
			}
			
		});
		searchButton.setOnMousePressed(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				LocalDate ld = startT.getValue();
				ZoneId zone = ZoneId.systemDefault();
				Instant instant = ld.atStartOfDay().atZone(zone).toInstant();
			    startTime = Date.from(instant);
			    //System.out.println(startTime);
			    
			    ld = endT.getValue();
			    endTime = Date.from(instant);
			    //System.out.println(endTime);
			    
			    if(startTime == null || endTime == null){
					TipUI.showMessageDialog(new Stage(), "请选择时间区间", "Warning Dialog");
				}
			    
			    if(startTime != null && endTime != null){
			    	if(startTime.getTime() > endTime.getTime()){
			    		TipUI.showMessageDialog(new Stage(), "请选择正确的时间区间", "Warning Dialog");
			    	}
			    	else{
			    		KeyForSearchReport k = new KeyForSearchReport(null, startTime, endTime, null, null, null, null);
						ReportBLService reportBLService = new ReportController();
						ManageProgressReportVO manageProgressReportVO = null;
						try {
							manageProgressReportVO = reportBLService.getManageProgress(k);
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						initList(manageProgressReportVO);
						root = showList(root, sX, sY, 0);
			    	}
			    	
			    }		    
				
			}
			
		});
		root.getChildren().add(searchButton);
		
		exportButton.setText("导出");
		exportButton.setLayoutX(580);
		exportButton.setLayoutY(65);
		exportButton.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE,null,null)));
		exportButton.setOnMouseEntered(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				exportButton.setLayoutX(exportButton.getLayoutX()+3);
				exportButton.setLayoutY(exportButton.getLayoutY()+3);
			}
			
		});
		exportButton.setOnMouseExited(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				exportButton.setLayoutX(exportButton.getLayoutX()-3);
				exportButton.setLayoutY(exportButton.getLayoutY()-3);
			}
			
		});
		exportButton.setOnMousePressed(new EventHandler<MouseEvent>(){

			@SuppressWarnings("static-access")
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				DirectoryChooser directoryChooser = new DirectoryChooser();
            	directoryChooser .setTitle("Open Resource File");
            	File file = directoryChooser .showDialog(new Stage());
            	String Path = "";
            	try {
            		Path = file.getCanonicalPath();	
            		System.out.println(Path);
            	} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				};
				ManageProgressReportVO manageProgressVO = new ManageProgressReportVO(null, null, null, null);
				ReportBLService rbls = new ReportController();
            	try {
					if(rbls.ExportReport(manageProgressVO, Path)){
						TipUI t = new TipUI();
						t.showMessageDialog(new Stage(), "导出成功！", "ERPsystem");
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}   
            	LOG.addLog("导出了经营历程表", "161250088");
			}
			
		});
		root.getChildren().add(exportButton);
		
		Label row = new Label("行号");
		row.setLayoutX(16);
		row.setLayoutY(120);
		root.getChildren().add(row);
		
		Label validTime = new Label("生效时间");
		validTime.setLayoutX(120);
		validTime.setLayoutY(120);
		root.getChildren().add(validTime);
		
		Label idLabel = new Label("单据编号");
		idLabel.setLayoutX(400);
		idLabel.setLayoutY(120);
		root.getChildren().add(idLabel);
		
		
		Scene scene = new Scene(root,660,580);
		primaryStage.setScene(scene);
		//primaryStage.show();
		return root;	
	}
	
	   //显示筛选的单据
		protected Pane showList(Pane root, double sx, double sy, int page){
			
			double sX=sx, sY=sy;
			for(int i=0;i<list.size();i++) {
				(list.get(i)).setVisible(false);
			}
			
			int c=150;
			for(int i=page*pageSize;i<formList.size()&&i<pageSize*(page+1);i++){
				KindOfForm kof = null;
				FormVO temp = formList.get(i);
				Label label_Item = new Label( Integer.toString(i+1)+"     "+ temp.getPassTime() + "                        " + temp.getID());
				label_Item.setLayoutX(32);
				label_Item.setLayoutY(c);
				label_Item.c = c;
	            label_Item.setOnMouseEntered(new EventHandler<MouseEvent>(){
		 			
		            @Override public void handle(MouseEvent e){
		            	label_Item.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE,null,null)));
		            	
		              }
		            });
		 		label_Item.setOnMouseExited(new EventHandler<MouseEvent>(){
		 			
		            @Override public void handle(MouseEvent e){
		            	label_Item.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE,null,null)));
		              }
		            });
		 		label_Item.setOnMouseClicked(new EventHandler<MouseEvent>(){

					@Override
					public void handle(MouseEvent e) {
						// TODO Auto-generated method stub
						FormMessageUI formMessageui = new FormMessageUI();
						formMessageui.user = presentOperator;
						formMessageui.editAble = false;
						formMessageui.formVO = temp;
						formMessageui.start(new Stage());
						if(presentOperator.getRole()== RoleOfUser.GeneralManager){
							
						}
						
					    
					}
		 			
		 		});
		 		
				list.add(label_Item);
				root.getChildren().add(label_Item);			
				c+=30;
				
			}
			root=createPageSelect(root, sX, sY, page);
	 		return root;
			
		}
	
	   //按分页方式显示查找的单据
		protected Pane createPageSelect(Pane root, double sx, double sy, int page) {
			int endPage = formList.size() % pageSize + 1;
			// TODO 自动生成的方法存根
			double sX = sx,sY = sy;
			double usedX = 0;
			
			if(formList.size()>pageSize) {
				if(page!=0) {
					Label label_11 = new Label("首页");
			 		label_11.setLayoutX(sX+usedX+30);
			 		usedX+=50;
			 		label_11.setLayoutY(sY+485);
			 		label_11.setFont(new Font("黑体",12));
			 		label_11.setTextFill(Color.BLUE);
			 		list.add(label_11);
			 		label_11.setOnMousePressed(new EventHandler<MouseEvent>(){
			            @Override public void handle(MouseEvent e){
			            	
			            	showList(root , sx, sy, 0);
			              }
			            });
			 		root.getChildren().add(label_11);
			 		
			 		
			 		
			 		Label label_22 = new Label("上一页 ");
			 		label_22.setLayoutX(sX+usedX+30);
			 		usedX+=50;
			 		label_22.setLayoutY(sY+485);
			 		label_22.setFont(new Font("黑体",12));
			 		label_22.setTextFill(Color.BLUE);
			 		list.add(label_22);
			 		label_22.setOnMousePressed(new EventHandler<MouseEvent>(){
			            @Override public void handle(MouseEvent e){
//			            
			            	showList(root , sx, sy, page-1);
			              }
			            });
			 		root.getChildren().add(label_22);
			 		
			 		
			 		
			 		
			 		Label label_33 = new Label(" "+Integer.toString(page));
			 		label_33.setLayoutX(sX+usedX+30);
			 		usedX+=50;
			 		label_33.setLayoutY(sY+485);
			 		label_33.setFont(new Font("黑体",12));
			 		label_33.setTextFill(Color.BLUE);
			 		list.add(label_33);
			 		label_33.setOnMousePressed(new EventHandler<MouseEvent>(){
			            @Override public void handle(MouseEvent e){
//			            
			            	showList(root , sx, sy, page-1);
			              }
			            });
			 		root.getChildren().add(label_33);		 		
			 		
				}
				
				Label label_44 = new Label(Integer.toString(page+1)+" ");
		 		label_44.setLayoutX(sX+usedX+30);
		 		usedX+=50;
		 		label_44.setLayoutY(sY+485);
		 		label_44.setFont(new Font("黑体",12));
		 		label_44.setTextFill(Color.GREY);
		 		list.add(label_44);	 	
		 		root.getChildren().add(label_44);
					 		
		 		
		 		if(page != endPage) {
		 			Label label_33 = new Label(Integer.toString(page+2));
			 		label_33.setLayoutX(sX+usedX+30);
			 		usedX+=40;
			 		label_33.setLayoutY(sY+485);
			 		label_33.setFont(new Font("黑体",12));
			 		label_33.setTextFill(Color.BLUE);
			 		list.add(label_33);
			 		label_33.setOnMousePressed(new EventHandler<MouseEvent>(){
			            @Override public void handle(MouseEvent e){
//			            
			            	showList(root , sx, sy, page+1);
			              }
			            });
			 		root.getChildren().add(label_33);
		 			
			 		
			 		
			 		Label label_22 = new Label("下一页 ");
			 		label_22.setLayoutX(sX+usedX+30);
			 		usedX+=40;
			 		label_22.setLayoutY(sY+485);
			 		label_22.setFont(new Font("黑体",12));
			 		label_22.setTextFill(Color.BLUE);
			 		list.add(label_22);
			 		label_22.setOnMousePressed(new EventHandler<MouseEvent>(){
			            @Override public void handle(MouseEvent e){
//			            
			            	showList(root , sx, sy, page+1);
			              }
			            });
			 		root.getChildren().add(label_22);
			 		
			 				
					Label label_11 = new Label(" 尾页");
			 		label_11.setLayoutX(sX+usedX+30);
			 		usedX+=50;
			 		label_11.setLayoutY(sY+485);
			 		label_11.setFont(new Font("黑体",12));
			 		label_11.setTextFill(Color.BLUE);
			 		list.add(label_11);
			 		label_11.setOnMousePressed(new EventHandler<MouseEvent>(){
			            @Override public void handle(MouseEvent e){
//			            
			            	showList(root , sx, sy, endPage);
			              }
			            });
			 		root.getChildren().add(label_11);
		 		}
			}
			return root;
		}
    
    public void initList(ManageProgressReportVO manageProgressReportVO) {
    	if(manageProgressReportVO.getFinanceList()!=null){
    		for(int i=0;i<manageProgressReportVO.getFinanceList().size();i++){
    			formList.add(manageProgressReportVO.getFinanceList().get(i));
    		}
    	}
    	if(manageProgressReportVO.getImportList()!=null){
    		for(int i=0;i<manageProgressReportVO.getImportList().size();i++){
    			formList.add(manageProgressReportVO.getImportList().get(i));
    		}
    	}
		if(manageProgressReportVO.getSaleList()!=null){
			for(int i=0;i<manageProgressReportVO.getSaleList().size();i++){
				formList.add(manageProgressReportVO.getSaleList().get(i));
			}
		}
		if(manageProgressReportVO.getStockList()!=null){
			for(int i=0;i<manageProgressReportVO.getStockList().size();i++){
				formList.add(manageProgressReportVO.getStockList().get(i));
			}
		}
		
    }
    
    public class Label extends  javafx.scene.control.Label{
		public Label(String string, ImageView imageView) {
			super(string , imageView);
			// TODO 自动生成的构造函数存根
		}
		public Label(String string) {
			super(string );
			// TODO 自动生成的构造函数存根
		}
		public Label() {
			super();
			// TODO 自动生成的构造函数存根
		}
		int c=0;
	}
	 
	protected String getImgPath() {
		return "";
	}
}
