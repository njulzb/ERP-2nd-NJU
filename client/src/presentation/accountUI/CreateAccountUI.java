package presentation.accountUI;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import presentation.littleUI.TipUI;
import presentation.mainUI.UIcaller;
import utility.ImageZipUtil;
import utility.LOG;
import vo.AccountVO;
import vo.UserVO;
import vo.Form.stockFormVO.StockItemVO;

public class CreateAccountUI extends Application {
	protected String Path = null;
	public AccountManageUI father;
	public UserVO user=new UserVO ("00101010","李测试");
	public AccountVO account;
	public Pane pane;
	public  CreateAccountUI me=this;
	public Label label_img = new Label();
	public boolean isEdit=false;
	public boolean isCreate=true;
	button label_buttonSave ;
	TextField tf_accountName,tf_accountID ,	tf_startMoney,tf_accountUserName,tf_startPassword;
	
	
	
	
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
	 		label_account  .setLayoutX(230);
	 		label_account .setLayoutY(70);
	 		root.getChildren().add(label_account );
			
			
	tf_accountName  =new 	TextField();
	tf_accountName .setLayoutX(290);
	tf_accountName .setLayoutY(70);
	tf_accountName .setMaxWidth(120);
	tf_accountName .setMaxHeight(10);;
	tf_accountName .setFont(new Font("黑体",11));
	tf_accountName .setText(account.getName());
	tf_accountName .focusedProperty().addListener(new ChangeListener<Boolean>() {
	            @Override
	            public void changed(ObservableValue<? extends Boolean> arg0,Boolean arg1, Boolean arg2) {
	                     // TODO Auto-generated method stub
	            	//获得焦点： false   true 		失去焦点： true false
	             if(arg1) {
	            	 String c=tf_accountName .getText().trim();
	             }

	            }
	    	});
	 		root.getChildren().add(tf_accountName );
 		
 		Label label_startMoney= new Label("余额");
 		label_startMoney  .setLayoutX(30);
 		label_startMoney.setLayoutY(212);
 		root.getChildren().add(label_startMoney );
		
		
		tf_startMoney=new 	TextField();
    	tf_startMoney.setLayoutX(150);
    	tf_startMoney.setLayoutY(210);
    	tf_startMoney.setMaxWidth(250);
    	tf_startMoney.setMinWidth(250);
    	tf_startMoney.setMaxHeight(10);;
    	tf_startMoney.setFont(new Font("黑体",11));
    	tf_startMoney.setText("0");
 		root.getChildren().add(tf_startMoney);	
 		
 		
 		Label label_accountUserName= new Label("账户账号");
 		label_accountUserName  .setLayoutX(30);
 		label_accountUserName.setLayoutY(240);
 		root.getChildren().add(label_accountUserName);
 		
