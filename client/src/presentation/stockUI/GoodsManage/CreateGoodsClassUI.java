package presentation.stockUI.GoodsManage;

import java.io.File;
import java.rmi.RemoteException;

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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import presentation.littleUI.HELP.MyButton;
import utility.ImageZipUtil;
import vo.Form.stockFormVO.StockItemVO;
import vo.goods.GoodsClassVO;

public class CreateGoodsClassUI extends Application {
	protected String Path = null;
	public StockManageUI2 father;
	public GoodsClassVO goodsClass=new GoodsClassVO();
	public int preNum=0;
	public boolean isEdit=false;
	public Pane pane;
	public  CreateGoodsClassUI me=this;
	public StockItemVO  item =new  StockItemVO();
	Label label_img;
	
	
	
	public static void main(String args[]) {
		launch();
	}
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
        
		
		
		
		
		Label label_ds = new Label("Item");
		 label_ds.setFont(new Font(20));
 		label_ds  .setLayoutX(30);
 		label_ds .setLayoutY(65);
 		root.getChildren().add(label_ds );
 		
			Label label_goods = new Label("分类名称：");
	 		label_goods  .setLayoutX(230);
	 		label_goods .setLayoutY(105);
	 		root.getChildren().add(label_goods );
			
			
			TextField tf_className  =new 	TextField();
	    	tf_className .setLayoutX(290);
	    	tf_className .setLayoutY(105);
	    	tf_className .setMaxWidth(120);
	    	tf_className .setMaxHeight(10);;
	    	tf_className .setFont(new Font("黑体",11));
	    	tf_className .setText(goodsClass.getName());
	    	
	 		root.getChildren().add(tf_className );
        
        
		Label label_father = new Label("父类ID");
 		label_father .setLayoutX(230);
 		label_father .setLayoutY(175);
 		root.getChildren().add(label_father);
		
		
 		Label label_fatherValue = new Label(goodsClass.getUpperID());
 		label_fatherValue .setLayoutX(290);
 		label_fatherValue .setLayoutY(175);
 		root.getChildren().add(label_fatherValue);
 		
		
		
		
		
        
		MyButton label_buttonSave = new MyButton("保存", 20,80);
 		label_buttonSave .setLayoutX(230);
 		label_buttonSave  .setLayoutY(360);
 		label_buttonSave.setOnMousePressed(new EventHandler<MouseEvent>(){
 			
            @Override public void handle(MouseEvent e){
            	goodsClass.setName(tf_className.getText().trim());
            	
            	if(isEdit) {
            		try {
                		father.controller.modify(goodsClass);
    				} catch (RemoteException e1) {
    					// TODO 自动生成的 catch 块
    					e1.printStackTrace();System.out.println("chu cuol e");
    					
    				}
            		father.showTip("更改成功");
            	}
            	else {
            		try {
                		father.controller.add(goodsClass);
    				} catch (RemoteException e1) {
    					// TODO 自动生成的 catch 块
    					e1.printStackTrace();System.out.println("chu cuol e");
    					
    				}
            		father.showTip("创建成功");
            	}
            
            		
            	
            
            		
            	
            	
            	father.showItem(father.nowPage);	
            	stage.hide();
            	
            	
            }
            });
 		root.getChildren().add(label_buttonSave);
        
        
        
 		MyButton label_buttonBack = new MyButton("返回", 20,80);
 		label_buttonBack .setLayoutX(340);
 		label_buttonBack  .setLayoutY(360);
 		label_buttonBack	.setOnMousePressed(new EventHandler<MouseEvent>(){
 				
 			@Override public void handle(MouseEvent e){
 				stage.hide();
 				father.showItem(father.nowPage);	
 	          }
 	        });
 		root.getChildren().add(label_buttonBack);
 		
 		
 		
 		
 		String path="img\\default\\test.png";
 		if(this.goodsClass.getImagePath()!=null) {
 			path=goodsClass.getImagePath();
 		}
 		else {
 			goodsClass.setImage("img\\default\\test.png");
 		}
 		label_img = new Label("", new ImageView(new Image("file:"+path)));
 		label_img .setLayoutX(30);
 		label_img  .setLayoutY(100);
		root.getChildren().add(label_img);
	
 		
 		
 		
	
		MyButton label_changeImg = new MyButton("编辑图片", 20,80);
 		label_changeImg .setLayoutX(30);
 		label_changeImg  .setLayoutY(70);
 		label_changeImg.setOnMousePressed(new EventHandler<MouseEvent>(){
 			
            @Override public void handle(MouseEvent e){
            	FileChooser fileChooser = new FileChooser();
            	fileChooser.setTitle("Open Resource File");
            	 File file =fileChooser.showOpenDialog(stage);
            	
            	String t= Path+"/temp/"+file.hashCode()+".png";
				ImageZipUtil.zipWidthHeightImageFile(file, new File(t), 80, 80,1.0f);
    		
				root.getChildren().remove(label_img);
				Image image3 = new Image("file:"+t);
				label_img = new Label("", new ImageView(image3));
				label_img .setLayoutX(30);
				label_img  .setLayoutY(100);
				root.getChildren().add(label_img);
				goodsClass.setImage(t);;
            	
              }
            });
 		root.getChildren().add(label_changeImg);
 		
 		
 		
 		
        Scene scene = new Scene(root, 450, 400);
        stage.setScene(scene);

        stage.show();
    }
    
    private void initGoods() {
		// TODO 自动生成的方法存根
		goodsClass.setID("t1");

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


