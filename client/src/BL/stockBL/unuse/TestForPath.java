package BL.stockBL.unuse;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestForPath {

	public void run() throws IOException {
		
		String filePath = this.getClass().getResource("/").getPath();
		String path = filePath + "/tempImage/test.txt";  
		File file = new File(path);
		System.out.println(file.getAbsolutePath());

		FileWriter w = new FileWriter(file);
		w.append("as");
		w.flush();
		w.close();
		
	}
	
	public static void main(String[] args) throws Exception {
		new TestForPath().run();
	}

}
