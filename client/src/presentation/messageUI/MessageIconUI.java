package presentation.messageUI;

import java.io.File;
import java.rmi.RemoteException;
import java.util.ArrayList;


import BL.messageBL.MessageController;
import BLService.messageBLService.MessageBLService;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import po.KeyForSearchMessage;
import presentation.littleUI.TipUI;
import vo.MessageVO;
import vo.UserVO;
 

/** 
* 
* @author Alan 
*/  
public class MessageIconUI extends Application{
	MessageIconUI me =this;
	String lastState="";
	//GoodsClassVO nowClass ;
	MessageBLService controller =new MessageController();
	public Pane root =new Pane(),locationPane=new Pane(), itemsPane=new Pane();
	String Path="";
	Stage stage;
	TextField tf_search;
	Label label_searchMes;
	int pageSize=5;
	public int nowPage=0;
	public UserVO user=null;
	boolean isSearching=false;
	ArrayList <MessageVO> VOtoShow=new 	ArrayList <MessageVO>();
	button label_newSubClass,label_searchbutton ; 
	boolean isSearchResult=false;
	int isRead=0;

	public static void main(String[] args) {
		System.out.println("1511");
		launch(args);
	}
	
	public MessageIconUI() {
		initData();
		initList();
		root = initPane();
		
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		System.out.println("111");
		
		this.stage =stage;
		stage.initStyle(StageStyle. TRANSPARENT);//无边�?
 		stage.setAlwaysOnTop(true);
 		stage.setResizable(false);//不能改变大小
 		Scene scene = new Scene(root,700,600);
// 		root = initPane();
		
 		stage.setScene(scene);
 		stage.show();

	}
	public Pane initPane( ) {

		Image imageClose = new Image("file:"+Path+getImgPath()+"stock\\closeIcon.png");
 		button label_Close = new button("", new ImageView(imageClose));
 		label_Close .setLayoutX(670);
 		label_Close  .setLayoutY(10);
		label_Close.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override public void handle(MouseEvent e){
            	stage.hide();
              }
            });
		root.getChildren().add(label_Close);
		
		
		Label label_title=new Label("通知与消息");
		label_title .setLayoutX(30);
		label_title  .setLayoutY(40);
		label_title.setFont(new Font(22));
		root.getChildren().add(label_title);
		
		
		Label label_wd=new Label("未读消息");
		label_wd .setLayoutX(30);
		label_wd.setTextFill(Color.ROYALBLUE);
		label_wd  .setLayoutY(100);
		label_wd.setFont(new Font(12));
		label_wd.setOnMousePressed(new EventHandler<MouseEvent>(){
          @Override public void handle(MouseEvent e){
        	  	isRead=0;
          }
        });
		root.getChildren().add(label_wd);	
		
		
		Label label_yd=new Label("已读消息");
		label_yd .setLayoutX(110);
		label_yd.setTextFill(Color.ROYALBLUE);
		label_yd  .setLayoutY(100);
		label_yd.setFont(new Font(12));
		label_yd.setOnMousePressed(new EventHandler<MouseEvent>(){
          @Override public void handle(MouseEvent e){
        	  isRead=1;
          }
        });
		root.getChildren().add(label_yd);	
		
		Label label_fs=new Label("发送消息");
		label_fs .setLayoutX(190);
		label_fs.setTextFill(Color.ROYALBLUE);
		label_fs  .setLayoutY(100);
		label_fs.setFont(new Font(12));
		label_fs.setOnMousePressed(new EventHandler<MouseEvent>(){
          @Override public void handle(MouseEvent e){
          }
        });
		root.getChildren().add(label_fs);
		
		
//		
//		Image imageleft = new Image("file:"+Path+getImgPath()+"message\\left.png");
// 		button label_left = new button("", new ImageView(imageleft));
// 		label_left .setLayoutX(0);
// 		label_left  .setLayoutY(0);
//		label_left.setOnMousePressed(new EventHandler<MouseEvent>(){
//            @Override public void handle(MouseEvent e){
//            	stage.hide();
//              }
//            });
//		root.getChildren().add(label_left);
		
		
		
		Image image1 = new Image("file:"+Path+getImgPath()+"stock\\line.png");
 		Label label_line1 = new Label("", new ImageView(image1));
 		label_line1 .setLayoutX(30);
 		label_line1  .setLayoutY(70);

		root.getChildren().add(label_line1);
		
		
//		Image imag1 = new Image("file:"+Path+getImgPath()+"button\\button_search.png");
// 		label_searchbutton = new button("", new ImageView(imag1));
// 		label_searchbutton .setLayoutX(30);
// 		label_searchbutton.setLayoutY(100);
// 	 	System.out.println(1);
// 		label_searchbutton.setOnMousePressed(new EventHandler<MouseEvent>(){
//            @Override public void handle(MouseEvent e){
//             	System.out.println(1);
//            	
//
//              }
//            });
//		root.getChildren().add(label_searchbutton); 
		
		
		
		
		return root ;
		
	}

	
	public void initData() {
		
		File directory = new File("");//设定为当前文件夹 
		try{ 
			 
		     Path=directory.getCanonicalPath();

		}catch(Exception e){} 
		
	}
	public void initList() {
		
		VOtoShow.clear();
		KeyForSearchMessage key =new 	KeyForSearchMessage ();
		key.setIsRead(isRead);
		if(user!=null) {
			key.setReceiverID(user.getID());
		}
		try {
			VOtoShow =controller.searchMessage(key);
		} catch (RemoteException e) {
			TipUI.showMessageDialog(stage, "错误/n无法连接到服务器", "error");
			e.printStackTrace();
		}
	
	}
	
	public  String getImgPath() {
		return "\\img\\";
		
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