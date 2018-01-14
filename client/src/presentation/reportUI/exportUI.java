package presentation.reportUI;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import BL.reportBL.ReportController;
import BL.reportBL.Stub.ReportBLServiceStub;
import BLService.reportBLService.ReportBLService;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import presentation.littleUI.TipUI;
import vo.Form.stockFormVO.StockItemVO;
import vo.goods.GoodsVO;
import vo.report.ManageStateReportVO;

public class exportUI extends Application {
	protected String Path = null;
	public Object father;
	public GoodsVO goods = new GoodsVO("000", "default", "000");
	public int preNum = 0;
	public boolean isEdit = false;
	public Pane pane;
	public  exportUI me = this;
	public StockItemVO  item = new  StockItemVO();
	private ManageStateReportVO r;
	
	public static void main(String args[]) {
		launch();
	}
    @SuppressWarnings("unchecked")
	@Override
    public void start(Stage stage) {
        stage.setTitle("ERPsystem");
        initGoods();
        
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);//不能改变大小
        stage.initStyle(StageStyle. TRANSPARENT);//无边框
        
        File directory = new File("");//设定为当前文件夹 
		 try{ 
		     Path=directory.getCanonicalPath();

		 }catch(Exception e){} 
        
        Pane root =new Pane();
   

		Image image0 = new Image("file:"+Path+getImgPath()+"stock/header_create.png");
 		Label	label_title = new Label("", new ImageView(image0));
 		label_title .setLayoutX(0);
 		label_title  .setLayoutY(0);
		root.getChildren().add(label_title);
		
		
		Image imageClose = new Image("file:"+Path+getImgPath()+"receipt\\closeIcon.png");
 		button label_Close = new button("", new ImageView(imageClose));
 		label_Close .setLayoutX(420);
 		label_Close  .setLayoutY(9);
		label_Close.setOnMousePressed(new EventHandler<MouseEvent>(){
 			
            @Override public void handle(MouseEvent e){
           	 stage.hide();
              }
            });
		root.getChildren().add(label_Close);
		
 		
 		
 		Label label_startSaleMoney= new Label("导出路径");
 		label_startSaleMoney  .setLayoutX(30);
 		label_startSaleMoney.setLayoutY(70);
 		root.getChildren().add(label_startSaleMoney );
		
		
		TextField tf_filePath=new 	TextField();
    	tf_filePath.setLayoutX(150);
    	tf_filePath.setLayoutY(70);
    	tf_filePath.setMaxWidth(250);
    	tf_filePath.setMinWidth(250);
    	tf_filePath.setMaxHeight(9);;
    	tf_filePath.setFont(new Font("黑体",9));
    	tf_filePath.setText("0");
 		root.getChildren().add(tf_filePath);	
 		
 		Label label_xxx= new Label("❤");
 		 label_xxx.setFont(new Font(20));
 		label_xxx  .setLayoutX(403);
 		label_xxx.setLayoutY(67);
 		label_xxx.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override public void handle(MouseEvent e){
            	DirectoryChooser directoryChooser = new DirectoryChooser();
            	directoryChooser .setTitle("Open Resource File");
            	File file = directoryChooser .showDialog(stage);
            	
            	try {
            		Path = file.getCanonicalPath();
					//System.out.println( file.getCanonicalPath());
					tf_filePath.setText(Path);
            	} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				};
            }
            });
 		root.getChildren().add(label_xxx );
 		

 		
 		/*Label label_startNum =new Label("导出格式");
 		label_startNum  .setLayoutX(30);
 		label_startNum.setLayoutY(110);
 		root.getChildren().add(label_startNum);
		
 		
		ArrayList<String> optionList=new ArrayList<String>();
		optionList.add(".txt");
		optionList.add(".xsxl");
 		ObservableList<String> options=FXCollections.observableArrayList(optionList);
 		 ComboBox<String> comboBox= new ComboBox<String>(options);
 	//	comboBox.getSelectionModel().select(" "); // [0, options.size())
 		comboBox.setLayoutX(150);
 		comboBox.setLayoutY(110);
 		comboBox.setMinSize(250, 10);
 		comboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {  
            @SuppressWarnings("rawtypes")
			@Override  
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {  
            	System.out.println(newValue);
            }  
        }); 
 		root.getChildren().add(comboBox);*/
 		

        
		Image image2 = new Image("file:"+Path+getImgPath()+"button/button_save.png");
 		button label_buttonSave = new button("", new ImageView(image2));
 		label_buttonSave .setLayoutX(230);
 		label_buttonSave  .setLayoutY(160);
 		label_buttonSave.setOnMousePressed(new EventHandler<MouseEvent>(){
            @SuppressWarnings("static-access")
			@Override public void handle(MouseEvent e){
            	ReportBLService rbls = new ReportController();
            	try {
					if(rbls.ExportReport(r, Path)){
						TipUI t = new TipUI();
						t.showMessageDialog(stage, "导出成功！", "ERPsystem");
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}           	
            }
            });
 		root.getChildren().add(label_buttonSave);
 		
        
        
 		Image image4 = new Image("file:"+Path+getImgPath()+"button/button_back.png");
 		button label_buttonBack = new button("", new ImageView(image4));
 		label_buttonBack .setLayoutX(340);
 		label_buttonBack  .setLayoutY(160);
 		label_buttonBack	.setOnMousePressed(new EventHandler<MouseEvent>(){
 				
 	        @Override public void handle(MouseEvent e){
 	      	 stage.hide();
 	        		
 	          }
 	        });
 		root.getChildren().add(label_buttonBack);
 		
 		
        Scene scene = new Scene(root, 450, 200);
        stage.setScene(scene);

        stage.show();
    }
    
    public void getVO(ManageStateReportVO newer){
    	r = newer;
    }
    
    private void initGoods() {
		// TODO 自动生成的方法存根
		goods.setID("t1");

	}
	protected String getImgPath() {
		// TODO 自动生成的方法存根
		return "\\img\\";
	}
	public void setItem(StockItemVO c) {
    	item=c;
    }
    
	
	
    public StockItemVO getItem() {
    	
		return item;
    	
    }
    
    
    
    
    public class button extends Label{
		public button(String a,ImageView c) {
			super(a,c);
			this .setOnMouseEntered(new EventHandler<MouseEvent>(){
	 			
	            @Override public void handle(MouseEvent e){
	            	
	           
	            	Label obj=(Label)e.getSource();
	            		double x=obj.getLayoutX();
	            		double y=obj.getLayoutY();
	            		obj.setLayoutX(x+3);
	            		obj.setLayoutY(y+3);
	              }
	            });
			this .setOnMouseExited(new EventHandler<MouseEvent>(){
	 			
	            @Override public void handle(MouseEvent e){
	            	Label obj=(Label)e.getSource();
	        		double x=obj.getLayoutX();
	        		double y=obj.getLayoutY();
	        		obj.setLayoutX(x-3);
	        		obj.setLayoutY(y-3);
	              }
	            });
		}
		public button() {
			
		}
	}


}