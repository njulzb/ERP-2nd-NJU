package presentation.accountUI;

import java.io.File;
import java.rmi.RemoteException;

import BL.accountBL.AccountController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import po.KeyForSearchAccount;
import presentation.littleUI.TipUI;
import vo.AccountVO;
import vo.UserVO;
import vo.Form.stockFormVO.StockItemVO;

public class SearchAccountUI extends Application {
	protected String Path = null;
	public AccountManageUI father;
	public UserVO user=new UserVO ("00101010","李测试");
	public KeyForSearchAccount key = new KeyForSearchAccount();
	public AccountVO account=new AccountVO();
	public Pane pane;
	public  SearchAccountUI me=this;
	public Label label_img = new Label();
	public boolean isEdit=true;
	public boolean isCreate=true;
	button label_buttonSearch ;
	TextField tf_accountName,tf_accountID ,	tf_startMoney,tf_endMoney,tf_startPassword;
	
	
	
	
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
        

	    
	Label label_account = new Label("账户名称：");
	label_account  .setLayoutX(30);
	label_account .setLayoutY(70);
	root.getChildren().add(label_account );
			
			
	tf_accountName  =new 	TextField();
	tf_accountName .setLayoutX(110);
	tf_accountName .setLayoutY(70);
	tf_accountName .setMaxWidth(320);
	tf_accountName .setMaxHeight(10);;
	tf_accountName .setFont(new Font("黑体",11));
	tf_accountName .setText("");
	root.getChildren().add(tf_accountName );
 		
 	Label label_startMoney= new Label("最小余额");
 	label_startMoney  .setLayoutX(30);
 	label_startMoney.setLayoutY(100);
 	root.getChildren().add(label_startMoney );
		
		
		tf_startMoney=new 	TextField();
    	tf_startMoney.setLayoutX(110);
    	tf_startMoney.setLayoutY(100);
    	tf_startMoney.setMaxWidth(50);
    	tf_startMoney.setMinWidth(50);
    	tf_startMoney.setMaxHeight(10);;
    	tf_startMoney.setFont(new Font("黑体",11));
    	tf_startMoney.setText("");
 		root.getChildren().add(tf_startMoney);	
 		
 		Label label_startPassword =new Label("最大余额");
 		label_startPassword  .setLayoutX(30);
 		label_startPassword.setLayoutY(270);
 		root.getChildren().add(label_startPassword);
 		
		tf_endMoney=new 	TextField();
    	tf_endMoney.setLayoutX(380);
    	tf_endMoney.setLayoutY(100);
    	tf_endMoney.setMaxWidth(50);
    	tf_endMoney.setMinWidth(50);
    	tf_endMoney.setMaxHeight(10);;
    	tf_endMoney.setFont(new Font("黑体",11));
    	tf_endMoney.setText("");
 		root.getChildren().add(tf_endMoney);	
 		
 		
 	
		
	
        
		Image image2 = new Image("file:"+Path+getImgPath()+"button/button_search.png");
 		label_buttonSearch = new button("", new ImageView(image2));
 		label_buttonSearch .setLayoutX(230);
 		label_buttonSearch  .setLayoutY(320);
 		label_buttonSearch.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override public void handle(MouseEvent e){
            	if(tf_accountName.getText().trim()!="") {
            	 	key.setName(tf_accountName.getText().trim());
            	}
           
            	if(tf_startMoney.getText().trim()!="") {
            		key.setMoneyLeftMin(Integer.valueOf(tf_startMoney.getText().trim()) );
            	}
            	if(tf_endMoney.getText().trim()!="") {
            		key.setMoneyLeftMax(Integer.valueOf(tf_endMoney.getText().trim()) );
	            }
	            	
            	try {
            		System.out.println("[[[["  +new AccountController().searchAccount(key).size()  );
					father.VOtoShow=new AccountController().searchAccount(key);
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
 		label_buttonBack  .setLayoutY(320);
 		label_buttonBack	.setOnMousePressed(new EventHandler<MouseEvent>(){
 				
 	        @Override public void handle(MouseEvent e){
 	      	 stage.hide();
 	        		
 	          }
 	        });
 		root.getChildren().add(label_buttonBack);
 		

 		
 		
        Scene scene = new Scene(root, 450, 360);
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


