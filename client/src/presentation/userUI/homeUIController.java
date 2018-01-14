package presentation.userUI;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.fxml.FXML;

import javafx.scene.text.Text;
import utility.RoleOfUser;
import vo.UserVO;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class homeUIController {
	@FXML
	private AnchorPane InfoPane;
	@FXML
	private ImageView photo;
	@FXML
	private Text loginTime;
	@FXML
	private Text loginStatus;
	@FXML
	private Text name;
	@FXML
	private Text work;
	@FXML
	private Text id;
	@FXML
	private Text ability;
	@FXML
	private Text abilityTitle;

	String getFolderPath() {
		File directory = new File("");// 璁惧畾涓哄綋鍓嶆枃浠跺す
		String folderPath = "";
		try {
			folderPath = directory.getCanonicalPath();

		} catch (Exception e) {
		}
		return folderPath;
	}

//初始化
	public void init(UserVO user) {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
		String time = dateFormat.format( now );
		//System.out.println(hehe);
		loginTime.setText(time);

		if (user!=null){
			work.setText(user.getRole().toString());
			loginStatus.setText(user.getRole().toString());
			id.setText(user.getID());
			name.setText(user.getName());

			if (user.getRole().equals(RoleOfUser.SaleManager)){
				ability.setText("¥5000");
			}else{
				if (user.getRole().equals(RoleOfUser.saler)){
					ability.setText("¥1000");
				}else{
					ability.setVisible(false);
					abilityTitle.setVisible(false);
				}
			}

			if (user.getImagePath()!=null){
				String imgPath = user.getImagePath() ;
				Image imagePush = new Image("file:" + imgPath);
				photo.setImage(imagePush);
			}else{
				Image noneImg = new Image("file:" +getFolderPath()+"/img/default/test.png");
				photo.setImage(noneImg);
			}
		}else{
			loginStatus.setText("admin");
			work.setText("admin");
			id.setText("admin");
			name.setText("admin");

			ability.setVisible(false);
			abilityTitle.setVisible(false);
		}

	}
}
