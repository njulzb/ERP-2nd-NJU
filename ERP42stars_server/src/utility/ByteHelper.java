package utility;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ByteHelper {

	public static byte[] ObjectToByte(Object obj) {
		
		byte[] byteArray = null;
		
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(arrayOutputStream);
			objectOutputStream.writeObject(obj);
			objectOutputStream.flush();
			
			byteArray = arrayOutputStream.toByteArray();
			
			objectOutputStream.close();
			arrayOutputStream.close();
			
			return byteArray;
			
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		
		return null;
	}
	
	public static Object ByteToObject(byte[] array) {
		
		Object obj = null;
		
		try {
			ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(array);
			ObjectInputStream objectInputStream = new ObjectInputStream(arrayInputStream);
			
			obj = objectInputStream.readObject();
			
			arrayInputStream.close();
			objectInputStream.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return obj;
	}
	
	
	


	public static byte[] imageToByte(String filePath)  {
	
		if (filePath==null) {
			return null;
		}
		byte[] result = null;
		
		File file = new File(filePath);
		
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
		
		try {
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
