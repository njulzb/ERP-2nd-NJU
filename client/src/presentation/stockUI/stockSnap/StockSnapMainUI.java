package presentation.stockUI.stockSnap;

import java.io.File;
import java.rmi.RemoteException;
import java.util.ArrayList;

import BL.logBL.LogController;
import BL.stockBL.Goods;
import BL.stockBL.StockController;
import BL.stockBL.Info.StockInfo;
import BLService.logBLService.LogService;
import BLService.stockBLService.StockBLService;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import po.KeyForSearchLog;
import presentation.littleUI.QiPaoUI;
import presentation.littleUI.TipUI;
import presentation.littleUI.HELP.MyButton;
import presentation.logUI.SearchLogUI;
import vo.LogItemVO;
import vo.goods.GoodsVO;
 

/** 
* 
* @author Alan 
*/  
public class StockSnapMainUI extends Application{
	StockSnapMainUI me =this;
	//GoodsClassVO nowClass ;
	StockController controller =new StockController();
	public Pane root =new Pane(),locationPane=new Pane(), itemsPane=new Pane();
	String Path="";
	Stage stage;
	TextField tf_search;
	Label label_searchMes;
	int pageSize=12;
	public int nowPage=0;
	boolean isSearching=false;
	ArrayList <GoodsVO> VOtoShow=new 	ArrayList <GoodsVO>();
	button label_newSubClass,label_searchbutton ; 
	boolean isSearchResult=false;
	
//	public static void main(String args[]) {
//		launch();
//	}
//	
	public static void main(String[] args) {
		launch(args);
	}
	
	public StockSnapMainUI() {
		initData();
		initList();
		root = initPane();
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		System.out.println("111");
		
		this.stage =stage;
		stage.initStyle(StageStyle. TRANSPARENT);//无边框
 		stage.setAlwaysOnTop(true);
 		//stage.setResizable(false);//不能改变大小
 		Scene scene = new Scene(root,700,600);
// 		root = initPane();
		
 		stage.setScene(scene);
 		stage.show();

	}
	public Pane initPane( ) {

		Label label_title=new Label("库存快照");
		label_title .setLayoutX(30);
		label_title  .setLayoutY(40);
		label_title.setFont(new Font(22));
		root.getChildren().add(label_title);
				
		Image image1 = new Image("file:"+Path+getImgPath()+"stock\\line.png");
 		Label label_line1 = new Label("", new ImageView(image1));
 		label_line1 .setLayoutX(30);
 		label_line1  .setLayoutY(70);

		root.getChildren().add(label_line1);
		
		
		MyButton button_out =new MyButton("导出",20,80);
 		button_out  .setLayoutX(30);
 		button_out .setLayoutY(100);
 		button_out.setOnAction((ActionEvent event) -> {
 			
 			
			outputUI ui=new outputUI();
			
			ui.start(new Stage());
		
			
			
			
			
		});
		root.getChildren().add(button_out ); 
		
		
		
		
		showItem(0);
		return root ;
		
	}
	public  void showItem( int page ) {
		
		initList();
		 nowPage=page;
		if(root.getChildren().contains(itemsPane)) {
			root.getChildren().remove(itemsPane);
		}
		
		itemsPane =new Pane();
		itemsPane.setLayoutX(30);
		itemsPane.setLayoutY(150);
		itemsPane.setMinWidth(640);
		itemsPane.setMinHeight(450);
	
		
		root.getChildren().add(itemsPane);
		
		Image imag1 = new Image("file:"+Path+getImgPath()+"stock\\StockSnap.png");
 		Label label_H = new Label("", new ImageView(imag1));
 		 label_H .setLayoutX(0);
 		 label_H .setLayoutY(-10);
 		itemsPane.getChildren().add( label_H );
            	

		
		
		
	
		if(VOtoShow.size()==0) {
			return;
		}
		
		int num=0;
		for(int i=pageSize*page;i<VOtoShow.size()&&i<(page+1)*pageSize;i++) {
			myPane_goods V =new myPane_goods();
			V.no=num;
				V.page=page;
				V.item=VOtoShow.get(i);
				V.make();
				V.setLayoutX(0);
				V.setLayoutY(30*num+25);
				itemsPane.getChildren().add(V);
				num++;
		}
		itemsPane=createPageSelect(itemsPane,page);
		
		
		
		
	}
	