		tf_accountUserName=new 	TextField();
    	tf_accountUserName.setLayoutX(150);
    	tf_accountUserName.setLayoutY(243);
    	tf_accountUserName.setMaxWidth(250);
    	tf_accountUserName.setMinWidth(250);
    	tf_accountUserName.setMaxHeight(10);;
    	tf_accountUserName.setFont(new Font("黑体",11));
    	tf_accountUserName.setText("0");
 		root.getChildren().add(tf_accountUserName);	
 		
 		
 		Label label_startPassword =new Label("初始密码");
 		label_startPassword  .setLayoutX(30);
 		label_startPassword.setLayoutY(270);
 		root.getChildren().add(label_startPassword);
		
		
		tf_startPassword=new 	TextField();
    	tf_startPassword.setLayoutX(150);
    	tf_startPassword.setLayoutY(270);
    	tf_startPassword.setMaxWidth(250);
    	tf_startPassword.setMinWidth(250);
    	tf_startPassword.setMaxHeight(10);;
    	tf_startPassword.setFont(new Font("黑体",11));
    	tf_startPassword.setText("0");
 		root.getChildren().add(tf_startPassword);
 		
 		
	
        
		Image image2 = new Image("file:"+Path+getImgPath()+"button/button_save.png");
 		label_buttonSave = new button("", new ImageView(image2));
 		label_buttonSave .setLayoutX(230);
 		label_buttonSave  .setLayoutY(320);
 		label_buttonSave.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override public void handle(MouseEvent e){
;
            	account.setID(tf_accountUserName.getText().trim());
            	account.setName(tf_accountName.getText().trim());
            	account.setMoney(Double.valueOf(tf_startMoney.getText().trim()));
				account.setPassword(tf_startPassword.getText().trim());
            	
            	
            	TipUI.showConfirmDialog(stage, "确认保存？", "confirm");
            	if(TipUI.buttonSelected==TipUI.Response.YES) {
            		AccountVO c=null;
            		
            		try {
						 if(c==null&&isCreate) {
							father.controller.newAccount(account);
							TipUI.showMessageDialog(stage, "恭喜您\n操作成功", "confirm");
							LOG.addLog("新建了银行账户XXXXX", "CW-001");
							stage.hide();
						}
						else if(c==null&&!isCreate) {
							father.controller.editAccount(account);
							TipUI.showMessageDialog(stage, "恭喜您\n操作成功", "confirm");
							stage.hide();
						}
						else {
							stage.hide();
						}
						
						
					} catch (RemoteException e1) {
						// TODO 自动生成的 catch 块
						TipUI.showMessageDialog(stage, "网络错误\n无法连接至服务器", "error");
						e1.printStackTrace();
					}
            	
                	
                	
            	}
            	father.showItem(0);
            	
            	
            }
            });
 		root.getChildren().add(label_buttonSave);
 		
        
        
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
 		
 		
 		String pathImg="img\\default\\test.png";
 			
 				
 				
 		if(account!=null&&account.getImagePath()!=null) {
 			 pathImg=account.getImagePath();
 			 System.out.println(pathImg);
 		}
		Image image3 = new Image("file:"+pathImg);
		label_img = new Label("", new ImageView(image3));
 		label_img .setLayoutX(30);
 		label_img  .setLayoutY(70);
		root.getChildren().add(label_img);
 		
 		
 		
 		
		Image image6 = new Image("file:"+Path+getImgPath()+"button/button_editImg.png");
		button label_changeImg = new button("编辑图片");
		label_changeImg.setFont( new Font(11));
 		label_changeImg .setLayoutX(170);
 		label_changeImg  .setLayoutY(170);
 		label_changeImg.setOnMousePressed(new EventHandler<MouseEvent>(){
 			
            @Override public void handle(MouseEvent e){
            	FileChooser fileChooser = new FileChooser();
            	fileChooser.setTitle("Open Resource File");
            	 File file;
            	  file =fileChooser.showOpenDialog(stage);
            	
            	//fileChooser.getInitialFileName();
            		//	  file.getCanonicalPath()
            	 	String c="null";
            		if(file==null) {
            			return ;
            		}
            		try {
            			c=file.getCanonicalPath();
            	 
            	 
            		}catch (IOException e1) {
 					// TODO 自动生成的 catch 块
 					UIcaller.callImagePushErrorUI();
            		};
            		if(c!="null") {
            			String t= Path+"/temp/"+c.hashCode()+".png";
            			ImageZipUtil.zipWidthHeightImageFile(new File(c), new File(t), 80, 80,1.0f);
            			
            			root.getChildren().remove(label_img);
    					label_img.setVisible(false);
    					Image imagePush = new Image("file:"+t);
    					ImageView iv=	new ImageView(imagePush);
    			 		label_img = new Label("", iv);
    			 		label_img .setLayoutX(30);
    			 		label_img  .setLayoutY(70);
    					root.getChildren().add(label_img);
    					account.setImagePath(t);
            		} 
            		
            	
              }
            });
 		root.getChildren().add(label_changeImg);
 		
 		if(account.getName()!=null) { tf_accountName.setText(account.getName());}
 		if(account.getID()!=null) {tf_accountUserName.setText(account.getID());}
 		if(account.getPassword()!=null) {tf_startPassword.setText(account.getPassword());}
 	 	
 		tf_startMoney.setText(account.getMoney()+"");
 		
 	if(isEdit) {
 		tf_accountName.setEditable(true);
 		tf_accountUserName.setEditable(false);
 		tf_startPassword.setEditable(false);
 		tf_startMoney.setEditable(false);
 		label_buttonSave .setVisible(true);
 		label_changeImg.setVisible(true);
 	}
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
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


