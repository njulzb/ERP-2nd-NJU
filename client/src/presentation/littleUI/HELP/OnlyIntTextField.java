package presentation.littleUI.HELP;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class OnlyIntTextField extends TextField {
	private OnlyIntTextField me = this;
	public int value = 0;
	String lastValue="";
	public OnlyIntTextField() {
		make();
	}

	public OnlyIntTextField(String a) {
		super(a);
		
		
		make();
		me.setText(a);
		value=Integer.valueOf(a);
	}

	private void make() {
		this.setText("");
		
		
		this.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue,
					String newValue) {
				boolean isInt = false;
				int inn = 0;

				try {
					inn = Integer.valueOf(newValue.trim());
					if(inn>=0&&inn<100000000) {
						isInt= true;
					}
					
				} catch (Exception e) {
					isInt = false;
				}
				
				if(newValue==""||newValue==null||newValue.length()==0) {
					value =0;
					me.setText("01");
				}
				else if(!isInt) {
					me.setText(oldValue);
				}
				else {
					value =inn;
				}
			}
		});
	}
}
