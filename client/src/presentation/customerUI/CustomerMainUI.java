package presentation.customerUI;

import java.io.IOException;
import java.util.ArrayList;

import BL.customerBL.CustomerController;
import BLService.customerBLService.CustomerBLService;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import po.KeyForSearchCustomer;
import presentation.littleUI.QiPaoUI;
import vo.CustomerVO;

public class CustomerMainUI {
	private KeyForSearchCustomer key;
	private ArrayList<CustomerVO> customerList;
	private String mode;
	private AnchorPane pane;

	//返回管理客户界面的面板
	public AnchorPane CustomerPane() throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CustomerMainUI.fxml"));
		pane =fxmlLoader.load();
		CustomerMainUIController controller = fxmlLoader.getController();
//		ScrollPane sp = new ScrollPane();
		VBox list=new VBox();

		CustomerBLService customerBLService = new CustomerController();
		customerList=customerBLService.getCustomerList(this.key);

		for (int i=0;i<customerList.size();i++){
			CustomerInfoUI customerInfoUI =new CustomerInfoUI();
			AnchorPane customerPane=customerInfoUI.InfoPane(customerList.get(i));
			customerPane.toFront();
			list.getChildren().add(customerPane);
		}

		controller.setScrollPane(list);

		if (mode.equals("new")){
			controller.setNewButton();
			//controller.setDeleteButton();
			controller.setSelectButton();
			controller.removeBackButton();
		}

		if (mode.equals("sel")){
			controller.setSelectButton();
			controller.setBackButton();
			//controller.removeDeleteButton();
			controller.removeNewButton();
		}

		return pane;
	}
//设置显示筛选客户列表
	public void setKey(KeyForSearchCustomer Key){

		this.key=Key;
	}
//设置当前状态，来显示相对应按钮
	public void setSelect(String mode) {
		// TODO Auto-generated method stub
		this.mode=mode;
	}
//提示
	public void setMessage(String text) throws IOException{
		QiPaoUI notice = new QiPaoUI();
		notice.showTip(pane, text);
	}
}
