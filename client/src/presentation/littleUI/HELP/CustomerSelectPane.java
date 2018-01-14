package presentation.littleUI.HELP;

import java.util.ArrayList;

import BL.customerBL.CustomerController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import po.KeyForSearchCustomer;
import vo.CustomerVO;

public class CustomerSelectPane extends Pane {
	private CustomerController controller = new CustomerController();
	private ArrayList<CustomerVO> cusList = new ArrayList<CustomerVO>();
	private ArrayList<String> cusNameList = new ArrayList<String>();

	ComboBox<String> cb;

	public CustomerSelectPane() {
	KeyForSearchCustomer key =new KeyForSearchCustomer();
		cusList = controller.getCustomerList(key);
		for (CustomerVO vo : cusList) {
			cusNameList.add(vo.getName());
		}
		makeUI();
	}

	public CustomerVO getCustomer() {
		int i = cb.getSelectionModel().getSelectedIndex();
		if(cb.getSelectionModel().getSelectedItem()==null) {
			System.out.println("未选择customer");
			return null;
		}
		System.out.println("customerSelector:i= " + i);
		CustomerVO out = (CustomerVO) cusList.get(i);
		return out;

	}

	public void setCustomer(CustomerVO vo) {
		cb.getSelectionModel().select(vo.getName());
		;

	}

	public void setSize(int x, int y, int h, int w) {
		this.setLayoutX(x);
		this.setLayoutY(y);

		cb.setMaxHeight(h);
		cb.setMinHeight(h);
		cb.setMaxWidth(w);
		cb.setMinWidth(w);
		this.setMaxHeight(h);
		this.setMinHeight(h);
		this.setMaxWidth(w);
		this.setMinWidth(w);
	}

	private void makeUI() {
		ObservableList<String> options = FXCollections.observableArrayList(cusNameList);
		cb = new ComboBox<String>(options);
		cb.getSelectionModel().select(null); // [0, options.size())
		cb.setLayoutX(0);
		cb.setLayoutY(0);
		cb.setMinSize(130, 15);
		// cb.getSelectionModel().selectedItemProperty().addListener(new
		// ChangeListener() {
		// @Override
		// public void changed(ObservableValue observable, Object oldValue, Object
		// newValue) {
		//
		// }
		// });
		this.getChildren().add(cb);
	}
}
