package presentation.strategyUI;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import BLService.strategyBLService.stub.StrategyBLServiceStub;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import utility.LevelOfCustomer;
import vo.goods.GoodsVO;
import vo.strategy.CustomerStrategyVO;
import vo.strategy.GoodsStrategyVO;
import vo.strategy.StrategyVO;
import vo.strategy.TotalStrategyVO;


public class strategyManageUI extends Application {
	private ArrayList<StrategyVO> strategyList=new ArrayList<StrategyVO>();
	private ArrayList<Label> list = new ArrayList<Label>();
	private Label titleLabel = new Label(),rowLabel = new Label(),nameLabel = new Label(),
			startTimeLabel = new Label(),endTimeLabel = new Label();
	protected Label label_formHighLight= new Label();
	private Button addButton = new Button(), selectButton = new Button();
	private Pane root = new Pane();
	private Font font1 = new Font("楷体",18);
	private Font font2 = new Font("楷体",15);
	private int pageSize = 10, line=0;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		root = getStrategyManageUIPane(primaryStage);
		//root = showList();
	}
	
	public Pane getStrategyManageUIPane(Stage primaryStage){
		double sX=0,sY=0;
		
		Scene scene = new Scene(root,600,600);
		titleLabel.setText("促销策略管理");
		titleLabel.setLayoutX(30);
		titleLabel.setLayoutY(10);
		titleLabel.setFont(new Font("楷体",23));
		root.getChildren().add(titleLabel);
		
		Line line = new Line();
		line.setStartX(27);
		line.setStartY(45);
		line.setEndX(580);
		line.setEndY(45);
		line.setStrokeWidth(2.5);
		line.setStroke(Color.GRAY);
		root.getChildren().add(line);
		
		addButton.setText(" 添加新策略 ");
		addButton.setLayoutX(45);
		addButton.setLayoutY(62);
		addButton.setFont(font1);
		addButton.setOnMouseEntered(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				Button obj=(Button)e.getSource();
        		double x=obj.getLayoutX();
        		double y=obj.getLayoutY();
        		obj.setLayoutX(x+2);
        		obj.setLayoutY(y+2);
			}
			
		});
		addButton.setOnMouseExited(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				Button obj=(Button)e.getSource();
        		double x=obj.getLayoutX();
        		double y=obj.getLayoutY();
        		obj.setLayoutX(x-2);
        		obj.setLayoutY(y-2);
			}
			
		});
		
		addButton.setOnMousePressed(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				NewStrategyUI create = new NewStrategyUI();
				try {
					create.start(new Stage());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		root.getChildren().add(addButton);
		
		selectButton.setText("筛 选");
		selectButton.setLayoutX(280);
		selectButton.setLayoutY(62);
		selectButton.setFont(font1);
		selectButton.setVisible(false);
		selectButton.setOnMouseEntered(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				Button obj=(Button)e.getSource();
        		double x=obj.getLayoutX();
        		double y=obj.getLayoutY();
        		obj.setLayoutX(x+2);
        		obj.setLayoutY(y+2);
			}
			
		});
		selectButton.setOnMouseExited(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				Button obj=(Button)e.getSource();
        		double x=obj.getLayoutX();
        		double y=obj.getLayoutY();
        		obj.setLayoutX(x-2);
        		obj.setLayoutY(y-2);
			}
			
		});
		selectButton.setOnMousePressed(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		root.getChildren().add(selectButton);
		
		rowLabel.setText("行号");
		rowLabel.setLayoutX(26);
		rowLabel.setLayoutY(120);
		rowLabel.setFont(font2);
		root.getChildren().add(rowLabel);
		
		nameLabel.setText("策略编号");
		nameLabel.setLayoutX(120);
		nameLabel.setLayoutY(120);
		nameLabel.setFont(font2);
		root.getChildren().add(nameLabel);
		
		startTimeLabel.setText("生效时间");
		startTimeLabel.setLayoutX(300);
		startTimeLabel.setLayoutY(120);
		startTimeLabel.setFont(font2);
		root.getChildren().add(startTimeLabel);
		
		endTimeLabel.setText("间隔时间");
		endTimeLabel.setLayoutX(450);
		endTimeLabel.setLayoutY(120);
		endTimeLabel.setFont(font2);
		root.getChildren().add(endTimeLabel);
		
				
        root.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE,null,null)));
		primaryStage.setScene(scene);
 		//primaryStage.show();
 		
 		initList();
 		
 		
 		return root;
 				
	}
	
	//显示已有销售策略
	protected Pane showList(Pane root, double sx, double sy, int page){
		double sX=sx, sY=sy;
		for(int i=0;i<list.size();i++) {
			(list.get(i)).setVisible(false);
		}
		
		int c=150;
		for(int i=page*pageSize;i<strategyList.size()&&i<pageSize*(page+1);i++){
			line = i;
			Date d = strategyList.get(i).getStartTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String st = sdf.format(d);
			Label label_item = new Label(i+1 + "       "+strategyList.get(i).getID()+"                  "+st+"                  "
					+strategyList.get(i).getDuration()+"  ");
			label_item.setLayoutX(32);
			label_item.setLayoutY(c);
			label_item.c = c;
            label_item.setOnMouseEntered(new EventHandler<MouseEvent>(){
	 			
	            @Override public void handle(MouseEvent e){
	            	label_item.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE,null,null)));
	            	
	              }
	            });
	 		label_item.setOnMouseExited(new EventHandler<MouseEvent>(){
	 			
	            @Override public void handle(MouseEvent e){
	            	label_item.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE,null,null)));
	              }
	            });
	 		label_item.setOnMouseClicked(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent e) {
					// TODO Auto-generated method stub
					CustomerStrategyInfoUI csi = new CustomerStrategyInfoUI();
					System.out.println("ok");
					try {
						System.out.println("ok");
						csi.InfoPane((CustomerStrategyVO) strategyList.get(0));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
	 			
	 		});
	 		
			list.add(label_item);
			root.getChildren().add(label_item);			
			c+=30;
			
		}
		root=createPageSelect(root, sX, sY, page);
 		return root;
		
	}
	
	//按分页方式显示已有销售策略
	protected Pane createPageSelect(Pane root, double sx, double sy, int page) {
		int endPage = strategyList.size() % pageSize + 1;
		// TODO 自动生成的方法存根
		double sX = sx,sY = sy;
		double usedX = 0;
		
		if(strategyList.size()>pageSize) {
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
	
	//初始化策略列表
	public void initList(){
		/*strategyList.clear();
		StrategyBLServiceStub sbls = new StrategyBLServiceStub();
		for(int i=0;i<sbls.getAllStrategy().size();i++){
			strategyList.add(sbls.getAllStrategy().get(i));
			
		}
		strategyList = sbls.getAllStrategy();*/
		for(int i=0;i<6;i++) {
			LevelOfCustomer lb = LevelOfCustomer.level5;
			LevelOfCustomer le = LevelOfCustomer.level5;
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");			
			Date d = null;
			try {
				d = simpleDateFormat.parse("2018-01-10");
			} catch (ParseException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			CustomerStrategyVO e = new CustomerStrategyVO(d, 45, "201712272325", lb, le, i, null);		
			e.setID("stc-201712271720"+Integer.toString(i%10)+Integer.toString(0));
			e.setDuration(45);
			strategyList.add(e);
		}
		for(int i=0;i<6;i++){
			LevelOfCustomer lb = LevelOfCustomer.level1;
			LevelOfCustomer le = LevelOfCustomer.level2;
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");			
			Date d = null;
			try {
				d = simpleDateFormat.parse("2018-01-13");
			} catch (ParseException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			CustomerStrategyVO e = new CustomerStrategyVO(d, 60, "", lb, le, i, null);		
			e.setID("stc-201712291542"+Integer.toString(i%10)+Integer.toString(0));
			e.setDuration(60);
			strategyList.add(e);
		}
		showList(root, 0, 0, 0);
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
	
	public void deleteS(){
		strategyList.remove(0);
		initList();
	}
	 
	protected String getImgPath() {
		return "";
	}
	
	public static void main(String[] args) {
		launch(args);
}

}
