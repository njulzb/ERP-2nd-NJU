package presentation.littleUI.HELP;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class LengthLimitTextField extends TextField {
	private LengthLimitTextField me =this;
	public String value="";
	public int length=0;
	
	
	public LengthLimitTextField() {
		make();
	}
	public LengthLimitTextField(int length) {
		this.length=length;
		make();
	}
	public LengthLimitTextField(String a) {
		super(a);
		make();
		me.setText(a);
	}	
	public LengthLimitTextField(String a,int length) {
		super(a);
		this.length=length;
		make();
		me.setText(a);
	}	
	
	private void make() {
		this.setText("");
	
		this.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue,
					String newValue) {
				if(newValue.length()>length) {
					me.setText(oldValue);
					
				}
				else {
					value=newValue;
					me.setText(newValue);
				}
				
			}
		});
	}
}
