package utility;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SLog {
   

    public static void wr(String f) {
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd    HH:mm:ss");//设置日期格式

        try {
        	 String filePath = "D:\\Log.txt";
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append("");
            
            bw.write(    	df.format(new Date()));// 往已有的文件上添加字符串
            bw.write("       ");
            bw.write(f+"\r\n");
            bw.close();
            fw.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

   
}
