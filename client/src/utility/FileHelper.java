package utility;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHelper {
	 public static byte[] getBytes(String filePath){  
	        byte[] buffer = null;  
	        try {  
	            File file = new File(filePath);  
	            FileInputStream fis = new FileInputStream(file);  
	            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);  
	            byte[] b = new byte[1000];  
	            int n;  
	            while ((n = fis.read(b)) != -1) {  
	                bos.write(b, 0, n);  
	            }  
	            fis.close();  
	            bos.close();  
	            buffer = bos.toByteArray();  
	        } catch (FileNotFoundException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	        return buffer;  
	    }
	   
	 public  static void createFile(byte[] bfile, String filePath,String fileName) {  
	        BufferedOutputStream bos = null;  
	        FileOutputStream fos = null;  
	        File file = null;  
	        try {  
	            File dir = new File(filePath);  
	            if(!dir.exists()&&dir.isDirectory()){//判断文件目录是否存在  
	                dir.mkdirs();  
	            }  
	            file = new File(filePath+"\\"+fileName);  
	            fos = new FileOutputStream(file);  
	            bos = new BufferedOutputStream(fos);  
	            bos.write(bfile);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        } finally {  
	            if (bos != null) {  
	                try {  
	                    bos.close();  
	                } catch (IOException e1) {  
	                    e1.printStackTrace();  
	                }  
	            }  
	            if (fos != null) {  
	                try {  
	                    fos.close();  
	                } catch (IOException e1) {  
	                    e1.printStackTrace();  
	                }  
	            }  
	        }  
	    }  
	 
	 
	 
	 
	 
	 
	 
	  public static byte[] toByteArray (Object obj) {      
	        byte[] bytes = null;      
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();      
	        try {        
	            ObjectOutputStream oos = new ObjectOutputStream(bos);         
	            oos.writeObject(obj);        
	            oos.flush();         
	            bytes = bos.toByteArray ();      
	            oos.close();         
	            bos.close();        
	        } catch (IOException ex) {        
	            ex.printStackTrace();   
	        }      
	        return bytes;    
	    }   
	       
	    /**  
	     * 数组转对象  
	     * @param bytes  
	     * @return  
	     */  
	    public static  Object toObject (byte[] bytes) {      
	        Object obj = null;      
	        try {        
	            ByteArrayInputStream bis = new ByteArrayInputStream (bytes);        
	            ObjectInputStream ois = new ObjectInputStream (bis);        
	            obj = ois.readObject();      
	            ois.close();   
	            bis.close();   
	        } catch (IOException ex) {        
	            ex.printStackTrace();   
	        } catch (ClassNotFoundException ex) {        
	            ex.printStackTrace();   
	        }      
	        return obj;    
	    }   
	 
	 
	 
	 
	 
	 public static boolean isFile(String filePath) {
		 
		 if (null == filePath || "".equals(filePath)) {
			 return false;
		 }
		 
		 File file = new File(filePath);
		 return file.exists();
	 }
	 
	 
	 
	 
	 
	 
	 
	 
}
