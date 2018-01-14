package presentation.stockUI.stockSnap;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import BL.stockBL.StockController;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import presentation.littleUI.HELP.MyButton;
import utility.ExcelHelper;
import vo.Form.stockFormVO.StockItemVO;
import vo.goods.GoodsVO;

public class outputUI extends Application {
	protected String Path = null;
	public Object father;
	public GoodsVO goods=new GoodsVO("000", "default", "000");
	public int preNum=0;
	public boolean isEdit=false;
	public Pane pane;
	public  outputUI me=this;
	public StockItemVO  item =new  StockItemVO();
	public String [][]content;
	
	private String outPath="";
	
	
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
            		outPath =file.getCanonicalPath();
					System.out.println( file.getCanonicalPath());
					tf_filePath.setText( file.getCanonicalPath());
            	} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				};
            }
            });
 		root.getChildren().add(label_xxx );
 		

 		
 		Label label_startNum =new Label("导出格式");
 		label_startNum  .setLayoutX(30);
 		label_startNum.setLayoutY(110);
 		root.getChildren().add(label_startNum);
		
 		
		ArrayList<String> optionList=new ArrayList<String>();
		optionList.add(".xsxl");
 		ObservableList<String> options=FXCollections.observableArrayList(optionList);
 		 ComboBox<String> comboBox= new ComboBox<String>(options);
 	//	comboBox.getSelectionModel().select(" "); // [0, options.size())
 		comboBox.setLayoutX(150);
 		comboBox.setLayoutY(110);
 		comboBox.setMinSize(250, 10);
 		comboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {  
            @Override  
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {  
            	System.out.println(newValue);
            }  
        }); 
 		root.getChildren().add(comboBox);
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
// 		toNewExcel(String tableName,String[][] content , String filePath) 
	
        
 		MyButton label_buttonSave = new MyButton("导出", 20,80);
 		label_buttonSave .setLayoutX(230);
 		label_buttonSave  .setLayoutY(160);
 		label_buttonSave.setOnAction((ActionEvent event) -> {
 			try {
				new StockController().examine().toExcel( outPath+"\\out.xlsx");
				stage.hide();
			} catch (RemoteException e1) {
				
			}
 		
		});
 		root.getChildren().add(label_buttonSave);
 		
        
        
 		MyButton label_buttonBack = new MyButton("返回",20,80);
 		label_buttonBack .setLayoutX(340);
 		label_buttonBack  .setLayoutY(160);
 		label_buttonBack.setOnAction((ActionEvent event) -> {
			stage.hide();
		});
 		root.getChildren().add(label_buttonBack);
 		
 		
 		
 		
 	
		
 		
        Scene scene = new Scene(root, 450, 200);
    	stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(scene);
		stage.showAndWait();
		// stage.show();
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


