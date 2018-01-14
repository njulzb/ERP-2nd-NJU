package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteHelper {

	public static byte[] imageToByte(String filePath)  {


		if (filePath==null) {
			return null;
		}


		byte[] result = null;

		File file = new File(filePath);

		if (!file.exists() && file.isDirectory()) {
			file.mkdirs();
		}


		try {
			FileInputStream fis = new FileInputStream(file);
			result = new byte[fis.available()];
			fis.read(result);
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}






		return result;
	}

	public static boolean byteToImage(byte[] array,String imagePath) {

		if (array==null) {
			return false;
		}





		File file = new File(imagePath);

		if (!file.exists() && file.isDirectory()) {
			file.mkdirs();
		}

		
		
		try {
//			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(array);

			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			System.out.println("file not found while ByteToImage");
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("wrong while write the byte array into file");
			return false;
		}



		return true;
	}


}