	protected Pane createPageSelect(Pane root ,int page) {
		
		int endPage = (int) Math.floor(VOtoShow.size() / pageSize) ;
		// TODO 自动生成的方法存根
		double sX=100,sY=-80;
		double usedX=0;
		
		if(VOtoShow.size()>pageSize) {
			if(page!=0) {
				Label label_11 = new Label("首页");
		 		label_11.setLayoutX(sX+usedX+30);
		 		usedX+=50;
		 		label_11.setLayoutY(sY+485);
		 		label_11.setFont(new Font("黑体",12));
		 		label_11.setTextFill(Color.BLUE);
		 		label_11.setOnMousePressed(new EventHandler<MouseEvent>(){
		            @Override public void handle(MouseEvent e){
		            	if(isSearching) {
		            		showSearchItem(0);
		            	}
		            	else {
		            		showItem(0);
		            	}
		            	
		              }
		            });
		 		root.getChildren().add(label_11);
		 		
		 		Label label_22 = new Label("上一页 ");
		 		label_22.setLayoutX(sX+usedX+30);
		 		usedX+=50;
		 		label_22.setLayoutY(sY+485);
		 		label_22.setFont(new Font("黑体",12));
		 		label_22.setTextFill(Color.BLUE);
		 		label_22.setOnMousePressed(new EventHandler<MouseEvent>(){
		            @Override public void handle(MouseEvent e){
		            	if(isSearching) {
			            		showSearchItem(page-1 );
			            	}
			            	else {
			            		showItem(page-1 );
			            	}
		            
		              }
		            });
		 		root.getChildren().add(label_22);
		 		
		 		Label label_33 = new Label(" "+Integer.toString(page));
		 		label_33.setLayoutX(sX+usedX+30);
		 		usedX+=50;
		 		label_33.setLayoutY(sY+485);
		 		label_33.setFont(new Font("黑体",12));
		 		label_33.setTextFill(Color.BLUE);
		 		label_33.setOnMousePressed(new EventHandler<MouseEvent>(){
		            @Override public void handle(MouseEvent e){
		            	   if(isSearching) {
			            		showSearchItem(page-1 );
			            	}
			            	else {
			            		showItem(page-1 );
			            	}
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
	 	
	 		root.getChildren().add(label_44);
	 		
	 		
	 		if(page!=endPage) {
	 			
	 			Label label_33 = new Label(Integer.toString(page+2));
		 		label_33.setLayoutX(sX+usedX+30);
		 		usedX+=40;
		 		label_33.setLayoutY(sY+485);
		 		label_33.setFont(new Font("黑体",12));
		 		label_33.setTextFill(Color.BLUE);
		 		label_33.setOnMousePressed(new EventHandler<MouseEvent>(){
		            @Override public void handle(MouseEvent e){
		            	   if(isSearching) {
			            		showSearchItem(page+1 );
			            	}
			            	else {
			            		showItem(page+1 );
			            	}
		              }
		            });
		 		root.getChildren().add(label_33);

		 		
		 		
		 		Label label_22 = new Label("下一页 ");
		 		label_22.setLayoutX(sX+usedX+30);
		 		usedX+=40;
		 		label_22.setLayoutY(sY+485);
		 		label_22.setFont(new Font("黑体",12));
		 		label_22.setTextFill(Color.BLUE);
		 		label_22.setOnMousePressed(new EventHandler<MouseEvent>(){
		            @Override public void handle(MouseEvent e){
		            	if(isSearching) {
		            		showSearchItem(page+1 );
		            	}
		            	else {
		            		showItem(page+1 );
		            	}
		              }
		            });
		 		root.getChildren().add(label_22);
	 			
				Label label_11 = new Label(" 尾页");
		 		label_11.setLayoutX(sX+usedX+30);
		 		usedX+=50;
		 		label_11.setLayoutY(sY+485);
		 		label_11.setFont(new Font("黑体",12));
		 		label_11.setTextFill(Color.BLUE);
		 		label_11.setOnMousePressed(new EventHandler<MouseEvent>(){
		            @Override public void handle(MouseEvent e){
		            	if(isSearching) {
		            		showSearchItem(endPage );
		            	}
		            	else {
		            		showItem(endPage);
		            	}
		              }
		            });
		 		root.getChildren().add(label_11);
		 		
		 		
			}
	 		
	 		
		}
		
		return root;
		
	}
	
	public void initData() {
		
		 Path="";
		
	}
	public void initList() {
		VOtoShow.clear();
		KeyForSearchLog key =new 	KeyForSearchLog ();
		
		try {
			
			
			
			VOtoShow =controller.search("");
		} catch (RemoteException e) {
			TipUI.showMessageDialog(stage, "错误/n无法连接到服务器", "error");
			e.printStackTrace();
		}
	
	}
	
	public  String getImgPath() {
		return "img\\";
		
	}
	
	public class myPane_goods extends Pane{
		GoodsVO item;
		//myPane_accountItem me=this;
		int page=0;
		public int no;
		public void make() {
			
			this.setMaxHeight(30);
			this.setMaxWidth(640);
			this.setMinWidth(640);
			this.setMinHeight(30);
			
	 		Label	label_LineNum = new Label(no+"");
	 		label_LineNum.setFont(new Font(12));
	 		label_LineNum.setLayoutX(20);
	 		label_LineNum .setLayoutY(5);
	 		this.getChildren().add(label_LineNum);
	 		
	 		
	 		
	 		
	 		Label	label_name = new Label(item.getName());
	 		label_name.setFont(new Font(12));
	 		label_name.setLayoutX(70);
	 		label_name .setLayoutY(5);
	 		this.getChildren().add(label_name);
	
	 		
	 		Label	label_ID= new Label(item.getType());
	 		label_ID .setFont(new Font(12));
	 		label_ID .setLayoutX(150);
	 		label_ID  .setLayoutY(5);
	 		this.getChildren().add(label_ID );
	 		
	 		Label	label_num = new Label(item.getNumbers()+"");
	 		label_num  .setFont(new Font(12));
	 		label_num .setLayoutX(225);
	 		label_num  .setLayoutY(5);
	 		this.getChildren().add(label_num );
	 		
	 		Label	label_price= new Label(item.getBuyingPrice()+"1");
	 		label_price  .setFont(new Font(12));
	 		label_price .setLayoutX(310);
	 		label_price  .setLayoutY(5);
	 		this.getChildren().add(label_price );
	 		
	 		Label	label_batchId= new Label(item.getBatchID()+"1");
	 		label_batchId  .setFont(new Font(12));
	 		label_batchId .setLayoutX(420);
	 		label_batchId  .setLayoutY(5);
	 		this.getChildren().add(label_batchId );
	 		
			Label	label_outDate= new Label(item.getProductionDate()+"1");
			label_outDate  .setFont(new Font(12));
			label_outDate .setLayoutX(510);
			label_outDate  .setLayoutY(5);
	 		this.getChildren().add(label_outDate );
	 		
	 
	 		this.setOnMouseEntered(new EventHandler<MouseEvent>(){
	            @Override
	            public void handle(MouseEvent e){
	            		Pane obj=(Pane) e.getSource();
	            		obj.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY,null,null)));
	            		
	             }
	            });
	 		this.setOnMouseExited(new EventHandler<MouseEvent>(){
	            @Override public void handle(MouseEvent e){
	            	Pane obj=(Pane) e.getSource();
	            	obj.setBackground(null);
	              }
			});
	 		
	 		
		}
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
	public void showSearchItem(int page) {
    	
		isSearching=true;
		if(	label_searchMes!=null) {
			root.getChildren().remove(label_searchMes);
		}
		label_searchbutton.setVisible(false);
		label_searchMes=new Label("当前共有搜索结果 "+VOtoShow.size()+" 条，点此返回 ❤");
		label_searchMes.setLayoutX(30);
		label_searchMes.setLayoutY(100);
		label_searchMes.setOnMousePressed(new EventHandler<MouseEvent>(){
			
            @Override public void handle(MouseEvent e){
            	root.getChildren().remove(label_searchMes);
            	label_searchbutton.setVisible(true);
            	isSearching=false;
            	showItem(0);
              }
            });
		root.getChildren().add(label_searchMes);
		
		
		
		
		
		
		Image imag1 = new Image("file:"+Path+getImgPath()+"log\\logH.png");
 		Label label_H = new Label("", new ImageView(imag1));
 		 label_H .setLayoutX(0);
 		 label_H .setLayoutY(-10);
 		itemsPane.getChildren().add( label_H );
            	
		
		
		
		if(root.getChildren().contains(itemsPane)) {
			root.getChildren().remove(itemsPane);
		}
		
		itemsPane =new Pane();
		itemsPane.setLayoutX(30);
		itemsPane.setLayoutY(150);
		itemsPane.setMinWidth(640);
		itemsPane.setMinHeight(450);
	
		
		root.getChildren().add(itemsPane);
		
	
	//	System.out.println(nowClass.getID());
	
		

		Image imag11 = new Image("file:"+Path+getImgPath()+"log\\logH.png");
 		Label label_w = new Label("", new ImageView(imag11));
 		 label_w .setLayoutX(0);
 		 label_w .setLayoutY(-10);
 		itemsPane.getChildren().add( label_H );
            	

		
		
		if(VOtoShow.size()==0) {
			return;
		}
		
			int num=0;
			for(int i=pageSize*page;i<VOtoShow.size()&&i<(page+1)*pageSize;i++) {
				myPane_goods V =new myPane_goods();
				V.page=page;
				V.item=VOtoShow.get(i);
				V.make();
				V.setLayoutX(0);
				V.setLayoutY(30*num+30);
				itemsPane.getChildren().add(V);
				num++;
			}
			itemsPane=createPageSelect(itemsPane,page);
		
		
		
	
		
		
	}
	
	
	
	
	
	
	
}		