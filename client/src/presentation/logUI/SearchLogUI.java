package presentation.logUI;

import java.io.File;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.time.LocalDate;

import BL.logBL.LogController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import po.KeyForSearchLog;
import presentation.littleUI.TipUI;
import vo.AccountVO;
import vo.UserVO;
import vo.Form.stockFormVO.StockItemVO;

public class SearchLogUI extends Application {
	protected String Path = null;
	public LogMainUI father;
	public UserVO user=new UserVO ("00101010","李测试");
	public KeyForSearchLog key = new KeyForSearchLog();
	public AccountVO account=new AccountVO();
	public Pane pane;
	public  SearchLogUI me=this;
	public Label label_img = new Label();
	public boolean isEdit=true;
	public boolean isCreate=true;
	DatePicker startDatePicker,endDatePicker;
	
	button label_buttonSearch ;
	TextField tf_logMes,tf_operator ;
	
	
	
	
	public static void main(String args[]) {
		launch();
	}
    @Override
    public void start(Stage stage) {
  
        stage.setTitle("ERPsystem");
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);//不能改变大小
        stage.initStyle(StageStyle. TRANSPARENT);//无边框
        
        File directory = new File("");//设定为当前文件夹 
		 try{ 
		     Path=directory.getCanonicalPath();

		 }catch(Exception e){} 
		account.setImagePath(Path +"/img/default/test.png");
		  
        Pane root =new Pane();


		Image image0 = new Image("file:"+Path+getImgPath()+"account/header.png");
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
        

	    
	Label label_account = new Label("操作关键词：");
	label_account  .setLayoutX(30);
	label_account .setLayoutY(70);
	root.getChildren().add(label_account );
			
			
	tf_logMes  =new 	TextField();
	tf_logMes .setLayoutX(130);
	tf_logMes .setLayoutY(70);
	tf_logMes .setMaxWidth(320);
	tf_logMes .setMaxHeight(10);;
	tf_logMes .setFont(new Font("黑体",11));
	tf_logMes .setText("");
	root.getChildren().add(tf_logMes );
 		
 	Label label_startMoney= new Label("起始日期：");
 	label_startMoney  .setLayoutX(30);
 	label_startMoney.setLayoutY(100);
 	root.getChildren().add(label_startMoney );
		

 		
 		Label label_startPassword =new Label("结束日期：");
 		label_startPassword  .setLayoutX(30);
 		label_startPassword.setLayoutY(130);
 		root.getChildren().add(label_startPassword);
 		
	
 		Label label_operator = new Label("操作人：");
 		label_operator   .setLayoutX(30);
 		label_operator .setLayoutY(160);
 		root.getChildren().add(label_operator );
 				
 				
 		tf_operator   =new 	TextField();
 		tf_operator .setLayoutX(130);
 		tf_operator .setLayoutY(160);
 		tf_operator  .setMaxWidth(320);
 		tf_operator .setMaxHeight(10);;
 		tf_operator .setFont(new Font("黑体",11));
 		tf_operator  .setText("");
 		root.getChildren().add(tf_operator  );
 	
		
	
        
		Image image2 = new Image("file:"+Path+getImgPath()+"button/button_search.png");
 		label_buttonSearch = new button("", new ImageView(image2));
 		label_buttonSearch .setLayoutX(230);
 		label_buttonSearch  .setLayoutY(200);
 		label_buttonSearch.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override public void handle(MouseEvent e){
            	if(tf_logMes.getText().trim()!="") {
            	 	key.setMessage(tf_logMes.getText().trim());
            	}
           
            	if(tf_operator.getText().trim()!="") {
            		key.setOperatorID(tf_operator.getText().trim() );
            	}
            	if(startDatePicker.getValue()!=null) {
            	System.out.println(startDatePicker.getValue().getYear());
            		System.out.println(startDatePicker.getValue().getMonthValue());
            		System.out.println(startDatePicker.getValue().getDayOfMonth());
            		Timestamp start =new Timestamp(startDatePicker.getValue().getYear()-1900,startDatePicker.getValue().getMonthValue()-1,startDatePicker.getValue().getDayOfMonth(),0,0,0,0);
            		
            		//System.out.println(start.toString());
            		key.setCreateTimeMin(start);
            	}
            	if(endDatePicker.getValue()!=null) {
            		Timestamp end=new Timestamp(endDatePicker.getValue().getYear()-1900,endDatePicker.getValue().getMonthValue()-1,endDatePicker.getValue().getDayOfMonth(),0,0,0,0);
             		key.setCreateTimeMax(end);
             	 //	System.out.println(end.toString());
            	}
            	
            	
            	try {
            		father.VOtoShow=new LogController().searchLog(key);
					stage.hide();
	            	father.showSearchItem(0);
	            	
				} catch (RemoteException e1) {
					TipUI.showMessageDialog(stage, "网络错误\n无法连接至服务器", "error");
					e1.printStackTrace();
				}
            	
            	
            }
            });
 		root.getChildren().add(label_buttonSearch);
 		
        
        
 		Image image4 = new Image("file:"+Path+getImgPath()+"button/button_back.png");
 		button label_buttonBack = new button("", new ImageView(image4));
 		label_buttonBack .setLayoutX(340);
 		label_buttonBack  .setLayoutY(200);
 		label_buttonBack	.setOnMousePressed(new EventHandler<MouseEvent>(){
 				
 	        @Override public void handle(MouseEvent e){
 	       	System.out.println(111); 
 	      	 stage.hide();
 	      		
 	          }
 	        });
 		root.getChildren().add(label_buttonBack);
 		

 		
		startDatePicker =new DatePicker();
		startDatePicker.setLayoutX(130);
		startDatePicker.setLayoutY(100);
		startDatePicker.setMaxWidth(120);
		root.getChildren().add(startDatePicker);
		
		endDatePicker =new DatePicker();
		endDatePicker.setLayoutX(130);
		endDatePicker.setLayoutY(130);
		endDatePicker.setMaxWidth(120);
		root.getChildren().add(endDatePicker);
 		
 		
		startDatePicker.setValue(LocalDate.now());
		endDatePicker.setValue(LocalDate.now());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
        Scene scene = new Scene(root, 450, 250);
        stage.setScene(scene);
        
        stage.show();
        
        
        
    }
    

	protected String getImgPath() {
		// TODO 自动生成的方法存根
		return "\\img\\";
	}
	public void setItem(StockItemVO c) {
    
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
		public button(String a) {
			super(a);
		}
		public button() {
			
		}
	}


}


