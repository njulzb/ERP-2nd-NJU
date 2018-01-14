package BL.userBL.unused;

import java.io.File;
import java.io.IOException;

public class TestFormkdirs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File("c:\\Users\\lzb\\Desktop\\userhead\\test.txt");
		if (!file.exists()) {
			try {
				file.mkdirs();
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
