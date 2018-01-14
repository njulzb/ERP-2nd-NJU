package presentation.littleUI.HELP;

import java.rmi.RemoteException;
import java.util.ArrayList;

import BL.accountBL.AccountController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import vo.AccountVO;

public class AccountSelectPane extends Pane {
	private AccountController controller = new AccountController();
	private ArrayList<AccountVO> accountList = new ArrayList<AccountVO>();
	private ArrayList<String> accountNameList = new ArrayList<String>();

	ComboBox<String> cb;

	public AccountSelectPane() {
		try {
			accountList = controller.getAccountList();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		for (AccountVO vo : accountList) {
			accountNameList.add(vo.getName());
		}
		makeUI();
	}

	public AccountVO getAccount() {

		int i = cb.getSelectionModel().getSelectedIndex();
		if (i != -1) {
			AccountVO out = (AccountVO) accountList.get(i);
			return out;
		} else {
			return null;
		}
	}

	public void setAccount(AccountVO vo) {
		cb.getSelectionModel().select(vo.getName());
	}

	public void setSize(int x, int y, int h, int w) {
		this.setLayoutX(x);
		this.setLayoutY(y);
		cb.setPrefSize(w, h);
		this.setPrefSize(w, h);
	}

	private void makeUI() {
		ObservableList<String> options = FXCollections.observableArrayList(accountNameList);
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
