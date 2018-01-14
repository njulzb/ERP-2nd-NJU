package presentation.mainUI;

import presentation.userUI.*;
import presentation.userUI.FinancialManager.FinancialUIController;
import presentation.userUI.GeneralManager.GeneralUIController;
import presentation.userUI.Operator.OperatorUIController;
import presentation.userUI.SaleManager.SaleUIController;
import presentation.userUI.StoreManager.StoreUIController;
import utility.RoleOfUser;
import vo.UserVO;

import java.io.IOException;


import javafx.application.Application;

import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UIController extends Application {
	static UIController present = new UIController();
	LoginApplication loginUI ;
	static Stage stage ;
	UserVO defaultuser;

	public static Stage getUIStage(){
		return stage;
	}

	public static UIController getUIController(){
		return present;
	}
//运行主界面
	public void runMainUI(UserVO user) throws IOException {
	// TODO Auto-generated method stub
		//ObservableList<Stage> stage = FXRobotHelper.getStages();
		//stage.get(0).close();
		defaultuser=user;
		if (user.getRole()==RoleOfUser.FinancialManager){
			FinancialUIController financialContro = FinancialUIController.getFinancialUIController();
			financialContro.setUser(user);
			financialContro.runNewStage("homeButton",null);
		}
		if (user.getRole()==RoleOfUser.GeneralManager){
			GeneralUIController generallContro = GeneralUIController.getGeneralUIController();
			generallContro.setUser(user);
			generallContro.runNewStage("homeButton");
		}
		if (user.getRole()==RoleOfUser.SaleManager || user.getRole()==RoleOfUser.saler){
			SaleUIController saleContro = SaleUIController.getSaleUIController();
			saleContro.setUser(user);
			saleContro.runNewStage("homeButton");
		}
		if (user.getRole()==RoleOfUser.StoreManager){
			StoreUIController storeContro = StoreUIController.getStoreUIController();
			storeContro.setUser(user);
			storeContro.runNewStage("homeButton",null);

		}
	}
//运行账户管理界面
	public void runOperatorUI() throws IOException {
		OperatorUIController.getOperatorUIController().runNewStage("homeButton");
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		loginUI = new LoginApplication();
		stage = new Stage();
		try {
			stage.initStyle(StageStyle.TRANSPARENT);
			loginUI.start(stage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[]args) {
        launch(args);
    }

	public void exit(){
		System.exit(0);
	}

	public void logout() throws Exception{
		stage.close();
		present.start(new Stage());

	}

}

