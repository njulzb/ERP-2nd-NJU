package presentation.littleUI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class OnlyDoubleTF extends TextField {
	
	public double value=0 ;
	
	private OnlyDoubleTF me =this;
	private String old ="";
	public OnlyDoubleTF(String a) {
		super(a);
		this.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue,
					String newValue) {
				boolean isDouble = false;
				double inn = 0;

				try {
					inn = Double.valueOf(newValue.trim());
					isDouble = true;
				} catch (Exception e) {
					isDouble = false;
				}
				
				if(newValue==""||newValue==null||newValue.length()==0) {
					value =0;
				}
				else if(isDouble) {
					value =inn;
				}
				else {
					me.setText(oldValue);
				}
			}
		});
		
		
		
		
		
	}
	
	
}
