package presentation.accountUI;

import java.io.File;
import java.rmi.RemoteException;
import java.util.ArrayList;

import BL.accountBL.AccountController;
import BLService.accountBLService.accountBLService;
import javafx.application.Application;
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
import po.KeyForSearchAccount;
import presentation.littleUI.TipUI;
import vo.AccountVO;
import vo.UserVO;
import vo.goods.GoodsVO;
 

/** 
* 
* @author Alan 
*/  
public class AccountManageUI extends Application{
	
	public UserVO user;
	AccountManageUI me =this;
	
	//GoodsClassVO nowClass ;
	accountBLService controller =new AccountController();
	public Pane root =new Pane(),locationPane=new Pane(), itemsPane=new Pane();
	String Path="";
	Stage stage;
	TextField tf_search;
	Label label_searchMes;
	int pageSize=4;
	public int nowPage=0;
	boolean isSearching=false;
	ArrayList <AccountVO> VOtoShow=new 	ArrayList <AccountVO>();
	button label_newSubClass,label_searchbutton ; 
	boolean isSearchResult=false;
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public AccountManageUI() {
		initData();
		initList();
		root = initPane();
		
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		this.stage =stage;
		stage.initStyle(StageStyle. TRANSPARENT);//无边框
 		stage.setAlwaysOnTop(true);
 		//stage.setResizable(false);//不能改变大小
 		Scene scene = new Scene(root,700,600);
 		stage.setScene(scene);
 		stage.show();

	}
	public Pane initPane( ) {

		
		
		Label label_title=new Label("银行账户管理");
		label_title .setLayoutX(30);
		label_title  .setLayoutY(40);
		label_title.setFont(new Font(22));
		root.getChildren().add(label_title);
				
		Image image1 = new Image("file:"+Path+getImgPath()+"stock\\line.png");
 		Label label_line1 = new Label("", new ImageView(image1));
 		label_line1 .setLayoutX(30);
 		label_line1  .setLayoutY(70);

		root.getChildren().add(label_line1);
		
		
	//	label_searchMes
		
		
		
		
		
		
		
		
		
		Image image2 = new Image("file:"+Path+getImgPath()+"button\\button_new.png");
 		label_newSubClass = new button("", new ImageView(image2));
 		label_newSubClass .setLayoutX(30);
 		label_newSubClass.setLayoutY(100);
 		label_newSubClass.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e){
            	CreateAccountUI c= new CreateAccountUI ();
            	c.father=me;
            	c.account=new AccountVO();
            	c.start(new Stage());

              }
            });
		root.getChildren().add(label_newSubClass);
		
		
		
		Image imag1 = new Image("file:"+Path+getImgPath()+"button\\button_search.png");
 		label_searchbutton = new button("", new ImageView(imag1));
 		label_searchbutton .setLayoutX(150);
 		label_searchbutton.setLayoutY(100);
 		label_searchbutton.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override public void handle(MouseEvent e){
            	SearchAccountUI c= new SearchAccountUI ();
            	c.father=me;
            	c.start(new Stage());

              }
            });
		root.getChildren().add(label_searchbutton); 
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		Image image4 = new Image("file:"+Path+getImgPath()+"stock\\searchPane.png");
 		Label	label_searchPane = new Label("", new ImageView(image4));
 		label_searchPane .setLayoutX(352);
 		label_searchPane  .setLayoutY(42);
		root.getChildren().add(label_searchPane);
		
		
		 tf_search =new  TextField();
		tf_search.setMinHeight(19);;
		tf_search.setMinWidth(216);
		tf_search.setLayoutX(388);
		tf_search.setLayoutY(47);	//	stage.initStyle(StageStyle. TRANSPARENT);//无边框
		//tf_search.setsty
		root.getChildren().add(tf_search);
		
		
		
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
		
	
	//	System.out.println(nowClass.getID());
	
		if(VOtoShow.size()==0) {
			return;
		}
		
	
		Object obj=(VOtoShow.get(0));
		if(obj  instanceof GoodsVO) {

			
		}
		else {
		
			int num=0;
			for(int i=pageSize*page;i<VOtoShow.size()&&i<(page+1)*pageSize;i++) {
				myPane_accountItem V =new myPane_accountItem();
				V.page=page;
				V.item=(VOtoShow.get(i));
				V.make();
				V.setLayoutX(0);
				V.setLayoutY(100*num+0);
				itemsPane.getChildren().add(V);
				num++;
			}
			itemsPane=createPageSelect(itemsPane,page);
		}
		
		
	
		
		
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
		
		File directory = new File("");//设定为当前文件夹 
		try{ 
			 
		     Path=directory.getCanonicalPath();

		}catch(Exception e){} 
		
	}
	public void initList() {
		VOtoShow.clear();
		KeyForSearchAccount key =new 	KeyForSearchAccount ();
		
		try {
			VOtoShow =controller.searchAccount(key);
		} catch (RemoteException e) {
			TipUI.showMessageDialog(stage, "错误/n无法连接到服务器", "error");
			e.printStackTrace();
		}
	
	}
	
	public  String getImgPath() {
		return "\\img\\";
		
	}
	
	public class myPane_accountItem extends Pane{
		AccountVO item;
		//myPane_accountItem me=this;
		int page=0;
		
		public void make() {
			
			this.setMaxHeight(100);
			this.setMaxWidth(640);
			this.setMinHeight(100);
			
			Line line1=new Line();
	 		line1.setStartX(0);
	 		line1.setStartY(1);
	 		line1.setEndX(640);
	 		line1.setEndY(1);
	 		line1.setStrokeWidth(0.1);
	 		this.getChildren().add(line1);
			
	 		if(item.getImage()==null) {
				item.setImage(new Image("file:"+item.getImagePath()));
			}
		
	 		Label	label_img = new Label("", new ImageView(item.getImage()));
	 		label_img.setMaxHeight(80);
	 		label_img.setMaxWidth(80);
	 		label_img .setLayoutX(10);
	 		label_img  .setLayoutY(10);
	 		this.getChildren().add(label_img);
			
	 		
	 		if(item.getName()==null) {
	 			item.setName("default");
	 		}
	 		
	 		
	 		Label	label_Name = new Label("账户名："+item.getName());
	 		label_Name.setFont(new Font(14));
	 		label_Name.setLayoutX(150);
	 		label_Name .setLayoutY(10);
	 		this.getChildren().add(label_Name);
	 		
	 		Line line2=new Line();
	 		line2.setStartX(150);
	 		line2.setStartY(35);
	 		line2.setEndX(600);
	 		line2.setEndY(35);
	 		line2.setStrokeWidth(0.5);
	 		this.getChildren().add(line2);
	 		
	 		Label	label_userName = new Label("账户账号："+item.getID());
	 		label_userName .setFont(new Font(12));
	 		label_userName .setLayoutX(150);
	 		label_userName  .setLayoutY(45);
	 		this.getChildren().add(label_userName );
	 		
	 		Label	label_password = new Label("初始密码："+item.getPassword());
	 		label_password .setFont(new Font(12));
	 		label_password.setLayoutX(150);
	 		label_password  .setLayoutY(65);
	 		this.getChildren().add(label_password);
	 		
	 		
	 		
	 		
	 		
	 		
	 		Label	label_edit = new Label("编辑");
	 		label_edit.setFont(new Font(12));
	 		label_edit.setTextFill(Color.DARKGRAY);
	 		label_edit.setLayoutX(610);
	 		label_edit .setLayoutY(10);
	 		label_edit .setOnMousePressed(new EventHandler<MouseEvent>(){
	            @Override
	            public void handle(MouseEvent e){
	            	CreateAccountUI c=new 		CreateAccountUI ();
	            	c.account=item;
	            	c.father=me;
	            	c.isCreate=false;
	            	c.isEdit=true;
	            	c.start(new Stage());
	            	
	            	
	             }
	            });
	 		label_edit.setOnMouseEntered(new EventHandler<MouseEvent>(){
	            @Override
	            public void handle(MouseEvent e){
	            		Label obj=(Label) e.getSource();
	            		obj.setBackground(new Background(new BackgroundFill(Color.BISQUE,null,null)));
	            		
	             }
	            });
	 		label_edit.setOnMouseExited(new EventHandler<MouseEvent>(){
	            @Override public void handle(MouseEvent e){
	          		Label obj=(Label) e.getSource();
	            	obj.setBackground(null);
	              }
			});
	 		this.getChildren().add(label_edit);
	 		
	 		
	 		
	 		
	 		
	 		
	 		
	 		
	 		
	 		this.setOnMousePressed(new EventHandler<MouseEvent>(){
	            @Override
	            public void handle(MouseEvent e){
	            
	            	
	             }
	            });
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
	 		Label	label_delete= new Label("删除");
	 		label_delete.setFont(new Font(12));
	 		label_delete.setTextFill(Color.DARKGRAY);
	 		label_delete.setLayoutX(610);
	 		label_delete .setLayoutY(40);
	 		label_delete .setOnMousePressed(new EventHandler<MouseEvent>(){
	            @Override
	            public void handle(MouseEvent e){
	            	TipUI.showConfirmDialog(stage, "警告\n您真的要删除它吗？", "confirm");
	            	if(TipUI.buttonSelected==TipUI.Response.YES) {
	            		try {
		            		controller.deleteAccount(item.getID());
							TipUI.showMessageDialog(stage, "恭喜您\n操作成功", "confirm");
							
						} catch (RemoteException e1) {
							// TODO 自动生成的 catch 块
							TipUI.showMessageDialog(stage, "网络错误\n无法连接至服务器", "error");
							e1.printStackTrace();
						}
	            	}
	            	
                	
	            	showItem(me.nowPage);
	             }
	            });
	 		label_delete.setOnMouseEntered(new EventHandler<MouseEvent>(){
	            @Override
	            public void handle(MouseEvent e){
	            		Label obj=(Label) e.getSource();
	            		obj.setBackground(new Background(new BackgroundFill(Color.BISQUE,null,null)));
	                    }
	            });
	 		label_delete.setOnMouseExited(new EventHandler<MouseEvent>(){
	 			
	            @Override public void handle(MouseEvent e){
	            	Label obj=(Label) e.getSource();
	            	obj.setBackground(null);
	              }
			});
	 		this.getChildren().add(label_delete);
	 		
		}
	}
	
	public class myPane_goods extends myPane_accountItem{
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
		label_newSubClass.setVisible(false);
    	label_searchbutton.setVisible(false);
		if(	label_searchMes!=null) {
			root.getChildren().remove(label_searchMes);
		}
		label_searchMes=new Label("当前共有搜索结果 "+VOtoShow.size()+" 条，点此返回 ❤");
		label_searchMes.setLayoutX(30);
		label_searchMes.setLayoutY(100);
		label_searchMes.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override public void handle(MouseEvent e){
            	root.getChildren().remove(label_searchMes);
            	isSearching=false;
            	label_newSubClass.setVisible(true);
            	label_searchbutton.setVisible(true);
            	showItem(0);
              }
            });
 		
		root.getChildren().add(label_searchMes);
		
		
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
	
		if(VOtoShow.size()==0) {
			return;
		}
		
	
		
			int num=0;
			for(int i=pageSize*page;i<VOtoShow.size()&&i<(page+1)*pageSize;i++) {
				myPane_accountItem V =new myPane_accountItem();
				V.page=page;
				V.item=(VOtoShow.get(i));
				V.make();
				V.setLayoutX(0);
				V.setLayoutY(100*num+0);
				itemsPane.getChildren().add(V);
				num++;
			}
			itemsPane=createPageSelect(itemsPane,page);
		
		
		
	
		
		
	}
	
	
	
	
	
	
	
	public void newAccount(AccountVO in) {
	}
	
	public void delete() {
		
	}
	
	
	
	
	
}		