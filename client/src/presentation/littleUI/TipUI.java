package presentation.littleUI;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 * JavaFxȷ�ϵ�����
 * @author clzhu 2014/12/15
 *
 */
public class TipUI {
	protected static String Path ;
    public enum Response {
        NO, YES, CANCEL
    };

    public static Response buttonSelected = Response.CANCEL;

    private static ImageView icon = new ImageView();

    static class Dialog extends Stage {
        public Dialog(String title, Stage owner, Scene scene) {
        	  initPath();
            setTitle(title);
            initStyle(StageStyle.UTILITY);
            initModality(Modality.APPLICATION_MODAL);
            initOwner(owner);
            setResizable(false);
            setScene(scene);
//            icon.setImage(new Image("file:"+Path+"default\\error.png"));
        }
//      public Dialog(String title, Stage owner, Scene scene, String iconFile) {
//          setTitle(title);
//          initStyle(StageStyle.UTILITY);
//          initModality(Modality.APPLICATION_MODAL);
//          initOwner(owner);
//          setResizable(false);
//          setScene(scene);
//          icon.setImage(new Image(getClass().getResourceAsStream(iconFile)));
//      }
        public void showDialog() {
        	 initPath();
            sizeToScene();
            centerOnScreen();
            showAndWait();
        }
    }

    static class Message extends Text {

        public Message(String msg) {
            super(msg);
            setWrappingWidth(250);
        }
    }

    public static Response showConfirmDialog(Stage owner, String message,String title) {
    	  initPath();
    	VBox vb = new VBox();
        Scene scene = new Scene(vb);
        final Dialog dial = new Dialog(title, owner, scene);
        vb.setPadding(new Insets(10, 10, 10, 10));
        vb.setSpacing(10);
        Button yesButton = new Button("确认");
        yesButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                dial.close();
                buttonSelected = Response.YES;
            }
        });
        Button noButton = new Button("取消");
        noButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                dial.close();
                buttonSelected = Response.NO;
            }
        });
        BorderPane bp = new BorderPane();
        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(10);
        buttons.getChildren().addAll(yesButton, noButton);
        bp.setCenter(buttons);
        HBox msg = new HBox();
        msg.setSpacing(5);
        msg.getChildren().addAll(icon,new Message(message));
        vb.getChildren().addAll(msg, bp);
        dial.showDialog();
        return buttonSelected;
    }

    public static void showMessageDialog(Stage owner, String message,String title) {
    	  initPath();
        showMessageDialog(owner, new Message(message), title);
    }
    //����ʶ��html���
    public static void showWebViewDialog(Stage owner,String text_,String title){
    	  initPath();
        VBox vb = new VBox();
        Scene scene = new Scene(vb);
        final Dialog dial = new Dialog(title, owner, scene);
        vb.setPadding(new Insets(10, 10, 10, 10));
        vb.setSpacing(10);
        Button okButton = new Button("OK");
        okButton.setAlignment(Pos.CENTER);
        okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                dial.close();
            }
        });
        BorderPane bp = new BorderPane();
        bp.setCenter(okButton);
        HBox msg = new HBox();
        msg.setSpacing(5);
        WebView webview = new WebView();
        WebEngine engine = webview.getEngine();
        engine.loadContent(text_);
        msg.getChildren().addAll(icon, webview);
        vb.getChildren().addAll(msg, bp);
        dial.setMinHeight(150);
        dial.setMaxHeight(150);
        dial.setHeight(150);
        dial.showDialog();

    }
    public static void showMessageDialog(Stage owner, Node message, String title) {
       initPath();
    	VBox vb = new VBox();
        Scene scene = new Scene(vb);
        final Dialog dial = new Dialog(title, owner, scene);
        vb.setPadding(new Insets(10, 10, 10, 10));
        vb.setSpacing(10);
        Button okButton = new Button("确认");
        okButton.setAlignment(Pos.CENTER);
        okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                dial.close();
            }
        });
        BorderPane bp = new BorderPane();
        bp.setCenter(okButton);
        HBox msg = new HBox();
        msg.setSpacing(5);
        msg.getChildren().addAll(icon, message);
        vb.getChildren().addAll(msg, bp);
        dial.showDialog();
    }



    public static void initPath() {
    	try {
			Path =new File("").getCanonicalPath()+"\\img\\";
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    }
}